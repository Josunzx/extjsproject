package cn.youcredit.thread.common.service.zmApi.internal.parser.xml;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Element;

import cn.youcredit.thread.common.service.zmApi.SignItem;
import cn.youcredit.thread.common.service.zmApi.ZhimaApiException;
import cn.youcredit.thread.common.service.zmApi.ZhimaConstants;
import cn.youcredit.thread.common.service.zmApi.ZhimaRequest;
import cn.youcredit.thread.common.service.zmApi.ZhimaResponse;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.Converter;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.Converters;
import cn.youcredit.thread.common.service.zmApi.internal.mapping.Reader;
import cn.youcredit.thread.common.service.zmApi.internal.util.StringUtils;
import cn.youcredit.thread.common.service.zmApi.internal.util.XmlUtils;

/**
 * JSON格式转换器。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class XmlConverter implements Converter {

    @Override
    public <T extends ZhimaResponse> T toResponse(String rsp, Class<T> clazz)
            throws ZhimaApiException {
        Element root = XmlUtils.getRootElementFromString(rsp);
        return this.getModelFromXML(root, clazz);
    }

    private <T> T getModelFromXML(final Element element, Class<T> clazz)
            throws ZhimaApiException {
        if (element == null) {
            return null;
        }

        return Converters.convert(clazz, new Reader() {
            @Override
            public boolean hasReturnField(Object name) {
                Element childE = XmlUtils.getChildElement(element,
                    (String) name);
                return childE != null;
            }

            @Override
            public Object getPrimitiveObject(Object name) {
                return XmlUtils.getElementValue(element, (String) name);
            }

            @Override
            public Object getObject(Object name, Class<?> type)
                    throws ZhimaApiException {
                Element childE = XmlUtils.getChildElement(element,
                    (String) name);
                if (childE != null) {
                    return XmlConverter.this.getModelFromXML(childE, type);
                } else {
                    return null;
                }
            }

            @Override
            public List<?> getListObjects(Object listName, Object itemName,
                    Class<?> subType) throws ZhimaApiException {
                List<Object> list = null;
                Element listE = XmlUtils.getChildElement(element,
                    (String) listName);

                if (listE != null) {
                    list = new ArrayList<>();
                    List<Element> itemEs = XmlUtils.getChildElements(listE,
                        (String) itemName);
                    for (Element itemE : itemEs) {
                        Object obj = null;
                        String value = XmlUtils.getElementValue(itemE);

                        if (String.class.isAssignableFrom(subType)) {
                            obj = value;
                        } else if (Long.class.isAssignableFrom(subType)) {
                            obj = Long.valueOf(value);
                        } else if (Integer.class.isAssignableFrom(subType)) {
                            obj = Integer.valueOf(value);
                        } else if (Boolean.class.isAssignableFrom(subType)) {
                            obj = Boolean.valueOf(value);
                        } else if (Date.class.isAssignableFrom(subType)) {
                            DateFormat format = new SimpleDateFormat(
                                ZhimaConstants.DATE_TIME_FORMAT);
                            try {
                                obj = format.parse(value);
                            } catch (ParseException e) {
                                throw new ZhimaApiException(e);
                            }
                        } else {
                            obj = XmlConverter.this.getModelFromXML(itemE,
                                subType);
                        }
                        if (obj != null) {
                            list.add(obj);
                        }
                    }
                }
                return list;
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
        String sign = XmlConverter.getSign(body);
        signItem.setSign(sign);

        // 签名源串
        String signSourceData = XmlConverter.getSignSourceData(request, body);
        signItem.setSignSourceDate(signSourceData);

        return signItem;
    }

    /**
     * @param request
     * @param body
     * @return
     */
    private static String getSignSourceData(ZhimaRequest<?> request, String body) {

        // XML不同的节点
        String rootNode = request.getApiMethodName().replace('.', '_')
            + ZhimaConstants.RESPONSE_SUFFIX;
        String errorRootNode = ZhimaConstants.ERROR_RESPONSE;

        int indexOfRootNode = body.indexOf(rootNode);
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        // 成功或者新版接口
        if (indexOfRootNode > 0) {

            return XmlConverter.parseSignSourceData(body, rootNode,
                indexOfRootNode);
            // 老版本接口
        } else if (indexOfErrorRoot > 0) {

            return XmlConverter.parseSignSourceData(body, errorRootNode,
                indexOfErrorRoot);
        } else {
            return null;
        }
    }

    /**
     * 获取签名
     *
     * @param body
     * @return
     */
    private static String getSign(String body) {

        String signNodeName = "<" + ZhimaConstants.SIGN + ">";
        String signEndNodeName = "</" + ZhimaConstants.SIGN + ">";

        int indexOfSignNode = body.indexOf(signNodeName);
        int indexOfSignEndNode = body.indexOf(signEndNodeName);

        if (indexOfSignNode < 0 || indexOfSignEndNode < 0) {
            return null;
        }

        //  签名
        return body.substring(indexOfSignNode + signNodeName.length(),
            indexOfSignEndNode);
    }

    /**
     * 签名源串
     *
     * @param body
     * @param rootNode
     * @param indexOfRootNode
     * @return
     */
    private static String parseSignSourceData(String body, String rootNode,
            int indexOfRootNode) {

        //  第一个字母+长度+>
        int signDataStartIndex = indexOfRootNode + rootNode.length() + 1;
        int indexOfSign = body.indexOf("<" + ZhimaConstants.SIGN);

        if (indexOfSign < 0) {

            return null;
        }

        // 签名前减去
        int signDataEndIndex = indexOfSign;

        return body.substring(signDataStartIndex, signDataEndIndex);
    }
}
