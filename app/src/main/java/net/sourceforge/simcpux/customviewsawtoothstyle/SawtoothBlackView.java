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
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by shaomiao on 2016-10-18.
 */

public class SawtoothBlackView extends View {
    //自定义画笔的属性
    private Paint paint;
    //获取屏幕的系数
    private DisplayMetrics dm;
    //不规则块的高
    private float big_heigth;
    //总的宽度
    private float big_width;
    //小角的高度
    private float triangle_height;
    //小角的高度
    private float triangle_width;
    //是否是向上画的
    private boolean state=true;

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public void setBig_heigth(float big_heigth) {
        this.big_heigth = big_heigth;
    }

    public void setDm(DisplayMetrics dm) {
        this.dm = dm;
    }

    public void setBig_width(float big_width) {
        this.big_width = big_width;
    }

    public void setTriangle_height(float triangle_height) {
        this.triangle_height = triangle_height;
    }

    public void setTriangle_width(float triangle_width) {
        this.triangle_width = triangle_width;
    }

    public SawtoothBlackView(Context context) {
        super(context);
        init();
    }

    public SawtoothBlackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SawtoothBlackView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public SawtoothBlackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        dm= new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);
        paint = new Paint();
        //是否设置抗锯齿效果
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.black));
        //paint.setTextSize((float) 2.0);
        //paint.setStrokeWidth(3);
        this.big_heigth = 30*dm.density;
        this.big_width = dm.widthPixels;
        this.triangle_width= 10*dm.density;
        this.triangle_height=6*dm.density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path(); //定义一条路径
        /**
         * 首先画出定点距离然后根据小角的宽度计算花多少次角
         * 解决铺不满的问题
         * 余数除以画的角的数量
         * 然后画每个角的时候加
         * 保证能铺满
         */
        float remainder= big_width%triangle_width;
        float lineCount=big_width /triangle_width*2;
        if(state) {
            path.moveTo(0, 0);
            path.lineTo(0, big_heigth);
            int i = 1;
            for (; i <= lineCount; i++) {
                path.lineTo((triangle_width / 2+((float)remainder/(float) lineCount)) * i, i % 2 == 0 ? big_heigth : big_heigth - triangle_height);
            }
            path.lineTo((triangle_width / 2+((float)remainder/(float) lineCount)) * (i > 1 ? i - 1 : i), 0);

            path.lineTo(0, 0);
        }else{
            path.moveTo(0,0);
            int i=1;
            //path.lineTo(triangle_width/2*i+remainder,i%2==0?0:triangle_height);
            for(; i< lineCount; i++){
                path.lineTo( ((triangle_width/2+((float)remainder/(float) lineCount))*i),i%2==0?0:triangle_height);
            }
            path.lineTo(big_width,0);
            path.lineTo(big_width,  big_heigth);
            //path.lineTo(dm.widthPixels, big_heigth);
            path.lineTo(0, big_heigth);
            path.lineTo(0,0);
        }
        canvas.drawPath(path, paint);
    }
}
