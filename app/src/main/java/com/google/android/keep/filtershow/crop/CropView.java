package com.google.android.keep.filtershow.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CropView extends View
{
  private Bitmap mBitmap;
  private boolean mDirty = false;
  private final Paint mPaint = new Paint();
  private RectF qB = new RectF();
  private RectF qC = new RectF();
  private final RectF qD = new RectF();
  private final RectF qE = new RectF();
  private final Rect qF = new Rect();
  private NinePatchDrawable qG;
  private e qH = null;
  private Drawable qI;
  private int qJ;
  private boolean qK = false;
  private Matrix qL = null;
  private Matrix qM = null;
  private float qN = 0.0F;
  private float qO = 0.0F;
  private float qP = 0.0F;
  private float qQ = 0.0F;
  private boolean qR = false;
  private int qS = 15;
  private int qT = 32;
  private int qU = -822083584;
  private int qV = 1593835520;
  private int qW = 2147483647;
  private int qX = 90;
  private int qY = 40;
  private float qZ = 20.0F;
  private int qj = 0;
  private float ra = 10.0F;
  private Mode rb = Mode.rc;

  public CropView(Context paramContext)
  {
    super(paramContext);
    k(paramContext);
  }

  public CropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    k(paramContext);
  }

  public CropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k(paramContext);
  }

  private int a(int paramInt, float paramFloat)
  {
    switch (d.b(paramFloat))
    {
    default:
      return paramInt;
    case 90:
      return d(paramInt, 1, 4);
    case 180:
      return d(paramInt, 2, 4);
    case 270:
    }
    return d(paramInt, 3, 4);
  }

  private int d(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (1 << paramInt3) - 1;
    int j = paramInt1 & i;
    paramInt2 %= paramInt3;
    return paramInt1 & (i ^ 0xFFFFFFFF) | j << paramInt2 & i | j >> paramInt3 - paramInt2;
  }

  private void fD()
  {
    qL = null;
    qM = null;
    invalidate();
  }

  private void k(Context paramContext)
  {
    paramContext = paramContext.getResources();
    qG = ((NinePatchDrawable)paramContext.getDrawable(2130837632));
    qI = paramContext.getDrawable(2130837573);
    qJ = ((int)paramContext.getDimension(2131427575));
    qS = ((int)paramContext.getDimension(2131427494));
    qT = ((int)paramContext.getDimension(2131427493));
    qX = ((int)paramContext.getDimension(2131427495));
    qY = ((int)paramContext.getDimension(2131427496));
    qU = paramContext.getColor(2131296413);
    qV = paramContext.getColor(2131296414);
    qW = paramContext.getColor(2131296415);
    qZ = paramContext.getDimension(2131427497);
    ra = paramContext.getDimension(2131427498);
  }

  private void reset()
  {
    Log.w("CropView", "crop reset called");
    rb = Mode.rc;
    qH = null;
    qj = 0;
    qK = false;
    fD();
  }

  public void a(Bitmap paramBitmap, RectF paramRectF1, RectF paramRectF2, int paramInt)
  {
    mBitmap = paramBitmap;
    if (qH != null)
    {
      paramBitmap = qH.fx();
      RectF localRectF = qH.fy();
      if ((paramBitmap != paramRectF1) || (localRectF != paramRectF2) || (qj != paramInt))
      {
        qj = paramInt;
        qH.a(paramRectF1, paramRectF2);
        fD();
      }
      return;
    }
    qj = paramInt;
    qH = new e(paramRectF2, paramRectF1, 0);
    fD();
  }

  public void f(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F))
      throw new IllegalArgumentException("Bad arguments to applyAspect");
    if (qj < 0);
    for (int i = -qj; ; i = qj)
    {
      float f2 = paramFloat1;
      float f1 = paramFloat2;
      if (i % 180 == 90)
      {
        f1 = paramFloat1;
        f2 = paramFloat2;
      }
      if (!qH.b(f2, f1))
        Log.w("CropView", "failed to set aspect ratio");
      invalidate();
      return;
    }
  }

  public RectF fB()
  {
    return qH.fx();
  }

  public RectF fC()
  {
    return qH.fy();
  }

  protected void fE()
  {
    mDirty = true;
  }

  public void onDraw(Canvas paramCanvas)
  {
    if (mBitmap == null);
    do
    {
      return;
      if (mDirty)
      {
        mDirty = false;
        fD();
      }
      qB = new RectF(0.0F, 0.0F, mBitmap.getWidth(), mBitmap.getHeight());
      qC = new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      qC.inset(qT, qT);
      if (qH == null)
      {
        reset();
        qH = new e(qB, qB, 0);
      }
      if ((qL == null) || (qM == null))
      {
        qL = new Matrix();
        qL.reset();
        if (!b.a(qL, qB, qC, qj))
        {
          Log.w("CropView", "failed to get screen matrix");
          qL = null;
          return;
        }
        qM = new Matrix();
        qM.reset();
        if (!qL.invert(qM))
        {
          Log.w("CropView", "could not invert display matrix");
          qM = null;
          return;
        }
        qH.d(qM.mapRadius(qX));
        qH.c(qM.mapRadius(qY));
      }
      qD.set(qB);
      if (qL.mapRect(qD))
      {
        int i = (int)qL.mapRadius(qS);
        qD.roundOut(qF);
        qF.set(qF.left - i, qF.top - i, qF.right + i, qF.bottom + i);
        qG.setBounds(qF);
        qG.draw(paramCanvas);
      }
      mPaint.setAntiAlias(true);
      mPaint.setFilterBitmap(true);
      paramCanvas.drawBitmap(mBitmap, qL, mPaint);
      qH.g(qE);
    }
    while (!qL.mapRect(qE));
    Paint localPaint1 = new Paint();
    localPaint1.setColor(qU);
    localPaint1.setStyle(Paint.Style.FILL);
    b.a(paramCanvas, localPaint1, qE, qD);
    b.b(paramCanvas, qE);
    if (!qR)
      b.a(paramCanvas, qE);
    while (true)
    {
      b.a(paramCanvas, qI, qJ, qE, qH.fz(), a(qH.getSelectState(), qj));
      return;
      Paint localPaint2 = new Paint();
      localPaint2.setColor(qW);
      localPaint2.setStrokeWidth(3.0F);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint2.setPathEffect(new DashPathEffect(new float[] { qZ, qZ + ra }, 0.0F));
      localPaint1.setColor(qV);
      b.a(paramCanvas, qE, qP, qQ, localPaint2, localPaint1);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((qL == null) || (qM == null))
      return true;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = f2;
    qM.mapPoints(arrayOfFloat);
    f1 = arrayOfFloat[0];
    f2 = arrayOfFloat[1];
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      invalidate();
      return true;
      if (rb == Mode.rc)
      {
        if (!qH.c(f1, f2))
          qK = qH.aG(16);
        qN = f1;
        qO = f2;
        rb = Mode.rd;
        continue;
        if (rb == Mode.rd)
        {
          qH.aG(0);
          qK = false;
          qN = f1;
          qO = f2;
          rb = Mode.rc;
          continue;
          if (rb == Mode.rd)
          {
            float f3 = qN;
            float f4 = qO;
            qH.d(f1 - f3, f2 - f4);
            qN = f1;
            qO = f2;
          }
        }
      }
    }
  }

  private static enum Mode
  {
  }
}