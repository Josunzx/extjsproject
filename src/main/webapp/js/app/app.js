Ext.application({ name : 'AM', appFolder : '/firstMaven/js/app',
// appFolder : '../js/app',
	launch : function() {
		Ext.create('Ext.container.Viewport', { layout : 'fit', items : [
			{ xtype : 'userlist' }
		] });
	}, 
	controllers : [
		'UserController'
	] });
