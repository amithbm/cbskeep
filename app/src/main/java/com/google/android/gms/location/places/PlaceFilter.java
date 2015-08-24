package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends AbstractPlaceFilter
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  final int mVersionCode;
  final List<Integer> zzaUc;
  private final Set<Integer> zzaUd;
  final List<String> zzaUe;
  final List<UserDataType> zzaUf;
  private final Set<String> zzaUg;
  private final Set<UserDataType> zzaUh;
  final boolean zzaUo;

  public PlaceFilter()
  {
    this(false, null);
  }

  PlaceFilter(int paramInt, List<Integer> paramList, boolean paramBoolean, List<String> paramList1, List<UserDataType> paramList2)
  {
    mVersionCode = paramInt;
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      zzaUc = paramList;
      zzaUo = paramBoolean;
      if (paramList2 != null)
        break label97;
      paramList = Collections.emptyList();
      label36: zzaUf = paramList;
      if (paramList1 != null)
        break label106;
    }
    label97: label106: for (paramList = Collections.emptyList(); ; paramList = Collections.unmodifiableList(paramList1))
    {
      zzaUe = paramList;
      zzaUd = zzr(zzaUc);
      zzaUh = zzr(zzaUf);
      zzaUg = zzr(zzaUe);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
      paramList = Collections.unmodifiableList(paramList2);
      break label36;
    }
  }

  public PlaceFilter(Collection<Integer> paramCollection, boolean paramBoolean, Collection<String> paramCollection1, Collection<UserDataType> paramCollection2)
  {
    this(0, zzl(paramCollection), paramBoolean, zzl(paramCollection1), zzl(paramCollection2));
  }

  public PlaceFilter(boolean paramBoolean, Collection<String> paramCollection)
  {
    this(null, paramBoolean, paramCollection, null);
  }

  public int describeContents()
  {
    zzf localzzf = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof PlaceFilter))
        return false;
      paramObject = (PlaceFilter)paramObject;
    }
    while ((zzaUd.equals(paramObject.zzaUd)) && (zzaUo == paramObject.zzaUo) && (zzaUh.equals(paramObject.zzaUh)) && (zzaUg.equals(paramObject.zzaUg)));
    return false;
  }

  public Set<String> getPlaceIds()
  {
    return zzaUg;
  }

  public Set<Integer> getPlaceTypes()
  {
    return zzaUd;
  }

  public Set<UserDataType> getRequestedUserDataTypes()
  {
    return zzaUh;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaUd, Boolean.valueOf(zzaUo), zzaUh, zzaUg });
  }

  public String toString()
  {
    zzu.zza localzza = zzu.zzy(this);
    if (!zzaUd.isEmpty())
      localzza.zzc("types", zzaUd);
    localzza.zzc("requireOpenNow", Boolean.valueOf(zzaUo));
    if (!zzaUg.isEmpty())
      localzza.zzc("placeIds", zzaUg);
    if (!zzaUh.isEmpty())
      localzza.zzc("requestedUserDataTypes", zzaUh);
    return localzza.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf localzzf = CREATOR;
    zzf.zza(this, paramParcel, paramInt);
  }
}