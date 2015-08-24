package com.google.android.gms.reminders;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<LoadRemindersOptions>
{
  static void zza(LoadRemindersOptions paramLoadRemindersOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzb(paramParcel, 2, paramLoadRemindersOptions.getServerAssignedIds(), false);
    zzb.zzc(paramParcel, 3, paramLoadRemindersOptions.getClientAssignedIds(), false);
    zzb.zza(paramParcel, 4, paramLoadRemindersOptions.getTaskListIds(), false);
    zzb.zza(paramParcel, 5, paramLoadRemindersOptions.getDueDateAfter(), false);
    zzb.zza(paramParcel, 6, paramLoadRemindersOptions.getDueDateBefore(), false);
    zzb.zza(paramParcel, 7, paramLoadRemindersOptions.getExcludeDueDateAfter(), false);
    zzb.zza(paramParcel, 8, paramLoadRemindersOptions.getExcludeDueDateBefore(), false);
    zzb.zza(paramParcel, 9, paramLoadRemindersOptions.getIncludeArchived());
    zzb.zzc(paramParcel, 10, paramLoadRemindersOptions.getCollapseMode());
    zzb.zza(paramParcel, 11, paramLoadRemindersOptions.getExcludeExceptions());
    zzb.zza(paramParcel, 12, paramLoadRemindersOptions.getIncludeRecurrencesOnly());
    zzb.zzc(paramParcel, 13, paramLoadRemindersOptions.getLoadReminderType());
    zzb.zzc(paramParcel, 14, paramLoadRemindersOptions.getSortOrder());
    zzb.zzc(paramParcel, 15, paramLoadRemindersOptions.getRecurrenceIds(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public LoadRemindersOptions zzkD(Parcel paramParcel)
  {
    int n = zza.zzcQ(paramParcel);
    int m = 0;
    ArrayList localArrayList4 = null;
    ArrayList localArrayList3 = null;
    ArrayList localArrayList2 = null;
    Long localLong4 = null;
    Long localLong3 = null;
    Long localLong2 = null;
    Long localLong1 = null;
    boolean bool3 = false;
    int k = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    int j = 0;
    int i = 0;
    ArrayList localArrayList1 = null;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i1))
      {
      default:
        zza.zzb(paramParcel, i1);
        break;
      case 1:
        m = zza.zzg(paramParcel, i1);
        break;
      case 2:
        localArrayList4 = zza.zzD(paramParcel, i1);
        break;
      case 3:
        localArrayList3 = zza.zzE(paramParcel, i1);
        break;
      case 4:
        localArrayList2 = zza.zzC(paramParcel, i1);
        break;
      case 5:
        localLong4 = zza.zzj(paramParcel, i1);
        break;
      case 6:
        localLong3 = zza.zzj(paramParcel, i1);
        break;
      case 7:
        localLong2 = zza.zzj(paramParcel, i1);
        break;
      case 8:
        localLong1 = zza.zzj(paramParcel, i1);
        break;
      case 9:
        bool3 = zza.zzc(paramParcel, i1);
        break;
      case 10:
        k = zza.zzg(paramParcel, i1);
        break;
      case 11:
        bool2 = zza.zzc(paramParcel, i1);
        break;
      case 12:
        bool1 = zza.zzc(paramParcel, i1);
        break;
      case 13:
        j = zza.zzg(paramParcel, i1);
        break;
      case 14:
        i = zza.zzg(paramParcel, i1);
        break;
      case 15:
        localArrayList1 = zza.zzE(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n)
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    return new LoadRemindersOptions(m, localArrayList4, localArrayList3, localArrayList2, localLong4, localLong3, localLong2, localLong1, bool3, k, bool2, bool1, j, i, localArrayList1);
  }

  public LoadRemindersOptions[] zzog(int paramInt)
  {
    return new LoadRemindersOptions[paramInt];
  }
}