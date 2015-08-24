package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;

public class PlaceAlias
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public static final PlaceAlias HOME = new PlaceAlias(0, "Home");
  public static final PlaceAlias WORK = new PlaceAlias(0, "Work");
  final int mVersionCode;
  private final String zzaWb;

  PlaceAlias(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzaWb = paramString;
  }

  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof PlaceAlias))
      return false;
    paramObject = (PlaceAlias)paramObject;
    return zzu.equal(zzaWb, paramObject.zzaWb);
  }

  public String getAlias()
  {
    return zzaWb;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaWb });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("alias", zzaWb).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
}