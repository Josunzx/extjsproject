package cn.youcredit.thread.common.service.zmApi.domain;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * 芝麻数据服务变量结果
 *
 * @author auto create
 * @since 1.0, 2016-02-01 10:08:34
 */
public class DasVariable extends ZhimaObject {

	private static final long serialVersionUID = 7867457368236868377L;

	/** 
	 * 芝麻变量服务返回的变量名
	 */
	@ApiField("key")
	private String key;

	/** 
	 * 芝麻变量服务返回的变量值
	 */
	@ApiField("value")
	private String value;

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
