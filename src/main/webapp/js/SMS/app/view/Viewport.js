/**
 * Created by zhengchaoqun on 2017/9/11.
 */
Ext.define('SMS.view.Viewport', {
    extend : 'Ext.Viewport',
    layout : 'fit',
    hideBorders : true,
    requires : [//创建引用,类似于import
        'SMS.view.Header',
        'SMS.view.Menu',
        'SMS.view.TabPanel',
        'SMS.view.South'
    ],
    initComponent : function () {
        var me = this;
        Ext.apply(me, {
            items : [{
                id : 'desk',
                layout : 'border',//只要定义了布局为border,items中必须要有region: 'center'的组件,该例的TabPanel就是
                items : [
                    Ext.create('SMS.view.Header'),
                    Ext.create('SMS.view.Menu'),
                    Ext.create('SMS.view.TabPanel'),
                    Ext.create('SMS.view.South')
                ]
            }]
        });
        me.callParent(arguments);
    }
})
