package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzv;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class zza<T>
  implements MetadataField<T>
{
  private final String zzawt;
  private final Set<String> zzawu;
  private final Set<String> zzawv;
  private final int zzaww;

  protected zza(String paramString, int paramInt)
  {
    zzawt = ((String)zzv.zzb(paramString, "fieldName"));
    zzawu = Collections.singleton(paramString);
    zzawv = Collections.emptySet();
    zzaww = paramInt;
  }

  protected zza(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    zzawt = ((String)zzv.zzb(paramString, "fieldName"));
    zzawu = Collections.unmodifiableSet(new HashSet(paramCollection1));
    zzawv = Collections.unmodifiableSet(new HashSet(paramCollection2));
    zzaww = paramInt;
  }

  public final String getName()
  {
    return zzawt;
  }

  public String toString()
  {
    return zzawt;
  }

  public final T zzn(Bundle paramBundle)
  {
    zzv.zzb(paramBundle, "bundle");
    if (paramBundle.get(getName()) != null)
      return zzo(paramBundle);
    return null;
  }

  protected abstract T zzo(Bundle paramBundle);
}