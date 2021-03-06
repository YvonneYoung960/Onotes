package com.example.onotes.utils;


import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;


import com.example.onotes.App;

import com.example.onotes.datebase.CityDbHelper;
import com.example.onotes.gson.Weather;
import com.example.onotes.view.NotelistActivity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by 10032 on 2017/3/9.
 */

public class WeatherUtil {


    /**
     * parse JSON date to Weather class
     */

    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather5");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

/**
 * id : CN101010100
 * cityEn : beijing
 * cityZh : 北京
 * provinceEn : beijing
 * provinceZh : 北京
 * leaderEn : beijing
 * leaderZh : 北京
 * lat : 39.904989
 * lon : 116.405285
 */
    /**
     * Parse and handle the data of city from server
     */
    public static boolean handleCityResponse(String response, Context context) {

        if (!TextUtils.isEmpty(response)) {
            try {
                String cityEn;
                JSONArray allCitys = new JSONArray(response);
                CityDbHelper cityDbHelper = new CityDbHelper(context);
                SQLiteDatabase db = cityDbHelper.getWritableDatabase();
                for (int i = 0; i < allCitys.length(); i++) {
                    JSONObject cityObject = allCitys.getJSONObject(i);
                    ContentValues values = new ContentValues();
                    cityEn= cityObject.getString("cityEn");
                    values.put("cityid", cityObject.getString("id"));
                   // values.put("cityEn", cityObject.getString("cityEn"));
                    values.put("cityEn", cityEn.substring(0,1).toUpperCase()+cityEn.substring(1,cityEn.length()));
                    values.put("cityZh", cityObject.getString("cityZh"));
                    values.put("provinceEn", cityObject.getString("provinceEn"));
                    values.put("provinceZh", cityObject.getString("provinceZh"));
                    values.put("leaderEn", cityObject.getString("leaderEn"));
                    values.put("leaderZh", cityObject.getString("leaderZh"));
                    values.put("lat", cityObject.getString("lat"));
                    values.put("lon", cityObject.getString("lon"));
                    db.insert("City", null, values);
                    Log.d("cwj", "add a city");
                }
                db.close();

                SharedPreferenesUtil.setIscityadd(true);

                if (ContextCompat.checkSelfPermission(App.getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    LocationUtil.startLocation();
                }

                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * according to the address and type poured in,query data from server
     */
    public static void queryFromServer(String address) {
        Log.d("db", "queryFromServer");
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                WeatherUtil.handleCityResponse(responseText, App.getContext());
                LogUtil.d("cwj", "queryFromServer succeed");
            }
        });
    }

}
