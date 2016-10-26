package com.wine.onewine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wine.onewine.R;
import com.wine.onewine.modelbeforehttp.ShopCarInfo;

import java.util.ArrayList;

/**
 * 单个商品显示
 */
public class MyOrderItemAdapter extends BaseAdapter {
    private ArrayList<ShopCarInfo> list;
    private Context context;
    public MyOrderItemAdapter(Context context){
        this.context = context;
    }
    public void setData(ArrayList<ShopCarInfo> list){
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
            view = LayoutInflater.from(context).inflate(R.layout.order_item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) view.findViewById(R.id.car_image);
            viewHolder.name = (TextView) view.findViewById(R.id.goods_name_car);
            viewHolder.price = (TextView) view.findViewById(R.id.car_price);
            viewHolder.num = (TextView) view.findViewById(R.id.num_textview);
            viewHolder.totalPrice = (TextView) view.findViewById(R.id.order_price);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ShopCarInfo info = (ShopCarInfo) getItem(i);
        Picasso.with(context).load(info.getCarImage()).placeholder(R.mipmap.ic_launcher).into(viewHolder.image);
        viewHolder.name.setText(info.getCarName());
        viewHolder.price.setText("￥"+info.getCarPrice());
        viewHolder.num.setText("x"+info.getCarNum());
        viewHolder.totalPrice.setText("￥"+info.getCarPrice()*info.getCarNum());

        return view;
    }

    private class ViewHolder{
        ImageView image;
        TextView name;
        TextView price;
        TextView num;
        TextView totalPrice;
    }
}
