package com.jarchie.youdu.view.fragment.home;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jarchie.youdu.R;
import com.jarchie.youdu.network.http.RequestCenter;
import com.jarchie.youdu.utils.LogUtil;
import com.jarchie.youdu.view.fragment.BaseFragment;
import com.jarchie.youdusdk.okhttp.listener.DisposeDataListener;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.view.fragment.home
 * 文件名:   HomeFragment
 * 创建者:   Jarchie
 * 创建时间: 17/2/10 下午8:06
 * 描述:     首页Fragment
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener,AdapterView.OnItemClickListener{
    //UI
    private View mContentView;
    private TextView mQRCodeView;
    private TextView mCategoryView;
    private TextView mSearchView;
    private ImageView mLoadingView;
    private ListView mListView;

    public HomeFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestRecommandData();
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

        mListView = (ListView) mContentView.findViewById(R.id.list_view);
        mListView.setOnItemClickListener(this);
        mLoadingView = (ImageView) mContentView.findViewById(R.id.loading_view);
        //启动loadingView动画
        AnimationDrawable anim = (AnimationDrawable) mLoadingView.getDrawable();
        anim.start();
    }

    /**
     * 发送首页列表数据请求
     */
    private void requestRecommandData() {
        RequestCenter.requestRecommandData(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                //完成我们的功能逻辑处理
                LogUtil.e("Success:"+responseObj.toString());
            }

            @Override
            public void onFailure(Object responseObj) {
                //提示用户网络有问题
                LogUtil.e("Failure:"+responseObj.toString());
            }
        });
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
