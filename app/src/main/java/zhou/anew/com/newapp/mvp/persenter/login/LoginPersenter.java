package zhou.anew.com.newapp.mvp.persenter.login;

import android.content.Context;

import zhou.anew.com.newapp.mvp.model.login.ILoginModel;
import zhou.anew.com.newapp.mvp.model.login.LoginModel;
import zhou.anew.com.newapp.mvp.view.login.ILoginView;

/**
 * Created by zhoukai on 2017/6/23.
 */
public class LoginPersenter {

    private ILoginModel loginModel;
    private ILoginView loginView;

    public LoginPersenter(Context context,ILoginView loginView){
        this.loginView = loginView;
        loginModel = new LoginModel(context,loginView);
    }

    /**
     * 登录操作
     */
    public void login(){
        loginModel.login(loginView.getName(),loginView.getPwd());
    }

}
