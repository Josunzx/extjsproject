package cn.youcredit.thread.common.service.zmApi.domain;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * 资产信息
 *
 * @author auto create
 * @since 1.0, 2017-03-24 17:44:13
 */
public class AssetInfo extends ZhimaObject {

	private static final long serialVersionUID = 8862677594536833791L;

	/** 
	 * null
	 */
	@ApiListField("asset_list")
	@ApiField("ep_info")
	private List<EpInfo> assetList;

	public void setAssetList(List<EpInfo> assetList) {
		this.assetList = assetList;
	}
	public List<EpInfo> getAssetList( ) {
		return this.assetList;
	}

}
