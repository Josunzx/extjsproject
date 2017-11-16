package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.data.upload.initialize response.
 * 
 * @author auto create
 * @since 1.0, 2017-04-28 14:30:00
 */
public class ZhimaMerchantDataUploadInitializeResponse extends ZhimaResponse {

	private static final long serialVersionUID = 2385266586511745959L;

	/** 
	 * 模板文件url地址
	 */
	@ApiField("template_url")
	private String templateUrl;

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}
	public String getTemplateUrl( ) {
		return this.templateUrl;
	}

}
