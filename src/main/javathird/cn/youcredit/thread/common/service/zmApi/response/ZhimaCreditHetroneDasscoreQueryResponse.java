package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.hetrone.dasscore.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-09-07 14:52:06
 */
public class ZhimaCreditHetroneDasscoreQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1244258264263169777L;

	/** 
	 * 共创das分
	 */
	@ApiField("das_score")
	private Long dasScore;

	public void setDasScore(Long dasScore) {
		this.dasScore = dasScore;
	}
	public Long getDasScore( ) {
		return this.dasScore;
	}

}
