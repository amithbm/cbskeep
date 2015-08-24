package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

public class GetServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzi();
  final int version;
  final int zzalj;
  int zzalk;
  String zzall;
  IBinder zzalm;
  Scope[] zzaln;
  Bundle zzalo;
  Account zzalp;

  public GetServiceRequest(int paramInt)
  {
    version = 2;
    zzalk = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    zzalj = paramInt;
  }

  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount)
  {
    version = paramInt1;
    zzalj = paramInt2;
    zzalk = paramInt3;
    zzall = paramString;
    if (paramInt1 < 2);
    for (zzalp = zzbU(paramIBinder); ; zzalp = paramAccount)
    {
      zzaln = paramArrayOfScope;
      zzalo = paramBundle;
      return;
      zzalm = paramIBinder;
    }
  }

  private Account zzbU(IBinder paramIBinder)
  {
    Account localAccount = null;
    if (paramIBinder != null)
      localAccount = zza.zza(IAccountAccessor.zza.zzbV(paramIBinder));
    return localAccount;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }

  public GetServiceRequest zza(Account paramAccount)
  {
    zzalp = paramAccount;
    return this;
  }

  public GetServiceRequest zzb(IAccountAccessor paramIAccountAccessor)
  {
    if (paramIAccountAccessor != null)
      zzalm = paramIAccountAccessor.asBinder();
    return this;
  }

  public GetServiceRequest zzb(Collection<Scope> paramCollection)
  {
    zzaln = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    return this;
  }

  public GetServiceRequest zzbW(String paramString)
  {
    zzall = paramString;
    return this;
  }

  public GetServiceRequest zzk(Bundle paramBundle)
  {
    zzalo = paramBundle;
    return this;
  }
}