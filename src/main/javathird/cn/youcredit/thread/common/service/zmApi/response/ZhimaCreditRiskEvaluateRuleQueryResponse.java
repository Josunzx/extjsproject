package cn.youcredit.thread.common.service.zmApi.response;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.RiskEvaluateRuleInfo;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.risk.evaluate.rule.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-29 14:03:10
 */
public class ZhimaCreditRiskEvaluateRuleQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 7235971817687436183L;

	/** 
	 * 对应规则配置信息列表
	 */
	@ApiListField("rule_infos")
	@ApiField("risk_evaluate_rule_info")
	private List<RiskEvaluateRuleInfo> ruleInfos;

	public void setRuleInfos(List<RiskEvaluateRuleInfo> ruleInfos) {
		this.ruleInfos = ruleInfos;
	}
	public List<RiskEvaluateRuleInfo> getRuleInfos( ) {
		return this.ruleInfos;
	}

}
