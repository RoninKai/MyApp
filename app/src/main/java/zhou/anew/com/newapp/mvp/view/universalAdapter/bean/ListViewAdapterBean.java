package zhou.anew.com.newapp.mvp.view.universalAdapter.bean;

/**
 * Created by zhoukai on 2017/7/20.
 */

public class ListViewAdapterBean{
    private String message;

    public String getImaStr() {
        return imaStr;
    }

    public String getMessage() {
        return message;
    }

    private String imaStr;

    public ListViewAdapterBean(Buidler buidler){
        this.message = buidler.message;
        this.imaStr = buidler.imaStr;
    }

    public static class Buidler{
        private String message;
        private String imaStr;
        public Buidler message(String message){
            this.message = message;
            return this;
        }
        public Buidler imaStr(String imaStr){
            this.imaStr = imaStr;
            return this;
        }

        public ListViewAdapterBean buidler(){
            return new ListViewAdapterBean(this);
        }
    }
}