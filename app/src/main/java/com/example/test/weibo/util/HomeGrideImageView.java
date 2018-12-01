package com.example.test.weibo.util;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.test.weibo.R;

import java.util.List;

/**
 * Created by 13969 on 2018/11/5.
 */

public class HomeGrideImageView extends BaseAdapter {
    private Context context;
    private List<Integer> list;
    LayoutInflater layoutInflater;
    private ImageView img;

    public HomeGrideImageView(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.item_image, null);
        img = (ImageView) convertView.findViewById(R.id.item_img);
        img.setImageResource(list.get(position));
        return convertView;

    }
}
