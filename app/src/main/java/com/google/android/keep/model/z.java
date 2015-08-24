package com.google.android.keep.model;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.reminders.model.DailyPattern;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.DateTime.Builder;
import com.google.android.gms.reminders.model.FeatureIdProto.Builder;
import com.google.android.gms.reminders.model.Location.Builder;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gms.reminders.model.RecurrenceInfo;
import com.google.android.gms.reminders.model.RecurrenceStart;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.Task.Builder;
import com.google.android.gms.reminders.model.TaskId;
import com.google.android.gms.reminders.model.Time.Builder;
import com.google.android.keep.N;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.PlaceIdEncoder;
import com.google.android.keep.util.e;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import com.google.android.keep.util.x;
import com.google.android.location.proto.support.FeatureIdProto;
import com.google.caribou.tasks.KeepExtension;
import com.google.caribou.tasks.TaskExtensions;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protos.maps_api.PlaceId;

public class z
{
  public static com.google.android.gms.reminders.model.Location a(Context paramContext, Location paramLocation)
  {
    Location.Builder localBuilder = new Location.Builder();
    String str = paramLocation.r(paramContext);
    paramContext = str;
    if (TextUtils.isEmpty(str))
      paramContext = "";
    localBuilder.setName(paramContext);
    if (paramLocation.getType() != 3)
      switch (paramLocation.getType())
      {
      default:
      case 1:
      case 2:
      }
    while (true)
    {
      return localBuilder.build();
      localBuilder.setLocationType(Integer.valueOf(1));
      continue;
      localBuilder.setLocationType(Integer.valueOf(2));
      continue;
      localBuilder.setRadiusMeters(paramLocation.getRadius());
      localBuilder.setLat(paramLocation.hW());
      localBuilder.setLng(paramLocation.hX());
      str = paramLocation.hY();
      paramContext = str;
      if (TextUtils.isEmpty(str))
        paramContext = "";
      localBuilder.setDisplayAddress(paramContext);
      localBuilder.setAddress(paramLocation.getAddress());
      if (!TextUtils.isEmpty(paramLocation.getPlaceId()))
      {
        try
        {
          paramContext = PlaceIdEncoder.decode(paramLocation.getPlaceId());
          if (featureId == null)
            break label241;
          localBuilder.setGeoFeatureId(new FeatureIdProto.Builder().setCellId(Long.valueOf(featureId.cellId)).setFprint(Long.valueOf(featureId.fprint)).build());
        }
        catch (IllegalArgumentException paramContext)
        {
          r.d("Keep", "Couldn't decode place id", new Object[0]);
        }
        continue;
        label241: r.d("Keep", "Missing location feature id data", new Object[0]);
      }
    }
  }

  public static Task a(Context paramContext, TaskId paramTaskId, BaseReminder paramBaseReminder, String paramString, TreeEntity paramTreeEntity)
  {
    paramString = N.jH().setTitle(paramString);
    if (paramBaseReminder.getType() == 0)
    {
      paramContext = (TimeReminder)paramBaseReminder;
      paramBaseReminder = new KeepTime();
      paramBaseReminder.setJulianDay(paramContext.jm());
      paramBaseReminder = x.b(paramBaseReminder);
      if (paramContext.jo() != 0)
      {
        int i = bh(paramContext.jo());
        if (i != -1)
        {
          paramBaseReminder.setPeriod(Integer.valueOf(i));
          paramBaseReminder.setTime(x.d(TimeReminder.TimePeriod.bm(paramContext.jo())));
        }
        paramString.setDueDate(paramBaseReminder.build());
      }
    }
    while (true)
    {
      paramString.setTaskId(paramTaskId);
      a(paramString, paramTreeEntity);
      return paramString.build();
      if (paramContext.jn() <= 0L)
        break;
      long l1 = paramContext.jn();
      paramContext = new Time.Builder();
      long l2 = l1 / 3600000L;
      paramContext.setHour(Integer.valueOf((int)l2));
      paramContext.setMinute(Integer.valueOf((int)((l1 - 3600000L * l2) / 60000L)));
      paramContext.setSecond(Integer.valueOf(0));
      paramBaseReminder.setTime(paramContext.build());
      break;
      if (paramBaseReminder.getType() == 1)
        paramString.setLocation(a(paramContext, ((LocationReminder)paramBaseReminder).hZ()));
    }
  }

  public static Task a(Task paramTask)
  {
    return new Task.Builder().setTaskList(Integer.valueOf(4)).setTitle(paramTask.getTitle()).setExtensions(paramTask.getExtensions()).build();
  }

  public static Task a(String paramString, TreeEntity paramTreeEntity, RecurrenceInfo paramRecurrenceInfo)
  {
    paramString = new Task.Builder().setTaskList(Integer.valueOf(4)).setTitle(paramString).setRecurrenceInfo(paramRecurrenceInfo);
    a(paramString, paramTreeEntity);
    return paramString.build();
  }

