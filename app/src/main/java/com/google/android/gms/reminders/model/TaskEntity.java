package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class TaskEntity
  implements SafeParcelable, Task
{
  public static final Parcelable.Creator<TaskEntity> CREATOR = new zzq();
  public final int mVersionCode;
  private final String zzasJ;
  private final Integer zzboV;
  private final Long zzboW;
  private final Long zzboX;
  private final Boolean zzboY;
  private final Boolean zzboZ;
  private final Boolean zzbpa;
  private final Boolean zzbpb;
  private final Long zzbpc;
  private final Long zzbph;
  private final byte[] zzbpi;
  private final byte[] zzbpk;
  private final Integer zzbpl;
  private final Long zzbpn;
  private final TaskIdEntity zzbpo;
  private final DateTimeEntity zzbpp;
  private final DateTimeEntity zzbpq;
  private final LocationEntity zzbpr;
  private final LocationGroupEntity zzbps;
  private final RecurrenceInfoEntity zzbpt;
  private final ExternalApplicationLinkEntity zzbpu;

  TaskEntity(int paramInt, TaskIdEntity paramTaskIdEntity, Integer paramInteger1, String paramString, Long paramLong1, Long paramLong2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Long paramLong3, DateTimeEntity paramDateTimeEntity1, DateTimeEntity paramDateTimeEntity2, LocationEntity paramLocationEntity, LocationGroupEntity paramLocationGroupEntity, Long paramLong4, byte[] paramArrayOfByte1, RecurrenceInfoEntity paramRecurrenceInfoEntity, byte[] paramArrayOfByte2, Integer paramInteger2, ExternalApplicationLinkEntity paramExternalApplicationLinkEntity, Long paramLong5)
  {
    zzbpo = paramTaskIdEntity;
    zzboV = paramInteger1;
    zzasJ = paramString;
    zzboW = paramLong1;
    zzboX = paramLong2;
    zzboY = paramBoolean1;
    zzboZ = paramBoolean2;
    zzbpa = paramBoolean3;
    zzbpb = paramBoolean4;
    zzbpc = paramLong3;
    zzbpp = paramDateTimeEntity1;
    zzbpq = paramDateTimeEntity2;
    zzbpr = paramLocationEntity;
    zzbps = paramLocationGroupEntity;
    zzbph = paramLong4;
    zzbpi = paramArrayOfByte1;
    zzbpt = paramRecurrenceInfoEntity;
    zzbpk = paramArrayOfByte2;
    zzbpl = paramInteger2;
    zzbpu = paramExternalApplicationLinkEntity;
    zzbpn = paramLong5;
    mVersionCode = paramInt;
  }

  public TaskEntity(Task paramTask)
  {
    this(paramTask.getTaskId(), paramTask.getTaskList(), paramTask.getTitle(), paramTask.getCreatedTimeMillis(), paramTask.getArchivedTimeMs(), paramTask.getArchived(), paramTask.getDeleted(), paramTask.getPinned(), paramTask.getSnoozed(), paramTask.getSnoozedTimeMillis(), paramTask.getDueDate(), paramTask.getEventDate(), paramTask.getLocation(), paramTask.getLocationGroup(), paramTask.getLocationSnoozedUntilMs(), paramTask.getExtensions(), paramTask.getRecurrenceInfo(), paramTask.getAssistance(), paramTask.getExperiment(), paramTask.getExternalApplicationLink(), paramTask.getFiredTimeMillis(), false);
  }

  TaskEntity(TaskId paramTaskId, Integer paramInteger1, String paramString, Long paramLong1, Long paramLong2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Long paramLong3, DateTime paramDateTime1, DateTime paramDateTime2, Location paramLocation, LocationGroup paramLocationGroup, Long paramLong4, byte[] paramArrayOfByte1, RecurrenceInfo paramRecurrenceInfo, byte[] paramArrayOfByte2, Integer paramInteger2, ExternalApplicationLink paramExternalApplicationLink, Long paramLong5, boolean paramBoolean)
  {
    mVersionCode = 2;
    zzboV = paramInteger1;
    zzasJ = paramString;
    zzboW = paramLong1;
    zzboX = paramLong2;
    zzboY = paramBoolean1;
    zzboZ = paramBoolean2;
    zzbpa = paramBoolean3;
    zzbpb = paramBoolean4;
    zzbpc = paramLong3;
    zzbph = paramLong4;
    zzbpi = paramArrayOfByte1;
    zzbpk = paramArrayOfByte2;
    zzbpl = paramInteger2;
    zzbpn = paramLong5;
    if (paramBoolean)
    {
      zzbpo = ((TaskIdEntity)paramTaskId);
      zzbpp = ((DateTimeEntity)paramDateTime1);
      zzbpq = ((DateTimeEntity)paramDateTime2);
      zzbpr = ((LocationEntity)paramLocation);
      zzbps = ((LocationGroupEntity)paramLocationGroup);
      zzbpt = ((RecurrenceInfoEntity)paramRecurrenceInfo);
      zzbpu = ((ExternalApplicationLinkEntity)paramExternalApplicationLink);
      return;
    }
    if (paramTaskId == null)
    {
      paramTaskId = null;
      zzbpo = paramTaskId;
      if (paramDateTime1 != null)
        break label255;
      paramTaskId = null;
      label177: zzbpp = paramTaskId;
      if (paramDateTime2 != null)
        break label268;
      paramTaskId = null;
      label189: zzbpq = paramTaskId;
      if (paramLocation != null)
        break label281;
      paramTaskId = null;
      label201: zzbpr = paramTaskId;
      if (paramLocationGroup != null)
        break label294;
      paramTaskId = null;
      label213: zzbps = paramTaskId;
      if (paramRecurrenceInfo != null)
        break label307;
      paramTaskId = null;
      label225: zzbpt = paramTaskId;
      if (paramExternalApplicationLink != null)
        break label320;
    }
    label268: label281: label294: label307: label320: for (paramTaskId = null; ; paramTaskId = new ExternalApplicationLinkEntity(paramExternalApplicationLink))
    {
      zzbpu = paramTaskId;
      return;
      paramTaskId = new TaskIdEntity(paramTaskId);
      break;
      label255: paramTaskId = new DateTimeEntity(paramDateTime1);
      break label177;
      paramTaskId = new DateTimeEntity(paramDateTime2);
      break label189;
      paramTaskId = new LocationEntity(paramLocation);
      break label201;
      paramTaskId = new LocationGroupEntity(paramLocationGroup);
      break label213;
      paramTaskId = new RecurrenceInfoEntity(paramRecurrenceInfo);
      break label225;
    }
  }

  public static boolean zza(Task paramTask1, Task paramTask2)
  {
    return (zzu.equal(paramTask1.getTaskId(), paramTask2.getTaskId())) && (zzu.equal(paramTask1.getTaskList(), paramTask2.getTaskList())) && (zzu.equal(paramTask1.getTitle(), paramTask2.getTitle())) && (zzu.equal(paramTask1.getCreatedTimeMillis(), paramTask2.getCreatedTimeMillis())) && (zzu.equal(paramTask1.getArchivedTimeMs(), paramTask2.getArchivedTimeMs())) && (zzu.equal(paramTask1.getArchived(), paramTask2.getArchived())) && (zzu.equal(paramTask1.getDeleted(), paramTask2.getDeleted())) && (zzu.equal(paramTask1.getPinned(), paramTask2.getPinned())) && (zzu.equal(paramTask1.getSnoozed(), paramTask2.getSnoozed())) && (zzu.equal(paramTask1.getSnoozedTimeMillis(), paramTask2.getSnoozedTimeMillis())) && (zzu.equal(paramTask1.getDueDate(), paramTask2.getDueDate())) && (zzu.equal(paramTask1.getEventDate(), paramTask2.getEventDate())) && (zzu.equal(paramTask1.getLocation(), paramTask2.getLocation())) && (zzu.equal(paramTask1.getLocationGroup(), paramTask2.getLocationGroup())) && (zzu.equal(paramTask1.getLocationSnoozedUntilMs(), paramTask2.getLocationSnoozedUntilMs())) && (zzu.equal(paramTask1.getExtensions(), paramTask2.getExtensions())) && (zzu.equal(paramTask1.getRecurrenceInfo(), paramTask2.getRecurrenceInfo())) && (zzu.equal(paramTask1.getAssistance(), paramTask2.getAssistance())) && (zzu.equal(paramTask1.getExperiment(), paramTask2.getExperiment())) && (zzu.equal(paramTask1.getExternalApplicationLink(), paramTask2.getExternalApplicationLink())) && (zzu.equal(paramTask1.getFiredTimeMillis(), paramTask2.getFiredTimeMillis()));
  }

  public static int zzc(Task paramTask)
  {
    return zzu.hashCode(new Object[] { paramTask.getTaskId(), paramTask.getTaskList(), paramTask.getTitle(), paramTask.getCreatedTimeMillis(), paramTask.getArchivedTimeMs(), paramTask.getArchived(), paramTask.getDeleted(), paramTask.getPinned(), paramTask.getSnoozed(), paramTask.getSnoozedTimeMillis(), paramTask.getDueDate(), paramTask.getEventDate(), paramTask.getLocation(), paramTask.getLocationGroup(), paramTask.getLocationSnoozedUntilMs(), paramTask.getExtensions(), paramTask.getRecurrenceInfo(), paramTask.getAssistance(), paramTask.getExperiment(), paramTask.getExternalApplicationLink(), paramTask.getFiredTimeMillis() });
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Task))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (Task)paramObject);
  }

  public Boolean getArchived()
  {
    return zzboY;
  }

  public Long getArchivedTimeMs()
  {
    return zzboX;
  }

  public byte[] getAssistance()
  {
    return zzbpk;
  }

  public Long getCreatedTimeMillis()
  {
    return zzboW;
  }

  public Boolean getDeleted()
  {
    return zzboZ;
  }

  public DateTime getDueDate()
  {
    return zzbpp;
  }

  public DateTime getEventDate()
  {
    return zzbpq;
  }

  public Integer getExperiment()
  {
    return zzbpl;
  }

  public byte[] getExtensions()
  {
    return zzbpi;
  }

  public ExternalApplicationLink getExternalApplicationLink()
  {
    return zzbpu;
  }

  public Long getFiredTimeMillis()
  {
    return zzbpn;
  }

  public Location getLocation()
  {
    return zzbpr;
  }

  public LocationGroup getLocationGroup()
  {
    return zzbps;
  }

  public Long getLocationSnoozedUntilMs()
  {
    return zzbph;
  }

  public Boolean getPinned()
  {
    return zzbpa;
  }

  public RecurrenceInfo getRecurrenceInfo()
  {
    return zzbpt;
  }

  public Boolean getSnoozed()
  {
    return zzbpb;
  }

  public Long getSnoozedTimeMillis()
  {
    return zzbpc;
  }

  public TaskId getTaskId()
  {
    return zzbpo;
  }

  public Integer getTaskList()
  {
    return zzboV;
  }

  public String getTitle()
  {
    return zzasJ;
  }

  public int hashCode()
  {
    return zzc(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }

  public Task zzCq()
  {
    return this;
  }
}