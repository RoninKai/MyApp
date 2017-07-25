package zhou.anew.com.newapp.mvp.view.shoppingView;

import android.graphics.Paint;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import me.wangyuwei.shoppoing.ShoppingView;
import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.BaseActivity;
import zhou.anew.com.newapp.mvp.view.myView.SquareImageView;

public class Main3Activity extends BaseActivity {

    @Override
    public void initView() {
        initToolBar("饿了么下单按钮");

        ((TextView)findViewById(R.id.tv_money)).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        Picasso.with(this)
                .load("http://img03.sogoucdn.com/app/a/100520093/508de2a2df69f20f-ad54974be9c2600f-01f80ad8e3e76b8fe0205b58d9e59649.jpg")
                .resize(getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getWidth() / 2)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(((SquareImageView) findViewById(R.id.iv_shopping_pic)));

        ShoppingView sv_number_change= (ShoppingView)findViewById(R.id.sv_number_change);
        sv_number_change.setOnShoppingClickListener(new ShoppingView.ShoppingClickListener() {
            @Override
            public void onAddClick(int num) {

            }

            @Override
            public void onMinusClick(int num) {

            }
        });

    }

    @Override
    public int setContentView() {
        return R.layout.activity_main3;
    }
}
