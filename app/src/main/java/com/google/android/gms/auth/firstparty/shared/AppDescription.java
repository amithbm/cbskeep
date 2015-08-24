package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class AppDescription
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private static final String zzSm = "[" + AppDescription.class.getSimpleName() + "]";
  final int version;
  String zzCQ;
  boolean zzSr;
  private final String zzTU = "[" + getClass().getSimpleName() + "] %s - %s: %s";
  int zzTV;
  String zzTW;
  String zzTX;

  AppDescription(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    version = paramInt1;
    zzCQ = paramString1;
    zzTW = paramString2;
    zzTX = zzv.zzd(paramString3, zzSm + " callingPkg cannot be null or empty!");
    if (paramInt2 != 0);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "Invalid callingUid! Cannot be 0!");
      zzTV = paramInt2;
      zzSr = paramBoolean;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return getClass().getSimpleName() + "<" + zzTX + ", " + zzTV + ">";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}