/**
 * Created by zhengchaoqun on 2017/9/11.
 */
Ext.define('SMS.view.Menu', {
    alias : 'widget.menu',
    extend : 'Ext.tree.Panel',
    initComponent : function () {
        Ext.apply(this, {
            id : 'menu-panel',
            title : '系统菜单',
            iconCls : 'icon-menu',
            margins : '0 0 -1 1',
            region : 'west',
            border : false,
            enableDD : false,
            split : true,
            width : 212,
            minSize : 130,
            maxSize : 300,
            rootVisible : false,
            containerScroll : true,
            collapsible : true,
            autoScroll : false,
            store : Ext.create('SMS.store.Menus')
        });
        this.callParent(arguments);
    }
});
