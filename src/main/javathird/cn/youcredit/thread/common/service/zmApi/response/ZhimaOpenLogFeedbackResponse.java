package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.open.log.feedback response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-02 15:23:56
 */
public class ZhimaOpenLogFeedbackResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3319362334159859725L;

	/** 
	 * 
	 */
	@ApiField("biz_success")
	private Boolean bizSuccess;

	public void setBizSuccess(Boolean bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public Boolean getBizSuccess( ) {
		return this.bizSuccess;
	}

}
