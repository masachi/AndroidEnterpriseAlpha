package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.OrderAdapter;
import org.example.androidenterprise.model.ReservationOrderEntity;
import org.example.androidenterprise.view.CustomMeasureListView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import static org.example.androidenterprise.utils.Constant.RESERVATION_ORDER_URL;

@ContentView(R.layout.activity_order)

public class OrderActivity extends BaseActivity {
    private List<ReservationOrderEntity.ListInfoEntity> slist;
    private ReservationOrderEntity response;

    @ViewInject(R.id.lv_order)
    CustomMeasureListView orderLv;
    @ViewInject(R.id.topbar_order)
    TopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();

//        OrderAdapter ordAdapter = new OrderAdapter(this);
//
//        orderLv.setAdapter(ordAdapter);
        RequestParams params = new RequestParams(RESERVATION_ORDER_URL);
        params.setAsJsonContent(true);
        params.setBodyContent("{\"user_id\":USERID,\"code\":\"2010\"}");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("预约订单", result);
                response = new Gson().fromJson(result, new TypeToken<ReservationOrderEntity>() {
                }.getType());
                final OrderAdapter orderAdapter = new OrderAdapter(getBaseContext(), response.getList());
                orderLv.setAdapter(orderAdapter);
                orderLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        orderAdapter.setCheckedPosition(position);
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
        topbar.setTopbarTv("预约订单");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Drawable ic_search = res.getDrawable(R.mipmap.ic_search);
        topbar.setRight1Ib(ic_search);
        topbar.getRight1Ib().setVisibility(View.VISIBLE);
        topbar.setRight1IbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SearchActivity.class));
            }
        });
    }
}
