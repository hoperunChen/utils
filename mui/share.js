(function($, mui, document) {
	var parentEl;
	var shareEl = "<div id='shade'></div><div class='send_success' id='share'>{share_text}<button id='shareBtn'>分享到...</button><button id='cancelBtn'>待会儿再说</button></div>";
	var shares = null,
		bhref = false;
	var sharehref;
	var sharehrefTitle;
	var sharehrefDes;
	var shareThumbs;
	var sharePic;
	var sucsbac = function() {};
	var errorbac = function() {};
	var cancelbac = function() {};
	var Intent = null,
		File = null,
		Uri = null,
		main = null;

	/**
	 * 初始化分享服务 
	 */
	function updateSerivces() {
		plus.share.getServices(function(s) {
			shares = {};
			for (var i in s) {
				var t = s[i];
				shares[t.id] = t;
			}
		}, function(e) {
			//outSet( "获取分享服务列表失败："+e.message );
		});
	}

	/**
	 * 打开分享上弹框
	 */
	function shareShow(obj) {
		// 分享按钮列表
		var shareBts = [];
		// 更新分享列表 
		var ss = shares['weixin'];
		ss && ss.nativeClient && (shareBts.push({
				title: '微信朋友圈',
				s: ss,
				x: 'WXSceneTimeline'
			}),
			shareBts.push({
				title: '微信好友',
				s: ss,
				x: 'WXSceneSession'
			}));
		ss = shares['sinaweibo'];
		ss && shareBts.push({
			title: '新浪微博',
			s: ss
		});
		ss = shares['qq'];
		ss && ss.nativeClient && shareBts.push({
			title: 'QQ',
			s: ss
		});
		// 弹出分享列表
		shareBts.length > 0 ? plus.nativeUI.actionSheet({
			title: '分享',
			cancel: '待会儿再说',
			buttons: shareBts
		}, function(e) {
			if (e.index == 0) {
				obj.showShare();
			}
			(e.index > 0) && shareAction(shareBts[e.index - 1], true, obj);
		}) : plus.nativeUI.alert('暂不支持分享!');
	}

	/**
	 * 分享操作
	 * @param {JSON} sb 分享操作对象s.s为分享通道对象(plus.share.ShareService)
	 * @param {Boolean} bh 是否分享链接
	 */
	function shareAction(sb, bh, obj) {
		console.log("分享操作：");
		if (!sb || !sb.s) {
			console.log("无效的分享服务！");
			return;
		}
		var msg = {
			//content:sharecontent.value,
			content: '测试分享',
			extra: {
				scene: sb.x
			}
		};
		if (bh) {
			msg.href = sharehref;
			//		msg.href='http://www.welcomepapa.com/';
			msg.title = (sharehrefTitle || '');
			msg.content = (sharehrefDes || '');
			msg.thumbs = [(shareThumbs || "_www/images/share/sharedefault.png")];
			msg.pictures = [(sharePic || "_www/images/share/sharedefault.png")];
		} else {
			if (pic && pic.realUrl) {
				msg.pictures = [pic.realUrl];
			}
		}

		// 发送分享
		if (sb.s.authenticated) {
			console.log("---已授权---");
			shareMessage(msg, sb.s, obj);
		} else {
			console.log("---未授权---");
			sb.s.authorize(function() {
				shareMessage(msg, sb.s, obj);
			}, function(e) {
				console.log("认证授权失败：" + e.code + " - " + e.message);
			});
		}
	}

	/**
	 * 发送分享消息
	 * @param {JSON} msg
	 * @param {plus.share.ShareService} s
	 */
	function shareMessage(msg, s, obj) {
		console.log(JSON.stringify(msg));
		s.send(msg, function() {
			console.log("分享到\"" + s.description + "\"成功！ ");
			//addShareLog
			obj.hideShare();
			if (sucsbac) {
				sucsbac();
			}
			Dcp.ajaxUtil.asyncPost("pointLog/addShareLog", {
				uid: Dcp.getUserId()
			}, function(resp) {});
		}, function(e) {
			console.log("分享到\"" + s.description + "\"失败: " + JSON.stringify(e));
			obj.hideShare();
			if (errorbac) {
				errorbac();
			}
		});
	}

	/**
	 * 分享者对象 
	 * @param {Object} options
	 */
	var Sharer = function(options) {
		var self = this;
		var st = "";
		if (options) {
			sharehref = options.sharehref;
			sharehrefTitle = options.sharehrefTitle;
			sharehrefDes = options.sharehrefDes;
			shareThumbs = options.shareThumbs;
			sharePic = options.sharePic;
			sucsbac = options.sucsbac || function() {};
			errorbac = options.errorbac || function() {};
			cancelbac = options.cancelbac || function() {};
			if (options.shareText)
				st = "<p><span>" + options.shareText + "!</span></p>";
		}
		shareEl = shareEl.replace("{share_text}", st);
		self.initElement();
		updateSerivces();
		if (plus.os.name == "Android") {
			Intent = plus.android.importClass("android.content.Intent");
			File = plus.android.importClass("java.io.File");
			Uri = plus.android.importClass("android.net.Uri");
			main = plus.android.runtimeMainActivity();
		}
	}

	/**
	 * 初始化元素 
	 */
	Sharer.prototype.initElement = function() {
		var self = this;
		$(parentEl).prepend(shareEl);

		$("#shareBtn").on("tap", function() {
			shareShow(self);
		});

		$("#cancelBtn").on("tap", function() {
			self.hideShare();
			cancelbac();
		})
	}

	/**
	 * 显示分享面板
	 * @param {Object} params
	 */
	Sharer.prototype.showShare = function(params) {
		if (params) {
			if (params.sharehref) {
				sharehref = params.sharehref;
			}
			if (params.sharehrefDes) {
				sharehrefDes = params.sharehrefDes;
			}
			if (params.shareText) {
				if ($("#share").find("p").length > 0) {
					$("#share").find("p").html(params.shareText);
				} else {
					$("#share").prepend("<p><span>" + params.shareText + "!</span></p>");
				}
			}
		}
		$("#shade").show();
		$("#share").show();
	}

	/**
	 * 显示分享面板
	 */
	Sharer.prototype.hideShare = function() {
		$("#shade").hide();
		$("#share").hide();
	}

	if ($.fn) {
		$.fn.pqSharer = function(options) {
			parentEl = this;
			var pqs = new Sharer(options);
			return pqs;
		}
	}

})($, mui, document)