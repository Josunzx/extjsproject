package cn.youcredit.thread.common.service.zmApi.domain;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ivs的细节信息
 *
 * @author auto create
 * @since 1.0, 2015-12-28 20:50:06
 */
public class IvsDetail extends ZhimaObject {

	private static final long serialVersionUID = 4125929958777535427L;

	/** 
	 * 风险因素code
	 */
	@ApiField("code")
	private String code;

	/** 
	 * 风险描述说明
	 */
	@ApiField("description")
	private String description;

	public void setCode(String code) {
		this.code = code;
	}
	public String getCode( ) {
		return this.code;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription( ) {
		return this.description;
	}

}
