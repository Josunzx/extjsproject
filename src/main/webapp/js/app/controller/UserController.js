Ext.define('AM.controller.UserController', {
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
		console.log('clicked the Save button');
	},
	editUser : function(grid, record) {
// console.log('Double clicked on ' + record.get('name'));
		var view = Ext.widget('useredit');
		view.down('form').loadRecord(record);
	} });
