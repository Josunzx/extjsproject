Ext.application({
	name : 'AM',
	appFolder : 'app',
	launch : function() {
		Ext.create(
			'Ext.container.Viewport',
			{
				layout : 'fit',
				items : [
				  {
				  	xtype : 'panel',
				  	title : 'Users',
				  	html : '<a href="http://www.baidu.com">红色</a>'
				  }
				]
			}
		);
  },
  controllers: [
    'UserController'
  ]

});
