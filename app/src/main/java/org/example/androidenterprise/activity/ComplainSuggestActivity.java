package org.example.androidenterprise.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_complain_suggest)
public class ComplainSuggestActivity extends AppCompatActivity {

    @ViewInject(R.id.complain_suggest_return_ib)
    ImageButton complain_suggest_return_ib;
    @ViewInject(R.id.choose_ib)
    ImageButton choose_ib;
    @ViewInject(R.id.suggest_context_et)
    EditText suggest_context_et;
    @ViewInject(R.id.commit_btn)
    Button commit_btn;
    @ViewInject(R.id.choose_title_tv)
    TextView choose_title_tv;
//    private String[] suggest = {"投诉", "操作建议", "其他"};
//    private List<Map<String, Object>> suggest_data;
    private Context mContext = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_complain_suggest);
        x.view().inject(this);
        mContext = this;
//        suggest_data = getSuggestData();
//        ComplainSuggestChooseAdapter chooseAdapter = new ComplainSuggestChooseAdapter(this, suggest_data);
//        suggest_kinds_lv.setAdapter(chooseAdapter);
        choose_title_tv.setText("请选择意见类型");
        choose_ib.setImageResource(R.mipmap.ic_complain_suggest_normal);
        choose_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                choose_ib.setImageResource(R.mipmap.ic_complain_suggest_selected);
                showPopupWindow(view);
            }
        });

    }
    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(mContext).inflate(
                R.layout.activity_suggest_complain_popupwindow_layout, null);

//   TODO click
//        final PopupWindow popupWindow = new PopupWindow(contentView,
//                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        PopupWindow popupWindow = new PopupWindow(contentView, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setTouchable(true);
        popupWindow.showAsDropDown(contentView,10,350);
//        popupWindow.setBackgroundDrawable(R.color.color_ffffff);

//        popupWindow.setTouchInterceptor(new OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                Log.i("mengdd", "onTouch : ");
//
//                return false;
//                // 这里如果返回true的话，touch事件将被拦截
//                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
//            }
//        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(
//                R.drawable.selectmenu_bg_downward));

        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);

    }
}
