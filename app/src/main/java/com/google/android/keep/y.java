package com.google.android.keep;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;

public final class y
{
  private static final Matrix sT = new Matrix();
  private static final Paint sU = new Paint();
  private static final Paint sV = new Paint();

  public static void a(Bitmap paramBitmap, Canvas paramCanvas, RectF paramRectF1, RectF paramRectF2)
  {
    paramBitmap = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    sT.reset();
    sT.setRectToRect(paramRectF1, paramRectF2, Matrix.ScaleToFit.FILL);
    paramBitmap.setLocalMatrix(sT);
    sU.setAntiAlias(true);
    sU.setFilterBitmap(true);
    sU.setDither(true);
    sU.setShader(paramBitmap);
    paramCanvas.drawCircle(paramRectF2.centerX(), paramRectF2.centerX(), paramRectF2.width() / 2.0F, sU);
  }

  public static void a(Canvas paramCanvas, RectF paramRectF, int paramInt, float paramFloat)
  {
    sV.setColor(paramInt);
    sV.setStyle(Paint.Style.STROKE);
    sV.setStrokeWidth(paramFloat);
    sV.setAntiAlias(true);
    paramCanvas.drawCircle(paramRectF.centerX(), paramRectF.centerX(), paramRectF.width() / 2.0F - paramFloat / 2.0F, sV);
  }
}