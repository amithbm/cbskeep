package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<CopresenceFeatureOptIn>
{
  static void zza(CopresenceFeatureOptIn paramCopresenceFeatureOptIn, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, paramCopresenceFeatureOptIn.getId(), false);
    zzb.zzc(paramParcel, 1000, paramCopresenceFeatureOptIn.getVersionCode());
    zzb.zza(paramParcel, 2, paramCopresenceFeatureOptIn.isOptedIn());
    zzb.zzJ(paramParcel, paramInt);
  }

  public CopresenceFeatureOptIn zzif(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        str = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CopresenceFeatureOptIn(i, str, bool);
  }

  public CopresenceFeatureOptIn[] zzlg(int paramInt)
  {
    return new CopresenceFeatureOptIn[paramInt];
  }
}