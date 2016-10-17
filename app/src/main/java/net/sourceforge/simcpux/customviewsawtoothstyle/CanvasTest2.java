package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by shaomiao on 2016-10-17.
 */

public class CanvasTest2 extends View {
    Paint paint;
    public CanvasTest2(Context context) {
        super(context);
        paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔

        //paint.setColor(Color.YELLOW);
        //paint.setColor(0xFF412129);

//        paint.setStrokeJoin(Paint.Join.ROUND);
//
//        paint.setStrokeCap(Paint.Cap.ROUND);

       // paint.setStrokeWidth(3);
        paint = new Paint();
        //是否设置抗锯齿效果
        paint.setAntiAlias(true);
        //paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFF412129);
        //paint.setTextSize((float) 2.0);
        //paint.setStrokeWidth(3);

    }
    @Override
    protected void onDraw(Canvas canvas) {
       // canvas.drawColor(Color.BLUE);
//        RectF rect = new RectF(0, 0, 100, 100);
//        canvas.drawArc(rect, //弧线所使用的矩形区域大小
//                0,  //开始角度
//                90, //扫过的角度
//                false, //是否使用中心
//                paint);
        Path path = new Path(); //定义一条路径

//        path.moveTo(10, 10); //移动到 坐标10,10
//
//        path.lineTo(100, 10);
//
//        path.lineTo(100,100);
//        path.lineTo(10,100);
//
//        path.lineTo(10, 10);
        path.moveTo(100,200);
        path.lineTo(100,50);
        path.lineTo(100*2,90);
        path.lineTo(100*3,50);
        path.lineTo(100*4,90);
        path.lineTo(100*5,50);
        path.lineTo(100*5,200);
        path.lineTo(100,200);




        canvas.drawPath(path, paint);
    }
}
