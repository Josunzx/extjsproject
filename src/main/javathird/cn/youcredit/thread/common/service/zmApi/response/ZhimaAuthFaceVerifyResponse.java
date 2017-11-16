package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.face.verify response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-29 13:11:30
 */
public class ZhimaAuthFaceVerifyResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6353635972695288431L;

	/** 
	 * 业务执行结果是否成功
	 */
	@ApiField("biz_success")
	private Boolean bizSuccess;

	/** 
	 * 一次请求的标识token
	 */
	@ApiField("token")
	private String token;

	public void setBizSuccess(Boolean bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public Boolean getBizSuccess( ) {
		return this.bizSuccess;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public String getToken( ) {
		return this.token;
	}

}
