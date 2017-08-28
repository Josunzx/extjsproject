Ext.define('AM.controller.UserController', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
			'viewport > panel' : { render : this.onPanelRendered },
			'userlist' : { itemdblclick : this.editUser } });
	},
	views : [
		'user.List'
	],
	onPanelRendered : function() {
		console.log('The panel was rendered');
	},
	editUser : function(grid, record) {
		console.log('Double clicked on ' + record.get('name'));
	} });
