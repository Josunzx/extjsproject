package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.PunishmentList;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ep.commercial.punishment.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-12 17:32:48
 */
public class ZhimaCreditEpCommercialPunishmentQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 4475435465371517651L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 工商处罚信息
	 */
	@ApiField("user_punishment_info")
	private PunishmentList userPunishmentInfo;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setUserPunishmentInfo(PunishmentList userPunishmentInfo) {
		this.userPunishmentInfo = userPunishmentInfo;
	}
	public PunishmentList getUserPunishmentInfo( ) {
		return this.userPunishmentInfo;
	}

}
