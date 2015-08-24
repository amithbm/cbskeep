package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetIncludeInGlobalSearchCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzk CREATOR = new zzk();
    public boolean enabled;
    final int mVersionCode;
    public String packageName;

    public Request()
    {
      mVersionCode = 1;
    }

    Request(int paramInt, String paramString, boolean paramBoolean)
    {
      mVersionCode = paramInt;
      packageName = paramString;
      enabled = paramBoolean;
    }

    public int describeContents()
    {
      zzk localzzk = CREATOR;
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzk localzzk = CREATOR;
      zzk.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;
    public Status status;

    public Response()
    {
      mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus)
    {
      mVersionCode = paramInt;
      status = paramStatus;
    }

    public int describeContents()
    {
      zzl localzzl = CREATOR;
      return 0;
    }

    public Status getStatus()
    {
      return status;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzl localzzl = CREATOR;
      zzl.zza(this, paramParcel, paramInt);
    }
  }
}