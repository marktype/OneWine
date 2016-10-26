package com.wine.onewine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wine.onewine.R;
import com.wine.onewine.modelbeforehttp.AddrlistInfo;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/10/21.
 */
public class AddressAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AddrlistInfo> list;
    public AddressAdapter(Context context){
        this.context = context;
    }

    public void setData(ArrayList<AddrlistInfo> list){
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
            view = LayoutInflater.from(context).inflate(R.layout.address_item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.addre_name);
            viewHolder.phone = (TextView) view.findViewById(R.id.addr_phone);
//            viewHolder.isDefult = (TextView) view.findViewById(R.id.is_defult);   //默认
            viewHolder.proCityTxt = (TextView) view.findViewById(R.id.pro_city_area_txt);
            viewHolder.addrDetial = (TextView) view.findViewById(R.id.addr_detial);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        AddrlistInfo info = (AddrlistInfo) getItem(i);
        viewHolder.name.setText(info.getName());
        viewHolder.phone.setText(info.getPhone());
        viewHolder.proCityTxt.setText(info.getProCity());
        viewHolder.addrDetial.setText(info.getDetial());



        return view;
    }


    private class ViewHolder{
        TextView name;
        TextView phone;
        TextView isDefult;
        TextView proCityTxt;
        TextView addrDetial;
    }
}
