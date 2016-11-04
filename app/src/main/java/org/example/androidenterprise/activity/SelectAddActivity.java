package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.SelectAddressAdapter;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by yangxinghua ：选择地址
 */
@ContentView(R.layout.activity_select_add)

public class SelectAddActivity extends AppCompatActivity {

    @ViewInject(R.id.lv_address)
    ListView addressLv;
    @ViewInject(R.id.btn_increase)
    Button increaseBtn;
    @ViewInject(R.id.topbar_select_add)
    TopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        final SelectAddressAdapter selectAddressAdapter = new SelectAddressAdapter(this);
        addressLv.setAdapter(selectAddressAdapter);

        addressLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectAddressAdapter.setCheckedPosition(position);
            }
        });
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("选择地址");
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

    @Event(value = {R.id.btn_increase})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_increase:
                // TODO: 跳到编辑地址页面（增加地址形式）
                Intent intent = new Intent().setClass(SelectAddActivity.this, EditAddActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("add_addr", "0");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}