package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

public final class ProvideContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProvideContentRequest> CREATOR = new zzi();
  final int versionCode;
  public IBinder zzbbF;
  public zzc zzbbG;

  @Deprecated
  public List<SharedContent> zzbbH;
  public long zzbbI;
  public zzd zzbbJ;

  ProvideContentRequest()
  {
    versionCode = 1;
  }

  ProvideContentRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, List<SharedContent> paramList, long paramLong, IBinder paramIBinder3)
  {
    versionCode = paramInt;
    zzbbF = paramIBinder1;
    zzbbG = zzc.zza.zzfs(paramIBinder2);
    zzbbH = paramList;
    zzbbI = paramLong;
    zzbbJ = zzd.zza.zzft(paramIBinder3);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }

  IBinder zzAv()
  {
    return zzbbJ.asBinder();
  }

  IBinder zzAx()
  {
    if (zzbbG == null)
      return null;
    return zzbbG.asBinder();
  }
}