package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteFilter
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int mVersionCode;
  final boolean zzaUb;
  final List<Integer> zzaUc;
  private final Set<Integer> zzaUd;

  AutocompleteFilter(int paramInt, boolean paramBoolean, Collection<Integer> paramCollection)
  {
    mVersionCode = paramInt;
    zzaUb = paramBoolean;
    if (paramCollection == null);
    for (paramCollection = Collections.emptyList(); ; paramCollection = new ArrayList(paramCollection))
    {
      zzaUc = paramCollection;
      if (!zzaUc.isEmpty())
        break;
      zzaUd = Collections.emptySet();
      return;
    }
    zzaUd = Collections.unmodifiableSet(new HashSet(zzaUc));
  }

  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof AutocompleteFilter))
        return false;
      paramObject = (AutocompleteFilter)paramObject;
    }
    while ((zzaUd.equals(paramObject.zzaUd)) && (zzaUb == paramObject.zzaUb));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Boolean.valueOf(zzaUb), zzaUd });
  }

  public boolean isRestrictedToPlaces()
  {
    return zzaUb;
  }

  public String toString()
  {
    zzu.zza localzza = zzu.zzy(this);
    if (!zzaUb)
      localzza.zzc("restrictedToPlaces", Boolean.valueOf(zzaUb));
    localzza.zzc("placeTypes", zzaUd);
    return localzza.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
}