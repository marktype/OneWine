package com.wine.onewine.personal;

import android.os.Bundle;
import android.widget.ListView;

import com.wine.onewine.R;
import com.wine.onewine.adapter.AddressAdapter;
import com.wine.onewine.basepage.BaseActivity;
import com.wine.onewine.modelbeforehttp.AddrlistInfo;

import java.util.ArrayList;

public class AddressListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        initWidget();
    }

    private void initWidget(){
        ListView mList = (ListView) findViewById(R.id.address_list);
        AddressAdapter addressAdapter = new AddressAdapter(this);
        addressAdapter.setData(setData());
        mList.setAdapter(addressAdapter);


    }

    private ArrayList<AddrlistInfo> setData(){
        ArrayList<AddrlistInfo> list = new ArrayList<>();
        for (int i = 0;i<3;i++){
            AddrlistInfo info = new AddrlistInfo();
            info.setName("小方"+i);
            info.setPhone("4132146456456");
            info.setProCity("四川省 成都市 青羊区");
            info.setDetial("哈哈哈哈哈哈哈哈");
            list.add(info);
        }
        return list;
    }


}
