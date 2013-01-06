package com.fracionlabs.testapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.webkit.WebSettings.TextSize;

public class MyBringBack extends View {

	Bitmap star;
	float y;
	Typeface font;

	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		star = BitmapFactory.decodeResource(getResources(),
				R.drawable.myicselect);
		y = 0;
		font = Typeface.createFromAsset(context.getAssets(), "cour.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.BLACK);
		
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 254, 100, 45);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);
		canvas.drawText("Ajith is ..", canvas.getWidth()/2, 200	, textPaint);
		
		
		canvas.drawBitmap(star, (canvas.getWidth() / 2), y, null);
		if (y < canvas.getHeight()) {
			y += 10;
		}else{
			y=0;
		}
		Rect middlRect = new Rect();
		middlRect.set(0, 400, canvas.getWidth(),550);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middlRect, ourBlue);
		invalidate();
	}

}
