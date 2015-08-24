package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzj
  implements Parcelable.Creator<ScopeDetail>
{
  static void zza(ScopeDetail paramScopeDetail, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, description, false);
    zzb.zza(paramParcel, 3, zzSa, false);
    zzb.zza(paramParcel, 4, zzUo, false);
    zzb.zza(paramParcel, 5, zzUp, false);
    zzb.zza(paramParcel, 6, zzTj, false);
    zzb.zzc(paramParcel, 7, zzUq, false);
    zzb.zza(paramParcel, 8, friendPickerData, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public ScopeDetail zzbJ(Parcel paramParcel)
  {
    FACLData localFACLData = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
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
        str5 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 6:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 7:
        localArrayList = zza.zzE(paramParcel, k);
        break;
      case 8:
        localFACLData = (FACLData)zza.zza(paramParcel, k, FACLData.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ScopeDetail(i, str5, str4, str3, str2, str1, localArrayList, localFACLData);
  }

  public ScopeDetail[] zzcF(int paramInt)
  {
    return new ScopeDetail[paramInt];
  }
}