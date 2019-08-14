package com.demo.myapplication.test.presenter;

import android.os.Handler;
import android.util.Log;

import com.demo.myapplication.mvp.BasePresenter;
import com.demo.myapplication.test.mode.Test01Mode;
import com.demo.myapplication.test.mode.WeatherBean;
import com.demo.myapplication.test.view.Test01View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ClassName:   Test01Presenter
 * Description: P层
 * <p>
 * Author:      leeeyou
 * Date:        2018/2/28 16:11
 */
public class Test01Presenter extends BasePresenter<Test01View> {
    private final Test01Mode mRequestMode;

    public Test01Presenter() {
        this.mRequestMode = new Test01Mode();
    }

    public void clickRequest(final String cityId) {
        if (getView() != null) {
            getView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRequestMode.request(cityId, new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        if (getView() != null) {
                            getView().resultSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        if (getView() != null) {
                            getView().resultFailure(Log.getStackTraceString(t));
                        }
                    }
                });
            }
        }, 1000);
    }


//    @Override
//    public void onCreatedPresenter(@Nullable Bundle savedState) {
//        super.onCreatedPresenter(savedState);
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("test2", "test_save2");
//    }
//
//    @Override
//    public void onDestroyPresenter() {
//        super.onDestroyPresenter();
//    }

    public void interruptHttp() {
//        mRequestMode.interruptHttp();
    }

}
