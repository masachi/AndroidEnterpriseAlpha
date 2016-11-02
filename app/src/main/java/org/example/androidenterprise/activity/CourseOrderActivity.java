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

/**
 * Created by yangxinghua ：课程订购
 */
@ContentView(R.layout.activity_course_order)

public class CourseOrderActivity extends AppCompatActivity {

    @ViewInject(R.id.ib_return)
    ImageButton returnIb;
    @ViewInject(R.id.tv_account_name)
    TextView accountTv;
    @ViewInject(R.id.lv_course_order)
    ListView courseorderLv;
    @ViewInject(R.id.et_real_name)
    EditText realnameEt;
    @ViewInject(R.id.et_phonenum)
    EditText phonenumEt;
    @ViewInject(R.id.tv_price)
    TextView priceTv;
    @ViewInject(R.id.btn_confirm)
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = {R.id.ib_return, R.id.btn_confirm})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_return:
                finish();
                break;
            case R.id.btn_confirm:
                //TODO: 上传订购信息
                startActivity(new Intent(this,OrderPaymentActivity.class));
                break;
        }
    }
}