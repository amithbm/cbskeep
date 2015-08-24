package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<MessageFilter.FilterPrimitive>
{
  static void zza(MessageFilter.FilterPrimitive paramFilterPrimitive, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramFilterPrimitive.getVersionCode());
    zzb.zza(paramParcel, 2, zzamK, false);
    zzb.zza(paramParcel, 3, type, false);
    zzb.zza(paramParcel, 4, zzaSg, paramInt, false);
    zzb.zza(paramParcel, 5, zzaSh);
    zzb.zza(paramParcel, 6, zzaSi, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public MessageFilter.FilterPrimitive zzhX(Parcel paramParcel)
  {
    People localPeople = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    long l = 0L;
    AccessKey localAccessKey = null;
    String str1 = null;
    String str2 = null;
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
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 4:
        localAccessKey = (AccessKey)zza.zza(paramParcel, k, AccessKey.CREATOR);
        break;
      case 5:
        l = zza.zzi(paramParcel, k);
        break;
      case 6:
        localPeople = (People)zza.zza(paramParcel, k, People.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new MessageFilter.FilterPrimitive(i, str2, str1, localAccessKey, l, localPeople);
  }

  public MessageFilter.FilterPrimitive[] zzkY(int paramInt)
  {
    return new MessageFilter.FilterPrimitive[paramInt];
  }
}