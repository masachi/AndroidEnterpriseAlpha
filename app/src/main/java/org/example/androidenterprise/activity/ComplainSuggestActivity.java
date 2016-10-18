package org.example.androidenterprise.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.ComplainSuggestPopupwindowAdapter;
import org.example.androidenterprise.fragment.MineFragment;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

@ContentView(R.layout.activity_complain_suggest)
public class ComplainSuggestActivity extends AppCompatActivity {

    @ViewInject(R.id.complain_suggest_return_ib)
    ImageButton complain_suggest_return_ib;

    @ViewInject(R.id.suggest_context_et)
    EditText suggest_context_et;
    @ViewInject(R.id.commit_btn)
    Button commit_btn;
    @ViewInject(R.id.choose_title_tv)
    TextView choose_title_tv;
    @ViewInject(R.id.choose_ib)
    ImageView choose_ib;

    private Context mContext = null;
    private String[] suggest_kinds = {"投诉", "操作建议", "其他"};

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
                choose_ib.setImageResource(R.mipmap.ic_complain_suggest_selected);
                showPopupWindow(view);

            }
        });
        // TODO commit suggest
//        complain_suggest_return_ib.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ComplainSuggestActivity.this, MineFragment.class);
//                startActivity(intent);
//            }
//        });

    }

    private void showPopupWindow(View view) {
        int popupWindowWidth = suggest_context_et.getMeasuredWidth();
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(mContext).inflate(
                R.layout.activity_suggest_complain_popupwindow_listview, null);
        ListView listView = (ListView) contentView.findViewById(R.id.suggest_listview);
//        suggest_data = getData();
        ComplainSuggestPopupwindowAdapter adapter = new ComplainSuggestPopupwindowAdapter(getApplicationContext(), suggest_kinds);
        listView.setAdapter(adapter);

        final PopupWindow popupWindow = new PopupWindow(contentView, popupWindowWidth, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.showAsDropDown(contentView, 30, -20);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imageView = (ImageView) view.findViewById(R.id.item_iv);
                imageView.setVisibility(view.VISIBLE);
                TextView textView = (TextView) view.findViewById(R.id.item_tv);
                choose_title_tv.setText(textView.getText());
                choose_ib.setImageResource(R.mipmap.ic_complain_suggest_normal);
                popupWindow.dismiss();
            }
        });

    }
}
