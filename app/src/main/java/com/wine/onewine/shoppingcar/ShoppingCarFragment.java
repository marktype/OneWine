package com.wine.onewine.shoppingcar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wine.onewine.R;
import com.wine.onewine.adapter.ShopCarAdapter;
import com.wine.onewine.modelbeforehttp.ShopCarInfo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class ShoppingCarFragment extends Fragment {
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null){
            mView = inflater.inflate(R.layout.fragment_shopping_car, container, false);
            initWidget();
        }

        return mView;
    }


    private void initWidget(){
        ListView mlist = (ListView) mView.findViewById(R.id.shopcar_listview);
        ShopCarAdapter adapter = new ShopCarAdapter(getContext());
        adapter.setData(setData());
        mlist.setAdapter(adapter);
    }

    private ArrayList<ShopCarInfo> setData(){
        ArrayList<ShopCarInfo> list = new ArrayList<>();
        for (int i = 0;i<5;i++){
            ShopCarInfo info = new ShopCarInfo();
            info.setCarImage("http://img1.imgtn.bdimg.com/it/u=2234308692,1924451743&fm=21&gp=0.jpg");
            info.setCarName("精品酒"+i);
            info.setCarPrice(234);
            info.setCarNum(i+1);
            list.add(info);
        }
        return list;
    }
}
