/**
 * 图片处理控件<br/>
 * 样式依赖common.css
 * @param {Object} $
 * @param {Object} mui
 * @param {Object} document
 * @author chenrui
 * @date 2016-06-15 11:57:33
 */
(function($, mui, document) {
	var bodyEl;
	var parentEl = '<div class="pic_handler" style="display: none;">{_element_}</div>';
	var sendToOtherEl = '<div class="share_bottom"><p class="share_to font-size28" id="ph_sendToFriends">发送给朋友</p></div>';
	var saveLocalEl = '<div class="share_bottom"><p class="share_to font-size28" id="ph_saveToLocal">保存到本地</p></div>';
	var cancelEl = '<div class="share_bottom"><p class="share_to font-size28" id="ph_cancel">取消</p></div>';

	var useSTO = true; //是否使用发送给朋友
	var useSL = true; //是否使用保存到本地
	var showPanelTime = 1500; //显示上弹框的时间
	var listenEl = ".mui-zoom"; //监听长按的元素
	var beginHoldTime; //开始hold时间
	var holdTimer; //hold定时器
	var picSrc; //当前hold图片路径

	/**
	 * 开始长按图片 
	 * @param {Object} el
	 */
	function beginHoldImg(el) {
		console.log("#####beginHold######");
		if (holdTimer) {
			return;
		}
		holdTimer = setInterval(function() {
			var hadHoldTime = (new Date()).getTime() - beginHoldTime;
			if (hadHoldTime > 1200) {
				picSrc = $(el).attr("src");
				$(".pic_handler").show();
				beginHoldTime = 0;
				clearInterval(holdTimer);
				holdTimer = null;
			}
		}, showPanelTime);

	}

	/**
	 * 保存到相册 
	 * @param {Object} imgSrc
	 */
	function saveToGallery(imgSrc) {
		plus.gallery.save(imgSrc, function() {
			mui.toast('保存成功');
		}, function() {
			mui.toast('保存失败，请重试！');
		});
	}

	/**
	 * 图片处理
	 * @param {Object} options
	 * @author chenrui 
	 */
	var PicHandler = function(options) {
			var self = this;
			var st = "";
			if (options) {
				useSTO = options.sto || true;
				useSL = options.sl || true;
				showPanelTime = options.showPanelTime || 2000;
				listenEl = options.listenEl || ".mui-zoom";
			}
			self.initElement();
			self.initEvent();
		}
		/**
		 * 初始化元素 
		 */
	PicHandler.prototype.initElement = function() {
		var self = this;
		if ($(".pic_handler").length > 0) {
			return;
		}
		var childEl = "";
		if (useSTO) {
			childEl += sendToOtherEl;
		}
		if (useSL) {
			childEl += saveLocalEl;
		}
		childEl += cancelEl;
		parentEl = parentEl.replace("{_element_}", childEl);
		$(bodyEl).append(parentEl);
	}

	/**
	 * 初始化事件 
	 */
	PicHandler.prototype.initEvent = function() {
		var self = this;
		$("body").on("tap", listenEl, function() {
			$(".pic_handler").hide();
		});
		$("body").on("tap", function() {
			$(".pic_handler").hide();
		});

		$("body").on("hold", listenEl, function() {
			beginHoldTime = (new Date()).getTime();
			beginHoldImg(this);
			console.log("begin hold");
		});

		$("body").on("release", listenEl, function() {
			console.log("release");
			beginHoldTime = 0;
			clearInterval(holdTimer);
			holdTimer = null;
		});

		//发送给好友
		$("#ph_sendToFriends").on("tap", function(e) {
			openWindowFull("mine_fri_send_choose.html", {
				src: picSrc
			});
			$(".pic_handler").hide();
		});

		$("#ph_saveToLocal").on("tap", function(e) {
			picSrc = picSrc + "";
			if (picSrc.startsWith("http")) {
				//下载
				var dtask = plus.downloader.createDownload(picSrc, {}, function(d, status) {
					// 下载完成
					if (status == 200) {
						//图片需要显示绝对路径
						picSrc = plus.io.convertLocalFileSystemURL(d.filename);
						saveToGallery(picSrc);
					} else {
						mui.toast("Download failed: " + status);
					}
				});
				dtask.start();
			} else if (picSrc.startsWith("file")) {
				saveToGallery(picSrc);
			}
			$(".pic_handler").hide();
		});

		$("#ph_cancel").on("tap", function(e) {
			clearInterval(holdTimer);
			$(".pic_handler").hide();
		});
	}

	if ($.fn) {
		$.fn.picHandler = function(options) {
			bodyEl = this;
			var ph = new PicHandler(options);
			return ph;
		}
	}

})($, mui, document)