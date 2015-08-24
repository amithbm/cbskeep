package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zza();
  private final int mVersionCode;
  private final List<ParcelableGeofence> zzaRh;
  private final int zzaRi;

  GeofencingRequest(int paramInt1, List<ParcelableGeofence> paramList, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzaRh = paramList;
    zzaRi = paramInt2;
  }

  private GeofencingRequest(List<ParcelableGeofence> paramList, int paramInt)
  {
    this(1, paramList, paramInt);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getInitialTrigger()
  {
    return zzaRi;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public List<ParcelableGeofence> zzyk()
  {
    return zzaRh;
  }

  public static final class Builder
  {
    private final List<ParcelableGeofence> zzaRh = new ArrayList();
    private int zzaRi = 5;

    public static int zzkG(int paramInt)
    {
      return paramInt & 0x7;
    }

    public Builder addGeofence(Geofence paramGeofence)
    {
      zzv.zzb(paramGeofence, "geofence can't be null.");
      zzv.zzb(paramGeofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
      zzaRh.add((ParcelableGeofence)paramGeofence);
      return this;
    }

    public GeofencingRequest build()
    {
      if (!zzaRh.isEmpty());
      for (boolean bool = true; ; bool = false)
      {
        zzv.zzb(bool, "No geofence has been added to this request.");
        return new GeofencingRequest(zzaRh, zzaRi, null);
      }
    }

    public Builder setInitialTrigger(int paramInt)
    {
      zzaRi = zzkG(paramInt);
      return this;
    }
  }
}