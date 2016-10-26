package com.wine.onewine.personal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wine.onewine.R;
import com.wine.onewine.adapter.MyOrderListAdapter;
import com.wine.onewine.modelbeforehttp.OrderListInfo;
import com.wine.onewine.modelbeforehttp.ShopCarInfo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AllOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllOrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mView;

    public AllOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllOrderFragment newInstance(String param1, String param2) {
        AllOrderFragment fragment = new AllOrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null){
            mView = inflater.inflate(R.layout.fragment_all_order, container, false);
            initWidget();
        }

        return mView;
    }

    private void initWidget(){
        ListView mlist = (ListView) mView.findViewById(R.id.order_list);
        MyOrderListAdapter adapter = new MyOrderListAdapter(getContext());
        adapter.setData(setData());
        mlist.setAdapter(adapter);

    }

    private ArrayList<OrderListInfo> setData(){
        ArrayList<OrderListInfo> listOrder = new ArrayList<>();
        for (int i = 0;i<3;i++){
            OrderListInfo info = new OrderListInfo();
            info.setOrderNo("1324554"+i);
            info.setTime("2016.10.23");
            ArrayList<ShopCarInfo> list = new ArrayList<>();
            for (int j= 0;j<1;j++){
                ShopCarInfo shopCarInfo = new ShopCarInfo();
                shopCarInfo.setCarImage("http://p4.so.qhmsg.com/bdr/_240_/t01c51fa1af76123da9.jpg");
                shopCarInfo.setCarName("好酒"+j);
                shopCarInfo.setCarNum(1);
                shopCarInfo.setCarPrice(213);
                list.add(shopCarInfo);
            }
            info.setList(list);
            listOrder.add(info);
        }
        return listOrder;
    }



}
