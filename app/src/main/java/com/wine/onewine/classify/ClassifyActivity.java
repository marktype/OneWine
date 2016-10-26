package com.wine.onewine.classify;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.wine.onewine.R;
import com.wine.onewine.adapter.GoodsListAdapter;
import com.wine.onewine.basepage.BaseActivity;
import com.wine.onewine.modelbeforehttp.GoodsListInfo;

import java.util.ArrayList;

public class ClassifyActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);
        initWidget();
    }

    private void initWidget(){
        ListView mList = (ListView) findViewById(R.id.goods_list);
        LinearLayout mBack = (LinearLayout) findViewById(R.id.back_img);

        GoodsListAdapter adapter = new GoodsListAdapter(this);
        adapter.setData(setData());
        mList.setAdapter(adapter);

        mBack.setOnClickListener(this);
    }


    private ArrayList<GoodsListInfo> setData(){
        ArrayList<GoodsListInfo> list = new ArrayList<>();
        for (int i = 0;i<5;i++){
            GoodsListInfo info = new GoodsListInfo();
            info.setGoodsImage("http://img1.imgtn.bdimg.com/it/u=1428854904,995377513&fm=21&gp=0.jpg");
            info.setGoodsName("好酒"+i);
            info.setGoodsPrcie(223+i);
            list.add(info);
        }
        return list;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_img:
                finish();
                break;
        }
    }
}
