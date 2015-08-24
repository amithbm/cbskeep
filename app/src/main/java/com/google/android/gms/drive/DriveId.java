package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.drive.internal.zzar;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.internal.zzadx;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new zzc();
  final int mVersionCode;
  final long zzasm;
  private volatile String zzaso = null;
  final String zzasw;
  final long zzasx;
  final int zzasy;
  private volatile String zzasz = null;

  DriveId(int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzasw = paramString;
    if (!"".equals(paramString));
    for (boolean bool1 = true; ; bool1 = false)
    {
      zzv.zzS(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L);
      }
      else
      {
        bool1 = true;
      }
      zzv.zzS(bool1);
      zzasx = paramLong1;
      zzasm = paramLong2;
      zzasy = paramInt2;
      return;
    }
  }

  public DriveId(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
  }

  public static DriveId zzcs(String paramString)
  {
    zzv.zzz(paramString);
    return new DriveId(paramString, -1L, -1L, -1);
  }

  public int describeContents()
  {
    return 0;
  }

  public final String encodeToString()
  {
    if (zzaso == null)
    {
      String str = Base64.encodeToString(zzsy(), 10);
      zzaso = ("DriveId:" + str);
    }
    return zzaso;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof DriveId));
    do
    {
      return false;
      paramObject = (DriveId)paramObject;
      if (paramObject.zzasm != zzasm)
      {
        zzx.zzC("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((paramObject.zzasx == -1L) && (zzasx == -1L))
        return paramObject.zzasw.equals(zzasw);
      if ((zzasw == null) || (paramObject.zzasw == null))
      {
        if (paramObject.zzasx == zzasx);
        while (true)
        {
          return bool;
          bool = false;
        }
      }
    }
    while (paramObject.zzasx != zzasx);
    if (paramObject.zzasw.equals(zzasw))
      return true;
    zzx.zzC("DriveId", "Unexpected unequal resourceId for same DriveId object.");
    return false;
  }

  public int hashCode()
  {
    if (zzasx == -1L)
      return zzasw.hashCode();
    return (String.valueOf(zzasm) + String.valueOf(zzasx)).hashCode();
  }

  public String toString()
  {
    return encodeToString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  final byte[] zzsy()
  {
    zzar localzzar = new zzar();
    localzzar.versionCode = mVersionCode;
    if (zzasw == null);
    for (String str = ""; ; str = zzasw)
    {
      localzzar.zzavX = str;
      localzzar.zzavY = zzasx;
      localzzar.zzavV = zzasm;
      localzzar.zzavZ = zzasy;
      return zzadx.zzf(localzzar);
    }
  }
}