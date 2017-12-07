package com.study.joseph.screenfit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.ScreenFitUtil.R;

/**
 * Created by joseph on 2017/12/7.
 */

public class SupportMultipleScreensUtil {
    //缩放的基准
    public static final int BASE_SCREEN_WIDTH = 1080;
    public static final int BASE_SCREEN_HEIGHT = 1920;
    private static final float BASE_SCREEN_WIDTH_FLOAT = 1080F;
    public static final float BASE_SCREEN_HEIGHT_FLOAT = 1920F;
    //缩放比
    private static float scale = 1.0F;

    public SupportMultipleScreensUtil() { }

    public static void init(Context context) {
        Resources resources=context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        scale = (float)widthPixels / BASE_SCREEN_WIDTH_FLOAT;
    }

    private static int getScaleValue(int value) {
        return (int)Math.ceil((double)(scale * (float)value));
    }


    public static void scale(View view) {
        if(null != view) {

            if(view instanceof ViewGroup) {
                scaleViewGroup((ViewGroup)view);
            } else {
                scaleView(view);
            }
        }
    }

    private static void scaleViewGroup(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); ++i) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                scaleViewGroup((ViewGroup) view);
            }
            scaleView(view);
        }
    }

    private static void scaleView(View view) {
        Object isScale = view.getTag(R.id.is_scale_size_tag);
        if (!(isScale instanceof Boolean) || !(Boolean) isScale) {
            if (view instanceof TextView) {
                scaleTextView((TextView) view);//缩放textview控件大小
            } else {
                scaleViewSize(view);//缩放文字大小
            }
            view.setTag(R.id.is_scale_size_tag, Boolean.TRUE);
        }
    }



    private static void scaleViewSize(View view) {
        if (null != view) {
            int paddingLeft = getScaleValue(view.getPaddingLeft());
            int paddingTop = getScaleValue(view.getPaddingTop());
            int paddingRight = getScaleValue(view.getPaddingRight());
            int paddingBottom = getScaleValue(view.getPaddingBottom());
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);

            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

            if (null != layoutParams) {

                if (layoutParams.width > 0) {
                    layoutParams.width = getScaleValue(layoutParams.width);
                }

                if (layoutParams.height > 0) {
                    layoutParams.height = getScaleValue(layoutParams.height);
                }

                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int topMargin = getScaleValue(marginLayoutParams.topMargin);
                    int leftMargin = getScaleValue(marginLayoutParams.leftMargin);
                    int bottomMargin = getScaleValue(marginLayoutParams.bottomMargin);
                    int rightMargin = getScaleValue(marginLayoutParams.rightMargin);
                    marginLayoutParams.topMargin = topMargin;
                    marginLayoutParams.leftMargin = leftMargin;
                    marginLayoutParams.bottomMargin = bottomMargin;
                    marginLayoutParams.rightMargin = rightMargin;
                }
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private static void setTextViewCompoundDrawables(TextView textView, Drawable leftDrawable, Drawable topDrawable, Drawable rightDrawable, Drawable bottomDrawable) {
        if(null != leftDrawable) {
            scaleDrawableBounds(leftDrawable);
        }

        if(null != rightDrawable) {
            scaleDrawableBounds(rightDrawable);
        }

        if(null != topDrawable) {
            scaleDrawableBounds(topDrawable);
        }

        if(null != bottomDrawable) {
            scaleDrawableBounds(bottomDrawable);
        }

        textView.setCompoundDrawables(leftDrawable, topDrawable, rightDrawable, bottomDrawable);
    }

    private static Drawable scaleDrawableBounds(Drawable drawable) {
        int right=getScaleValue(drawable.getIntrinsicWidth());
        int bottom=getScaleValue(drawable.getIntrinsicHeight());
        drawable.setBounds(0, 0, right, bottom);
        return drawable;
    }

    private static void scaleTextView(TextView textView) {
        if (null != textView) {

            scaleViewSize(textView);

            Object isScale = textView.getTag(R.id.is_scale_font_tag);
            if (!(isScale instanceof Boolean) || !(Boolean) isScale) {
                float size = textView.getTextSize();
                size *= scale;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
            }

            Drawable[] drawables = textView.getCompoundDrawables();
            Drawable leftDrawable = drawables[0];
            Drawable topDrawable = drawables[1];
            Drawable rightDrawable = drawables[2];
            Drawable bottomDrawable = drawables[3];
            setTextViewCompoundDrawables(textView, leftDrawable, topDrawable, rightDrawable, bottomDrawable);
            int compoundDrawablePadding = getScaleValue(textView.getCompoundDrawablePadding());
            textView.setCompoundDrawablePadding(compoundDrawablePadding);
        }
    }


}
