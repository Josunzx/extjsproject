package cn.youcredit.thread.common.service.zmApi.response;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.InfoItem;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.passinfo.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-12-30 14:33:47
 */
public class ZhimaCreditPassinfoGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3348283954955826579L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 信息基础单元列表List<InfoItem>， 其中每个信息基础单元包含key,value, name三个属性
	 */
	@ApiListField("info_items")
	@ApiField("info_item")
	private List<InfoItem> infoItems;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setInfoItems(List<InfoItem> infoItems) {
		this.infoItems = infoItems;
	}
	public List<InfoItem> getInfoItems( ) {
		return this.infoItems;
	}

}
