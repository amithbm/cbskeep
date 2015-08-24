package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class People
  implements SafeParcelable
{
  public static final Parcelable.Creator<People> CREATOR = new zzj();
  public static final People zzaSl = new People(1);
  public static final People zzaSm = new People(2);
  private final int mVersionCode;
  private final List<String> zzaSj;
  private final int zzaSk;

  private People(int paramInt)
  {
    this(1, null, paramInt);
  }

  People(int paramInt1, List<String> paramList, int paramInt2)
  {
    mVersionCode = paramInt1;
    if (paramList == null);
    for (paramList = null; ; paramList = Collections.unmodifiableList(paramList))
    {
      zzaSj = paramList;
      zzaSk = paramInt2;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  public boolean zza(People paramPeople)
  {
    return (paramPeople == null) || (paramPeople.zzyB() == 1) || (zzaSk == 2) || ((zzaSk == 0) && (paramPeople.zzyB() == 0) && (zzaSj.containsAll(paramPeople.zzyA())));
  }

  public List<String> zzyA()
  {
    return zzaSj;
  }

  public int zzyB()
  {
    return zzaSk;
  }
}