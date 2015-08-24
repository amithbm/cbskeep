package com.google.android.gms.internal;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzmu extends zzj<DriveId>
{
  public static final zzmu zzaxy = new zzmu();

  private zzmu()
  {
    super("driveId", Arrays.asList(new String[] { "sqlId", "resourceId", "mimeType" }), Arrays.asList(new String[] { "dbInstanceId" }), 4100000);
  }
}