package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.OrderAdapter;
import org.example.androidenterprise.view.CustomMeasureListView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_order)

public class OrderActivity extends BaseActivity {

    @ViewInject(R.id.lv_order)
    CustomMeasureListView orderLv;
    @ViewInject(R.id.topbar_order)
    TopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        // TODO: 2016/10/16 Add adapter in this place after server provide the port and URL

        OrderAdapter ordAdapter = new OrderAdapter(this);

        orderLv.setAdapter(ordAdapter);
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("预约订单");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Drawable ic_search = res.getDrawable(R.mipmap.ic_search);
        topbar.setRight1Ib(ic_search);
        topbar.getRight1Ib().setVisibility(View.VISIBLE);
        topbar.setRight1IbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SearchActivity.class));
            }
        });
    }
}
