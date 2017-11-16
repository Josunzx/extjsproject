package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.info.authquery response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-07 10:48:13
 */
public class ZhimaAuthInfoAuthqueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6438626981669352526L;

	/** 
	 * 用户是否对该应用授权
	 */
	@ApiField("authorized")
	private Boolean authorized;

	/** 
	 * 
	 */
	@ApiField("open_id")
	private String openId;

	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}
	public Boolean getAuthorized( ) {
		return this.authorized;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId( ) {
		return this.openId;
	}

}
