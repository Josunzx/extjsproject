Ext.application({
	name : "HelloExt",
	launch : function() {
		Ext.create('Ext.panel.Panel', {
			width : 1024,
			height : 720,
			layout : 'border',
			items : [
				{
					region : 'south',
					xtype : 'panel',
					height : 20,
					split : false,
					html : '欢迎登录!',
					margins : '0 5 5 5' },
				{
					region : 'west',
					xtype : 'panel',
					margins : '5 0 0 5',
					title : 'Accordion Layout',
					width : 300,
					layout : 'accordion',
					defaults : { bodyStyle : 'padding:15px' },
					layoutConfig : {
						titleCollapse : false,
						animate : true,
						activeOnTop : true },
					items : [
						{ title : 'Panel 1', html : 'Panel content!' },
						{ title : 'Panel 2', html : 'Panel content!' },
						{ title : 'Panel 3', html : 'Panel content!' }
					] },
				{
					title : 'Center Region',
					region : 'center',
					xtype : 'panel',
					layout : 'fit',
					margins : '5 5 0 0',
					html : '在Extjs4中，center区域必须指定，否则会报错。' }
			],
			renderTo : Ext.getBody() });
	} });
