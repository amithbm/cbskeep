package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzak();
  final int mVersionCode;
  private final Scope[] zzakA;
  final IBinder zzakz;
  private final int zzamk;
  private final Bundle zzaml;
  private final String zzamm;

  ValidateAccountRequest(int paramInt1, int paramInt2, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, String paramString)
  {
    mVersionCode = paramInt1;
    zzamk = paramInt2;
    zzakz = paramIBinder;
    zzakA = paramArrayOfScope;
    zzaml = paramBundle;
    zzamm = paramString;
  }

  public ValidateAccountRequest(IAccountAccessor paramIAccountAccessor, Scope[] paramArrayOfScope, String paramString, Bundle paramBundle)
  {
  }

  public int describeContents()
  {
    return 0;
  }

  public String getCallingPackage()
  {
    return zzamm;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzak.zza(this, paramParcel, paramInt);
  }

  public int zzqe()
  {
    return zzamk;
  }

  public Scope[] zzqf()
  {
    return zzakA;
  }

  public Bundle zzqg()
  {
    return zzaml;
  }
}