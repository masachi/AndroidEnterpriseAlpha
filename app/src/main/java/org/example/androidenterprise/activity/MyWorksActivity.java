package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.MyWorksAdapter;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojiao : 我的作品
 */

@ContentView(R.layout.activity_my_works)
public class MyWorksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @ViewInject(R.id.gv_myworks)
    GridView gv_myworks;
    @ViewInject(R.id.topbar_my_works)
    TopbarView topbar;

    private int works_data[] = {R.drawable.ic_shoot, R.drawable.ic_works, R.drawable.ic_works, R.drawable.ic_works,
            R.drawable.ic_works, R.drawable.ic_works};
    private List<Integer> list_works;

    // TODO get works_data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();

        list_works = getWorksData();
        MyWorksAdapter myWorksAdapter = new MyWorksAdapter(getApplicationContext(), list_works);
        gv_myworks.setAdapter(myWorksAdapter);
        gv_myworks.setOnItemClickListener(this);
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("我的作品");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Drawable ic_delete = res.getDrawable(R.mipmap.ic_myworks_delete);
        topbar.setRight1Ib(ic_delete);
        topbar.getRight1Ib().setVisibility(View.VISIBLE);
        topbar.setRight1IbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyWorksActivity.this, MyWorksDeleteActivity.class));
            }
        });
    }

    private List<Integer> getWorksData() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < works_data.length; i++) {
            list.add(works_data[i]);
        }
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            startActivity(new Intent(this, VideoRecordActivity.class));
        } else {
            // TODO: 2016/11/2 video play
        }
    }
}
