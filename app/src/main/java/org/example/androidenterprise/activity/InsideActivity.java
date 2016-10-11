package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.fragment.CourseFragment;
import org.example.androidenterprise.fragment.InstrumentFragment;
import org.example.androidenterprise.fragment.MineFragment;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_inside)

public class InsideActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @ViewInject(R.id.main_viewpager)
    ViewPager inside;
    @ViewInject(R.id.bottom_image_1)
    ImageView imgIv_1;
    @ViewInject(R.id.bottom_text_1)
    TextView text_1;
    @ViewInject(R.id.rl1)
    RelativeLayout rl1;
    @ViewInject(R.id.bottom_image_2)
    ImageView imgIv_2;
    @ViewInject(R.id.bottom_text_2)
    TextView text_2;
    @ViewInject(R.id.rl2)
    RelativeLayout rl2;
    @ViewInject(R.id.bottom_image_3)
    ImageView imgIv_3;
    @ViewInject(R.id.bottom_text_3)
    TextView text_3;
    @ViewInject(R.id.rl3)
    RelativeLayout rl3;

    private List<Fragment> flist;
    private CourseFragment courseFragment;
    private MineFragment mineFragment;
    private InstrumentFragment instrumentFragment;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        flist = new ArrayList<>();
        courseFragment = new CourseFragment();
        mineFragment = new MineFragment();
        instrumentFragment = new InstrumentFragment();
        flist.add(courseFragment);
        flist.add(mineFragment);
        flist.add(instrumentFragment);
        adapter = new FragmentAdapter(getSupportFragmentManager(), flist);
        inside.setAdapter(adapter);

        inside.setOnPageChangeListener(this);

        inside.setOffscreenPageLimit(3);
        change(0);
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
                imgIv_1.setImageResource(R.mipmap.bottom_selected);
                imgIv_2.setImageResource(R.mipmap.bottom_normal);
                imgIv_3.setImageResource(R.mipmap.bottom_normal);
                text_1.setTextColor(getResources().getColor(R.color.bottom_color_selected));
                text_2.setTextColor(getResources().getColor(R.color.bottom_color_normal));
                text_3.setTextColor(getResources().getColor(R.color.bottom_color_normal));
                break;
            case 1:
                imgIv_1.setImageResource(R.mipmap.bottom_normal);
                imgIv_2.setImageResource(R.mipmap.bottom_selected);
                imgIv_3.setImageResource(R.mipmap.bottom_normal);
                text_1.setTextColor(getResources().getColor(R.color.bottom_color_normal));
                text_2.setTextColor(getResources().getColor(R.color.bottom_color_selected));
                text_3.setTextColor(getResources().getColor(R.color.bottom_color_normal));
                break;
            case 2:
                imgIv_1.setImageResource(R.mipmap.bottom_normal);
                imgIv_2.setImageResource(R.mipmap.bottom_normal);
                imgIv_3.setImageResource(R.mipmap.bottom_selected);
                text_1.setTextColor(getResources().getColor(R.color.bottom_color_normal));
                text_2.setTextColor(getResources().getColor(R.color.bottom_color_normal));
                text_3.setTextColor(getResources().getColor(R.color.bottom_color_selected));
                break;
        }
    }

    @Event(value = {R.id.rl1, R.id.rl2, R.id.rl3})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl1:
                inside.setCurrentItem(0);
                change(0);
                break;
            case R.id.rl2:
                inside.setCurrentItem(1);
                change(1);
                break;
            case R.id.rl3:
                inside.setCurrentItem(2);
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
