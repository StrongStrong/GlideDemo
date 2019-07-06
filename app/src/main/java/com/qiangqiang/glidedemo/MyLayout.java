package com.qiangqiang.glidedemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;


public class MyLayout extends RelativeLayout {
    private ViewTarget<MyLayout, Drawable> viewTarget;
    private Context context;

    public MyLayout(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.context=context;
        viewTarget = new ViewTarget<MyLayout, Drawable>(this) {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                MyLayout myLayout = getView();
                myLayout.setImageAsBackground(resource);
            }




        };
    }

    public ViewTarget<MyLayout, Drawable> getTarget() {
        return viewTarget;
    }

    public void setImageAsBackground(Drawable drawable) {

        setBackground(drawable);
    }
}
