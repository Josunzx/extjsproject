package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.certify.initial response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-19 11:23:32
 */
public class ZhimaCustomerCertifyInitialResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3117562929326896976L;

	/** 
	 * 芝麻认证每一次请求返回的令牌，发起页面认证请求和认证请求结果查询接口都需要使用到该返回值作为入参
	 */
	@ApiField("token")
	private String token;

	public void setToken(String token) {
		this.token = token;
	}
	public String getToken( ) {
		return this.token;
	}

}
