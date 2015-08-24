package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzadl;
import com.google.android.gms.internal.zzadw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzw extends com.google.android.gms.common.data.zzc
{
  private final String TAG = "SafeDataBufferRef";

  public zzw(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  protected String zzJ(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (zzbQ(paramString1))
    {
      str = paramString2;
      if (!zzbS(paramString1))
        str = getString(paramString1);
    }
    return str;
  }

  protected <E extends SafeParcelable> E zza(String paramString, Parcelable.Creator<E> paramCreator)
  {
    paramString = zzc(paramString, null);
    if (paramString == null)
      return null;
    return com.google.android.gms.common.internal.safeparcel.zzc.zza(paramString, paramCreator);
  }

  protected <E extends SafeParcelable> List<E> zza(String paramString, Parcelable.Creator<E> paramCreator, List<E> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null);
    do
      while (true)
      {
        return paramList;
        try
        {
          Object localObject = zzadl.zzO(paramString);
          if (((zzadl)localObject).zzbJw != null)
          {
            paramString = new ArrayList(((zzadl)localObject).zzbJw.length);
            localObject = ((zzadl)localObject).zzbJw;
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              paramString.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(localObject[i], paramCreator));
              i += 1;
            }
            return paramString;
          }
        }
        catch (zzadw paramString)
        {
        }
      }
    while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }

  protected List<Integer> zza(String paramString, List<Integer> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null);
    do
      while (true)
      {
        return paramList;
        try
        {
          paramString = zzadl.zzO(paramString);
          if (paramString.zzbJv != null)
          {
            ArrayList localArrayList = new ArrayList(paramString.zzbJv.length);
            int i = 0;
            while (i < paramString.zzbJv.length)
            {
              localArrayList.add(Integer.valueOf(paramString.zzbJv[i]));
              i += 1;
            }
            return localArrayList;
          }
        }
        catch (zzadw paramString)
        {
        }
      }
    while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }

  protected float zzb(String paramString, float paramFloat)
  {
    float f = paramFloat;
    if (zzbQ(paramString))
    {
      f = paramFloat;
      if (!zzbS(paramString))
        f = getFloat(paramString);
    }
    return f;
  }

  protected List<String> zzb(String paramString, List<String> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null);
    do
      while (true)
      {
        return paramList;
        try
        {
          paramString = zzadl.zzO(paramString);
          if (paramString.zzbJu != null)
          {
            paramString = Arrays.asList(paramString.zzbJu);
            return paramString;
          }
        }
        catch (zzadw paramString)
        {
        }
      }
    while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }

  protected byte[] zzc(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (zzbQ(paramString))
    {
      arrayOfByte = paramArrayOfByte;
      if (!zzbS(paramString))
        arrayOfByte = getByteArray(paramString);
    }
    return arrayOfByte;
  }

  protected boolean zzj(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (zzbQ(paramString))
    {
      bool = paramBoolean;
      if (!zzbS(paramString))
        bool = getBoolean(paramString);
    }
    return bool;
  }

  protected int zzx(String paramString, int paramInt)
  {
    int i = paramInt;
    if (zzbQ(paramString))
    {
      i = paramInt;
      if (!zzbS(paramString))
        i = getInteger(paramString);
    }
    return i;
  }
}