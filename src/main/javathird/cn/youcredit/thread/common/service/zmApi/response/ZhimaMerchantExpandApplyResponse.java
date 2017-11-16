package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.expand.apply response.
 * 
 * @author auto create
 * @since 1.0, 2017-05-16 11:44:21
 */
public class ZhimaMerchantExpandApplyResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1545432523284312594L;

	/** 
	 * 二级商户标识
	 */
	@ApiField("linked_merchant_id")
	private String linkedMerchantId;

	public void setLinkedMerchantId(String linkedMerchantId) {
		this.linkedMerchantId = linkedMerchantId;
	}
	public String getLinkedMerchantId( ) {
		return this.linkedMerchantId;
	}

}
