package com.example.test.weibo.util;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.test.weibo.R;

import java.util.List;

/**
 * Created by 13969 on 2018/10/12.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    LayoutInflater layoutInflater;
    private ImageView img;

    public GridViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.item_image, null);
        img = (ImageView) convertView.findViewById(R.id.item_img);
        if (position < list.size()) {
            /*img.setImageURI(Uri.parse("/storage/emulated/0/img/"+list.get(position)));*/
            img.setImageResource(R.drawable.bg_home);

        }else{
            img.setBackgroundResource(R.drawable.home);//最后一个显示加号图片
        }
        return convertView;

    }
}
