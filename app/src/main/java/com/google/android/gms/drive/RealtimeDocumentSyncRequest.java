package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.List;

public class RealtimeDocumentSyncRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RealtimeDocumentSyncRequest> CREATOR = new zzg();
  final int mVersionCode;
  final List<String> zzasT;
  final List<String> zzasU;

  RealtimeDocumentSyncRequest(int paramInt, List<String> paramList1, List<String> paramList2)
  {
    mVersionCode = paramInt;
    zzasT = ((List)zzv.zzz(paramList1));
    zzasU = ((List)zzv.zzz(paramList2));
  }

  public RealtimeDocumentSyncRequest(List<String> paramList1, List<String> paramList2)
  {
    this(1, paramList1, paramList2);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}