  public static BaseReminder a(long paramLong, Task paramTask)
  {
    if (paramTask == null);
    String str;
    long l;
    boolean bool;
    do
    {
      return null;
      str = w.k(paramTask);
      if (paramTask.getArchivedTimeMs() != null);
      for (l = paramTask.getArchivedTimeMs().longValue(); ; l = 0L)
      {
        bool = x.o(paramTask);
        if (paramTask.getDueDate() == null)
          break;
        return a(paramLong, str, paramTask.getDueDate(), paramTask.getRecurrenceInfo(), bool, l);
      }
      if (paramTask.getRecurrenceInfo() != null)
      {
        Recurrence localRecurrence = paramTask.getRecurrenceInfo().getRecurrence();
        DateTime localDateTime = localRecurrence.getRecurrenceStart().getStartDateTime();
        localObject = localDateTime;
        if (localRecurrence != null)
        {
          localObject = localDateTime;
          if (localRecurrence.getDailyPattern() != null)
          {
            localObject = localRecurrence.getDailyPattern();
            localObject = new DateTime.Builder(localDateTime).setTime(((DailyPattern)localObject).getTimeOfDay()).setPeriod(((DailyPattern)localObject).getDayPeriod()).build();
          }
        }
        return a(paramLong, str, (DateTime)localObject, paramTask.getRecurrenceInfo(), bool, l);
      }
    }
    while (paramTask.getLocation() == null);
    Object localObject = paramTask.getLocation();
    int i = 3;
    if (((com.google.android.gms.reminders.model.Location)localObject).getLocationType() != null);
    switch (((com.google.android.gms.reminders.model.Location)localObject).getLocationType().intValue())
    {
    default:
      i = 3;
      if (((com.google.android.gms.reminders.model.Location)localObject).getGeoFeatureId() == null)
        break;
    case 1:
    case 2:
    }
    for (paramTask = PlaceIdEncoder.encode(((com.google.android.gms.reminders.model.Location)localObject).getGeoFeatureId()); ; paramTask = "")
    {
      return new LocationReminder(paramLong, str, new Location(i, ((com.google.android.gms.reminders.model.Location)localObject).getName(), ((com.google.android.gms.reminders.model.Location)localObject).getLat(), ((com.google.android.gms.reminders.model.Location)localObject).getLng(), ((com.google.android.gms.reminders.model.Location)localObject).getRadiusMeters(), ((com.google.android.gms.reminders.model.Location)localObject).getDisplayAddress(), paramTask, ((com.google.android.gms.reminders.model.Location)localObject).getAddress()), bool, l);
      i = 1;
      break;
      i = 2;
      break;
    }
  }

  private static TimeReminder a(long paramLong1, String paramString, DateTime paramDateTime, RecurrenceInfo paramRecurrenceInfo, boolean paramBoolean, long paramLong2)
  {
    if ((paramDateTime.getUnspecifiedFutureTime() != null) && (paramDateTime.getUnspecifiedFutureTime().booleanValue()));
    for (int i = 1; i != 0; i = 0)
      return new TimeReminder(paramLong1, paramString);
    int j = 0;
    i = j;
    if (paramDateTime.getPeriod() != null)
    {
      localObject = x.d(paramDateTime);
      i = j;
      if (localObject != TimeReminder.TimePeriod.zI)
        i = TimeReminder.TimePeriod.b((TimeReminder.TimePeriod)localObject);
    }
    Object localObject = null;
    if (paramRecurrenceInfo != null)
      localObject = paramRecurrenceInfo.getRecurrence();
    return new TimeReminder(paramLong1, paramString, x.b(paramDateTime), x.c(paramDateTime), i, paramBoolean, paramLong2, (Recurrence)localObject);
  }

  private static void a(Task.Builder paramBuilder, TreeEntity paramTreeEntity)
  {
    TaskExtensions localTaskExtensions = new TaskExtensions();
    localTaskExtensions.keepExtension = new KeepExtension();
    localTaskExtensions.keepExtension.serverNoteId = e.bv(paramTreeEntity.getServerId());
    localTaskExtensions.keepExtension.clientNoteId = e.bv(paramTreeEntity.gu());
    paramBuilder.setExtensions(TaskExtensions.toByteArray(localTaskExtensions));
  }

  public static KeepExtension b(Task paramTask)
  {
    if (paramTask.getExtensions() != null)
      try
      {
        KeepExtension localKeepExtension = TaskExtensions.parseFrom(paramTask.getExtensions()).keepExtension;
        return localKeepExtension;
      }
      catch (InvalidProtocolBufferNanoException localInvalidProtocolBufferNanoException)
      {
        r.e("Keep", "Failed to parse taskExtension for task: " + w.k(paramTask), new Object[0]);
      }
    return null;
  }

  private static int bh(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return -1;
    case 1:
      return 1;
    case 2:
      return 2;
    case 3:
      return 3;
    case 4:
    }
    return 4;
  }
}