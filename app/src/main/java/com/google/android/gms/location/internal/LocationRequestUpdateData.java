package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;
import com.google.android.gms.location.zze;
import com.google.android.gms.location.zze.zza;

public class LocationRequestUpdateData
  implements SafeParcelable
{
  public static final zzl CREATOR = new zzl();
  PendingIntent mPendingIntent;
  private final int mVersionCode;
  int zzaTR;
  LocationRequestInternal zzaTS;
  zze zzaTT;
  zzd zzaTU;

  LocationRequestUpdateData(int paramInt1, int paramInt2, LocationRequestInternal paramLocationRequestInternal, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2)
  {
    mVersionCode = paramInt1;
    zzaTR = paramInt2;
    zzaTS = paramLocationRequestInternal;
    if (paramIBinder1 == null)
    {
      paramLocationRequestInternal = null;
      zzaTT = paramLocationRequestInternal;
      mPendingIntent = paramPendingIntent;
      if (paramIBinder2 != null)
        break label63;
    }
    label63: for (paramLocationRequestInternal = localObject; ; paramLocationRequestInternal = zzd.zza.zzdS(paramIBinder2))
    {
      zzaTU = paramLocationRequestInternal;
      return;
      paramLocationRequestInternal = zze.zza.zzdT(paramIBinder1);
      break;
    }
  }

  public static LocationRequestUpdateData zza(zzd paramzzd)
  {
    return new LocationRequestUpdateData(1, 2, null, null, null, paramzzd.asBinder());
  }

  public static LocationRequestUpdateData zzb(zze paramzze)
  {
    return new LocationRequestUpdateData(1, 2, null, paramzze.asBinder(), null, null);
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }

  IBinder zzyR()
  {
    if (zzaTT == null)
      return null;
    return zzaTT.asBinder();
  }

  IBinder zzyS()
  {
    if (zzaTU == null)
      return null;
    return zzaTU.asBinder();
  }
}