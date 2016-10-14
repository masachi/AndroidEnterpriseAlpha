package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

;

@ContentView(R.layout.activity_contact_us)

public class ContactUsActivity extends AppCompatActivity {


    @ViewInject(R.id.contact_us_return_ib)
    ImageButton contact_us_return_ib;
    @ViewInject(R.id.dial_telephone_tv)
    TextView dial_telephone_tv;
    @ViewInject(R.id.service_gv)
    GridView service_gv;
    @ViewInject(R.id.qq_gv)
    GridView qq_gv;
//    TODO get data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
