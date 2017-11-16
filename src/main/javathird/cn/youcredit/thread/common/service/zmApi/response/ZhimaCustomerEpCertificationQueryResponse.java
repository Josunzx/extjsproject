package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.ep.certification.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-07-27 20:19:37
 */
public class ZhimaCustomerEpCertificationQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 5665718988611821772L;

	/** 
	 * 认证没有通过的原因
	 */
	@ApiField("failed_reason")
	private String failedReason;

	/** 
	 * 认证是否通过，通过为true，不通过为false
	 */
	@ApiField("passed")
	private String passed;

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}
	public String getFailedReason( ) {
		return this.failedReason;
	}

	public void setPassed(String passed) {
		this.passed = passed;
	}
	public String getPassed( ) {
		return this.passed;
	}

}
