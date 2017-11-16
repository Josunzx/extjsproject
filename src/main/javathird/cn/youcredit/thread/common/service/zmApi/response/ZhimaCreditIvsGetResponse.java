package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ivs.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-12 11:17:23
 */
public class ZhimaCreditIvsGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8115757145245592692L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * ivs评分。取值区间为[0,100]。分数越高，表示可信程度越高。0表示无对应数据。
	 */
	@ApiField("ivs_score")
	private Long ivsScore;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setIvsScore(Long ivsScore) {
		this.ivsScore = ivsScore;
	}
	public Long getIvsScore( ) {
		return this.ivsScore;
	}

}
