package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  final String mPackageName;
  final int mVersionCode;
  final String zzMG;
  final String zzMH;

  DocumentId(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    mPackageName = paramString1;
    zzMG = paramString2;
    zzMH = paramString3;
  }

  public DocumentId(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, paramString2, paramString3);
  }

  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }

  public String toString()
  {
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[] { mPackageName, zzMG, zzMH });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
}