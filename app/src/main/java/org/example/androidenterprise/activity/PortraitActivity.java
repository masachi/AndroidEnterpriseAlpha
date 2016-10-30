package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.example.androidenterprise.R;
import org.example.androidenterprise.utils.com.lling.photopicker.PhotoPickerActivity;
import org.example.androidenterprise.utils.com.lling.photopicker.utils.ImageLoader;
import org.example.androidenterprise.utils.com.lling.photopicker.utils.OtherUtils;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_portrait)

public class PortraitActivity extends BaseActivity {

    @ViewInject(R.id.iv_return)
    ImageView returnIb;
    @ViewInject(R.id.tv_accept)
    TextView acceptBtn;
    @ViewInject(R.id.btn_change_portrait)
    Button changeBtn;
    @ViewInject(R.id.img_head_portrait)
    ImageView headportraitIv;

    private List<String> mResults;
    private int mColumnWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int screenWidth = OtherUtils.getWidthInPx(getApplicationContext());
        mColumnWidth = (screenWidth - OtherUtils.dip2px(getApplicationContext(), 4)) / 3;
    }

    @Event(value = {R.id.iv_return, R.id.tv_accept, R.id.btn_change_portrait})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_return:
                finish();
                break;
            case R.id.tv_accept:
                finish();
                break;
            case R.id.btn_change_portrait:
                Intent intent = new Intent(this, PhotoPickerActivity.class);
                intent.putExtra(PhotoPickerActivity.EXTRA_SHOW_CAMERA, true);
                intent.putExtra(PhotoPickerActivity.EXTRA_SELECT_MODE, PhotoPickerActivity.MODE_SINGLE);
                intent.putExtra(PhotoPickerActivity.EXTRA_MAX_MUN, PhotoPickerActivity.DEFAULT_NUM);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> result = data.getStringArrayListExtra(PhotoPickerActivity.KEY_RESULT);
                showResult(result);
            }
        }
    }

    private void showResult(ArrayList<String> paths) {
        if (mResults == null) {
            mResults = new ArrayList<>();
        }
        mResults.clear();
        mResults.addAll(paths);
        String headPortrait = mResults.get(0);
        ImageLoader.getInstance().display(paths.get(0), headportraitIv, mColumnWidth, mColumnWidth);

    }
}
