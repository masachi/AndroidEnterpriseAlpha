package org.example.androidenterprise.List;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.androidenterprise.model.SettingEntity;

import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by sdlds on 2016/9/18.
 */
public class SettingList {
    private static List<SettingEntity> slist;

    public static List<SettingEntity> getData(Context context){
        try{
            if(slist == null) {
                slist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("setting.json"))), new TypeToken<List<SettingEntity>>() {
                }.getType());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return slist;
    }
}
