/**
 * Created by zhengchaoqun on 2017/9/11.
 */
Ext.define('SMS.view.South', {
    extend : 'Ext.Toolbar',
    initComponent : function () {
        Ext.apply(this, {
            id : "bottom",
            //frame:true,
            region : "south",
            height : 23,
            items : ["当前用户：Guest", '->', "技术支持:<a href='http://www.baidu.net' target='_blank' style='text-decoration:none;'></a>&nbsp;&nbsp;"]
        });
        this.callParent(arguments);
    }
})
