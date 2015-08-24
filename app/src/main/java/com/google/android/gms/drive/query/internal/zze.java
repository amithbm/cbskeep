package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Iterator;
import java.util.Set;

class zze
{
  static MetadataField<?> zzb(MetadataBundle paramMetadataBundle)
  {
    paramMetadataBundle = paramMetadataBundle.zztq();
    if (paramMetadataBundle.size() != 1)
      throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    return (MetadataField)paramMetadataBundle.iterator().next();
  }
}