package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEventList
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEventList> CREATOR = new zze();
  final int mVersionCode;
  final DataHolder zzaAC;
  final boolean zzaAD;
  final List<String> zzaAE;
  final List<ParcelableEvent> zzpg;

  ParcelableEventList(int paramInt, List<ParcelableEvent> paramList, DataHolder paramDataHolder, boolean paramBoolean, List<String> paramList1)
  {
    mVersionCode = paramInt;
    zzpg = paramList;
    zzaAC = paramDataHolder;
    zzaAD = paramBoolean;
    zzaAE = paramList1;
  }

  public int describeContents()
  {
    return 0;
  }

  public List<ParcelableEvent> getEvents()
  {
    return zzpg;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }

  public DataHolder zzui()
  {
    return zzaAC;
  }

  public boolean zzuj()
  {
    return zzaAD;
  }

  public List<String> zzuk()
  {
    return zzaAE;
  }
}