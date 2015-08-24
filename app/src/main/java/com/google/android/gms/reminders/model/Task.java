package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.zzv;

public abstract interface Task extends Parcelable, Freezable<Task>
{
  public abstract Boolean getArchived();

  public abstract Long getArchivedTimeMs();

  public abstract byte[] getAssistance();

  public abstract Long getCreatedTimeMillis();

  public abstract Boolean getDeleted();

  public abstract DateTime getDueDate();

  public abstract DateTime getEventDate();

  public abstract Integer getExperiment();

  public abstract byte[] getExtensions();

  public abstract ExternalApplicationLink getExternalApplicationLink();

  public abstract Long getFiredTimeMillis();

  public abstract Location getLocation();

  public abstract LocationGroup getLocationGroup();

  public abstract Long getLocationSnoozedUntilMs();

  public abstract Boolean getPinned();

  public abstract RecurrenceInfo getRecurrenceInfo();

  public abstract Boolean getSnoozed();

  public abstract Long getSnoozedTimeMillis();

  public abstract TaskId getTaskId();

  public abstract Integer getTaskList();

  public abstract String getTitle();

  public static class Builder
  {
    private String zzasJ;
    private TaskId zzboU;
    private Integer zzboV;
    private Long zzboW;
    private Long zzboX;
    private Boolean zzboY;
    private Boolean zzboZ;
    private Boolean zzbpa;
    private Boolean zzbpb;
    private Long zzbpc;
    private DateTime zzbpd;
    private DateTime zzbpe;
    private Location zzbpf;
    private LocationGroup zzbpg;
    private Long zzbph;
    private byte[] zzbpi;
    private RecurrenceInfo zzbpj;
    private byte[] zzbpk;
    private Integer zzbpl;
    private ExternalApplicationLink zzbpm;
    private Long zzbpn;

    public Builder()
    {
    }

    public Builder(Task paramTask)
    {
      if (paramTask.getTaskId() == null)
      {
        localObject1 = null;
        zzboU = ((TaskId)localObject1);
        zzboV = paramTask.getTaskList();
        zzasJ = paramTask.getTitle();
        zzboW = paramTask.getCreatedTimeMillis();
        zzboX = paramTask.getArchivedTimeMs();
        zzboY = paramTask.getArchived();
        zzboZ = paramTask.getDeleted();
        zzbpa = paramTask.getPinned();
        zzbpb = paramTask.getSnoozed();
        zzbpc = paramTask.getSnoozedTimeMillis();
        if (paramTask.getDueDate() != null)
          break label276;
        localObject1 = null;
        label123: zzbpd = ((DateTime)localObject1);
        if (paramTask.getEventDate() != null)
          break label293;
        localObject1 = null;
        label139: zzbpe = ((DateTime)localObject1);
        if (paramTask.getLocation() != null)
          break label310;
        localObject1 = null;
        label155: zzbpf = ((Location)localObject1);
        if (paramTask.getLocationGroup() != null)
          break label327;
        localObject1 = null;
        label171: zzbpg = ((LocationGroup)localObject1);
        zzbph = paramTask.getLocationSnoozedUntilMs();
        zzbpi = paramTask.getExtensions();
        if (paramTask.getRecurrenceInfo() != null)
          break label344;
        localObject1 = null;
        label207: zzbpj = ((RecurrenceInfo)localObject1);
        zzbpk = paramTask.getAssistance();
        zzbpl = paramTask.getExperiment();
        if (paramTask.getExternalApplicationLink() != null)
          break label361;
      }
      label276: label293: label310: label327: label344: label361: for (Object localObject1 = localObject2; ; localObject1 = new ExternalApplicationLinkEntity(paramTask.getExternalApplicationLink()))
      {
        zzbpm = ((ExternalApplicationLink)localObject1);
        zzbpn = paramTask.getFiredTimeMillis();
        return;
        localObject1 = new TaskIdEntity(paramTask.getTaskId());
        break;
        localObject1 = new DateTimeEntity(paramTask.getDueDate());
        break label123;
        localObject1 = new DateTimeEntity(paramTask.getEventDate());
        break label139;
        localObject1 = new LocationEntity(paramTask.getLocation());
        break label155;
        localObject1 = new LocationGroupEntity(paramTask.getLocationGroup());
        break label171;
        localObject1 = new RecurrenceInfoEntity(paramTask.getRecurrenceInfo());
        break label207;
      }
    }

