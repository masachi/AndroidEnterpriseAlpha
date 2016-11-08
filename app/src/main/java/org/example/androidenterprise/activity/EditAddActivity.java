package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.EditAddressEntity;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.EDIT_ADDRESS_URL;

/**
 * Created by yangxinghua ：编辑地址
 */
@ContentView(R.layout.activity_edit_add)

public class EditAddActivity extends AppCompatActivity {

    @ViewInject(R.id.et_consignee)
    EditText consigneeEt;
    @ViewInject(R.id.et_phonenum)
    EditText phonenumEt;
    @ViewInject(R.id.et_detailed)
    EditText detailEt;
    @ViewInject(R.id.rl_delete)
    RelativeLayout deleteRl;
    @ViewInject(R.id.btn_conserve)
    Button conserveBtn;
    @ViewInject(R.id.topbar_edit_add)
    TopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        Intent intent = getIntent();
        consigneeEt.setText(intent.getStringExtra("name"));
        phonenumEt.setText(intent.getStringExtra("phone"));
        detailEt.setText(intent.getStringExtra("address"));
//        if (intent.getExtras().get("add_addr").equals("0")) {
//            consigneeEt.setText("");
//            phonenumEt.setText("");
//            detailEt.setText("");
//        } else {// TODO: setText(从List获取)
//            consigneeEt.setText("某某某");
//            phonenumEt.setText("13366668888");
//            detailEt.setText("山东省威海市山东省威海市山东省威海市山东省威海市山东省威海市");
//        }
    }
    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("编辑地址");
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

    @Event(value = {R.id.rl_delete, R.id.btn_conserve})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_delete:
                // TODO: 实现删除功能,上传到数据库
                break;
            case R.id.btn_conserve:

                EditAddressEntity editAddressEntity = new EditAddressEntity();
                editAddressEntity.setCode("2008");
                editAddressEntity.setUser_id(1);
                editAddressEntity.setReceiver(consigneeEt.getText().toString());
                editAddressEntity.setTel(phonenumEt.getText().toString());
                editAddressEntity.setAddress(detailEt.getText().toString());
                RequestParams params = new RequestParams(EDIT_ADDRESS_URL);
                params.setAsJsonContent(true);
                params.setBodyContent(new Gson().toJson(editAddressEntity).toString());
                x.http().post(params, new Callback.CommonCallback<String>() {

                    @Override
                    public void onSuccess(String result) {
                        Log.i("info",result);
                        startActivity(new Intent(EditAddActivity.this, SelectAddActivity.class));
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

                break;
        }
    }
}
