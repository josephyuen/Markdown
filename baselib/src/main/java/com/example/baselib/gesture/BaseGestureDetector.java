package com.example.baselib.gesture;

import android.content.Context;
import android.view.MotionEvent;

/**
 * Created by joseph on 2017/12/22.
 */

public abstract class BaseGestureDetector {

    boolean mGestureInProgress;
    MotionEvent mPreMotionEvent;
    private MotionEvent mCurrentMotionEvent;
    private Context mContext;

    public BaseGestureDetector(Context context){
        mContext = context;
    }

    public boolean onTouchEvent(MotionEvent event){
         if(!mGestureInProgress){
             handleStartProgressEvent(event);
         }else{
             handleInProgressEvent(event);
         }
        return true;
    }

    abstract void handleInProgressEvent(MotionEvent event);

    abstract void handleStartProgressEvent(MotionEvent event);

    abstract void updateStateByEvent(MotionEvent event);

    /**
     * 重置状态
     */
    void resetState(){
        if(mPreMotionEvent != null){
            mPreMotionEvent.recycle();
            mPreMotionEvent = null;
        }

        if(mCurrentMotionEvent != null){
            mCurrentMotionEvent.recycle();
            mCurrentMotionEvent = null;
        }
        mGestureInProgress = false;
    }

}
