package zhou.anew.com.newapp.mvp.view.universalAdapter.fragment;

import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.fragment.BaseFragment;
import zhou.anew.com.newapp.mvp.view.universalAdapter.adapter.CommonAdaper;
import zhou.anew.com.newapp.mvp.view.universalAdapter.adapter.ViewHolder;
import zhou.anew.com.newapp.mvp.view.universalAdapter.bean.ListViewAdapterBean;

/**
 * Created by zhoukai on 2017/7/20.
 */
public class ListViewFragment extends BaseFragment {
    private ListView lv_data_show;
    private List<ListViewAdapterBean> list;
    private CommonAdaper adaper;
    @Override
    public int getLayout() {
        return R.layout.fragment_listview_layout;
    }

    @Override
    public void initViews(View view) {
        lv_data_show = (ListView) view.findViewById(R.id.lv_data_show);
        list = new ArrayList<ListViewAdapterBean>();
        lv_data_show.setAdapter(adaper = new CommonAdaper<ListViewAdapterBean>(getContext(),list,R.layout.listview_item_layout) {
            @Override
            public void convert(ViewHolder holder, ListViewAdapterBean bean) {
                holder.setText(R.id.tv_str_show,bean.getMessage());
                holder.setSquareImageByUrl(R.id.qiv_pic_show,bean.getImaStr());
            }
        });
    }

    @Override
    public void loadData() {
        list.add(new ListViewAdapterBean.Buidler().message("①版权声明：本文为博主原创文章，未经博主允许不得转载。").imaStr("http://img03.sogoucdn.com/app/a/100520093/508de2a2df69f20f-ad54974be9c2600f-01f80ad8e3e76b8fe0205b58d9e59649.jpg").buidler());
        list.add(new ListViewAdapterBean.Buidler().message("②版权声明：本文为博主原创文章，未经博主允许不得转载。").imaStr("http://img.ctoy.com.cn/vipcom/longchangkt/2011611105337535.jpg").buidler());
        list.add(new ListViewAdapterBean.Buidler().message("③版权声明：本文为博主原创文章，未经博主允许不得转载。").imaStr("http://img.ctoy.com.cn/vipcom/cqllkt/20092221627280A.jpg").buidler());
        list.add(new ListViewAdapterBean.Buidler().message("④版权声明：本文为博主原创文章，未经博主允许不得转载。").imaStr("http://img.ctoy.com.cn/vipcom/etetoy/201269162420746.jpg").buidler());
        list.add(new ListViewAdapterBean.Buidler().message("⑤版权声明：本文为博主原创文章，未经博主允许不得转载。").imaStr("http://img.ctoy.com.cn/vipcom/hepingkt/2011319145313595.jpg").buidler());
        adaper.notifyDataSetChanged();
    }
}

