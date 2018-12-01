package com.example.test.weibo.view.sendinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.test.weibo.R;

/**
 * Created by 13969 on 2018/11/1.
 */

public class SendInfoText extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.send_info_wenzi);
        TextView wenzi_fan=(TextView) findViewById(R.id.wenzi_fan);
        wenzi_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
