# Custom
自定义控件DEMO

- 鱼眼索引控件

- 文字图片居中

- 水波纹View

# 笔记
paint中基本设置的函数：

* reset()

    重置画笔
* setColor(int color)

    给画笔设置颜色值
* setARGB(int a, int r, int g, int b)

    同样是设置颜色，但是利用ARGB分开设置
* setAlpha(int a)

    设置画笔透明度
* setStyle(Paint.Style style)

    设置画笔样式，取值有

        Paint.Style.FILL :填充内部
        Paint.Style.FILL_AND_STROKE ：填充内部和描边
        Paint.Style.STROKE ：仅描边

* setStrokeWidth(float width)

    设置画笔宽度
* setAntiAlias(boolean aa)

    设置画笔是否抗锯齿
* setStrokeCap(Paint.Cap cap)

    设置线冒样式，取值有

        Cap.ROUND(圆形线冒)
        Cap.SQUARE(方形线冒)
        Cap.BUTT(无线冒)
* setStrokeJoin(Paint.Join join)

    设置线段连接处样式，取值有：

        Join.MITER（结合处为锐角）
        Join.Round(结合处为圆弧)
        Join.BEVEL(结合处为直线)

* setStrokeMiter(float miter)

设置笔画的倾斜度，90度拿画笔与30拿画笔，画出来的线条样式肯定是不一样的吧。
* setPathEffect(PathEffect effect)

    设置路径样式;取值类型是所有派生自PathEffect的子类：

        ComposePathEffect
        CornerPathEffect
        DashPathEffect
        DiscretePathEffect
        PathDashPathEffect
        SumPathEffect

