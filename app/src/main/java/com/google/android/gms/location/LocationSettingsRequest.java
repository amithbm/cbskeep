package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzh();
  private final int mVersionCode;
  private final List<LocationRequest> zzaEo;
  private final boolean zzaRE;
  private final boolean zzaRF;
  private final boolean zzaRG;

  LocationSettingsRequest(int paramInt, List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    mVersionCode = paramInt;
    zzaEo = paramList;
    zzaRE = paramBoolean1;
    zzaRF = paramBoolean2;
    zzaRG = paramBoolean3;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }

  public List<LocationRequest> zzvc()
  {
    return Collections.unmodifiableList(zzaEo);
  }

  public boolean zzyl()
  {
    return zzaRE;
  }

  public boolean zzym()
  {
    return zzaRF;
  }

  public boolean zzyn()
  {
    return zzaRG;
  }
}