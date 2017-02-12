package com.jarchie.youduproject.application;

import android.app.Application;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.application
 * 文件名:   BaseApplication
 * 创建者:   Jarchie
 * 创建时间: 17/2/10 下午8:04
 * 描述:     1.这是整个程序的入口
 *          2.做一些常用的初始化工作
 *          3.为整个应用的其它模块提供上下文环境
 */

public class BaseApplication extends Application{
    private static BaseApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    //单例构建
    public static BaseApplication getInstance(){
        return mApplication;
    }
}
