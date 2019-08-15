package com.demo.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.demo.myapplication.adapter.AdapterBannerComponentA;
import com.demo.myapplication.banner.indicator.BannerComponent;
import com.demo.myapplication.banner.indicator.Indicator;
import com.demo.myapplication.banner.indicator.IndicatorViewPager.IndicatorViewPagerAdapter;
import com.demo.myapplication.banner.indicator.slidebar.ColorBar;
import com.demo.myapplication.banner.indicator.slidebar.ScrollBar;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    A a;
    private String[] url = {"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3190441126,995644236&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3985721766,1358716390&fm=26&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2211997936,2194621113&fm=26&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1802563968,897623865&fm=26&gp=0.jpg"};
    private AdapterBannerComponentA abc;
    private BannerComponent bannerComponent;

    //！！！使用非绘制的指示器
    private LayoutInflater inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.banner_viewPager);
        Indicator indicator = (Indicator) findViewById(R.id.banner_indicator);
        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.TRANSPARENT, 0, ScrollBar.Gravity.CENTENT_BACKGROUND));
        viewPager.setOffscreenPageLimit(2);

        bannerComponent = new BannerComponent(indicator, viewPager, false);
        //！！！使用非绘制的指示器
        inflate = LayoutInflater.from(getApplicationContext());
        abc = new AdapterBannerComponentA(this, url);
        bannerComponent.setAdapter(abc.getAdapter());

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                images = new int[]{};
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                images = new int[]{R.drawable.p2};
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                images = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};
                adapter.notifyDataSetChanged();
            }
        });
        //默认就是800毫秒，设置单页滑动效果的时间
        bannerComponent.setScrollDuration(1000);
        //设置播放间隔时间，默认情况是3000毫秒
        bannerComponent.setAutoPlayTime(2500);
//        switchString();


    }

    private void switchString() {
        /***
         * 第一步 添加依赖关系
         */
        //第一种方式
//        DaggerMainComponenta.create().inject(this);

        //第二种方式
//        DaggerMainConponent.builder().build().inject(this);

        /***
         * 第三步  调用A 对象的方法
         */
        a.eatA();

        String grade = "Bbbb";
//        switch 语句中的变量类型可以是： byte、short、int 或者 char。从 Java SE 7 开始，switch 支持字符串 String 类型了，同时 case 标签必须为字符串常量或字面量。
        switch (grade) {
            case "Aaaa":
                Log.d("MainActivity", "---------优秀");
                break;
            case "Bbbb":
            case "Cccc":
                Log.d("MainActivity", "---------良好");
                break;
            case "Dddd":
                Log.d("MainActivity", "---------及格");
                break;
            case "Ffff":
                Log.d("MainActivity", "---------你需要再努力努力");
                break;
            default:
                Log.d("MainActivity", "---------未知等级");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        bannerComponent.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bannerComponent.stopAutoPlay();
    }

    private int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};

    private IndicatorViewPagerAdapter adapter = new IndicatorViewPagerAdapter() {

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                //！！！使用非绘制的指示器
                convertView = inflate.inflate(R.layout.tab_guide, container, false);
//                convertView = new View(container.getContext());
            }
            return convertView;
        }

        @Override
        public View getViewForPage(final int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = new ImageView(getApplicationContext());
                convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            ImageView imageView = (ImageView) convertView;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, position + 1 + "click", Toast.LENGTH_SHORT).show();
                }
            });
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(images[position]);
            return convertView;
        }

//        @Override
//        public int getItemPosition(Object object) {
//            return RecyclingPagerAdapter.POSITION_NONE;
//        }

        @Override
        public int getCount() {
            return images.length;
        }
    };
}
