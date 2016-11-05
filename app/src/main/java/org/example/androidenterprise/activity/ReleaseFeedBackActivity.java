package org.example.androidenterprise.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.ReleaseFeedBackPopupWindowAdapter;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

//Created by caishuang:发布反馈
@ContentView(R.layout.activity_release_feed_back)
public class ReleaseFeedBackActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.tv_select_course_time)
    TextView tv_select_course_time;
    @ViewInject(R.id.iv_down_qwe)
    ImageView iv_down_qwe;
    @ViewInject(R.id.et_please_input_thought)
    EditText et_please_input_thought;
    @ViewInject(R.id.iv_video)
    ImageView iv_video;
    @ViewInject(R.id.ib_delete)
    ImageButton ib_delete;
    @ViewInject(R.id.iv_add_square)
    ImageView iv_add_square;
    @ViewInject(R.id.topbar_release_feed_back)
    TopbarView topbar;

    private Context mContext = null;
    private String[] course_time = {"课时1", "课时2", "课时3"};
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        mContext = this;
        tv_select_course_time.setText("课时");
        iv_down_qwe.setImageResource(R.mipmap.ic_complain_suggest_normal);
        iv_down_qwe.setOnClickListener(this);
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
                // TODO: 发布 
            }
        });
    }

    @Event(value = {R.id.iv_down_qwe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_down_qwe:
                iv_down_qwe.setImageResource(R.mipmap.ic_complain_suggest_selected);
                showPopupWindow(view);
                break;
        }
    }

    private void showPopupWindow(View view) {
        int popupWindowWidth = et_please_input_thought.getMeasuredWidth();
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.release_feed_back_popupwindow_lv, null);
        ListView listview = (ListView) contentView.findViewById(R.id.lv_course);
        ReleaseFeedBackPopupWindowAdapter adapter = new ReleaseFeedBackPopupWindowAdapter(getApplicationContext(), course_time);
        listview.setAdapter(adapter);

        popupWindow = new PopupWindow(contentView, popupWindowWidth, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
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