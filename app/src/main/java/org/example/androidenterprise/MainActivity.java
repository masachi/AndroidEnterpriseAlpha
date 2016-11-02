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
    /**
     * init top bar text and button visibility
     */
    public interface InitTopBar{
        void initTopBar();
    }

    /**
     * if use relativelayout and top bar has its own id, use this interface to make the include view can be clicked
     */
    public interface InjectIncludeView{
        void injectView();
    }
}
