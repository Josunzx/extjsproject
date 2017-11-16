package cn.youcredit.thread.common.service.zmApi.response;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.ZmWatchListDetail;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.watchlistii.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-09 16:53:21
 */
public class ZhimaCreditWatchlistiiGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1359889421782695999L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 行业关注名单信息列表，由芝麻信用进行维护和升级
	 */
	@ApiListField("details")
	@ApiField("zm_watch_list_detail")
	private List<ZmWatchListDetail> details;

	/** 
	 * true=命中 在关注名单中
false=未命中
	 */
	@ApiField("is_matched")
	private Boolean isMatched;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setDetails(List<ZmWatchListDetail> details) {
		this.details = details;
	}
	public List<ZmWatchListDetail> getDetails( ) {
		return this.details;
	}

	public void setIsMatched(Boolean isMatched) {
		this.isMatched = isMatched;
	}
	public Boolean getIsMatched( ) {
		return this.isMatched;
	}

}
