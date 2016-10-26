package com.wine.onewine.classify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.wine.onewine.R;
import com.wine.onewine.adapter.ClassifyAdapter;
import com.wine.onewine.modelbeforehttp.ClassifyInfo;
import com.wine.onewine.myutil.Logs;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mView == null){
            mView = inflater.inflate(R.layout.fragment_category, container, false);
            initWidget();
        }

        return mView;
    }

    private void initWidget(){
        GridView mGridview = (GridView) mView.findViewById(R.id.classify_gridview);
        ClassifyAdapter adapter = new ClassifyAdapter(getContext());
        adapter.setData(setData());
        mGridview.setAdapter(adapter);

        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Logs.d("aaaaaaaaaaa");
                Intent intent = new Intent(getContext(),ClassifyActivity.class);
                startActivity(intent);
            }
        });

    }


    private ArrayList<ClassifyInfo> setData(){
        ArrayList<ClassifyInfo> list = new ArrayList<>();
        ClassifyInfo info = new ClassifyInfo();
        info.setClassifyImage(R.mipmap.baijiu);
        info.setName("白酒");
        list.add(info);
        info = new ClassifyInfo();
        info.setClassifyImage(R.mipmap.class_putaojiu);
        info.setName("葡萄酒");
        list.add(info);
        info = new ClassifyInfo();
        info.setClassifyImage(R.mipmap.class_pijiu);
        info.setName("啤酒");
        list.add(info);
        info = new ClassifyInfo();
        info.setClassifyImage(R.mipmap.class_yangjiu);
        info.setName("洋酒");
        list.add(info);
        info = new ClassifyInfo();
        info.setClassifyImage(R.mipmap.qita);
        info.setName("其他");
        list.add(info);
        info = new ClassifyInfo();
        info.setClassifyImage(R.mipmap.jiuju);
        info.setName("酒具");
        list.add(info);

        return list;
    }

}
