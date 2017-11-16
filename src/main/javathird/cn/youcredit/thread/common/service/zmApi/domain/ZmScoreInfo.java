package cn.youcredit.thread.common.service.zmApi.domain;

import cn.youcredit.thread.common.service.zmApi.ZhimaObject;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;

/**
 * 芝麻分及其变动情况
 *
 * @author auto create
 * @since 1.0, 2017-07-21 15:06:29
 */
public class ZmScoreInfo extends ZhimaObject {

	private static final long serialVersionUID = 4159632532679169636L;

	/** 
	 * null
	 */
	@ApiField("zm_score")
	private String zmScore;

	/** 
	 * null
	 */
	@ApiField("zm_score_change")
	private String zmScoreChange;

	public void setZmScore(String zmScore) {
		this.zmScore = zmScore;
	}
	public String getZmScore( ) {
		return this.zmScore;
	}

	public void setZmScoreChange(String zmScoreChange) {
		this.zmScoreChange = zmScoreChange;
	}
	public String getZmScoreChange( ) {
		return this.zmScoreChange;
	}

}
