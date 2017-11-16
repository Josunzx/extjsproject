package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.image.upload response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-02 14:53:50
 */
public class ZhimaMerchantImageUploadResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1411338776396952324L;

	/** 
	 * 图片在芝麻存储中的url地址
	 */
	@ApiField("image_id")
	private String imageId;

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getImageId( ) {
		return this.imageId;
	}

}
