package com.wine.onewine.busness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wine.onewine.R;
import com.wine.onewine.adapter.ShopAdapter;
import com.wine.onewine.modelbeforehttp.ShopInfo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class BusnessFragment extends Fragment {
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null){
            mView = inflater.inflate(R.layout.fragment_busness, container, false);
//            initWidget();
        }

        return mView;
    }

    private void initWidget(){
        ListView mlist = (ListView) mView.findViewById(R.id.shop_listview);
        ShopAdapter adapter = new ShopAdapter(getContext());
        adapter.setData(setData());
        mlist.setAdapter(adapter);
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

}
