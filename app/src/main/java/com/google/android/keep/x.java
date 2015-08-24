package com.google.android.keep;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.google.android.keep.provider.g;
import com.google.android.keep.util.r;

public class x
{
  private static volatile x sO = null;
  private static Drawable sP = new ColorDrawable(17170445);
  private final Drawable sM;
  private int sN;

  private x(Context paramContext)
  {
    sM = paramContext.getResources().getDrawable(2130837714);
    sN = paramContext.getResources().getColor(2131296390);
  }

  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramImageView != null)
    {
      paramImageView.setImageBitmap(paramBitmap);
      paramImageView.setBackgroundColor(0);
      paramImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }

  private void a(ImageView paramImageView, Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    if (paramImageView != null)
    {
      paramImageView.setImageDrawable(paramDrawable);
      paramImageView.setBackgroundColor(sN);
      paramImageView.setScaleType(paramScaleType);
    }
  }

  public static x fV()
  {
    return sO;
  }

  public static void init(Context paramContext)
  {
    if (sO == null)
      sO = new x(paramContext.getApplicationContext());
  }

  public void a(Context paramContext, ImageView paramImageView, Uri paramUri)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString())))
    {
      r.a("Keep", "Skip uri:" + paramUri, new Object[0]);
      a(paramImageView, sM, ImageView.ScaleType.CENTER);
      return;
    }
    Object localObject = (Uri)paramImageView.getTag();
    r.a("Keep", "Loading uri:" + paramUri + " imageView:" + paramImageView, new Object[0]);
    paramImageView.setTag(paramUri);
    localObject = w.fU().f(paramUri);
    if (localObject != null)
    {
      r.a("Keep", "Bitmap cached:" + paramUri, new Object[0]);
      a(paramImageView, (Bitmap)localObject);
      return;
    }
    r.a("Keep", "Set place holder and start bitmap:" + paramUri, new Object[0]);
    a(paramImageView, sM, ImageView.ScaleType.CENTER);
    new a(paramContext, paramImageView, paramUri).execute(new Void[0]);
  }

  private class a extends AsyncTask<Void, Integer, Bitmap>
  {
    protected final ContentResolver mResolver;
    protected final Resources mResources;
    protected final ImageView sQ;
    protected final Uri sR;

    a(Context paramImageView, ImageView paramUri, Uri arg4)
    {
      mResolver = paramImageView.getContentResolver();
      sQ = paramUri;
      Object localObject;
      sR = localObject;
      mResources = paramImageView.getResources();
    }

    protected Bitmap doInBackground(Void[] paramArrayOfVoid)
    {
      return g.c(mResolver, sR);
    }

    protected void onPostExecute(Bitmap paramBitmap)
    {
      r.a("Keep", "Load result:" + sR + " bitmap:" + paramBitmap + " ImageView:" + sQ, new Object[0]);
      if (paramBitmap == null);
      Uri localUri;
      do
      {
        do
        {
          return;
          w.fU().a(sR, paramBitmap);
        }
        while (sQ == null);
        localUri = (Uri)sQ.getTag();
        r.a("Keep", "ImageUri:" + sR + " tag:" + sQ.getTag(), new Object[0]);
      }
      while ((localUri == null) || (!localUri.equals(sR)));
      paramBitmap = new TransitionDrawable(new Drawable[] { x.fW(), new BitmapDrawable(mResources, paramBitmap) });
      r.a("Keep", "Fade in image:" + sR, new Object[0]);
      x.a(x.this, sQ, paramBitmap, ImageView.ScaleType.CENTER_CROP);
      paramBitmap.startTransition(300);
    }
  }
}