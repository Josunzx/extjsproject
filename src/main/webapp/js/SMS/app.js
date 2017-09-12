/**
 * Created by zhengchaoqun on 2017/9/8.
 * 该文件应放在app项目目录外
 */
Ext.Loader.setConfig({enabled : true});
Ext.application({
    name : 'SMS', //理解为命名空间即可
    appFolder : 'app',//真实的项目目录，最好为该app.js的相对路径
    autoCreateViewport : true,//设置为true，默认加载view/Viewport.js，Extjs4.02a版本以后默认为false
    controllers : [
        'Main'
    ]
});
