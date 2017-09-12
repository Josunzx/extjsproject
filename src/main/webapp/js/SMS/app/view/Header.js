/**
 * Created by zhengchaoqun on 2017/9/11.
 */
Ext.define('SMS.view.Header', {
    extend : 'Ext.Component',
    initComponent : function () {
        Ext.applyIf(this, {
            xtype : 'box',
            cls : 'header',
            region : 'north',
            html : '<h1>员工管理系统</h1>',
            height : 30
        });
        this.callParent(arguments);
    }
});
