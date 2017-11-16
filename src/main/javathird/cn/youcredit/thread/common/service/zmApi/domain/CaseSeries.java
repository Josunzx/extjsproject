package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 案件串联信息
 *
 * @author auto create
 * @since 1.0, 2017-03-21 23:21:05
 */
public class CaseSeries extends ZhimaObject {

	private static final long serialVersionUID = 3237158894635315975L;

	/** 
	 * null
	 */
	@ApiListField("case_series")
	@ApiField("ep_element")
	private List<EpElement> caseSeries;

	public void setCaseSeries(List<EpElement> caseSeries) {
		this.caseSeries = caseSeries;
	}
	public List<EpElement> getCaseSeries( ) {
		return this.caseSeries;
	}

}
