package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.utils.MovieRecorderView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.Timer;
import java.util.TimerTask;

@ContentView(R.layout.activity_video_record)

public class VideoRecordActivity extends BaseActivity {


    @ViewInject(R.id.ib_return)
    ImageButton returnIb;
    @ViewInject(R.id.ib_upload)
    ImageButton uploadIb;
    @ViewInject(R.id.rv_record)
    MovieRecorderView recordRv;
    @ViewInject(R.id.tv_record_time)
    TextView timeTv;
    @ViewInject(R.id.ib_record)
    ImageButton recordIb;
    @ViewInject(R.id.tv_record)
    TextView recordTv;

    private int mTimeCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Event(value = {R.id.ib_return, R.id.ib_upload, R.id.ib_record})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_return:
                finish();
                break;
            case R.id.ib_upload:
                break;
            case R.id.ib_record:
                if(recordTv.getText().toString().equals("暂停")){
                    recordRv.record(new MovieRecorderView.OnRecordFinishListener() {
                        @Override
                        public void onRecordFinish() {

                        }
                    });
                    updateTimer();
                    recordIb.setImageResource(R.mipmap.ic_video_record);
                    recordTv.setText("录制");
                }
                else{
                    if(recordTv.getText().toString().equals("录制")){
                        recordRv.stop();
                        recordIb.setImageResource(R.mipmap.ic_video_pause);
                        recordTv.setText("暂停");
                    }
                }
                break;
        }
    }

    private void updateTimer(){
        Timer mTimer = new Timer();
        mTimeCount = 0;
        mTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                mTimeCount++;
                if(mTimeCount < 60){
                    //timeTv.setText("00"+":"+ String.valueOf(mTimeCount));
                }
                else{
                    //timeTv.setText(String.valueOf(mTimeCount%60) + ":" + String.valueOf(mTimeCount - 60));
                }
            }
        }, 0, 1000);
    }
}
