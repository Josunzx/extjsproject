/**
 * Created by zhengchaoqun on 2017/9/12.
 */
Ext.define('SMS.controller.Menu', {
	extend : 'Ext.app.Controller',
	init : function () {
		this.control({
			'menu' : {//Ext选择器
				itemclick : this.loadMenu
			}
		})
	},
	loadMenu : function (selModel, record) {
		if (record.get('leaf')) {
			var text = record.get('text');
			var panel = Ext.getCmp(text);
			if (!panel) {
				panel = {
					title : 'New Tab ' + text,
					iconCls : 'tabs',
					html : 'Tab Body ' + text + '<br/><br/>',
					closable : true
				};
				this.openTab(panel, text);
			} else {
				var main = Ext.getCmp("content-panel");
				main.setActiveTab(panel);
			}
		}
	},
	openTab : function (panel, id) {
		var o = (typeof panel == "string" ? panel : id || panel.id);
		var main = Ext.getCmp("content-panel");
		var tab = main.getComponent(o);
		if (tab) {
			main.setActiveTab(tab);
		} else if (typeof panel != "string") {
			panel.id = o;
			var p = main.add(panel);
			main.setActiveTab(p);
		}
	}
});