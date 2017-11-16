package cn.youcredit.thread.common.service.zmApi.response;

import java.util.Date;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.creditlife.preauth.unfreeze response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-04 10:25:40
 */
public class ZhimaMerchantCreditlifePreauthUnfreezeResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1192126561748562257L;

	/** 
	 * true:解冻成功;false:失败
	 */
	@ApiField("biz_success")
	private Boolean bizSuccess;

	/** 
	 * 资金解冻时间
	 */
	@ApiField("unfreeze_time")
	private Date unfreezeTime;

	public void setBizSuccess(Boolean bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public Boolean getBizSuccess( ) {
		return this.bizSuccess;
	}

	public void setUnfreezeTime(Date unfreezeTime) {
		this.unfreezeTime = unfreezeTime;
	}
	public Date getUnfreezeTime( ) {
		return this.unfreezeTime;
	}

}
