package org.example.androidenterprise.List;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.androidenterprise.Model.CatagoryEntity;

import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by sdlds on 2016/9/21.
 */
public class CatagoryList {
    private static List<CatagoryEntity> calist;

    public static List<CatagoryEntity> getData(Context context) {
        try {
            calist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("catagory.json"))),
                    new TypeToken<List<CatagoryEntity>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calist;
    }
}
