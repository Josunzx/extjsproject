package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.CompanyInfo;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ep.info.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-06 11:44:47
 */
public class ZhimaCreditEpInfoGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1215856656447595667L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账。
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 企业工商基本信息
	 */
	@ApiField("company_info")
	private CompanyInfo companyInfo;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
	public CompanyInfo getCompanyInfo( ) {
		return this.companyInfo;
	}

}
