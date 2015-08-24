package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import java.util.List;

@Deprecated
public final class PlaceLocalization
  implements SafeParcelable
{
  public static final zzp CREATOR = new zzp();
  public final String name;
  public final int versionCode;
  public final String zzaVD;
  public final String zzaVE;
  public final String zzaVF;
  public final List<String> zzaVG;

  public PlaceLocalization(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    versionCode = paramInt;
    name = paramString1;
    zzaVD = paramString2;
    zzaVE = paramString3;
    zzaVF = paramString4;
    zzaVG = paramList;
  }

  public static PlaceLocalization zza(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    return new PlaceLocalization(0, paramString1, paramString2, paramString3, paramString4, paramList);
  }

  public int describeContents()
  {
    zzp localzzp = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof PlaceLocalization))
        return false;
      paramObject = (PlaceLocalization)paramObject;
    }
    while ((zzu.equal(name, paramObject.name)) && (zzu.equal(zzaVD, paramObject.zzaVD)) && (zzu.equal(zzaVE, paramObject.zzaVE)) && (zzu.equal(zzaVF, paramObject.zzaVF)) && (zzu.equal(zzaVG, paramObject.zzaVG)));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { name, zzaVD, zzaVE, zzaVF });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("name", name).zzc("address", zzaVD).zzc("internationalPhoneNumber", zzaVE).zzc("regularOpenHours", zzaVF).zzc("attributions", zzaVG).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp localzzp = CREATOR;
    zzp.zza(this, paramParcel, paramInt);
  }
}