package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<TaskEntity>
{
  static void zza(TaskEntity paramTaskEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramTaskEntity.getTaskId(), paramInt, false);
    zzb.zza(paramParcel, 3, paramTaskEntity.getTaskList(), false);
    zzb.zza(paramParcel, 4, paramTaskEntity.getTitle(), false);
    zzb.zza(paramParcel, 6, paramTaskEntity.getDueDate(), paramInt, false);
    zzb.zza(paramParcel, 7, paramTaskEntity.getLocation(), paramInt, false);
    zzb.zza(paramParcel, 8, paramTaskEntity.getEventDate(), paramInt, false);
    zzb.zza(paramParcel, 9, paramTaskEntity.getArchived(), false);
    zzb.zza(paramParcel, 11, paramTaskEntity.getDeleted(), false);
    zzb.zza(paramParcel, 12, paramTaskEntity.getArchivedTimeMs(), false);
    zzb.zza(paramParcel, 13, paramTaskEntity.getLocationGroup(), paramInt, false);
    zzb.zza(paramParcel, 15, paramTaskEntity.getLocationSnoozedUntilMs(), false);
    zzb.zza(paramParcel, 17, paramTaskEntity.getRecurrenceInfo(), paramInt, false);
    zzb.zza(paramParcel, 16, paramTaskEntity.getExtensions(), false);
    zzb.zza(paramParcel, 19, paramTaskEntity.getCreatedTimeMillis(), false);
    zzb.zza(paramParcel, 18, paramTaskEntity.getAssistance(), false);
    zzb.zza(paramParcel, 20, paramTaskEntity.getExperiment(), false);
    zzb.zza(paramParcel, 23, paramTaskEntity.getSnoozed(), false);
    zzb.zza(paramParcel, 22, paramTaskEntity.getPinned(), false);
    zzb.zza(paramParcel, 24, paramTaskEntity.getSnoozedTimeMillis(), false);
    zzb.zza(paramParcel, 27, paramTaskEntity.getFiredTimeMillis(), false);
    zzb.zza(paramParcel, 26, paramTaskEntity.getExternalApplicationLink(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public TaskEntity zzkV(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    TaskIdEntity localTaskIdEntity = null;
    Integer localInteger2 = null;
    String str = null;
    Long localLong5 = null;
    Long localLong4 = null;
    Boolean localBoolean4 = null;
    Boolean localBoolean3 = null;
    Boolean localBoolean2 = null;
    Boolean localBoolean1 = null;
    Long localLong3 = null;
    DateTimeEntity localDateTimeEntity2 = null;
    DateTimeEntity localDateTimeEntity1 = null;
    LocationEntity localLocationEntity = null;
    LocationGroupEntity localLocationGroupEntity = null;
    Long localLong2 = null;
    byte[] arrayOfByte2 = null;
    RecurrenceInfoEntity localRecurrenceInfoEntity = null;
    byte[] arrayOfByte1 = null;
    Integer localInteger1 = null;
    ExternalApplicationLinkEntity localExternalApplicationLinkEntity = null;
    Long localLong1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      case 5:
      case 10:
      case 14:
      case 21:
      case 25:
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localTaskIdEntity = (TaskIdEntity)zza.zza(paramParcel, k, TaskIdEntity.CREATOR);
        break;
      case 3:
        localInteger2 = zza.zzh(paramParcel, k);
        break;
      case 4:
        str = zza.zzp(paramParcel, k);
        break;
      case 6:
        localDateTimeEntity2 = (DateTimeEntity)zza.zza(paramParcel, k, DateTimeEntity.CREATOR);
        break;
      case 7:
        localLocationEntity = (LocationEntity)zza.zza(paramParcel, k, LocationEntity.CREATOR);
        break;
      case 8:
        localDateTimeEntity1 = (DateTimeEntity)zza.zza(paramParcel, k, DateTimeEntity.CREATOR);
        break;
      case 9:
        localBoolean4 = zza.zzd(paramParcel, k);
        break;
      case 11:
        localBoolean3 = zza.zzd(paramParcel, k);
        break;
      case 12:
        localLong4 = zza.zzj(paramParcel, k);
        break;
      case 13:
        localLocationGroupEntity = (LocationGroupEntity)zza.zza(paramParcel, k, LocationGroupEntity.CREATOR);
        break;
      case 15:
        localLong2 = zza.zzj(paramParcel, k);
        break;
      case 17:
        localRecurrenceInfoEntity = (RecurrenceInfoEntity)zza.zza(paramParcel, k, RecurrenceInfoEntity.CREATOR);
        break;
      case 16:
        arrayOfByte2 = zza.zzs(paramParcel, k);
        break;
      case 19:
        localLong5 = zza.zzj(paramParcel, k);
        break;
      case 18:
        arrayOfByte1 = zza.zzs(paramParcel, k);
        break;
      case 20:
        localInteger1 = zza.zzh(paramParcel, k);
        break;
      case 23:
        localBoolean1 = zza.zzd(paramParcel, k);
        break;
      case 22:
        localBoolean2 = zza.zzd(paramParcel, k);
        break;
      case 24:
        localLong3 = zza.zzj(paramParcel, k);
        break;
      case 27:
        localLong1 = zza.zzj(paramParcel, k);
        break;
      case 26:
        localExternalApplicationLinkEntity = (ExternalApplicationLinkEntity)zza.zza(paramParcel, k, ExternalApplicationLinkEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new TaskEntity(i, localTaskIdEntity, localInteger2, str, localLong5, localLong4, localBoolean4, localBoolean3, localBoolean2, localBoolean1, localLong3, localDateTimeEntity2, localDateTimeEntity1, localLocationEntity, localLocationGroupEntity, localLong2, arrayOfByte2, localRecurrenceInfoEntity, arrayOfByte1, localInteger1, localExternalApplicationLinkEntity, localLong1);
  }

  public TaskEntity[] zzoz(int paramInt)
  {
    return new TaskEntity[paramInt];
  }
}