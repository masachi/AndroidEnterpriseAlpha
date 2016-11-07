package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.SelectAddressAdapter;
import org.example.androidenterprise.model.SelectAddressEntity;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import static org.example.androidenterprise.utils.Constant.*;

/**
 * Created by yangxinghua ：选择地址
 */
@ContentView(R.layout.activity_select_add)

public class SelectAddActivity extends AppCompatActivity {

    //    final SelectAddressAdapter selectAddressAdapter=new SelectAddressAdapter(getBaseContext(),slist);
    private List<SelectAddressEntity.ContentEntity> slist;
    private SelectAddressEntity response;
    @ViewInject(R.id.lv_address)
    ListView addressLv;
    @ViewInject(R.id.btn_increase)
    Button increaseBtn;
    @ViewInject(R.id.topbar_select_add)
    TopbarView topbar;

    String name;
    String address;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        RequestParams params = new RequestParams(SELECT_ADDRESS_URL);
        params.setAsJsonContent(true);
        params.setBodyContent("{\"User_id\":1,\"code\":\"1008\"}");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("选择地址", result);
                response = new Gson().fromJson(result, new TypeToken<SelectAddressEntity>() {
                }.getType());
                final SelectAddressAdapter selectAddressAdapter = new SelectAddressAdapter(getBaseContext(), response.getContent());
                addressLv.setAdapter(selectAddressAdapter);
                addressLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        selectAddressAdapter.setCheckedPosition(position);
                        name = response.getContent().get(position).getRecipient();
                        phone = response.getContent().get(position).getTelephone();
                        address = response.getContent().get(position).getAddress();
                        Log.e("jjjj",name);
                    }
                });
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

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("选择地址");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("phone",phone);
                intent.putExtra("address",address);
//                setResult(RESULT_CODE, intent);
                finish();
            }
        });
    }

    @Event(value = {R.id.btn_increase})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_increase:
                // TODO: 跳到编辑地址页面（增加地址形式）
                Intent intent = new Intent().setClass(SelectAddActivity.this, EditAddActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("add_addr", "0");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}