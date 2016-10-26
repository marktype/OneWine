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
import com.wine.onewine.modelbeforehttp.GoodsListInfo;

import java.util.ArrayList;

/**
 * 商品列表
 */
public class GoodsListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsListInfo> list;
    public GoodsListAdapter(Context context){
        this.context = context;
    }
    public void setData(ArrayList<GoodsListInfo> list){
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
            view = LayoutInflater.from(context).inflate(R.layout.goods_list_item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) view.findViewById(R.id.car_image);
            viewHolder.name = (TextView) view.findViewById(R.id.goods_name_car);
            viewHolder.Price = (TextView) view.findViewById(R.id.car_price);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GoodsListInfo info = (GoodsListInfo) getItem(i);
        Picasso.with(context).load(info.getGoodsImage()).placeholder(R.mipmap.ic_launcher).into(viewHolder.image);
        viewHolder.name.setText(info.getGoodsName());
        viewHolder.Price.setText("￥"+info.getGoodsPrcie());

        return view;
    }

    private class ViewHolder{
        ImageView image;
        TextView name;
        TextView Price;
    }
}
