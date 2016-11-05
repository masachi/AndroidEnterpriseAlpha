package org.example.androidenterprise.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.TopbarView;
import org.example.androidenterprise.adapter.StudentHeadListAdapter;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_students_head_list)

/**
 * Created by baiqingyu : 学员列表
 */
public class StudentsHeadListActivity extends Activity {
    @ViewInject(R.id.topbar_student_head_list)
    TopbarView topbar;
    @ViewInject(R.id.gv_students_head_list)
    CustomMeasureGridView studentsheadlistGv;

    private String number;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initData();
        setTopbar();
    }
    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("学员列表（"+number+"）");
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


    public void initData(){
        Bundle bundle = this.getIntent().getExtras();
        String num = bundle.getString("number");
        number = num;
        studentsheadlistGv.setAdapter(new StudentHeadListAdapter(this,Integer.valueOf(num)));

    }
}
