package zhou.anew.com.newapp.mvp.view.bannerView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.squareup.picasso.Picasso;

import zhou.anew.com.newapp.R;

/**
 * Created by zhoukai on 2017/7/19.
 */
public class LocalImageHolderView implements Holder<String>{ // Holder<Class>

    private ImageView imageView;
//    private TextView textView;
    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
//        //找到布局填充器
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        //找到整个xml布局
//        RelativeLayout rl = (RelativeLayout) inflater.inflate(R.layout.head_view, null);
//        //通过找到xml布局来找控件
//        imageView = (ImageView) rl.findViewById(R.id.iv_banner);
//        textView = (TextView) rl.findViewById(R.id.tv_banner);
//        //结果返回布局
//        return rl;

    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Picasso.with(context).load(data).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);
        //data可以是一个实体类
//        textView.setText(data.getTitle());
    }
}
