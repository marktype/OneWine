package com.wine.onewine.adapter;

import android.content.Context;
import android.graphics.Paint;
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
 * Created by 欢大哥 on 2016/10/18.
 */
public class GridviewAdapter extends BaseAdapter {
    private ArrayList<GoodsListInfo> list;
    private Context context;
    public GridviewAdapter(Context context){
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
            view = LayoutInflater.from(context).inflate(R.layout.home_goods_gridview_item,null);
            viewHolder = new ViewHolder();
            viewHolder.goodsImage = (ImageView) view.findViewById(R.id.goods_image);
            viewHolder.name = (TextView) view.findViewById(R.id.goods_name);
            viewHolder.price = (TextView) view.findViewById(R.id.goods_price);
            viewHolder.discunt = (TextView) view.findViewById(R.id.goods_discunt);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GoodsListInfo info = (GoodsListInfo) getItem(i);
        Picasso.with(context).load(info.getGoodsImage()).placeholder(R.mipmap.ic_launcher).into(viewHolder.goodsImage);
        viewHolder.name.setText(info.getGoodsName());
        viewHolder.price.setText("￥"+info.getGoodsPrcie());
        viewHolder.discunt.setText("￥"+info.getGoodsDiscunt());
        viewHolder.discunt.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        return view;
    }

    private class ViewHolder{
        ImageView goodsImage;
        TextView name;
        TextView price;
        TextView discunt;
    }
}
