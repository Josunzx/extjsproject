package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.EpInfo;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.pe.lawsuit.detail.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-07-06 15:22:58
 */
public class ZhimaCreditPeLawsuitDetailQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 7868893911763466491L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 个人涉诉信息元素
	 */
	@ApiField("lawsuit_detail")
	private EpInfo lawsuitDetail;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setLawsuitDetail(EpInfo lawsuitDetail) {
		this.lawsuitDetail = lawsuitDetail;
	}
	public EpInfo getLawsuitDetail( ) {
		return this.lawsuitDetail;
	}

}
