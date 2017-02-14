package com.jarchie.youdu.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.activity.base
 * 文件名:   BaseActivity
 * 创建者:   Jarchie
 * 创建时间: 17/2/10 下午8:26
 * 描述:     为我们所有的Activity提供公共的行为
 */

public abstract class BaseActivity extends AppCompatActivity{
    /**
     * 输出日志,所需TAG
     */
    public String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
