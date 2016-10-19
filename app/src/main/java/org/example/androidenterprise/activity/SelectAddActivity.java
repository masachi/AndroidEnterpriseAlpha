package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_select_add)

public class SelectAddActivity extends AppCompatActivity {

    @ViewInject(R.id.select_add_return_ib)
    ImageButton returnImgBtn;
    @ViewInject(R.id.select_add_rg)
    RadioGroup radioGroup;
    @ViewInject(R.id.select_add_increase_btn)
    Button increaseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = {R.id.select_add_return_ib, R.id.select_add_rg, R.id.select_add_increase_btn})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_add_return_ib:
                finish();
                break;
            case R.id.select_add_rg:
                //TODO: 实现单选功能
                break;
            // TODO: “编辑” 跳到编辑页面
            case R.id.select_add_increase_btn:
                // TODO: 跳到编辑地址页面（增加地址形式）
                Intent intent = new Intent().setClass(SelectAddActivity.this, EditAddActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("add_addr","0");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}