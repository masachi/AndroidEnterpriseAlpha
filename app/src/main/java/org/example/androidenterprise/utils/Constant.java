package org.example.androidenterprise.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by sdlds on 2016/10/26.
 */
public class Constant {
    private static String URL_HEAD = "https://128.199.74.192:443";
    public static String VIEWPAGER_URL = URL_HEAD + "/myapi/showslide/api_showslide";
    public static String COURSE_LIST_URL = URL_HEAD + "/regist/sc";
    public static String LOGIN_URL = URL_HEAD + "/music-stju-test/api_login";
    public static String REGISTER_URL = URL_HEAD + "/myapi/regist/api_regist";
    public static String COURSE_INFO_URL = URL_HEAD + "/music-stju-test/api_classdetail";
    public static String INSTRUMENT_DETAIL_URL = URL_HEAD + "/music-stju-test/api_insdetail";
    public static String SELECT_ADDRESS_URL = URL_HEAD + "/music-stju-test/api_selectadd";
    public static String STUDENT_FEEDBACK_URL = URL_HEAD + "/music-stju-test/api_feedback";
    public static String RECORD_URL = URL_HEAD + "/myapi/buyOrder/api_buyInsOrder";
    public static String HELP_CENTER_URL = URL_HEAD + "/music-stju-test/api_helpcenter";
    public static String ALBUM_URL = URL_HEAD + "/myapi/showalbum/api_showalbum";
    public static String INSANDDES_URL = URL_HEAD + "/myapi/showInsAndDes/api_insdes";
    public static String INSTRUMENT_URL = URL_HEAD + "/myapi/showinstrument/api_showinstrument";
//    public static String RESERVATION_ORDER_URL = URL_HEAD + "/myapi/ReservationOrder/api_showReservationOrder";
    public static String INSTRUNMET_URL = URL_HEAD + "/myapi/showinstrument/api_showinstrument";
    public static String EDIT_ADDRESS_URL = URL_HEAD + "/myapi/receiverAddress/api_edictAddress";
    public static String COURSE_CALENDAR_URL = URL_HEAD + "/music-stju-test/api_calendar";
//    public static String COMPLAIN_SUGGEST_URL = URL_HEAD + "/music-stju-test/api_complaint";
    public static String RESERVATION_ORDER_URL = URL_HEAD + "/myapi/ReservationOrder/api_showReservationOrder";
//    public static String ORDER_PAY_URL = URL_HEAD + "/music-stju-test/api_payorder";
//    public static String RELEASE_FEEDBACK_URL = URL_HEAD + "/myapi/feedback/api_feedBack";
    public static String ORDER_PAY_URL = URL_HEAD + "/music-stju-test/api_payorder";
    public static String COMPLAIN_SUGGEST_URL = URL_HEAD + "/music-stju-test/api_complaint";
    public static String RELEASE_FEEDBACK_URL = URL_HEAD + "/myapi/feedback/api_feedBack";
    public static String CONFIRM_ORDER_URL = URL_HEAD + "/myapi/buyInstrument/api_buyinstrument";
    public static String SYSTEM_MESSAGE_URL=URL_HEAD+"/myapi/showSystemMessage/api_showSystemMessage";
    public static int systemMessageNum=2;

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

   public static String serviceName[] = {"客服1", "客服2", "客服3", "客服4", "客服5", "客服6", "客服7"};

    public static int JUMP = 1;
    //趣拍
    public static final String APP_KEY = "20d4cfd18f84cc8";
    public static final String APP_SECRET = "a9d1065295f44ea59b970ba63ec6c7a3";
    public static final String domain = "http://instrument.s.qupai.me";//当前TEST应用的域名。该地址每个应用都不同
    public static int JUMP_MAINACTIVITY = 1;
    public static int chooseRecycleView = 0;
    public static String account = "";
    public static String headPortrait = "";
    /**
     * 默认时长
     */
    public static  float DEFAULT_DURATION_LIMIT = 8;
    /**
     * 默认最小时长
     */
    public static  float DEFAULT_MIN_DURATION_LIMIT = 2;
    /**
     * 默认码率
     */
    public static  int DEFAULT_BITRATE =2000 * 1000;
    /**
     * 默认Video保存路径，请开发者自行指定
     */
    public static  String VIDEOPATH = FileUtils.newOutgoingFilePath();
    /**
     * 默认缩略图保存路径，请开发者自行指定
     */
    public static  String THUMBPATH =  VIDEOPATH + ".jpg";
    /**
     * 水印本地路径，文件必须为rgba格式的PNG图片
     */
    public static  String WATER_MARK_PATH ="assets://Qupai/watermark/qupai-logo.png";
    public static String tags = "tags";
    public static String description = "description";
    public static int shareType = 0; //是否公开 0公开分享 1私有(default) 公开类视频不需要AccessToken授权
    public static String accessToken;//accessToken 通过调用授权接口得到
    //    public static String space = UUID.randomUUID().toString().replace("-",""); //存储目录 建议使用uid cid之类的信息,不要写死
    public static String space = null; //存储目录 建议使用uid cid之类的信息,不要写死

    public static int RECORDE_SHOW = 10001;

    public static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    public static int CLASS_TIME = 1;

    public static int USERID = 1;
}
