package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by shaomiao on 2016/10/11.
 */

public class BezierTestView extends View {
    private int screenWidth;
    private Paint mPaint;
    private Path mPath;
    //两个距离的差越小角的高越小
    //最大距离 距离顶端 第一个顶点y
    private int first_y=70;
    //第一个顶点x
    private int first_x=0;
    //角的大小宽
    private int horn_size=100;
    //最小距离距离顶端
    private int minimum_distance=10;

    public int getMinimum_distance() {
        return minimum_distance;
    }

    public void setMinimum_distance(int minimum_distance) {
        this.minimum_distance = minimum_distance;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getFirst_x() {
        return first_x;
    }

    public int getFirst_y() {
        return first_y;
    }

    public void setFirst_x(int first_x) {
        this.first_x = first_x;
    }

    public void setFirst_y(int first_y) {
        this.first_y = first_y;
    }

    public int getHorn_size() {
        return horn_size;
    }

    public void setHorn_size(int horn_size) {
        this.horn_size = horn_size;
    }

    public BezierTestView(Context context) {
        super(context);
        init();
    }

    public BezierTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BezierTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        /**
         setAntiAlias: 设置画笔的锯齿效果。
         setColor: 设置画笔颜色
         setARGB:  设置画笔的a,r,p,g值。
         setAlpha:  设置Alpha值
         setTextSize: 设置字体尺寸。
         setStyle:  设置画笔风格，空心或者实心。
         setStrokeWidth: 设置空心的边框宽度。
         getColor:  得到画笔的颜色
         getAlpha:  得到画笔的Alpha值。
         */
        //画笔
        mPaint = new Paint();
        //是否设置抗锯齿效果
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0xFF412129);
        mPaint.setTextSize((float) 2.0);
        mPath = new Path();
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        this.screenWidth=wm.getDefaultDisplay().getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
//        mPath.moveTo(0,90);
//        //mPath.lineTo(0,0);
//        mPath.lineTo(100,50);
//        mPath.lineTo(100*2,90);
//        mPath.lineTo(100*3,50);
//        mPath.lineTo(100*4,90);
//        mPath.lineTo(100*5,50);

        mPath.moveTo(first_x,first_y);
        //mPath.lineTo(50,10);
        //屏幕宽度除以角的宽度
        int size=screenWidth%horn_size==0?screenWidth/horn_size:screenWidth/horn_size+1;
        //画多少个
        for (int i=1;i<=size;i++){
            //y前一个大角后一个小
            mPath.lineTo((i*horn_size)+first_x,i%2==0?first_y:minimum_distance);
        }
        canvas.drawPath(mPath, mPaint);
    }
}
