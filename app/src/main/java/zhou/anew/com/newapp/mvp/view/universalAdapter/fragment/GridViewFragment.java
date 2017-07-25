package zhou.anew.com.newapp.mvp.view.universalAdapter.fragment;

import android.view.View;
import android.widget.GridView;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.fragment.BaseFragment;

/**
 * Created by zhoukai on 2017/7/20.
 * 代码同ListView
 */
public class GridViewFragment extends BaseFragment {
    private GridView gv_data_show;
    @Override
    public int getLayout() {
        return R.layout.fragment_gridview_layout;
    }

    @Override
    public void initViews(View view) {
        gv_data_show = (GridView) view.findViewById(R.id.gv_data_show);
    }

    @Override
    public void loadData() {

    }
}
