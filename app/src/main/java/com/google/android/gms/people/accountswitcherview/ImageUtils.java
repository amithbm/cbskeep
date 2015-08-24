package com.google.android.gms.people.accountswitcherview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;

final class ImageUtils
{
  public static Bitmap frameBitmapInCircle(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return null;
    int m = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    int j;
    int k;
    if (m >= i)
    {
      j = m / 2 - i / 2;
      k = 0;
    }
    while (true)
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localCanvas.drawCircle(i / 2, i / 2, i / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, j, k, localPaint);
      return localBitmap;
      j = 0;
      k = i / 2 - m / 2;
      i = m;
    }
  }
}