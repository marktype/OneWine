package com.wine.onewine.personal;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.wine.onewine.R;
import com.wine.onewine.adapter.MyPagerAdapter;
import com.wine.onewine.basepage.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class AllOrderActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<Fragment> mViewList = new ArrayList<>();//页卡视图集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_order);
        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        initTab();
    }

    private void initTab(){

        //添加页卡视图
        mViewList.add(AllOrderFragment.newInstance("",""));
        mViewList.add(DaiFuKuanFragment.newInstance("",""));
        mViewList.add(DaiShouHuoFragment.newInstance("",""));
        mViewList.add(DaiPingJiaFragment.newInstance("",""));
        mViewList.add(HuanHuoFragment.newInstance("",""));

        //添加页卡标题
        mTitleList.add("全部");
        mTitleList.add("待付款");
        mTitleList.add("待收货");
        mTitleList.add("待评价");
        mTitleList.add("换货");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mViewList,mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mViewPager.setOffscreenPageLimit(0);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
//        mViewPager.setCurrentItem(3);    //跳转到哪个页面
    }
}
