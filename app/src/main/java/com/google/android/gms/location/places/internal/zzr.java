package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.places.PlacePhotoMetadata;

public class zzr
  implements PlacePhotoMetadata
{
  private int mIndex;
  private final String zzaVN;
  private final CharSequence zzaVO;
  private final int zzzA;
  private final int zzzB;

  public zzr(String paramString, int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    zzaVN = paramString;
    zzzA = paramInt1;
    zzzB = paramInt2;
    zzaVO = paramCharSequence;
    mIndex = paramInt3;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof zzr))
        return false;
      paramObject = (zzr)paramObject;
    }
    while ((paramObject.zzzA == zzzA) && (paramObject.zzzB == zzzB) && (zzu.equal(paramObject.zzaVN, zzaVN)) && (zzu.equal(paramObject.zzaVO, zzaVO)));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(zzzA), Integer.valueOf(zzzB), zzaVN, zzaVO });
  }

  public PlacePhotoMetadata zzzh()
  {
    return this;
  }
}