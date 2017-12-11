package com.nzf.markdown.study;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by zhanghongyang01 on 17/11/23.
 */

public class AdImageView extends AppCompatImageView {
    public AdImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private int mDx;
    private int mMinDx;

    public void setDx(int dx) {
        if (getDrawable() == null) {
            return;
        }
        mDx = dx - mMinDx;
        Log.i("Adimage","" + mDx);
        if (mDx <= 0) {
            mDx = 0;
        }

        if (mDx >= mMinDx - getDrawable().getBounds().width()) {
            mDx = mMinDx - getDrawable().getBounds().width();
        }

        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMinDx = w;
    }

    public int getDx() {
        return mDx;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mDx = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();
        int w = (int) (drawable.getIntrinsicWidth() * getHeight() * 1.0f / drawable.getIntrinsicHeight());
        int h = getHeight();
        drawable.setBounds(0, 0, w, h);
        canvas.save();
        canvas.translate(getDx(),0);
        super.onDraw(canvas);
        canvas.restore();
    }
}