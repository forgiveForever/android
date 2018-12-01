package com.example.test.weibo.view.mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
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
import com.example.test.weibo.fragment.MainFragment;
import com.example.test.weibo.praseEntity.AddFriendEntity;
import com.example.test.weibo.praseEntity.Item;
import com.example.test.weibo.util.CircleImageView;
import com.example.test.weibo.view.system.WeiBoLogin;
import com.example.test.weibo.view.system.WeiBoRegister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13969 on 2018/11/5.
 */

public class MyAddFriend extends AppCompatActivity {
    private ListView listView;
    private List<AddFriendEntity> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_add_friend);
        getSupportActionBar().hide();
        ImageView fan=(ImageView) findViewById(R.id.my_add_friend_fan);
        listView =(ListView)  findViewById(R.id.my_add_friend_listview);
        setItems();
        addListView();
        fan.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

   private void setItems(){
       items=new ArrayList<>();
       for(int n=0;n<3;n++){
           AddFriendEntity friend1=new AddFriendEntity();
           friend1.setImg(R.drawable.friend_a);
           friend1.setUsername("李大飞");
           friend1.setJieshao("幽默与实力并存的主播");
           friend1.setLeibie("游戏主播");
           items.add(friend1);
       AddFriendEntity friend2=new AddFriendEntity();
       friend2.setImg(R.drawable.friend_b);
       friend2.setUsername("李小飞");
       friend2.setJieshao("擅长唱歌和跳舞");
       friend2.setLeibie("星秀主播");
       items.add(friend2);
       AddFriendEntity friend3=new AddFriendEntity();
       friend3.setImg(R.drawable.friend_c);
       friend3.setUsername("心在流浪");
       friend3.setJieshao("千里之外取敌将首级");
       friend3.setLeibie("绝地求生主播");
       items.add(friend3);
       AddFriendEntity friend4=new AddFriendEntity();
       friend4.setImg(R.drawable.friend_d);
       friend4.setUsername("赛潘安");
       friend4.setJieshao("户外搭讪；专撩小姐姐");
       friend4.setLeibie("户外主播");
       items.add(friend4);
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

                    LayoutInflater inflater = MyAddFriend.this.getLayoutInflater();
                    //因为getView()返回的对象，adapter会自动赋给ListView
                    view = inflater.inflate(R.layout.my_add_friend_item, null);
                }else{
                    Log.i("info:", "有缓存，不需要重新生成"+position);
                    view = convertView;
                }
                AddFriendEntity item =items.get(position);

                CircleImageView userImg=  (CircleImageView)view.findViewById(R.id.my_add_friend_item_img);
                userImg.setImageResource(item.getImg());
                TextView name=(TextView) view.findViewById(R.id.my_add_friend_item_name);
                name.setText(item.getUsername());
                TextView jieshao=(TextView) view.findViewById(R.id.my_add_friend_item_jianjie);
                jieshao.setText(item.getJieshao());

                TextView leibie=(TextView) view.findViewById(R.id.my_add_friend_item_leibie);
                leibie.setText(item.getLeibie());
                return view;
            }
        });
    }
}
