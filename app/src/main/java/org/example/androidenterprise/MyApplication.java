package org.example.androidenterprise;

import android.app.Application;
import org.xutils.x;

/**
 * Created by sdlds on 2016/10/10.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 开启debug会影响性能
    }
}
