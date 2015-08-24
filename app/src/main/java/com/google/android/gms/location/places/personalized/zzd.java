package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.ArrayList;

public class zzd
  implements Parcelable.Creator<PlaceUserData>
{
  static void zza(PlaceUserData paramPlaceUserData, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, paramPlaceUserData.getUserAccountName(), false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, paramPlaceUserData.getPlaceId(), false);
    zzb.zzd(paramParcel, 5, paramPlaceUserData.getTestDataImpls(), false);
    zzb.zzd(paramParcel, 6, paramPlaceUserData.getPlaceAliases(), false);
    zzb.zzd(paramParcel, 7, paramPlaceUserData.getHereContents(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public PlaceUserData zziK(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList3 = null;
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
        str2 = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 5:
        localArrayList3 = zza.zzc(paramParcel, k, TestDataImpl.CREATOR);
        break;
      case 6:
        localArrayList2 = zza.zzc(paramParcel, k, PlaceAlias.CREATOR);
        break;
      case 7:
        localArrayList1 = zza.zzc(paramParcel, k, HereContent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new PlaceUserData(i, str2, str1, localArrayList3, localArrayList2, localArrayList1);
  }

  public PlaceUserData[] zzlR(int paramInt)
  {
    return new PlaceUserData[paramInt];
  }
}