package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetRecentContextCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzi CREATOR = new zzi();
    public final Account filterAccount;
    public final boolean includeDeviceOnlyData;
    public final boolean includeThirdPartyContext;
    public final boolean includeUsageEnded;
    final int mVersionCode;

    public Request()
    {
      this(null, false, false, false);
    }

    Request(int paramInt, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      mVersionCode = paramInt;
      filterAccount = paramAccount;
      includeDeviceOnlyData = paramBoolean1;
      includeThirdPartyContext = paramBoolean2;
      includeUsageEnded = paramBoolean3;
    }

    public Request(Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this(1, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3);
    }

    public int describeContents()
    {
      zzi localzzi = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzi localzzi = CREATOR;
      zzi.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzj CREATOR = new zzj();
    public List<UsageInfo> context;
    final int mVersionCode;
    public Status status;
    public String[] topRunningPackages;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, List<UsageInfo> paramList, String[] paramArrayOfString)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      context = paramList;
      topRunningPackages = paramArrayOfString;
    }

    public int describeContents()
    {
      zzj localzzj = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzj localzzj = CREATOR;
      zzj.zza(this, paramParcel, paramInt);
    }
  }
}