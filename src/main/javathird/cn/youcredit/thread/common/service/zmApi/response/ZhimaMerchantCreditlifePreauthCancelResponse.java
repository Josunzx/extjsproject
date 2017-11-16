package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.creditlife.preauth.cancel response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-04 10:25:57
 */
public class ZhimaMerchantCreditlifePreauthCancelResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3228934763814427247L;

	/** 
	 * 显示入参的外部订单号
	 */
	@ApiField("out_order_no")
	private String outOrderNo;

	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	public String getOutOrderNo( ) {
		return this.outOrderNo;
	}

}
