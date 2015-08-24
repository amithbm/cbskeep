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
import com.google.android.gms.nearby.bootstrap.Device;

public class ConnectRequest
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final String description;
  private final String name;
  private final long timeoutMillis;
  final int versionCode;
  private final String zzSt;
  private final byte zzbas;
  private final Device zzbat;
  private final zzqr zzbau;
  private final zzqs zzbav;
  private final zzqt zzbaw;

  ConnectRequest(int paramInt, Device paramDevice, String paramString1, String paramString2, byte paramByte, long paramLong, String paramString3, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    versionCode = paramInt;
    zzbat = ((Device)zzv.zzz(paramDevice));
    name = zzv.zzce(paramString1);
    description = ((String)zzv.zzz(paramString2));
    zzbas = paramByte;
    timeoutMillis = paramLong;
    zzSt = paramString3;
    zzv.zzz(paramIBinder1);
    zzbau = zzqr.zza.zzff(paramIBinder1);
    zzv.zzz(paramIBinder2);
    zzbav = zzqs.zza.zzfg(paramIBinder2);
    zzv.zzz(paramIBinder3);
    zzbaw = zzqt.zza.zzfh(paramIBinder3);
  }

  public int describeContents()
  {
    zza localzza = CREATOR;
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

  public String getToken()
  {
    return zzSt;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }

  public Device zzAh()
  {
    return zzbat;
  }

  public long zzAi()
  {
    return timeoutMillis;
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