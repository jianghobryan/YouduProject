package com.jarchie.youduproject.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.okhttp.request
 * 文件名:   CommonRequest
 * 创建者:   Jarchie
 * 创建时间: 17/2/13 下午3:36
 * 描述:     接收请求参数,为我们生成Request对象
 */

public class CommonRequest {

    /**
     * 创建post请求的Request
     *
     * @param url
     * @param params
     * @return 返回一个创建好的Request对象
     */
    public static Request createPostRequest(String url, RequestParams params) {
        //创建FormBody的构建者
        FormBody.Builder mFormBodyBuild = new FormBody.Builder();
        //往FromBody的构建者中添加参数
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                //将请求参数逐一遍历添加到我们的请求构建类中
                mFormBodyBuild.add(entry.getKey(), entry.getValue());
            }
        }
        //通过请求构建类的build方法获取到真正的请求体对象,通过FormBody的构建者拿到FormBody对象
        FormBody mFormBody = mFormBodyBuild.build();
        //最后再由FromBody对象生成我们的Request对象
        return new Request.Builder().url(url).post(mFormBody).build();
    }

    /**
     * 创建get请求的Request
     *
     * @param url
     * @param params
     * @return 通过传入的参数返回一个get类型的请求
     */
    public static Request createGetRequest(String url, RequestParams params) {
        //实质就是字符串的拼接,将url和params拼接成一个字符串
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=")
                        .append(entry.getValue()).append("&");
            }
        }
        //通过这个字符串生成我们Get类型的Request
        return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length() - 1))
                .get().build();
    }
}
