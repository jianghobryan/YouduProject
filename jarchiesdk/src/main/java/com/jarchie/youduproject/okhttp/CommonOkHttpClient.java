package com.jarchie.youduproject.okhttp;

import com.jarchie.youduproject.okhttp.https.HttpsUtils;
import com.jarchie.youduproject.okhttp.response.CommonJsonCallback;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.okhttp
 * 文件名:   CommonOkHttpClient
 * 创建者:   Jarchie
 * 创建时间: 17/2/13 下午3:26
 * 描述:     请求的发送,请求参数的配置,Https支持
 */

public class CommonOkHttpClient {
    //超时时间
    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkHttpClient;

    //为我们的client去配置参数,使用静态语句块
    static {
        //创建client对象的构建者
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        //为构建者填充超时时间
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        //允许请求重定向
        okHttpBuilder.followRedirects(true);
        //添加https支持
        okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        okHttpBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory());
        //生成我们的client对象
        mOkHttpClient = okHttpBuilder.build();
    }

    /**
     * 发送具体的http以及https请求
     *
     * @param request
     * @param commonCallback
     * @return Call
     */
    public static Call sendRequest(Request request, CommonJsonCallback commonCallback) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(commonCallback);
        return call;
    }

}
