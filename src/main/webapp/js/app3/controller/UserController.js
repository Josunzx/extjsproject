Ext.define('APPThird.controller.UserController', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
			'viewport > userlist' : { itemdblclick : this.editUser },
			'useredit button[action=save]' : { click : this.updateUser } });
	},
	stores : [
		'Users'
	],
	models : [
		'User'
	],
	views : [
		'user.List', 'user.Edit'
	],
	updateUser : function(button) {
		var win = button.up('window'), form = win.down('form'), record = form
		.getRecord(), values = form.getValues();
		record.set(values);
		win.close();
		// 保证服务的同步编辑
		this.getUsersStore().sync();
	},
	editUser : function(grid, record) {
// console.log('Double clicked on ' + record.get('name'));
		var view = Ext.widget('useredit');
		view.down('form').loadRecord(record);
	} });
