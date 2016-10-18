package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_edit_add)

public class EditAddActivity extends AppCompatActivity {

    @ViewInject(R.id.edit_add_return_ib)
    ImageButton returnIb;
    @ViewInject(R.id.edit_add_consignee_et)
    EditText consigneeEt;
    @ViewInject(R.id.edit_add_phonenum_et)
    EditText phonenumEt;
    @ViewInject(R.id.edit_add_detailed_et)
    EditText detailEt;
    @ViewInject(R.id.edit_add_rl_delete)
    RelativeLayout deleteRl;
    @ViewInject(R.id.edit_add_conserve)
    Button conserveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_add);
        x.view().inject(this);
        Intent intent = getIntent();
        if(intent.getExtras().get("add_addr").equals("0")){
            consigneeEt.setText("");
            phonenumEt.setText("");
            detailEt.setText("");
        }
        else
        {// TODO: setText(从List获取)
            consigneeEt.setText("收货人XXX");
            phonenumEt.setText("1334876630");
            detailEt.setText("山东省枣庄市XXX");
        }
    }

    @Event(value = {R.id.edit_add_return_ib, R.id.edit_add_rl_delete, R.id.edit_add_conserve})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_add_return_ib:
                finish();
                break;
            case R.id.edit_add_rl_delete:
                // TODO: 实现删除功能,上传到数据库
                break;
            case R.id.edit_add_conserve:
                // TODO: 实现按钮保存功能，上传到数据库
                break;
        }
    }
}