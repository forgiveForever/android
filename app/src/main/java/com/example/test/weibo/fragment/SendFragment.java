package com.example.test.weibo.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.test.weibo.R;
import com.example.test.weibo.view.myhome.MainActivity;
import com.example.test.weibo.view.sendinfo.SendInfoText;

/**
 * Created by 13969 on 2018/10/5.
 */

public class SendFragment extends Fragment {
    private View addButton;
    private View mPanelView;
    private View mCloseButton;
    private View mIdeaButton;
    private View mPhotoButton;
    private View mWeiboButton;
    private View mLbsButton;
    private View mReviewButton;
    private View mMoreButton;

    public static SendFragment newInstance(String param1) {
        SendFragment fragment = new SendFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public SendFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.center_music_more_window, container, false);
        ImageView  wenzi=(ImageView) view.findViewById(R.id.send_wenzi);
        wenzi.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SendFragment.this.getActivity(),SendInfoText.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
