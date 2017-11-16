package cn.youcredit.thread.common.service.zmApi.response;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.AssetInfo;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ep.asset.freeze.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-05-09 15:54:12
 */
public class ZhimaCreditEpAssetFreezeGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 5775945449841886547L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 资产冻结信息
	 */
	@ApiField("user_asset_freeze_info")
	private AssetInfo userAssetFreezeInfo;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setUserAssetFreezeInfo(AssetInfo userAssetFreezeInfo) {
		this.userAssetFreezeInfo = userAssetFreezeInfo;
	}
	public AssetInfo getUserAssetFreezeInfo( ) {
		return this.userAssetFreezeInfo;
	}

}
