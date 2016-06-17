Array.prototype.remove = function(dx) {
	if (isNaN(dx) || dx > this.length) {
		return false;
	}
	for (var i = 0, n = 0; i < this.length; i++) {
		if (this[i] != this[dx]) {
			this[n++] = this[i]
		}
	}
	this.length -= 1
}

$(function() {
	var muiPreviewObj;
	var showError = true;
	//初始化
	var curUserId = null; //用户自身的环信名
	var talkInputId = "#newstalk_cont"; //聊天输入框的容器id
	var maxWidth = 200;
	var themUserInfo; //目标聊天对象
	var user; //用户自身对象
	var curChatUserId = ''; //目标聊天对象环信名
	var recorder = null; //录音对象
	var startTimestamp = null; //录音开始时间
	var stopTimestamp = null; //录音结束时间
	var MAX_SOUND_TIME = 60; //语音最长时间
	var MIN_SOUND_TIME = 800; //语音最短时间
	var recordCancel = false; //是否取消
	var player = null; //语音播放对象
	var playingMsg = null; //是否正在播放
	var Context = null; //安卓运行时环境
	var AudioManager = null; //安卓播放类
	var am = null; //安卓播放对象
	var ph; //图片保存转发控件
	var minPh; //小图保存转发控件
	mui.init({
		beforeback: function() {
			plus.webview.getWebviewById("news_letter.html").evalJS("newsTalkList.setCurrUser('')");
			saveDraft();
			return true;
		},
		gestureConfig: {
			tap: true, //默认为true
			doubletap: true, //默认为false
			longtap: true, //默认为false
			swipe: true, //默认为true
			drag: true, //默认为true
			hold: true, //默认为false，不监听
			release: true //默认为false，不监听
		}

	});

	mui.plusReady(function() {
		if (plus.os.name == "Android") {
			Context = plus.android.importClass("android.content.Context");
			AudioManager = plus.android.importClass("android.media.AudioManager");
			am = plus.android.runtimeMainActivity().getSystemService(Context.AUDIO_SERVICE);
		}
		plus.proximity.watchProximity(function(d) {
			if (d == 0) {
				if (player) {
					console.log("使用听筒");
					if (plus.os.name == "Android") {
						player.pause();
						am.setSpeakerphoneOn(false);
						am.setMode(AudioManager.MODE_IN_COMMUNICATION);
						am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_PLAY_SOUND);
						player.resume();
					}
					player.setRoute(plus.audio.ROUTE_EARPIECE);
				}
			} else {
				if (plus.os.name == "Android") {
					am.setSpeakerphoneOn(true);
					am.setMode(AudioManager.MODE_NORMAL);
				}
				if (player) {
					console.log("使用扬声器");
					player.setRoute(plus.audio.ROUTE_SPEAKER);
				}
			}
		}, function(e) {
			alert("Error: " + e.message);
		});
		initEvent();
		plus.webview.currentWebview().setStyle({
			softinputMode: "adjustResize"
		});
		var hx_info = plus.webview.currentWebview();
		window.addEventListener('_loadData', loadData);
		mui.trigger(window, "_loadData", {
			hx_u: hx_info.hx_u
		});
		/**
		 * 图片上弹框
		 */
		ph = $("body").picHandler({});
		minPh = $("body").picHandler({
			listenEl: "img[data-preview-src]"
		});
	});

	function loadData(event) {
		$("#news_talk_con").html("");
		curChatUserId = event.detail.hx_u;
		muiPreviewObj = mui.previewImage();
		initUser();
		showDraft();
		beginshowLocalMsgTimer();
	}

	var firstShowMsg;

	function beginshowLocalMsgTimer() {
		firstShowMsg = true;
		setInterval(function() {
			showLocalMsg();
		}, 1000)
	}

	/**
	 * 显示草稿
	 */
	function showDraft() {
		var msgStorage = localStorage.getItem("msg_storage_" + user.id);
		if (!msgStorage) {
			msgStorage = {};
		} else {
			msgStorage = JSON.parse(msgStorage);
		}
		var draftStorage = msgStorage["draft_" + curChatUserId];
		if (draftStorage) {
			$("#newstalk_cont").val(draftStorage);
			$(".mine_talk_btn2").show();
			$(".mine_talk_btntalk").hide();
		}
	}

	/**
	 * 保存草稿
	 */
	function saveDraft() {
		var draft = $("#newstalk_cont").val();
		var msgStorage = localStorage.getItem("msg_storage_" + user.id);
		if (!msgStorage) {
			msgStorage = {};
		} else {
			msgStorage = JSON.parse(msgStorage);
		}
		var draftStorage = msgStorage["draft_" + curChatUserId];
		draftStorage = "";
		if (draft) {
			draftStorage = draft;
		}
		msgStorage["draft_" + curChatUserId] = draftStorage;
		localStorage.setItem("msg_storage_" + user.id, JSON.stringify(msgStorage));
	}

	/**
	 * 初始化事件
	 */
	function initEvent() {
		// 用户侧滑返回时关闭显示的图片
		plus.webview.currentWebview().addEventListener("popGesture", function(e) {
			if (e.type == "start") {
				closeImg();
			}
		}, false);
		//点击发送消息的方法
		$("#mine_talk_btn2").on('tap', function() {
			sendText();
		});

		//聊天输入框有内容显示发送按钮，无内容显示图片添加按钮
		$("#newstalk_cont").on("keyup", function() {
			if ($(this).val() == "" || $(this).val() == null) {
				$(".mine_talk_btntalk").show();
				$(".mine_talk_btn2").hide();
			} else {
				$(".mine_talk_btn2").show();
				$(".mine_talk_btntalk").hide();
			}
		});
		//点击语音按钮语音按钮和输入框消失，键盘按钮和按住说话出现
		$(".mine_talk_btntalk").on("tap", function() {
			$(".mine_talk_btntalk").hide();
			$(".newstalk_cont").hide();
			$(".news_talk_func").show();
			$(".mine_talk_btnkey").show();
		});
		//点击键盘按钮键盘按钮和按住说话消失，语音按钮和输入框出现
		$(".mine_talk_btnkey").on("tap", function() {
			$(".mine_talk_btnkey").hide();
			$(".news_talk_func").hide();
			$(".mine_talk_btntalk").show();
			$(".newstalk_cont").show();
		});
		//点完发送按钮语音按钮出现
		$(".mine_talk_btn2").on("tap", function() {
			$(".mine_talk_btn2").hide();
			$(".mine_talk_btntalk").show();
		});

		window.addEventListener('resize', function() {
			document.getElementById("news_talk_con2").scrollTop = document.getElementById("news_talk_con2").scrollHeight;
		}, false);

		$(".mine_talk_btn1").on("tap", function() {
			//galleryImgs();
			$("#circle_out").addClass("add_photo");
		});

		$(".mui-content").on("tap", function() {
			$("#circle_out").removeClass("add_photo");
		});

		$(".close_photo").on("tap", function() {
			$("#circle_out").removeClass("add_photo");
		});
		/**
		 * 从相册选择
		 */
		$("#selectPhoto").on("tap", function() {
			galleryImgs();
			$("#circle_out").removeClass("add_photo");
		});
		/**
		 * 拍照
		 */
		$("#photograph").on("tap", function() {
			getImage();
			$("#circle_out").removeClass("add_photo");
		});

		$("body").on("tap", ".head_img_you", function() {
			openWindowFull('climb_cirle_he.html', {
				fid: themUserInfo.id,
				friends: "frimap",
				fImName: themUserInfo.imUsername
			});
		});

		$("body").on("tap", ".head_img_me", function() {
			openWindowFull('climb_cirle_he.html', {
				fid: user.id,
				friends: "frimap"
			});
		});

		/**
		 * 录音功能
		 */
		document.querySelector("#source_btn").addEventListener("hold", function(e) {
			$(".sound_icon").show();
			$(".sound_num").hide();
			$(".sound_num").text("10");
			$(this).addClass("talk_func_btn");
			recordCancel = false;
			$(".sound_icon").removeClass("r-sigh_cancel");
			$("#audio_tips").html("手指上滑，取消发送");
			$("#sound-alert").removeClass('rprogress-sigh');
			setSoundAlertVisable(true);

			recorder = plus.audio.getRecorder();
			if (recorder == null) {
				mui.toast("不能获取录音对象");
				return;
			}
			startTimestamp = (new Date()).getTime();
			startVoiceTimer();
			recorder.record({
				filename: "_doc/audio/",
				format: "amr"
			}, function(path) {
				if (recordCancel) return;
				var voiceDuration = (stopTimestamp - startTimestamp) / 1000;
				sendVoice(path, voiceDuration);
				startTimestamp = null;
			}, function(e) {
				mui.toast("录音时出现异常: " + e.message);
			});
		});

		/**
		 * 手指滑动事件
		 */
		document.querySelector("footer").addEventListener('drag', function(event) {
			console.log("滑动" + Math.abs(event.detail.deltaY))
			if (Math.abs(event.detail.deltaY) > 50) {
				if (!recordCancel) {
					recordCancel = true;
					if (!$("#audio_tips").hasClass("cancel")) {
						$("#audio_tips").addClass("cancel");
					}
					if (!$(".sound_icon").hasClass("r-sigh_cancel")) {
						$(".sound_icon").addClass("r-sigh_cancel");
					}
					$("#audio_tips").html("松开手指，取消发送");
				}
			} else {
				if (recordCancel) {
					recordCancel = false;
					if ($("#audio_tips").hasClass("cancel")) {
						$("#audio_tips").removeClass("cancel");
					}
					if ($(".sound_icon").hasClass("r-sigh_cancel")) {
						$(".sound_icon").removeClass("r-sigh_cancel");
					}
					$("#audio_tips").html("手指上划，取消发送");
				}
			}
		}, false);

		/**
		 * 手指抬起
		 */
		document.querySelector('#source_btn').addEventListener("release", function(e) {
			stopVoice();
		});

		/**
		 * 播放录音
		 */
		$("body").on("tap", ".voice_msg", function(e) {
			if (playingMsg) {
				//有正在播放的
				if (player) {
					player.stop();
					player = null;
					$(playingMsg).removeClass('voice_msg_talking');
					if ($(this).attr("msg-content") == $(playingMsg).attr("msg-content"))
						return;
				}
			}
			playingMsg = $(this);
			listenVoice(playingMsg);
			if (playingMsg) {
				var audioPath = playingMsg.attr("msg-content");
				player = plus.audio.createPlayer(audioPath);
				$(playingMsg).addClass('voice_msg_talking');
				player.play(function() {
					$(playingMsg).removeClass('voice_msg_talking');
					player = null;
				}, function(e) {
					$(playingMsg).removeClass('voice_msg_talking');
					player = null;
				});
			}
		})

	}

	function listenVoice(el) {
		var el = $(el);
		var audioPath = el.attr("msg-content");
		el.parent("em").prev().removeClass("em_right_new");
		var msgStorage = localStorage.getItem("msg_storage_" + user.id);
		if (!msgStorage) {
			firstShowMsg = false;
			return;
		}
		msgStorage = JSON.parse(msgStorage);
		var msgList = msgStorage[curChatUserId];
		$.each(msgList, function(i, o) {
			if (o.msg.type == 2) {
				if (o.msg.msg.src == audioPath) {
					o.msg.msg.isListen = true;
					msgList[i] = o;
				}
			}
		});
		msgStorage[curChatUserId] = msgList;
		localStorage.setItem("msg_storage_" + user.id, JSON.stringify(msgStorage));
	}

	var voiceTimer = null;
	/**
	 * 停止录音
	 */
	function stopVoice() {
		$("#source_btn").removeClass("talk_func_btn");
		if ($("#audio_tips").hasClass("cancel")) {
			$("#audio_tips").removeClass("cancel");
		}
		$("#audio_tips").html("手指上滑，取消发送");

		setSoundAlertVisable(false);
		$("#sound-alert").addClass('rprogress-sigh');
		stopTimestamp = (new Date()).getTime();
		if (stopTimestamp - startTimestamp < MIN_SOUND_TIME) {
			mui.toast("录音时间太短");
			recordCancel = true;
		}
		clearInterval(voiceTimer);
		recorder.stop();
	}
	/**
	 * 开始录音
	 */
	function startVoiceTimer() {
		voiceTimer = setInterval(function() {
			var nowTimestamp = (new Date()).getTime();
			nowTimestamp = nowTimestamp - startTimestamp;
			if (nowTimestamp / 1000 >= MAX_SOUND_TIME - 10) {
				restTime = MAX_SOUND_TIME - parseInt(nowTimestamp / 1000);
				$(".sound_icon").hide();
				$(".sound_num").show();
				$(".sound_num").text(restTime);
			}
			if (nowTimestamp / 1000 >= MAX_SOUND_TIME) {
				stopVoice();
				clearInterval(voiceTimer);
			}
		}, 1000);

	}

	/**
	 * 显示/隐藏语音提示框
	 * @param {Object} show
	 */
	function setSoundAlertVisable(show) {
		if (show) {
			setTimeout(function() {
				$("#sound_alert").show();
			}, 200);

		} else {
			setTimeout(function() {
				$("#sound_alert").hide();
			}, 200);
		}
	};

	/**
	 * 初始化用户
	 */
	function initUser() {
		//设置当前用户
		user = Dcp.getUser();
		//设置当前用户id
		curUserId = user.imUsername;
		//修改当前用户头像
		$(".talk_con_me").find(".talk_con_metx").attr("src", Dcp.getImgUri() + user.imagePath)
			//查询对方用户
		var url = "/memberuser/queryUserByImName";
		var params = {
			imUserName: curChatUserId
		};
		Dcp.ajaxUtil.asyncPost(url, params, function(resp) {
			if (resp) {
				if (resp.code == 0) {
					themUserInfo = resp.data;
					//修改标题为对方昵称
					$("#title").empty().append(themUserInfo.nickName);
					//修改对方头像
					$(".talk_con_you").find(".talk_con_tx").attr("src", Dcp.getImgUri() + themUserInfo.imagePath);
				} else {
					if (showError)
						mui.toast(resp.msg);
					showError = false;

				}
			}
		});
	}

	var lastDate;
	/**
	 * 显示本地存储的消息 , 不传值就是全部显示
	 * @param {Object} beginIndex 从倒数第几条消息开始(数组中的结束位置)
	 * @param {Object} endInedx 到倒数第几条结束(数组中的开始位置)
	 */
	function showLocalMsg(beginIndex, endInedx) {
		var msgStorage = localStorage.getItem("msg_storage_" + user.id);
		if (!msgStorage) {
			firstShowMsg = false;
			return;
		}
		msgStorage = JSON.parse(msgStorage);
		var msgList = msgStorage[curChatUserId];
		if (!msgList) {
			firstShowMsg = false;
			return;
		}
		if (beginIndex) {
			beginIndex = msgList.length - beginIndex < 0 ? msgList.length : msgList.length - beginIndex;
		} else {
			beginIndex = msgList.length;
		}
		if (endInedx) {
			endInedx = msgList.length - endInedx;
		} else {
			endInedx = msgList.length - 20;
		}
		$.each(msgList, function(i, msgObj) {
			if (!lastDate) {
				lastDate = "2016-04-21T05:46:24.780Z";
			}
			if (i >= endInedx && i < beginIndex) {
				var tempDate = msgObj.dateTime;
				if (firstShowMsg || !msgObj.isReaded) {
					if (Dcp.compareDateMinute(new Date(lastDate), new Date(tempDate)) >= 1) {
						var dateMsg = Dcp.TimeStampFormat(tempDate, "MM月dd日 hh:mm")
						if (Dcp.compareDate(new Date(lastDate), new Date(tempDate)) >= 1) {
							dateMsg = Dcp.TimeStampFormat(tempDate, "yyyy年MM月dd日 hh:mm");
						}
						lastDate = tempDate;
						appendMsg(null, dateMsg, "date");
					}
					appendMsg(msgObj.who, msgObj.msg);
					msgObj.isReaded = true;
					msgList[i] = msgObj;
					msgStorage[curChatUserId] = msgList;
					localStorage.setItem("msg_storage_" + user.id, JSON.stringify(msgStorage));
				}
			}

		});
		firstShowMsg = false;
	}

	var pics = [];
	var choosedPic = 0; //选择的图片数量,每次sendPic之后都会回复为0
	function appendFile(p) {
		pics.push({
			name: "uploadkey" + pics.length, //这个值服务器会用到，作为file的key 
			path: p
		});
		if (pics.length >= choosedPic) {
			//选择的图片已经全部压缩完毕
			sendPic(pics);
		}
	}

	/**
	 * 拍照
	 * @param {Object} maxWidth
	 */
	function getImage(maxWidth) {
		maxWidth = maxWidth || 1000;
		$(".circle_out").removeClass("add_photo");
		var cmr = plus.camera.getCamera();
		cmr.captureImage(function(p) {
			plus.io.resolveLocalFileSystemURL(p, function(entry) {
				var localurl = entry.toLocalURL();
				compressImage(localurl);
			})
		});
	};
	/**
	 * 从相册选择照片
	 */
	function galleryImgs() {
		// 从相册中选择图片
		console.log("从相册中选择多张图片");
		//	outSet("从相册中选择多张图片:");
		plus.gallery.pick(function(e) {
			choosedPic = e.files.length;
			for (var i in e.files) {
				compressImage(e.files[i]);
			}
		}, function(e) {}, {
			filter: "image",
			multiple: true,
			system: false,
			maximum: 9,
			onmaxed: function() {
				plus.nativeUI.alert('主人,最多只能选择9张图片哦!');
			}
		});
	}
	//压缩图片
	function compressImage(mSrc) {
		console.log("压缩图片");
		console.log(mSrc);
		if (0 != mSrc.toString().indexOf("file://")) {
			mSrc = "file://" + mSrc;
		}
		var _div_ = document.getElementById("_div_");
		var _img_ = new Image();
		_img_.src = mSrc;
		_img_.onload = function() {
			var tHeight = _img_.height;
			var tWidth = _img_.width;
			_img_.onload = null;
			var h_pro = 100.00;
			var w_pro = 100.00;
			var max = tHeight > tWidth ? tHeight : tWidth;
			if (max > 1000 && tHeight > tWidth) {
				h_pro = 1000 / tHeight * 100;
				w_pro = 1000 / tHeight * 100;
			} else if (max > 1000 && tWidth > tHeight) {
				h_pro = 1000 / tWidth * 100;
				w_pro = 1000 / tWidth * 100;
			}
			h_pro = h_pro + "%";
			w_pro = w_pro + "%";
			//存储路径
			var mDst = "_doc/tmp/" + (new Date()).valueOf() + getUuid() + ".jpg"
			console.log(mDst);
			plus.zip.compressImage({
					src: mSrc,
					dst: mDst,
					width: w_pro,
					height: h_pro,
					quality: 90,
					overwrite: true
				},
				function(event) {
					console.log("开始添加页面图片")
					console.log(event.target);
					console.log(event.target);
					appendFile(event.target);
				},
				function(error) {
					console.log("出错了");
				});
		}
		_div_.appendChild(_img_);
	}

	// 产生一个随机数
	function getUuid() {
		return Math.floor(Math.random() * 100000000 + 10000000).toString();
	}

	/**
	 * 发送图片
	 * @param {Object} imgSrc
	 */
	function sendPic(picFiles) {
		var to = curChatUserId;
		if (to == null) {
			pics = [];
			choosedPic = 0;
			return;
		}
		$.each(pics, function(i, pic) {
			plus.webview.getWebviewById("news_letter.html").evalJS("newsTalkList.sendPicToOther('" + themUserInfo.id + "','" + pic.path + "')");
			var msg = {
				type: 1,
				msg: {
					src: pic.path
				}
			}
			appendMsg(curUserId, msg);
		});
		pics = [];
		choosedPic = 0;
	};

	/**
	 * 发送语音
	 * @param {Object} voicePath
	 */
	function sendVoice(voicePath, voiceDuration) {
		var duration = Math.round(voiceDuration);
		if (duration < 1) duration = 1;
		if (duration > 60) duration = 60;
		plus.webview.getWebviewById("news_letter.html").evalJS("newsTalkList.sendVoiceToOther('" + themUserInfo.id + "','" + voicePath + "','" + duration + "')");
		var msg = {
			type: 2,
			msg: {
				src: voicePath,
				duration: duration
			}
		}
		appendMsg(curUserId, msg);
	};

	/**
	 * 发送文本消息
	 */
	var sendText = function() {
		var msg = $(talkInputId).val();
		if (msg == null || msg.length == 0) {
			return;
		}
		plus.webview.getWebviewById("news_letter.html").evalJS("newsTalkList.sendTextToOther('" + themUserInfo.id + "','" + msg + "')");
		var msg = {
			type: 0,
			msg: msg
		}
		appendMsg(curUserId, msg);
		$(talkInputId).val("");
	};

	function scrollPage() {
		mui.trigger(window, "resize");
	}

	//显示聊天记录的统一处理方法
	var appendMsg = function(who, message, chattype) {
		var localMsg = null;
		var lineDiv = $("#news_talk_con");
		var neirong = "";
		var lineDiv = $("#news_talk_con");
		if (chattype && chattype == "date") {
			timeEl = "<p class='talk_time_det font-size24'>" + message + "</p>";
			lineDiv.append(timeEl);
		} else {
			var bubbleW = null;
			var durationEl = null;
			var spanStyle = "";
			var arrowStyle = "";
			if (message.type == 0) {
				//文字
				neirong = message.msg;
			} else if (message.type == 1) {
				spanStyle = "padding:0;background-color: transparent;margin-right:5px;margin-left:5px;"
				arrowStyle = "display:none";
				//图片
				localMsg = message.msg.src;
				var eletext;
				if (who == curUserId) {
					//ta
					eletext = "<img src='" + localMsg + "' width='200' data-preview-src='" + localMsg + "' data-preview-group='" + localMsg + "' /><div class='talk_trend_left'></div>";
				} else {
					//wo
					eletext = "<img src='" + localMsg + "' width='200' data-preview-src='" + localMsg + "' data-preview-group='" + localMsg + "' /><div class='talk_trend_right'></div>";
				}

				neirong = eletext;
			} else if (message.type == 2) {
				//语音
				//根据时间计算宽度
				bubbleW = 1.76;
				message.msg.duration = message.msg.duration || 1;
				if (message.msg.duration > 1) {
					bubbleW = bubbleW + (message.msg.duration - 1) / 10;
				}
				if (bubbleW > 6.3) {
					bubbleW = 6.3;
				}
				bubbleW = bubbleW + "rem";
				var readClass = "";
				if (!message.msg.isListen) {
					readClass = " em_right_new";
				}
				if (who == curUserId) {
					durationEl = "<div class='em_left'>" + message.msg.duration + "\"</div>";
				} else {
					durationEl = "<div class='em_right " + readClass + "'>" + message.msg.duration + "\"</div>";
				}
				localMsg = message.msg.src;
				var eletext = "<div class='voice_msg' msg-content='" + localMsg + "' style='height:0.533333rem;" + (bubbleW == null ? "" : "width:" + bubbleW) + ";'  ></div>";
				neirong = eletext;
			}
			var strme = "<li class='talk_con_me font-size28'><div class='talk_con_metx'><img class='talk_con_tx head_img_me' src='' alt='' /></div><span style='" + spanStyle + "' class='talk_item_me news_talk_green talk_bubble' >" + (durationEl || '') + "<em>" + neirong + "</em><i style='" + arrowStyle + "' class='talk_arrow_me'></i></span></li>";
			var stryou = "<li class='talk_con_you font-size28'><div class='talk_con_youtx'><img class='talk_con_tx head_img_you' src='' alt='' /></div><span style='" + spanStyle + "' class='talk_item_you news_talk_gray talk_bubble' >" + (durationEl || '') + "<em>" + neirong + "</em><i style='" + arrowStyle + "' class='talk_arrow_you'></i></span></li>";
			if (who == curUserId) {
				lineDiv.append(strme);
				lineDiv.find("li:last-child").find(".talk_con_tx").attr("src", Dcp.getImgUri() + user.imagePath);
			} else if (who == curChatUserId) {
				lineDiv.append(stryou);
				lineDiv.find("li:last-child").find(".talk_con_tx").attr("src", Dcp.getImgUri() + (themUserInfo == null ? "" : themUserInfo.imagePath));
			}
		}
		scrollPage();
	};
})