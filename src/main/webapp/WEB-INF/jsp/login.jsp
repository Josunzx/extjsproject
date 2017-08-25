<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ExtJs测试页面</title>
<link rel="stylesheet" type="text/css" href="${pagecontext.request.getcontextpath }/resources/css/ext-all.css"/>
<script type="text/javascript" src="${pagecontext.request.getcontextpath }/js/common/ext-all.js"></script>
<script type="text/javascript" src="${pagecontext.request.getcontextpath }/js/common/ext-lang-zh_CN.js"></script>
<script type="text/javascript">
	Ext.onReady(function() {
		//创建一个窗体
		var win = new Ext.Window({
			width : 300,
			height : 300,
			items : [],
			modal : true,
			buttonAlign : 'center',
			buttons : [
				{
					text : '测试',
					id : 'btnTest',
					handler : function() {
						Ext.Msg.show({
							title : '询问',
							msg : '您喜欢 ExtJs 吗？',
							fn : processResult,
							icon : Ext.Msg.QUESTION,
							buttons : Ext.Msg.YESNO });
					} }
			] });
		win.show();
	});
	//询问对话框处理Handler
	function processResult(btn) {
		Ext.Msg.alert('结果', btn);
	}
</script>
</head>
<body>

</body>
</html>