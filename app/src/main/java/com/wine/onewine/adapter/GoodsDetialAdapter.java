package com.wine.onewine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wine.onewine.R;
import com.wine.onewine.modelbeforehttp.GoodsContent;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/10/20.
 */
public class GoodsDetialAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsContent> list;
    public GoodsDetialAdapter(Context context){
        this.context= context;
    }
    public void setData(ArrayList<GoodsContent> list){
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
            view = LayoutInflater.from(context).inflate(R.layout.goods_info_item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.goods_detial_name);
            viewHolder.content = (TextView) view.findViewById(R.id.goods_detial_content);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GoodsContent info = (GoodsContent) getItem(i);
        viewHolder.name.setText(info.getName());
        viewHolder.content.setText(info.getContent());

        return view;
    }

    private class ViewHolder{
        TextView name;
        TextView content;
    }
}
