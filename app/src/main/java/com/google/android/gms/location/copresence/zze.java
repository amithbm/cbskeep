package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.copresence.internal.CopresenceFeatureOptIn;

public class zze
  implements Parcelable.Creator<CopresenceSettings>
{
  static void zza(CopresenceSettings paramCopresenceSettings, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, paramCopresenceSettings.getVersionCode());
    zzb.zza(paramParcel, 2, paramCopresenceSettings.isEnabled());
    zzb.zza(paramParcel, 3, paramCopresenceSettings.zzyx());
    zzb.zza(paramParcel, 8, paramCopresenceSettings.zzyy(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public CopresenceSettings zzhU(Parcel paramParcel)
  {
    boolean bool2 = false;
    int j = zza.zzcQ(paramParcel);
    CopresenceFeatureOptIn[] arrayOfCopresenceFeatureOptIn = null;
    boolean bool1 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 3:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 8:
        arrayOfCopresenceFeatureOptIn = (CopresenceFeatureOptIn[])zza.zzb(paramParcel, k, CopresenceFeatureOptIn.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CopresenceSettings(i, bool1, bool2, arrayOfCopresenceFeatureOptIn);
  }

  public CopresenceSettings[] zzkV(int paramInt)
  {
    return new CopresenceSettings[paramInt];
  }
}