package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.borrow.scan response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-18 16:38:23
 */
public class ZhimaCustomerBorrowScanResponse extends ZhimaResponse {

	private static final long serialVersionUID = 4767762141624627135L;

	/** 
	 * 
	 */
	@ApiField("category")
	private String category;

	/** 
	 * 
	 */
	@ApiField("goods_id")
	private String goodsId;

	/** 
	 * 
	 */
	@ApiField("goods_name")
	private String goodsName;

	/** 
	 * 
	 */
	@ApiField("scene")
	private String scene;

	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory( ) {
		return this.category;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsId( ) {
		return this.goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsName( ) {
		return this.goodsName;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}
	public String getScene( ) {
		return this.scene;
	}

}
