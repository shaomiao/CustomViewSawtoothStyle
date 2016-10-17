package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by shaomiao on 2016-10-17.
 */

public class CanvasTest extends View {

    public CanvasTest(Context context) {
        super(context);
    }
    /**
     * 要画图形，最起码要有三个对象：
     * 1.颜色对象 Color
     * 2.画笔对象 Paint
     * 3.画布对象 Canvas
     */

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        //设置颜色为蓝色
        paint.setColor(Color.BLUE);
        //设置字体大小
        paint.setTextSize(200);
        //让画图为空心
        paint.setStyle(Paint.Style.STROKE);
        //设置画出的线的粗细
        paint.setStrokeWidth(5);
        //画出一条线
        canvas.drawLine(0, 0, 200, 200, paint);
        //画矩形
        //画矩形
        canvas.drawRect(200, 500, 300, 300, paint);
        //画圆
        canvas.drawCircle(200, 200, 100, paint);
        //画出字符串 drawText(String text, float x, float y, Paint paint)
        // y 是 基准线 ，不是 字符串的 底部
        canvas.drawText("apple", 60, 60, paint);
        canvas.drawLine(0, 60, 500, 60, paint);
        //绘制图片

        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 150, 150, paint);
//canvas.drawRGB(23,23,23);
        //canvas.drawCircle(100, 100, 90, paint);
        //

    }
}
