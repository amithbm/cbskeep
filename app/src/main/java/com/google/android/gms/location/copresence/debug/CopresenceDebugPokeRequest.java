package com.google.android.gms.location.copresence.debug;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.copresence.internal.zzi;

public class CopresenceDebugPokeRequest
  implements SafeParcelable
{
  public static int COMMAND_CLEAR_CACHE = 2;
  public static int COMMAND_CLEAR_DIRECTIVES = 32;
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  public final zzi messageListener;
  private int zzaSo;
  private byte[] zzaSp;

  CopresenceDebugPokeRequest(int paramInt1, int paramInt2, byte[] paramArrayOfByte, IBinder paramIBinder)
  {
  }

  private CopresenceDebugPokeRequest(int paramInt1, int paramInt2, byte[] paramArrayOfByte, zzi paramzzi)
  {
    mVersionCode = paramInt1;
    zzaSo = paramInt2;
    zzaSp = paramArrayOfByte;
    messageListener = paramzzi;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getCommand()
  {
    return zzaSo;
  }

  public byte[] getProtoData()
  {
    return zzaSp;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  IBinder zzyC()
  {
    if (messageListener == null)
      return null;
    return messageListener.asBinder();
  }
}