package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.borrow.restore response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-18 16:19:24
 */
public class ZhimaCustomerBorrowRestoreResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8535896192591711564L;

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
