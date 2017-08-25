/**
 * Copyright(c) 2011-2012 by YouCredit Inc. All Rights Reserved
 */
// Ext.UpdateManager.defaults.indicatorText = '<div
// class="loading-indicator">加载中...</div>';
if (Ext.View) {
	Ext.View.prototype.emptyText = "";
}
// if(Ext.MessageBox){
// Ext.window.MessageBox.prototype.buttonText.cancle = "取消";
// Ext.window.MessageBox.buttonText.cancle = "取消";
// }
if (Ext.grid.Grid) {
	Ext.grid.Grid.prototype.ddText = "{0} 选择行";
}
if (Ext.TabPanelItem) {
	Ext.TabPanelItem.prototype.closeText = "关闭";
}
if (Ext.form.Field) {
	Ext.form.Field.prototype.invalidText = "输入值非法";
}
Date.monthNames = [
	"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"
];
Date.dayNames = [
	"日", "一", "二", "三", "四", "五", "六"
];
if (Ext.MessageBox) {
	Ext.MessageBox.buttonText = { ok : "确定", cancel : "取消", yes : "是", no : "否" };
}
var msgBox = Ext.MessageBox;
Ext.each(msgBox.msgButtons, function(btn, index) {
	btn.setText(msgBox.buttonText[msgBox.buttonIds[index]]);
});
if (Ext.util.Format) {
	Ext.util.Format.date = function(v, format) {
		if (!v) return "";
		// if(!(v instanceof Date)) v = new Date(Date.parse(v));
		// return v.dateFormat(format || "y年m月d日");
		if (!(v instanceof Date)) {
			v = new Date(v);
			return Ext.Date.format(v, format || "Y-m-d");
		} else {
			return "";
		}
	};
}
if (Ext.DatePicker) {
	Ext.apply(Ext.DatePicker.prototype, {
		todayText : "今天",
		minText : "日期在最小日期之前",
		maxText : "日期在最大日期之后",
		disabledDaysText : "",
		disabledDatesText : "",
		monthNames : Date.monthNames,
		dayNames : Date.dayNames,
		nextText : '下月 (Control+Right)',
		prevText : '上月 (Control+Left)',
		monthYearText : '选择一个月 (Control+Up/Down 来改变年)',
		todayTip : "{0} (空格键选择)",
		format : "Y-m-d",
		okText : "确定",
		cancelText : "取消" });
}
if (Ext.PagingToolbar) {
	Ext.apply(Ext.PagingToolbar.prototype, {
		beforePageText : "第",
		afterPageText : "页，共 {0} 页",
		firstText : "第一页",
		prevText : "前一页",
		nextText : "下一页",
		lastText : "最后页",
		refreshText : "刷新",
		displayMsg : "本页显示：第 {0} 至第 {1} 条，共 {2} 条",
		emptyMsg : '没有数据需要显示' });
}
if (Ext.form.TextField) {
	Ext.apply(Ext.form.TextField.prototype, {
		minLengthText : "该输入项的最小长度是 {0}",
		maxLengthText : "该输入项的最大长度是 {0}",
		blankText : "该输入项为必输项",
		regexText : "",
		emptyText : "" });
}
if (Ext.form.NumberField) {
	Ext.apply(Ext.form.NumberField.prototype, {
		minText : "该输入项的最小值是 {0}",
		maxText : "该输入项的最大值是 {0}",
		nanText : "{0} 不是有效数值" });
}
if (Ext.form.DateField) {
	Ext.apply(Ext.form.DateField.prototype, {
		disabledDaysText : "禁用",
		disabledDatesText : "禁用",
		minText : "该输入项的日期必须在 {0} 之后",
		maxText : "该输入项的日期必须在 {0} 之前",
		invalidText : "{0} 是无效的日期 - 必须符合格式： {1}",
		format : "y年m月d日" });
}
if (Ext.form.ComboBox) {
	Ext.apply(Ext.form.ComboBox.prototype, {
		loadingText : "加载...",
		valueNotFoundText : "   ",
		emptyText : "--请选择--" });
}
if (Ext.form.VTypes) {
	Ext.apply(Ext.form.VTypes, {
		emailText : '该输入项必须是电子邮件地址，格式如： "user@domain.com"',
		urlText : '该输入项必须是URL地址，格式如： "http:/' + '/www.domain.com"',
		alphaText : '该输入项只能包含字符和_',
		alphanumText : '该输入项只能包含字符,数字和_' });
}
if (Ext.grid.header.Container) {
	Ext.apply(Ext.grid.header.Container.prototype, {
		sortAscText : "正序",
		sortDescText : "逆序",
		lockText : "锁列",
		unlockText : "解锁列",
		columnsText : "列" });
}
// if (Ext.ux.grid.FiltersFeature) {
// Ext.apply(Ext.ux.grid.FiltersFeature, { menuFilterText : "过滤器" });
// }
if (Ext.grid.PropertyColumnModel) {
	Ext.apply(Ext.grid.PropertyColumnModel.prototype, {
		nameText : "名称",
		valueText : "值",
		dateFormat : "y年m月d日" });
}
if (Ext.layout.BorderLayout.SplitRegion) {
	Ext.apply(Ext.layout.BorderLayout.SplitRegion.prototype, {
		splitTip : "拖动来改变尺寸.",
		collapsibleSplitTip : "拖动来改变尺寸. 双击隐藏." });
}
if (Ext.grid.RowEditor) {
	Ext.apply(Ext.grid.RowEditor, { saveBtnText : "更新", cancelBtnText : "取消" });
}
if (Ext.grid.RowEditor) {
	Ext.apply(Ext.grid.RowEditor.prototype, {
		saveBtnText : '保存',
		cancelBtnText : '取消',
		errorsText : '错误信息',
		dirtyText : '已修改,你需要提交或取消变更' });
	if (Ext.form.action.Submit) {
		Ext
			.apply(Ext.form.action.Submit.prototype, {
				processResponse : function(response) {
					this.response = response;
					var data = response.responseText;
					if (data == '<pre></pre>') {
						response.responseText = '';
					}
					if (!response.responseText) { return true; }
					return (this.result = this.handleResponse(response));
				},
				handleResponse : function(response) {
					var form = this.form, errorReader = form.errorReader, rs, errors, i, len, records;
					if (errorReader) {
						rs = errorReader.read(response);
						records = rs.records;
						errors = [];
						if (records) {
							for (i = 0, len = records.length; i < len; i++) {
								errors[i] = records[i].data;
							}
						}
						if (errors.length < 1) {
							errors = null;
						}
						return { success : rs.success, errors : errors };
					}
					return response.responseText;
				} });
	}
}
