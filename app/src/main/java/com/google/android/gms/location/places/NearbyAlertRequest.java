package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import java.util.Set;

public final class NearbyAlertRequest
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  private final int mVersionCode;
  private final int zzaQW;
  private final int zzaUi;

  @Deprecated
  private final PlaceFilter zzaUj;
  private final NearbyAlertFilter zzaUk;

  NearbyAlertRequest(int paramInt1, int paramInt2, int paramInt3, PlaceFilter paramPlaceFilter, NearbyAlertFilter paramNearbyAlertFilter)
  {
    mVersionCode = paramInt1;
    zzaQW = paramInt2;
    zzaUi = paramInt3;
    if (paramNearbyAlertFilter != null)
      zzaUk = paramNearbyAlertFilter;
    while (true)
    {
      zzaUj = null;
      return;
      if (paramPlaceFilter != null)
      {
        if (isValidPlaceFilter(paramPlaceFilter))
          zzaUk = NearbyAlertFilter.createNearbyAlertFilter(paramPlaceFilter.getPlaceIds(), paramPlaceFilter.getPlaceTypes(), paramPlaceFilter.getRequestedUserDataTypes());
        else
          zzaUk = null;
      }
      else
        zzaUk = null;
    }
  }

  @Deprecated
  public static boolean isValidPlaceFilter(PlaceFilter paramPlaceFilter)
  {
    return ((paramPlaceFilter.getPlaceTypes() != null) && (!paramPlaceFilter.getPlaceTypes().isEmpty())) || ((paramPlaceFilter.getPlaceIds() != null) && (!paramPlaceFilter.getPlaceIds().isEmpty())) || ((paramPlaceFilter.getRequestedUserDataTypes() != null) && (!paramPlaceFilter.getRequestedUserDataTypes().isEmpty()));
  }

  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof NearbyAlertRequest))
        return false;
      paramObject = (NearbyAlertRequest)paramObject;
    }
    while ((zzaQW == paramObject.zzaQW) && (zzaUi == paramObject.zzaUi) && (zzu.equal(zzaUj, paramObject.zzaUj)) && (zzu.equal(zzaUk, paramObject.zzaUk)));
    return false;
  }

  @Deprecated
  public PlaceFilter getFilter()
  {
    return zzaUj;
  }

  public int getLoiteringTimeMillis()
  {
    return zzaUi;
  }

  public NearbyAlertFilter getNearbyAlertFilter()
  {
    return zzaUk;
  }

  public int getTransitionTypes()
  {
    return zzaQW;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(zzaQW), Integer.valueOf(zzaUi) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("transitionTypes", Integer.valueOf(zzaQW)).zzc("loiteringTimeMillis", Integer.valueOf(zzaUi)).zzc("nearbyAlertFilter", zzaUk).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
}