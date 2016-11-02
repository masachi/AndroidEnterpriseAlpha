package org.example.androidenterprise.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.CourseInfoEntity;
import org.example.androidenterprise.view.CircleImageView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.*;

@ContentView(R.layout.activity_course_info)

public class CourseInfoActivity extends BaseActivity implements View.OnClickListener {
    LinearLayout ll, feedbackLl;
    LayoutInflater mInflater = null;

    private ImageButton returnIb;
    private TextView titleTv;
    private TextView levelTv;
    private TextView idTv;
    private TextView durationTv;
    private TextView posTv;
    private TextView otherTv;
    private TextView signTv;
    private TextView priceTv;
    private ImageButton feedbackIb;
    private CircleImageView teacherCiv;
    private TextView teacherNameTv;
    private TextView teacherPhoneTv;
    private TextView studentNumberTv;
    private TextView courseInfoScheduleTitleTv;
    private TextView typeTv;
    private TextView scheduleInfoTv;
    private TextView feedbackNumTv;
    private Button chooseBtn;

    private Context context;


//    public final static int STUDENT_NUMBER = 10;
//    public final static int MAX_STUDENT_NUMBER = 8;
//    public final static int MAX_STUDENT_NUMBER_BACK = 7;

    private int id;

    private CourseInfoEntity response;
//    private SubjectDetails response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInflater = LayoutInflater.from(this);

        returnIb = (ImageButton) findViewById(R.id.ib_return);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        id = Integer.parseInt(bundle.getString("course_selected"));
        returnIb.setOnClickListener(this);

        InitWidget();

        ll.setOnClickListener(this);
        feedbackLl.setOnClickListener(this);
        feedbackIb.setOnClickListener(this);
        chooseBtn.setOnClickListener(this);
        feedbackIb.setOnClickListener(this);

        initLinearLayoutImage();
        initLinearLayoutFeedback();

        RequestParams params = new RequestParams(COURSE_INFO_URL);
        params.setAsJsonContent(true);
//        params.setBodyContent("{\"Class_id\":\""+id+"\"}");
        params.setBodyContent("{\"Class_id\":\"1\"}");
        x.http().post(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Log.e("233", result);
                    response = new Gson().fromJson(result, new TypeToken<CourseInfoEntity>() {
                    }.getType());
//                    Log.e("hhhhh",response.toString());
                    getCourseInfoData();
                }


                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
//                    Log.e("233", "crrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
                    ex.printStackTrace();

                    Toast.makeText(CourseInfoActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {

                }
            });
    }

    public void getCourseInfoData() {
        titleTv.setText(response.getClass_name());
        levelTv.setText("等级 : " + response.getClass_level());
        priceTv.setText(String.valueOf(response.getClass_price()));
        idTv.setText("编号 : " + String.valueOf(response.getClass_number()));
        durationTv.setText("课时 : " + String.valueOf(response.getClass_time()));
        posTv.setText("地点 : " + response.getClass_location());
        otherTv.setText("备注 : " + response.getClass_remark());
//        Glide.with(context).load(response.getTeacher().get(0).getTeacher_pic_URL()).into(teacherCiv);
//        Glide.with(context).load(response.getTeacher().get(0)).bitmapTransform(new CropCircleTransformation(context)).into(teacherCiv);
        teacherNameTv.setText(response.getTeacher().get(0).getTeacher_name());
        teacherPhoneTv.setText("手机号 : " + response.getTeacher().get(0).getTeacher_telephone());
        studentNumberTv.setText("共" + String.valueOf(response.getTeacher().get(0).getStudent_number()) + "名学员");
        feedbackNumTv.setText(String.valueOf(response.getFeedback_number()) + "条学员反馈");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_return:
                finish();
                break;
            case R.id.ll_stu_info:
                startActivity(new Intent(this,StudentsHeadListActivity.class));
                break;
            case R.id.ll_stu_feedback:
                startActivity(new Intent(this, StudentsFeedBackActivity.class));
                break;
            case R.id.ib_feedback:
                startActivity(new Intent(this, ReleaseFeedBackActivity.class));
                break;
            case R.id.btn_choose:
                startActivity(new Intent(this,CourseOrderActivity.class));
                break;
        }
    }

    private void InitWidget() {
        titleTv = (TextView) findViewById(R.id.tv_course_title);
        levelTv = (TextView) findViewById(R.id.tv_course_level);
        idTv = (TextView) findViewById(R.id.tv_course_id);
        durationTv = (TextView) findViewById(R.id.tv_course_duration);
        posTv = (TextView) findViewById(R.id.tv_course_pos);
        otherTv = (TextView) findViewById(R.id.tv_course_other);
        signTv = (TextView) findViewById(R.id.tv_price_sign);
        priceTv = (TextView) findViewById(R.id.tv_course_price);
        feedbackIb = (ImageButton) findViewById(R.id.ib_feedback);
        teacherCiv = (CircleImageView) findViewById(R.id.civ_teacher);
        teacherNameTv = (TextView) findViewById(R.id.tv_teacher_name);
        teacherPhoneTv = (TextView) findViewById(R.id.tv_teacher_phone);
        studentNumberTv = (TextView) findViewById(R.id.tv_stu_number);
        courseInfoScheduleTitleTv = (TextView) findViewById(R.id.tv_course_info_schedule_title);
        typeTv = (TextView) findViewById(R.id.tv_type);
        scheduleInfoTv = (TextView) findViewById(R.id.tv_schedule_info);
        feedbackNumTv = (TextView) findViewById(R.id.tv_feedback_num);

        chooseBtn = (Button) findViewById(R.id.btn_choose);

        ll = (LinearLayout) findViewById(R.id.ll_stu_info);
        feedbackLl = (LinearLayout) findViewById(R.id.ll_stu_feedback);
    }

    private void initLinearLayoutFeedback() {
        addHeadImgToLinearLayout(STUDENT_NUMBER, MAX_STUDENT_NUMBER_BACK,
                R.layout.head_stu_feedback_img_item, feedbackLl);
    }

    public void initLinearLayoutImage() {
        addHeadImgToLinearLayout(STUDENT_NUMBER, MAX_STUDENT_NUMBER,
                R.layout.head_stu_img_item, ll);
    }

    public void addHeadImgToLinearLayout(int studentNumber, int MaxNumber, int itemlayout,
                                         LinearLayout linearLayout) {
        if (studentNumber <= MaxNumber) {
            for (int i = 0; i < studentNumber; i++) {
                View v = mInflater.inflate(itemlayout, null);
                linearLayout.addView(v);
            }
        } else {
            for (int i = 0; i < MaxNumber; i++) {
                View v = mInflater.inflate(itemlayout, null);
                if (i == MaxNumber - 1) {
                    CircleImageView civ = (CircleImageView) v.findViewById(R.id.civ_stu);
                    civ.setImageResource(R.mipmap.ic_img_more);
                }
                linearLayout.addView(v);
            }
        }
    }

}
