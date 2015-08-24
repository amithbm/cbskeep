package com.google.android.keep.filtershow.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.google.android.keep.i;

public class d
{
  public static int a(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }

  public static RectF a(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(paramRectF2, paramRectF3, Matrix.ScaleToFit.FILL);
    paramRectF2 = new RectF(paramRectF1);
    paramRectF1 = paramRectF2;
    if (!localMatrix.mapRect(paramRectF2))
      paramRectF1 = null;
    return paramRectF1;
  }

  public static RectF a(float[] paramArrayOfFloat)
  {
    RectF localRectF = new RectF((1.0F / 1.0F), (1.0F / 1.0F), (1.0F / -1.0F), (1.0F / -1.0F));
    int i = 1;
    if (i < paramArrayOfFloat.length)
    {
      float f2 = paramArrayOfFloat[(i - 1)];
      float f1 = paramArrayOfFloat[i];
      float f3;
      if (f2 < localRectF.left)
      {
        f3 = f2;
        label51: localRectF.left = f3;
        if (f1 >= localRectF.top)
          break label125;
        f3 = f1;
        label69: localRectF.top = f3;
        if (f2 <= localRectF.right)
          break label134;
        label85: localRectF.right = f2;
        if (f1 <= localRectF.bottom)
          break label143;
      }
      while (true)
      {
        localRectF.bottom = f1;
        i += 2;
        break;
        f3 = localRectF.left;
        break label51;
        label125: f3 = localRectF.top;
        break label69;
        label134: f2 = localRectF.right;
        break label85;
        label143: f1 = localRectF.bottom;
      }
    }
    localRectF.sort();
    return localRectF;
  }

  public static void a(RectF paramRectF, float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length < 2);
    while (true)
    {
      return;
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        paramArrayOfFloat[i] = i.clamp(paramArrayOfFloat[i], left, right);
        paramArrayOfFloat[(i + 1)] = i.clamp(paramArrayOfFloat[(i + 1)], top, bottom);
        i += 2;
      }
    }
  }

  public static boolean a(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 <= right) && (paramFloat1 >= left) && (paramFloat2 <= bottom) && (paramFloat2 >= top);
  }

  public static float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int j = paramArrayOfFloat2.length;
    float f1 = (1.0F / 1.0F);
    Object localObject = null;
    int i = 0;
    while (i < j)
    {
      float[] arrayOfFloat = new float[4];
      arrayOfFloat[0] = paramArrayOfFloat2[i];
      arrayOfFloat[1] = paramArrayOfFloat2[((i + 1) % j)];
      arrayOfFloat[2] = paramArrayOfFloat2[((i + 2) % j)];
      arrayOfFloat[3] = paramArrayOfFloat2[((i + 3) % j)];
      float f3 = i.c(i.c(paramArrayOfFloat1, arrayOfFloat));
      float f2 = f1;
      if (f3 < f1)
      {
        f2 = f3;
        localObject = arrayOfFloat;
      }
      i += 2;
      f1 = f2;
    }
    return localObject;
  }

  public static int b(float paramFloat)
  {
    int j = (int)(paramFloat % 360.0F / 90.0F);
    int i = j;
    if (j < 0)
      i = j + 4;
    return i * 90;
  }

  public static void b(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    float f1 = paramRectF.width();
    float f2 = paramRectF.height();
    float f3 = f1 / f2;
    paramFloat1 /= paramFloat2;
    if (f3 < paramFloat1)
    {
      paramFloat1 = f1 / paramFloat1;
      top = (paramRectF.centerY() - paramFloat1 / 2.0F);
      bottom = (top + paramFloat1);
      return;
    }
    paramFloat1 = f2 * paramFloat1;
    left = (paramRectF.centerX() - paramFloat1 / 2.0F);
    right = (left + paramFloat1);
  }

  public static float[] f(RectF paramRectF)
  {
    return new float[] { left, top, right, top, right, bottom, left, bottom };
  }
}