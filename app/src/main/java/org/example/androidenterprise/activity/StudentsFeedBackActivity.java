package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.StudentsFeedbackAdapter;
import org.example.androidenterprise.model.CourseEntity;
import org.example.androidenterprise.model.StudentsFeedBackEntity;
import org.example.androidenterprise.model.StudentsFeedbackRequestEntity;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.STUDENT_FEEDBACK_URL;

//Created by caishuang:学生反馈
@ContentView(R.layout.activity_students_feed_back)
public class StudentsFeedBackActivity extends AppCompatActivity {

    @ViewInject(R.id.ib_instrument_info_back1)
    ImageButton ib_instrument_info_back1;
    @ViewInject(R.id.ib_instrument_info_back2)
    ImageButton ib_instrument_info_back2;
    @ViewInject(R.id.ib_instrument_info_next)
    ImageButton ib_instrument_info_next;
    @ViewInject(R.id.lv_th)
    ListView lv_th;

    StudentsFeedBackEntity responseStudentsFeedBack;
    StudentsFeedbackAdapter studentsFeedbackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_feed_back);
        x.view().inject(this);
        StudentsFeedbackRequestEntity studentsFeedbackRequest = new StudentsFeedbackRequestEntity();
        studentsFeedbackRequest.setClass_id(1);
        studentsFeedbackRequest.setTime_id(1);
        RequestParams params = new RequestParams(STUDENT_FEEDBACK_URL);
        params.setAsJsonContent(true);
        params.setBodyContent(new Gson().toJson(studentsFeedbackRequest));
//        params.setBodyContent("{\"Class_id\":1,\"Time_id\":1\"}");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("23333", result);
                responseStudentsFeedBack = new Gson().fromJson(result, new TypeToken<StudentsFeedBackEntity>() {
                }.getType());
                Log.e("hhhh",responseStudentsFeedBack.toString());
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
