package zhou.anew.com.newapp.mvp.view.splash;

import android.text.TextUtils;
import android.view.WindowManager;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.BaseActivity;
import zhou.anew.com.newapp.mvp.view.myView.GifView;
import zhou.anew.com.newapp.mvp.view.login.LoginActivity;
import zhou.anew.com.newapp.mvp.view.main.MainActivity;
import zhou.anew.com.newapp.other.SharedPreferencesUtils;

public class SplashActivity extends BaseActivity {

    private GifView gv_splash;

    @Override
    public void initView() {
        gv_splash = (GifView) findViewById(R.id.gv_splash);
        gv_splash.setMovieResource(R.mipmap.splash);
    }

    @Override
    public int setContentView() {
        //设置登录界面全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
        super.initData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            SharedPreferencesUtils sharedPreferencesUtils = SharedPreferencesUtils.getSharedPreferencesUtils();
                            if(!TextUtils.isEmpty(sharedPreferencesUtils.getString(SplashActivity.this,"user_name"))
                                    && !TextUtils.isEmpty(sharedPreferencesUtils.getString(SplashActivity.this,"user_pwd"))
                                    && sharedPreferencesUtils.getBoolean(SplashActivity.this,"user_login")){
                                toActivity(SplashActivity.this, MainActivity.class);
                            }else {
                                toActivity(SplashActivity.this, LoginActivity.class);
                            }
                            finish();
                        }
                    });
                }
            }
        }).start();
    }
}
