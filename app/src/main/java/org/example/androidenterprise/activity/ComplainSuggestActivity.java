package org.example.androidenterprise.activity;

import android.content.Context;
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
import org.example.androidenterprise.adapter.ComplainSuggestPopupwindowAdapter;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by chenguojiao : 投诉建议
 */

@ContentView(R.layout.activity_complain_suggest)
public class ComplainSuggestActivity extends AppCompatActivity {
    @ViewInject(R.id.tv_choose_title)
    TextView tv_choose_title;
    @ViewInject(R.id.iv_choose)
    ImageView chooseIv;
    @ViewInject(R.id.et_suggest_context)
    EditText et_suggest_context;
    @ViewInject(R.id.tv_complain_telephone)
    TextView tv_complain_telephone;
    @ViewInject(R.id.tv_complain_telephone_number)
    TextView tv_complain_telephone_number;
    @ViewInject(R.id.btn_commit)
    Button btn_commit;
    @ViewInject(R.id.topbar_complain_suggest)
    TopbarView topbar;

    private Context mContext = null;
    PopupWindow popupWindow;
    private String[] suggest_kinds = {"投诉", "操作建议", "其他"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        mContext = this;
        tv_choose_title.setText("请选择意见类型");
        chooseIv.setImageResource(R.mipmap.ic_complain_suggest_normal);
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("投诉建议");
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

    private void showPopupWindow(View view) {
        int popupWindowWidth = et_suggest_context.getMeasuredWidth();
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(mContext).inflate(
                R.layout.activity_suggest_complain_popupwindow_listview, null);
        ListView listView = (ListView) contentView.findViewById(R.id.lv_suggest);
//        suggest_data = getData();
        ComplainSuggestPopupwindowAdapter adapter = new ComplainSuggestPopupwindowAdapter(getApplicationContext(), suggest_kinds);
        listView.setAdapter(adapter);

        popupWindow = new PopupWindow(contentView, popupWindowWidth, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.showAsDropDown(contentView, 30, -20);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_item);
                imageView.setVisibility(view.VISIBLE);
                TextView textView = (TextView) view.findViewById(R.id.tv_item);
                tv_choose_title.setText(textView.getText());
                chooseIv.setImageResource(R.mipmap.ic_complain_suggest_normal);
                popupWindow.dismiss();
            }
        });
    }

    @Event(value = {R.id.iv_choose, R.id.btn_commit})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_choose:
                chooseIv.setImageResource(R.mipmap.ic_complain_suggest_selected);
                showPopupWindow(view);
                break;
            case R.id.btn_commit: // TODO commit suggest
                break;
        }
    }
}
