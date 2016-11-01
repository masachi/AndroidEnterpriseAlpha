package org.example.androidenterprise.utils;

/**
 * Created by sdlds on 2016/10/26.
 */
public class UrlAddress {
//    public static String VIEWPAGER_URL = "http://128.199.201.13:8080/myapi/regist/ss";
//    public static String COURSE_LIST_URL = "http://128.199.201.13:8080/myapi/regist/sc";
//    public static String LOGIN_URL = "http://128.199.201.13:8080/myapi/login/api_login";
//    public static String REGISTER_URL = "http://128.199.201.13:8080/myapi/regist/getdata";
//    public static String COURSE_INFO_URL = "http://128.199.201.13:8080/myapi/music/api_classdetail";
//    public static String INSTRUMENT_DETAIL_URL = "http://128.199.201.13:8080/myapi/music/api_insdetail";
    private static String URL_HEAD = "http://128.199.137.227:8080";
    public static String VIEWPAGER_URL = URL_HEAD + "/myapi/showslide/api_showslide";
    public static String COURSE_LIST_URL = URL_HEAD + "/regist/sc";
    public static String LOGIN_URL = URL_HEAD + "/login/api_login";
    public static String REGISTER_URL = URL_HEAD + "/myapi/regist/api_regist";
    public static String COURSE_INFO_URL = URL_HEAD + "/music/api_classdetail";
    public static String INSTRUMENT_DETAIL_URL = URL_HEAD + "/music/api_insdetail";

}
