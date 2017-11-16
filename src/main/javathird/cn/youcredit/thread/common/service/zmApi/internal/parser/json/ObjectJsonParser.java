package cn.youcredit.thread.common.service.zmApi.internal.parser.json;

import cn.youcredit.thread.common.service.zmApi.SignItem;
import cn.youcredit.thread.common.service.zmApi.ZhimaApiException;
import cn.youcredit.thread.common.service.zmApi.ZhimaParser;
import cn.youcredit.thread.common.service.zmApi.ZhimaRequest;
import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.Converter;

/**
 * 单个JSON对象解释器。
 *
 * @author carver.gu
 * @param <T>
 * @since 1.0, Apr 11, 2010
 */
public class ObjectJsonParser<T extends ZhimaResponse> implements
        ZhimaParser<T> {

    private Class<T> clazz;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T parse(String rsp) throws ZhimaApiException {
        Converter converter = new JsonConverter();
        return converter.toResponse(rsp, this.clazz);
    }

    @Override
    public Class<T> getResponseClass() {
        return this.clazz;
    }

    /**
     * @see cn.youcredit.thread.common.service.zmApi.ZhimaParser#getSignItem(cn.youcredit.thread.common.service.zmApi.ZhimaRequest,
     *      cn.youcredit.thread.common.service.zmApi.ZhimaResponse)
     */
    @Override
    public SignItem getSignItem(ZhimaRequest<?> request, ZhimaResponse response)
            throws ZhimaApiException {

        Converter converter = new JsonConverter();

        return converter.getSignItem(request, response);
    }

}
