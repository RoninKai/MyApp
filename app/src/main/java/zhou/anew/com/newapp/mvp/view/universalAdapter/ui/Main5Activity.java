package zhou.anew.com.newapp.mvp.view.universalAdapter.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.BaseActivity;
import zhou.anew.com.newapp.mvp.view.myView.MyViewPager;
import zhou.anew.com.newapp.mvp.view.universalAdapter.fragment.ExpandableListViewFragment;
import zhou.anew.com.newapp.mvp.view.universalAdapter.fragment.GridViewFragment;
import zhou.anew.com.newapp.mvp.view.universalAdapter.fragment.ListViewFragment;

public class Main5Activity extends BaseActivity {

    private MyViewPager viewPager;
    private TabLayout tabLayout;
    private TabLayout.Tab listViewTab,gridViewTab,expandableListViewTab;
    private ListViewFragment listViewFragment;
    private GridViewFragment gridViewFragment;
    private ExpandableListViewFragment expandableListViewFragment;

    @Override
    public void initView() {
        initToolBar("万能的Adapter");
        viewPager = (MyViewPager) findViewById(R.id.vp_pager);
        tabLayout = (TabLayout) findViewById(R.id.tl_pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            private String[] pager_title = new String[]{"ListView","GridView","ExpandableListView"};
            @Override
            public Fragment getItem(int position) {
                if(position == 0){
                    listViewFragment = new ListViewFragment();
                    return listViewFragment;
                }else if(position == 1){
                    gridViewFragment = new GridViewFragment();
                    return gridViewFragment;
                }
                expandableListViewFragment = new ExpandableListViewFragment();
                return expandableListViewFragment;
            }

            @Override
            public int getCount() {
                return pager_title.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pager_title[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        listViewTab = tabLayout.getTabAt(0);
        gridViewTab = tabLayout.getTabAt(1);
        expandableListViewTab = tabLayout.getTabAt(2);
        viewPager.setCurrentItem(0);  //默认显示第几个选项卡
        viewPager.setOffscreenPageLimit(2);
    }

    @Override
    public int setContentView() {
        return R.layout.activity_main5;
    }
}

