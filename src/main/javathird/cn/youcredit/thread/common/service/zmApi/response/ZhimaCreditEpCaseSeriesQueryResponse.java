package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.CaseSeriesList;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ep.case.series.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-12 17:31:56
 */
public class ZhimaCreditEpCaseSeriesQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6369471677497159997L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 用户案件串联信息
	 */
	@ApiField("user_case_series_info")
	private CaseSeriesList userCaseSeriesInfo;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setUserCaseSeriesInfo(CaseSeriesList userCaseSeriesInfo) {
		this.userCaseSeriesInfo = userCaseSeriesInfo;
	}
	public CaseSeriesList getUserCaseSeriesInfo( ) {
		return this.userCaseSeriesInfo;
	}

}
