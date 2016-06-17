var curr_talk_user = ""; //当前聊天对象

var newsTalkList = (function() {
	var hasLoad = false; //是否已经加载
	var conn; //环信连接对象
	var user; //登陆用户对象
	var noSendMsgs = []; //因环信未连接而未发送的聊天
	var noUploadMsgs = []; //因无法连接服务器而未发送的聊天记录
	var showError = true; //是否显示错误
	var hadShowRightLi = null; //是否显示删除按钮

	/**
	 * 左滑结束事件
	 */
	$('#add_news').on('slideleft', '.mui-table-view-cell', function(event) {
		var elem = this;
		hadShowRightLi = this;
	});

	$("body").on("tap", function(event) {
		closeRightBtn()
	});

	/**
	 * 删除聊天
	 */
	$("#add_news").on("tap", '.mui-btn', function(event) {
		var el = $(this);
		mui.confirm("主人,删除列表会丢失聊天记录,您确定继续吗?", "", ["取消", "继续"], function(e) {
			if (e.index == 0) {} else {
				removeTalker(el);
			}
		});

	})

	/**
	 * 初始化
	 */
	function init() {
		hasLoad = true;
		user = Dcp.getUser();
		if (!user) {
			hasLoad = false;
			return;
		}
		$("#add_news").empty();
		//		showMsgList();
		showMsgTimer();
		initConn();
		login();
		beginLoginTimer();
	}

	/**
	 * 断线重连解决方案
	 */
	function beginLoginTimer() {
		setInterval(function() {
			user = Dcp.getUser();
			if (!user) {
				return;
			}
			/**
			 * 因环信web-safari端无法收到消息bug,临时使用该方法收消息,当环信bug修复后不在使用!
			 * @author chenrui
			 * @date 2016-06-03 09:31:25
			 */
			if (mui.os.ios) {
				if (conn) {
					conn.close();
					setTimeout(function() {}, 3000);
					login();
				}
			} else {
				//处理断线重连

				if (conn.isOpened()) {
					return;
				} else {
					conn.close();
					setTimeout(function() {}, 3000);
					login();
				}
			}
		}, 3000);
	}

	/**
	 * 定时刷新聊天列表
	 */
	function showMsgTimer() {
		timer = setInterval(function() {
			showMsgList();
		}, 1000);
	}

	/**
	 * 显示消息列表
	 */
	var showMsgList = function() {
		user = Dcp.getUser();
		if (!user) {
			$("#add_news").empty();
			return;
		}
		var msgStorage = localStorage.getItem("msg_storage_" + user.id);
		if (!msgStorage) {
			return;
		}
		msgStorage = JSON.parse(msgStorage);
		$.each(msgStorage, function(i, msgList) {
			if (typeof msgList == "string") {
				return;
			}
			var draft = null;
			if (msgStorage["draft_" + i]) {
				draft = "[草稿] " + msgStorage["draft_" + i];
			}
			var lastIndex = msgList.length - 1;
			if (msgList[lastIndex].isReaded) {
				//如果最后一条消息读过了,那么就显示最后一条消息
				var showMsg = msgList[lastIndex].msg;
				if (draft) {
					showMsg = draft;
				}
				appendMsg(msgList[lastIndex].who, i, showMsg, null, false, null, msgList[lastIndex].dateTime);
			} else {
				var cishu = 0;
				var withWho;
				var msg;
				$.each(msgList, function(j, msgObj) {
					withWho = i;
					msg = msgObj;
					if (!msgObj.isReaded) {
						cishu++;
					}
				});
				var showMsg = msg.msg;
				if (draft) {
					showMsg = draft;
				}
				appendMsg(msg.who, i, showMsg, null, true, cishu, msg.dateTime);
			}
		});

	}

	/**
	 * 初始化连接
	 */
	function initConn() {
		conn = new Easemob.im.Connection();
		//初始化连接
		conn.init({
			"https": true,
			url: 'wss://im-api.easemob.com/ws/',
			wait: '80', //连接超时时间
			domain: 'easemob.com',
			//当连接成功时的回调方法
			onOpened: function() {
				console.log('连接成功！');
				conn.setPresence();
				sendNoSendMsgs();
			},
			//收到文本消息时的回调方法
			onTextMessage: function(message) {
				handleTextMessage(message);
			},
			onPictureMessage: function(message) {
				//不会受到图片消息
			},
			onReceivedMessage: function() {
				console.log('消息发送成功！');
			},
			onClosed: function() {
				handleClosed();
			},
			onError: function(e) {
				console.log("聊天异常" + e.type + ":" + e.msg);
				handleError(e);
			}
		});
	}

	/**
	 * 登陆
	 */
	function login() {
		user = Dcp.getUser();
		if (user) {
			conn.open({
				user: user.imUsername,
				pwd: user.imPassword,
				appKey: Dcp.getImAppKey()
			});
		}
	}

	//重新发送未发送的消息
	function sendNoSendMsgs() {

		if (noSendMsgs) {
			while (noSendMsgs.length > 0) {
				if (conn.isOpened()) {
					var msg = noSendMsgs.shift();
					console.log("发送未发送的消息" + JSON.stringify(msg));
					conn.sendTextMessage(msg);
				}
			}
		}

		if (noUploadMsgs) {
			while (noUploadMsgs.length > 0) {
				var msg = noUploadMsgs.shift();
				if (msg) {
					console.log("发送未上传的消息" + JSON.stringify(msg));
					var msgTo = msg.to; //接受者id
					var msgType = msg.type; //消息类型
					var msgContent = msg.content; //消息内容;文字消息是文字,语音图片是地址
					var msgDuration = msg.duration; //消息长度,只有语音有;
					switch (msgType) {
						case 0:
							//文本消息
							sendText(msgTo, msgContent);
							break;
						case 1:
							//图片消息
							sendPic(msgTo, msgContent);
							break;
						case 2:
							//语音消息
							sendVoice(msgTo, msgContent, msgDuration);
							break;
					}
				}
			}
		}
	}

	/**
	 * 收到文本消息处理
	 * @param {Object} message
	 */
	function handleTextMessage(message) {
		var from = message.from; //消息的发送者
		var mestype = message.type; //消息发送的类型是群组消息还是个人消息
		var messageContent = message.data; //文本消息体
		var msgObj = {};
		try {
			msgObj = JSON.parse(messageContent);
		} catch (e) {
			console.error("消息解析失败");
			return;
		}
		if (msgObj.type == undefined) {
			console.error("消息格式错误");
			return;
		}
		if (msgObj.type != 0) {
			var fileName = msgObj.msg.src.substring(msgObj.msg.src.lastIndexOf("/") + 1);
			var dtask = plus.downloader.createDownload(Dcp.getImgUri() + msgObj.msg.src, {
				filename: fileName
			}, function(d, status) {
				// 下载完成
				if (status == 200) {
					//图片和语音消息需要下载完后才存储
					msgObj.msg.src = d.filename;
					if (msgObj.type == 1) {
						//图片需要显示绝对路径
						msgObj.msg.src = plus.io.convertLocalFileSystemURL(d.filename);
					}
					storageMsg(from, from, msgObj);
				} else {
					mui.toast("Download failed: " + status);
				}
			});
			dtask.start();
		} else {
			storageMsg(from, from, msgObj);
		}

		messageBeep(from, messageContent);
	};

	//存储历史消息的方法
	var storageMsg = function(who, from, msg, isReaded) {
		isReaded = isReaded || false;
		var msgUuid = msg.uuid;
		var msgStorage = localStorage.getItem("msg_storage_" + user.id)
		if (!msgStorage) {
			msgStorage = {};
		} else {
			msgStorage = JSON.parse(msgStorage);
		}
		var msgList = msgStorage[who];
		try {
			$.each(msgList, function(i, o) {
				if (o.uuid == msgUuid) {
					throw 'repeated msg';
				}
			});
		} catch (e) {
			//重复消息,不存储
			if (e == 'repeated msg') {
				console.log("重复消息,不存储");
				return;
			}
		}
		var msgObj = {};
		if (!msgList || msgList < 1) {
			msgList = [];
		}
		msgObj.who = from;
		msgObj.msg = msg;
		msgObj.uuid = msg.uuid;
		msgObj.dateTime = new Date();
		msgObj.isReaded = isReaded;
		msgList.push(msgObj);
		msgStorage[who] = msgList;
		localStorage.setItem("msg_storage_" + user.id, JSON.stringify(msgStorage));
	}

	/**
	 * 收到消息蜂鸣
	 * @param {Object} from
	 */
	var messageBeep = function(from, msg) {
		var userhx = from;
		if (from != curr_talk_user) {
			var url = "/memberuser/queryUserByImName";
			var params = {
				imUserName: from
			};
			Dcp.ajaxUtil.syncPost(url, params, function(resp) {
				if (resp) {
					if (resp.code == 0) {
						from = resp.data.nickName;
					} else {
						if (showError)
							mui.toast(resp.msg);
						shwoError = false;
					}
					var msgObj = {};
					try {
						msgObj = JSON.parse(msg);
					} catch (e) {
						console.error("消息解析失败");
						return;
					}
					if (msgObj.type != undefined) {
						if (msgObj.type == 1) {
							msg = "[图片]";
						} else if (msgObj.type == 2) {
							msg = "[语音]";
						} else {
							msg = msgObj.msg;
						}
						plus.webview.getWebviewById("tab-webview.html").evalJS("mui.toast('" + from + " : " + msg + "')");
						var voice = "none";
						alertConfig = Dcp.getLocalStorage("alertConfig");
						if (alertConfig) {
							alertConfig = JSON.parse(alertConfig);
						}
						var mssageConent = "您收到一条新消息";
						if (alertConfig) {
							if (alertConfig.messageaccept == 0) {
								//接受新消息
								if (alertConfig.messageshow == 0) {
									//显示消息内容 
									mssageConent = from + ":" + msg;
								}
								if (alertConfig.messagevibrate == 0) {
									//震动
									plus.device.vibrate();
								}
								if (alertConfig.messagevoice == 0) {
									if (alertConfig.messageopen == 0) {
										//时段静音开启
										var now = parseInt(Dcp.TimeStampFormat(new Date(), "hhmmss"));
										var dateStart = parseInt(Dcp.TimeStampFormat(new Date(alertConfig.messagestart), "hhmmss"));
										var dateEnd = parseInt(Dcp.TimeStampFormat(new Date(alertConfig.messageend), "hhmmss"));
										if (dateEnd < now && dateStart > now) {
											//在允许时段内 
											plus.ios.invoke(null, "AudioServicesPlaySystemSound", 1000);
											voice = "system";
										}
									} else {
										plus.ios.invoke(null, "AudioServicesPlaySystemSound", 1000);
										voice = "system";
									}
								}
							}
						}

						plus.push.createMessage(mssageConent, userhx, {
							"cover": true,
							"sound": voice
						});
					}
				}
			});
		}
	}

	/**
	 * 连接关闭处理方法
	 */
	function handleClosed() {
		console.log("连接关闭");
	}

	/**
	 * 连接异常处理方法
	 */
	function handleError(e) {
		if (e.type == 3) {
			setTimeout(function() {}, 3000);
			//			login();
		} else if (e.type == 6) {
			//重连异常
			conn.close();
			setTimeout(function() {}, 3000);
			login();
		}
	}

	/**
	 * 判断改环信用户是否已经添加到列表
	 * @param {Object} hxName
	 */
	function checkHasNotRead(hxName) {
		for (var j = 0; j < $(".hasNo_Readed").length; j++) {
			if ($(".hasNo_Readed").eq(j).attr("title") == hxName) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 显示聊天记录方法
	 * @param {Object} who 谁发送的
	 * @param {Object} contact 用于跳转聊天界面以及在列表页面查找li
	 * @param {Object} message 聊天内容
	 * @param {Object} chattype 聊天类型 此js中无用
	 * @param {Object} showcount 是否显示新消息标记
	 */
	function appendMsg(who, contact, message, chattype, showcount, cishu, datetime) {
		showcount = (showcount == null) ? true : showcount;
		var localMsg = null;
		var neirong = "";
		var contactDivId = contact;
		if (curr_talk_user != contact) {
			if (message.type == 0) {
				//文字
				message = message.msg;
			} else if (message.type == 1) {
				//图片
				message = "[图片]";
			} else if (message.type == 2) {
				message = "[语音]";
			}

			//判断已有未读消息列表里，没有聊天对象时返回true，有时返回false
			var weiMsg = $(".hasNo_Readed");
			if (checkHasNotRead(contact)) {
				console.log("创建新的聊天列表");
				var url = "/memberuser/queryUserByImName";
				var params = {
					imUserName: contact
				};
				Dcp.ajaxUtil.asyncPost(url, params, function(resp) {
					if (resp) {
						if (resp.code == 0) {
							var imagePath;
							var nickName;
							var count;
							imagePath = resp.data.imagePath;
							if (imagePath) {
								imagePath = Dcp.getImgUri() + imagePath;
							}
							nickName = resp.data.nickName;

							if (showcount) {
								count = '<span class="right font-size28 letter_add">1</span>';
							} else {
								count = '<span class="right font-size28 letter_add" style="display:none">0</span>';
							}
							if (message.length > 10)
								message = message.substring(0, 10).concat("......");
							var hasNot_ReadMsg = '<li class="mui-table-view-cell letterin hasNo_Readed" id="news_talk.html" title="' + contact + '" style="width: 100%;height: 100%;line-height: 21px;text-align: left;margin-top: 0;" >' +
								'<div class="mui-slider-right mui-disabled"><a class="mui-btn mui-btn-red" style="font-size:0.48rem;padding: 0 0.4rem">删除</a></div>' +
								'<div class="mui-slider-handle">' +
								'<div class="left letter_left"><img src="' + (imagePath || "../images/Climb_cirle/Climb_msg_01.jpg") + '"></div>' +
								'<div class="left letter_r"><ul><li class="left letter_r01"><h3 class="fosn-size30 left">' + (nickName || "神秘人") + '</h3><span class="right letter_time font-size28" >' + Dcp.TimeStampFormat(new Date(datetime), "hh:mm") + '</span></li><li class="left letter_r02"><p class="font-size28 left">' + message + '</p>' + count + '</li></ul></div>' +
								'</div>' +
								'</li>';
							$("#add_news").prepend(hasNot_ReadMsg);
						} else {
							if (showError)
								mui.toast(resp.msg);
							showError = false;
						}
					}
				});
			} else {
				if (showcount) {
					for (var i = 0; i < weiMsg.length; i++) {
						if (weiMsg.eq(i).attr("title") == contact) {
							if (message.length > 10)
								message = message.substring(0, 10).concat("......");
							weiMsg.eq(i).find(".letter_r02").find("p").html(message);
							weiMsg.eq(i).find(".letter_add").show().text(cishu);
							weiMsg.eq(i).find(".letter_time").text(Dcp.TimeStampFormat(new Date(datetime), "hh:mm"));
						}
						$("#add_news").prepend($("[title='" + contact + "']"));
					}
				} else {
					for (var i = 0; i < weiMsg.length; i++) {
						if (weiMsg.eq(i).attr("title") == contact) {
							if (message.length > 10)
								message = message.substring(0, 10).concat("......");
							weiMsg.eq(i).find(".letter_r02").find("p").html(message);
							weiMsg.eq(i).find(".letter_add").hide().text(cishu);
							weiMsg.eq(i).find(".letter_time").text(Dcp.TimeStampFormat(new Date(datetime), "hh:mm"));
						}
					}
				}
			}
		}
	}

	/**
	 * 添加因服务器无法连接而未发送的消息
	 * @param {Object} msgType
	 * @param {Object} msgContent
	 * @param {Object} msgDuration
	 */
	function addNoUploadMsgs(toUserId, msgType, msgContent, msgDuration) {
		console.log("添加未上传消息");
		var m = {
			to: toUserId,
			type: msgType,
			content: msgContent || '',
			duration: msgDuration || ''
		};
		noUploadMsgs.push(m);
	}

	/**
	 * 查询用户
	 * @param {Object} toUserId
	 * @param {Object} cb
	 */
	function findUserById(toUserId, cb, eb) {
		Dcp.ajaxUtil.asyncPost("memberuser/ajaxfinduserbyid", {
			id: toUserId
		}, function(resp) {
			if (resp) {
				cb(resp);
			} else {
				console.log("查询用户失败");
				eb();
			}
		}, function(e) {
			console.log("查询用户失败")
			eb();
		});
	}

	/**
	 * 发送消息
	 * @param {Object} toUserId 接收人的userid
	 * @param {Object} textMsg 文本消息内容
	 */
	function sendText(toUserId, textMsg) {
		findUserById(toUserId, function(resp) {
			sendMessage(0, resp.imUsername, textMsg);
		}, function() {
			addNoUploadMsgs(toUserId, 0, textMsg);
		});
	}

	/**
	 * 发送图片
	 * @param {Object} picSrc 图片路径 可以是网络路径可以是本地路径
	 */
	function sendPic(toUserId, picSrc) {
		findUserById(toUserId, function(resp) {
			if (picSrc.startsWith("http")) {
				//下载
				var dtask1 = plus.downloader.createDownload(picSrc, {}, function(d, status) {
					// 下载完成
					if (status == 200) {
						//图片需要显示绝对路径
						picSrc = plus.io.convertLocalFileSystemURL(d.filename);
						uploadFileThenSend(resp, 0, picSrc)
					} else {
						mui.toast("Download failed: " + status);
					}
				});
				dtask1.start();
			} else {
				uploadFileThenSend(resp, 0, picSrc);
			}
		}, function() {
			addNoUploadMsgs(toUserId, 1, picSrc);
		});
	};

	/**
	 * 发送语音
	 * @param {Object} toUserId 接受者的userid
	 * @param {Object} voicePath 语音路径
	 * @param {Object} voiceDuration
	 */
	function sendVoice(toUserId, voicePath, voiceDuration) {
		findUserById(toUserId, function(resp) {
			if (voicePath.startsWith("http")) {
				//下载
				var dtask1 = plus.downloader.createDownload(voicePath, {}, function(d, status) {
					// 下载完成
					if (status == 200) {
						voicePath = plus.io.convertLocalFileSystemURL(d.filename);
						uploadFileThenSend(resp, 1, voicePath, voiceDuration);
					} else {
						mui.toast("Download failed: " + status);
					}
				});
				dtask1.start();
			} else {
				voicePath = plus.io.convertLocalFileSystemURL(voicePath);
				uploadFileThenSend(resp, 1, voicePath, voiceDuration);
			}
		}, function() {
			addNoUploadMsgs(toUserId, 2, voicePath, voiceDuration);
		});
	};

	/**
	 * 上传并发送 
	 * @param {Object} to 发送给谁 接收者的user对象
	 * @param {Object} type 0:图片,1:语音
	 * @param {Object} src 路径必须是本地绝对路径
	 * @param {Object} duration 时长
	 */
	function uploadFileThenSend(to, type, src, duration) {
		var url = "imfiles/uploadFile";
		var params = {
			type: type,
			from: user.id,
			to: to.id
		};
		if (!src.startsWith("file://")) {
			src = "file://" + src;
		}
		var files = [{
			name: "uploadkey",
			path: src
		}];
		Dcp.ajaxUtil.uploadFile(url, params, files, function(resp) {
			if (resp) {
				if (resp.data) {
					$.each(resp.data, function(i, obj) {
						var msgType = type == 0 ? 1 : 2;
						if (duration)
							obj.duration = duration;
						obj.localPath = src;
						obj.isListen = false;
						sendMessage(msgType, to.imUsername, obj);
					});
					console.log("发送成功");
				}
			} else {
				console.log("发送图片失败")
			}
		}, function(e) {
			console.log("发送图片失败")
		});
	}

	/**
	 * 发送消息并存储到本地
	 * @param {Object} type 消息类型:0:文字,1:图片,2:语音
	 * @param {Object} to 接收人 接收人的环信用户名
	 * @param {Object} msg 消息内容,文字消息直接传文字,语音和图片传对象
	 */
	function sendMessage(type, to, msg) {
		var uuid = Dcp.getUuid();
		var msgObj = {
			type: type,
			msg: msg,
			uuid: uuid
		};
		var msgObjStr = JSON.stringify(msgObj);
		var options = {
			to: to,
			msg: msgObjStr,
			type: "chat"
		};
		if (conn.isOpened()) {
			conn.sendTextMessage(options);
		} else {
			console.log("发送失败保存到本地");
			noSendMsgs.push(options);
		}

		if (type != 0) {
			msgObj.msg.src = Dcp.getImgUri() + msgObj.msg.src;
		}
		//语音需要本地路径
		if (type == 2)
			msgObj.msg.src = msgObj.msg.localPath
		storageMsg(to, user.imUsername, msgObj, true);
	}

	/**
	 * 关闭删除按钮
	 */
	function closeRightBtn() {
		if (hadShowRightLi) {
			mui.swipeoutClose(hadShowRightLi);
			hadShowRightLi = null;
			return false;
		}
		return true;
	}

	/**
	 * 删除聊天
	 * @param {Object} el
	 */
	function removeTalker(el) {
		var li = el.parent().parent();
		var title = li.attr("title");
		removeMsg(title);
		$("[title=" + title + "]").remove("");

	}

	/**
	 * 删除聊天对象的聊天记录
	 * @param {Object} imUserName 用户环信名
	 */
	function removeMsg(imUserName) {
		var msgStorage = localStorage.getItem("msg_storage_" + user.id)
		if (!msgStorage) {
			return;
		}
		msgStorage = JSON.parse(msgStorage);
		delete msgStorage[imUserName];
		localStorage.setItem("msg_storage_" + user.id, JSON.stringify(msgStorage));
	}

	return {
		loadData: function() {
			if (!hasLoad) {
				init();
			}
		},
		isLoaded: function() {
			return hasLoad;
		},
		openTalkPage: function(el, curr_contact) {
			if (el && !closeRightBtn(el)) {
				curr_talk_user = ' ';
				return;
			}
			//标记该用户消息已读
			var msgStorage = localStorage.getItem("msg_storage_" + user.id);
			if (!msgStorage) {
				msgStorage = {};
			} else {
				msgStorage = JSON.parse(msgStorage);
			}
			var msgList = msgStorage[curr_contact];
			$.each(msgList, function(i, msgObj) {
				msgObj.isReaded = true;
				msgList[i] = msgObj;
			});
			msgStorage[curr_contact] = msgList;
			localStorage.setItem("msg_storage_" + user.id, JSON.stringify(msgStorage));
			//跳转页面
			openWindowFull('news_talk.html', {
				"hx_u": curr_contact
			});
		},
		sendPicToOther: function(toId, imgSrc) {
			sendPic(toId, imgSrc);
		},
		sendVoiceToOther: function(toId, voiceSrc, duration) {
			sendVoice(toId, voiceSrc, duration);
		},
		sendTextToOther: function(toId, textMsg) {
			sendText(toId, textMsg);
		},
		setCurrUser: function(userName) {
			curr_talk_user = userName;
		},
		closeConn: function() {
			conn.close();
		},
		canEnter: function() {
			return closeRightBtn();
		}
	};
})();

$(function() {
	mui.plusReady(function() {
		//点击推送列表
		//不要改成tap,否则收到消息ios会直接跳转到聊天页面
		plus.push.addEventListener("click", function(msg) {
			newsTalkList.openTalkPage(null, msg.payload);
		}, false);
	});

	//点击未读消息列表，跳转至聊天页面
	$("#hasNot_Read").on("tap", ".hasNo_Readed", function() {
		curr_talk_user = $(this).attr("title");
		newsTalkList.openTalkPage(this, curr_talk_user);
	});

	document.addEventListener("pause", function() {
		console.log("应用从前台切换到后台");
		localStorage.setItem("curr_talk_user", curr_talk_user);
		curr_talk_user = " ";
	}, false);
	document.addEventListener("resume", function() {
		console.log("应用从后台切换到前台");
		curr_talk_user = localStorage.getItem("curr_talk_user");
	}, false);

});