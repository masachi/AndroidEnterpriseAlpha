package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_course_order)

public class CourseOrderActivity extends AppCompatActivity {

    @ViewInject(R.id.course_order_return_ib)
    ImageButton returnImgBtn;
    @ViewInject(R.id.course_order_account_name)
    TextView accountTv;
    @ViewInject(R.id.course_order_lv)
    ListView courseorderLv;
    @ViewInject(R.id.course_order_real_name)
    EditText realnameEt;
    @ViewInject(R.id.course_order_phonenum)
    EditText phonenumEt;
    @ViewInject(R.id.course_order_price)
    TextView priceTv;
    @ViewInject(R.id.course_order_confirm)
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = {R.id.course_order_return_ib, R.id.course_order_})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.course_order_return_ib:
                finish();
                break;
            case R.id.course_order_confirm:
                //TODO: 上传订购信息
                break;
        }
    }
}