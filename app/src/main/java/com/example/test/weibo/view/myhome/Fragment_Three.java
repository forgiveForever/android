package com.example.test.weibo.view.myhome;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.test.weibo.R;
import com.example.test.weibo.praseEntity.Item;
import com.example.test.weibo.util.CircleImageView;
import com.example.test.weibo.util.GridViewAdapter;
import com.example.test.weibo.util.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZJSB-01 on 2017/12/5.
 */

public class Fragment_Three extends Fragment {
    private MyListView listView;
    private List<Item> items;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_listview, null);
        listView =(MyListView) view.findViewById(R.id.my_home_list);
        setItems();
        addListView();
        return view;
    }

    private void setItems(){
        items=new ArrayList<>();
        for(int n=0;n<4;n++){
            Item item=new Item();
            item.setUser_name("小红");
            item.setStatus("转发");
            item.setText("eeeeeee");
            items.add(item);
        }
    }
    private void addListView(){
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return items.size();
            }

            @Override
            public Object getItem(int position) {

                return items.get(position);
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
                    LayoutInflater inflater = Fragment_Three.this.getActivity().getLayoutInflater();
                    //因为getView()返回的对象，adapter会自动赋给ListView
                    view = inflater.inflate(R.layout.item, null);
                }else{
                    Log.i("info:", "有缓存，不需要重新生成"+position);
                    view = convertView;
                }
                Item item =items.get(position);
                String sdpath  = Environment.getExternalStorageDirectory().getAbsolutePath();

                CircleImageView userImg=  (CircleImageView)view.findViewById(R.id.user_img);
                //   userImg.setImageURI(Uri.parse("/storage/emulated/0/img/home.png"));
                userImg.setImageResource(R.drawable.head);
                TextView title=(TextView) view.findViewById(R.id.content_title);
                title.setText(item.getText()+":"+sdpath);
                TextView time =(TextView)view.findViewById(R.id.time);
                time.setText("2018-02-12");
                TextView content=(TextView)view.findViewById(R.id.content);
                content.setText("学习一门语言是需要过程的，虽然两个月的时间并不是很长，但是我们还是能学到一点东西的，而且学习也是自己的事儿，并不是其他可以帮助的，我学习android，首先了解Android apk的构成，主要是由 activity和layout布局文件还有一些图片组成，我在其中学到了activity的生命周期，开始创建一直到销毁的过程。还有布局文件，让我了解到了如何布局\n");
                GridView imgs=(GridView) view.findViewById(R.id.imgs);
                setGrideView(imgs);
                return view;
            }
        });
    }
    private  View setGrideView(GridView imgs){
        ArrayList<String> list=new ArrayList();
        list.add("home.png");
        list.add("home.png");
        imgs.setAdapter(new GridViewAdapter( Fragment_Three.this.getActivity(),list));
        return imgs;
    }
}
