package org.example.androidenterprise.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.example.androidenterprise.fragment.CourseFragment;
import org.example.androidenterprise.fragment.MineFragment;
import org.example.androidenterprise.fragment.InstrumentFragment;

import java.util.ArrayList;
import java.util.List;

public class InsideActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager inside;
    private List<Fragment> flist;
    private CourseFragment courseFragment;
    private MineFragment mineFragment;
    private InstrumentFragment instrumentFragment;
    private ImageView imgIv_1;
    private ImageView imgIv_2;
    private ImageView imgIv_3;
    private TextView text_1;
    private TextView text_2;
    private TextView text_3;
    private FragmentPagerAdapter adapter;
    private RelativeLayout rl1;
    private RelativeLayout rl2;
    private RelativeLayout rl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);
        inside = (ViewPager) findViewById(R.id.main_viewpager);
        imgIv_1 = (ImageView) findViewById(R.id.bottom_image_1);
        imgIv_2 = (ImageView) findViewById(R.id.bottom_image_2);
        imgIv_3 = (ImageView) findViewById(R.id.bottom_image_3);
        text_1 = (TextView) findViewById(R.id.bottom_text_1);
        text_2 = (TextView) findViewById(R.id.bottom_text_2);
        text_3 = (TextView) findViewById(R.id.bottom_text_3);
        rl1 = (RelativeLayout) findViewById(R.id.rl1);
        rl2 = (RelativeLayout) findViewById(R.id.rl2);
        rl3 = (RelativeLayout) findViewById(R.id.rl3);


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
        rl1.setOnClickListener(this);
        rl2.setOnClickListener(this);
        rl3.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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

    private void change(int pos){
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
