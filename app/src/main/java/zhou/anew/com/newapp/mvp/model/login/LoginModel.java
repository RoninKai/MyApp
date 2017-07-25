package zhou.anew.com.newapp.mvp.model.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;

import zhou.anew.com.newapp.mvp.bean.UserBean;
import zhou.anew.com.newapp.mvp.view.myView.IBaseView;
import zhou.anew.com.newapp.mvp.view.login.ILoginView;
import zhou.anew.com.newapp.mvp.view.main.MainActivity;
import zhou.anew.com.newapp.other.SharedPreferencesUtils;

/**
 * Created by zhoukai on 2017/6/23.
 */
public class LoginModel implements ILoginModel {

    private Context context;
    private ILoginView loginView;
    public LoginModel(Context context, IBaseView loginView){
        this.context = context;
        this.loginView = (ILoginView) loginView;
    }
    @Override
    public void login(final String name, final String pwd) {
        final Dialog loadingDialog = loginView.createLoadingDialog(context);
        loadingDialog.setCancelable(false);
        if(TextUtils.isEmpty(name)){
            loginView.toast("请输入账号！");
            loginView.dismiss(loadingDialog);
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            loginView.toast("请输入密码！");
            loginView.dismiss(loadingDialog);
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    ((Activity)context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            UserBean userBean = new UserBean.Builder()
                                    .userName(name)
                                    .userPwd(pwd)
                                    .build();
                            loginView.dismiss(loadingDialog);
                            //网络请求
                            if(TextUtils.equals(userBean.getUserNmae(),"1") && TextUtils.equals(userBean.getUserPwd(),"1") ){
                                SharedPreferencesUtils sharedPreferencesUtils = SharedPreferencesUtils.getSharedPreferencesUtils();
                                sharedPreferencesUtils.saveString(context,"user_name",userBean.getUserNmae());
                                sharedPreferencesUtils.saveString(context,"user_pwd",userBean.getUserPwd());
                                sharedPreferencesUtils.saveBoolean(context,"user_login",true);
                                loginView.toActivity(context, MainActivity.class);
                                ((Activity)context).finish();
                                return;
                            }
                            loginView.toast("密码错误！");
                        }
                    });
                }
            }
        }).start();
    }
}
