package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.profile.status.feedback response.
 * 
 * @author auto create
 * @since 1.0, 2016-03-31 14:36:04
 */
public class ZhimaProfileStatusFeedbackResponse extends ZhimaResponse {

	private static final long serialVersionUID = 2653768914575112554L;

	/** 
	 * 业务处理结果
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
