package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 处罚信息
 *
 * @author auto create
 * @since 1.0, 2017-03-21 23:19:17
 */
public class Punishment extends ZhimaObject {

	private static final long serialVersionUID = 4524188577333876871L;

	/** 
	 * null
	 */
	@ApiListField("punishment")
	@ApiField("ep_element")
	private List<EpElement> punishment;

	public void setPunishment(List<EpElement> punishment) {
		this.punishment = punishment;
	}
	public List<EpElement> getPunishment( ) {
		return this.punishment;
	}

}
