package zhou.anew.com.newapp.mvp.view.main;

import android.view.View;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.BaseActivity;
import zhou.anew.com.newapp.mvp.view.activityLifecycle.Main6Activity;
import zhou.anew.com.newapp.mvp.view.bannerView.Main4Activity;
import zhou.anew.com.newapp.mvp.view.gridViewAndPicasso.Main2Activity;
import zhou.anew.com.newapp.mvp.view.shoppingView.Main3Activity;
import zhou.anew.com.newapp.mvp.view.universalAdapter.ui.Main5Activity;

public class MainActivity extends BaseActivity {

    @Override
    public void initView() {}

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    public void startGridView(View view){
       toActivity(this,Main2Activity.class);
    }

    public void startShoppingView(View view){
        toActivity(this,Main3Activity.class);
    }

    public void startConvenientBanner(View view){
        toActivity(this,Main4Activity.class);
    }

    public void startUniversalAdapter(View view){
        toActivity(this,Main5Activity.class);
    }

    public void startActivity(View view){
        toActivity(this,Main6Activity.class);
    }
}
