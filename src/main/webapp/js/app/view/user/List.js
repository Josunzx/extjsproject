Ext.define('AM.view.user.List', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.userlist',
	title : 'All Users',
	store : 'Users',//有此项，可省略store
	initComponent : function() {
		this.columns = [//columns不能丢失 
			{ header : 'Name', dataIndex : 'name', flex : 1 },
			{ header : 'Email', dataIndex : 'email', flex : 1 }
		];
		this.callParent(arguments);
	} });
