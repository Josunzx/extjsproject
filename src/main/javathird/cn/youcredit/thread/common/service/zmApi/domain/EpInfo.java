package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 企业征信基本信息
 *
 * @author auto create
 * @since 1.0, 2016-02-04 14:49:18
 */
public class EpInfo extends ZhimaObject {

	private static final long serialVersionUID = 7695938132615697727L;

	/** 
	 * 企业征信基本信息
	 */
	@ApiListField("ep_element_list")
	@ApiField("ep_element")
	private List<EpElement> epElementList;

	public void setEpElementList(List<EpElement> epElementList) {
		this.epElementList = epElementList;
	}
	public List<EpElement> getEpElementList( ) {
		return this.epElementList;
	}

}
