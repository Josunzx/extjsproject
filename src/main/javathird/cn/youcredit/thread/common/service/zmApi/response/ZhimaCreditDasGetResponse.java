package cn.youcredit.thread.common.service.zmApi.response;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.DasVariable;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.das.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-08-09 15:08:01
 */
public class ZhimaCreditDasGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8421266615427624714L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 芝麻信用元素表服务返回的元素列表, 即为签约时选择的变量列表。
	 */
	@ApiListField("vars")
	@ApiField("das_variable")
	private List<DasVariable> vars;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setVars(List<DasVariable> vars) {
		this.vars = vars;
	}
	public List<DasVariable> getVars( ) {
		return this.vars;
	}

}
