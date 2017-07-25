package zhou.anew.com.newapp.mvp.view.gridViewAndPicasso;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.adapter.PicShowAdapter;
import zhou.anew.com.newapp.mvp.view.BaseActivity;
import zhou.anew.com.newapp.mvp.view.main.GoTopScrollView;
import zhou.anew.com.newapp.mvp.view.main.MyGridView;

public class Main2Activity extends BaseActivity {

    private GoTopScrollView sc_up;
    private MyGridView gv_pic_show;
    private PicShowAdapter adapter;
    private List<String> list;

    @Override
    public void initView() {

        initToolBar("GridView + Picasso + ScrollView置顶");

        findViewById(R.id.tv_began).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add("http://img03.sogoucdn.com/app/a/100520093/508de2a2df69f20f-ad54974be9c2600f-01f80ad8e3e76b8fe0205b58d9e59649.jpg");
                list.add("http://img.ctoy.com.cn/vipcom/longchangkt/2011611105337535.jpg");
                list.add("http://img.ctoy.com.cn/vipcom/cqllkt/20092221627280A.jpg");
                list.add("http://img.ctoy.com.cn/vipcom/etetoy/201269162420746.jpg");
                list.add("http://img.ctoy.com.cn/vipcom/hepingkt/2011319145313595.jpg");
                list.add("http://img.ctoy.com.cn/vipcom/cqllkt/20092261516520A.jpg");
                list.add("http://img01.jiuxian.com/upload/goods/13969/f/1389580907135.jpg");
                list.add("http://hao315tv.37cy.com/www/upload/2014-07-09/115542472.jpg");
                adapter.notifyDataSetChanged();
            }
        });

        sc_up = (GoTopScrollView) findViewById(R.id.sc_up);
        ImageView imageView = (ImageView) findViewById(R.id.iv_go_up);
        sc_up.setTextViewOnClickGoToFirst(imageView);
        sc_up.setScreenHeight(getWindowManager().getDefaultDisplay().getHeight());
        gv_pic_show = (MyGridView) findViewById(R.id.gv_pic_show);
        gv_pic_show.setOverScrollMode(View.OVER_SCROLL_NEVER);
        list = new ArrayList<>();
        adapter = new PicShowAdapter(this, list);
        gv_pic_show.setAdapter(adapter);

        list.add("http://img03.sogoucdn.com/app/a/100520093/508de2a2df69f20f-ad54974be9c2600f-01f80ad8e3e76b8fe0205b58d9e59649.jpg");
        list.add("http://img.ctoy.com.cn/vipcom/longchangkt/2011611105337535.jpg");
        list.add("http://img.ctoy.com.cn/vipcom/cqllkt/20092221627280A.jpg");
        list.add("http://img.ctoy.com.cn/vipcom/etetoy/201269162420746.jpg");
        list.add("http://img.ctoy.com.cn/vipcom/hepingkt/2011319145313595.jpg");
        list.add("http://img.ctoy.com.cn/vipcom/cqllkt/20092261516520A.jpg");
        list.add("http://img01.jiuxian.com/upload/goods/13969/f/1389580907135.jpg");
        list.add("http://hao315tv.37cy.com/www/upload/2014-07-09/115542472.jpg");
        adapter.notifyDataSetChanged();

    }

    @Override
    public int setContentView() {
        return R.layout.activity_main2;
    }

    @Override
    public void onBack() {
        super.onBack();
        //拦截ToolBar的返回按钮之后的操作
    }
}