package cn.youcredit.thread.common.service.zmApi.domain;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * 扩展信息 例如对应的订单号
 *
 * @author auto create
 * @since 1.0, 2017-05-23 16:09:33
 */
public class ZmWatchListExtendInfo extends ZhimaObject {

	private static final long serialVersionUID = 1757687521993154388L;

	/** 
	 * 补充信息字段的中文描述
	 */
	@ApiField("description")
	private String description;

	/** 
	 * 补充信息字段的英文编码
	 */
	@ApiField("key")
	private String key;

	/** 
	 * 补充信息字段的信息内容
	 */
	@ApiField("value")
	private String value;

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription( ) {
		return this.description;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public String getKey( ) {
		return this.key;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getValue( ) {
		return this.value;
	}

}
