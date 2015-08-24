package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AddListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddListenerRequest> CREATOR = new zzb();
  final int mVersionCode;
  public final zzas zzbGK;
  public final IntentFilter[] zzbGL;
  public final String zzbGM;
  public final String zzbGN;

  AddListenerRequest(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    if (paramIBinder != null);
    for (zzbGK = zzas.zza.zzhw(paramIBinder); ; zzbGK = null)
    {
      zzbGL = paramArrayOfIntentFilter;
      zzbGM = paramString1;
      zzbGN = paramString2;
      return;
    }
  }

  public AddListenerRequest(zzbl paramzzbl)
  {
    mVersionCode = 1;
    zzbGK = paramzzbl;
    zzbGL = paramzzbl.zzGY();
    zzbGM = paramzzbl.zzGZ();
    zzbGN = paramzzbl.zzHa();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  IBinder zzrV()
  {
    if (zzbGK == null)
      return null;
    return zzbGK.asBinder();
  }
}