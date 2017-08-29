Ext.define('Post', {
	extend : 'Ext.data.Model',
	fields : [
		'id', 'user_id', 'title', 'body'
	],
	proxy : {
		type : 'rest',
		url : 'data/posts',
		reader : { type : 'json', root : 'posts' } },
	belongsTo : 'User',
	hasMany : { model : 'Comment', name : 'comments' } 
	}); 
