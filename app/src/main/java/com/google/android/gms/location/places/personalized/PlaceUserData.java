package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.List;

public class PlaceUserData
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int mVersionCode;
  private final String zzQt;
  private final String zzaUw;
  private final List<TestDataImpl> zzaWc;
  private final List<PlaceAlias> zzaWd;
  private final List<HereContent> zzaWe;

  PlaceUserData(int paramInt, String paramString1, String paramString2, List<TestDataImpl> paramList, List<PlaceAlias> paramList1, List<HereContent> paramList2)
  {
    mVersionCode = paramInt;
    zzQt = paramString1;
    zzaUw = paramString2;
    zzaWc = paramList;
    zzaWd = paramList1;
    zzaWe = paramList2;
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
      if (!(paramObject instanceof PlaceUserData))
        return false;
      paramObject = (PlaceUserData)paramObject;
    }
    while ((zzQt.equals(paramObject.zzQt)) && (zzaUw.equals(paramObject.zzaUw)) && (zzaWc.equals(paramObject.zzaWc)) && (zzaWd.equals(paramObject.zzaWd)) && (zzaWe.equals(paramObject.zzaWe)));
    return false;
  }

  public List<HereContent> getHereContents()
  {
    return zzaWe;
  }

  public List<PlaceAlias> getPlaceAliases()
  {
    return zzaWd;
  }

  public String getPlaceId()
  {
    return zzaUw;
  }

  public List<TestDataImpl> getTestDataImpls()
  {
    return zzaWc;
  }

  public String getUserAccountName()
  {
    return zzQt;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzQt, zzaUw, zzaWc, zzaWd, zzaWe });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("accountName", zzQt).zzc("placeId", zzaUw).zzc("testDataImpls", zzaWc).zzc("placeAliases", zzaWd).zzc("hereContents", zzaWe).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
}