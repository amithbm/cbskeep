package com.google.android.gms.common.people.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Collections;
import java.util.List;

public final class Audience
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  private final List<AudienceMember> zzamC;
  private final int zzamD;

  @Deprecated
  private final boolean zzamE;
  private final boolean zzamF;

  Audience(int paramInt1, List<AudienceMember> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramList;
    if (paramInt1 == 1)
    {
      localObject = paramList;
      if (paramList == null)
        localObject = Collections.emptyList();
    }
    mVersionCode = paramInt1;
    zzamC = Collections.unmodifiableList((List)localObject);
    zzamD = paramInt2;
    if (paramInt1 == 1)
    {
      zzamE = paramBoolean1;
      if (!paramBoolean1);
      for (paramBoolean1 = bool1; ; paramBoolean1 = false)
      {
        zzamF = paramBoolean1;
        return;
      }
    }
    zzamF = paramBoolean2;
    if (!paramBoolean2);
    for (paramBoolean1 = bool2; ; paramBoolean1 = false)
    {
      zzamE = paramBoolean1;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Audience));
    do
    {
      return false;
      paramObject = (Audience)paramObject;
    }
    while ((mVersionCode != paramObject.mVersionCode) || (!zzu.equal(zzamC, paramObject.zzamC)) || (zzamD != paramObject.zzamD) || (zzamF != paramObject.zzamF));
    return true;
  }

  public List<AudienceMember> getAudienceMemberList()
  {
    return zzamC;
  }

  public int getDomainRestricted()
  {
    return zzamD;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(mVersionCode), zzamC, Integer.valueOf(zzamD), Boolean.valueOf(zzamF) });
  }

  public boolean isReadOnly()
  {
    return zzamF;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  @Deprecated
  boolean zzqi()
  {
    return zzamE;
  }
}