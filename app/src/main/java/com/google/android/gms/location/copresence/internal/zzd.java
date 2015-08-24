package com.google.android.gms.location.copresence.internal;

import android.content.Context;
import com.google.android.gms.location.internal.zzn;

public class zzd
{
  private final Context mContext;
  private final String zzOZ;
  private final String zzQt;
  private final zzn<com.google.android.gms.location.internal.zzg> zzaSx;
  private final CopresenceApiOptions zzaSy;
  private zzg zzaSz;

  private zzd(Context paramContext, String paramString1, String paramString2, zzn<com.google.android.gms.location.internal.zzg> paramzzn, CopresenceApiOptions paramCopresenceApiOptions)
  {
    mContext = paramContext;
    zzQt = paramString1;
    zzaSx = paramzzn;
    zzaSz = null;
    zzOZ = paramString2;
    zzaSy = paramCopresenceApiOptions;
  }

  public static zzd zza(Context paramContext, String paramString1, String paramString2, zzn<com.google.android.gms.location.internal.zzg> paramzzn, CopresenceApiOptions paramCopresenceApiOptions)
  {
    return new zzd(paramContext, paramString1, paramString2, paramzzn, paramCopresenceApiOptions);
  }
}