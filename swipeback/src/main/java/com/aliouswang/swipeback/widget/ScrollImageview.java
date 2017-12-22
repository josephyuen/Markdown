package com.aliouswang.swipeback.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Scroller;

/**
 * Created by joseph on 2017/12/22.
 */

public class ScrollImageview extends AppCompatImageView{
    private Scroller mScroller;
    public ScrollImageview(Context context) {
        this(context,null);
    }

    public ScrollImageview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScrollImageview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
        initAnimation();
    }


    private void initAnimation() {

    }


    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            Log.i("compute:",""+mScroller.getCurrX());
            layout(mScroller.getCurrX(),0,mScroller.getCurrX() + getWidth(),getHeight());

            invalidate();
        }
    }

    /**
     * @param direction 滚动方向 0左,1右
     * @param distance 滑动距离
     */
   public void startScroll(int direction,int distance){
       if(direction == 0){
           mScroller.startScroll(distance,0,0,0,100);
       }else{
           mScroller.startScroll(distance,0,-getWidth() / 4,0,100);
       }
       invalidate();
   }


}
