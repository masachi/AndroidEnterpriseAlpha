package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_help__center)

public class Help_CenterActivity extends AppCompatActivity {


    @ViewInject(R.id.help_center_return_ib)
    ImageButton rebackIb;
    @ViewInject(R.id.use_article_context_tv)
    TextView use_article_context_tv;
    @ViewInject(R.id.about_context_tv)
    TextView about_context_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
