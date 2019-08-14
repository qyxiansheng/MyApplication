package com.demo.myapplication.test.view;

import com.demo.myapplication.mvp.IMvpView;
import com.demo.myapplication.test.mode.WeatherBean;

/**
 * ClassName:   Test01View
 * Description: V层
 * <p>
 * Author:      leeeyou
 * Date:        2018/2/28 16:12
 */
public interface Test01View extends IMvpView {
    void requestLoading();

    void resultSuccess(WeatherBean result);

    void resultFailure(String result);
}
