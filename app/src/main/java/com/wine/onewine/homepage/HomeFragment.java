package com.wine.onewine.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.wine.onewine.R;
import com.wine.onewine.adapter.GridviewAdapter;
import com.wine.onewine.customview.MyGridView;
import com.wine.onewine.modelbeforehttp.GoodsListInfo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private View mView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mView == null){
            mView = inflater.inflate(R.layout.fragment_home, container, false);
            initWight();
        }

        return mView;
    }

    private void initWight(){
        MyGridView mContent = (MyGridView) mView.findViewById(R.id.home_content_gridview);
        GridviewAdapter adapter = new GridviewAdapter(getContext());
        adapter.setData(setGridviewData());
        mContent.setAdapter(adapter);

        mContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),GoodsDetialActivity.class);
                startActivity(intent);
            }
        });

    }

    private ArrayList<GoodsListInfo> setGridviewData(){
        ArrayList<GoodsListInfo> list = new ArrayList<>();
        for (int i = 0;i<6;i++){
            GoodsListInfo info = new GoodsListInfo();
            info.setGoodsImage("http://pic61.nipic.com/file/20150311/9301655_085711366600_2.jpg");
            info.setGoodsName("美酒佳肴"+i);
            info.setGoodsPrcie(123);
            info.setGoodsDiscunt(124);
            list.add(info);
        }
        return list;
    }



//    /**
//     * imageSlider控件加入
//     * */
//    public void getSliderLayoutView(String[] mImage, final String[] mString) {
//        SliderLayout mSliderLayout = (SliderLayout) mSliderVIew.findViewById(R.id.image_slider_layout);
//
//        PagerIndicator pagerIndicator = (PagerIndicator) mSliderVIew.findViewById(R.id.custom1_indicator);
//
//        mSliderLayout.removeAllSliders();
//        int length = mImage.length;
//        for (int i = 0; i < length; i++) {
//            TextSliderView sliderView = new TextSliderView(getContext());   //向SliderLayout中添加控件
//            sliderView.image(mImage[i]);
////            sliderView.description(mString[i]);
//            final int finalI = i;
//            sliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
//                @Override
//                public void onSliderClick(BaseSliderView slider) {
//                    Intent intent = new Intent(getContext(), AgreementWebActivity.class);
//                    intent.putExtra(AgreementWebActivity.URLTYPE,3);
//                    intent.putExtra(AgreementWebActivity.URL,mString[finalI]);
//                    startActivity(intent);
//                }
//            });
//            mSliderLayout.addSlider(sliderView);
//        }
////        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);  //将小圆点设置到右下方
//        mSliderLayout.setCustomIndicator(pagerIndicator);  //将小圆点设置到右下方(自定义控件指示器)
//
//    }
}
