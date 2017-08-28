//Viewport作为我们应用程序的视图面板，可以被单独的定义在一个Viewport.js文件中。它的定义也很简单，通常用来将一个或多个view作为它的子控件。
Ext.define("MyApp.view.Viewport", {
	extend : "Ext.container.Viewport",
	layout : "fit",
	items : { xtype : "userlist" } });
