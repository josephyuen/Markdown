package com.aliouswang.swipeback;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.widget.ViewDragHelper;
import android.text.TextUtils;
import android.util.Base64;

import com.aliouswang.swipeback.helper.SwipeHelper;

/**
 * Created by aliouswang on 16/2/18.
 */
public class ViewDragerHelperDemoAct extends Activity{
    public static final String ENCODE_SHOT_PIC = "encode_shot_bitmap";
    private SwipeHelper mSwipeHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_drag_helper_act_layout);
        mSwipeHelper = new SwipeHelper(this);
        mSwipeHelper.onActivityCreate();
        mSwipeHelper.setSwipeEdge(ViewDragHelper.EDGE_RIGHT);
        settlePic();
    }

    private void settlePic() {
        String encode = getIntent().getStringExtra(ENCODE_SHOT_PIC);
        if(!TextUtils.isEmpty(encode)){
            byte[] bytes = Base64.decode(encode,Base64.DEFAULT);
            Bitmap bimap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            BitmapDrawable drawable = new BitmapDrawable(getResources(),bimap);
            mSwipeHelper.setBottomPic(drawable);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeHelper.onPostCreate();
    }
}
