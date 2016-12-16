package com.maedi.user.godok.v1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RoundRectangleImageView extends BaseImageView {
	
	private static Context mcontext;
	
    public RoundRectangleImageView(Context context) {    	
        super(context);
        setContextActivity(context);
    }

    public RoundRectangleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setContextActivity(context);
    }

    public RoundRectangleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setContextActivity(context);
    }

    public static Bitmap getBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        RectF rect = new RectF(0.0f, 0.0f, width, height);
        canvas.drawRoundRect(rect, 5, 5, paint);
        return bitmap;
    }

    @Override
    public Bitmap getBitmap() {
        return getBitmap(getWidth(), getHeight());
    }

	public static Context getContextActivity() {
		return mcontext;
	}

	public static void setContextActivity(Context context) {
		mcontext = context;
	}
}
