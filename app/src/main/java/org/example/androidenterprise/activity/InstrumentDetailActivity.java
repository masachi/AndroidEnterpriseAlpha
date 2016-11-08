package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.BuyPropertyAdapter;
import org.example.androidenterprise.model.InstrumentDetailEntity;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.activity.LoginActivity.isLogin;
import static org.example.androidenterprise.utils.Constant.INSTRUMENT_DETAIL_URL;
import static org.example.androidenterprise.utils.Constant.isClick;

@ContentView(R.layout.activity_instrument_detail)
/**
 * Created by caishuang:乐器详情
 */
public class InstrumentDetailActivity extends BaseActivity {

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
    //乐器参数
    @ViewInject(R.id.tv_buy)
    TextView buyTv;
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
    @ViewInject(R.id.topbar_instrument_detail)
    TopbarView topbar;

    private InstrumentDetailEntity response;
    private PopupWindow buyNowPopup;
//    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        priceWithLineTv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final int pos = Integer.parseInt(bundle.getString("instrument_selected"));

        RequestParams params = new RequestParams(INSTRUMENT_DETAIL_URL);
        params.setAsJsonContent(true);
        params.setBodyContent("{\"Ins_id\":\"1\"}");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("23333", result);
                response = new Gson().fromJson(result, new TypeToken<InstrumentDetailEntity>() {
                }.getType());
                getInstrumentDetailData();
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
//        final BuyPropertyAdapter propertyAdapter = new BuyPropertyAdapter(this);
//
//        View popupView = getLayoutInflater().inflate(R.layout.instrument_detail, null);
//        buyNowPopup = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
//        buyNowPopup.setTouchable(true);
//        buyNowPopup.setOutsideTouchable(true);
//        buyNowPopup.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));//点击状态栏外部，状态栏能自己弹回去
//        buyNowPopup.setAnimationStyle(R.style.anim_menu_buy);
//
//        buyNowPopup.getContentView().setFocusableInTouchMode(true);
//        buyNowPopup.getContentView().setFocusable(true);
//        TextView buyNowTv = (TextView) popupView.findViewById(R.id.tv_right_now_buy);
//        GridView propertyGv = (GridView) popupView.findViewById(R.id.gv_property);
//        propertyGv.setAdapter(propertyAdapter);
//
//        propertyGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                propertyAdapter.changeState(position);
//                isClick = true;
//            }
//        });
//
//        buyNowTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (!isClick){
//                    Toast.makeText(getBaseContext(),"请选择属性",Toast.LENGTH_LONG).show();
//                }else {
//                    buyNowPopup.dismiss();
//                    if (!isLogin) {
//                        Toast.makeText(getBaseContext(), "请登录", Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(getBaseContext(), LoginActivity.class));
//                    } else {
//                        Intent intent = new Intent();
//                        intent.setClass(getBaseContext(), ConfirmOrderActivity.class);
//                        intent.putExtra("price", String.valueOf(response.getInstrument_now_price() + response.getFreight()));
//                        startActivity(intent);
//                    }
//                }
//            }
//        });


    }

    public void getInstrumentDetailData() {
        titleTv.setText(response.getInstrument_name());
        priceTv.setText(String.valueOf(response.getInstrument_now_price()));
        priceWithLineTv.setText(String.valueOf(response.getInstrument_pre_price()));
        levelTv.setText(String.valueOf(response.getFreight()));
        placeTv.setText(response.getInstrument_location());
//        产品参数和图片
//        Glide.with(this).load(response.getPic_url()).into(firstPictureIv);
//        Glide.with(context).load(response.getPic_url()).into(secondPictureIv);
//        Glide.with(context).load(response.getPic_url()).into(thirdPictureIv);
        contentTv.setText(response.getDescription());
        bottomTotalTv.setText(String.valueOf(response.getFreight()));
        buyPriceTv.setText(String.valueOf(response.getInstrument_now_price() + response.getFreight()));
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("乐器详情");
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

    @Event(value = {R.id.tv_buy})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_buy:
//                buyNowPopup.showAtLocation(findViewById(R.id.layout_instrument_detail), Gravity.BOTTOM, 0, 0);
                if (!isLogin) {
                    Toast.makeText(getBaseContext(), "请登录", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getBaseContext(), LoginActivity.class));
                } else {
                    Intent intent = new Intent();
                    intent.setClass(getBaseContext(), ConfirmOrderActivity.class);
                    intent.putExtra("price", String.valueOf(response.getInstrument_now_price() + response.getFreight()));
                    startActivity(intent);
                }
                break;
        }
    }
}