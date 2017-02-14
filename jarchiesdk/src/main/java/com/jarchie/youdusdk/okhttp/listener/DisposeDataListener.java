package com.jarchie.youdusdk.okhttp.listener;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.okhttp.listener
 * 文件名:   DisposeDataListener
 * 创建者:   Jarchie
 * 创建时间: 17/2/13 下午5:17
 * 描述:     自定义事件监听
 */

public interface DisposeDataListener {
    /**
     * 请求成功回调事件处理
     */
    public void onSuccess(Object responseObj);

    /**
     * 请求失败回调事件处理
     */
    public void onFailure(Object responseObj);
}
