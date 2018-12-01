package com.example.test.weibo.fragment;


import android.Manifest;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.test.weibo.R;
import com.example.test.weibo.praseEntity.Item;
import com.example.test.weibo.util.CircleImageView;
import com.example.test.weibo.util.GridViewAdapter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;


/**
 * Created by 13969 on 2018/10/5.
 */

public class MainFragment extends Fragment {
    private ListView listView;
    final ArrayList<Item> items=new ArrayList<>();
    private PtrFrameLayout ptrFrameLayout;
    //private PtrClassicDefaultHeader ptrClassicDefaultHeader;
    //private MaterialHeader materialHeader;
    private StoreHouseHeader storeHouseHeader;
    private  PtrClassicDefaultFooter pfft;
    public static MainFragment newInstance(String param1) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {

    }
    private void requestWritePermission(){
        if (ActivityCompat.checkSelfPermission(MainFragment.this.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainFragment.this.getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWritePermission();

    }



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_fragment, container, false);
       /* EditText search=(EditText) view.findViewById(R.id.main_search) ;
       *//* search.clearFocus();
        search.setFocusable(true);
        search.setFocusableInTouchMode(true);
        search.requestFocus();
        search.findFocus();*//*
        InputMethodManager imm = (InputMethodManager)this.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(search.getWindowToken(),0);*/

        ptrFrameLayout=(PtrFrameLayout) view.findViewById(R.id.more_refresh);
        listView =(ListView) view.findViewById(R.id.listView) ;
        ImageView saomiao=(ImageView) view .findViewById(R.id.main_saomiao);
        saomiao.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        ImageView xiangji=(ImageView) view .findViewById(R.id.main_xiangji);

        xiangji.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        addListView();
        //String sdpath  = Environment.getExternalStorageDirectory().getAbsolutePath();
        File f =new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"img"+File.separator+"home.png");
        if(f.exists()){
            Log.i("LQ",f.getAbsolutePath());
        }
        //saveImg();

        for(int n=0;n<4;n++){
            Item item=new Item();
            item.setUser_name("小红");
            item.setStatus("转发");
            item.setText("这是内容");
            items.add(item);
        }

        initPtrRefresh();
        return view;
    }


    private void  initHeader(){
        storeHouseHeader = new StoreHouseHeader(this.getActivity());
        storeHouseHeader.setBackgroundColor(Color.BLACK);
        storeHouseHeader.setTextColor(Color.WHITE);
        storeHouseHeader.setLineWidth(5);
        storeHouseHeader.initWithString("LQ");
    }

    private void initFooter(){


    }

    private void initPtrRefresh(){
        //initHeader();
        PtrClassicDefaultHeader ptrClassicDefaultHeader=new PtrClassicDefaultHeader(this.getActivity());
        ptrFrameLayout.setHeaderView(ptrClassicDefaultHeader);
        ptrFrameLayout.addPtrUIHandler(ptrClassicDefaultHeader);
        PtrClassicDefaultFooter ptrClassicDefaultFooter = new PtrClassicDefaultFooter(this.getActivity());

        ptrFrameLayout.setFooterView(ptrClassicDefaultFooter);
        ptrFrameLayout.addPtrUIHandler(ptrClassicDefaultFooter);
        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                Log.i("LQ", "onLoadMoreBegin");
                frame.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                for(int n=0;n<4;n++){
                    Item item=new Item();
                    item.setUser_name("小红");
                    item.setStatus("转发");
                    item.setText("eeeeeee");
                    items.add(item);
                }
                addListView();
                Log.i("LQ", "onRefreshBegin");
                frame.refreshComplete();

            }

        });
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

                    LayoutInflater inflater = MainFragment.this.getActivity().getLayoutInflater();
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
                TextView  title=(TextView) view.findViewById(R.id.content_title);
                title.setText(item.getText()+":"+sdpath);
                TextView time =(TextView)view.findViewById(R.id.time);
                time.setText("2018-02-12");

                TextView content=(TextView)view.findViewById(R.id.content);
                content.setText("学习一门语言是需要过程的，虽然两个月的时间并不是很长，但是我们还是能学到一点东西的，而且学习也是自己的事儿，并不是其他可以帮助的，我学习android，首先了解Android apk的构成，主要是由 activity和layout布局文件还有一些图片组成，我在其中学到了activity的生命周期，开始创建一直到销毁的过程。还有布局文件，让我了解到了如何布局\n");
                GridView imgs=(GridView) view.findViewById(R.id.imgs);
                imgs= (GridView) setGrideView(imgs);
              /*  TextView username=(TextView) view.findViewById(R.id.user_name);
                username.setText("来自："+item.getUser_name());*/

                return view;
            }
        });
    }
    private void saveImg(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home);
        try {
            saveBitmapToFile(bitmap,"home.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void saveBitmapToFile(Bitmap bitmap, String imgPath)
            throws IOException {BufferedOutputStream os = null;
        try {
            String savePath= Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"img"+File.separator+imgPath;
            File file = new File(savePath);  //新建图片

            if (!file.exists()) {  //如果文件夹不存在，创建文件夹
                file.createNewFile();  //创建图片文件
                os = new BufferedOutputStream(new FileOutputStream(file));
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);  //图片存成png格式。
            }


        } finally {
            if (os != null) {
                try {
                    os.close();  //关闭流
                } catch (IOException e) {
                    Log.i("LQ", "保存文件失败");
                }
            }
        }
    }


    private  View setGrideView(GridView imgs){
        ArrayList<String> list=new ArrayList();
        list.add("home.png");
        list.add("home.png");
        imgs.setAdapter(new GridViewAdapter( MainFragment.this.getActivity(),list));
        return imgs;
    }
}
