Ext.define('User', {
	extend : 'Ext.data.Model',
	fields : [
		'id', 'username'
	],
	// 在model中使用proxy有如下好处：
	// 1.使每个使用User模型类的存储类实例以相同方式加载数据，这样能避免必须为每个存储类实例复制相同代理方式的定义。
	// 2.可以不必使用存储类来加载和保存模型数据
	proxy : {
		type : 'rest',
		url : '/firstMaven/user/getUsers',
		reader : { type : 'json', root : 'users' } },
	validations : [//模型类验证数据的功能
		{ type : 'presence', name : 'name' },
		{ type : 'length', name : 'name', min : 5 },
		{ type : 'format', name : 'age', matcher : /\d+/ },
		{ type : 'inclusion', name : 'gender', list : [ 'male', 'female' ] },
		{ type : 'exclusion', name : 'name', list : [ 'admin' ] }
	],
	hasMany : 'Post' // shorthand for { model: 'Post', name: 'posts' }
});
// 加载User使用ID 1和相关的文章和评论使用User的代理
// 将会调用data/users/1,到后端查找
User.load(1, { success : function(user) {
	console.log("User: " + user.get('name'));
	user.posts().each(function(post) {
		console.log("Comments for post: " + post.get('title'));
		post.comments().each(function(comment) {
			console.log(comment.get('message'));
		});
	});
} });
