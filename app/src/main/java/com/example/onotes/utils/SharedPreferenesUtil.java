package com.example.onotes.utils;

import android.content.SharedPreferences;
import android.preference.Preference;

import com.example.onotes.App;
import static android.content.Context.MODE_PRIVATE;


/**
 * Created by cwj on 4/24/17.
 * 统一管理Sharedpreferenes
 */

public class SharedPreferenesUtil {
    //accout
    private static String username;
    private static String password;
    private static boolean remember_password_checkbox;
    private static boolean issignin;


    //qqcount
    private static String nickname;
    private static String gender;
    private static String province;
    private static String city;
    private static String figureurl;
    private static String figureurl_1;
    private static String figureurl_2;
    private static String figureurl_qq_1;
    private static String figureurl_qq_2;
    private static String openID;
    private static String accessToken;
    private static String expires;

    private static String is_first_lanuch;

    private static String weatherid;
    private static String iscityadd;
    private static String bing_pic;
    private static String weatherresponseText;







    private static String weatherCity;
    private static String cityEn;


    private static String cityZh;

    private static String language;

    private static int recyclerview_category;



    private static String located_city;

    private  static String personalizeSignature;

    private static int themeMode;


    private static String avatarUrl;



    private static boolean isNeedUploadAvatar;


    private static boolean isUpdateAvatar;


    public static boolean isNeedBackGroud() {
        return app_pref.getBoolean("isNeedBackGroud",false);
    }

    public static void setIsNeedBackGroud(boolean isNeedBackGroud) {
        app_editor.putBoolean("isNeedBackGroud",isNeedBackGroud).apply();
    }

    private static boolean isNeedBackGroud;

    private static SharedPreferences.Editor qqaccount_editor = App.getContext().getSharedPreferences("qqaccount", MODE_PRIVATE).edit();

    private static SharedPreferences qqaccount_pref = App.getContext().getSharedPreferences("qqaccount", MODE_PRIVATE);

    private static SharedPreferences account_pref = App.getContext().getSharedPreferences("account", MODE_PRIVATE);

    private static SharedPreferences.Editor account_editor = App.getContext().getSharedPreferences("account", MODE_PRIVATE).edit();

    private static SharedPreferences app_pref = App.getContext().getSharedPreferences("app", MODE_PRIVATE);

    private static SharedPreferences.Editor app_editor = App.getContext().getSharedPreferences("app", MODE_PRIVATE).edit();

    private static SharedPreferences weather_pref = App.getContext().getSharedPreferences("weather", MODE_PRIVATE);

    private static SharedPreferences.Editor weather_editor = App.getContext().getSharedPreferences("weather", MODE_PRIVATE).edit();

    private static SharedPreferences myUser_pref = App.getContext().getSharedPreferences("myUser", MODE_PRIVATE);

    private static SharedPreferences.Editor myUser_editor = App.getContext().getSharedPreferences("myUser", MODE_PRIVATE).edit();



    public static boolean isNeedUploadAvatar() {
        return app_pref.getBoolean("isNeedUploadAvatar",false);
    }

    public static void setIsNeedUploadAvatar(boolean isNeedUploadAvatar) {
        app_editor.putBoolean("isNeedUploadAvatar",isNeedUploadAvatar);
    }

    public static boolean isUpdateAvatar() {
        return app_pref.getBoolean("isUpdateAvatar",false);
    }

    public static void setIsUpdateAvatar(boolean isUpdateAvatar) {
        app_editor.putBoolean("avatarUrl",isUpdateAvatar).apply();
    }

    public static String getAvatarUrl() {
        return app_pref.getString("avatarUrl","");
    }

    public static void setAvatarUrl(String avatarUrl) {
       app_editor.putString("avatarUrl",avatarUrl).apply();
    }



//0为日间模式 1为夜间模式
    public static int getThemeMode() {
        return app_pref.getInt("theme",0);
    }

    public static void setThemeMode(int themeMode) {
        app_editor.putInt("theme",themeMode).apply();
    }





    public static  String getPersonalizeSignature() {
        return myUser_pref.getString("personalizeSignature","");
    }

    public static  void setPersonalizeSignature(String personalizeSignature) {
        myUser_editor.putString("personalizeSignature",personalizeSignature);
        myUser_editor.apply();
    }



   /* public static String getWeatherCity() {
        return weatherCity;
    }

    public static void setWeatherCity(String weatherCity) {
        SharedPreferenesUtil.weatherCity = weatherCity;
    }*/

    public static String getLocated_city() {
     return weather_pref.getString("located_city","");
    }



    public static void setLocated_city(String located_city) {
        weather_editor.putString("located_city",located_city);
        weather_editor.apply();
    }


    public static int getRecyclerview_category() {
        return app_pref.getInt("recyclerview_category",-1);
    }

    public static void setRecyclerview_category(int recyclerview_category) {
        app_editor.putInt("recyclerview_category",recyclerview_category);
        app_editor.apply();
    }



    public static String getCityZh() {
        return weather_pref.getString("cityZh","");
    }

    public static void setCityZh(String cityZh) {
        weather_editor.putString("cityZh", cityZh);
        weather_editor.apply();
    }

