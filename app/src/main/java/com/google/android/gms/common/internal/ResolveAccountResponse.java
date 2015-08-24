package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzx();
  final int mVersionCode;
  private boolean zzahs;
  private ConnectionResult zzaiA;
  IBinder zzakz;
  private boolean zzamh;

  public ResolveAccountResponse(int paramInt)
  {
    this(new ConnectionResult(paramInt, null));
  }

  ResolveAccountResponse(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    zzakz = paramIBinder;
    zzaiA = paramConnectionResult;
    zzahs = paramBoolean1;
    zzamh = paramBoolean2;
  }

  public ResolveAccountResponse(ConnectionResult paramConnectionResult)
  {
    this(1, null, paramConnectionResult, false, false);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof ResolveAccountResponse))
        return false;
      paramObject = (ResolveAccountResponse)paramObject;
    }
    while ((zzaiA.equals(paramObject.zzaiA)) && (zzqa().equals(paramObject.zzqa())));
    return false;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzx.zza(this, paramParcel, paramInt);
  }

  public IAccountAccessor zzqa()
  {
    return IAccountAccessor.zza.zzbV(zzakz);
  }

  public ConnectionResult zzqb()
  {
    return zzaiA;
  }

  public boolean zzqc()
  {
    return zzahs;
  }

  public boolean zzqd()
  {
    return zzamh;
  }
}