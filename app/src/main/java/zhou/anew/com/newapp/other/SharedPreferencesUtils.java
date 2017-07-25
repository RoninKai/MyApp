package zhou.anew.com.newapp.other;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhoukai on 2017/6/23.
 */

public class SharedPreferencesUtils {
    private static volatile SharedPreferencesUtils sharedPreferencesUtils = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferencesUtils(){}
    public static SharedPreferencesUtils getSharedPreferencesUtils(){
        if(sharedPreferencesUtils == null){
            synchronized (SharedPreferencesUtils.class){
                if(sharedPreferencesUtils == null){
                    sharedPreferencesUtils = new SharedPreferencesUtils();
                }
            }
        }
        return sharedPreferencesUtils;
    }

    public void saveString(Context context,String key,String value){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public String getString(Context context,String key){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        }
        return sharedPreferences.getString(key,"");
    }

    public void saveBoolean(Context context,String key,boolean value){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public boolean getBoolean(Context context,String key){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(key,false);
    }

}
