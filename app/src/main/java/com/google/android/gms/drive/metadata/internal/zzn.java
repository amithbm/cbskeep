package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public class zzn extends zzb<String>
{
  public zzn(String paramString, int paramInt)
  {
    super(paramString, Collections.singleton(paramString), Collections.emptySet(), paramInt);
  }

  protected Collection<String> zzt(Bundle paramBundle)
  {
    return paramBundle.getStringArrayList(getName());
  }
}