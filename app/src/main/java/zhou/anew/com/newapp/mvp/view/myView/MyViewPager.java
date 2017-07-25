package zhou.anew.com.newapp.mvp.view.myView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by zhoukai on 2017/7/20.
 */

public class MyViewPager extends ViewPager {

    /**
     * 是否可以滑动
     */
    private boolean isCanScroll = true;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }
    /**
     * 让ViewPager不能左右滑动
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(isCanScroll){
            return super.onTouchEvent(ev);
        }else{
            return false;
        }
    }

    /**
     * 暴露出去的方法,屏蔽ViewPager的滑动,默认不可滑动
     * @param isCanScroll 为true可以左右滑动,为false不可滑动
     */
    public void setIsCanScroll(boolean isCanScroll){
        this.isCanScroll = isCanScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(isCanScroll){
            return super.onInterceptTouchEvent(ev);
        }else{
            return false;
        }
    }
}
