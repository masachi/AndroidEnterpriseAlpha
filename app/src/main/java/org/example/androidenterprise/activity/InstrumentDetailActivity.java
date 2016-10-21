package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_instrument_detail)

public class InstrumentDetailActivity extends BaseActivity implements View.OnFocusChangeListener{

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int pos = Integer.parseInt(bundle.getString("instrument_selected"));
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
        if(!hasFocus){
            instantRl.setVisibility(View.INVISIBLE);
        }
        else{
            instantRl.setVisibility(View.INVISIBLE);
            Log.e("23333","233333");
        }
    }
}
