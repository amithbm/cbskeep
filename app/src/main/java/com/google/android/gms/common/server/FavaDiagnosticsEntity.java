package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FavaDiagnosticsEntity
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int mVersionCode;
  public final String zzamK;
  public final int zzamL;

  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzamK = paramString;
    zzamL = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}