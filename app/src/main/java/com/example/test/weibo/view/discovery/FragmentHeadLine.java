package com.example.test.weibo.view.discovery;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.test.weibo.R;
import com.example.test.weibo.praseEntity.Item;
import com.example.test.weibo.util.CircleImageView;
import com.example.test.weibo.util.GridViewAdapter;
import com.example.test.weibo.view.myhome.Fragment_One;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13969 on 2018/11/2.
 */

public class FragmentHeadLine extends Fragment {
    private  ListView listView;
    private List<Integer> imgpatha;
    private List<Integer> imgpathb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_listview, null);
        listView=(ListView)view.findViewById(R.id.my_home_list) ;
        setItems();
        addListView();
        return view;
    }


    private void setItems(){
        imgpatha=new ArrayList<>();
        imgpatha.add(R.drawable.friend_a);
        imgpatha.add(R.drawable.friend_b);
        imgpatha.add(R.drawable.friend_c);
        imgpatha.add(R.drawable.friend_d);
        imgpathb=new ArrayList<>();
        imgpathb.add(R.drawable.guanggao_a);
        imgpathb.add(R.drawable.guanggao_b);
        imgpathb.add(R.drawable.gaunggao_c);
        imgpathb.add(R.drawable.guanggao_d);
    }
    private void addListView(){
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return imgpatha.size();
            }

            @Override
            public Object getItem(int position) {

                return imgpatha.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = null;
                //布局不变，数据变
                //如果缓存为空，我们生成新的布局作为1个item
                if(convertView==null){
                    Log.i("info:", "没有缓存，重新生成"+position);
                    LayoutInflater inflater = FragmentHeadLine.this.getActivity().getLayoutInflater();
                    //因为getView()返回的对象，adapter会自动赋给ListView
                    view = inflater.inflate(R.layout.discovery_headline, null);
                }else{
                    Log.i("info:", "有缓存，不需要重新生成"+position);
                    view = convertView;
                }
                ImageView a =(ImageView) view.findViewById(R.id.discovery_headline_img_a);
                a.setImageResource(imgpatha.get(position));
                ImageView b =(ImageView) view.findViewById(R.id.discovery_headline_img_b);
               b.setImageResource(imgpathb.get(position));
                return view;
            }
        });
    }

}
