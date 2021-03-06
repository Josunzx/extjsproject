package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.kkcredit.abscore.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-18 13:35:14
 */
public class ZhimaCreditKkcreditAbscoreQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1479311756212322751L;

	/** 
	 * 用户的芝麻卡卡信用分。分值范围[429,832]。如果用户数据不足，无法评分时，返回数值0。
	 */
	@ApiField("kkdab_score")
	private Long kkdabScore;

	public void setKkdabScore(Long kkdabScore) {
		this.kkdabScore = kkdabScore;
	}
	public Long getKkdabScore( ) {
		return this.kkdabScore;
	}

}
