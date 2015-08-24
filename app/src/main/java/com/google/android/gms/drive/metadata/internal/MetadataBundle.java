package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzh();
  final int mVersionCode;
  final Bundle zzawD;

  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    mVersionCode = paramInt;
    zzawD = ((Bundle)zzv.zzz(paramBundle));
    zzawD.setClassLoader(getClass().getClassLoader());
    paramBundle = new ArrayList();
    Object localObject = zzawD.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (zze.zzcx(str) == null)
      {
        paramBundle.add(str);
        zzx.zzC("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
      }
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (String)paramBundle.next();
      zzawD.remove((String)localObject);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof MetadataBundle))
      return false;
    paramObject = (MetadataBundle)paramObject;
    Object localObject = zzawD.keySet();
    if (!((Set)localObject).equals(paramObject.zzawD.keySet()))
      return false;
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!zzu.equal(zzawD.get(str), paramObject.zzawD.get(str)))
        return false;
    }
    return true;
  }

  public int hashCode()
  {
    Iterator localIterator = zzawD.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = zzawD.get(str).hashCode() + i * 31)
      str = (String)localIterator.next();
    return i;
  }

  public String toString()
  {
    return "MetadataBundle [values=" + zzawD + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }

  public <T> T zza(MetadataField<T> paramMetadataField)
  {
    return paramMetadataField.zzn(zzawD);
  }

  public Set<MetadataField<?>> zztq()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = zzawD.keySet().iterator();
    while (localIterator.hasNext())
      localHashSet.add(zze.zzcx((String)localIterator.next()));
    return localHashSet;
  }
}