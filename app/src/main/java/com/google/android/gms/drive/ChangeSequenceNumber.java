package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.drive.internal.zzaq;
import com.google.android.gms.internal.zzadx;

public class ChangeSequenceNumber
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangeSequenceNumber> CREATOR = new zza();
  final int mVersionCode;
  final long zzasl;
  final long zzasm;
  final long zzasn;
  private volatile String zzaso = null;

  ChangeSequenceNumber(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != -1L)
    {
      bool1 = true;
      zzv.zzS(bool1);
      if (paramLong2 == -1L)
        break label92;
      bool1 = true;
      label40: zzv.zzS(bool1);
      if (paramLong3 == -1L)
        break label98;
    }
    label92: label98: for (boolean bool1 = bool2; ; bool1 = false)
    {
      zzv.zzS(bool1);
      mVersionCode = paramInt;
      zzasl = paramLong1;
      zzasm = paramLong2;
      zzasn = paramLong3;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label40;
    }
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
      zzaso = ("ChangeSequenceNumber:" + str);
    }
    return zzaso;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ChangeSequenceNumber));
    do
    {
      return false;
      paramObject = (ChangeSequenceNumber)paramObject;
    }
    while ((paramObject.zzasm != zzasm) || (paramObject.zzasn != zzasn) || (paramObject.zzasl != zzasl));
    return true;
  }

  public int hashCode()
  {
    return (String.valueOf(zzasl) + String.valueOf(zzasm) + String.valueOf(zzasn)).hashCode();
  }

  public String toString()
  {
    return encodeToString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  final byte[] zzsy()
  {
    zzaq localzzaq = new zzaq();
    localzzaq.versionCode = mVersionCode;
    localzzaq.zzavU = zzasl;
    localzzaq.zzavV = zzasm;
    localzzaq.zzavW = zzasn;
    return zzadx.zzf(localzzaq);
  }
}