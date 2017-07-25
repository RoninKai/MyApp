package zhou.anew.com.newapp.mvp.view.universalAdapter.fragment;

import android.view.View;
import android.widget.ExpandableListView;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.fragment.BaseFragment;

/**
 * Created by zhoukai on 2017/7/20.
 */
public class ExpandableListViewFragment extends BaseFragment{

    private ExpandableListView elv_data_show;
    @Override
    public int getLayout() {
        return R.layout.fragment_expandable_listview_layout;
    }

    @Override
    public void initViews(View view) {
        elv_data_show = (ExpandableListView) view.findViewById(R.id.elv_data_show);
    }

    @Override
    public void loadData() {

    }
}
