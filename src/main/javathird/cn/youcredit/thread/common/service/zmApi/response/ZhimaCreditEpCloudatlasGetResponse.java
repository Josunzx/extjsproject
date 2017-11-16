package cn.youcredit.thread.common.service.zmApi.response;

import java.util.List;

import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.domain.Edge;
import cn.youcredit.thread.common.service.zmApi.domain.Vertex;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiField;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.ep.cloudatlas.get response.
 * 
 * @author auto create
 * @since 1.0, 2017-06-21 09:19:45
 */
public class ZhimaCreditEpCloudatlasGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 2113358671783658237L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账。
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 云图编码
	 */
	@ApiField("cloudatlas_code")
	private String cloudatlasCode;

	/** 
	 * 边表列表，具体的字段内容含义参考产品说明文档
	 */
	@ApiListField("edges")
	@ApiField("edge")
	private List<Edge> edges;

	/** 
	 * 点表列表,具体的字段内容含义参考产品说明文档
	 */
	@ApiListField("vertexs")
	@ApiField("vertex")
	private List<Vertex> vertexs;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setCloudatlasCode(String cloudatlasCode) {
		this.cloudatlasCode = cloudatlasCode;
	}
	public String getCloudatlasCode( ) {
		return this.cloudatlasCode;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	public List<Edge> getEdges( ) {
		return this.edges;
	}

	public void setVertexs(List<Vertex> vertexs) {
		this.vertexs = vertexs;
	}
	public List<Vertex> getVertexs( ) {
		return this.vertexs;
	}

}
