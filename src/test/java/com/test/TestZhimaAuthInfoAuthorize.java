package com.test;

import cn.youcredit.thread.common.service.zmApi.DefaultZhimaClient;
import cn.youcredit.thread.common.service.zmApi.ZhimaApiException;
import cn.youcredit.thread.common.service.zmApi.request.ZhimaAuthInfoAuthorizeRequest;

public class TestZhimaAuthInfoAuthorize {
    //芝麻开放平台地址
    private String gatewayUrl = "https://zmopenapi.zmxy.com.cn/openapi.do";
    //商户应用 Id
    private String appId = "***";
    //商户 RSA 私钥
    private String privateKey = "***";
    //芝麻 RSA 公钥
    private String zhimaPublicKey = "***";

    public void testZhimaAuthInfoAuthorize() {
        ZhimaAuthInfoAuthorizeRequest req = new ZhimaAuthInfoAuthorizeRequest();
        req.setChannel("apppc");
        req.setPlatform("zmop");
        req.setIdentityType("2");// 必要参数
        req.setIdentityParam("{\"name\":\"张三\",\"certType\":\"IDENTITY_CARD\",\"certNo\":\"330100xxxxxxxxxxxx\"}");// 必要参数
        req.setBizParams("{\"auth_code\":\"M_H5\",\"channelType\":\"app\",\"state\":\"商户自定义\"}");//
        DefaultZhimaClient client = new DefaultZhimaClient(this.gatewayUrl,
            this.appId, this.privateKey, this.zhimaPublicKey);
        try {
            String url = client.generatePageRedirectInvokeUrl(req);
            System.out.println(url);
        } catch (ZhimaApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestZhimaAuthInfoAuthorize result = new TestZhimaAuthInfoAuthorize();
        result.testZhimaAuthInfoAuthorize();
    }
}