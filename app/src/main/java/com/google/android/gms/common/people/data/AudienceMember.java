package com.google.android.gms.common.people.data;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public final class AudienceMember
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private final int zzOu;
  private final String zzPa;

  @Deprecated
  private final Bundle zzajg;
  private final int zzamG;
  private final String zzamH;
  private final String zzamI;
  private final String zzamJ;

  AudienceMember(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    mVersionCode = paramInt1;
    zzOu = paramInt2;
    zzamG = paramInt3;
    zzamH = paramString1;
    zzamI = paramString2;
    zzPa = paramString3;
    zzamJ = paramString4;
    if (paramBundle != null);
    while (true)
    {
      zzajg = paramBundle;
      return;
      paramBundle = new Bundle();
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudienceMember));
    do
    {
      return false;
      paramObject = (AudienceMember)paramObject;
    }
    while ((mVersionCode != paramObject.mVersionCode) || (zzOu != paramObject.zzOu) || (zzamG != paramObject.zzamG) || (!zzu.equal(zzamH, paramObject.zzamH)) || (!zzu.equal(zzamI, paramObject.zzamI)));
    return true;
  }

  public String getAvatarUrl()
  {
    return zzamJ;
  }

  public String getCircleId()
  {
    return zzamH;
  }

  public int getCircleType()
  {
    return zzamG;
  }

  public String getDisplayName()
  {
    return zzPa;
  }

  @Deprecated
  public Bundle getMetadata()
  {
    return zzajg;
  }

  public String getPeopleQualifiedId()
  {
    return zzamI;
  }

  public int getType()
  {
    return zzOu;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(mVersionCode), Integer.valueOf(zzOu), Integer.valueOf(zzamG), zzamH, zzamI });
  }

  public boolean isPerson()
  {
    return zzOu == 2;
  }

  public boolean isPersonalCircle()
  {
    return (zzOu == 1) && (zzamG == -1);
  }

  public String toString()
  {
    if (isPerson())
      return String.format("Person [%s] %s", new Object[] { getPeopleQualifiedId(), getDisplayName() });
    if (isPersonalCircle())
      return String.format("Circle [%s] %s", new Object[] { getCircleId(), getDisplayName() });
    return String.format("Group [%s] %s", new Object[] { getCircleId(), getDisplayName() });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}