package com.mm.renrenhua.custom.demo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/**
 * @ 作 用：
 * @ 作 者：szc
 * @ 时 间：2017/8/25 10:19
 */

public class IndexView extends View {
    private static Paint paint = new Paint();
    private static final String TAG = "Index";
    private PopupWindow window;
    private String[] str = {
            "#", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    private String selectColor = "#fa7829";
    private String defColor = "#888888";
    private int selectPosition = -1;


    public IndexView(Context context) {
        this(context, null);

    }

    public IndexView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndexView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        float height = getHeight();
        //个数
        int size = str.length + 1;
        //获取每个字符的高度
        float singleHeight = height / size;

        Log.i(TAG, "height:" + height + "singleHeight:" + singleHeight + "size:" + size);
        //初始化笔
        paint.setColor(Color.parseColor(selectPosition != -1 ? selectColor : defColor));
        paint.setStyle(Paint.Style.FILL);//填充
        canvas.drawCircle(width / 2, singleHeight / 2, singleHeight / 4, paint);//画圆点
        canvas.drawLine(0, singleHeight, width, singleHeight, paint);
        paint.setAntiAlias(true);
        paint.setTextSize(22);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.DEFAULT_BOLD);//字体加粗
        float centerWidth = width / 2.0f;
        float centerHeight;
        Paint.FontMetrics fm = paint.getFontMetrics();

        float baseLine = (fm.bottom - fm.top) / 2 - fm.bottom;

        //画字
        for (int i = 0; i < str.length; i++) {
            paint.setColor(Color.parseColor(selectPosition == i ? selectColor : defColor));
            //中间线
            centerHeight = singleHeight / 2 + singleHeight * (i + 1) + baseLine;
            canvas.drawText(str[i], centerWidth, centerHeight, paint);
            canvas.drawLine(0, singleHeight * (i + 2), width, singleHeight * (i + 2), paint);
        }
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float y = event.getY();
        float height = getHeight() / (str.length + 1f);
        selectPosition = (int) (y / height) - 1;
        switch (event.getAction()) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                selectPosition = -1;
                break;
        }
        invalidate();
        return true;
    }
}
