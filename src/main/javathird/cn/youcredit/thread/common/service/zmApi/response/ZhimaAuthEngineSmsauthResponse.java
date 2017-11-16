package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.engine.smsauth response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-07 10:47:27
 */
public class ZhimaAuthEngineSmsauthResponse extends ZhimaResponse {

	private static final long serialVersionUID = 4289454735635678628L;

	/** 
	 * 业务是否成功
	 */
	@ApiField("biz_success")
	private String bizSuccess;

	/** 
	 * 商户调用芝麻发短信的时候,芝麻发现用户已经授权就会直接返回,并且带openid参数
	 */
	@ApiField("open_id")
	private String openId;

	/** 
	 * 商户传递的透传数据,系统会重新回传给商户
	 */
	@ApiField("state")
	private String state;

	public void setBizSuccess(String bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public String getBizSuccess( ) {
		return this.bizSuccess;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId( ) {
		return this.openId;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getState( ) {
		return this.state;
	}

}
