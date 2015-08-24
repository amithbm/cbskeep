package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.zza;

public class zzg extends zza<Long>
{
  public zzg(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }

  protected Long zzs(Bundle paramBundle)
  {
    return Long.valueOf(paramBundle.getLong(getName()));
  }
}