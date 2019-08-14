package com.demo.myapplication.test.mode;

import com.demo.myapplication.test.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * ClassName:   Test01Mode
 * Description: M层
 * <p>
 * Author:      leeeyou
 * Date:        2018/2/28 16:10
 */
public class Test01Mode {
    private static final String BASE_URL = "http://www.weather.com.cn/";
    private Call<WeatherBean> weatherBeanCall;

    public void request(String cityId, Callback<WeatherBean> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        weatherBeanCall = apiService.requestWeather(cityId);
        weatherBeanCall.enqueue(callback);
    }

    public void interruptHttp() {
        if (weatherBeanCall != null && !weatherBeanCall.isCanceled()) {
            weatherBeanCall.cancel();
        }
    }

}
