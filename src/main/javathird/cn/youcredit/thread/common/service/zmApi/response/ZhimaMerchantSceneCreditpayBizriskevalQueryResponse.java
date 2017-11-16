package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.scene.creditpay.bizriskeval.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-07-20 22:17:50
 */
public class ZhimaMerchantSceneCreditpayBizriskevalQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3378873614962538397L;

	/** 
	 * 芝麻分
	 */
	@ApiField("zm_score")
	private String zmScore;

	public void setZmScore(String zmScore) {
		this.zmScore = zmScore;
	}
	public String getZmScore( ) {
		return this.zmScore;
	}

}
