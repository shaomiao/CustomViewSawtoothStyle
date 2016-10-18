package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by shaomiao on 2016-10-18.
 * 一条锯齿线
 */

public class CanvasTest5 extends View {
    private Paint paint;
    private DisplayMetrics dm;
    private int heigth;
    private int width;
    private int triangle_height;
    private int triangle_width;
    //是否是向上画的
    private boolean state=true;

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public CanvasTest5(Context context) {
        super(context);
        init();
    }

    public CanvasTest5(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CanvasTest5(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public CanvasTest5(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        dm= new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);
        paint = new Paint();
        //是否设置抗锯齿效果
        paint.setAntiAlias(true);
        //paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.black));
        //paint.setTextSize((float) 2.0);
        //paint.setStrokeWidth(3);
        this.heigth= (int) (30*dm.density);
        this.width= (int) (dm.widthPixels*dm.density);
        this.triangle_width= (int) (10*dm.density);
        this.triangle_height=(int)(6*dm.density);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path(); //定义一条路径
        if(state) {
            path.moveTo(0, 0);
            path.lineTo(0, heigth);
            int i = 1;
            for (; i <= width / triangle_width; i++) {
                path.lineTo(triangle_width / 2 * i, i % 2 == 0 ? heigth : heigth - triangle_height);
            }
            path.lineTo(triangle_width / 2 * (i > 1 ? i - 1 : i), 0);
            path.lineTo(0, 0);
        }else{
            path.moveTo(0,0);
            int i=1;
            for(;i<width/triangle_width;i++){
                path.lineTo(triangle_width/2*i,i%2==0?0:triangle_height);
            }
            path.lineTo(triangle_width/2*i,0);
            path.lineTo(triangle_width/2*i,heigth);
            path.lineTo(0,heigth);
            path.lineTo(0,0);
        }
        canvas.drawPath(path, paint);
    }
}
