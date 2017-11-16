package cn.youcredit.thread.common.service.zmApi;

/**
 * 响应解释器接口。响应格式可以是JSON, XML等等。
 *
 * @author carver.gu
 * @param <T>
 * @since 1.0, Apr 11, 2010
 */
public interface ZhimaParser<T extends ZhimaResponse> {

    /**
     * 把响应字符串解释成相应的领域对象。
     *
     * @param rsp
     *        响应字符串
     * @return 领域对象
     * @throws ZhimaApiException
     */
    public T parse(String rsp) throws ZhimaApiException;

    /**
     * 获取响应类类型。
     *
     * @return
     * @throws ZhimaApiException
     */
    public Class<T> getResponseClass() throws ZhimaApiException;

    /**
     * 获取响应内的签名数据
     * 
     * @param request
     * @param response
     *        响应字符串
     * @return
     * @throws ZhimaApiException
     */
    public SignItem getSignItem(ZhimaRequest<?> request, ZhimaResponse response)
            throws ZhimaApiException;

}
