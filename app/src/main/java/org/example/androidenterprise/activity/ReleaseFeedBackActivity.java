package org.example.androidenterprise.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.ReleaseFeedBackPopupWindowAdapter;
import org.example.androidenterprise.model.ReleaseFeedBackEntity;
import org.example.androidenterprise.model.ReleaseRequstEntity;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.example.androidenterprise.activity.LoginActivity.isLogin;
import static org.example.androidenterprise.utils.Constant.RELEASE_FEEDBACK_URL;

//Created by caishuang:发布反馈
@ContentView(R.layout.activity_release_feed_back)
public class ReleaseFeedBackActivity extends BaseActivity {

    @ViewInject(R.id.tv_select_course_time)
    TextView tv_select_course_time;
    @ViewInject(R.id.iv_down_qwe)
    ImageView iv_down_qwe;
    @ViewInject(R.id.et_please_input_thought)
    EditText inputThoughtEt;
    @ViewInject(R.id.iv_add_square)
    ImageView iv_add_square;
    @ViewInject(R.id.topbar_release_feed_back)
    TopbarView topbar;
    @ViewInject(R.id.rl_select_course_time)
    RelativeLayout selectCourseTimeRl;

    private ReleaseFeedBackEntity response;
    private Context mContext = null;
    private String[] course_time = {"课时1", "课时2", "课时3"};
    PopupWindow popupWindow;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss     ");
    Date curDate = new Date(System.currentTimeMillis());//获取当前时间
    String date = formatter.format(curDate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        mContext = this;
        tv_select_course_time.setText("课时");
        iv_down_qwe.setImageResource(R.mipmap.ic_complain_suggest_normal);
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("发布反馈");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Drawable ic_release = res.getDrawable(R.mipmap.ic_release);
        topbar.setRight1Ib(ic_release);
        topbar.getRight1Ib().setVisibility(View.VISIBLE);
        topbar.setRight1IbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    Toast.makeText(ReleaseFeedBackActivity.this, "请登录", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ReleaseFeedBackActivity.this, LoginActivity.class));
                } else {
                    if (inputThoughtEt.length() == 0) {
                        Toast.makeText(getApplicationContext(), "感想内容不能为空", Toast.LENGTH_SHORT).show();
                    } else {
                        ReleaseRequstEntity releaseRequst = new ReleaseRequstEntity();
                        releaseRequst.setCode(2061);
                        releaseRequst.setUser_id(1);
                        releaseRequst.setClass_id(1);
                        releaseRequst.setFeedback(inputThoughtEt.getText().toString());
                        releaseRequst.setTime_id(1);
                        releaseRequst.setDate(date);
                        RequestParams params = new RequestParams(RELEASE_FEEDBACK_URL);
                        params.setAsJsonContent(true);
                        params.setBodyContent(new Gson().toJson(releaseRequst));
                        x.http().post(params, new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
                                Log.e("发布反馈", result);
                                response = new Gson().fromJson(result, new TypeToken<ReleaseFeedBackEntity>() {
                                }.getType());
                                Toast.makeText(ReleaseFeedBackActivity.this, "发布成功", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(ReleaseFeedBackActivity.this, StudentsFeedBackActivity.class));
                            }

                            @Override
                            public void onError(Throwable ex, boolean isOnCallback) {

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
            }
        });

    }

    @Event(value = {R.id.rl_select_course_time})
   private void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_select_course_time:
                iv_down_qwe.setImageResource(R.mipmap.ic_complain_suggest_selected);
                showPopupWindow(view);
                break;
        }
    }

    private void showPopupWindow(View view) {
        int popupWindowWidth = inputThoughtEt.getMeasuredWidth();
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.release_feed_back_popupwindow_lv, null);
        ListView listview = (ListView) contentView.findViewById(R.id.lv_course);
        ReleaseFeedBackPopupWindowAdapter adapter = new ReleaseFeedBackPopupWindowAdapter(getApplicationContext(), course_time);
        listview.setAdapter(adapter);

        popupWindow = new PopupWindow(contentView, popupWindowWidth, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));//点击状态栏外部，状态栏能自己弹回去
        popupWindow.showAsDropDown(contentView, 30, -10);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_select_item);
                imageView.setVisibility(view.VISIBLE);
                TextView textView = (TextView) view.findViewById(R.id.tv_course_time_item);
                tv_select_course_time.setText(textView.getText());
                iv_down_qwe.setImageResource(R.mipmap.ic_complain_suggest_normal);
                popupWindow.dismiss();
            }
        });
    }
}