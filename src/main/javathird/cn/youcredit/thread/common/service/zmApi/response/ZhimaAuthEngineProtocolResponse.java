package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.engine.protocol response.
 * 
 * @author auto create
 * @since 1.0, 2017-07-26 21:18:54
 */
public class ZhimaAuthEngineProtocolResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1496985963553225456L;

	/** 
	 * 27位openId，用于标识芝麻会员在商户端的身份标识
	 */
	@ApiField("open_id")
	private String openId;

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId( ) {
		return this.openId;
	}

}
