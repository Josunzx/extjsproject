/**
 * Created by zhengchaoqun on 2017/9/11.
 */
Ext.define('SMS.store.Menus', {
    extend : 'Ext.data.TreeStore',
    root : {
        expanded : true
    },
    proxy : {
        type : 'ajax',
        url : 'Data/Menu/0.json'
    }
});
