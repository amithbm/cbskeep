package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzah
  implements Parcelable.Creator<ParcelableCollaborator>
{
  static void zza(ParcelableCollaborator paramParcelableCollaborator, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzazL);
    zzb.zza(paramParcel, 3, zzafr);
    zzb.zza(paramParcel, 4, zzGc, false);
    zzb.zza(paramParcel, 5, zzFm, false);
    zzb.zza(paramParcel, 6, zzPa, false);
    zzb.zza(paramParcel, 7, zzazM, false);
    zzb.zza(paramParcel, 8, zzazN, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ParcelableCollaborator zzfq(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    boolean bool2 = false;
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
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 3:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 4:
        str5 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 6:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 7:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ParcelableCollaborator(i, bool2, bool1, str5, str4, str3, str2, str1);
  }

  public ParcelableCollaborator[] zzhM(int paramInt)
  {
    return new ParcelableCollaborator[paramInt];
  }
}