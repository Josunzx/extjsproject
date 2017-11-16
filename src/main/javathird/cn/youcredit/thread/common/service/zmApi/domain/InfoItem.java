package cn.youcredit.thread.common.service.zmApi.domain;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * 单元包含三个属性：key, value, name; 其中name为中文描述
 *
 * @author auto create
 * @since 1.0, 2016-11-22 10:28:17
 */
public class InfoItem extends ZhimaObject {

	private static final long serialVersionUID = 2687988714178264667L;

	/** 
	 * 键值对中对应的key
	 */
	@ApiField("key")
	private String key;

	/** 
	 * 键值对中文描述
	 */
	@ApiField("name")
	private String name;

	/** 
	 * 键值对中的值
	 */
	@ApiField("value")
	private String value;

	public void setKey(String key) {
		this.key = key;
	}
	public String getKey( ) {
		return this.key;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName( ) {
		return this.name;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getValue( ) {
		return this.value;
	}

}
