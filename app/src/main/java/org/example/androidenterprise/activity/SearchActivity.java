package org.example.androidenterprise.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.CourseAdapter;
import org.example.androidenterprise.adapter.ItemAdapter;
import org.example.androidenterprise.adapter.OrderAdapter;
import org.example.androidenterprise.adapter.RecordAdapter;
import org.example.androidenterprise.model.*;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.example.androidenterprise.view.CustomMeasureListView;
import org.example.androidenterprise.view.CustomScrollView;
import org.example.androidenterprise.view.SearchExpandableListView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.*;

@ContentView(R.layout.activity_search)
public class SearchActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ExpandableListView.OnGroupClickListener {
    @ViewInject(R.id.ib_return)
    ImageButton returnIb;
    @ViewInject(R.id.lv_course_info)
    CustomMeasureListView courseInfoLv;
    @ViewInject(R.id.gv_instrument_info)
    CustomMeasureGridView instrumentInfoGv;
    @ViewInject(R.id.lv_order)
    CustomMeasureListView orderLv;
    @ViewInject(R.id.explv_record)
    SearchExpandableListView recordExplv;
    @ViewInject(R.id.custom_scroll_view)
    CustomScrollView customScrollView;

    private EditText mainWordEt;
    private TextView searchTv;
    private RadioGroup searchRg;
    private ListView courseLv;
    private ListView recordLv;
    private GridView instruGv;
    private CourseEntity responseCourse;
    private ReservationOrderEntity responseOrder;
    private RecordEntity responseRecord;
    private InstrumentEntity responseInstrument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        x.view().inject(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        getCourseData();
        getInstrumentData();
        getOrderData();
        getRecordData();

        returnIb = (ImageButton) findViewById(R.id.ib_return);
        mainWordEt = (EditText) findViewById(R.id.et_search);
        searchTv = (TextView) findViewById(R.id.ib_search);
        searchRg = (RadioGroup) findViewById(R.id.search_radioGp);
        courseLv = (ListView) findViewById(R.id.lv_course_info);
    }

    private void getCourseData() {
        ListRequestEntity courseRequest = new ListRequestEntity();
        courseRequest.setCode(2051);
        courseRequest.setId(9527);
        courseRequest.setRole("student");
        courseRequest.setMaxtime(0);
        RequestParams paramsCourse = new RequestParams(COURSE_LIST_URL);
        paramsCourse.setAsJsonContent(true);
        paramsCourse.setBodyContent(new Gson().toJson(courseRequest));
        x.http().post(paramsCourse, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("课程", result);
                responseCourse = new Gson().fromJson(result, new TypeToken<CourseEntity>() {
                }.getType());
                CourseAdapter courseAdapter = new CourseAdapter(getApplicationContext(), responseCourse.getList());
                courseInfoLv.setAdapter(courseAdapter);
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

    private void getOrderData() {
        RequestParams params = new RequestParams(RESERVATION_ORDER_URL);
        params.setAsJsonContent(true);
        params.setBodyContent("{\"user_id\":USERID,\"code\":\"2010\"}");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("预约订单", result);
                responseOrder = new Gson().fromJson(result, new TypeToken<ReservationOrderEntity>() {
                }.getType());
                final OrderAdapter orderAdapter = new OrderAdapter(getBaseContext(), responseOrder.getList());
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

    private void getRecordData() {
        RecordRequestEntity request = new RecordRequestEntity();
        request.setUser_id(USERID);
        RequestParams params = new RequestParams(RECORD_URL);
        params.setAsJsonContent(true);
        params.setBodyContent(new Gson().toJson(request));
        x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("交易记录", result);
                responseRecord = new Gson().fromJson(result, new TypeToken<RecordEntity>() {
                }.getType());
                RecordAdapter recAdapter = new RecordAdapter(getApplicationContext(), responseRecord.getOrder_list());
                recordExplv.setAdapter(recAdapter);
                for (int i = 0; i < responseRecord.getOrder_list().size(); i++) {
                    recordExplv.expandGroup(i);
                }
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

    private void getInstrumentData() {
//        所有乐器展示的网络请求
        InstrumentInfoEntity infoEntity = new InstrumentInfoEntity();
        infoEntity.setCode("2053");
        infoEntity.setId(USERID);
        infoEntity.setRole("student");
        infoEntity.setMaxtime(0);
        RequestParams paramsInstrument = new RequestParams(INSTRUMENT_URL);
        paramsInstrument.setAsJsonContent(true);
        paramsInstrument.setBodyContent(new Gson().toJson(infoEntity));
        x.http().post(paramsInstrument, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("所有1111乐器展示", result);
                responseInstrument = new Gson().fromJson(result, new TypeToken<InstrumentEntity>() {
                }.getType());
                ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), responseInstrument);
                instrumentInfoGv.setAdapter(itemAdapter);
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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return true;
    }

    @Event(value = {R.id.rdob_course, R.id.rdob_instrument, R.id.rdob_order, R.id.rdob_record, R.id.ib_return})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.rdob_course:
                customScrollView.scrollTo(0, 0);
                break;
            case R.id.rdob_order:
                customScrollView.scrollTo(0, 1296);
                break;
            case R.id.rdob_record:
                customScrollView.scrollTo(0, 1425);
                break;
            case R.id.rdob_instrument:
//                Toast toast=Toast.makeText(getApplicationContext(),"yueqitoast",Toast.LENGTH_SHORT);
//                toast.show();
                customScrollView.scrollTo(0, 2754);
                break;
            case R.id.ib_return:
                finish();
                break;
        }
    }
}