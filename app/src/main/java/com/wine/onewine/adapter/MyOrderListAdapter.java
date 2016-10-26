package com.wine.onewine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wine.onewine.R;
import com.wine.onewine.customview.MyListView;
import com.wine.onewine.modelbeforehttp.OrderListInfo;

import java.util.ArrayList;

/**
 * 商品列表
 */
public class MyOrderListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<OrderListInfo> list;
    public MyOrderListAdapter(Context context){
        this.context = context;
    }

    public void setData(ArrayList<OrderListInfo> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.order_list_item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.status = (TextView) view.findViewById(R.id.status_order);
            viewHolder.orderNo = (TextView) view.findViewById(R.id.order_no);
            viewHolder.time = (TextView) view.findViewById(R.id.order_time);
            viewHolder.listView = (MyListView) view.findViewById(R.id.my_list_order_list);
            viewHolder.cancalorder = (TextView) view.findViewById(R.id.cancal_order);
            viewHolder.goPay = (TextView) view.findViewById(R.id.go_pay_order);
            viewHolder.sureOrder = (TextView) view.findViewById(R.id.sure_order);
            viewHolder.appyOrder = (TextView) view.findViewById(R.id.apply_order);
            viewHolder.commentOrder = (TextView) view.findViewById(R.id.comment_order);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        OrderListInfo info = (OrderListInfo) getItem(i);
        MyOrderItemAdapter adapter = new MyOrderItemAdapter(context);
        adapter.setData(info.getList());
        viewHolder.listView.setAdapter(adapter);

        viewHolder.orderNo.setText(info.getOrderNo());
        viewHolder.time.setText(info.getTime());



        return view;
    }

    private class ViewHolder{
        TextView status;
        TextView orderNo;
        TextView time;
        TextView cancalorder,goPay,sureOrder,appyOrder,commentOrder;
        MyListView listView;
    }

    /**
     * 设置订单状态
     * @param status
     */
    private void setStatus(TextView stuTxt,int status){
        switch (status){
            case 0:
                break;
        }
    }

    /**
     * 设置按钮是否显示
     * @param cancalorder  取消
     * @param goPay    支付
     * @param sureOrder   确认
     * @param appyOrder   申请退货
     * @param commentOrder   评价
     * @param status   状态码
     */
    private void setButomStatus(TextView cancalorder,TextView goPay,TextView sureOrder,TextView appyOrder,TextView commentOrder,int status){
        switch (status){
            case 0:
                break;
        }
    }
}
