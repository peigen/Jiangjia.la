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

var $switch = $('.switch');
var $body = $('body');
var $switchWave = $('#ft');
$switch.bind('click', function() {
	var panelName = $(this).attr('data-panel-name');
	$switchWave.addClass('wave');
	var switchTimer = setTimeout(function() {
		$body.removeClass().addClass(panelName);
		$switchWave.removeClass('wave');
	}, 1000);
	return false;
});