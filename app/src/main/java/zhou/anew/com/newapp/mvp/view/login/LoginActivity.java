package zhou.anew.com.newapp.mvp.view.login;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.persenter.login.LoginPersenter;
import zhou.anew.com.newapp.mvp.view.BaseActivity;
import zhou.anew.com.newapp.mvp.view.myView.GifView;

public class LoginActivity extends BaseActivity implements ILoginView{

    private GifView gv_gif;
    private EditText et_login_name,et_login_pwd;
    private TextView tv_login;
    private LoginPersenter loginPersenter;
    private LinearLayout ll_login;

    @Override
    public int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        gv_gif = (GifView) findViewById(R.id.gv_gif);
        gv_gif.setMovieResource(R.mipmap.login);
        et_login_name = (EditText) findViewById(R.id.et_login_name);
        et_login_name.setText("1");
        et_login_pwd = (EditText) findViewById(R.id.et_login_pwd);
        et_login_pwd.setText("1");
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);
        ll_login = (LinearLayout) findViewById(R.id.ll_login);
        ll_login.bringToFront();
    }

    @Override
    public void initData() {
        super.initData();
        loginPersenter = new LoginPersenter(this,this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if(tv_login == view){
            loginPersenter.login();
        }
    }

    @Override
    public String getName() {
        return et_login_name.getText().toString();
    }

    @Override
    public String getPwd() {
        return et_login_pwd.getText().toString();
    }
}
