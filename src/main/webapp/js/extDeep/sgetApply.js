Ext.define('My.own.WindowBottomBar', { xtype : 'button', text : 'Button 1' });
Ext.define('My.own.Window', {
	/** @readonly */
	isWindow : true,
	config : {
		title : 'Title Here',
		bottomBar : { enabled : true, height : 50, resizable : false } },
	constructor : function(config) {
		this.initConfig(config);
		return this;
	},
	// 设置值之前调用apply方法.apply没有返回值,则setter不会设置值
	applyTitle : function(title) {
		if (!Ext.isString(title) || title.length === 0) {
			alert('Error: Title must be a valid non-empty string');
			//抛出异常
			throw new Error('['+ Ext.getDisplayName(arguments.callee) +'] Some message here');
		} else {
			return title;
		}
//		return title + "我的我的";
	},
	applyBottomBar : function(bottomBar) {
		if (bottomBar && bottomBar.enabled) {
			if (!this.bottomBar) {
				return Ext.create('My.own.WindowBottomBar', bottomBar);
			} else {
				this.bottomBar.setConfig(bottomBar);
			}
		}
	} });
var myWindow = Ext.create('My.own.Window', {
	title : 'Hello World',
	bottomBar : { height : 60 }});
alert(myWindow.getTitle()); // alerts "Hello World"
myWindow.setTitle('Something New');
alert(myWindow.getTitle()); // alerts "Something New"
myWindow.setTitle(null); // alerts "Error: Title must be a valid non-empty string"
myWindow.setBottomBar({ height : 100 }); // Bottom bar's height is changed to 100
