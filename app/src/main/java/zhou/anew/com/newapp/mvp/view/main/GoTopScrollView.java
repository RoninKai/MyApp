package zhou.anew.com.newapp.mvp.view.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

/**
 * Created by zhoukai on 2017/7/18.
 */
public class GoTopScrollView extends ScrollView implements View.OnClickListener {

    private ImageView imageView;
    private int screenHeight = 500;

    public GoTopScrollView(Context context) {
        super(context);
    }

    public GoTopScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public void setTextViewOnClickGoToFirst(ImageView imageView){
        this.imageView = imageView;
        this.imageView.setOnClickListener(this);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(screenHeight != 0){
            if(t > screenHeight){
                imageView.setVisibility(VISIBLE);
            }else{
                imageView.setVisibility(GONE);
            }
        }
    }

    @Override
    public void onClick(View view) {
        this.smoothScrollTo(0,0);
    }
}
