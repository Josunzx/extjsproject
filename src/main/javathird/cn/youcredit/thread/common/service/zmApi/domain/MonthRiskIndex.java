package cn.youcredit.thread.common.service.zmApi.domain;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * 每月对应的风险指数
 *
 * @author auto create
 * @since 1.0, 2017-01-16 15:19:23
 */
public class MonthRiskIndex extends ZhimaObject {

	private static final long serialVersionUID = 5838719988138312462L;

	/** 
	 * 月份，格式为yyyyMM
	 */
	@ApiField("month")
	private String month;

	/** 
	 * 风险指数，整数
	 */
	@ApiField("risk_index")
	private Long riskIndex;

	public void setMonth(String month) {
		this.month = month;
	}
	public String getMonth( ) {
		return this.month;
	}

	public void setRiskIndex(Long riskIndex) {
		this.riskIndex = riskIndex;
	}
	public Long getRiskIndex( ) {
		return this.riskIndex;
	}

}
