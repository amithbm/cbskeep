package com.google.android.gms.reminders;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<CreateReminderOptionsInternal>
{
  static void zza(CreateReminderOptionsInternal paramCreateReminderOptionsInternal, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramCreateReminderOptionsInternal.zzBV(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramCreateReminderOptionsInternal.zzBW(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramCreateReminderOptionsInternal.zzBU());
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public CreateReminderOptionsInternal zzkC(Parcel paramParcel)
  {
    String str2 = null;
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CreateReminderOptionsInternal(i, str1, str2, bool);
  }

  public CreateReminderOptionsInternal[] zzof(int paramInt)
  {
    return new CreateReminderOptionsInternal[paramInt];
  }
}