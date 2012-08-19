/**
 * Drj v0.1
 * 
 * Jiangjia.la Main js.
 * Copyright 2012, Dr_rOot
 * Dual licensed under the MIT or GPL Version 2 licenses.
 *
 * @param  {Object} win       cache window
 * @param  {Object} $         cache jQuery $
 * @param  {Object} undefined cache undefined
 * @return {Object}
 */
var Drj = (function(win, $, undefined) {

    var that = $({});

    that.switchPanel = function() {
    }

    return that;

})(this, $);

(function($) {

	$.fn.placeholder = function(options) {

        // 插件默认参数
        var defaults = {
            focusedClass: 'hidden',
            triggerMode: 'keyup'
        }

        var opts = $.extend({}, defaults, options);

        return this.each(function() {
            var $input = $(this);
            var inputValue = $input.val();
            var _placeholder = $input.attr('id');
            var $placeholder = $('label[for="' + _placeholder + '"]');
            
            $input.bind(opts.triggerMode, function() {
                $placeholder.trigger("hide.placeholder");
            });

            $input.bind("blur", function() {
                inputValue = $(this).val();
                // input value为空时才触发show.placeholder事件
                if (inputValue === "") {
                    $placeholder.trigger("show.placeholder");
                };
            });

            $placeholder.bind("hide.placeholder", function(e) {
                $(this).addClass(opts.focusedClass);
            });

            $placeholder.bind("show.placeholder", function(e) {
                $(this).removeClass(opts.focusedClass);
            });

            if (inputValue) {
                $input.trigger(opts.triggerMode);
            };

        });
    }

})(jQuery);

