package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 欠税信息
 *
 * @author auto create
 * @since 1.0, 2017-03-16 22:40:31
 */
public class TaxOwe extends ZhimaObject {

	private static final long serialVersionUID = 3193388376146176763L;

	/** 
	 * null
	 */
	@ApiListField("tax_owe")
	@ApiField("ep_element")
	private List<EpElement> taxOwe;

	public void setTaxOwe(List<EpElement> taxOwe) {
		this.taxOwe = taxOwe;
	}
	public List<EpElement> getTaxOwe( ) {
		return this.taxOwe;
	}

}
