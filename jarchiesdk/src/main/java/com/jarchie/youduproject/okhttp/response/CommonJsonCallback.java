package com.jarchie.youduproject.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.jarchie.youduproject.okhttp.exception.OkHttpException;
import com.jarchie.youduproject.okhttp.listener.DisposeDataHandle;
import com.jarchie.youduproject.okhttp.listener.DisposeDataListener;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.okhttp.response
 * 文件名:   CommonJsonCallback
 * 创建者:   Jarchie
 * 创建时间: 17/2/13 下午5:28
 * 描述:     处理JSON的回调响应
 */

public class CommonJsonCallback implements Callback {
    /**
     * 与服务器的字段的一个对应关系
     */
    protected final String RESULT_CODE = "ecode"; //有返回则对于http请求来说是成功的，但还有可能是业务逻辑上的错误
    protected final int RESULT_CODE_VALUE = 0;
    protected final String ERROR_MSG = "emsg";
    protected final String EMPTY_MSG = "";

    /**
     * 自定义异常类型
     */
    protected final int NETWORK_ERROR = -1; //the network relative error
    protected final int JSON_ERROR = -2; //the JSON relative error
    protected final int OTHER_ERROR = -3; //the unknow error

    private Handler mDeliveryHandler; //进行消息的转发
    private DisposeDataListener mListener;
    private Class<?> mClass;

    //构造方法
    public CommonJsonCallback(DisposeDataHandle handle) {
        this.mListener = handle.mListener;
        this.mClass = handle.mClass;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    //请求失败处理
    @Override
    public void onFailure(Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ERROR, e));
            }
        });
    }

    //请求成功处理
    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    /**
     * 处理服务器返回的响应数据
     *
     * @param responseObj
     */
    private void handleResponse(Object responseObj) {
        //为了保证代码的健壮性
        if (responseObj == null && responseObj.toString().trim().equals("")) {
            mListener.onFailure(new OkHttpException(NETWORK_ERROR, EMPTY_MSG));
            return;
        }
        try {
            JSONObject result = new JSONObject(responseObj.toString());
            //开始尝试解析json
            if (result.has(RESULT_CODE)) {
                //从json对象中取出我们的响应码,若为0,则是正确的响应
                if (result.getInt(RESULT_CODE) == RESULT_CODE_VALUE) {
                    //不需要解析,直接返回数据到应用层
                    if (mClass == null) {
                        mListener.onSuccess(responseObj);
                    } else {
                        //需要我们将json对象转化为实体对象
                        Gson gson = new Gson();
                        Object obj = gson.fromJson((String) responseObj, mClass);
                        //表明正确的转为了实体对象
                        if (obj != null) {
                            mListener.onSuccess(obj);
                        } else {
                            //返回的json不是合法的json
                            mListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
                        }
                    }
                } else {
                    //将服务器返回的异常回调到应用层去处理
                    mListener.onFailure(new OkHttpException(OTHER_ERROR,
                            result.get(RESULT_CODE)));
                }
            }
        } catch (Exception e) {
            mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
        }
    }
}
