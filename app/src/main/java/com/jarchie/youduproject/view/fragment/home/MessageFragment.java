package com.jarchie.youduproject.view.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jarchie.youduproject.R;
import com.jarchie.youduproject.view.fragment.BaseFragment;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.view.fragment.home
 * 文件名:   MessageFragment
 * 创建者:   Jarchie
 * 创建时间: 17/2/10 下午8:07
 * 描述:     消息Fragment
 */

public class MessageFragment extends BaseFragment implements View.OnClickListener {
    //UI
    private View mContentView;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mZanLayout;
    private RelativeLayout mImoocLayout;
    private TextView mTipView;
    private TextView mTipZanView;
    private TextView mTipMsgView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_message_layout, null, false);
        //初始化View
        initView();
        return mContentView;
    }

    /**
     * 初始化页面中所有的控件
     */
    private void initView() {
        mMessageLayout = (RelativeLayout) mContentView.findViewById(R.id.message_layout);
        mImoocLayout = (RelativeLayout) mContentView.findViewById(R.id.imooc_layout);
        mZanLayout = (RelativeLayout) mContentView.findViewById(R.id.zan_layout);
        mTipView = (TextView) mContentView.findViewById(R.id.tip_view);
        mTipZanView = (TextView) mContentView.findViewById(R.id.zan_tip_view);
        mTipMsgView = (TextView) mContentView.findViewById(R.id.unread_tip_view);

        mImoocLayout.setOnClickListener(this);
        mZanLayout.setOnClickListener(this);
        mMessageLayout.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zan_layout:
                break;
            case R.id.message_layout:
                break;
            case R.id.imooc_layout:
                break;
        }
    }
}
