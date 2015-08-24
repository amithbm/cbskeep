package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.List;

public class AutocompletePredictionEntity
  implements SafeParcelable, AutocompletePrediction
{
  public static final Parcelable.Creator<AutocompletePredictionEntity> CREATOR = new zza();
  final String mDescription;
  final int mVersionCode;
  final List<Integer> zzaTZ;
  final List<SubstringEntity> zzaUK;
  final int zzaUL;
  final String zzaUw;

  AutocompletePredictionEntity(int paramInt1, String paramString1, String paramString2, List<Integer> paramList, List<SubstringEntity> paramList1, int paramInt2)
  {
    mVersionCode = paramInt1;
    mDescription = paramString1;
    zzaUw = paramString2;
    zzaTZ = paramList;
    zzaUK = paramList1;
    zzaUL = paramInt2;
  }

  public static AutocompletePredictionEntity zza(String paramString1, String paramString2, List<Integer> paramList, List<SubstringEntity> paramList1, int paramInt)
  {
    return new AutocompletePredictionEntity(0, (String)zzv.zzz(paramString1), paramString2, paramList, paramList1, paramInt);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof AutocompletePredictionEntity))
        return false;
      paramObject = (AutocompletePredictionEntity)paramObject;
    }
    while ((zzu.equal(mDescription, paramObject.mDescription)) && (zzu.equal(zzaUw, paramObject.zzaUw)) && (zzu.equal(zzaTZ, paramObject.zzaTZ)) && (zzu.equal(zzaUK, paramObject.zzaUK)) && (zzu.equal(Integer.valueOf(zzaUL), Integer.valueOf(paramObject.zzaUL))));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { mDescription, zzaUw, zzaTZ, zzaUK, Integer.valueOf(zzaUL) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("description", mDescription).zzc("placeId", zzaUw).zzc("placeTypes", zzaTZ).zzc("substrings", zzaUK).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public AutocompletePrediction zzyW()
  {
    return this;
  }

  public static class SubstringEntity
    implements SafeParcelable
  {
    public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzx();
    final int mLength;
    final int mOffset;
    final int mVersionCode;

    public SubstringEntity(int paramInt1, int paramInt2, int paramInt3)
    {
      mVersionCode = paramInt1;
      mOffset = paramInt2;
      mLength = paramInt3;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if (!(paramObject instanceof SubstringEntity))
          return false;
        paramObject = (SubstringEntity)paramObject;
      }
      while ((zzu.equal(Integer.valueOf(mOffset), Integer.valueOf(paramObject.mOffset))) && (zzu.equal(Integer.valueOf(mLength), Integer.valueOf(paramObject.mLength))));
      return false;
    }

    public int hashCode()
    {
      return zzu.hashCode(new Object[] { Integer.valueOf(mOffset), Integer.valueOf(mLength) });
    }

    public String toString()
    {
      return zzu.zzy(this).zzc("offset", Integer.valueOf(mOffset)).zzc("length", Integer.valueOf(mLength)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzx.zza(this, paramParcel, paramInt);
    }
  }
}