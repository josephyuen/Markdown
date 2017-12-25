package com.nzf.markdown.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 2017/12/23.
 */

public class FlowLayout extends ViewGroup{
    public FlowLayout(Context context) {this(context,null);}

    public FlowLayout(Context context, AttributeSet attrs) {this(context, attrs,0);}

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int width = 0;
        int height = 0;
        int lineWidth = 0;
        int lineHeight = 0;

        MarginLayoutParams lp;
        int childWidth,childHeight;
        for (int i = 0;i < getChildCount();i++){
            View child = getChildAt(i);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
            lp = (MarginLayoutParams) getLayoutParams();
            childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            childHeight = child.getMeasuredHeight() + lp.leftMargin + lp.rightMargin;
            if(lineWidth + childWidth > sizeWidth){
                width = Math.max(lineHeight,width);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
            }else{
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight,childHeight);
            }
            if(i == getChildCount() - 1){
                lineWidth = Math.max(width,lineWidth);
                height += lineHeight;
            }
            setMeasuredDimension(modeWidth == MeasureSpec.EXACTLY? sizeWidth : width,
                    modeHeight == MeasureSpec.EXACTLY? sizeHeight : height);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    private List<List<View>> mAllChildViews = new ArrayList<>();
    private List<Integer> mLineHeight = new ArrayList<>();
    List<View> lineViews = new ArrayList<>();

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllChildViews.clear();
        mLineHeight.clear();
        int width = getWidth();

        int lineWidth = 0;
        int lineHeight = 0;

        int childCount = getChildCount();
        for(int i = 0;i < childCount; i ++){
            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if(childWidth + lineWidth + lp.leftMargin + lp.rightMargin > width){
                mLineHeight.add(lineHeight);
                mAllChildViews.add(lineViews);
                lineWidth = 0;
                lineHeight = childHeight + lp.topMargin + lp.bottomMargin;
                lineViews.clear();
            }
            lineWidth += childWidth + lp.leftMargin + lp.rightMargin;
            lineHeight = Math.max(lineHeight, childHeight + lp.topMargin + lp.bottomMargin);
            lineViews.add(child);
        }

        mLineHeight.add(lineHeight);
        mAllChildViews.add(lineViews);


        int left = 0;
        int top = 0;

        int lineCount = mAllChildViews.size();
        for(int i = 0; i < lineCount; i ++){

            lineViews = mAllChildViews.get(i);
            lineHeight = mLineHeight.get(i);
            for(int j = 0; j < lineViews.size(); j ++){
                View child = lineViews.get(j);

                if(child.getVisibility() == View.GONE){
                    continue;
                }
                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
                int cLeft = left + lp.leftMargin;
                int cTop = top + lp.topMargin;
                int cRight = cLeft + child.getMeasuredWidth();
                int cBottom = cTop + child.getMeasuredHeight();

                child.layout(cLeft, cTop, cRight, cBottom);
                left += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            }
            left = 0;
            top += lineHeight;
        }
    }

}
