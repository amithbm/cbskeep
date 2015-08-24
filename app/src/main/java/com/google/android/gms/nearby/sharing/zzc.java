package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<SharedContent>
{
  static void zza(SharedContent paramSharedContent, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramSharedContent.getVersionCode());
    zzb.zza(paramParcel, 3, paramSharedContent.getUri(), false);
    zzb.zza(paramParcel, 8, paramSharedContent.getViewableItems(), paramInt, false);
    zzb.zza(paramParcel, 9, paramSharedContent.getLocalContents(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public SharedContent zzjL(Parcel paramParcel)
  {
    LocalContent[] arrayOfLocalContent = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      Object localObject3;
      switch (zza.zzeS(k))
      {
      case 2:
      case 4:
      case 5:
      case 6:
      case 7:
      default:
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      case 1:
      case 3:
      case 8:
      case 9:
      }
      while (true)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzp(paramParcel, k);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (ViewableItem[])zza.zzb(paramParcel, k, ViewableItem.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        arrayOfLocalContent = (LocalContent[])zza.zzb(paramParcel, k, LocalContent.CREATOR);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SharedContent(i, localObject1, localObject2, arrayOfLocalContent);
  }

  public SharedContent[] zzne(int paramInt)
  {
    return new SharedContent[paramInt];
  }
}