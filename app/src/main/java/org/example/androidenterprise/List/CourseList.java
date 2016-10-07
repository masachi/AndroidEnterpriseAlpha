package org.example.androidenterprise.List;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.androidenterprise.model.CourseEntity;

import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by sdlds on 2016/9/18.
 */
public class CourseList {
    public static List<CourseEntity> clist;

    public static List<CourseEntity> getData(Context context){
        try{
            if(clist == null) {
                clist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("course.json"))), new TypeToken<List<CourseEntity>>() {
                }.getType());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return clist;
    }
}
