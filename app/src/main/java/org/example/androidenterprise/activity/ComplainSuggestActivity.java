package org.example.androidenterprise.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        mContext = this;
        choose_title_tv.setText("请选择意见类型");
        choose_ib.setImageResource(R.mipmap.ic_complain_suggest_normal);
        choose_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(view);

            }
        });

    }
    private void showPopupWindow(View view) {
        int popupWindowWidth = suggest_context_et.getMeasuredWidth();
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(mContext).inflate(
                R.layout.activity_suggest_complain_popupwindow_layout, null);

//   TODO click
        PopupWindow popupWindow = new PopupWindow(contentView,popupWindowWidth, ActionBar.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setTouchable(true);
        popupWindow.showAsDropDown(contentView, 30, 350);

    }
}
