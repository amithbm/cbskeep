package com.google.android.keep.filtershow.crop;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.google.android.keep.i;
import java.util.Arrays;

public class a
{
  private float pK;
  private RectF pL;
  private RectF pM;
  private float[] pN;

  public a(float paramFloat, RectF paramRectF1, RectF paramRectF2)
  {
    pK = paramFloat;
    pL = new RectF(paramRectF1);
    pM = new RectF(paramRectF2);
    pN = d.f(pM);
    fh();
    if (!ff())
      fg();
  }

  private boolean ff()
  {
    int i = 0;
    while (i < 8)
    {
      if (!d.a(pL, pN[i], pN[(i + 1)]))
        return false;
      i += 2;
    }
    return true;
  }

  private void fg()
  {
    d.a(pL, pN);
    Matrix localMatrix = fi();
    float[] arrayOfFloat = Arrays.copyOf(pN, 8);
    localMatrix.mapPoints(arrayOfFloat);
    pM = d.a(arrayOfFloat);
  }

  private void fh()
  {
    fj().mapPoints(pN);
  }

  private Matrix fi()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(pK, pL.centerX(), pL.centerY());
    return localMatrix;
  }

  private Matrix fj()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-pK, pL.centerX(), pL.centerY());
    return localMatrix;
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    Object localObject2 = fj();
    Object localObject1 = new RectF(pM);
    ((RectF)localObject1).offset(paramFloat1, paramFloat2);
    localObject1 = d.f((RectF)localObject1);
    float[] arrayOfFloat1 = d.f(pL);
    ((Matrix)localObject2).mapPoints((float[])localObject1);
    localObject2 = new float[2];
    Object tmp56_54 = localObject2;
    tmp56_54[0] = 0.0F;
    Object tmp60_56 = tmp56_54;
    tmp60_56[1] = 0.0F;
    tmp60_56;
    int i = 0;
    while (i < localObject1.length)
    {
      paramFloat1 = localObject1[i] + localObject2[0];
      paramFloat2 = localObject1[(i + 1)] + localObject2[1];
      if (!d.a(pL, paramFloat1, paramFloat2))
      {
        float[] arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = paramFloat1;
        arrayOfFloat2[1] = paramFloat2;
        arrayOfFloat2 = i.c(arrayOfFloat2, d.a(arrayOfFloat2, arrayOfFloat1));
        localObject2[0] += arrayOfFloat2[0];
        localObject2[1] += arrayOfFloat2[1];
      }
      i += 2;
    }
    i = 0;
    while (i < localObject1.length)
    {
      paramFloat1 = localObject1[i] + localObject2[0];
      paramFloat2 = localObject1[(i + 1)] + localObject2[1];
      if (!d.a(pL, paramFloat1, paramFloat2))
      {
        arrayOfFloat1 = new float[2];
        arrayOfFloat1[0] = paramFloat1;
        arrayOfFloat1[1] = paramFloat2;
        d.a(pL, arrayOfFloat1);
        arrayOfFloat1[0] -= paramFloat1;
        arrayOfFloat1[1] -= paramFloat2;
        localObject2[0] += arrayOfFloat1[0];
        localObject2[1] += arrayOfFloat1[1];
      }
      i += 2;
    }
    i = 0;
    while (i < localObject1.length)
    {
      paramFloat1 = localObject1[i];
      paramFloat2 = localObject2[0];
      float f1 = localObject1[(i + 1)];
      float f2 = localObject2[1];
      localObject1[i] = (paramFloat1 + paramFloat2);
      localObject1[(i + 1)] = (f1 + f2);
      i += 2;
    }
    pN = ((float[])localObject1);
    fg();
  }

  public void a(float paramFloat, RectF paramRectF1, RectF paramRectF2)
  {
    pK = paramFloat;
    pL.set(paramRectF1);
    pM.set(paramRectF2);
    pN = d.f(pM);
    fh();
    if (!ff())
      fg();
  }

  public void a(RectF paramRectF)
  {
    if (pM.equals(paramRectF));
    do
    {
      return;
      pM = paramRectF;
      pN = d.f(pM);
      fh();
    }
    while (ff());
    fg();
  }

  public void b(RectF paramRectF)
  {
    paramRectF.set(pM);
  }

  public void c(RectF paramRectF)
  {
    Object localObject = fi();
    Matrix localMatrix = fj();
    float[] arrayOfFloat1 = d.f(pL);
    ((Matrix)localObject).mapPoints(arrayOfFloat1);
    float[] arrayOfFloat2 = d.f(pM);
    float[] arrayOfFloat3 = d.f(paramRectF);
    RectF localRectF = new RectF(paramRectF);
    int i = 0;
    while (i < arrayOfFloat3.length)
    {
      paramRectF = new float[2];
      paramRectF[0] = arrayOfFloat3[i];
      paramRectF[1] = arrayOfFloat3[(i + 1)];
      localObject = Arrays.copyOf(paramRectF, 2);
      localMatrix.mapPoints((float[])localObject);
      if (!d.a(pL, localObject[0], localObject[1]))
      {
        paramRectF = d.a(paramRectF, arrayOfFloat1);
        localObject = i.b(new float[] { arrayOfFloat3[i], arrayOfFloat3[(i + 1)], arrayOfFloat2[i], arrayOfFloat2[(i + 1)] }, paramRectF);
        paramRectF = (RectF)localObject;
        if (localObject == null)
        {
          paramRectF = new float[2];
          paramRectF[0] = arrayOfFloat2[i];
          paramRectF[1] = arrayOfFloat2[(i + 1)];
        }
      }
      float f;
      switch (i)
      {
      default:
        i += 2;
        break;
      case 0:
      case 1:
        if (paramRectF[0] > localRectF.left)
        {
          f = paramRectF[0];
          localRectF.left = f;
          if (paramRectF[1] <= localRectF.top)
            break label299;
        }
        for (f = paramRectF[1]; ; f = localRectF.top)
        {
          localRectF.top = f;
          break;
          f = localRectF.left;
          break label259;
        }
      case 2:
      case 3:
        if (paramRectF[0] < localRectF.right)
        {
          f = paramRectF[0];
          localRectF.right = f;
          if (paramRectF[1] <= localRectF.top)
            break label364;
        }
        for (f = paramRectF[1]; ; f = localRectF.top)
        {
          localRectF.top = f;
          break;
          f = localRectF.right;
          break label324;
        }
      case 4:
      case 5:
        if (paramRectF[0] < localRectF.right)
        {
          f = paramRectF[0];
          localRectF.right = f;
          if (paramRectF[1] >= localRectF.bottom)
            break label429;
        }
        for (f = paramRectF[1]; ; f = localRectF.bottom)
        {
          localRectF.bottom = f;
          break;
          f = localRectF.right;
          break label389;
        }
      case 6:
      case 7:
        label259: label299: label324: label364: if (paramRectF[0] > localRectF.left)
        {
          f = paramRectF[0];
          localRectF.left = f;
          if (paramRectF[1] >= localRectF.bottom)
            break label494;
        }
        label389: label429: label454: label494: for (f = paramRectF[1]; ; f = localRectF.bottom)
        {
          localRectF.bottom = f;
          break;
          f = localRectF.left;
          break label454;
        }
      }
    }
    paramRectF = d.f(localRectF);
    localMatrix.mapPoints(paramRectF);
    pN = paramRectF;
    fg();
  }

  public void d(RectF paramRectF)
  {
    Object localObject = fi();
    Matrix localMatrix = fj();
    float f4 = pM.width() / pM.height();
    float[] arrayOfFloat1 = d.f(pL);
    ((Matrix)localObject).mapPoints(arrayOfFloat1);
    float[] arrayOfFloat2 = d.f(pM);
    float[] arrayOfFloat3 = d.f(paramRectF);
    int j = -1;
    int i;
    if (pM.top == paramRectF.top)
      if (pM.left == paramRectF.left)
        i = 0;
    while (i == -1)
    {
      return;
      i = j;
      if (pM.right == paramRectF.right)
      {
        i = 2;
        continue;
        i = j;
        if (pM.bottom == paramRectF.bottom)
          if (pM.right == paramRectF.right)
          {
            i = 4;
          }
          else
          {
            i = j;
            if (pM.left == paramRectF.left)
              i = 6;
          }
      }
    }
    float f1 = paramRectF.width();
    j = 0;
    if (j < arrayOfFloat3.length)
    {
      paramRectF = new float[2];
      paramRectF[0] = arrayOfFloat3[j];
      paramRectF[1] = arrayOfFloat3[(j + 1)];
      localObject = Arrays.copyOf(paramRectF, 2);
      localMatrix.mapPoints((float[])localObject);
      f2 = f1;
      if (!d.a(pL, localObject[0], localObject[1]))
      {
        if (j != i)
          break label286;
        f2 = f1;
      }
      while (true)
      {
        j += 2;
        f1 = f2;
        break;
        label286: paramRectF = d.a(paramRectF, arrayOfFloat1);
        localObject = i.b(new float[] { arrayOfFloat3[j], arrayOfFloat3[(j + 1)], arrayOfFloat2[j], arrayOfFloat2[(j + 1)] }, paramRectF);
        paramRectF = (RectF)localObject;
        if (localObject == null)
        {
          paramRectF = new float[2];
          paramRectF[0] = arrayOfFloat2[j];
          paramRectF[1] = arrayOfFloat2[(j + 1)];
        }
        f2 = arrayOfFloat2[i];
        float f3 = arrayOfFloat2[(i + 1)];
        f3 = Math.max(Math.abs(f2 - paramRectF[0]), f4 * Math.abs(f3 - paramRectF[1]));
        f2 = f1;
        if (f3 < f1)
          f2 = f3;
      }
    }
    float f2 = f1 / f4;
    paramRectF = new RectF(pM);
    if (i == 0)
    {
      paramRectF.right = (paramRectF.left + f1);
      paramRectF.bottom = (paramRectF.top + f2);
    }
    while (true)
    {
      paramRectF = d.f(paramRectF);
      localMatrix.mapPoints(paramRectF);
      pN = paramRectF;
      fg();
      return;
      if (i == 2)
      {
        paramRectF.left = (paramRectF.right - f1);
        paramRectF.bottom = (paramRectF.top + f2);
      }
      else if (i == 4)
      {
        paramRectF.left = (paramRectF.right - f1);
        paramRectF.top = (paramRectF.bottom - f2);
      }
      else if (i == 6)
      {
        paramRectF.right = (paramRectF.left + f1);
        paramRectF.top = (paramRectF.bottom - f2);
      }
    }
  }

  public RectF fd()
  {
    return new RectF(pM);
  }

  public RectF fe()
  {
    return new RectF(pL);
  }
}