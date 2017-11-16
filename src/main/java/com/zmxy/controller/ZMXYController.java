package com.zmxy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.youcredit.thread.common.service.zmApi.DefaultZhimaClient;
import cn.youcredit.thread.common.service.zmApi.ZhimaApiException;
import cn.youcredit.thread.common.service.zmApi.request.ZhimaAuthInfoAuthorizeRequest;

@Controller
@RequestMapping("/zmxy")
public class ZMXYController {
    //芝麻开放平台地址
    private String gatewayUrl = "https://zmopenapi.zmxy.com.cn/openapi.do";
    //商户应用 Id
    private String appId = "300000332";
    //商户 RSA 私钥
    private String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMwSQV/g2TY4nWKxA4CguSfouA1eVJbpQ/K3biLfypYx6wo7WYyiJDoG+WUz4FaxKSjlq13ZJcdtioky95sq3lPVWJTp7TgkPVqL54Vc97Ewo8gn3QNzGztv+Ep7enka4l6aexGkdEMcdOxuV2gYIpk5jakEvTcqS+AZsdn5CU6LAgMBAAECgYBHn9imKCrUpwZGT06lZMPXyAxhVMxnszOQCuVzBAz8rkSKcM47V+VTIIOEC7Mfekqx+fotlDt4RXAsO2FAaslhDj2GDr2tWy7r+0YY4LOGi56eWQRN658PcXuSZV6/b8GV2saQ2/+xKMsGvw1Jf4/y7QwZC7vQAHa4ur9DlIvHsQJBAPdBT6MBtY6Et6urVoGAow3nIMslJT3UKy8OdWczRrp+KQoBWYq3WP3yJT184AFcMjiXzuwxHkL5foeq9xoAOM8CQQDTSfNtkH4DHuzie3xaoDhqODxYZIrZZ3A6YVeHQUoIPBSpYOeM4JUsdxM0R/j/w/LNEDpNBjZ13CaRYaeNpEWFAkEAyO7nk/XQoMhUJwtvmoB6gdLhwJUoRa3FhlE+saZnBSl/mmTsaqGDjaQaBXUU6aYOHhWokCN+jzkITaJve07Q2wJBAMlqxsccpjO9aF6jDzGpaP5BK62r8v068S6GGxWR9MwS0jOBcFrIwQwJW2JMdh8DodNAdAN3N7V1L8MJj9ujzK0CQQCHJ+WfD3EC32PMhenmpKmdC8M1oEZ+W/COFkR4dhRazFnOjFStOTLMJ8yivAmAwhGXuheu0AOaBuTZEzTtwpbk";
    //芝麻 RSA 公钥
    private String zhimaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzCXmtGdJHawjDdUXfNTVHmT2gNhFHjickRrOz88B5Vs5ECKAbUmVgCTZJNbt9HSzL46wlSbF40MimZ1HzrmNoyMy63NOeFD3ibQ5XE3JK0ZsyJWT1Hga/sQ9lUixFh3BLO426i8Yj6Y/fAeFAaPahP0pBnO2r5CzTR6VWxuQAEQIDAQAB";
    //编码
    private String charset = "UTF-8";

    @RequestMapping("/zmxyGet")
    public void zmxyGet(HttpServletResponse resp) {
        try {
            resp.sendRedirect("http://ssss.sss.com/thread/html/zmresult.html?");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        ZhimaAuthInfoAuthqueryRequest req = new ZhimaAuthInfoAuthqueryRequest();
//        req.setChannel("apppc");
//        req.setPlatform("zmop");
//        req.setIdentityType("2");// 必要参数
//        req.setIdentityParam("{\"certNo\":\"131182199002053810\",\"name\":\"郑超群\",\"certType\":\"IDENTITY_CARD\"} ");// 必要参数
//        req.setAuthCategory("C2B");// 必要参数
//        DefaultZhimaClient client = new DefaultZhimaClient(this.gatewayUrl,
//            this.appId, this.privateKey, this.zhimaPublicKey);
//        try {
//            ZhimaAuthInfoAuthqueryResponse response = client.execute(req);
//            System.out.println("接口调用是否成功：" + response.isSuccess());
//            System.out.println("用户是否对该应用授权 :" + response.getAuthorized());
//            System.out.println("用户的openId:" + response.getOpenId());
//            System.out.println(response.getErrorCode());
//            System.out.println(response.getErrorMessage());
//        } catch (ZhimaApiException e) {
//            e.printStackTrace();
//        }
    }

    @RequestMapping("/zmxyURLGet")
    public void zmxyURLGet() {
        ZhimaAuthInfoAuthorizeRequest req = new ZhimaAuthInfoAuthorizeRequest();
        req.setChannel("apppc");
        req.setPlatform("zmop");
        req.setIdentityType("2");// 必要参数
        req.setIdentityParam("{\"name\":\"郑超群\",\"certType\":\"IDENTITY_CARD\",\"certNo\":\"131182199002053810\"}");// 必要参数
        req.setBizParams("{\"auth_code\":\"M_APPPC_CERT\",\"channelType\":\"app\",\"state\":\"商户自定义\"}");//
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
        ZMXYController controller = new ZMXYController();
        controller.zmxyURLGet();
    }

    public void getResult() throws UnsupportedEncodingException {
        String params = "om%2FqE8s5DyjXhAf1IEwMQt6s4BYp92Lgl3UFAvJ4fmD1DKpuYQUdDshJlVYeX8tFvGbgnzFhZJXrNJk55fMTLytr2co1%2FGVV5F%2FY0GUGM2V3lkgfvo3kO8Nmme%2F%2Fn1176C6AMHGJDo1AQsSQKMMVbqBsfJREnPw8fpH4dNN7H2%2FCbEs5B3qe9wONXoXy%2BJIlr8mIZkt%2F%2BdnP8NdaqM2lnp9R95ab8ghqlOLb0SJ4Thtkw4CitBHebQrP4MMFNR28m2Hse4Udrc%2BPwovZsI7%2Bi8L7IJTY1oIesyZZ%2BLypoBA9v6ATIDAdsQqjX%2B8omK4WCbUZ5fH24mCJhUHmCsOfbg%3D%3D";
        //从回调URL中获取params参数，此处为示例值
        String sign = "BiZODF8hgruqzeQYZNXH3UmM8EPpQ6o8WSJ79bnnsUZ%2Br%2FsSSbNF2iZjgvfg2bRGueXl7F6404uaWHdRhsRkVMW1eFqQWWGyXgqGC8fRQGvXdISaV9Rh7BrInOHS7FShKn1O5X4HlnRHuvyPfvbNEHpxMeqBqAiDhlJTLqkMMrE%3D";
        //从回调URL中获取sign参数，此处为示例值
        //判断串中是否有%，有则需要decode
        if (params.indexOf("%") != -1) {
            params = URLDecoder.decode(params, this.charset);
        }
        if (sign.indexOf("%") != -1) {
            sign = URLDecoder.decode(sign, this.charset);
        }
        DefaultZhimaClient client = new DefaultZhimaClient(this.gatewayUrl,
            this.appId, this.privateKey, this.zhimaPublicKey);
        try {
            String result = client.decryptAndVerifySign(params, sign);
            System.out.println(URLDecoder.decode(result, this.charset));
        } catch (ZhimaApiException e) {
            e.printStackTrace();
        }
    }

}
