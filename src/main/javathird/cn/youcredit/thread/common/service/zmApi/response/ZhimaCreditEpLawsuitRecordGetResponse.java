package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.LawsuitRecord;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ep.lawsuit.record.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-10 10:49:40
 */
public class ZhimaCreditEpLawsuitRecordGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 5367561716448944337L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账。
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 企业涉诉记录
	 */
	@ApiField("lawsuit_record")
	private LawsuitRecord lawsuitRecord;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setLawsuitRecord(LawsuitRecord lawsuitRecord) {
		this.lawsuitRecord = lawsuitRecord;
	}
	public LawsuitRecord getLawsuitRecord( ) {
		return this.lawsuitRecord;
	}

}
