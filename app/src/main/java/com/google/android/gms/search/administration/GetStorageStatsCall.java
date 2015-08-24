package com.google.android.gms.search.administration;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetStorageStatsCall
{
  public static class PackageStats
    implements SafeParcelable
  {
    public static final zzb CREATOR = new zzb();
    public boolean blocked;
    final int mVersionCode;
    public String packageName;
    public long zzbpV;
    public long zzbpW;

    public PackageStats()
    {
      mVersionCode = 1;
    }

    PackageStats(int paramInt, String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
    {
      mVersionCode = paramInt;
      packageName = paramString;
      zzbpV = paramLong1;
      blocked = paramBoolean;
      zzbpW = paramLong2;
    }

    public int describeContents()
    {
      zzb localzzb = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzb localzzb = CREATOR;
      zzb.zza(this, paramParcel, paramInt);
    }
  }

  public static class Request
    implements SafeParcelable
  {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt)
    {
      mVersionCode = paramInt;
    }

    public int describeContents()
    {
      zzc localzzc = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzc localzzc = CREATOR;
      zzc.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    public Status status;
    public GetStorageStatsCall.PackageStats[] zzbpX;
    public long zzbpY;
    public long zzbpZ;
    public long zzbqa;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, GetStorageStatsCall.PackageStats[] paramArrayOfPackageStats, long paramLong1, long paramLong2, long paramLong3)
    {
      mVersionCode = paramInt;
      status = paramStatus;
      zzbpX = paramArrayOfPackageStats;
      zzbpY = paramLong1;
      zzbpZ = paramLong2;
      zzbqa = paramLong3;
    }

    public int describeContents()
    {
      zzd localzzd = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzd localzzd = CREATOR;
      zzd.zza(this, paramParcel, paramInt);
    }
  }
}