package com.hxht.testparallaxeffects.customview;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ListView;

import com.hxht.testparallaxeffects.ui.ResetAnimation;

public class MyListView extends ListView {

    private ImageView headerView ;
    private int originHeight;
    private int maxHeight;

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setParallaxImageView(ImageView headerView) {
        this.headerView = headerView ;

        originHeight = headerView.getHeight();
        maxHeight = headerView.getDrawable().getIntrinsicHeight();
    }

    /**
     * 重写overScrollBy，能获取ListView下拉的距离
     *
     * @param deltaX:横向的变化量
     * @param deltaY：纵向的变化量
     * @param scrollX：横向X的偏移量
     * @param scrollY：纵向Y的偏移量
     * @param scrollRangeX：横向X偏移范围
     * @param scrollRangeY：纵向Y的偏移范围
     * @param maxOverScrollX：横向X最大的偏移量
     * @param maxOverScrollY：纵向Y最大的偏移量
     * @param isTouchEvent：是否是触摸产生的滑动超出
     * @return
     */
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

        if (isTouchEvent && deltaY < 0){

            int newHeight = (int) (headerView.getHeight() + Math.abs(deltaY /3.0f));

            //if (newHeight > maxHeight){
            //    newHeight = maxHeight ;
            //}
            newHeight = Math.min(newHeight,maxHeight);

            headerView.getLayoutParams().height = newHeight ;
            headerView.requestLayout();
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (MotionEventCompat.getActionMasked(ev) == MotionEvent.ACTION_UP){
            ResetAnimation resetAnimation = new ResetAnimation(headerView, originHeight);
            headerView.startAnimation(resetAnimation);
        }
        return super.onTouchEvent(ev);
    }
}
