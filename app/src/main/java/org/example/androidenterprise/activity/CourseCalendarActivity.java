package org.example.androidenterprise.activity;

/**
 * Created by byyoung1 on 2016/10/14.： 课程日历界面
 */


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import org.example.androidenterprise.MainActivity;
import org.example.androidenterprise.R;
import org.example.androidenterprise.utils.EventDecorator;
import org.example.androidenterprise.utils.MySelectorDecorator;
import org.example.androidenterprise.utils.OneDayDecorator;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

@ContentView(R.layout.activity_course_calendar)
public class CourseCalendarActivity extends AppCompatActivity implements OnDateSelectedListener, MainActivity.InitTopBar {

    @ViewInject(R.id.ib_left)
    ImageButton leftIb;
    @ViewInject(R.id.tv_top_bar)
    TextView topTv;
    @ViewInject(R.id.ib_search)
    ImageButton searchIb;
    @ViewInject(R.id.mv_calendar)
    MaterialCalendarView calendarMv;

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initTopBar();
        calendarMv.setOnDateChangedListener(this);
        calendarMv.setShowOtherDates(MaterialCalendarView.SHOW_ALL);

        Calendar instance = Calendar.getInstance();
        calendarMv.setSelectedDate(instance.getTime());

        Calendar instance1 = Calendar.getInstance();
        instance1.set(instance1.get(Calendar.YEAR), Calendar.JANUARY, 1);

        Calendar instance2 = Calendar.getInstance();
        instance2.set(instance2.get(Calendar.YEAR), Calendar.DECEMBER, 31);

        calendarMv.state().edit()
                .setMinimumDate(instance1.getTime())
                .setMaximumDate(instance2.getTime())
                .commit();

        calendarMv.addDecorators(
                new MySelectorDecorator(this),
                //new HighlightWeekendsDecorator(),
                oneDayDecorator
        );

        new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        //If you change a decorate, you need to invalidate decorators
        oneDayDecorator.setDate(date.getDate());
        widget.invalidateDecorators();
    }

    @Event(value = {R.id.ib_left})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_left:
                finish();
                break;
        }
    }

    @Override
    public void initTopBar() {
        topTv.setText(R.string.course_calendar_title);
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
            calendar.add(Calendar.MONTH, -2);
            ArrayList<CalendarDay> dates = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                CalendarDay day = CalendarDay.from(calendar);
                dates.add(day);
                calendar.add(Calendar.DATE, 5);
            }

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


}