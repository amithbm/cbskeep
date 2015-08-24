package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.Arrays;

public class PermitAccess
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final byte[] mData;
  final int mVersion;
  final String zzEK;
  final String zzLf;

  PermitAccess(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    mVersion = paramInt;
    zzLf = zzv.zzce(paramString1);
    zzEK = zzv.zzce(paramString2);
    mData = ((byte[])zzv.zzz(paramArrayOfByte));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null);
    do
    {
      return false;
      if (paramObject == this)
        return true;
    }
    while (!(paramObject instanceof PermitAccess));
    paramObject = (PermitAccess)paramObject;
    if ((TextUtils.equals(zzLf, paramObject.zzLf)) && (TextUtils.equals(zzEK, paramObject.zzEK)) && (Arrays.equals(mData, paramObject.mData)));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public String getId()
  {
    return zzLf;
  }

  public int hashCode()
  {
    return 31 * ((zzLf.hashCode() + 527) * 31 + zzEK.hashCode()) + Arrays.hashCode(mData);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}