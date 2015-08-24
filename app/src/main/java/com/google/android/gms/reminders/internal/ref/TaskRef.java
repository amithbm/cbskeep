package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.ExternalApplicationLink;
import com.google.android.gms.reminders.model.Location;
import com.google.android.gms.reminders.model.LocationGroup;
import com.google.android.gms.reminders.model.RecurrenceInfo;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskEntity;
import com.google.android.gms.reminders.model.TaskId;

public class TaskRef extends zza
  implements Task
{
  private boolean zzbng = false;
  private TaskIdRef zzbnh;
  private boolean zzbni = false;
  private DateTimeRef zzbnj;
  private boolean zzbnk = false;
  private DateTimeRef zzbnl;
  private boolean zzbnm = false;
  private LocationRef zzbnn;
  private boolean zzbno = false;
  private LocationGroupRef zzbnp;
  private boolean zzbnq = false;
  private RecurrenceInfoRef zzbnr;
  private boolean zzbns = false;
  private ExternalApplicationLinkRef zzbnt;

  public TaskRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, "");
  }

  public TaskRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
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
    return TaskEntity.zza(this, (Task)paramObject);
  }

  public Boolean getArchived()
  {
    return Boolean.valueOf(getBoolean(zzer("archived")));
  }

  public Long getArchivedTimeMs()
  {
    return getAsLong(zzer("archived_time_ms"));
  }

  public byte[] getAssistance()
  {
    return getByteArray(zzer("assistance"));
  }

  public Long getCreatedTimeMillis()
  {
    return getAsLong(zzer("created_time_millis"));
  }

  public Boolean getDeleted()
  {
    return Boolean.valueOf(getBoolean(zzer("deleted")));
  }

  public DateTime getDueDate()
  {
    if (!zzbni)
    {
      zzbni = true;
      if (!DateTimeRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "due_date_"))
        break label62;
    }
    label62: for (zzbnj = null; ; zzbnj = new DateTimeRef(mDataHolder, zzaiZ, zzbne + "due_date_"))
      return zzbnj;
  }

  public DateTime getEventDate()
  {
    if (!zzbnk)
    {
      zzbnk = true;
      if (!DateTimeRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "event_date_"))
        break label62;
    }
    label62: for (zzbnl = null; ; zzbnl = new DateTimeRef(mDataHolder, zzaiZ, zzbne + "event_date_"))
      return zzbnl;
  }

  public Integer getExperiment()
  {
    return getAsInteger(zzer("experiment"));
  }

  public byte[] getExtensions()
  {
    return getByteArray(zzer("extensions"));
  }

  public ExternalApplicationLink getExternalApplicationLink()
  {
    if (!zzbns)
    {
      zzbns = true;
      if (!ExternalApplicationLinkRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbnt = null; ; zzbnt = new ExternalApplicationLinkRef(mDataHolder, zzaiZ, zzbne))
      return zzbnt;
  }

  public Long getFiredTimeMillis()
  {
    return getAsLong(zzer("fired_time_millis"));
  }

  public Location getLocation()
  {
    if (!zzbnm)
    {
      zzbnm = true;
      if (!LocationRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbnn = null; ; zzbnn = new LocationRef(mDataHolder, zzaiZ, zzbne))
      return zzbnn;
  }

  public LocationGroup getLocationGroup()
  {
    if (!zzbno)
    {
      zzbno = true;
      if (!LocationGroupRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbnp = null; ; zzbnp = new LocationGroupRef(mDataHolder, zzaiZ, zzbne))
      return zzbnp;
  }

  public Long getLocationSnoozedUntilMs()
  {
    return getAsLong(zzer("location_snoozed_until_ms"));
  }

  public Boolean getPinned()
  {
    return Boolean.valueOf(getBoolean(zzer("pinned")));
  }

  public RecurrenceInfo getRecurrenceInfo()
  {
    if (!zzbnq)
    {
      zzbnq = true;
      if (!RecurrenceInfoRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbnr = null; ; zzbnr = new RecurrenceInfoRef(mDataHolder, zzaiZ, zzbne))
      return zzbnr;
  }

  public Boolean getSnoozed()
  {
    return Boolean.valueOf(getBoolean(zzer("snoozed")));
  }

  public Long getSnoozedTimeMillis()
  {
    return getAsLong(zzer("snoozed_time_millis"));
  }

  public TaskId getTaskId()
  {
    if (!zzbng)
    {
      zzbng = true;
      if (!TaskIdRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbnh = null; ; zzbnh = new TaskIdRef(mDataHolder, zzaiZ, zzbne))
      return zzbnh;
  }

  public Integer getTaskList()
  {
    return getAsInteger(zzer("task_list"));
  }

  public String getTitle()
  {
    return getString(zzer("title"));
  }

  public int hashCode()
  {
    return TaskEntity.zzc(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new TaskEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public Task zzCq()
  {
    return new TaskEntity(this);
  }
}