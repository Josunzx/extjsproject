package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.data.single.feedback response.
 * 
 * @author auto create
 * @since 1.0, 2017-09-06 13:16:35
 */
public class ZhimaDataSingleFeedbackResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8594548956314324468L;

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
