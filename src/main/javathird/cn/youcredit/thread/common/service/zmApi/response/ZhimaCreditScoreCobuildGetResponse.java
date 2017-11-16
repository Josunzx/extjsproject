package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.score.cobuild.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-08 10:11:48
 */
public class ZhimaCreditScoreCobuildGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6726882795221636159L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账。
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 商户共创风险评分
	 */
	@ApiField("score")
	private String score;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setScore(String score) {
		this.score = score;
	}
	public String getScore( ) {
		return this.score;
	}

}
