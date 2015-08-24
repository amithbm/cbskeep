package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.zzu;

public final class zzlt extends zzme<zza, Drawable>
{
  public static final class zza
  {
    public final int zzakx;
    public final int zzaky;

    public zza(int paramInt1, int paramInt2)
    {
      zzakx = paramInt1;
      zzaky = paramInt2;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool1;
      if (!(paramObject instanceof zza))
        bool1 = false;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        }
        while (this == paramObject);
        paramObject = (zza)paramObject;
        if (paramObject.zzakx != zzakx)
          break;
        bool1 = bool2;
      }
      while (paramObject.zzaky == zzaky);
      return false;
    }

    public int hashCode()
    {
      return zzu.hashCode(new Object[] { Integer.valueOf(zzakx), Integer.valueOf(zzaky) });
    }
  }
}