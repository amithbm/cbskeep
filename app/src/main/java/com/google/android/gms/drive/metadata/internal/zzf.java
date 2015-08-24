package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.zza;

public class zzf extends zza<Integer>
{
  public zzf(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }

  protected Integer zzr(Bundle paramBundle)
  {
    return Integer.valueOf(paramBundle.getInt(getName()));
  }
}