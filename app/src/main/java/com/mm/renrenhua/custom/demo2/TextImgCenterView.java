package com.mm.renrenhua.custom.demo2;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * @ 作 者：S Z C
 * @ 时 间：2017/8/26 9:37
 * @ 作 用：
 */

public class TextImgCenterView extends AppCompatTextView {

    public TextImgCenterView(Context context) {
        this(context, null);
    }

    public TextImgCenterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextImgCenterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            Drawable left = drawables[0];
            float textWidth = getPaint().measureText(getText().toString());
            setGravity(Gravity.CENTER_VERTICAL);
            if (left != null){
                //实际长度
                float contextWidth = textWidth + getCompoundDrawablePadding() + left.getIntrinsicWidth();
                //偏移距离
                float translateWidth = (getWidth() - contextWidth) / 2;
                canvas.translate(translateWidth,0);
            }

        }
        super.onDraw(canvas);
    }
}
