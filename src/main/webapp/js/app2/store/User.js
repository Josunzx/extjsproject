//虽然store不是mvc中必须的步骤，但是作为数据仓库，store起到了数据存取的作用，
//grid、form等展现的数据都是通过store来提供的，因此store在extjs mvc开发模式中是必不可少的。
Ext.define("MyApp.store.User", {
	extend : "Ext.data.Store",
	model : "MyApp.model.User",
	data : [
		{ name : "Tom", age : 5, phone : "123456" },
		{ name : "Jerry", age : 3, phone : "654321" }
	] });
