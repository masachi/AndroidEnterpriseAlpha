package org.example.androidenterprise.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.ReleaseFeedBackPopupWindowAdapter;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

//Created by caishuang:发布反馈
@ContentView(R.layout.activity_release_feed_back)
public class ReleaseFeedBackActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.ib_back1)
    ImageButton ib_back1;
    @ViewInject(R.id.tv_release)
    TextView tv_release;
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


    private Context mContext = null;
    private String[] course_time = {"课时1", "课时2", "课时3"};
    PopupWindow popupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_release_feed_back);
        x.view().inject(this);
        mContext = this;
        tv_select_course_time.setText("课时");
        iv_down_qwe.setImageResource(R.mipmap.ic_complain_suggest_normal);
        ib_back1.setOnClickListener(this);
        tv_release.setOnClickListener(this);
        iv_down_qwe.setOnClickListener(this);
    }

    @Event(value = {R.id.ib_back1, R.id.tv_release, R.id.iv_down_qwe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back1:
                finish();
                break;
            case R.id.tv_release:
//                TODO:commit release;
                break;
            case R.id.iv_down_qwe:
                iv_down_qwe.setImageResource(R.mipmap.ic_complain_suggest_selected);
                showPopupWindow(view);
                break;
            default:
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