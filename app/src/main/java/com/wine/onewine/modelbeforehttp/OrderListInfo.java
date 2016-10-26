package com.wine.onewine.modelbeforehttp;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/10/21.
 */
public class OrderListInfo {

    private String orderNo;
    private int status;
    private String time;
    private ArrayList<ShopCarInfo> list;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<ShopCarInfo> getList() {
        return list;
    }

    public void setList(ArrayList<ShopCarInfo> list) {
        this.list = list;
    }
}
