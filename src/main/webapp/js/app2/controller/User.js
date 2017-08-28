// 将定义好的model、store、view作为配置项添加到controller中，controller会加载这些文件；
// 在init方法中为view添加响应事件（这里添加事件的方法是通过query方式获取控件并添加的，这也是为什么要为view添加alias的原因）
// editUser方法和saveUser方法则是具体的操作内容
Ext.define('MyApp.controller.User', {
	extend : 'Ext.app.Controller',
	stores : [
		'User'
	],
	models : [
		'User'
	],
	views : [
		'Viewport', 'user.List', 'user.Edit'
	],
	init : function() {
		this.control({
			'userlist' : { itemdblclick : this.editUser },
			'useredit button[action=save]' : { click : this.saveUser } });
	},
	editUser : function(grid, record) {
		var win = Ext.widget("useredit");
		win.down("form").loadRecord(record);
		win.show();
	},
	saveUser : function(btn) {
		var win = btn.up("window"), form = win.down("form"), record = form
		.getRecord();
		form.updateRecord();
		record.commit();
		win.close();
	} });
