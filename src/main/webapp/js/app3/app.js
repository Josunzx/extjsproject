Ext.application({ name : 'APPThird', appFolder : '/firstMaven/js/app3',
// appFolder : '../js/app',
	launch : function() {
		Ext.create('Ext.container.Viewport', { layout : 'fit', items : [
			{ xtype : 'userlist' }
		] });
	}, 
	controllers : [
		'UserController'
	] });