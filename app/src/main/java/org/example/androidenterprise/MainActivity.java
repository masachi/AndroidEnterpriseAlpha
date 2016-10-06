package org.example.androidenterprise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.InsideActivity;
import org.example.androidenterprise.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent().setClass(MainActivity.this, InsideActivity.class));
                startActivity(new Intent().setClass(MainActivity.this, LoginActivity.class));
                //startActivity(new Intent().setClass(MainActivity.this, InsideActivity.class));
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(MainActivity.this, InsideActivity.class));
                //startActivity(new Intent().setClass(MainActivity.this, LoginActivity.class));
                //startActivity(new Intent().setClass(MainActivity.this, InsideActivity.class));
            }
        });
    }
}
