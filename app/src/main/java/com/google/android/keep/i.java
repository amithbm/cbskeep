package com.google.android.keep;

public final class i
{
  public static float[] b(float[] paramArrayOfFloat)
  {
    float f = (float)Math.sqrt(paramArrayOfFloat[0] * paramArrayOfFloat[0] + paramArrayOfFloat[1] * paramArrayOfFloat[1]);
    return new float[] { paramArrayOfFloat[0] / f, paramArrayOfFloat[1] / f };
  }

  public static float[] b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f5 = paramArrayOfFloat1[0];
    float f6 = paramArrayOfFloat1[1];
    float f1 = paramArrayOfFloat1[2];
    float f2 = paramArrayOfFloat1[3];
    float f8 = paramArrayOfFloat2[0];
    float f7 = paramArrayOfFloat2[1];
    float f3 = paramArrayOfFloat2[2];
    float f4 = paramArrayOfFloat2[3];
    f5 -= f1;
    f6 -= f2;
    f8 -= f3;
    f7 -= f4;
    float f9 = f6 * f8 - f5 * f7;
    if (f9 == 0.0F)
      return null;
    f3 = ((f4 - f2) * f8 + f7 * (f1 - f3)) / f9;
    return new float[] { f3 * f5 + f1, f3 * f6 + f2 };
  }

  public static float c(float[] paramArrayOfFloat)
  {
    return (float)Math.sqrt(paramArrayOfFloat[0] * paramArrayOfFloat[0] + paramArrayOfFloat[1] * paramArrayOfFloat[1]);
  }

  public static float[] c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat2[0];
    float f2 = paramArrayOfFloat2[2];
    float f3 = paramArrayOfFloat2[1];
    float f4 = paramArrayOfFloat2[3];
    float f5 = f2 - f1;
    float f6 = f4 - f3;
    if ((f5 == 0.0F) && (f6 == 0.0F))
      return null;
    f5 = ((paramArrayOfFloat1[0] - f1) * f5 + (paramArrayOfFloat1[1] - f3) * f6) / (f5 * f5 + f6 * f6);
    paramArrayOfFloat2 = new float[2];
    paramArrayOfFloat2[0] = ((f2 - f1) * f5 + f1);
    paramArrayOfFloat2[1] = ((f4 - f3) * f5 + f3);
    return new float[] { paramArrayOfFloat2[0] - paramArrayOfFloat1[0], paramArrayOfFloat2[1] - paramArrayOfFloat1[1] };
  }

  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(Math.min(paramFloat1, paramFloat3), paramFloat2);
  }

  public static float d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[1];
  }

  public static float e(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f = (float)Math.sqrt(paramArrayOfFloat2[0] * paramArrayOfFloat2[0] + paramArrayOfFloat2[1] * paramArrayOfFloat2[1]);
    return d(paramArrayOfFloat1, paramArrayOfFloat2) / f;
  }
}