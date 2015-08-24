package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.Arrays;

public class Authorization
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public final byte[] mData;
  public final String mPermitAccessId;
  public final String mPermitId;
  final int mVersion;

  Authorization(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    mVersion = paramInt;
    mPermitId = zzv.zzce(paramString1);
    mPermitAccessId = zzv.zzce(paramString2);
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
    while (!(paramObject instanceof Authorization));
    paramObject = (Authorization)paramObject;
    if ((TextUtils.equals(mPermitId, paramObject.mPermitId)) && (TextUtils.equals(mPermitAccessId, paramObject.mPermitAccessId)) && (Arrays.equals(mData, paramObject.mData)));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public int hashCode()
  {
    return 31 * ((mPermitId.hashCode() + 527) * 31 + mPermitAccessId.hashCode()) + Arrays.hashCode(mData);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}