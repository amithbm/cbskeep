package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd
  implements Parcelable.Creator<Permit>
{
  static void zza(Permit paramPermit, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zza(paramParcel, 2, zzLf, false);
    zzb.zza(paramParcel, 3, zzTJ, false);
    zzb.zza(paramParcel, 5, zzEK, false);
    zzb.zza(paramParcel, 6, zzTK, paramInt, false);
    zzb.zzd(paramParcel, 7, zzTL, false);
    zzb.zzc(paramParcel, 8, zzTN, false);
    zzb.zzJ(paramParcel, i);
  }

  public Permit zzbz(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ArrayList localArrayList2 = null;
    PermitAccess localPermitAccess = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      case 4:
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6:
        localPermitAccess = (PermitAccess)zza.zza(paramParcel, k, PermitAccess.CREATOR);
        break;
      case 7:
        localArrayList2 = zza.zzc(paramParcel, k, PermitAccess.CREATOR);
        break;
      case 8:
        localArrayList1 = zza.zzE(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new Permit(i, str3, str2, str1, localPermitAccess, localArrayList2, localArrayList1);
  }

  public Permit[] zzcv(int paramInt)
  {
    return new Permit[paramInt];
  }
}