    public Task build()
    {
      return new TaskEntity(zzboU, zzboV, zzasJ, zzboW, zzboX, zzboY, zzboZ, zzbpa, zzbpb, zzbpc, zzbpd, zzbpe, zzbpf, zzbpg, zzbph, zzbpi, zzbpj, zzbpk, zzbpl, zzbpm, zzbpn, true);
    }

    public Builder setArchived(Boolean paramBoolean)
    {
      zzboY = paramBoolean;
      return this;
    }

    public Builder setArchivedTimeMs(Long paramLong)
    {
      zzboX = paramLong;
      return this;
    }

    public Builder setDeleted(Boolean paramBoolean)
    {
      zzboZ = paramBoolean;
      return this;
    }

    public Builder setDueDate(DateTime paramDateTime)
    {
      if (paramDateTime != null);
      for (paramDateTime = (DateTime)paramDateTime.freeze(); ; paramDateTime = null)
      {
        zzbpd = paramDateTime;
        return this;
      }
    }

    public Builder setExtensions(byte[] paramArrayOfByte)
    {
      zzbpi = paramArrayOfByte;
      return this;
    }

    public Builder setLocation(Location paramLocation)
    {
      if (paramLocation != null);
      for (paramLocation = (Location)paramLocation.freeze(); ; paramLocation = null)
      {
        zzbpf = paramLocation;
        return this;
      }
    }

    public Builder setLocationGroup(LocationGroup paramLocationGroup)
    {
      if (paramLocationGroup != null);
      for (paramLocationGroup = (LocationGroup)paramLocationGroup.freeze(); ; paramLocationGroup = null)
      {
        zzbpg = paramLocationGroup;
        return this;
      }
    }

    public Builder setPinned(Boolean paramBoolean)
    {
      zzbpa = paramBoolean;
      return this;
    }

    public Builder setRecurrenceInfo(RecurrenceInfo paramRecurrenceInfo)
    {
      if (paramRecurrenceInfo != null);
      for (paramRecurrenceInfo = (RecurrenceInfo)paramRecurrenceInfo.freeze(); ; paramRecurrenceInfo = null)
      {
        zzbpj = paramRecurrenceInfo;
        return this;
      }
    }

    public Builder setSnoozed(Boolean paramBoolean)
    {
      zzbpb = paramBoolean;
      return this;
    }

    public Builder setTaskId(TaskId paramTaskId)
    {
      if (paramTaskId != null);
      for (paramTaskId = (TaskId)paramTaskId.freeze(); ; paramTaskId = null)
      {
        zzboU = paramTaskId;
        return this;
      }
    }

    public Builder setTaskList(Integer paramInteger)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInteger != null)
      {
        bool1 = bool2;
        if (paramInteger.intValue() != 1)
        {
          bool1 = bool2;
          if (paramInteger.intValue() != 2)
          {
            bool1 = bool2;
            if (paramInteger.intValue() != 3)
            {
              bool1 = bool2;
              if (paramInteger.intValue() != 4)
              {
                bool1 = bool2;
                if (paramInteger.intValue() != 5)
                {
                  bool1 = bool2;
                  if (paramInteger.intValue() != 6)
                    if (paramInteger.intValue() != 7)
                      break label93;
                }
              }
            }
          }
        }
      }
      label93: for (bool1 = bool2; ; bool1 = false)
      {
        zzv.zzb(bool1, "Invalid constant for SystemListId. Use value in ModelConstants");
        zzboV = paramInteger;
        return this;
      }
    }

    public Builder setTitle(String paramString)
    {
      zzasJ = paramString;
      return this;
    }
  }
}