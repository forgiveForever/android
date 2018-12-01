package com.example.test.weibo.view;





import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.test.weibo.R;
import com.example.test.weibo.fragment.DiscoveryFragment;
import com.example.test.weibo.fragment.MainFragment;
import com.example.test.weibo.fragment.MessageFragment;
import com.example.test.weibo.fragment.MyFragment;
import com.example.test.weibo.fragment.SendFragment;


/**
 * Created by 13969 on 2018/9/29.
 */

public class WeiBoMain extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {



    private MainFragment mainFragment;
    private MyFragment myFragment;
    private SendFragment sendFragment;
    private MessageFragment messageFragment;
    private DiscoveryFragment discoveryFragment;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.weibo_main);
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home, "微博").setInactiveIconResource(R.drawable.home).setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.mess, "消息").setInactiveIconResource(R.drawable.mess).setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.add, "日迹").setInactiveIconResource(R.drawable.add).setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.fanxian, "发现").setInactiveIconResource(R.drawable.fanxian).setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.wode, "我的").setInactiveIconResource(R.drawable.wode).setActiveColor(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
        }

    @Override
    public void onTabSelected(int position) {
       Log.d("LQ", "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = this.getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();

      switch (position) {
            case 0:
                if (mainFragment == null) {
                    mainFragment = MainFragment.newInstance("微博");
                }
                transaction.replace(R.id.fragment_container, mainFragment);
                break;
            case 1:
                if (messageFragment == null) {
                    messageFragment = MessageFragment.newInstance("消息");
                }
                transaction.replace(R.id.fragment_container, messageFragment);
                break;
            case 2:
                if (sendFragment == null) {
                    sendFragment = SendFragment.newInstance("日迹");
                }
                transaction.replace(R.id.fragment_container, sendFragment);
                break;
            case 3:
                if (discoveryFragment == null) {
                    discoveryFragment = DiscoveryFragment.newInstance("发现");
                }
               transaction.replace(R.id.fragment_container, discoveryFragment);
                break;
          case 4:
              if (myFragment == null) {
                  myFragment = MyFragment.newInstance("我");
              }
              transaction.replace(R.id.fragment_container, myFragment);
              break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


    //设置初始界面
    private void setDefaultFragment() {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, MainFragment.newInstance("微博"));
        transaction.commit();
    }

}
