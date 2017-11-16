package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.zhima.cust.certify.initial response.
 * 
 * @author auto create
 * @since 1.0, 2016-03-31 14:34:57
 */
public class ZhimaAuthZhimaCustCertifyInitialResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8188593731554179243L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号，发起页面认证请求和认证请求结果查询接口都需要使用到该返回值作为入参。后续可以通过此业务号进行流水比对
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
