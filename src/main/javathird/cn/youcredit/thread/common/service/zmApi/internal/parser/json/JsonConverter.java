package cn.youcredit.thread.common.service.zmApi.internal.parser.json;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.youcredit.thread.common.service.zmApi.SignItem;
import cn.youcredit.thread.common.service.zmApi.ZhimaApiException;
import cn.youcredit.thread.common.service.zmApi.ZhimaConstants;
import cn.youcredit.thread.common.service.zmApi.ZhimaRequest;
import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.Converter;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.Converters;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.Reader;
import cn.youcredit.thread.common.service.zmApi.internal.util.StringUtils;
import cn.youcredit.thread.common.service.zmApi.internal.util.json.ExceptionErrorListener;
import cn.youcredit.thread.common.service.zmApi.internal.util.json.JSONReader;
import cn.youcredit.thread.common.service.zmApi.internal.util.json.JSONValidatingReader;

/**
 * JSON格式转换器。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class JsonConverter implements Converter {

    @Override
    public <T extends ZhimaResponse> T toResponse(String rsp, Class<T> clazz)
            throws ZhimaApiException {
        JSONReader reader = new JSONValidatingReader(
            new ExceptionErrorListener());
        Object rspObj = reader.read(rsp);
        if (rspObj instanceof Map<?, ?>) {
            Map<?, ?> rspJson = (Map<?, ?>) rspObj;
            return this.fromJson(rspJson, clazz);
        }
        return null;
    }

    /**
     * 把JSON格式的数据转换为对象。
     *
     * @param <T>
     *        泛型领域对象
     * @param json
     *        JSON格式的数据
     * @param clazz
     *        泛型领域类型
     * @return 领域对象
     * @throws ZhimaApiException
     */
    public <T> T fromJson(final Map<?, ?> json, Class<T> clazz)
            throws ZhimaApiException {
        return Converters.convert(clazz, new Reader() {
            @Override
            public boolean hasReturnField(Object name) {
                return json.containsKey(name);
            }

            @Override
            public Object getPrimitiveObject(Object name) {
                return json.get(name);
            }

            @Override
            public Object getObject(Object name, Class<?> type)
                    throws ZhimaApiException {
                Object tmp = json.get(name);
                if (tmp instanceof Map<?, ?>) {
                    Map<?, ?> map = (Map<?, ?>) tmp;
                    return JsonConverter.this.fromJson(map, type);
                } else {
                    return null;
                }
            }

            @Override
            public List<?> getListObjects(Object listName, Object itemName,
                    Class<?> subType) throws ZhimaApiException {
                List<Object> listObjs = null;

                Object listTmp = json.get(listName);
                if (listTmp instanceof Map<?, ?>) {
                    Map<?, ?> jsonMap = (Map<?, ?>) listTmp;
                    Object itemTmp = jsonMap.get(itemName);
                    if (itemTmp == null && listName != null) {
                        String listNameStr = listName.toString();
                        itemTmp = jsonMap.get(listNameStr.substring(0,
                            listNameStr.length() - 1));
                    }
                    if (itemTmp instanceof List<?>) {
                        listObjs = this.getListObjectsInner(subType, itemTmp);
                    }
                } else if (listTmp instanceof List<?>) {
                    listObjs = this.getListObjectsInner(subType, listTmp);
                }

                return listObjs;
            }

            private List<Object> getListObjectsInner(Class<?> subType,
                    Object itemTmp) throws ZhimaApiException {
                List<Object> listObjs;
                listObjs = new ArrayList<>();
                List<?> tmpList = (List<?>) itemTmp;
                for (Object subTmp : tmpList) {
                    Object obj = null;
                    if (String.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Long.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Integer.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Boolean.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Date.class.isAssignableFrom(subType)) {
                        DateFormat format = new SimpleDateFormat(
                            ZhimaConstants.DATE_TIME_FORMAT);
                        try {
                            obj = format.parse(String.valueOf(subTmp));
                        } catch (ParseException e) {
                            throw new ZhimaApiException(e);
                        }
                    } else if (subTmp instanceof Map<?, ?>) {// object
                        Map<?, ?> subMap = (Map<?, ?>) subTmp;
                        obj = JsonConverter.this.fromJson(subMap, subType);
                    }

                    if (obj != null) {
                        listObjs.add(obj);
                    }
                }
                return listObjs;
            }

        });
    }

    /**
     * @see cn.youcredit.thread.common.service.zmApi.internal.mapping.Converter#getSignItem(cn.youcredit.thread.common.service.zmApi.ZhimaRequest,
     *      cn.youcredit.thread.common.service.zmApi.ZhimaResponse)
     */
    @Override
    public SignItem getSignItem(ZhimaRequest<?> request, ZhimaResponse response) {

        String body = response.getBody();

        // 响应为空则直接返回
        if (StringUtils.isEmpty(body)) {

            return null;
        }

        SignItem signItem = new SignItem();

        // 获取签名
        String sign = JsonConverter.getSign(body);
        signItem.setSign(sign);

        // 签名源串
        String signSourceData = JsonConverter.getSignSourceData(request, body);
        signItem.setSignSourceDate(signSourceData);

        return signItem;
    }

    /**
     * @param request
     * @param body
     * @return
     */
    private static String getSignSourceData(ZhimaRequest<?> request, String body) {

        // 加签源串起点
        String rootNode = request.getApiMethodName().replace('.', '_')
            + ZhimaConstants.RESPONSE_SUFFIX;
        String errorRootNode = ZhimaConstants.ERROR_RESPONSE;

        int indexOfRootNode = body.indexOf(rootNode);
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        // 成功或者新版接口
        if (indexOfRootNode > 0) {

            return JsonConverter.parseSignSourceData(body, rootNode,
                indexOfRootNode);

            // 老版本失败接口
        } else if (indexOfErrorRoot > 0) {

            return JsonConverter.parseSignSourceData(body, errorRootNode,
                indexOfErrorRoot);
        } else {
            return null;
        }
    }

    /**
     * 获取签名源串内容
     *
     * @param body
     * @param rootNode
     * @param indexOfRootNode
     * @return
     */
    private static String parseSignSourceData(String body, String rootNode,
            int indexOfRootNode) {

        //  第一个字母+长度+引号和分号
        int signDataStartIndex = indexOfRootNode + rootNode.length() + 2;
        int indexOfSign = body.indexOf("\"" + ZhimaConstants.SIGN + "\"");

        if (indexOfSign < 0) {

            return null;
        }

        // 签名前-逗号
        int signDataEndIndex = indexOfSign - 1;

        return body.substring(signDataStartIndex, signDataEndIndex);
    }

    /**
     * 获取签名
     *
     * @param body
     * @return
     */
    private static String getSign(String body) {

        JSONReader reader = new JSONValidatingReader(
            new ExceptionErrorListener());
        Object rootObj = reader.read(body);
        Map<?, ?> rootJson = (Map<?, ?>) rootObj;

        return (String) rootJson.get(ZhimaConstants.SIGN);
    }

}
