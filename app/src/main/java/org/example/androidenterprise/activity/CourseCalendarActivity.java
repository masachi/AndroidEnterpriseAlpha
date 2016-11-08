package org.example.androidenterprise.activity;

/**
 * Created by byyoung1 on 2016/10/14.： 课程日历界面
 */


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.CourseCalendarAdapter;
import org.example.androidenterprise.model.CourseCalendarEntity;
import org.example.androidenterprise.model.CourseCalendarInfoEntity;
import org.example.androidenterprise.utils.EventDecorator;
import org.example.androidenterprise.utils.MySelectorDecorator;
import org.example.androidenterprise.utils.OneDayDecorator;
import org.example.androidenterprise.view.CustomMeasureListView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

import static org.example.androidenterprise.utils.Constant.COURSE_CALENDAR_URL;
import static org.example.androidenterprise.utils.Constant.FORMATTER;

@ContentView(R.layout.activity_course_calendar)

public class CourseCalendarActivity extends AppCompatActivity implements OnDateSelectedListener {

    private CourseCalendarEntity reponse;
    private Boolean isRequst = false;
    String[] deta = new String[3];
    String strs;

    @ViewInject(R.id.mv_calendar)
    MaterialCalendarView calendarMv;

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
    @ViewInject(R.id.topbar_complain_suggest)
    TopbarView topbar;
    @ViewInject(R.id.cmlv_course_msg)
    CustomMeasureListView coursemsgCmLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        //网络请求
        getCourseCalendarDate();

        calendarMv.setOnDateChangedListener(this);
        calendarMv.setShowOtherDates(MaterialCalendarView.SHOW_ALL);

        Calendar instance = Calendar.getInstance();
        calendarMv.setSelectedDate(instance.getTime());

//        Calendar instance1 = Calendar.getInstance();
//        instance1.set(instance1.get(Calendar.YEAR), Calendar.JANUARY, 1);
//
//        Calendar instance2 = Calendar.getInstance();
//        instance2.set(instance2.get(Calendar.YEAR), Calendar.DECEMBER, 31);
//
//        calendarMv.state().edit()
//                .setMinimumDate(instance1.getTime())
//                .setMaximumDate(instance2.getTime())
//                .commit();
        calendarMv.addDecorators(
                new MySelectorDecorator(this),
                //new HighlightWeekendsDecorator(),
                oneDayDecorator
        );


        new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());
    }


    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("课程日历");
        Drawable ic_table = res.getDrawable(R.mipmap.ic_table);
        topbar.setLeftIb(ic_table);
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

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        //If you change a decorate, you need to invalidate decorators
        oneDayDecorator.setDate(date.getDate());
        widget.invalidateDecorators();
        strs = "";
        strs = deta[0]+"年"+deta[1]+"月"+deta[2]+"日";
        Log.e("strs",strs);
        if (getSelectedDatesString().equals(strs)){
            coursemsgCmLv.setVisibility(View.VISIBLE);
            CourseCalendarAdapter adapter = new CourseCalendarAdapter(this,reponse);
            coursemsgCmLv.setAdapter(adapter);
        }else {
            coursemsgCmLv.setVisibility(View.GONE);
        }
        Log.e("日期",getSelectedDatesString());
    }

    @Event(value = {R.id.ib_left})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_left:
                Intent intent = new Intent();
                intent.setClass(this,InsideActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * Simulate an API call to show how to add decorators
     */
    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {
        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            if (isRequst){
                calendar.set(Integer.valueOf(deta[0]), Integer.valueOf(deta[1]) - 1, Integer.valueOf(deta[2]));
                isRequst = false;
            }

//            calendar.add(Calendar.MONTH, -2);
            ArrayList<CalendarDay> dates = new ArrayList<>();
            CalendarDay day = CalendarDay.from(calendar);
            dates.add(day);
            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }
            calendarMv.addDecorator(new EventDecorator(Color.rgb(151, 200, 205), calendarDays));
        }
    }

    public void getCourseCalendarDate() {
        Log.e("课程日历", "---------------");
        //网络请求
        CourseCalendarInfoEntity ccine = new CourseCalendarInfoEntity();
        ccine.setCode("1004");
        ccine.setUser_id(1);
        RequestParams params = new RequestParams(COURSE_CALENDAR_URL);
        params.setAsJsonContent(true);
        params.setBodyContent(new Gson().toJson(ccine));
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("Course_Calendar", result);
                reponse = new Gson().fromJson(result, new TypeToken<CourseCalendarEntity>() {
                }.getType());
                deta = reponse.getDate().split("-");
                isRequst = true;
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("Course_Calendar", "FK");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    private String getSelectedDatesString() {
        CalendarDay date = calendarMv.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }
}