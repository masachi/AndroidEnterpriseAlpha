package org.example.androidenterprise.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_instrument_detail)
/**
 * Created by caishuang:乐器详情
 */
public class InstrumentDetailActivity extends BaseActivity implements View.OnFocusChangeListener {

    @ViewInject(R.id.ib_back)
    ImageButton returnIb;
    @ViewInject(R.id.tv_title)
    TextView titleTv;
    @ViewInject(R.id.tv_price)
    TextView priceTv;
    @ViewInject(R.id.tv_level)
    TextView levelTv;
    @ViewInject(R.id.tv_place)
    TextView placeTv;
    @ViewInject(R.id.lv_instrument_detail)
    ListView instrumentDetailLv;
    @ViewInject(R.id.gv_property)
    GridView propertyGv;
    @ViewInject(R.id.tv_right_now_buy)
    TextView instantBuyBtn;
    @ViewInject(R.id.tv_buy)
    TextView buyBtn;
    @ViewInject(R.id.rl_instant_buy)
    RelativeLayout instantRl;
    @ViewInject(R.id.tv_price_with_line)
    TextView priceWithLineTv;
    @ViewInject(R.id.tv_buy_price)
    TextView buyPriceTv;
    @ViewInject(R.id.iv_picture_first)
    ImageView firstPictureIv;
    @ViewInject(R.id.tv_transfer_price)
    TextView transferPriceTv;
    @ViewInject(R.id.tv_content)
    TextView contentTv;
    @ViewInject(R.id.iv_picture_second)
    ImageView secondPictureIv;
    @ViewInject(R.id.iv_picture_third)
    ImageView thirdPictureIv;
    @ViewInject(R.id.tv_bottom_total)
    TextView bottomTotalTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        priceWithLineTv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int pos = Integer.parseInt(bundle.getString("instrument_selected"));

        RequestParams params = new RequestParams("http://138.68.4.19:8080/music/api_insdetail");
        params.setAsJsonContent(true);
        params.setBodyContent("{\"Ins_id\":\"1\"}");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("23333", result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("23333", "FK");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

        instantRl.setOnFocusChangeListener(this);
    }

    @Event(value = {R.id.ib_back, R.id.tv_buy, R.id.tv_right_now_buy})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                break;
            case R.id.tv_buy:
                instantRl.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_right_now_buy:
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            instantRl.setVisibility(View.INVISIBLE);
        } else {
            instantRl.setVisibility(View.INVISIBLE);
            Log.e("23333", "233333");
        }
    }
}
