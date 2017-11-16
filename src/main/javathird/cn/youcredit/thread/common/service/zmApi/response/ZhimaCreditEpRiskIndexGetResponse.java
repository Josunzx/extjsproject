package cn.youcredit.thread.common.service.zmApi.response;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.RiskIndex;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.ep.risk.index.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-12 17:33:35
 */
public class ZhimaCreditEpRiskIndexGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8139593264263264855L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 风险指数
	 */
	@ApiListField("risk_index")
	@ApiField("risk_index")
	private List<RiskIndex> riskIndex;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setRiskIndex(List<RiskIndex> riskIndex) {
		this.riskIndex = riskIndex;
	}
	public List<RiskIndex> getRiskIndex( ) {
		return this.riskIndex;
	}

}
