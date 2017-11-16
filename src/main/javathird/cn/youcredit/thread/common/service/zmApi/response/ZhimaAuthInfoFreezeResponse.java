package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.info.freeze response.
 * 
 * @author auto create
 * @since 1.0, 2016-03-31 14:34:57
 */
public class ZhimaAuthInfoFreezeResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3835535687897147161L;

	/** 
	 * 业务返回值，true代表成功
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
