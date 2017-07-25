package zhou.anew.com.newapp.mvp.bean;

/**
 * Created by zhoukai on 2017/6/23.
 */

public class UserBean {
    private String userNmae;
    private String userPwd;


    public String getUserPwd() {
        return userPwd;
    }

    public String getUserNmae() {
        return userNmae;
    }

    UserBean(Builder builder){
        this.userNmae = builder.userNmae;
        this.userPwd = builder.userPwd;
    }

    public static class Builder{
        private String userNmae;
        private String userPwd;

        public Builder userName(String userNmae){
            this.userNmae = userNmae;
            return this;
        }
        public Builder userPwd(String userPwd){
            this.userPwd = userPwd;
            return this;
        }
        public UserBean build(){
            return new UserBean(this);
        }
    }

}
