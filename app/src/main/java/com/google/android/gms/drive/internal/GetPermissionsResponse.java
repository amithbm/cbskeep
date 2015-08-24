package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import java.util.List;

public class GetPermissionsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetPermissionsResponse> CREATOR = new zzaj();
  final int mVersionCode;
  final List<Permission> zzavw;
  final int zzwV;

  GetPermissionsResponse(int paramInt1, List<Permission> paramList, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzavw = paramList;
    zzwV = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaj.zza(this, paramParcel, paramInt);
  }
}