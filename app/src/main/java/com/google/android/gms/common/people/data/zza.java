package com.google.android.gms.common.people.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<Audience>
{
  static void zza(Audience paramAudience, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzd(paramParcel, 1, paramAudience.getAudienceMemberList(), false);
    zzb.zzc(paramParcel, 1000, paramAudience.getVersionCode());
    zzb.zzc(paramParcel, 2, paramAudience.getDomainRestricted());
    zzb.zza(paramParcel, 3, paramAudience.zzqi());
    zzb.zza(paramParcel, 4, paramAudience.isReadOnly());
    zzb.zzJ(paramParcel, paramInt);
  }

  public Audience zzcS(Parcel paramParcel)
  {
    boolean bool1 = false;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    ArrayList localArrayList = null;
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(m))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1:
        localArrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, AudienceMember.CREATOR);
        break;
      case 1000:
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 3:
        bool2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m);
        break;
      case 4:
        bool1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new Audience(j, localArrayList, i, bool2, bool1);
  }

  public Audience[] zzeW(int paramInt)
  {
    return new Audience[paramInt];
  }
}