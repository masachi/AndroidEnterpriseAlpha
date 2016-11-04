package org.example.androidenterprise.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.MyWorksAdapter;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojiao : 删除作品
 */

@ContentView(R.layout.activity_my_works_delete)
public class MyWorksDeleteActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.gv_myworks)
    CustomMeasureGridView gv_myworks;
    @ViewInject(R.id.btn_delete)
    Button btn_delete;
    @ViewInject(R.id.topbar_my_works_delete)
    TopbarView topbar;

    private int works_data[] = {R.drawable.ic_works, R.drawable.ic_works, R.drawable.ic_works,
            R.drawable.ic_works, R.drawable.ic_works};
    private List<Integer> list_works;
    MyWorksAdapter myWorksAdapter;

    // TODO get works_data and  delete
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        btn_delete.setText("删除");
        btn_delete.setOnClickListener(this);

        list_works = getWorksData();
        myWorksAdapter = new MyWorksAdapter(getApplicationContext(), list_works);
        gv_myworks.setAdapter(myWorksAdapter);
        gv_myworks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list_works.remove(i);
            }
        });
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("删除");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_delete:
                myWorksAdapter.notifyDataSetChanged();
            default:
                break;
        }
    }

    private List<Integer> getWorksData() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < works_data.length; i++) {
            list.add(works_data[i]);
        }
        return list;
    }
}
