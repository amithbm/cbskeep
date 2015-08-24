package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties
  implements SafeParcelable, Iterable<CustomProperty>
{
  public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new zza();
  public static final AppVisibleCustomProperties zzawy = new zza().zztm();
  final int mVersionCode;
  final List<CustomProperty> zzawz;

  AppVisibleCustomProperties(int paramInt, Collection<CustomProperty> paramCollection)
  {
    mVersionCode = paramInt;
    zzv.zzz(paramCollection);
    zzawz = new ArrayList(paramCollection);
  }

  private AppVisibleCustomProperties(Collection<CustomProperty> paramCollection)
  {
    this(1, paramCollection);
  }

  public int describeContents()
  {
    return 0;
  }

  public Iterator<CustomProperty> iterator()
  {
    return zzawz.iterator();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public static class zza
  {
    private final Map<CustomPropertyKey, CustomProperty> zzawA = new HashMap();

    public AppVisibleCustomProperties zztm()
    {
      return new AppVisibleCustomProperties(zzawA.values(), null);
    }
  }
}