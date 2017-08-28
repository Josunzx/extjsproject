// 1.name: 应用程序名称
// 2.appFolder: 应用程序代码的目录，用来进行动态加载代码的
// 3.controllers: 应用程序使用到的控制器
// 4.autoCreateViewport:是否自动创建Viewport，默认为false，我们这里设置为true，
// 当它被设置为true的时候，应用程序会自动创建Viewport，这个Viewport的定义在我们的app/view/viewport.js中；
// 如果为false的时候，我们需要在launch中手动创建相应的视图。
//
Ext.application({ name : "MyApp", appFolder : '../js/app2', controllers : [
	"User"
], autoCreateViewport : true, launch : function() {
// 页面加载完成之后执行
	console.info('加载完成');
} });
