package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<FACLConfig>
{
  static void zza(FACLConfig paramFACLConfig, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzUa);
    zzb.zza(paramParcel, 3, zzUb, false);
    zzb.zza(paramParcel, 4, zzUc);
    zzb.zza(paramParcel, 5, zzUd);
    zzb.zza(paramParcel, 6, zzUe);
    zzb.zza(paramParcel, 7, zzUf);
    zzb.zzJ(paramParcel, paramInt);
  }

  public FACLConfig zzbE(Parcel paramParcel)
  {
    boolean bool1 = false;
    int j = zza.zzcQ(paramParcel);
    String str = null;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        bool5 = zza.zzc(paramParcel, k);
        break;
      case 3:
        str = zza.zzp(paramParcel, k);
        break;
      case 4:
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 5:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 6:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 7:
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new FACLConfig(i, bool5, str, bool4, bool3, bool2, bool1);
  }

  public FACLConfig[] zzcA(int paramInt)
  {
    return new FACLConfig[paramInt];
  }
}