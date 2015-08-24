package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import java.util.List;

public class HereContent
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int mVersionCode;
  private final String zzPg;
  private final List<Action> zzaWa;

  HereContent(int paramInt, String paramString, List<Action> paramList)
  {
    mVersionCode = paramInt;
    zzPg = paramString;
    zzaWa = paramList;
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
      if (!(paramObject instanceof HereContent))
        return false;
      paramObject = (HereContent)paramObject;
    }
    while ((zzu.equal(zzPg, paramObject.zzPg)) && (zzu.equal(zzaWa, paramObject.zzaWa)));
    return false;
  }

  public List<Action> getActions()
  {
    return zzaWa;
  }

  public String getData()
  {
    return zzPg;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzPg, zzaWa });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("data", zzPg).zzc("actions", zzaWa).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }

  public static final class Action
    implements SafeParcelable
  {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    private final String zzMH;
    private final String zzasJ;

    Action(int paramInt, String paramString1, String paramString2)
    {
      mVersionCode = paramInt;
      zzasJ = paramString1;
      zzMH = paramString2;
    }

    public int describeContents()
    {
      zza localzza = CREATOR;
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if (!(paramObject instanceof Action))
          return false;
        paramObject = (Action)paramObject;
      }
      while ((zzu.equal(zzasJ, paramObject.zzasJ)) && (zzu.equal(zzMH, paramObject.zzMH)));
      return false;
    }

    public String getTitle()
    {
      return zzasJ;
    }

    public String getUri()
    {
      return zzMH;
    }

    public int hashCode()
    {
      return zzu.hashCode(new Object[] { zzasJ, zzMH });
    }

    public String toString()
    {
      return zzu.zzy(this).zzc("title", zzasJ).zzc("uri", zzMH).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zza localzza = CREATOR;
      zza.zza(this, paramParcel, paramInt);
    }
  }
}