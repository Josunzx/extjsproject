Ext.define('User', {
	extend : 'Ext.data.Model',
	fields : [
		'id', 'name'
	],
	proxy : {
		type : 'rest',
		url : '/firstMaven/user/getUsers',
		reader : { type : 'json', root : 'users' } },
	hasMany : 'Post' // shorthand for { model: 'Post', name: 'posts' } 
	}); 



//加载User使用ID 1和相关的文章和评论使用User的代理 
//将会调用data/users/1,到后端查找
User.load(1, { success : function(user) {
	console.log("User: " + user.get('name'));
	user.posts().each(function(post) {
		console.log("Comments for post: " + post.get('title'));
		post.comments().each(function(comment) {
			console.log(comment.get('message'));
		});
	});
} }); 
