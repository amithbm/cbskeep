package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetFdForAssetResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetFdForAssetResponse> CREATOR = new zzao();
  public final int statusCode;
  public final int versionCode;
  public final ParcelFileDescriptor zzbIe;

  GetFdForAssetResponse(int paramInt1, int paramInt2, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    zzbIe = paramParcelFileDescriptor;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzao.zza(this, paramParcel, paramInt | 0x1);
  }
}