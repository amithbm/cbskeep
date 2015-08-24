package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<AncsNotificationParcelable>
{
  static void zza(AncsNotificationParcelable paramAncsNotificationParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, paramAncsNotificationParcelable.getId());
    zzb.zza(paramParcel, 3, paramAncsNotificationParcelable.getAppId(), false);
    zzb.zza(paramParcel, 4, paramAncsNotificationParcelable.getDateTime(), false);
    zzb.zza(paramParcel, 5, paramAncsNotificationParcelable.getNotificationText(), false);
    zzb.zza(paramParcel, 6, paramAncsNotificationParcelable.getTitle(), false);
    zzb.zza(paramParcel, 7, paramAncsNotificationParcelable.getSubtitle(), false);
    zzb.zza(paramParcel, 8, paramAncsNotificationParcelable.getDisplayName(), false);
    zzb.zza(paramParcel, 9, paramAncsNotificationParcelable.getEventId());
    zzb.zza(paramParcel, 10, paramAncsNotificationParcelable.getEventFlags());
    zzb.zza(paramParcel, 11, paramAncsNotificationParcelable.getCategoryId());
    zzb.zza(paramParcel, 12, paramAncsNotificationParcelable.getCategoryCount());
    zzb.zzJ(paramParcel, paramInt);
  }

  public AncsNotificationParcelable zznh(Parcel paramParcel)
  {
    int k = zza.zzcQ(paramParcel);
    int j = 0;
    int i = 0;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    byte b4 = 0;
    byte b3 = 0;
    byte b2 = 0;
    byte b1 = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        i = zza.zzg(paramParcel, m);
        break;
      case 3:
        str6 = zza.zzp(paramParcel, m);
        break;
      case 4:
        str5 = zza.zzp(paramParcel, m);
        break;
      case 5:
        str4 = zza.zzp(paramParcel, m);
        break;
      case 6:
        str3 = zza.zzp(paramParcel, m);
        break;
      case 7:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 8:
        str1 = zza.zzp(paramParcel, m);
        break;
      case 9:
        b4 = zza.zze(paramParcel, m);
        break;
      case 10:
        b3 = zza.zze(paramParcel, m);
        break;
      case 11:
        b2 = zza.zze(paramParcel, m);
        break;
      case 12:
        b1 = zza.zze(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new AncsNotificationParcelable(j, i, str6, str5, str4, str3, str2, str1, b4, b3, b2, b1);
  }

  public AncsNotificationParcelable[] zzrj(int paramInt)
  {
    return new AncsNotificationParcelable[paramInt];
  }
}