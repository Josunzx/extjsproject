package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 税务信息
 *
 * @author auto create
 * @since 1.0, 2017-08-06 00:21:45
 */
public class TaxInfo extends ZhimaObject {

	private static final long serialVersionUID = 8354374847757812439L;

	/** 
	 * null
	 */
	@ApiListField("tax_invoice")
	@ApiField("ep_info")
	private List<EpInfo> taxInvoice;

	public void setTaxInvoice(List<EpInfo> taxInvoice) {
		this.taxInvoice = taxInvoice;
	}
	public List<EpInfo> getTaxInvoice( ) {
		return this.taxInvoice;
	}

}
