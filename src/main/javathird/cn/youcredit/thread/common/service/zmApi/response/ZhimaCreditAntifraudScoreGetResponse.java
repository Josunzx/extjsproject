package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.antifraud.score.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-02 14:55:56
 */
public class ZhimaCreditAntifraudScoreGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1459374857526435514L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 申请欺诈评分，分数范围是[0,100]的整数,分数越高信息越真实
	 */
	@ApiField("score")
	private Long score;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setScore(Long score) {
		this.score = score;
	}
	public Long getScore( ) {
		return this.score;
	}

}
