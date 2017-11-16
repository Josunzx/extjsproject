package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.card.permit response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-12 10:48:28
 */
public class ZhimaCreditCardPermitResponse extends ZhimaResponse {

	private static final long serialVersionUID = 2115797583758892785L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 是否准入
	 */
	@ApiField("is_passed")
	private Boolean isPassed;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setIsPassed(Boolean isPassed) {
		this.isPassed = isPassed;
	}
	public Boolean getIsPassed( ) {
		return this.isPassed;
	}

}
