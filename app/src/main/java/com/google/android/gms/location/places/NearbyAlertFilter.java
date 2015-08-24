package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter extends AbstractPlaceFilter
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int mVersionCode;
  final List<Integer> zzaUc;
  private final Set<Integer> zzaUd;
  final List<String> zzaUe;
  final List<UserDataType> zzaUf;
  private final Set<String> zzaUg;
  private final Set<UserDataType> zzaUh;

  NearbyAlertFilter(int paramInt, List<String> paramList, List<Integer> paramList1, List<UserDataType> paramList2)
  {
    mVersionCode = paramInt;
    if (paramList1 == null)
    {
      paramList1 = Collections.emptyList();
      zzaUc = paramList1;
      if (paramList2 != null)
        break label91;
      paramList1 = Collections.emptyList();
      label31: zzaUf = paramList1;
      if (paramList != null)
        break label100;
    }
    label91: label100: for (paramList = Collections.emptyList(); ; paramList = Collections.unmodifiableList(paramList))
    {
      zzaUe = paramList;
      zzaUd = zzr(zzaUc);
      zzaUh = zzr(zzaUf);
      zzaUg = zzr(zzaUe);
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
      paramList1 = Collections.unmodifiableList(paramList2);
      break label31;
    }
  }

  public static NearbyAlertFilter createNearbyAlertFilter(Collection<String> paramCollection, Collection<Integer> paramCollection1, Collection<UserDataType> paramCollection2)
  {
    if (((paramCollection == null) || (paramCollection.isEmpty())) && ((paramCollection1 == null) || (paramCollection1.isEmpty())) && ((paramCollection2 == null) || (paramCollection2.isEmpty())))
      throw new IllegalArgumentException("NearbyAlertFilters must contain at least onePlaceId, PlaceType, or UserDataType to match results with.");
    return new NearbyAlertFilter(0, zzl(paramCollection), zzl(paramCollection1), zzl(paramCollection2));
  }

  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof NearbyAlertFilter))
        return false;
      paramObject = (NearbyAlertFilter)paramObject;
    }
    while ((zzaUd.equals(paramObject.zzaUd)) && (zzaUh.equals(paramObject.zzaUh)) && (zzaUg.equals(paramObject.zzaUg)));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaUd, zzaUh, zzaUg });
  }

  public String toString()
  {
    zzu.zza localzza = zzu.zzy(this);
    if (!zzaUd.isEmpty())
      localzza.zzc("types", zzaUd);
    if (!zzaUg.isEmpty())
      localzza.zzc("placeIds", zzaUg);
    if (!zzaUh.isEmpty())
      localzza.zzc("requestedUserDataTypes", zzaUh);
    return localzza.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
}