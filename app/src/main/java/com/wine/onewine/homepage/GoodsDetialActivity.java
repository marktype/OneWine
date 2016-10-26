package com.wine.onewine.homepage;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wine.onewine.R;
import com.wine.onewine.basepage.BaseActivity;
import com.wine.onewine.customview.pop.BuyPopWindow;
import com.wine.onewine.customview.pop.GoodsInfoPopWindow;

public class GoodsDetialActivity extends BaseActivity implements View.OnClickListener{
    private BuyPopWindow buyPopWindow;
    private GoodsInfoPopWindow goodsInfoPopWindow;
    private RelativeLayout mlayout;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detial);
            initWidget();
    }

    private void initWidget(){
        mlayout = (RelativeLayout) findViewById(R.id.goods_detial_relat);
        RelativeLayout mSelect = (RelativeLayout) findViewById(R.id.select_num_relat);
        LinearLayout mInfo = (LinearLayout) findViewById(R.id.goods_detial_layout);

        mSelect.setOnClickListener(this);
        mInfo.setOnClickListener(this);
    }

    /**
     * 规格属性选择
     */
    private void buyGoods(){
        buyPopWindow = new BuyPopWindow(this);
        buyPopWindow.showAtLocation(mlayout, Gravity.RIGHT | Gravity.BOTTOM, 0, 0); //设置layout在PopupWindow中显示的位置
        buyPopWindow.setOnDismissListener(new BuyPopWindow.OnDismissListener() {
            @Override
            public void onDismiss(Boolean isMiss) {
                if (isMiss) {
                    buyPopWindow.dismiss();

                }
            }
        });
    }

    /**
     * 商品信息详情
     */
    private void goodsInfoPop(){
        goodsInfoPopWindow = new GoodsInfoPopWindow(this);
        goodsInfoPopWindow.showAtLocation(mlayout, Gravity.RIGHT | Gravity.BOTTOM, 0, 0); //设置layout在PopupWindow中显示的位置
        goodsInfoPopWindow.setOnDismissListener(new GoodsInfoPopWindow.OnDismissListener() {
            @Override
            public void onDismiss(Boolean isMiss) {
                if (isMiss) {
                    goodsInfoPopWindow.dismiss();

                }
            }
        });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.select_num_relat:
                buyGoods();
                break;
            case R.id.goods_detial_layout:
                goodsInfoPop();
                break;
        }
    }
}
