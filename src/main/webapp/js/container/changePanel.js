// 不知如何显示
var containerPanel = Ext.create('Ext.panel.Panel', {
	renderTo : Ext.getBody(),
	width : 400,
	height : 200,
	title : 'Container Panel',
	layout : 'column',
//	suspendLayout : true
// 当我们做一些能触发其自动布局的操作时，保证延缓其能自动布局。
}).show();
// 添加一对子items。我们可以通过调用add()并传递一个数组一次性添加这两个子组件，
// 但是我们假定需要分别地添加它们是因为其他原因。
containerPanel.add({
	xtype : 'panel',
	title : 'Child Panel 1',
	height : 100,
	width : '50%' });
containerPanel.add({
	xtype : 'panel',
	title : 'Child Panel 2',
	height : 100,
	width : '50%' });
// 关闭延缓布局标志
containerPanel.suspendLayout = false;
// 触发布局
containerPanel.doLayout();

//containerPanel.show();