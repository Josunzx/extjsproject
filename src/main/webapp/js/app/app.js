Ext.application({
	name : 'AM',
	appFolder : '/FirstMaven/js/app',
//	appFolder : '../js/app',
	launch : function() {
		Ext.create(
			'Ext.container.Viewport',
			{
				layout : 'fit',
				items : [
				  {
					  xtype: 'userlist'
				  }
				]
			}
		);
  },
//  launch: function() {
//    Ext.create('Ext.container.Viewport', {
//        layout: 'fit',
//        items: [
//            {
//                xtype: 'panel',
//                title: 'Users',
//                html : 'List of users will go here'
//            }
//        ]
//    });
//  },

  controllers: [
    'UserController'
  ]

});
