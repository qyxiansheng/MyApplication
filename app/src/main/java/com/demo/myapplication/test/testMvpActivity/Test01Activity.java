package com.demo.myapplication.test.testMvpActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.demo.myapplication.R;
import com.demo.myapplication.mvp.AbstractMvpActivity;
import com.demo.myapplication.test.mode.WeatherBean;
import com.demo.myapplication.test.presenter.Test01Presenter;
import com.demo.myapplication.test.view.Test01View;
import com.google.gson.Gson;

/**
 * ClassName:   Test01Activity
 * Description: mvp Activity测试类
 * <p>
 * Author:      leeeyou
 * Date:        2018/2/28 16:11
 */
public class Test01Activity extends AbstractMvpActivity<Test01Presenter> implements Test01View {

    private Test01Presenter mTest01Presenter;

    @Override
    protected Test01Presenter createPresenter() {
        mTest01Presenter = new Test01Presenter();
        return mTest01Presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);

        View btn_01 = findViewById(R.id.btn_test_activity);
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTest01Presenter.clickRequest("101010100");
            }
        });
    }

    @Override
    public void requestLoading() {
        Toast.makeText(this, "发起网络请求,请稍后...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resultSuccess(WeatherBean result) {
        //成功
        Toast.makeText(this, "onSuccess : " + new Gson().toJson(result.getWeatherinfo()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resultFailure(String result) {
        //失败
        Toast.makeText(this, "onFailure", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    public void showLoading(String tips) {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showToast(String info) {

    }

    @Override
    public void onFinish() {

    }
}
