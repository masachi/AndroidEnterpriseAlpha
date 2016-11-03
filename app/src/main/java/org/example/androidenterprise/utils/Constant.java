package org.example.androidenterprise.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by sdlds on 2016/10/26.
 */
public class Constant {
    private static String URL_HEAD = "http://128.199.137.227:8080";
    public static String VIEWPAGER_URL = URL_HEAD + "/myapi/showslide/api_showslide";
    public static String COURSE_LIST_URL = URL_HEAD + "/regist/sc";
    public static String LOGIN_URL = URL_HEAD + "/music-stju-test/api_login";
    public static String REGISTER_URL = URL_HEAD + "/myapi/regist/api_regist";
    public static String COURSE_INFO_URL = URL_HEAD + "/music/api_classdetail";
    public static String INSTRUMENT_DETAIL_URL = URL_HEAD + "/music/api_insdetail";
    public static String STUDENT_FEEDBACK_URL = URL_HEAD + "/music-stju-test/api_feedback";
    public static String HELP_CENTER_URL=URL_HEAD+"/music-stju-test/api_helpcenter";
    public static String ALBUM_URL = URL_HEAD + "/myapi/showalbum/api_showalbum";
    public static String INSANDDES_URL = URL_HEAD + "/myapi/showInsAndDes/api_insdes";
    public static String INSTRUNMET_URL = URL_HEAD + "/myapi/showinstrument/api_showinstrument";

    public static int STUDENT_NUMBER = 10;
    public static int MAX_STUDENT_NUMBER = 8;
    public static int MAX_STUDENT_NUMBER_BACK = 7;

    public static Long TIME_INTERVAL = 60000L;

    public static int lastPosition = -1;
    public static int size = 10;

    public static  String ARG_PARAM1 = "param1";
    public static  String ARG_PARAM2 = "param2";

    public static float DEFAULT_RADIUS = 3;

    public static int TIME_INTERVALAUTOPLAYINGVIEWPAGER = 5;

    public static  ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    public static Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    public static int COLORDRAWABLE_DIMENSION = 2;

    public static int DEFAULT_BORDER_WIDTH = 0;
    public static int DEFAULT_BORDER_COLOR = Color.BLACK;
    public static int DEFAULT_FILL_COLOR = Color.TRANSPARENT;
    public static boolean DEFAULT_BORDER_OVERLAY = false;

    public static int PULL_TO_REFRESH = 2;
    public static int RELEASE_TO_REFRESH = 3;
    public static int REFRESHING = 4;
    // pull state
    public static int PULL_UP_STATE = 0;
    public static int PULL_DOWN_STATE = 1;

}
