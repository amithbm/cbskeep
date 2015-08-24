package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class zzl extends zzi<DriveId>
  implements SearchableCollectionMetadataField<DriveId>
{
  public zzl(int paramInt)
  {
    super("parents", Collections.emptySet(), Arrays.asList(new String[] { "parentsExtra", "dbInstanceId", "parentsExtraHolder" }), paramInt);
  }

  protected Collection<DriveId> zzt(Bundle paramBundle)
  {
    paramBundle = super.zzt(paramBundle);
    if (paramBundle == null)
      return null;
    return new HashSet(paramBundle);
  }
}