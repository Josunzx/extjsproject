package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.contract.initialize response.
 * 
 * @author auto create
 * @since 1.0, 2017-09-19 14:41:27
 */
public class ZhimaCustomerContractInitializeResponse extends ZhimaResponse {

	private static final long serialVersionUID = 7512676277919895265L;

	/** 
	 * 电子合约号，后续的电子签名流程需要用到
	 */
	@ApiField("contract_no")
	private String contractNo;

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractNo( ) {
		return this.contractNo;
	}

}