// @PLUGIN Owl Notifications | http://std.li/07 | Made by me | You are only allowed to use the script in this project
(function ($) {
    $.notification = function (settings) {
        var con, notification, hide, image, right, left, inner;
        
        settings = $.extend({
            title: undefined,
            content: undefined,
            timeout: 0,
            img: undefined,
            border: true,
            fill: false,
            showTime: false,
            click: undefined,
            icon: undefined,
            color: undefined,
            error: false
        }, settings);
        
        con = $("#notifications");
        if (!con.length) {
            con = $("<div>", { id: "notifications" }).appendTo($("#overlays"))
        };
        
        notification = $("<div>");
        notification.addClass("notification animated fadeInLeftMiddle fast");
        
        if(settings.error == true) {
            notification.addClass("error");
        }
        
        if( $("#notifications .notification").length > 0 ) {
            notification.addClass("more");
        } else {
            con.addClass("animated flipInX").delay(1000).queue(function(){ 
                con.removeClass("animated flipInX");
                    con.clearQueue();
            });
        }
        
        hide = $("<div>", {
            click: function () {
                 
                
                if($(this).parent().is(':last-child')) {
                    $(this).parent().remove();
                    $('#notifications .notification:last-child').removeClass("more");
                } else {
                    $(this).parent().remove();
                }
            }
        });
        
        hide.addClass("hide");

        left = $("<div class='left'>");
        right = $("<div class='right'>");
        
        if(settings.title != undefined) {
            var htmlTitle = "<h2>" + settings.title + "</h2>";
        } else {
            var htmlTitle = "";
        }
        
        if(settings.content != undefined) {
            var htmlContent = settings.content;
        } else {
            var htmlContent = "";
        }
        
        inner = $("<div>", { html: htmlTitle + htmlContent });
        inner.addClass("inner");
        
        inner.appendTo(right);
        
        if (settings.img != undefined) {
            image = $("<div>", {
                style: "background-image: url('"+settings.img+"')"
            });
        
            image.addClass("img");
            image.appendTo(left);
            
            if(settings.border==false) {
                image.addClass("border")
            }
            
            if(settings.fill==true) {
                image.addClass("fill");
            }
            
        } else {
            if (settings.icon != undefined) {
                var iconType = settings.icon;
            } else {
                if(settings.error!=true) {
                    var iconType = '"';
                } else {
                    var iconType = '!';
                }
            }   
            icon = $('<div class="icon">').html(iconType);
            
            if (settings.color != undefined) {
                icon.css("color", settings.color);
            }
            
            icon.appendTo(left);
        }

        left.appendTo(notification);
        right.appendTo(notification);
        
        hide.appendTo(notification);
        
        function timeSince(time){
            var time_formats = [
              [2, "One second", "1 second from now"], // 60*2
              [60, "seconds", 1], // 60
              [120, "One minute", "1 minute from now"], // 60*2
              [3600, "minutes", 60], // 60*60, 60
              [7200, "One hour", "1 hour from now"], // 60*60*2
              [86400, "hours", 3600], // 60*60*24, 60*60
              [172800, "One day", "tomorrow"], // 60*60*24*2
              [604800, "days", 86400], // 60*60*24*7, 60*60*24
              [1209600, "One week", "next week"], // 60*60*24*7*4*2
              [2419200, "weeks", 604800], // 60*60*24*7*4, 60*60*24*7
              [4838400, "One month", "next month"], // 60*60*24*7*4*2
              [29030400, "months", 2419200], // 60*60*24*7*4*12, 60*60*24*7*4
              [58060800, "One year", "next year"], // 60*60*24*7*4*12*2
              [2903040000, "years", 29030400], // 60*60*24*7*4*12*100, 60*60*24*7*4*12
              [5806080000, "One century", "next century"], // 60*60*24*7*4*12*100*2
              [58060800000, "centuries", 2903040000] // 60*60*24*7*4*12*100*20, 60*60*24*7*4*12*100
            ];
            
            var seconds = (new Date - time) / 1000;
            var token = "ago", list_choice = 1;
            if (seconds < 0) {
                seconds = Math.abs(seconds);
                token = "from now";
                list_choice = 1;
            }
            var i = 0, format;
            
            while (format = time_formats[i++]) if (seconds < format[0]) {
                if (typeof format[2] == "string")
                    return format[list_choice];
                else
                    return Math.floor(seconds / format[2]) + " " + format[1];
            }
            return time;
        };
        
        if(settings.showTime != false) {
            var timestamp = Number(new Date());
            
            timeHTML = $("<div>", { html: "<strong>" + timeSince(timestamp) + "</strong> ago" });
            timeHTML.addClass("time").attr("title", timestamp);
            timeHTML.appendTo(right);
            
            setInterval(
                function() {
                    $(".time").each(function () {
                        var timing = $(this).attr("title");
                        $(this).html("<strong>" + timeSince(timing) + "</strong> ago");
                    });
                }, 4000)
            
        }

        notification.hover(
            function () {
                hide.show();
            }, 
            function () {
                hide.hide();
            }
        );
        
        notification.prependTo(con);
        notification.show();

        if (settings.timeout) {
            setTimeout(function () {
                var prev = notification.prev();
                if(prev.hasClass("more")) {
                    if(prev.is(":first-child") || notification.is(":last-child")) {
                        prev.removeClass("more");
                    }
                }
                notification.remove();
            }, settings.timeout)
        }
        
        if (settings.click != undefined) {
            notification.addClass("click");
            notification.bind("click", function (event) {
                var target = $(event.target);
                if(!target.is(".hide") ) {
                    settings.click.call(this)
                }
            })
        }
        return this
    }
})(jQuery);

jQuery(function ($) {
	var $switch = $('.switch');
	var $body = $('body');
	var currentPanelName = $body.attr('class');
	var $switchWave = $('#ft');
	$switch.bind('click', function() {
		var panelName = $(this).attr('data-panel-name') || 'enter_url';
		if (panelName === currentPanelName) {
			return false;
		};
		$switchWave.addClass('wave');
		var switchTimer = setTimeout(function() {
			$body.removeClass().addClass(panelName);
			$switchWave.removeClass('wave');
		}, 1000);
		currentPanelName = panelName;
		return false;
	});

    $('.placeholder').placeholder({
        focusedClass : 'hidden'
    });

    $('.dropdown-toggle').dropdown();

    $.notification( 
        {
            title: '降小鱿快报：降价啦！降价啦！',
            content: '您订阅的 “<a target="_blank" href="http://item.mbaobao.com/pshow-1211011602.html?s_l=1_13">[戈尔本]英伦再现系列牛皮手提单肩斜挎包 黄棕色（马鞍棕）</a>” 价格从648降为599了！如有需求，请<a target="_blank" href="#">点此</a>一键购买。',
            img: "img/demo/01.jpg",
            fill: true
        }
    );
    
    // $.notification( 
    //     {
    //         title: 'This is the notification area',
    //         content: 'Check the <em>Notifications</em> section for more information.',
    //         icon: '&amp;'
    //     }
    // );
});