package com.wine.onewine.myutil;

import android.content.Context;

import java.lang.reflect.Field;

/**
 * Created by 欢大哥 on 2016/10/20.
 */
public class MethodUtil {

    //通知栏高度写在dimen文件中(获取状态栏高度)
    public static int getStatusBarHeight(Context context){
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }
}
