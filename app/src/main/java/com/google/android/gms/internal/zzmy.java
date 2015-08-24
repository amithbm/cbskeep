package com.google.android.gms.internal;

import android.database.CursorWindow;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.drive.realtime.internal.zzag;
import com.google.android.gms.drive.realtime.internal.zzf;
import java.util.Collection;
import java.util.Map;

public class zzmy
{
  public static DataHolder zzC(Object paramObject)
  {
    return zzmz.zzaAn.zzB(paramObject);
  }

  public static DataHolder zzF(Map<String, Object> paramMap)
  {
    return zzna.zzaAo.zzb(paramMap.entrySet());
  }

  public static Object zza(DataHolder paramDataHolder, int paramInt, zzag paramzzag)
  {
    int i = paramDataHolder.zzez(paramInt);
    int j = paramDataHolder.zzc("valueType", paramInt, i);
    switch (j)
    {
    default:
      throw new IllegalStateException("Unknown object type: " + j);
    case 0:
      zzx.zzA("DataHolder", "found null type");
      return null;
    case 2:
      return zznb.zzcH(paramDataHolder.zzd("value", paramInt, i));
    case 1:
      return paramzzag.zzF(paramDataHolder.zzd("value", paramInt, i), paramDataHolder.zzd("refType", paramInt, i));
    case 3:
    }
    return paramDataHolder.zzd("value", paramInt, i);
  }

  public static boolean zza(CursorWindow paramCursorWindow, int paramInt, Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null)
      return paramCursorWindow.putLong(0L, paramInt, 0) & true;
    if ((paramObject instanceof zzf))
    {
      paramObject = (zzf)paramObject;
      return paramCursorWindow.putLong(1L, paramInt, 0) & true & paramCursorWindow.putString(paramObject.getId(), paramInt, 1) & paramCursorWindow.putString(paramObject.getType(), paramInt, 2);
    }
    if ((!paramBoolean) && ((paramObject instanceof String)))
      return paramCursorWindow.putLong(3L, paramInt, 0) & true & paramCursorWindow.putString((String)paramObject, paramInt, 1);
    return paramCursorWindow.putLong(2L, paramInt, 0) & true & paramCursorWindow.putString(zznb.zzE(paramObject), paramInt, 1);
  }

  public static DataHolder zzk(Collection<?> paramCollection)
  {
    return zzmz.zzaAn.zzb(paramCollection);
  }
}