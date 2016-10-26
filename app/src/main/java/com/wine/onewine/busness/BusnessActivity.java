package com.wine.onewine.busness;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.wine.onewine.R;
import com.wine.onewine.adapter.ShopAdapter;
import com.wine.onewine.basepage.BaseActivity;
import com.wine.onewine.basepage.MainActivity;
import com.wine.onewine.modelbeforehttp.ShopInfo;

import java.util.ArrayList;

public class BusnessActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busness);
        initWidget();


    }


    private void initWidget(){
        ListView mlist = (ListView) findViewById(R.id.shop_listview);
        ShopAdapter adapter = new ShopAdapter(this);
        adapter.setData(setData());
        mlist.setAdapter(adapter);

        TextView mBack = (TextView) findViewById(R.id.back_txt);

        mBack.setOnClickListener(this);
    }

    private ArrayList<ShopInfo> setData(){
        ArrayList<ShopInfo> list = new ArrayList<>();
        for (int i = 0;i<5;i++){
            ShopInfo info = new ShopInfo();
            info.setShopImage("http://img1.imgtn.bdimg.com/it/u=3791825666,3126358737&fm=21&gp=0.jpg");
            info.setShopName("店铺"+i);
            list.add(info);
        }
        return list;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent = new Intent();
        intent.setAction(MainActivity.BACKTYPE);
        sendBroadcast(intent);
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_txt:
                Intent intent = new Intent();
                intent.setAction(MainActivity.BACKTYPE);
                sendBroadcast(intent);
                finish();
                break;
        }
    }
}
