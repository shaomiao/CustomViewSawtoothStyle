package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shaomiao on 2016-10-14.
 */

public class BezierHeartView extends View {
    private int mMeasureWidth;
    private int mWidthMode;
    private int mMeasureHeight;
    private int mHeightMode;
    private Paint paint;
    private int heartColor;
    public BezierHeartView(Context context) {
        super(context);
    }

    public BezierHeartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BezierHeartView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public BezierHeartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        mHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeight = MeasureSpec.getSize(heightMeasureSpec);
        if(mWidthMode == MeasureSpec.AT_MOST && mHeightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(200,200);
        }else if(mWidthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(200,mMeasureHeight);
        }else if(mHeightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(mMeasureWidth,200);
        }else{
            setMeasuredDimension(mMeasureWidth,mMeasureHeight);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setStrokeWidth(6);
        paint.setAntiAlias(true);
        paint.setColor(heartColor);
        int width = getWidth();
        int height = getHeight();

        // 绘制心形
        Path path = new Path();
        path.moveTo(width/2,height/4);
        path.cubicTo((width*6)/7,height/9,(width*12)/13,(height*2)/5,width/2,(height*7)/12);
        canvas.drawPath(path,paint);

        Path path2 = new Path();
        path2.moveTo(width/2,height/4);
        path2.cubicTo(width / 7, height / 9, width / 13, (height * 2) / 5, width / 2, (height * 7) / 12);
        canvas.drawPath(path2,paint);

    }
}
