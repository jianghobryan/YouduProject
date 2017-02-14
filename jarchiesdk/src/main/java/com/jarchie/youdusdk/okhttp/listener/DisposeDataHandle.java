package com.jarchie.youdusdk.okhttp.listener;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.okhttp.listener
 * 文件名:   DisposeDataHandle
 * 创建者:   Jarchie
 * 创建时间: 17/2/13 下午5:23
 * 描述:     对Callback的预处理
 */

public class DisposeDataHandle {
    public DisposeDataListener mListener = null;
    public Class<?> mClass = null;

    //单参构造
    public DisposeDataHandle(DisposeDataListener mListener){
        this.mListener = mListener;
    }

    //双参构造
    public DisposeDataHandle(DisposeDataListener mListener,Class<?> mClass){
        this.mListener = mListener;
        this.mClass = mClass;
    }
}
