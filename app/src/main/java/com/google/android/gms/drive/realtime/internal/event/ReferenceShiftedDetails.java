package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReferenceShiftedDetails> CREATOR = new zzf();
  final int mVersionCode;
  final String zzayQ;
  final String zzayR;
  final int zzayS;
  final int zzayT;

  ReferenceShiftedDetails(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzayR = paramString1;
    zzayQ = paramString2;
    zzayT = paramInt2;
    zzayS = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getNewIndex()
  {
    return zzayS;
  }

  public String getNewObjectId()
  {
    return zzayQ;
  }

  public int getOldIndex()
  {
    return zzayT;
  }

  public String getOldObjectId()
  {
    return zzayR;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}