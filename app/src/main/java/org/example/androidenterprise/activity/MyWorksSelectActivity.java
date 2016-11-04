package org.example.androidenterprise.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by chenguojiao : 选择作品
 */

@ContentView(R.layout.activity_my_works_select)
public class MyWorksSelectActivity extends AppCompatActivity {

    @ViewInject(R.id.gv_myworks)
    CustomMeasureGridView gv_myworks;
    @ViewInject(R.id.btn_confirm)
    Button btn_confirm;
    @ViewInject(R.id.topbar_my_works_select)
    TopbarView topbar;

// TODO get works_data and select

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
    }
    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("选择作品");
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
}
