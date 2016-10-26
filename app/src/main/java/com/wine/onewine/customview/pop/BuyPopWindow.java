package com.wine.onewine.customview.pop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.wine.onewine.R;
import com.wine.onewine.myutil.MethodUtil;

public class BuyPopWindow extends PopupWindow {
    private Activity activity;
    private View mMenuView;
    private OnDismissListener onDismissListener;

    public BuyPopWindow(Activity activity) {
        //这个设置的是宽高-但是我下面又强制的重设了宽高
        super(activity);
        this.activity = activity;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.add_shopcar_pop, null);
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
