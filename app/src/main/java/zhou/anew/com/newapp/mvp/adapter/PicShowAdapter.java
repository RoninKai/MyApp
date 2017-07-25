package zhou.anew.com.newapp.mvp.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.myView.SquareImageView;

/**
 * Created by zhoukai on 2017/7/18.
 */
public class PicShowAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    public PicShowAdapter(Context context,List<String> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pic_show_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_pic_item_show = (SquareImageView) view.findViewById(R.id.iv_pic_item_show);
            viewHolder.pb_wait = (ProgressBar) view.findViewById(R.id.pb_wait);
            viewHolder.tv_money = (TextView) view.findViewById(R.id.tv_money);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_money.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        viewHolder.pb_wait.setVisibility(View.VISIBLE);
        Picasso.with(context).load(list.get(i)).into(viewHolder.iv_pic_item_show, new Callback() {
                    @Override
                    public void onSuccess() {
                        viewHolder.pb_wait.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        viewHolder.pb_wait.setVisibility(View.GONE);
                        viewHolder.iv_pic_item_show.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_launcher));
                    }
                });
        return view;
    }

    class ViewHolder {
        SquareImageView iv_pic_item_show;
        ProgressBar pb_wait;
        TextView tv_money;
    }
}

