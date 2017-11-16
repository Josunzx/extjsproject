package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 欠税信息列表
 *
 * @author auto create
 * @since 1.0, 2017-03-16 22:54:50
 */
public class TaxOweList extends ZhimaObject {

	private static final long serialVersionUID = 7277387277866933117L;

	/** 
	 * 欠税信息列表
	 */
	@ApiListField("tax_owe_list")
	@ApiField("tax_owe")
	private List<TaxOwe> taxOweList;

	public void setTaxOweList(List<TaxOwe> taxOweList) {
		this.taxOweList = taxOweList;
	}
	public List<TaxOwe> getTaxOweList( ) {
		return this.taxOweList;
	}

}
