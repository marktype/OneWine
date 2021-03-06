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
import com.wine.onewine.modelbeforehttp.ClassifyInfo;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/10/18.
 */
public class ClassifyAdapter extends BaseAdapter {
    private ArrayList<ClassifyInfo> list;
    private Context context;
    public ClassifyAdapter(Context context){
        this.context = context;
    }
    public void setData(ArrayList<ClassifyInfo> list){
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
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.classify_item_layout,null);
            viewHolder.image = (ImageView) view.findViewById(R.id.classify_image);
            viewHolder.title = (TextView) view.findViewById(R.id.classify_name);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ClassifyInfo info = (ClassifyInfo) getItem(i);
        viewHolder.title.setText(info.getName());
        Picasso.with(context).load(info.getClassifyImage()).placeholder(R.mipmap.ic_launcher).into(viewHolder.image);

        return view;
    }

    private class ViewHolder{
        ImageView image;
        TextView title;
    }
}
