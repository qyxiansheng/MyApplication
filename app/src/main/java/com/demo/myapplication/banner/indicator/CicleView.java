package com.demo.myapplication.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CicleView extends View {
    private int realWidth, realHeiht;

    //    定义画笔
    Paint paint;

    public CicleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measure(widthMeasureSpec);
        measure(heightMeasureSpec);
        Log.e("onMeasure", "realWidth: " + realWidth + "realHeiht: " + realHeiht + "widthMeasureSpec" + widthMeasureSpec + "heightMeasureSpec" + heightMeasureSpec);
        setMeasuredDimension(realWidth, realHeiht);
    }

    private void measure(int measureValue) {
        int defalueWidthSize = 20;//默认宽度
        int defalueHeightSize = 20;//默认高度
        int mode = MeasureSpec.getMode(measureValue);
        int specValue = MeasureSpec.getSize(measureValue);
        Log.e("onMeasure", "mode: " + mode + "specValue: " + specValue);
        switch (mode) {
            //指定一个默认值
            case MeasureSpec.UNSPECIFIED:
                Log.e("onMeasure", "mode: " + mode + "UNSPECIFIED ");
                realWidth = defalueWidthSize;
                realHeiht = defalueHeightSize;
                break;
            //取测量值
            case MeasureSpec.EXACTLY:
                Log.e("onMeasure", "mode: " + mode + "EXACTLY ");
                realHeiht = specValue;
                realWidth = specValue;
                break;
            //取测量值和默认值中的最小值
            case MeasureSpec.AT_MOST:
                Log.e("onMeasure", "mode: " + mode + "AT_MOST ");
                realWidth = Math.min(defalueWidthSize, specValue);
                realHeiht = Math.min(defalueHeightSize, specValue);
                break;
            default:
                break;
        }
    }

    //    重写draw方法
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        实例化画笔对象
        paint = new Paint();
//        给画笔设置颜色
        paint.setColor(Color.RED);
//        设置画笔属性
        paint.setStyle(Paint.Style.FILL);//画笔属性是实心圆
//        paint.setStyle(Paint.Style.STROKE);//画笔属性是空心圆
        paint.setStrokeWidth(8);//设置画笔粗细
        /*四个参数：
                参数一：圆心的x坐标
                参数二：圆心的y坐标
                参数三：圆的半径
                参数四：定义好的画笔
                */
        paint.setAntiAlias(true);
        canvas.drawCircle(realWidth / 2, realHeiht / 2, realWidth / 2, paint);
    }
}
