package com.hxht.testparallaxeffects.ui;

import android.animation.IntEvaluator;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;

public class ResetAnimation extends Animation {

    private int startHeight;
    private int tragetHeight;
    private ImageView imageView;

    public ResetAnimation(ImageView imageView, int tragetHeight) {
        this.imageView = imageView ;
        this.startHeight = imageView.getHeight();
        this.tragetHeight = tragetHeight;
        this.setDuration(500);
        setInterpolator(new OvershootInterpolator());
        System.out.println("构造函数被调用了");
    }

    /**
     *
     * @param interpolatedTime：从0.0 ————> 到1.0的百分比
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        IntEvaluator intEvaluator = new IntEvaluator();
        Integer newHeight = intEvaluator.evaluate(interpolatedTime, startHeight, tragetHeight);
        System.out.println(startHeight);
        imageView.getLayoutParams().height = newHeight ;

        imageView.requestLayout();
    }
}
