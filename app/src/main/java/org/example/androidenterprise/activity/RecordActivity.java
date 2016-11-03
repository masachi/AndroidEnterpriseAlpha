package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.RecordAdapter;
import org.example.androidenterprise.model.RecordEntity;
import org.example.androidenterprise.model.RecordRequestEntity;
import org.example.androidenterprise.model.StudentsFeedBackEntity;
import org.example.androidenterprise.model.StudentsFeedbackRequestEntity;
import org.example.androidenterprise.view.RecordExpandableListView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.RECORD_URL;
import static org.example.androidenterprise.utils.Constant.STUDENT_FEEDBACK_URL;

@ContentView(R.layout.activity_record)

public class RecordActivity extends BaseActivity {

    @ViewInject(R.id.ib_return)
    ImageButton returnIb;
    @ViewInject(R.id.ib_search)
    ImageButton searchIb;
    @ViewInject(R.id.explv_record)
    RecordExpandableListView recordExpLv;

    RecordEntity response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecordRequestEntity request = new RecordRequestEntity();
        request.setCode("2009");
        request.setRole("student");
        request.setUser_id(1);
        RequestParams params = new RequestParams(RECORD_URL);
        params.setAsJsonContent(true);
        params.setBodyContent(new Gson().toJson(request));
        x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("23333", result);
                response = new Gson().fromJson(result, new TypeToken<RecordEntity>() {
                }.getType());
//                RecordAdapter recAdapter = new RecordAdapter(this);
//                recordExpLv.setAdapter(recAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("233", "crrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
                ex.printStackTrace();

                Toast.makeText(RecordActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    @Event(value = {R.id.ib_return, R.id.ib_search})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_return:
                finish();
                break;
            case R.id.ib_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
    }
}
