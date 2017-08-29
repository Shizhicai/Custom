package com.mm.renrenhua.custom.demo3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @ 作 者：S Z C
 * @ 时 间：2017/8/29 23:37
 * @ 作 用：
 */

public class RippleView extends View {

    private Paint mPaint;
    private int originY = 300;
    private int waveLenth = 300;
    private Path mPath;

    public RippleView(Context context) {
        super(context);
    }

    public RippleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RippleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setColor(Color.RED);
            mPaint.setAntiAlias(true);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setStrokeWidth(22);
        }

        if (mPath == null)
            mPath = new Path();
        mPath.reset();

        int halfWaveLenth = (int) (waveLenth / 2);
        mPath.moveTo(-waveLenth, originY);

        for (int i = -waveLenth; i < getWidth() + waveLenth; i += waveLenth) {
            mPath.rQuadTo((float) (halfWaveLenth / 2), 20, halfWaveLenth, 0);
            mPath.rQuadTo((float) (halfWaveLenth / 2), -20, halfWaveLenth, 0);
        }
        mPath.lineTo(getWidth(),getHeight());
        mPath.lineTo(0,getHeight());
        canvas.drawPath(mPath,mPaint);
    }
}
