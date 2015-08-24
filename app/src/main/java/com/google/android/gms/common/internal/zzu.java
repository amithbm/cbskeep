package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzu
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static int hashCode(Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }

  public static zza zzy(Object paramObject)
  {
    return new zza(paramObject, null);
  }

  public static final class zza
  {
    private final Object zzHc;
    private final List<String> zzamf;

    private zza(Object paramObject)
    {
      zzHc = zzv.zzz(paramObject);
      zzamf = new ArrayList();
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(zzHc.getClass().getSimpleName()).append('{');
      int j = zzamf.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)zzamf.get(i));
        if (i < j - 1)
          localStringBuilder.append(", ");
        i += 1;
      }
      return '}';
    }

    public zza zzc(String paramString, Object paramObject)
    {
      zzamf.add((String)zzv.zzz(paramString) + "=" + String.valueOf(paramObject));
      return this;
    }
  }
}