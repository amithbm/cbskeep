package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbo
  implements Parcelable.Creator<SetFileUploadPreferencesRequest>
{
  static void zza(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzawc, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public SetFileUploadPreferencesRequest zzeN(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    FileUploadPreferencesImpl localFileUploadPreferencesImpl = null;
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
        localFileUploadPreferencesImpl = (FileUploadPreferencesImpl)zza.zza(paramParcel, k, FileUploadPreferencesImpl.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SetFileUploadPreferencesRequest(i, localFileUploadPreferencesImpl);
  }

  public SetFileUploadPreferencesRequest[] zzhh(int paramInt)
  {
    return new SetFileUploadPreferencesRequest[paramInt];
  }
}