    public static String getCityEn() {
        return weather_pref.getString("cityEn","");
    }

    public static void setCityEn(String cityEn) {
        weather_editor.putString("cityEn", cityEn);
        weather_editor.apply();
    }


    public static String getLanguage() {
        return app_pref.getString("language","default");
    }

    public static void setLanguage(String language) {
        app_editor.putString("language", language);
        app_editor.apply();
        //ToastUtil.showToast(language, Toast.LENGTH_LONG);
        //App.getContext()
    }





    public static String getBing_pic() {
        return weather_pref.getString("bing_pic",null);
    }

    public static void setBing_pic(String bing_pic) {
        weather_editor.putString("bing_pic",bing_pic);
        weather_editor.apply();
    }

    public static String getWeatherresponseText() {
        return weather_pref.getString("weatherresponseText",null);
    }


    public static void setWeatherresponseText(String weatherresponseText) {
        weather_editor.putString("weatherresponseText",weatherresponseText);
        weather_editor.apply();
    }


    public static boolean isCityadd() {
        return weather_pref.getBoolean("iscityadded",false);
    }

    public static void setIscityadd(boolean iscityadd) {
        weather_editor.putBoolean("iscityadded",iscityadd);
        weather_editor.apply();
    }


    public static String getWeatherid() {
        return weather_pref.getString("weatherid","");
    }

    public static void setWeatherid(String weatherid) {
        weather_editor.putString("weatherid",weatherid);
        weather_editor.apply();
    }


    public static boolean getIs_first_lanuch() {
        return app_pref.getBoolean("is_first_lanuch",true);
    }

    public static void setIs_first_lanuch(boolean is_first_lanuch) {
        app_editor.putBoolean("is_first_lanuch", is_first_lanuch);
        app_editor.apply();
    }



    public static boolean issignin() {
        return account_pref.getBoolean("issignin",false);
    }

    public static void setIssignin(boolean issignin) {
        account_editor.putBoolean("issignin", issignin);
        account_editor.apply();
    }

    public static boolean isRemember_password_checkbox() {
        return account_pref.getBoolean("remember_password_checkbox",false);
    }

    public static void setRemember_password_checkbox(boolean remember_password_checkbox) {
        account_editor.putBoolean("remember_password_checkbox", remember_password_checkbox);
        account_editor.apply();
    }


    public static String getUsername() {
        return account_pref.getString("username","");
    }

    public static void setUsername(String username) {
        account_editor.putString("username", username);
        account_editor.apply();
    }


    public static String getPassword() {
        return account_pref.getString("password","");
    }

    public static void setPassword(String password) {
        account_editor.putString("password", password);
        account_editor.apply();
    }

    public static void setQqInfo(String nickname, String gender, String province, String city,
                                 String figureurl, String figureurl_1, String figureurl_2,
                                 String figureurl_qq_1, String figureurl_qq_2, String openID,
                                 String accessToken, String expires) {
        qqaccount_editor = App.getContext().getSharedPreferences("qqaccount", MODE_PRIVATE).edit();
        qqaccount_editor.putString("nickname", nickname);
        qqaccount_editor.putString("gender", gender);
        qqaccount_editor.putString("province", province);
        qqaccount_editor.putString("city", city);
        qqaccount_editor.putString("figureurl", figureurl);
        qqaccount_editor.putString("figureurl_1", figureurl_1);
        qqaccount_editor.putString("figureurl_2", figureurl_2);
        qqaccount_editor.putString("figureurl_qq_1", figureurl_qq_1);
        qqaccount_editor.putString("figureurl_qq_2", figureurl_qq_2);
        qqaccount_editor.putString("openID", openID);
        qqaccount_editor.putString("accessToken", accessToken);
        qqaccount_editor.putString("expires", expires);
        qqaccount_editor.apply();
    }


    public static String getNickname() {
        return qqaccount_pref.getString("nickname", "");
    }
    public static void setNickname(String nickname) {
        qqaccount_editor.putString("nickname",nickname);
        qqaccount_editor.apply();
    }


    public static String getGender() {
        return qqaccount_pref.getString("gender", "");
    }

    public static String getProvince() {
        return qqaccount_pref.getString("province", "");

    }

    public static String getCity() {
        return qqaccount_pref.getString("city", "");

    }

    public static String getFigureurl_1() {
        return qqaccount_pref.getString("figureurl_1", "");

    }

    public static String getFigureurl() {
        return qqaccount_pref.getString("figureurl", "");

    }

    public static String getFigureurl_qq_1() {
        return qqaccount_pref.getString("figureurl_qq_1", "");
    }

    public static String getFigureurl_2() {
        return qqaccount_pref.getString("figureurl_2", "");
    }

    public static String getOpenID() {
        return qqaccount_pref.getString("openID", "");

    }

    public static String getFigureurl_qq_2() {
        return qqaccount_pref.getString("figureurl_qq_2", "");
    }

    public static String getAccessToken() {
        return qqaccount_pref.getString("accessToken", "");
    }

    public static String getExpires() {
        return qqaccount_pref.getString("expires", "");
    }




}
