package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 案件串联列表
 *
 * @author auto create
 * @since 1.0, 2017-03-21 23:24:13
 */
public class CaseSeriesList extends ZhimaObject {

	private static final long serialVersionUID = 7844731446968698838L;

	/** 
	 * null
	 */
	@ApiListField("case_series_list")
	@ApiField("case_series")
	private List<CaseSeries> caseSeriesList;

	public void setCaseSeriesList(List<CaseSeries> caseSeriesList) {
		this.caseSeriesList = caseSeriesList;
	}
	public List<CaseSeries> getCaseSeriesList( ) {
		return this.caseSeriesList;
	}

}
