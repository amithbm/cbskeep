package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<Message>
{
  static void zza(Message paramMessage, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramMessage.getVersionCode());
    zzb.zza(paramParcel, 2, paramMessage.getNamespace(), false);
    zzb.zza(paramParcel, 3, paramMessage.getType(), false);
    zzb.zza(paramParcel, 4, paramMessage.getPayload(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public Message zzhV(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
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
        arrayOfByte = zza.zzs(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new Message(i, str1, str2, arrayOfByte);
  }

  public Message[] zzkW(int paramInt)
  {
    return new Message[paramInt];
  }
}