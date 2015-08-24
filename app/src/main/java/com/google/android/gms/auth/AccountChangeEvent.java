package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;

public class AccountChangeEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
  final long mId;
  final int mVersion;
  final String zzQt;
  final int zzQu;
  final int zzQv;
  final String zzQw;

  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    mVersion = paramInt1;
    mId = paramLong;
    zzQt = ((String)zzv.zzz(paramString1));
    zzQu = paramInt2;
    zzQv = paramInt3;
    zzQw = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent))
        break;
      paramObject = (AccountChangeEvent)paramObject;
    }
    while ((mVersion == paramObject.mVersion) && (mId == paramObject.mId) && (zzu.equal(zzQt, paramObject.zzQt)) && (zzQu == paramObject.zzQu) && (zzQv == paramObject.zzQv) && (zzu.equal(zzQw, paramObject.zzQw)));
    return false;
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(mVersion), Long.valueOf(mId), zzQt, Integer.valueOf(zzQu), Integer.valueOf(zzQv), zzQw });
  }

  public String toString()
  {
    String str = "UNKNOWN";
    switch (zzQu)
    {
    default:
    case 1:
    case 2:
    case 4:
    case 3:
    }
    while (true)
    {
      return "AccountChangeEvent {accountName = " + zzQt + ", changeType = " + str + ", changeData = " + zzQw + ", eventIndex = " + zzQv + "}";
      str = "ADDED";
      continue;
      str = "REMOVED";
      continue;
      str = "RENAMED_TO";
      continue;
      str = "RENAMED_FROM";
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}