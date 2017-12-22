package com.aliouswang.swipeback.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.aliouswang.swipeback.R;

/**
 * Created by aliouswang on 16/2/18.
 */
public class BaseSwipeLayout extends FrameLayout{

    private Context mContext;

    private View mDragView;

    private ViewDragHelper mViewDragHelper;

    private ViewDragHelper mBackDragHelper;

    private Point mAutoBackOrignalPoint = new Point();

    private Point mCurArrivePoint = new Point();

    private int mCurEdgeFlag = ViewDragHelper.EDGE_LEFT;
    private int mSwipeEdge = ViewDragHelper.EDGE_LEFT;

    public BaseSwipeLayout(Context context) {
        this(context, null);
    }

    public BaseSwipeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseSwipeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
        initBackDrag();
    }

    private void initBackDrag() {


    }

    public void setSwipeEdge(int swipeEdge) {
        this.mSwipeEdge = swipeEdge;
        mViewDragHelper.setEdgeTrackingEnabled(swipeEdge);
    }


    private void init() {

        mViewDragHelper = ViewDragHelper.create(this,1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return false;
            }



            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                distance = distance + dx / 3;
                if(distance >= 0){
                    imageView.layout(distance,0,distance + imageView.getWidth(),imageView.getHeight());
                }

                mCurArrivePoint.x = left;
                if (mCurEdgeFlag != ViewDragHelper.EDGE_BOTTOM) {
                    return left;
                }else return 0;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                mCurArrivePoint.y = top;
                if (mCurEdgeFlag == ViewDragHelper.EDGE_BOTTOM) {
                    return top;
                }else return 0;
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);

                if(mCurArrivePoint.x < -getWidth() / 2 && distance > 0){
                    ViewCompat.animate(imageView).translationX(-distance).setDuration(200).start();
                }else if(mCurArrivePoint.x >= -getWidth()/2 && distance > 0){
                  distance = getWidth() / 4 - distance;
                  ViewCompat.animate(imageView).translationX(distance).setDuration(200).start();
                }

                switch (mCurEdgeFlag) {
                    case ViewDragHelper.EDGE_LEFT:
                        if (mCurArrivePoint.x > getWidth()/2) {
                            mViewDragHelper.settleCapturedViewAt(getWidth(), mAutoBackOrignalPoint.y);
                        }else {
                            mViewDragHelper.settleCapturedViewAt(mAutoBackOrignalPoint.x, mAutoBackOrignalPoint.y);
                        }
                        break;
                    case ViewDragHelper.EDGE_RIGHT:
                        if (mCurArrivePoint.x < -getWidth()/2) {
                            mViewDragHelper.settleCapturedViewAt(-getWidth(), mAutoBackOrignalPoint.y);
                        }else {
                            mViewDragHelper.settleCapturedViewAt(mAutoBackOrignalPoint.x, mAutoBackOrignalPoint.y);
                        }
                        break;
                    case ViewDragHelper.EDGE_BOTTOM:
                        if (mCurArrivePoint.y < -getHeight()/2) {
                            mViewDragHelper.settleCapturedViewAt(mAutoBackOrignalPoint.x, -getHeight());
                        }else {
                            mViewDragHelper.settleCapturedViewAt(mAutoBackOrignalPoint.x, mAutoBackOrignalPoint.y);
                        }
                        break;
                }

                mCurArrivePoint.x = 0;
                mCurArrivePoint.y = 0;
                invalidate();
            }

            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                super.onViewPositionChanged(changedView, left, top, dx, dy);
                switch (mCurEdgeFlag) {
                    case ViewDragHelper.EDGE_LEFT:
                        if (left >= getWidth()) {
                            if (mFinishScroll != null) {
                                mFinishScroll.complete();
                            }
                        }
                        break;
                    case ViewDragHelper.EDGE_RIGHT:
                        if (left <= -getWidth()) {
                            if (mFinishScroll != null) {
                                mFinishScroll.complete();
                            }
                        }
                        break;
                    case ViewDragHelper.EDGE_BOTTOM:
                        if (top <= -getHeight()) {
                            if (mFinishScroll != null) {
                                mFinishScroll.complete();
                            }
                        }
                        break;
                }
            }

            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                imageView.clearAnimation();
                distance = getWidth() / 4;
                imageView.layout(distance,0,imageView.getMeasuredWidth() + distance,imageView.getMeasuredHeight());
                mCurEdgeFlag = edgeFlags;
                if (mDragView == null) mDragView = getChildAt(1);
                mViewDragHelper.captureChildView(mDragView, pointerId);
            }
        });

        mViewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
    }

    @Override
    public void computeScroll() {
        if (mViewDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            mDragView = getChildAt(1);
        }
    }

    private OnFinishScroll mFinishScroll;

    public void setOnFinishScroll(OnFinishScroll finishScroll) {
        this.mFinishScroll = finishScroll;
    }

    /**
      reset background
     */
    public void setBottomPic(Drawable drawable) {
        this.backDrawable = drawable;
    }

    private Drawable backDrawable;
    private ScrollImageview imageView;

    public interface OnFinishScroll {
        void complete();
    }

    int distance;
    private Activity mActivity;

    public void attachToActivity(Activity activity) {

        this.mActivity = activity;
        TypedArray a = activity.getTheme().obtainStyledAttributes(new int[]{
                android.R.attr.windowBackground
        });
        int background = a.getResourceId(0, 0);
        a.recycle();
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup decorChild = (ViewGroup) decorView.getChildAt(0);
        decorChild.setBackgroundResource(background);
        decorView.removeView(decorChild);

        LayoutInflater.from(mActivity).inflate(R.layout.item_imageview,this,true);
        imageView = (ScrollImageview) getChildAt(0);

        if(backDrawable != null){
            imageView.setBackground(backDrawable);
        }

        addView(decorChild);
        decorView.addView(this);
    }

}
