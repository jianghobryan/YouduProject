package com.jarchie.youdu.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.view.fragment
 * 文件名:   BaseFragment
 * 创建者:   Jarchie
 * 创建时间: 17/2/10 下午8:05
 * 描述:     为我们所有的Fragment提供公共的行为或事件
 */

public class BaseFragment extends Fragment {
    protected Activity mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
