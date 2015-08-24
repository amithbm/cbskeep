package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDataItemResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetDataItemResponse> CREATOR = new zzan();
  public final int statusCode;
  public final int versionCode;
  public final DataItemParcelable zzbId;

  GetDataItemResponse(int paramInt1, int paramInt2, DataItemParcelable paramDataItemParcelable)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    zzbId = paramDataItemParcelable;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzan.zza(this, paramParcel, paramInt);
  }
}