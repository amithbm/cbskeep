package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class Permission
  implements SafeParcelable
{
  public static final Parcelable.Creator<Permission> CREATOR = new zzf();
  final int mVersionCode;
  private String zzasN;
  private int zzasO;
  private String zzasP;
  private String zzasQ;
  private int zzasR;
  private boolean zzasS;

  Permission(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, boolean paramBoolean)
  {
    mVersionCode = paramInt1;
    zzasN = paramString1;
    zzasO = paramInt2;
    zzasP = paramString2;
    zzasQ = paramString3;
    zzasR = paramInt3;
    zzasS = paramBoolean;
  }

  public static boolean isValidExposedAccountType(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return false;
    case 256:
    case 257:
    case 258:
    }
    return true;
  }

  public static boolean isValidExposedRole(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return false;
    case 0:
    case 1:
    case 2:
    case 3:
    }
    return true;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      bool1 = false;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (paramObject == this);
      paramObject = (Permission)paramObject;
      if ((!zzu.equal(zzasN, paramObject.zzasN)) || (zzasO != paramObject.zzasO) || (zzasR != paramObject.zzasR))
        break;
      bool1 = bool2;
    }
    while (zzasS == paramObject.zzasS);
    return false;
  }

  public String getAccountDisplayName()
  {
    return zzasP;
  }

  public String getAccountIdentifier()
  {
    if (!isValidExposedAccountType(zzasO))
      return null;
    return zzasN;
  }

  public int getAccountType()
  {
    if (!isValidExposedAccountType(zzasO))
      return -1;
    return zzasO;
  }

  public String getPhotoLink()
  {
    return zzasQ;
  }

  public int getRole()
  {
    if (!isValidExposedRole(zzasR))
      return -1;
    return zzasR;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzasN, Integer.valueOf(zzasO), Integer.valueOf(zzasR), Boolean.valueOf(zzasS) });
  }

  public boolean isLinkRequiredForAccess()
  {
    return zzasS;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}