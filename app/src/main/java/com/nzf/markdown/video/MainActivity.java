package com.nzf.markdown.video;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.aliouswang.swipeback.NormalSwipeBackAct;
import com.aliouswang.swipeback.helper.SwipeHelper;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btn_view_drag_helper;
    private Button btn_normal_swipe_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.aliouswang.swipeback.R.layout.activity_module_main);
        initView();
    }

    private boolean isFirst = true;

    @Override
    protected void onResume() {
        super.onResume();
        if(isFirst){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    encodeString = SwipeHelper.generaShot(MainActivity.this);
                }
            }, 500);
        }
    }

    private String encodeString;

    private void initView() {
        btn_normal_swipe_back = findViewById(com.aliouswang.swipeback.R.id.btn_normal_swipe_back);
        btn_normal_swipe_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalSwipeBackAct.class);
                startActivity(intent);


            }
        });

        btn_view_drag_helper = findViewById(com.aliouswang.swipeback.R.id.btn_view_drag_helper);
        btn_view_drag_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  switchLanguage();
                  startActivity(new Intent(MainActivity.this,MainActivity.class));
                  finish();
                  overridePendingTransition(0, com.aliouswang.swipeback.R.anim.activity_alpha_out);

//                Intent intent = new Intent(MainActivity.this, ViewDragerHelperDemoAct.class);
//                if(!TextUtils.isEmpty(encodeString)){
//                    intent.putExtra(ENCODE_SHOT_PIC,encodeString);
//                }
//                startActivity(intent);


            }
        });
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this,VideoListActivity.class));
        super.onBackPressed();
    }

    private void switchLanguage(){
        Configuration config = getResources().getConfiguration();
        if(config.locale == Locale.SIMPLIFIED_CHINESE){
            config.locale = Locale.ENGLISH;
        }else {
            config.locale = Locale.SIMPLIFIED_CHINESE;
        }
        getApplicationContext().getResources().updateConfiguration(config,getResources().getDisplayMetrics());
    }

}