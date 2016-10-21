package org.example.androidenterprise.utils;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.androidenterprise.model.*;

import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by sdlds on 2016/10/5.
 */
public class InitData {
    //    public static List<CatagoryEntity> calist;
    public static List<CourseEntity> clist;
    //    public static List<IntroductionEntity> introlist;
//    public static List<ItemEntity> ilist;
    public static List<OrderEntity> olist;
    public static List<SettingEntity> slist;
    //    public static List<UserInfoEntity> ulist;
    public static CourseEntity course;

    public static void initData(Context context) {
        try {
//            calist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("catagory.json"))),
//                    new TypeToken<List<CatagoryEntity>>() {}.getType());
//
            clist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("course.json"))),
                    new TypeToken<List<CourseEntity>>() {
                    }.getType());
//
//            introlist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("introduction.json"))),
//                    new TypeToken<List<IntroductionEntity>>() {}.getType());
//
//            ilist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("AllItem.json"))),
//                    new TypeToken<List<ItemEntity>>() {}.getType());
//
            olist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("order.json"))),
                    new TypeToken<List<OrderEntity>>() {
                    }.getType());
//
            slist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("setting.json"))),
                    new TypeToken<List<SettingEntity>>() {
                    }.getType());
//
//            ulist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("UserInfo.json"))),
//                    new TypeToken<List<UserInfoEntity>>() {}.getType());

            course = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("CourseInfo.json"))),
                    new TypeToken<CourseEntity>() {
                    }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
