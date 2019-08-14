package com.demo.myapplication.test.testMvpFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.demo.myapplication.R;
import com.demo.myapplication.mvp.AbstractMvpFragment;
import com.demo.myapplication.test.mode.WeatherBean;
import com.demo.myapplication.test.presenter.Test01Presenter;
import com.demo.myapplication.test.view.Test01View;
import com.google.gson.Gson;

/**
 * ClassName:   Test02Fragment
 * Description: mvp fragment测试类
 * <p>
 * Author:      leeeyou
 * Date:        2018/2/28 16:12
 */
public class Test02Fragment extends AbstractMvpFragment<Test01Presenter> implements Test01View {

    private Test01Presenter mTest01Presenter;

    @Override
    protected Test01Presenter createPresenter() {
        mTest01Presenter = new Test01Presenter();
        return mTest01Presenter;
    }

    @Override
    protected View onBindView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test02, container, false);
        View btn_fragment = v.findViewById(R.id.btn_fragment);
        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTest01Presenter.clickRequest("101010100");
            }
        });
        return v;
    }

    @Override
    public void requestLoading() {
        Toast.makeText(getActivity(), "发起网络请求,请稍后...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resultSuccess(WeatherBean result) {
        //成功
        Toast.makeText(getActivity(), "onSuccess : " + new Gson().toJson(result.getWeatherinfo()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resultFailure(String result) {
        //失败
        Toast.makeText(getActivity(), "onFailure", Toast.LENGTH_SHORT).show();
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
