package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.ep.certification.initialize response.
 * 
 * @author auto create
 * @since 1.0, 2017-07-27 20:20:02
 */
public class ZhimaCustomerEpCertificationInitializeResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1636888655955829333L;

	/** 
	 * 本次认证的唯一标识，商户需要记录，biz_no有效期为23小时
	 */
	@ApiField("biz_no")
	private String bizNo;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

}
