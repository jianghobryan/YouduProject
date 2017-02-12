package com.jarchie.youduproject.view.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jarchie.youduproject.R;
import com.jarchie.youduproject.view.fragment.BaseFragment;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.view.fragment.home
 * 文件名:   HomeFragment
 * 创建者:   Jarchie
 * 创建时间: 17/2/10 下午8:06
 * 描述:     首页Fragment
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener{
    //UI
    private View mContentView;
    private TextView mQRCodeView;
    private TextView mCategoryView;
    private TextView mSearchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home_layout,container,false);
        //初始化View
        initView();
        return mContentView;
    }

    /**
     * 初始化页面中所有的控件
     */
    private void initView() {
        mQRCodeView = (TextView) mContentView.findViewById(R.id.qrcode_view);
        mQRCodeView.setOnClickListener(this);
        mCategoryView = (TextView) mContentView.findViewById(R.id.category_view);
        mCategoryView.setOnClickListener(this);
        mSearchView = (TextView) mContentView.findViewById(R.id.search_view);
        mSearchView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qrcode_view:

                break;
            case R.id.category_view:

                break;
            case R.id.search_view:

                break;
        }
    }
}
