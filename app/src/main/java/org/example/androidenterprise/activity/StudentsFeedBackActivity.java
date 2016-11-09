package org.example.androidenterprise.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.StudentsFeedbackAdapter;
import org.example.androidenterprise.model.StudentsFeedBackEntity;
import org.example.androidenterprise.model.StudentsFeedbackRequestEntity;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.CLASS_TIME;
import static org.example.androidenterprise.utils.Constant.STUDENT_FEEDBACK_URL;

//Created by caishuang:学生反馈
@ContentView(R.layout.activity_students_feed_back)
public class StudentsFeedBackActivity extends AppCompatActivity {

    @ViewInject(R.id.topbar_student_feed_back)
    TopbarView topbar;
    @ViewInject(R.id.ib_instrument_info_back2)
    ImageButton instrumentInfoBack2Ib;
    @ViewInject(R.id.ib_instrument_info_next)
    ImageButton instrumentInfoNextIb;
    @ViewInject(R.id.lv_th)
    ListView lv_th;
    @ViewInject(R.id.tv_class_time)
    TextView classTimeTv;

    StudentsFeedBackEntity responseStudentsFeedBack;
    StudentsFeedbackAdapter studentsFeedbackAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        classTimeTv.setText("课时1");
        if (classTimeTv.getText().toString().equals("课时1")) {
            instrumentInfoBack2Ib.setClickable(false);
        }



    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("学员反馈");
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

    @Event(value = {R.id.ib_instrument_info_back2, R.id.ib_instrument_info_next})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_instrument_info_back2:
                CLASS_TIME = CLASS_TIME - 1;
                classTimeTv.setText("课时" + CLASS_TIME);
                instrumentInfoBack2Ib.setClickable(false);
                instrumentInfoNextIb.setClickable(true);
                if (classTimeTv.getText().toString().equals("课时1")) {
                    instrumentInfoBack2Ib.setClickable(false);
                    getInfo();
                }

                break;
            case R.id.ib_instrument_info_next:
                CLASS_TIME = CLASS_TIME + 1;
                classTimeTv.setText("课时" + CLASS_TIME);
                instrumentInfoBack2Ib.setClickable(true);
                if (classTimeTv.getText().toString().equals("课时3")) {
                    instrumentInfoNextIb.setClickable(false);
                }
                break;
        }
    }
    private void getInfo(){
        StudentsFeedbackRequestEntity studentsFeedbackRequest = new StudentsFeedbackRequestEntity();
        studentsFeedbackRequest.setClass_id(1);
        studentsFeedbackRequest.setTime_id(CLASS_TIME);
        RequestParams params = new RequestParams(STUDENT_FEEDBACK_URL);
        params.setAsJsonContent(true);
        params.setBodyContent(new Gson().toJson(studentsFeedbackRequest));
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("23333", result);
                responseStudentsFeedBack = new Gson().fromJson(result, new TypeToken<StudentsFeedBackEntity>() {
                }.getType());
                Log.e("hhhh", responseStudentsFeedBack.toString());
                studentsFeedbackAdapter = new StudentsFeedbackAdapter(getApplicationContext(), responseStudentsFeedBack.getTopic());
                lv_th.setAdapter(studentsFeedbackAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("233", "crrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
                ex.printStackTrace();

                Toast.makeText(StudentsFeedBackActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
