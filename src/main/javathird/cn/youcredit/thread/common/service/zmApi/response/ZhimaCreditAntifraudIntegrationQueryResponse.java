package cn.youcredit.thread.common.service.zmApi.response;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.antifraud.integration.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-02 14:55:36
 */
public class ZhimaCreditAntifraudIntegrationQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 4158144158626733183L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 欺诈关注清单是否命中，yes标识命中，no标识未命中
	 */
	@ApiField("hit_risk")
	private String hitRisk;

	/** 
	 * 欺诈关注清单的RiskCode列表，对应的描述见产品文档
	 */
	@ApiListField("risk_code")
	@ApiField("string")
	private List<String> riskCode;

	/** 
	 * 申请欺诈评分，分数范围是[0,100]的整数,分数越高信息越真实
	 */
	@ApiField("score")
	private Long score;

	/** 
	 * 欺诈信息验证，输出验证码verifyCode列表,verifyCode和文案的映射关系参见"产品接口说明"
	 */
	@ApiListField("verify_code")
	@ApiField("string")
	private List<String> verifyCode;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setHitRisk(String hitRisk) {
		this.hitRisk = hitRisk;
	}
	public String getHitRisk( ) {
		return this.hitRisk;
	}

	public void setRiskCode(List<String> riskCode) {
		this.riskCode = riskCode;
	}
	public List<String> getRiskCode( ) {
		return this.riskCode;
	}

	public void setScore(Long score) {
		this.score = score;
	}
	public Long getScore( ) {
		return this.score;
	}

	public void setVerifyCode(List<String> verifyCode) {
		this.verifyCode = verifyCode;
	}
	public List<String> getVerifyCode( ) {
		return this.verifyCode;
	}

}
