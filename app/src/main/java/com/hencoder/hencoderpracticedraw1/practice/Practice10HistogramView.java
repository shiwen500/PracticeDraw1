package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice10HistogramView extends View {

    public static final class DataItem {
        public String label;
        public float value;
        public static DataItem newItem(String l, float v) {
            DataItem item = new DataItem();
            item.label = l;
            item.value = v;
            return item;
        }
    }

    private DataItem[] items;
    private Paint paint = new Paint();
    private Paint cPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice10HistogramView(Context context) {
        super(context);
        initData();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        items = new DataItem[]{
                DataItem.newItem("Froyo", 1),
                DataItem.newItem("JK", 20),
                DataItem.newItem("LJKKJ", 100),
                DataItem.newItem("Seven", 300),
                DataItem.newItem("Zahgn", 500),
                DataItem.newItem("Chenj", 700)
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        float baseX = 100;
        float baseY = getMeasuredHeight() - 100; // 左下角为原点
        // 绘制坐标轴
        paint.setStrokeWidth(2);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        Path axis = new Path();
        axis.moveTo(100, 100);
        axis.lineTo(baseX, baseY);
        axis.lineTo(getMeasuredWidth() - 100, baseY);
        canvas.drawPath(axis, paint);
        // 绘制x坐标文字,柱子
        cPaint.setColor(Color.GREEN);
        paint.setTextSize(30);
        float horizontalMargin = 10; // 柱子之间的距离
        float columnWidth = 100; // 柱子的宽度
        cPaint.setStrokeWidth(columnWidth);
        Rect bounds = new Rect();
        for (int i = 0; i < items.length; i++) {
            DataItem item = items[i];
            paint.getTextBounds(item.label, 0, item.label.length(), bounds);
            float x = baseX + horizontalMargin * (i+1) + columnWidth * (i + 0.5f);
            canvas.drawText(
                    item.label,
                    x - bounds.width()/2.0f,
                    baseY + 40,
                    paint
            );
            canvas.drawLine(
                    x, baseY, x, baseY - item.value, cPaint
            );
        }
    }
}
