/**
 * Created by zhengchaoqun on 2017/9/8.
 */
Ext.define('SMS.controller.Main', {
	extend : 'Ext.app.Controller',
	requires : ['SMS.view.Login'],
	onLaunch : function () {
		var win;
		while (!win) {
			win = Ext.create('SMS.view.Login').show();
		}
	},
	init : function () {

	}
});