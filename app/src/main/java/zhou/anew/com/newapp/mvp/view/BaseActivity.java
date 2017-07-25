package zhou.anew.com.newapp.mvp.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.myView.IBaseView;

/**
 * Created by zhoukai on 2017/6/23.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener,IBaseView {
    private Toolbar toolbar;
    private Window window;
    private boolean isInterceptBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        initView();
        initData();
    }

    public void initToolBar(String title){
        toolbar = (Toolbar) findViewById(R.id.tb_title);
        toolbar.setTitle("");
        toolbar.setSubtitle(title);
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.back));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void initToolBar(String title,boolean isInterceptBack){
        toolbar = (Toolbar) findViewById(R.id.tb_title);
        toolbar.setTitle("");
        toolbar.setSubtitle(title);
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.back));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.isInterceptBack = isInterceptBack;
    }

    public void initData(){}

    public void onBack(){}

    @Override
    public void onClick(View view) {}

    public abstract void initView();
    public abstract int setContentView();

    @Override
    public void toast(String message) {
        Toast.makeText(this,message + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toActivity(Context context, Class<? extends Activity> cla) {
        Intent intent = new Intent(this,cla);
        startActivity(intent);
    }

    @Override
    public void toActivity(Context context, Class<? extends Activity> cla, Bundle bundle) {
        Intent intent = new Intent(this,cla);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void toActivityForResult(Context context, Class<? extends Activity> cla, int requestCode) {
        Intent intent = new Intent(this,cla);
        startActivityForResult(intent,requestCode);
    }

    @Override
    public void toActivityForResult(Context context, Class<? extends Activity> cla, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this,cla);
        intent.putExtras(bundle);
        startActivityForResult(intent,requestCode);
    }

    @Override
    public Dialog createLoadingDialog(Context context) {
        Dialog progressDialog = new Dialog(context, R.style.progress_dialog);
        progressDialog.setContentView(R.layout.progress);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window = getWindow();
        if(window != null){
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.alpha = 0.5f;
            window.setAttributes(layoutParams);
        }
        progressDialog.show();
        return progressDialog;
    }

    @Override
    public void dismiss(Dialog dialog) {
        if(dialog != null){
            if(window == null){
                window = getWindow();
            }
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.alpha = 1.0f;
            window.setAttributes(layoutParams);
            dialog.dismiss();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            if(isInterceptBack){
                onBack();
            }else {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
