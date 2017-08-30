package com.ssoft.travel.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.ssoft.travel.R;
import com.ssoft.travel.adapter.MainPageAdapter;
import com.ssoft.travel.fragment.BaseFragment;
import com.ssoft.travel.fragment.DrinkFragment;
import com.ssoft.travel.fragment.FoodFragment;
import com.ssoft.travel.fragment.MineFragment;
import com.ssoft.travel.fragment.TravelFragment;
import com.ssoft.travel.service.daemon.DaemonWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silentlrb on 2017/8/2.
 * 主界面
 */

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<BaseFragment> mFragments = new ArrayList<>();  //主界面显示的fragment
    private int[] mIcon = new int[]{R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        // 保活
        DaemonWrapper.bindActivity(this,0);

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_content);
        mTabLayout = (TabLayout) findViewById(R.id.tl_menu);
        initFragments();

        mViewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager(),mFragments,this));
        mTabLayout.setupWithViewPager(mViewPager);
        initIcon();
    }

    /**
     * 初始化底部菜单的icon
     */
    private void initIcon() {
        for (int i = 0;i< mTabLayout.getTabCount() && i<mIcon.length;i++){
            mTabLayout.getTabAt(i).setIcon(mIcon[i]);
        }
    }

    /**
     * 初始化fragment
     */
    private void initFragments() {
        mFragments.add(new FoodFragment());
        mFragments.add(new DrinkFragment());
        mFragments.add(new TravelFragment());
        mFragments.add(new MineFragment());
    }
}
