package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaw
  implements Parcelable.Creator<MessageEventParcelable>
{
  static void zza(MessageEventParcelable paramMessageEventParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, paramMessageEventParcelable.getRequestId());
    zzb.zza(paramParcel, 3, paramMessageEventParcelable.getPath(), false);
    zzb.zza(paramParcel, 4, paramMessageEventParcelable.getData(), false);
    zzb.zza(paramParcel, 5, paramMessageEventParcelable.getSourceNodeId(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public MessageEventParcelable zznD(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzcQ(paramParcel);
    byte[] arrayOfByte = null;
    String str2 = null;
    int j = 0;
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
        str2 = zza.zzp(paramParcel, m);
        break;
      case 4:
        arrayOfByte = zza.zzs(paramParcel, m);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new MessageEventParcelable(j, i, str2, arrayOfByte, str1);
  }

  public MessageEventParcelable[] zzrI(int paramInt)
  {
    return new MessageEventParcelable[paramInt];
  }
}