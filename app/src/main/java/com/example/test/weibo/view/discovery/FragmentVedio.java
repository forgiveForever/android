package com.example.test.weibo.view.discovery;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.test.weibo.R;
import com.example.test.weibo.praseEntity.NearbyEntity;

import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13969 on 2018/11/2.
 */

public class FragmentVedio extends Fragment {
    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_listview, null);
        listView=(ListView)view.findViewById(R.id.my_home_list) ;
        List<NearbyEntity> list =new ArrayList<>();
        for(int n=0; n<4;n++){
            NearbyEntity nearbyEntity =new NearbyEntity();
            nearbyEntity.setName("小飞飞");
            nearbyEntity.setComment("1");
            nearbyEntity.setContent("小飞飞的生活很痛苦");
            nearbyEntity.setDistance("4km");
            nearbyEntity.setFabulous("6");
            nearbyEntity.setVediopath("sdfsfs");
            nearbyEntity.setReprint("5989");
            list.add(nearbyEntity);
        }
        listView.setAdapter(new ListViewAdapter(list,FragmentVedio.this.getActivity()));
        return view;
    }
}
