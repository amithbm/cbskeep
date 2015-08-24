package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.List;

public final class AppMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<AppMetadata> CREATOR = new zzb();
  private final int mVersionCode;
  private final List<AppIdentifier> zzbay;

  AppMetadata(int paramInt, List<AppIdentifier> paramList)
  {
    mVersionCode = paramInt;
    zzbay = ((List)zzv.zzb(paramList, "Must specify application identifiers"));
    zzv.zza(paramList.size(), "Application identifiers cannot be empty");
  }

  public int describeContents()
  {
    return 0;
  }

  public List<AppIdentifier> getAppIdentifiers()
  {
    return zzbay;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}