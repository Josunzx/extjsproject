package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.scene.creditpay.signriskeval.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-07-20 22:17:31
 */
public class ZhimaMerchantSceneCreditpaySignriskevalQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8352198979417456368L;

	/** 
	 * openId
	 */
	@ApiField("open_id")
	private String openId;

	/** 
	 * 芝麻分
	 */
	@ApiField("zm_score")
	private String zmScore;

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId( ) {
		return this.openId;
	}

	public void setZmScore(String zmScore) {
		this.zmScore = zmScore;
	}
	public String getZmScore( ) {
		return this.zmScore;
	}

}
