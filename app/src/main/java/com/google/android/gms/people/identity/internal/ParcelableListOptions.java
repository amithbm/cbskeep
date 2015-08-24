package com.google.android.gms.people.identity.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;

public final class ParcelableListOptions
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  private final int mVersionCode;
  final boolean zzbcN;
  final boolean zzbcO;
  final String zzbcP;
  final boolean zzbcQ;
  final Bundle zzbcR;

  ParcelableListOptions(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    mVersionCode = paramInt;
    zzbcN = paramBoolean1;
    zzbcO = paramBoolean2;
    zzbcP = paramString;
    zzbcQ = paramBoolean3;
    paramString = paramBundle;
    if (paramBundle == null)
      paramString = new Bundle();
    zzbcR = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("useOfflineDatabase", Boolean.valueOf(zzbcN)).zzc("useWebData", Boolean.valueOf(zzbcO)).zzc("useCP2", Boolean.valueOf(zzbcQ)).zzc("endpoint", zzbcP).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}