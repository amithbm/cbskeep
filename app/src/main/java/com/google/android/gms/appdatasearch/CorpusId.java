package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class CorpusId
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public final String corpusName;
  final int mVersionCode;
  public final String packageName;
  final Bundle userHandle;

  CorpusId(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    mVersionCode = paramInt;
    packageName = paramString1;
    corpusName = paramString2;
    userHandle = paramBundle;
  }

  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof CorpusId))
    {
      paramObject = (CorpusId)paramObject;
      bool1 = bool2;
      if (zzu.equal(packageName, paramObject.packageName))
      {
        bool1 = bool2;
        if (zzu.equal(corpusName, paramObject.corpusName))
        {
          bool1 = bool2;
          if (zzu.equal(userHandle, paramObject.userHandle))
            bool1 = true;
        }
      }
    }
    return bool1;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { packageName, corpusName, userHandle });
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("CorpusId[package=").append(packageName).append(", corpus=").append(corpusName).append("userHandle=");
    if (userHandle != null);
    for (String str = userHandle.toString(); ; str = "null")
      return str + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
}