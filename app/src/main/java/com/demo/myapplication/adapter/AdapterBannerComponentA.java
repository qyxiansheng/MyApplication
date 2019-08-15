package com.demo.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.demo.myapplication.MainActivity;
import com.demo.myapplication.R;
import com.demo.myapplication.banner.indicator.IndicatorViewPager;
import com.demo.myapplication.banner.indicator.IndicatorViewPager.IndicatorViewPagerAdapter;

public class AdapterBannerComponentA {
    private Context context;
    private String[] imagesUrl;


    public AdapterBannerComponentA(Context context, String[] imagesUrl) {
        this.context = context;
        this.imagesUrl = imagesUrl;
    }

    //！！！使用非绘制的指示器
    private LayoutInflater inflate;

    public IndicatorViewPager.IndicatorViewPagerAdapter getAdapter() {
        return adapter;
    }

    private IndicatorViewPagerAdapter adapter = new IndicatorViewPagerAdapter() {

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                inflate = LayoutInflater.from(context.getApplicationContext());
                //！！！使用非绘制的指示器
                convertView = inflate.inflate(R.layout.tab_guide, container, false);
//                convertView = new View(container.getContext());
            }
            return convertView;
        }

        @Override
        public View getViewForPage(final int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = new ImageView(context.getApplicationContext());
                convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            ImageView imageView = (ImageView) convertView;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context.getApplicationContext(), position + 1 + "click", Toast.LENGTH_SHORT).show();
                }
            });
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(context)
                    .load(imagesUrl[position])
                    .error(R.drawable.qweqwe)
                    .into(imageView);
//            imageView.setImageResource(images[position]);
            return convertView;
        }

//        @Override
//        public int getItemPosition(Object object) {
//            return RecyclingPagerAdapter.POSITION_NONE;
//        }

        @Override
        public int getCount() {
            return imagesUrl.length;
        }
    };


}
