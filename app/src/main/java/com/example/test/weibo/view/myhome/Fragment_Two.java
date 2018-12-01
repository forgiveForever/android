package com.example.test.weibo.view.myhome;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.test.weibo.util.HomeGrideImageView;
import com.example.test.weibo.util.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZJSB-01 on 2017/12/5.
 */

public class Fragment_Two extends Fragment {
    private MyListView listView;
    private  List<List<Integer>> imgPaths;
    private List<String> titles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_listview, null);
        listView =(MyListView) view.findViewById(R.id.my_home_list);
        setItems();
        addListView();
        return view;
    }

    private void setItems(){
        imgPaths=new ArrayList<>();
        List<Integer> a1=new ArrayList<>();
        a1.add(R.drawable.guanggao_e);
        a1.add(R.drawable.guanggao_d);
        imgPaths.add(a1);

        List<Integer> a2=new ArrayList<>();
        a2.add(R.drawable.guanggao_a);
        a2.add(R.drawable.friend_d);
        a2.add(R.drawable.friend_a);
        imgPaths.add(a2);
        List<Integer> a3=new ArrayList<>();
        a3.add(R.drawable.friend_b);
        a3.add(R.drawable.friend_d);
        a3.add(R.drawable.friend_a);
        a3.add(R.drawable.friend_b);
        a3.add(R.drawable.friend_d);
        a3.add(R.drawable.friend_a);
        imgPaths.add(a3);
        titles=new ArrayList<>();
        titles.add("我赞过的");
        titles.add("小飞飞上传的");
        titles.add("出去游玩的");

    }
    private void addListView(){
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return imgPaths.size();
            }

            @Override
            public Object getItem(int position) {

                return imgPaths.get(position);
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
                    LayoutInflater inflater = Fragment_Two.this.getActivity().getLayoutInflater();
                    //因为getView()返回的对象，adapter会自动赋给ListView
                    view = inflater.inflate(R.layout.home_xiangche, null);
                }else{
                    view = convertView;
                }
                GridView gridView=(GridView) view.findViewById(R.id.home_imgs);
                TextView title=(TextView) view.findViewById(R.id.home_imgs_title);
                title.setText(titles.get(position));
                setGrideView(gridView,imgPaths.get(position));
                return view;
            }
        });
    }
    private  View setGrideView(GridView imgs,List<Integer> path){
        imgs.setAdapter(new HomeGrideImageView( Fragment_Two.this.getActivity(),path));
        return imgs;
    }
}

