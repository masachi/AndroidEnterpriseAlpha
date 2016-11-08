package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.fragment.CourseFragment;
import org.example.androidenterprise.fragment.InstrumentFragment;
import org.example.androidenterprise.fragment.MineFragment;
import org.example.androidenterprise.utils.InitData;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static org.example.androidenterprise.utils.Constant.JUMP;

@ContentView(R.layout.activity_inside)

public class InsideActivity extends BaseActivity implements ViewPager.OnPageChangeListener {


    @ViewInject(R.id.vp_fragment)
    ViewPager fragmentVp;
    @ViewInject(R.id.iv_course)
    ImageView courseIv;
    @ViewInject(R.id.tv_course)
    TextView courseTv;
    @ViewInject(R.id.rl_course)
    RelativeLayout courseRl;
    @ViewInject(R.id.iv_mine)
    ImageView mineIv;
    @ViewInject(R.id.tv_mine)
    TextView mineTv;
    @ViewInject(R.id.rl_mine)
    RelativeLayout mineRl;
    @ViewInject(R.id.iv_instrument)
    ImageView instrumentIv;
    @ViewInject(R.id.tv_instrument)
    TextView instrumentTv;
    @ViewInject(R.id.rl_instrument)
    RelativeLayout instrumentRl;

    private List<Fragment> flist;
    private CourseFragment courseFragment;
    private MineFragment mineFragment;
    private InstrumentFragment instrumentFragment;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        InitData.initData(this);

        flist = new ArrayList<>();
        courseFragment = new CourseFragment();
        mineFragment = new MineFragment();
        instrumentFragment = new InstrumentFragment();
        flist.add(courseFragment);
        flist.add(mineFragment);
        flist.add(instrumentFragment);
        adapter = new FragmentAdapter(getSupportFragmentManager(), flist);
        fragmentVp.setAdapter(adapter);

        fragmentVp.setOnPageChangeListener(this);

        fragmentVp.setOffscreenPageLimit(3);
        if ( JUMP != 1){
            fragmentVp.setCurrentItem(2,false);
            change(2);
        }else {
            change(0);
        }
//        Intent intent = getIntent();
//        int position =Integer.parseInt(intent.getStringExtra("position"));
//        change(position);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                change(0);
                break;
            case 1:
                change(1);
                break;
            case 2:
                change(2);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private void change(int pos) {
        switch (pos) {
            case 0:
                courseTv.setTextColor(getResources().getColor(R.color.color_97c8cd));
                mineTv.setTextColor(getResources().getColor(R.color.color_999999));
                instrumentTv.setTextColor(getResources().getColor(R.color.color_999999));
                courseIv.setImageResource(R.mipmap.bottom_selected);
                mineIv.setImageResource(R.mipmap.bottom_normal);
                instrumentIv.setImageResource(R.mipmap.bottom_normal);
                break;
            case 1:
                courseTv.setTextColor(getResources().getColor(R.color.color_999999));
                mineTv.setTextColor(getResources().getColor(R.color.color_97c8cd));
                instrumentTv.setTextColor(getResources().getColor(R.color.color_999999));
                courseIv.setImageResource(R.mipmap.bottom_normal);
                mineIv.setImageResource(R.mipmap.bottom_selected);
                instrumentIv.setImageResource(R.mipmap.bottom_normal);
                break;
            case 2:
                courseTv.setTextColor(getResources().getColor(R.color.color_999999));
                mineTv.setTextColor(getResources().getColor(R.color.color_999999));
                instrumentTv.setTextColor(getResources().getColor(R.color.color_97c8cd));
                courseIv.setImageResource(R.mipmap.bottom_normal);
                mineIv.setImageResource(R.mipmap.bottom_normal);
                instrumentIv.setImageResource(R.mipmap.bottom_selected);
                break;
        }
    }

    @Event(value = {R.id.rl_course, R.id.rl_mine, R.id.rl_instrument})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_course:
                fragmentVp.setCurrentItem(0);
                change(0);
                break;
            case R.id.rl_mine:
                fragmentVp.setCurrentItem(1);
                change(1);
                break;
            case R.id.rl_instrument:
                fragmentVp.setCurrentItem(2);
                change(2);
                break;
        }
    }
}

class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public Fragment getItem(int fragment) {
        return fragments.get(fragment);
    }

    public int getCount() {
        return fragments.size();
    }

}
