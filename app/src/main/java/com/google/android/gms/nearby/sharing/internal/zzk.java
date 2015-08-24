package com.google.android.gms.nearby.sharing.internal;

import com.google.android.gms.nearby.sharing.ShareCallback;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.Collections;
import java.util.List;

class zzk extends zzc.zza
{
  private final ShareCallback zzbbL;

  zzk(ShareCallback paramShareCallback)
  {
    zzbbL = paramShareCallback;
  }

  public List<SharedContent> zzAw()
  {
    SharedContent localSharedContent = zzbbL.onGetContent();
    if (localSharedContent != null)
      return Collections.singletonList(localSharedContent);
    return Collections.emptyList();
  }
}