package cn.youcredit.thread.common.service.zmApi.domain;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * 信用记录按场景每月次数
 *
 * @author auto create
 * @since 1.0, 2017-08-14 16:55:20
 */
public class CreditRecordMonthlyCount extends ZhimaObject {

	private static final long serialVersionUID = 8476295121879441849L;

	/** 
	 * 信用业务场景
	 */
	@ApiField("biz_scene_code")
	private String bizSceneCode;

	/** 
	 * null
	 */
	@ApiField("biz_scene_name")
	private String bizSceneName;

	/** 
	 * 信用记录次数
	 */
	@ApiField("credit_record_count")
	private Long creditRecordCount;

	public void setBizSceneCode(String bizSceneCode) {
		this.bizSceneCode = bizSceneCode;
	}
	public String getBizSceneCode( ) {
		return this.bizSceneCode;
	}

	public void setBizSceneName(String bizSceneName) {
		this.bizSceneName = bizSceneName;
	}
	public String getBizSceneName( ) {
		return this.bizSceneName;
	}

	public void setCreditRecordCount(Long creditRecordCount) {
		this.creditRecordCount = creditRecordCount;
	}
	public Long getCreditRecordCount( ) {
		return this.creditRecordCount;
	}

}
