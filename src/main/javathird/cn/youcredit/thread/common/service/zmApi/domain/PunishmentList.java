package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 处罚信息列表
 *
 * @author auto create
 * @since 1.0, 2017-03-21 23:22:51
 */
public class PunishmentList extends ZhimaObject {

	private static final long serialVersionUID = 2517873285367348673L;

	/** 
	 * null
	 */
	@ApiListField("punishment_list")
	@ApiField("punishment")
	private List<Punishment> punishmentList;

	public void setPunishmentList(List<Punishment> punishmentList) {
		this.punishmentList = punishmentList;
	}
	public List<Punishment> getPunishmentList( ) {
		return this.punishmentList;
	}

}
