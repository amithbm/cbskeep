package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new zzaz();
  final int mVersionCode;
  final int zzanC;
  final ChangeEvent zzawf;
  final CompletionEvent zzawg;
  final QueryResultEventParcelable zzawh;
  final ChangesAvailableEvent zzawi;
  final ProgressEvent zzawj;

  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, CompletionEvent paramCompletionEvent, QueryResultEventParcelable paramQueryResultEventParcelable, ChangesAvailableEvent paramChangesAvailableEvent, ProgressEvent paramProgressEvent)
  {
    mVersionCode = paramInt1;
    zzanC = paramInt2;
    zzawf = paramChangeEvent;
    zzawg = paramCompletionEvent;
    zzawh = paramQueryResultEventParcelable;
    zzawi = paramChangesAvailableEvent;
    zzawj = paramProgressEvent;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaz.zza(this, paramParcel, paramInt);
  }
}