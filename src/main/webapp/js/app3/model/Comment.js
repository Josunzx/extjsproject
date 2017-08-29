Ext.define('Comment', {
	extend : 'Ext.data.Model',
	fields : [
		'id', 'post_id', 'name', 'message'
	],
	belongsTo : 'Post' });
