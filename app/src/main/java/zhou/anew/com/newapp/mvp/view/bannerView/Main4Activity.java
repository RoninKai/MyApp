package zhou.anew.com.newapp.mvp.view.bannerView;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;

import com.ToxicBakery.viewpager.transforms.ABaseTransformer;
import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.Arrays;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.BaseActivity;

public class Main4Activity extends BaseActivity implements OnItemClickListener,ViewPager.OnPageChangeListener {

    private ConvenientBanner cb_pic_show;
    @Override
    public void initView() {

        initToolBar("图片轮播器");

        String[] imageData = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
                "http://img03.sogoucdn.com/app/a/100520093/508de2a2df69f20f-ad54974be9c2600f-01f80ad8e3e76b8fe0205b58d9e59649.jpg",
                "http://d.3987.com/sqmy_131219/001.jpg",
                "http://img2.3lian.com/2014/f2/37/d/39.jpg",
                "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
                "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
                "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"};
        cb_pic_show = (ConvenientBanner) findViewById(R.id.cb_pic_show);
        cb_pic_show.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, Arrays.asList(imageData))        //设置数据
                .setOnItemClickListener(this)       //点击监听
                .setOnPageChangeListener(this)      //翻页监听
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)    //设置指示器的方向
                .startTurning(2000)  //设置切换速度（同时设置自动切换）
                .setPointViewVisible(true) //设置指示器是否可见  
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator,R.mipmap.ic_page_indicator_focused})     //设置指示器
                .setManualPageable(true);    //设置不能手动影响  
        try {
            //效果示例
            //DefaultTransformer     AccordionTransformer     BackgroundToForegroundTransformer
            // CubeInTransformer     CubeOutTransformer     DepthPageTransformer
            // FlipHorizontalTransformer     FlipVerticalTransformer     ForegroundToBackgroundTransformer
            // RotateDownTransformer     RotateUpTransformer     StackTransformer
            // ZoomInTransformer     ZoomOutTranformer
            String transforemerName =  AccordionTransformer.class.getSimpleName();
            Class cls = Class.forName("com.ToxicBakery.viewpager.transforms." + transforemerName);
            ABaseTransformer transformer = (ABaseTransformer) cls.newInstance();
            cb_pic_show.getViewPager().setPageTransformer(true,transformer);        //设置切换效果
            //部分3D特效需要调整滑动速度
            if (TextUtils.equals(transforemerName,"StackTransformer")) {
                cb_pic_show.setScrollDuration(1200);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int setContentView() {
        return R.layout.activity_main4;
    }

    @Override
    protected void onPause() {
        super.onPause();
        cb_pic_show.stopTurning();
    }

    @Override
    public void onItemClick(int position) {
        toast("点击的是第" + position + "个");
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
