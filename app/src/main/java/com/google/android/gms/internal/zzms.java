package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzms extends zzj<AppVisibleCustomProperties>
{
  public zzms(int paramInt)
  {
    super("customProperties", Arrays.asList(new String[] { "customProperties", "sqlId" }), Arrays.asList(new String[] { "customPropertiesExtra" }), paramInt);
  }
}