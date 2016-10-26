package com.wine.onewine.basepage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.wine.onewine.R;
import com.wine.onewine.busness.BusnessActivity;
import com.wine.onewine.busness.BusnessFragment;
import com.wine.onewine.classify.CategoryFragment;
import com.wine.onewine.homepage.HomeFragment;
import com.wine.onewine.personal.PersonFragment;
import com.wine.onewine.shoppingcar.ShoppingCarFragment;

public class MainActivity extends BaseActivity {
    public static final String BACKTYPE = "com.wine.main.type";
    private Boolean isMain = false;    //是否是从店铺列表进入
    private FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();

        IntentFilter filter = new IntentFilter();
        // 向过滤器中添加action
        filter.addAction(BACKTYPE);
        // 注册广播
        registerReceiver(isMainBroad, filter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isMain){
            tabHost.setCurrentTab(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isMainBroad != null){
            unregisterReceiver(isMainBroad);
        }
    }

    /**
     * 广播接收者
     */
    private BroadcastReceiver isMainBroad = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            isMain = true;
        }

    };

    //自定义tab
    public View setTabMenu(String name, int image) {
        View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_own_item_layout, null);
        TextView menuText = (TextView) v.findViewById(R.id.tab_menu_txt);
        ImageView menuImg = (ImageView) v.findViewById(R.id.tab_image);
        if (TextUtils.isEmpty(name)){
            menuText.setVisibility(View.GONE);
        }else {
            menuText.setVisibility(View.VISIBLE);
            menuText.setText(name);
        }
        menuImg.setImageResource(image);
        return v;
    }


    public void initTab() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //使用fragment代替activity转换实现
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(setTabMenu("首页", R.drawable.tab_item1_selector)), HomeFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(setTabMenu("分类", R.drawable.tab_item2_selector)), CategoryFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(setTabMenu("", R.drawable.tab_item3_selector)), BusnessFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator(setTabMenu("购物车", R.drawable.tab_item4_selector)), ShoppingCarFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator(setTabMenu("我的", R.drawable.tab_item5_selector)), PersonFragment.class, null);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s){
                    case "tab3":
                        Intent intent = new Intent(MainActivity.this, BusnessActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
