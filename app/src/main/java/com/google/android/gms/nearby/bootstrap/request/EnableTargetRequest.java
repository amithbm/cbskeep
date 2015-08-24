package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzqr.zza;
import com.google.android.gms.internal.zzqs;
import com.google.android.gms.internal.zzqs.zza;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;

public class EnableTargetRequest
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  private final String description;
  private final String name;
  final int versionCode;
  private final byte zzbas;
  private final zzqr zzbau;
  private final zzqs zzbav;
  private final zzqt zzbaw;

  EnableTargetRequest(int paramInt, String paramString1, String paramString2, byte paramByte, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    versionCode = paramInt;
    name = zzv.zzce(paramString1);
    description = ((String)zzv.zzz(paramString2));
    zzbas = paramByte;
    zzv.zzz(paramIBinder1);
    zzbau = zzqr.zza.zzff(paramIBinder1);
    zzv.zzz(paramIBinder2);
    zzbav = zzqs.zza.zzfg(paramIBinder2);
    zzv.zzz(paramIBinder3);
    zzbaw = zzqt.zza.zzfh(paramIBinder3);
  }

  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }

  public IBinder getCallbackBinder()
  {
    if (zzbaw == null)
      return null;
    return zzbaw.asBinder();
  }

  public String getDescription()
  {
    return description;
  }

  public byte getDeviceType()
  {
    return zzbas;
  }

  public String getName()
  {
    return name;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }

  public IBinder zzAj()
  {
    if (zzbau == null)
      return null;
    return zzbau.asBinder();
  }

  public IBinder zzAk()
  {
    if (zzbav == null)
      return null;
    return zzbav.asBinder();
  }
}