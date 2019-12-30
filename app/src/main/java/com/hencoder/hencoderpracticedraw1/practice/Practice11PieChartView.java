package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

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
    private int selectIndex = 4;

    int[] colors = new int[]{Color.RED, Color.BLUE, Color.GREEN};

    public Practice11PieChartView(Context context) {
        super(context);
        initData();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        items = new DataItem[]{
                DataItem.newItem("Froyo", 10),
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

        float totalValue = 0;
        for (DataItem item: items) {
            totalValue += item.value;
        }

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        float radius = getMeasuredHeight() * 0.33f;
        float centerX = getMeasuredWidth() / 2.0f;
        float centerY = getMeasuredHeight() / 2.0f;

        RectF oval = new RectF(centerX-radius, centerY-radius, centerX+radius, centerY+radius);
        float startAngle = 0f;
        for (int i = 0; i < items.length; i++) {
            int color = colors[i%colors.length];
            paint.setColor(color);
            float sweepAngle = items[i].value/totalValue * 360f;
            if (i == selectIndex) {
                canvas.save();
                float translateAngle = startAngle + sweepAngle/2;
                double dy = Math.sin(translateAngle/360f * 2 * Math.PI) * 20;
                double dx = Math.cos(translateAngle/360f * 2 * Math.PI) * 20;
                canvas.translate((float) dx, (float) dy);
                canvas.drawArc(oval, startAngle, sweepAngle, true, paint);
                canvas.restore();
            } else {
                canvas.drawArc(oval, startAngle, sweepAngle, true, paint);
            }
            startAngle += sweepAngle;
        }
    }
}
