package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.face.init response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-23 17:18:57
 */
public class ZhimaAuthFaceInitResponse extends ZhimaResponse {

	private static final long serialVersionUID = 2571831833532861166L;

	/** 
	 * 请求返回的加密串
	 */
	@ApiField("auth_msg")
	private String authMsg;

	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}
	public String getAuthMsg( ) {
		return this.authMsg;
	}

}
