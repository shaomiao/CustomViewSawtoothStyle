package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Created by shaomiao on 2016-10-17.
 */

public class CanvasTest3 extends View {
    Paint paint;
    DisplayMetrics dm;
    int heigth;
    int width;
    int triangle_height;
    int triangle_width;
    private  void init(){
        dm= new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);
        paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
        //paint.setColor(Color.YELLOW);
        //paint.setColor(0xFF412129);
//        paint.setStrokeJoin(Paint.Join.ROUND);
//        paint.setStrokeCap(Paint.Cap.ROUND);
        // paint.setStrokeWidth(3);
        paint = new Paint();
        //是否设置抗锯齿效果
        paint.setAntiAlias(true);
        //paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFF412129);
        //paint.setTextSize((float) 2.0);
        //paint.setStrokeWidth(3);
        this.heigth= (int) (30*dm.density);
        this.width= (int) (dm.widthPixels*dm.density);
        this.triangle_width= (int) (10*dm.density);
        this.triangle_height=(int)(10*dm.density);

    }

    public CanvasTest3(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasTest3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CanvasTest3(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public CanvasTest3(Context context) {
        super(context);
        init();

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



//        path.moveTo(100,200);
//        path.lineTo(100,50);
//        path.lineTo(100*2,90);
//        path.lineTo(100*3,50);
//        path.lineTo(100*4,90);
//        path.lineTo(100*5,50);
//        path.lineTo(100*5,200);
//        path.lineTo(100,200);

        path.moveTo(0,0);
        path.lineTo(0,heigth);
//        path.lineTo(triangle_width/2*1,heigth-triangle_height);
//        path.lineTo(triangle_width/2*2,heigth);
//        path.lineTo(triangle_width/2*3,heigth-triangle_height);
//        path.lineTo(triangle_width/2*4,heigth);
//        path.lineTo(triangle_width/2*4,0);
//        path.lineTo(0,0);
        int i=1;
        Log.e("aaa", "onDraw: "+width );
        Log.e("aaa", "onDraw: "+triangle_width );
        Log.e("aaa", "onDraw: "+width/triangle_width );
        for (;i<=width/triangle_width;i++){
            path.lineTo(triangle_width/2*i,i%2==0?heigth:heigth-triangle_height);
//            path.lineTo(triangle_width/2*i,heigth);
//            path.lineTo(triangle_width/2*i,heigth-triangle_height);
//            path.lineTo(triangle_width/2*i,heigth);
            Log.e("aaa", "onDraw: "+i );
        }
        Log.e("aaa", "onDraw: "+i );
        path.lineTo(triangle_width/2*(i>1?i-1:i),0);
        path.lineTo(0,0);








        canvas.drawPath(path, paint);
    }
}
