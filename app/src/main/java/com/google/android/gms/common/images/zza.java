package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlt.zza;
import java.lang.ref.WeakReference;

public abstract class zza
{
  final zza zzajO;
  protected int zzajQ;
  protected ImageManager.OnImageLoadedListener zzajS;
  protected int zzajW;

  private Drawable zza(Context paramContext, zzlt paramzzlt, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (zzajW > 0)
    {
      zzlt.zza localzza = new zzlt.zza(paramInt, zzajW);
      Drawable localDrawable = (Drawable)paramzzlt.get(localzza);
      paramContext = localDrawable;
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        paramContext = localDrawable;
        if ((zzajW & 0x1) != 0)
          paramContext = zza(localResources, localDrawable);
        paramzzlt.put(localzza, paramContext);
      }
      return paramContext;
    }
    return localResources.getDrawable(paramInt);
  }

  protected Drawable zza(Resources paramResources, Drawable paramDrawable)
  {
    return zzlr.zza(paramResources, paramDrawable);
  }

  void zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    zzb.zzv(paramBitmap);
    Bitmap localBitmap = paramBitmap;
    if ((zzajW & 0x1) != 0)
      localBitmap = zzlr.zzb(paramBitmap);
    paramContext = new BitmapDrawable(paramContext.getResources(), localBitmap);
    if (zzajS != null)
      zzajS.onImageLoaded(zzajO.uri, paramContext, true);
    zza(paramContext, paramBoolean, false, true);
  }

  void zza(Context paramContext, zzlt paramzzlt, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (zzajQ != 0)
      localDrawable = zza(paramContext, paramzzlt, zzajQ);
    if (zzajS != null)
      zzajS.onImageLoaded(zzajO.uri, localDrawable, false);
    zza(localDrawable, paramBoolean, false, false);
  }

  protected abstract void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

  static final class zza
  {
    public final Uri uri;

    public zza(Uri paramUri)
    {
      uri = paramUri;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza))
        return false;
      if (this == paramObject)
        return true;
      return zzu.equal(((zza)paramObject).uri, uri);
    }

    public int hashCode()
    {
      return zzu.hashCode(new Object[] { uri });
    }
  }

  public static final class zzc extends zza
  {
    private WeakReference<ImageManager.OnImageLoadedListener> zzajY;

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzc))
        return false;
      if (this == paramObject)
        return true;
      paramObject = (zzc)paramObject;
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)zzajY.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)paramObject.zzajY.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (zzu.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (zzu.equal(paramObject.zzajO, zzajO)));
      for (boolean bool = true; ; bool = false)
        return bool;
    }

    public int hashCode()
    {
      return zzu.hashCode(new Object[] { zzajO });
    }

    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)zzajY.get();
        if (localOnImageLoadedListener != null)
          localOnImageLoadedListener.onImageLoaded(zzajO.uri, paramDrawable, paramBoolean3);
      }
    }
  }
}