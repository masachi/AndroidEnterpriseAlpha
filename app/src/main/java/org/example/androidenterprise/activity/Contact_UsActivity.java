package org.example.androidenterprise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;

@ContentView(R.layout.activity_contact__us)

public class Contact_UsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);
    }
}
