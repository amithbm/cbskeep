package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class zzaz
  implements Parcelable.Creator<OnEventResponse>
{
  static void zza(OnEventResponse paramOnEventResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, zzanC);
    zzb.zza(paramParcel, 3, zzawf, paramInt, false);
    zzb.zza(paramParcel, 5, zzawg, paramInt, false);
    zzb.zza(paramParcel, 6, zzawh, paramInt, false);
    zzb.zza(paramParcel, 7, zzawi, paramInt, false);
    zzb.zza(paramParcel, 8, zzawj, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public OnEventResponse zzez(Parcel paramParcel)
  {
    int i = 0;
    ProgressEvent localProgressEvent = null;
    int k = zza.zzcQ(paramParcel);
    ChangesAvailableEvent localChangesAvailableEvent = null;
    QueryResultEventParcelable localQueryResultEventParcelable = null;
    CompletionEvent localCompletionEvent = null;
    ChangeEvent localChangeEvent = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      case 4:
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        i = zza.zzg(paramParcel, m);
        break;
      case 3:
        localChangeEvent = (ChangeEvent)zza.zza(paramParcel, m, ChangeEvent.CREATOR);
        break;
      case 5:
        localCompletionEvent = (CompletionEvent)zza.zza(paramParcel, m, CompletionEvent.CREATOR);
        break;
      case 6:
        localQueryResultEventParcelable = (QueryResultEventParcelable)zza.zza(paramParcel, m, QueryResultEventParcelable.CREATOR);
        break;
      case 7:
        localChangesAvailableEvent = (ChangesAvailableEvent)zza.zza(paramParcel, m, ChangesAvailableEvent.CREATOR);
        break;
      case 8:
        localProgressEvent = (ProgressEvent)zza.zza(paramParcel, m, ProgressEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new OnEventResponse(j, i, localChangeEvent, localCompletionEvent, localQueryResultEventParcelable, localChangesAvailableEvent, localProgressEvent);
  }

  public OnEventResponse[] zzgT(int paramInt)
  {
    return new OnEventResponse[paramInt];
  }
}