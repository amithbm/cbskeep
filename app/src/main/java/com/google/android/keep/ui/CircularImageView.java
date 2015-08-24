package com.google.android.keep.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.keep.a.a;
import com.google.android.keep.util.D;
import com.google.android.keep.y;

public class CircularImageView extends ImageView
{
  private final RectF IH;
  private final RectF II;
  private int IJ = 0;
  private float IK = 0.0F;

  public CircularImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    IH = new RectF();
    II = new RectF();
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null)
      return;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CircularImageView);
    IJ = paramContext.getColor(0, 0);
    IK = paramContext.getDimension(1, 0.0F);
    paramContext.recycle();
  }

  public void b(int paramInt, float paramFloat)
  {
    IJ = paramInt;
    IK = paramFloat;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    D.bO("CircularImageView_onDraw");
    Object localObject = getDrawable();
    if (!(localObject instanceof BitmapDrawable))
    {
      super.onDraw(paramCanvas);
      D.ot();
      return;
    }
    localObject = (BitmapDrawable)localObject;
    if (localObject == null)
    {
      D.ot();
      return;
    }
    localObject = ((BitmapDrawable)localObject).getBitmap();
    if (localObject == null)
    {
      D.ot();
      return;
    }
    IH.set(0.0F, 0.0F, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    II.set(0.0F, 0.0F, getWidth(), getHeight());
    y.a((Bitmap)localObject, paramCanvas, IH, II);
    if (IJ != 0)
      y.a(paramCanvas, II, IJ, IK);
    D.ot();
  }
}