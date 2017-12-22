package com.aliouswang.swipeback;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.aliouswang.swipeback.helper.SwipeHelper;

public class MainActivity extends AppCompatActivity {

    private Button btn_view_drag_helper;
    private Button btn_normal_swipe_back;
    public static final String ENCODE_SHOT_PIC = "encode_shot_bitmap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_main);
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
        btn_normal_swipe_back = findViewById(R.id.btn_normal_swipe_back);
        btn_normal_swipe_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalSwipeBackAct.class);
                startActivity(intent);
            }
        });

        btn_view_drag_helper = findViewById(R.id.btn_view_drag_helper);
        btn_view_drag_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewDragerHelperDemoAct.class);
                if(!TextUtils.isEmpty(encodeString)){
                    intent.putExtra(ENCODE_SHOT_PIC,encodeString);
                }
                startActivity(intent);
            }
        });
    }

}