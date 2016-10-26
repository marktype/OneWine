package com.wine.onewine.personal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wine.onewine.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class PersonFragment extends Fragment implements View.OnClickListener{
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null){
            mView = inflater.inflate(R.layout.fragment_person, container, false);
            initWidget();
        }

        return mView;
    }

    private void initWidget(){
        ImageView mSetting = (ImageView) mView.findViewById(R.id.setting_img);
        RelativeLayout mAllOrder = (RelativeLayout) mView.findViewById(R.id.all_order_relat);



        mAllOrder.setOnClickListener(this);
        mSetting.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_img:
                Intent intent = new Intent(getContext(),SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.all_order_relat:
                intent = new Intent(getContext(),AllOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
