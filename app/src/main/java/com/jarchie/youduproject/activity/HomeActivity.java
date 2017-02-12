package com.jarchie.youduproject.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jarchie.youduproject.R;
import com.jarchie.youduproject.activity.base.BaseActivity;
import com.jarchie.youduproject.view.fragment.home.HomeFragment;
import com.jarchie.youduproject.view.fragment.home.MessageFragment;
import com.jarchie.youduproject.view.fragment.home.MineFragment;

/**
 * 项目名:   YouduProject
 * 包名:     com.jarchie.youduproject.activity
 * 文件名:   HomeActivity
 * 创建者:   Jarchie
 * 创建时间: 17/2/10 下午8:03
 * 描述:     创建首页所有的Fragment,以及
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener{
    /**
     * Fragment相关
     */
    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        //初始化View
        initView();
        //添加默认要显示的Fragment
        mHomeFragment = new HomeFragment();
        fm = getFragmentManager();
    }

    /**
     * 实例化我们页面中所有的控件
     */
    private void initView() {
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (TextView) findViewById(R.id.home_image_view);
        mPondView = (TextView) findViewById(R.id.fish_image_view);
        mMessageView = (TextView) findViewById(R.id.message_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

    }

}
