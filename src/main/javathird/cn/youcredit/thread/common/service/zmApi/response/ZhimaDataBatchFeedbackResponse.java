package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.data.batch.feedback response.
 * 
 * @author auto create
 * @since 1.0, 2017-09-06 13:16:12
 */
public class ZhimaDataBatchFeedbackResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3446122859433823968L;

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
