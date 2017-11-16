package cn.youcredit.thread.common.service.zmApi.response;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.OperationalReport;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.ep.operationalreport.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-19 10:05:13
 */
public class ZhimaCreditEpOperationalreportGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6333496856914351788L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账。
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 0:表示经营报告无效
1:表示经营报告有效
	 */
	@ApiField("is_valid")
	private String isValid;

	/** 
	 * 经营报告数据列表
	 */
	@ApiListField("report_data")
	@ApiField("operational_report")
	private List<OperationalReport> reportData;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getIsValid( ) {
		return this.isValid;
	}

	public void setReportData(List<OperationalReport> reportData) {
		this.reportData = reportData;
	}
	public List<OperationalReport> getReportData( ) {
		return this.reportData;
	}

}
