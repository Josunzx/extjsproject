package cn.youcredit.thread.common.service.zmApi.response;

import java.util.Date;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.creditlife.withhold.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-04 10:25:21
 */
public class ZhimaMerchantCreditlifeWithholdQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8187595516298981876L;

	/** 
	 * 代扣签约产生的合约号
	 */
	@ApiField("agreement_no")
	private String agreementNo;

	/** 
	 * 失效日期
	 */
	@ApiField("invalid_time")
	private Date invalidTime;

	/** 
	 * 生效时间
	 */
	@ApiField("valid_time")
	private Date validTime;

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}
	public String getAgreementNo( ) {
		return this.agreementNo;
	}

	public void setInvalidTime(Date invalidTime) {
		this.invalidTime = invalidTime;
	}
	public Date getInvalidTime( ) {
		return this.invalidTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	public Date getValidTime( ) {
		return this.validTime;
	}

}
