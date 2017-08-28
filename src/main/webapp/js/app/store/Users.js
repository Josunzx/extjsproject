// we now reference the Model instead of defining fields inline
Ext
.define('AM.store.Users', {
	extend : 'Ext.data.Store',
	model : 'AM.model.User',
	// 将Store的autoLoad设置为了true，这要求Store的代理要自动加载数据，当刷新页面，将得到和之前一样的效果。
	autoLoad : true,
	// 在Extjs4中，代理的方式有AJAX, JSON-P 和 HTML5 localStorage
	proxy : {
		type : 'ajax',
// url : '../js/app/data/users.txt',//json文件找不到，不知道为什么
		// 使用api来更新一个新的URL。
		api : { read : '../js/app/data/users.txt', update : '../js/app/data/updateUsers.txt' },
		reader : { type : 'json', root : 'users', successProperty : 'success' } } });
