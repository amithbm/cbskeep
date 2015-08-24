package com.google.android.keep.filtershow.crop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;

public abstract class b
{
  public static void a(Canvas paramCanvas, Paint paramPaint, RectF paramRectF1, RectF paramRectF2)
  {
    paramCanvas.drawRect(paramRectF2.left, paramRectF2.top, paramRectF1.right, paramRectF1.top, paramPaint);
    paramCanvas.drawRect(paramRectF1.right, paramRectF2.top, paramRectF2.right, paramRectF1.bottom, paramPaint);
    paramCanvas.drawRect(paramRectF1.left, paramRectF1.bottom, paramRectF2.right, paramRectF2.bottom, paramPaint);
    paramCanvas.drawRect(paramRectF2.left, paramRectF1.top, paramRectF1.left, paramRectF2.bottom, paramPaint);
  }

  public static void a(Canvas paramCanvas, RectF paramRectF)
  {
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(Color.argb(128, 255, 255, 255));
    localPaint.setStrokeWidth(2.0F);
    float f4 = paramRectF.width() / 3.0F;
    float f3 = paramRectF.height() / 3.0F;
    float f1 = paramRectF.left + f4;
    float f2 = paramRectF.top + f3;
    int i = 0;
    while (i < 2)
    {
      paramCanvas.drawLine(f1, paramRectF.top, f1, paramRectF.bottom, localPaint);
      f1 += f4;
      i += 1;
    }
    i = 0;
    f1 = f2;
    while (i < 2)
    {
      paramCanvas.drawLine(paramRectF.left, f1, paramRectF.right, f1, localPaint);
      f1 += f3;
      i += 1;
    }
  }

  public static void a(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, Paint paramPaint1, Paint paramPaint2)
  {
    paramFloat1 = paramRectF.width() * paramFloat1;
    paramFloat2 = paramRectF.height() * paramFloat2;
    float f1 = paramRectF.centerX();
    float f2 = paramRectF.centerY();
    RectF localRectF1 = new RectF(f1 - paramFloat1 / 2.0F, f2 - paramFloat2 / 2.0F, paramFloat1 / 2.0F + f1, paramFloat2 / 2.0F + f2);
    RectF localRectF2 = new RectF(f1 - paramFloat2 / 2.0F, f2 - paramFloat1 / 2.0F, paramFloat2 / 2.0F + f1, paramFloat1 / 2.0F + f2);
    paramCanvas.save();
    paramCanvas.clipRect(paramRectF);
    paramCanvas.clipRect(localRectF1, Region.Op.DIFFERENCE);
    paramCanvas.clipRect(localRectF2, Region.Op.DIFFERENCE);
    paramCanvas.drawPaint(paramPaint2);
    paramCanvas.restore();
    paramRectF = new Path();
    paramRectF.moveTo(localRectF1.left, localRectF1.top);
    paramRectF.lineTo(localRectF1.right, localRectF1.top);
    paramRectF.moveTo(localRectF1.left, localRectF1.top);
    paramRectF.lineTo(localRectF1.left, localRectF1.bottom);
    paramRectF.moveTo(localRectF1.left, localRectF1.bottom);
    paramRectF.lineTo(localRectF1.right, localRectF1.bottom);
    paramRectF.moveTo(localRectF1.right, localRectF1.top);
    paramRectF.lineTo(localRectF1.right, localRectF1.bottom);
    paramRectF.moveTo(localRectF2.left, localRectF2.top);
    paramRectF.lineTo(localRectF2.right, localRectF2.top);
    paramRectF.moveTo(localRectF2.right, localRectF2.top);
    paramRectF.lineTo(localRectF2.right, localRectF2.bottom);
    paramRectF.moveTo(localRectF2.left, localRectF2.bottom);
    paramRectF.lineTo(localRectF2.right, localRectF2.bottom);
    paramRectF.moveTo(localRectF2.left, localRectF2.top);
    paramRectF.lineTo(localRectF2.left, localRectF2.bottom);
    paramCanvas.drawPath(paramRectF, paramPaint1);
  }

  public static void a(Canvas paramCanvas, Drawable paramDrawable, int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = (int)paramFloat1 - paramInt / 2;
    int j = (int)paramFloat2 - paramInt / 2;
    paramDrawable.setBounds(i, j, i + paramInt, j + paramInt);
    paramDrawable.draw(paramCanvas);
  }

  public static void a(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, RectF paramRectF, boolean paramBoolean, int paramInt2)
  {
    int i;
    if (paramInt2 == 0)
    {
      i = 1;
      if (!paramBoolean)
        break label123;
      if ((paramInt2 == 3) || (i != 0))
        a(paramCanvas, paramDrawable, paramInt1, paramRectF.left, paramRectF.top);
      if ((paramInt2 == 6) || (i != 0))
        a(paramCanvas, paramDrawable, paramInt1, paramRectF.right, paramRectF.top);
      if ((paramInt2 == 9) || (i != 0))
        a(paramCanvas, paramDrawable, paramInt1, paramRectF.left, paramRectF.bottom);
      if ((paramInt2 == 12) || (i != 0))
        a(paramCanvas, paramDrawable, paramInt1, paramRectF.right, paramRectF.bottom);
    }
    label123: 
    do
    {
      return;
      i = 0;
      break;
      if (((paramInt2 & 0x2) != 0) || (i != 0))
        a(paramCanvas, paramDrawable, paramInt1, paramRectF.centerX(), paramRectF.top);
      if (((paramInt2 & 0x8) != 0) || (i != 0))
        a(paramCanvas, paramDrawable, paramInt1, paramRectF.centerX(), paramRectF.bottom);
      if (((paramInt2 & 0x1) != 0) || (i != 0))
        a(paramCanvas, paramDrawable, paramInt1, paramRectF.left, paramRectF.centerY());
    }
    while (((paramInt2 & 0x4) == 0) && (i == 0));
    a(paramCanvas, paramDrawable, paramInt1, paramRectF.right, paramRectF.centerY());
  }

  public static boolean a(Matrix paramMatrix, RectF paramRectF1, RectF paramRectF2, int paramInt)
  {
    RectF localRectF = new RectF();
    paramMatrix.setRotate(paramInt, paramRectF1.centerX(), paramRectF1.centerY());
    if (!paramMatrix.mapRect(localRectF, paramRectF1));
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = paramMatrix.setRectToRect(localRectF, paramRectF2, Matrix.ScaleToFit.CENTER);
      bool2 = paramMatrix.preRotate(paramInt, paramRectF1.centerX(), paramRectF1.centerY());
    }
    while ((!bool1) || (!bool2));
    return true;
  }

  public static void b(Canvas paramCanvas, RectF paramRectF)
  {
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(-1);
    localPaint.setStrokeWidth(3.0F);
    paramCanvas.drawRect(paramRectF, localPaint);
  }
}