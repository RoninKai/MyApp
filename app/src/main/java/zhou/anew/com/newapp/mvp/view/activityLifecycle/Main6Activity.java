package zhou.anew.com.newapp.mvp.view.activityLifecycle;

import android.os.Bundle;
import android.util.Log;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.BaseActivity;

public class Main6Activity extends BaseActivity {

    @Override
    public void initView() {

    }

    @Override
    public int setContentView() {
        return R.layout.activity_main6;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("activity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("activity","onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("activity","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("activity","onRestoreInstanceState");
    }
}
