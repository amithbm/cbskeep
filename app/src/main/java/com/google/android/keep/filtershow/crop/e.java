package com.google.android.keep.filtershow.crop;

import android.graphics.RectF;
import com.google.android.keep.i;

public class e
{
  private float mRotation = 0.0F;
  private int qA = 0;
  private a qu;
  private float qv = 1.0F;
  private float qw = 1.0F;
  private boolean qx = false;
  private float qy = 45.0F;
  private float qz = 20.0F;

  public e(RectF paramRectF1, RectF paramRectF2, int paramInt)
  {
    qu = new a(paramInt % 360, paramRectF1, paramRectF2);
  }

  private static RectF a(RectF paramRectF, int paramInt, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = null;
    if (paramInt == 12)
      localRectF = new RectF(left, top, left + paramRectF.width() + paramFloat1, top + paramRectF.height() + paramFloat2);
    do
    {
      return localRectF;
      if (paramInt == 9)
        return new RectF(right - paramRectF.width() + paramFloat1, top, right, top + paramRectF.height() + paramFloat2);
      if (paramInt == 3)
        return new RectF(right - paramRectF.width() + paramFloat1, bottom - paramRectF.height() + paramFloat2, right, bottom);
    }
    while (paramInt != 6);
    return new RectF(left, bottom - paramRectF.height() + paramFloat2, left + paramRectF.width() + paramFloat1, bottom);
  }

  public static boolean aC(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 6) || (paramInt == 12) || (paramInt == 9);
  }

  public static boolean aD(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 4) || (paramInt == 8);
  }

  public static boolean aE(int paramInt)
  {
    return paramInt == 16;
  }

  public static boolean aF(int paramInt)
  {
    return (paramInt == 0) || (aE(paramInt)) || (aD(paramInt)) || (aC(paramInt));
  }

  private static int aH(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 1)
      i = paramInt | 0x2;
    paramInt = i;
    if (i == 2)
      paramInt = i | 0x1;
    i = paramInt;
    if (paramInt == 4)
      i = paramInt | 0x8;
    paramInt = i;
    if (i == 8)
      paramInt = i | 0x4;
    return paramInt;
  }

  private int e(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = qu.fd();
    float f1 = Math.abs(paramFloat1 - localRectF.left);
    float f2 = Math.abs(paramFloat1 - localRectF.right);
    float f3 = Math.abs(paramFloat2 - localRectF.top);
    float f4 = Math.abs(paramFloat2 - localRectF.bottom);
    int j = 0;
    int i;
    if ((f1 <= qy) && (qy + paramFloat2 >= localRectF.top) && (paramFloat2 - qy <= localRectF.bottom) && (f1 < f2))
    {
      i = 0x0 | 0x1;
      if ((f3 > qy) || (qy + paramFloat1 < localRectF.left) || (paramFloat1 - qy > localRectF.right) || (f3 >= f4))
        break label227;
      j = i | 0x2;
    }
    label227: 
    do
    {
      do
      {
        do
        {
          return j;
          i = j;
          if (f2 > qy)
            break;
          i = j;
          if (qy + paramFloat2 < localRectF.top)
            break;
          i = j;
          if (paramFloat2 - qy > localRectF.bottom)
            break;
          i = 0x0 | 0x4;
          break;
          j = i;
        }
        while (f4 > qy);
        j = i;
      }
      while (qy + paramFloat1 < localRectF.left);
      j = i;
    }
    while (paramFloat1 - qy > localRectF.right);
    return i | 0x8;
  }

  public void a(RectF paramRectF1, RectF paramRectF2)
  {
    qu.a(0.0F, paramRectF2, paramRectF1);
  }

  public boolean aG(int paramInt)
  {
    if (!aF(paramInt))
      throw new IllegalArgumentException("bad edge selected");
    if ((qx) && (!aC(paramInt)) && (!aE(paramInt)) && (paramInt != 0))
      throw new IllegalArgumentException("bad corner selected");
    qA = paramInt;
    return true;
  }

  public boolean b(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F))
      throw new IllegalArgumentException("Width and Height must be greater than zero");
    RectF localRectF = qu.fd();
    d.b(localRectF, paramFloat1, paramFloat2);
    if ((localRectF.width() < qz) || (localRectF.height() < qz))
      return false;
    qv = paramFloat1;
    qw = paramFloat2;
    qx = true;
    qu.a(localRectF);
    fA();
    return true;
  }

  public void c(float paramFloat)
  {
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException("Tolerance must be greater than zero");
    qy = paramFloat;
  }

  public boolean c(float paramFloat1, float paramFloat2)
  {
    int j = e(paramFloat1, paramFloat2);
    int i = j;
    if (qx)
      i = aH(j);
    if (i == 0)
      return false;
    return aG(i);
  }

  public void d(float paramFloat)
  {
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException("Min dide must be greater than zero");
    qz = paramFloat;
  }

  public boolean d(float paramFloat1, float paramFloat2)
  {
    if (qA == 0)
      return false;
    RectF localRectF = qu.fd();
    float f3 = qz;
    int i = qA;
    if (i == 16)
    {
      qu.a(paramFloat1, paramFloat2);
      return true;
    }
    float f1 = 0.0F;
    float f2 = 0.0F;
    if ((i & 0x1) != 0)
      f1 = Math.min(localRectF.left + paramFloat1, localRectF.right - f3) - localRectF.left;
    if ((i & 0x2) != 0)
      f2 = Math.min(localRectF.top + paramFloat2, localRectF.bottom - f3) - localRectF.top;
    if ((i & 0x4) != 0)
      f1 = Math.max(localRectF.right + paramFloat1, localRectF.left + f3) - localRectF.right;
    if ((i & 0x8) != 0)
      f2 = Math.max(localRectF.bottom + paramFloat2, localRectF.top + f3) - localRectF.bottom;
    if (qx)
    {
      float[] arrayOfFloat1 = new float[2];
      arrayOfFloat1[0] = localRectF.left;
      arrayOfFloat1[1] = localRectF.bottom;
      float[] arrayOfFloat2 = new float[2];
      arrayOfFloat2[0] = localRectF.right;
      arrayOfFloat2[1] = localRectF.top;
      if ((i == 3) || (i == 12))
      {
        arrayOfFloat1[1] = localRectF.top;
        arrayOfFloat2[1] = localRectF.bottom;
      }
      arrayOfFloat1 = i.b(new float[] { arrayOfFloat1[0] - arrayOfFloat2[0], arrayOfFloat1[1] - arrayOfFloat2[1] });
      paramFloat1 = i.e(new float[] { f1, f2 }, arrayOfFloat1);
      localRectF = a(localRectF, i, paramFloat1 * arrayOfFloat1[0], paramFloat1 * arrayOfFloat1[1]);
      qu.d(localRectF);
    }
    while (true)
    {
      return true;
      if ((i & 0x1) != 0)
        localRectF.left += f1;
      if ((i & 0x2) != 0)
        localRectF.top += f2;
      if ((i & 0x4) != 0)
        localRectF.right += f1;
      if ((i & 0x8) != 0)
        localRectF.bottom += f2;
      qu.c(localRectF);
    }
  }

  public void fA()
  {
    qA = 0;
  }

  public RectF fx()
  {
    return qu.fd();
  }

  public RectF fy()
  {
    return qu.fe();
  }

  public boolean fz()
  {
    return qx;
  }

  public void g(RectF paramRectF)
  {
    qu.b(paramRectF);
  }

  public int getSelectState()
  {
    return qA;
  }
}