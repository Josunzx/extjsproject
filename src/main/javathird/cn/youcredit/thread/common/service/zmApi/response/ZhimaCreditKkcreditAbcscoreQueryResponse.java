package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.kkcredit.abcscore.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-22 15:59:07
 */
public class ZhimaCreditKkcreditAbcscoreQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3787283823149875316L;

	/** 
	 * 用户的芝麻卡卡信用分。分值范围[431,870]。如果用户数据不足，无法评分时，返回数值0。
	 */
	@ApiField("kkdabc_score")
	private Long kkdabcScore;

	public void setKkdabcScore(Long kkdabcScore) {
		this.kkdabcScore = kkdabcScore;
	}
	public Long getKkdabcScore( ) {
		return this.kkdabcScore;
	}

}
