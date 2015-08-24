package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<GlobalSearchApplication>
{
  static void zza(GlobalSearchApplication paramGlobalSearchApplication, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, appInfo, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzMU, paramInt, false);
    zzb.zza(paramParcel, 3, enabled);
    zzb.zzJ(paramParcel, i);
  }

  public GlobalSearchApplication zzD(Parcel paramParcel)
  {
    Object localObject2 = null;
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    Object localObject1 = null;
    int i = 0;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      Object localObject3;
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      case 1:
      case 1000:
      case 2:
      case 3:
      }
      while (true)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = (GlobalSearchApplicationInfo)zza.zza(paramParcel, k, GlobalSearchApplicationInfo.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (GlobalSearchAppCorpusFeatures[])zza.zzb(paramParcel, k, GlobalSearchAppCorpusFeatures.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        bool = zza.zzc(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GlobalSearchApplication(i, localObject1, localObject2, bool);
  }

  public GlobalSearchApplication[] zzap(int paramInt)
  {
    return new GlobalSearchApplication[paramInt];
  }
}