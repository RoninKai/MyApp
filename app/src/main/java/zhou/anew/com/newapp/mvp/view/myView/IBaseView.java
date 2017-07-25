package zhou.anew.com.newapp.mvp.view.myView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by zhoukai on 2017/6/23.
 */

public interface IBaseView {

    void toast(String message);

    void toActivity(Context context, Class<? extends Activity> cla);

    void toActivity(Context context, Class<? extends Activity> cla, Bundle bundle);

    void toActivityForResult(Context context, Class<? extends Activity> cla,int requestCode);

    void toActivityForResult(Context context, Class<? extends Activity> cla, Bundle bundle,int requestCode);

    Dialog createLoadingDialog(Context context);

    void dismiss(Dialog dialog);
}
