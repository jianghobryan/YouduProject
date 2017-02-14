package com.jarchie.youdu.network.http;

import com.jarchie.youdu.moudle.recommand.BaseRecommandModel;
import com.jarchie.youdusdk.okhttp.CommonOkHttpClient;
import com.jarchie.youdusdk.okhttp.listener.DisposeDataHandle;
import com.jarchie.youdusdk.okhttp.listener.DisposeDataListener;
import com.jarchie.youdusdk.okhttp.request.CommonRequest;
import com.jarchie.youdusdk.okhttp.request.RequestParams;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youdu.network.http
 * 文件名:   RequestCenter
 * 创建者:   Jarchie
 * 创建时间: 17/2/14 下午4:47
 * 描述:     存放应用中所有的请求
 */

public class RequestCenter {
    //根据参数发送所有的post请求
    private static void postRequest(String url, RequestParams params,
                                    DisposeDataListener listener,
                                    Class<?> clazz){
        CommonOkHttpClient.get(CommonRequest.createGetRequest(url, params),
                new DisposeDataHandle(listener,clazz));
    }

    /**
     * 真正的发送我们首页的请求
     * @param listener
     */
    public static void requestRecommandData(DisposeDataListener listener){
        RequestCenter.postRequest(HttpConstants.HOME_RECOMMAND,null,listener, BaseRecommandModel.class);
    }
}
