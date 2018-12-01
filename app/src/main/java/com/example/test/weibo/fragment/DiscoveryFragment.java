package com.example.test.weibo.fragment;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.test.weibo.R;
import com.example.test.weibo.util.GlideImageLoader;
import com.example.test.weibo.view.discovery.AdapterDiscoveryPage;
import com.example.test.weibo.view.discovery.FragmentHeadLine;
import com.example.test.weibo.view.discovery.FragmentList;
import com.example.test.weibo.view.discovery.FragmentVedio;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by 13969 on 2018/10/29.
 */

public class DiscoveryFragment extends Fragment {
    private   ViewPager viewpager;
    private TabLayout tabLayout;
    private ImageView iv;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    public static DiscoveryFragment newInstance(String param1) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle args = new Bundle();
       /* args.putString("agrs1", param1);
        fragment.setArguments(args);*/
        return fragment;
    }

    public DiscoveryFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  setContentView(R.layout.discovery_fragment);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar_layout);
        // iv = (ImageView) view.findViewById(R.id.iv);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // ((AppCompatActivity) this.getActivity()).setSupportActionBar(toolbar);
        // toolbar.setNavigationIcon(R.drawable.bg_home);
        collapsingToolbarLayout.setTitle("DesignLibrarySample");
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        //iv.setImageResource(R.mipmap.ic_bg);

        Banner banner = (Banner) findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<Integer> images= new ArrayList();

        images.add(R.drawable.guanggao_a);
        images.add(R.drawable.guanggao_b);
        images.add(R.drawable.gaunggao_c);
        images.add(R.drawable.guanggao_d);
        images.add(R.drawable.guanggao_e);
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        List<String> titles =new ArrayList<>();
        titles.add("小飞飞");
        titles.add("小飞飞");
        titles.add("小飞飞");
        titles.add("小飞飞");
        titles.add("小飞飞");
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();*/
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.discovery_fragment,container, false);
        collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);
       // iv = (ImageView) view.findViewById(R.id.iv);
        toolbar = (Toolbar) view.findViewById(R.id.discovery_toolbar);
      //  ( this.getActivity()).getSupportActionBar(toolbar);
       // toolbar.setNavigationIcon(R.drawable.bg_home);
        collapsingToolbarLayout.setTitle("DesignLibrarySample");
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        //iv.setImageResource(R.mipmap.ic_bg);

        Banner banner = (Banner) view.findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<Integer> images= new ArrayList();

        images.add(R.drawable.guanggao_a);
        images.add(R.drawable.guanggao_b);
        images.add(R.drawable.gaunggao_c);
        images.add(R.drawable.guanggao_d);
        images.add(R.drawable.guanggao_e);
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        List<String> titles =new ArrayList<>();
        titles.add("小飞飞");
        titles.add("小飞飞");
        titles.add("小飞飞");
        titles.add("小飞飞");
        titles.add("小飞飞");
       banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        viewpager = (ViewPager) view.findViewById(R.id.discovery_view_pager);
        tabLayout=(TabLayout) view.findViewById(R.id.discovery_tabs);
        initDiscoveryViewPager();
        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
      //  menu.clear();
    }

    public  void initDiscoveryViewPager(){

        AdapterDiscoveryPage page=new AdapterDiscoveryPage(getChildFragmentManager());
        page.addFragment(new FragmentVedio(),"视频");
        page.addFragment(new FragmentHeadLine(),"头条");
        viewpager.setAdapter(page);
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        viewpager.setCurrentItem(0);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tabLayout,30,30);
            }
        });

    }

    /**
     * 通过反射修改踏遍layout的宽，其实相当于margin
     * @param tabs
     * @param leftDip
     * @param rightDip
     */
    public void setIndicator (TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
