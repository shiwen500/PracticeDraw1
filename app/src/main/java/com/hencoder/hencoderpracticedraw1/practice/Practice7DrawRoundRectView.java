package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {
    private Paint paint = new Paint();
    private RectF rectF0 = new RectF(100, 100, 500, 200);
    private RectF rectF1 = new RectF(100, 300, 500, 400);
    private RectF rectF2 = new RectF(100, 500, 500, 600);

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        canvas.drawRoundRect(rectF0, 0, 0, paint); // 无圆角
        canvas.drawRoundRect(rectF1, 20, 20, paint); // 规则圆角
        canvas.drawRoundRect(rectF2, 15, 30, paint); // 椭圆角
    }
}
