package com.example.test.weibo.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.test.weibo.R;
import com.example.test.weibo.util.CircleImageView;
import com.example.test.weibo.view.mine.MyAddFriend;
import com.example.test.weibo.view.myhome.MainActivity;

/**
 * Created by 13969 on 2018/10/5.
 */

public class MyFragment extends Fragment {
    public static MyFragment newInstance(String param1) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public MyFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        CircleImageView user_head = (CircleImageView)view.findViewById(R.id.user_head);
        ImageView  my_add_friend = (ImageView) view.findViewById(R.id. my_add_friend );
        my_add_friend.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MyFragment.this.getActivity(),MyAddFriend.class);
                startActivity(intent);
            }
        });
        user_head.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MyFragment.this.getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
