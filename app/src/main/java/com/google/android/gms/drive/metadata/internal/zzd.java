package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import java.util.Date;

public class zzd extends com.google.android.gms.drive.metadata.zzd<Date>
{
  public zzd(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }

  protected Date zzq(Bundle paramBundle)
  {
    return new Date(paramBundle.getLong(getName()));
  }
}