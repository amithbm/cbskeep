package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldChangedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<FieldChangedDetails> CREATOR = new zza();
  final int mVersionCode;
  final int zzaAp;

  FieldChangedDetails(int paramInt1, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzaAp = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public int zztU()
  {
    return zzaAp;
  }

  public int zztV()
  {
    return zzaAp + 1;
  }

  public int zztW()
  {
    return zzaAp + 2;
  }
}