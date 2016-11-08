package org.example.androidenterprise.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by yangxinghua : 播放视频界面
 */
@ContentView(R.layout.activity_video_play)
public class VideoPlayActivity extends AppCompatActivity {

    @ViewInject(R.id.ib_return)
    ImageButton returnIb;
    @ViewInject(R.id.vv_video_play)
    VideoView videoPlayVV;

    private MediaController mMediaController;
    private Uri uri;
    String path2 = "http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai" +
            ".com/D046015255134077DDB3ACA0D7E68D45.flv";
    //String path1 = Environment.getExternalStorageDirectory() + "/ok.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        x.view().inject(this);
        play();
    }

    private void play() {

        uri = Uri.parse(path2);
        videoPlayVV.setVideoURI(uri);
        // mVideoView.setVideoPath(path1);//设置播放地址
        mMediaController = new MediaController(this);//实例化控制器
        mMediaController.show(10000);//控制器显示5s后自动隐藏
        videoPlayVV.setMediaController(mMediaController);//绑定控制器
        videoPlayVV.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//设置播放画质 高画质
        videoPlayVV.requestFocus();//取得焦点

    }

    @Event(value = {R.id.ib_return})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_return:
                finish();
                break;
        }
    }
}
