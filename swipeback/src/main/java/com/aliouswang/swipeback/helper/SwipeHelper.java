package com.aliouswang.swipeback.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;

import com.aliouswang.swipeback.R;
import com.aliouswang.swipeback.widget.BaseSwipeLayout;

import java.io.ByteArrayOutputStream;


/**
 * Created by Administrator on 2016/2/20 0020.
 */
public class SwipeHelper {

    private Activity mActivity;
    private BaseSwipeLayout mBaseSwipeLayout;

    public SwipeHelper(Activity activity) {
        this.mActivity = activity;
    }

    public void onActivityCreate() {
        mBaseSwipeLayout = (BaseSwipeLayout) LayoutInflater.from(mActivity)
                .inflate(R.layout.swipe_layout, null);
        mBaseSwipeLayout.setOnFinishScroll(new BaseSwipeLayout.OnFinishScroll() {
            @Override
            public void complete() {
                mActivity.finish();
                mActivity.overridePendingTransition(0,R.anim.activity_alpha_out);
            }
        });
    }

    public void onPostCreate() {
        mBaseSwipeLayout.attachToActivity(mActivity);
    }

    public void setSwipeEdge(int edgeFlag) {
        mBaseSwipeLayout.setSwipeEdge(edgeFlag);
    }

    /**
      set bottom Picture
     */
    public void setBottomPic(Drawable drawable) {
        mBaseSwipeLayout.setBottomPic(drawable);
    }

    public static String generaShot(Activity activity) {
        View dector = activity.getWindow().getDecorView();
        Bitmap bitmap = Bitmap.createBitmap(dector.getWidth(),dector.getHeight(),Bitmap.Config.ARGB_8888);
        dector.draw(new Canvas(bitmap));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
        byte[] bytes = baos.toByteArray();
        bytes = Base64.encode(bytes,Base64.DEFAULT);
        return new String(bytes);
    }
}
