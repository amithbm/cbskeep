package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GlobalSearchApplication
  implements SafeParcelable
{
  public static final zzl CREATOR = new zzl();
  public final GlobalSearchApplicationInfo appInfo;
  public final boolean enabled;
  final int mVersionCode;
  final GlobalSearchAppCorpusFeatures[] zzMU;

  GlobalSearchApplication(int paramInt, GlobalSearchApplicationInfo paramGlobalSearchApplicationInfo, GlobalSearchAppCorpusFeatures[] paramArrayOfGlobalSearchAppCorpusFeatures, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    appInfo = paramGlobalSearchApplicationInfo;
    zzMU = paramArrayOfGlobalSearchAppCorpusFeatures;
    enabled = paramBoolean;
  }

  public int describeContents()
  {
    zzl localzzl = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl localzzl = CREATOR;
    zzl.zza(this, paramParcel, paramInt);
  }
}