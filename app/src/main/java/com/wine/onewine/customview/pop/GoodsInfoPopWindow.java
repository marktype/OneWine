package com.wine.onewine.customview.pop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.wine.onewine.R;
import com.wine.onewine.adapter.GoodsDetialAdapter;
import com.wine.onewine.modelbeforehttp.GoodsContent;
import com.wine.onewine.myutil.MethodUtil;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/10/20.
 */
public class GoodsInfoPopWindow extends PopupWindow {

    private Activity activity;
    private View mMenuView;
    private OnDismissListener onDismissListener;

    public GoodsInfoPopWindow(Activity activity) {
        //这个设置的是宽高-但是我下面又强制的重设了宽高
        super(activity);
        this.activity = activity;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.goods_info_detial_layout, null);
        setContentView(mMenuView);
        //重设宽高
        resetWidthHeight();
        //下面的没设置
//        实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        setBackgroundDrawable(dw);
        getBackground().setAlpha(0);
        initWidget(mMenuView);

    }

    /**
     * @param mMenuView
     */
    private void initWidget(View mMenuView) {
        ListView mlist = (ListView) mMenuView.findViewById(R.id.pop_listview);
        GoodsDetialAdapter adapter = new GoodsDetialAdapter(activity);
        adapter.setData(setData());
        mlist.setAdapter(adapter);

    }

    private ArrayList<GoodsContent> setData(){
        ArrayList<GoodsContent> list = new ArrayList<>();
        GoodsContent info = new GoodsContent();
        info.setName("葡萄酒类型");
        info.setContent("起泡葡萄酒");
        list.add(info);
        info = new GoodsContent();
        info.setName("葡萄酒品种");
        info.setContent("白桃");
        list.add(info);
        info = new GoodsContent();
        info.setName("酒精度");
        info.setContent("12%vol");
        list.add(info);
        info = new GoodsContent();
        info.setName("生产年份");
        info.setContent("NV");
        list.add(info);
        info = new GoodsContent();
        info.setName("规格");
        info.setContent("750ml");
        list.add(info);
        info = new GoodsContent();
        info.setName("所属国家");
        info.setContent("意大利");
        list.add(info);
        info = new GoodsContent();
        info.setName("品尝温度");
        info.setContent("6°～ 8°");
        list.add(info);
        info = new GoodsContent();
        info.setName("色泽");
        info.setContent("淡黄色");
        list.add(info);
        info = new GoodsContent();
        info.setName("香味");
        info.setContent("细致的果香");
        list.add(info);
        info = new GoodsContent();
        info.setName("口感");
        info.setContent("甜美的果香");
        list.add(info);
        info = new GoodsContent();
        info.setName("产区");
        info.setContent("皮埃蒙特");
        list.add(info);
        info = new GoodsContent();
        info.setName("享用期");
        info.setContent("2015-2025");
        list.add(info);
        info = new GoodsContent();
        info.setName("搭配菜肴");
        info.setContent("直接喝");
        list.add(info);
        return list;
    }




    /**
     * 重设宽高
     */
    private void resetWidthHeight() {
        int wight = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        this.setWidth(wight/2+200);
        //设置SelectPicPopupWindow弹出窗体的高(屏幕宽度的一半+200px)
        this.setHeight(height- MethodUtil.getStatusBarHeight(activity));   //状态栏高度
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.popwindow_anim_style);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setFocusable(true);
    }

    /**
     * 设置消失监听
     *
     * @param onDismissListener
     */
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    /**
     * pop消失接口
     */
    public interface OnDismissListener {
        //是否销毁当前pop
        void onDismiss(Boolean isMiss);
    }

    ;
}
