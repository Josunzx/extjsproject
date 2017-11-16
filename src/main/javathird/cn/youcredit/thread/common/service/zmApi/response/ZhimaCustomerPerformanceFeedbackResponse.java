package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.performance.feedback response.
 * 
 * @author auto create
 * @since 1.0, 2016-12-22 17:42:59
 */
public class ZhimaCustomerPerformanceFeedbackResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6783745885458411219L;

	/** 
	 * 
	 */
	@ApiField("biz_success")
	private String bizSuccess;

	public void setBizSuccess(String bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public String getBizSuccess( ) {
		return this.bizSuccess;
	}

}
