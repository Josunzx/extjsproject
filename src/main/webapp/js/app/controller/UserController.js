Ext.define('AM.controller.UserController', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
// 'viewport > panel' : { render : this.onPanelRendered },
		'userlist' : { itemdblclick : this.editUser } });
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
	editUser : function(grid, record) {
// console.log('Double clicked on ' + record.get('name'));
		var view = Ext.widget('useredit');
		view.down('form').loadRecord(record);
	} });
