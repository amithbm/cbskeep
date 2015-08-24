package com.google.android.keep.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import com.android.calendarcommon2.EventRecurrence;
import com.android.recurrencepicker.Utils;
import com.google.android.common.base.Preconditions;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.ui.PlacePicker.IntentBuilder;
import com.google.android.gms.reminders.model.DailyPattern;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.DateTime.Builder;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gms.reminders.model.RecurrenceInfo;
import com.google.android.gms.reminders.model.RecurrenceStart;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.Time.Builder;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.U;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.location.d;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.Location;
import com.google.android.keep.model.LocationReminder;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.TimeReminder;
import com.google.android.keep.model.TimeReminder.TimePeriod;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.j;
import com.google.android.keep.model.m;
import com.google.android.keep.ui.KeepRecurrencePickerDialog;
import com.google.android.keep.ui.KeepRecurrencePickerDialog.b;
import com.google.android.keep.ui.i;
import com.google.android.keep.ui.i.a;
import com.google.android.keep.ui.k;
import com.google.android.keep.ui.k.a;
import com.google.android.keep.ui.s;
import com.google.android.keep.ui.t;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class x
{
  private static final long Qa = ((Integer)Config.OQ.get()).intValue();

  public static long a(DateTime paramDateTime)
  {
    return e(paramDateTime).op();
  }

  public static long a(com.google.android.gms.reminders.model.Time paramTime)
  {
    return e.d(paramTime.getHour()) * 3600000L + e.d(paramTime.getMinute()) * 60000L + e.d(paramTime.getSecond()) * 1000L;
  }

  private static String a(Context paramContext, LocationReminder paramLocationReminder)
  {
    double d = paramLocationReminder.ia();
    if (d > 0.0D)
    {
      if (Locale.US.equals(Locale.getDefault()))
        return paramContext.getString(2131231124, new Object[] { paramLocationReminder.hZ().r(paramContext), Double.valueOf(e.b(d)) });
      return paramContext.getString(2131231125, new Object[] { paramLocationReminder.hZ().r(paramContext), Double.valueOf(e.a(d)) });
    }
    return paramLocationReminder.hZ().r(paramContext);
  }

  private static String a(Context paramContext, TimeReminder paramTimeReminder)
  {
    if (paramTimeReminder.getRecurrence() != null)
      return b(paramContext, paramTimeReminder);
    if (paramTimeReminder.jq())
      return paramContext.getResources().getString(2131231225);
    return g.a(paramContext, new KeepTime(paramTimeReminder.jp()), TimeReminder.TimePeriod.bm(paramTimeReminder.jo()));
  }

  public static String a(Context paramContext, String paramString, TreeEntity.TreeEntityType paramTreeEntityType, List<ListItem> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null);
    m[] arrayOfm;
    for (int i = 0; ; i = paramList.size())
    {
      arrayOfm = new m[i];
      int j = 0;
      while (j < i)
      {
        ListItem localListItem = (ListItem)paramList.get(j);
        arrayOfm[j] = new m(localListItem.getText(), localListItem.isInitialized(), localListItem.gu());
        j += 1;
      }
    }
    return a(paramContext, paramString, paramTreeEntityType, arrayOfm, paramBoolean1, paramBoolean2);
  }

  public static String a(Context paramContext, String paramString, TreeEntity.TreeEntityType paramTreeEntityType, m[] paramArrayOfm, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = Config.nR();
    ArrayList localArrayList = new ArrayList();
    int j;
    if (paramArrayOfm != null)
    {
      j = paramArrayOfm.length;
      i = 0;
      while (i < j)
      {
        m localm = paramArrayOfm[i];
        String str = localm.getText();
        if ((str != null) && (!TextUtils.isEmpty(str.trim())))
          localArrayList.add(localm);
        i += 1;
      }
    }
    if (localArrayList.isEmpty())
    {
      if (!TextUtils.isEmpty(paramString))
        return e.b(paramContext, paramString, m);
      if (paramBoolean1)
        return paramContext.getString(2131231254);
      if (paramBoolean2)
        return paramContext.getString(2131231253);
      return paramContext.getString(2131231242);
    }
    if (paramTreeEntityType == TreeEntity.TreeEntityType.zO)
    {
      paramTreeEntityType = ((m)localArrayList.get(0)).getText();
      if (!TextUtils.isEmpty(paramString))
      {
        if ((TextUtils.isEmpty(paramTreeEntityType)) || (paramString.length() >= m - Math.min(8, paramTreeEntityType.length() + 3)))
          return e.b(paramContext, paramString, m);
        return e.b(paramContext, paramContext.getString(2131231153, new Object[] { paramString, paramTreeEntityType }), m);
      }
      return e.b(paramContext, paramTreeEntityType, m);
    }
    int n = localArrayList.size();
    int i1 = Math.min(n, Config.nS());
    if (TextUtils.isEmpty(paramString))
    {
      j = 0;
      paramArrayOfm = new StringBuilder();
      i = 0;
    }
    while (true)
    {
      if (i < i1)
      {
        paramTreeEntityType = ((m)localArrayList.get(i)).getText();
        if (TextUtils.isEmpty(paramTreeEntityType))
        {
          i += 1;
          continue;
          j = paramString.length() + 3;
          break;
        }
        if (i <= 0)
          break label415;
        paramTreeEntityType = "; " + paramTreeEntityType;
        k = n - i - 1;
        if (k != 0)
          break label418;
      }
      label415: label418: for (int k = 0; ; k = paramContext.getResources().getQuantityString(2131755030, k, new Object[] { Integer.valueOf(k) }).length() + 1)
      {
        if (paramArrayOfm.length() + paramTreeEntityType.length() <= m - j - k)
          break label452;
        if (i <= 0)
          break label572;
        paramTreeEntityType = paramArrayOfm.toString();
        if (i != n)
          break label486;
        if (!TextUtils.isEmpty(paramString))
          break label467;
        return paramArrayOfm.toString();
        break;
      }
      label452: paramArrayOfm.append(paramTreeEntityType);
      i += 1;
    }
    label467: return paramContext.getString(2131231153, new Object[] { paramString, paramTreeEntityType });
    label486: int i = n - i;
    paramTreeEntityType = paramTreeEntityType + " " + paramContext.getResources().getQuantityString(2131755030, i, new Object[] { Integer.valueOf(i) });
    if (TextUtils.isEmpty(paramString))
      return paramArrayOfm.toString();
    return paramContext.getString(2131231153, new Object[] { paramString, paramTreeEntityType });
    label572: if (TextUtils.isEmpty(paramString))
    {
      paramString = ((m)localArrayList.get(0)).getText();
      if (n == 1)
        return e.b(paramContext, paramString, m);
      paramTreeEntityType = " " + paramContext.getResources().getQuantityString(2131755030, n - 1, new Object[] { Integer.valueOf(n - 1) });
      i = paramTreeEntityType.length();
      return e.b(paramContext, paramString, m - i) + paramTreeEntityType;
    }
    paramTreeEntityType = paramContext.getResources().getQuantityString(2131755031, n, new Object[] { Integer.valueOf(n) });
    return paramContext.getString(2131231153, new Object[] { e.b(paramContext, paramString, m - 3 - paramTreeEntityType.length()), paramTreeEntityType });
  }

  public static String a(Resources paramResources, EventRecurrence paramEventRecurrence)
  {
    return paramResources.getString(2131231232, new Object[] { Utils.getRepeatString(paramResources, paramEventRecurrence, true, false) });
  }

  public static void a(Fragment paramFragment, Location paramLocation)
  {
    FragmentActivity localFragmentActivity = paramFragment.getActivity();
    j localj = o.O(localFragmentActivity);
    if ((localj == null) || (TextUtils.isEmpty(localj.getName())))
      return;
    PlacePicker.IntentBuilder localIntentBuilder = new PlacePicker.IntentBuilder();
    localIntentBuilder.setAccountName(localj.getName());
    if (!((Boolean)Config.Pn.get()).booleanValue())
      localIntentBuilder.hideNearbyPlaces(true);
    if ((paramLocation != null) && (paramLocation.hW() != null) && (paramLocation.hX() != null))
      localIntentBuilder.setLatLngBounds(v.g(paramLocation));
    try
    {
      paramFragment.startActivityForResult(localIntentBuilder.build(localFragmentActivity), 12);
      return;
    }
    catch (GooglePlayServicesRepairableException paramFragment)
    {
      while (true)
      {
        GooglePlayServicesUtil.showErrorNotification(paramFragment.getConnectionStatusCode(), localFragmentActivity);
        return;
        if (((Boolean)Config.Pm.get()).booleanValue())
          localIntentBuilder.setMode(2);
      }
    }
    catch (GooglePlayServicesNotAvailableException paramFragment)
    {
      r.e("ReminderUtil", "Play services not available.", new Object[0]);
    }
  }

  public static void a(Fragment paramFragment, i.a parama, k.a parama1)
  {
    paramFragment = paramFragment.getFragmentManager();
    Fragment localFragment = paramFragment.findFragmentByTag("date_picker_dialog");
    if ((localFragment instanceof i))
      ((i)localFragment).a(parama);
    paramFragment = paramFragment.findFragmentByTag("time_picker_dialog");
    if ((paramFragment instanceof k))
      ((k)paramFragment).a(parama1);
  }

  public static void a(Fragment paramFragment, KeepTime paramKeepTime, EventRecurrence paramEventRecurrence, KeepRecurrencePickerDialog.b paramb)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("bundle_event_start_time", paramKeepTime.op());
    if (paramEventRecurrence != null);
    for (paramKeepTime = paramEventRecurrence.toString(); ; paramKeepTime = "FREQ=DAILY")
    {
      localBundle.putString("bundle_event_rrule", paramKeepTime);
      KeepRecurrencePickerDialog.a(localBundle, paramb).show(paramFragment.getFragmentManager(), "recurrence_picker_dialog");
      return;
    }
  }

  public static void a(Fragment paramFragment, KeepTime paramKeepTime, i.a parama)
  {
    if (KeepApplication.aq())
    {
      s.c(parama, paramKeepTime.year, paramKeepTime.month, paramKeepTime.monthDay).show(paramFragment.getFragmentManager(), "date_picker_dialog");
      return;
    }
    paramKeepTime = i.a(parama, paramKeepTime.year, paramKeepTime.month, paramKeepTime.monthDay);
    parama = Calendar.getInstance();
    paramKeepTime.setYearRange(parama.get(1), parama.get(1) + 10);
    paramKeepTime.show(paramFragment.getFragmentManager(), "date_picker_dialog");
  }

  public static void a(Fragment paramFragment, KeepTime paramKeepTime, k.a parama)
  {
    if (KeepApplication.aq())
    {
      t.c(parama, paramKeepTime.hour, paramKeepTime.minute, DateFormat.is24HourFormat(paramFragment.getActivity())).show(paramFragment.getFragmentManager(), "time_picker_dialog");
      return;
    }
    parama = k.a(parama, paramKeepTime.hour, paramKeepTime.minute, DateFormat.is24HourFormat(paramFragment.getActivity()));
    parama.q(paramKeepTime.hour, paramKeepTime.minute);
    parama.show(paramFragment.getFragmentManager(), "time_picker_dialog");
  }

  public static boolean a(Task paramTask, long paramLong)
  {
    paramTask = e(paramTask.getDueDate());
    KeepTime localKeepTime = new KeepTime(paramLong);
    return (paramTask.jm() == localKeepTime.jm()) && (paramTask.oq() >= localKeepTime.oq() - Qa) && (paramTask.oq() <= localKeepTime.oq() + Qa);
  }

  public static String[] a(Context paramContext, int[] paramArrayOfInt)
  {
    Object localObject;
    if (paramArrayOfInt == null)
      localObject = null;
    String[] arrayOfString;
    int i;
    do
    {
      return localObject;
      arrayOfString = new String[paramArrayOfInt.length];
      i = 0;
      localObject = arrayOfString;
    }
    while (i >= paramArrayOfInt.length);
    int j = paramArrayOfInt[i];
    switch (j)
    {
    default:
      throw new IllegalArgumentException("Unknown reminder option: " + j);
    case 0:
      arrayOfString[i] = paramContext.getString(2131231141, new Object[] { DateUtils.formatDateTime(paramContext, cH(0).op(), 1) });
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      i += 1;
      break;
      arrayOfString[i] = paramContext.getString(2131231142, new Object[] { DateUtils.formatDateTime(paramContext, cH(1).op(), 1) });
      continue;
      localObject = cH(2);
      String str = DateUtils.formatDateTime(paramContext, ((KeepTime)localObject).op(), 1);
      switch (((KeepTime)localObject).weekDay)
      {
      default:
        break;
      case 0:
        arrayOfString[i] = paramContext.getString(2131231149, new Object[] { str });
        break;
      case 1:
        arrayOfString[i] = paramContext.getString(2131231143, new Object[] { str });
        break;
      case 2:
        arrayOfString[i] = paramContext.getString(2131231144, new Object[] { str });
        break;
      case 3:
        arrayOfString[i] = paramContext.getString(2131231145, new Object[] { str });
        break;
      case 4:
        arrayOfString[i] = paramContext.getString(2131231146, new Object[] { str });
        break;
      case 5:
        arrayOfString[i] = paramContext.getString(2131231147, new Object[] { str });
        break;
      case 6:
        arrayOfString[i] = paramContext.getString(2131231148, new Object[] { str });
        continue;
        arrayOfString[i] = paramContext.getString(2131231150);
        continue;
        arrayOfString[i] = paramContext.getString(2131231151);
      }
    }
  }

  public static int b(DateTime paramDateTime)
  {
    return e(paramDateTime).jm();
  }

  public static DateTime.Builder b(android.text.format.Time paramTime)
  {
    DateTime.Builder localBuilder = new DateTime.Builder();
    localBuilder.setDay(Integer.valueOf(monthDay));
    localBuilder.setMonth(Integer.valueOf(month + 1));
    localBuilder.setYear(Integer.valueOf(year));
    Time.Builder localBuilder1 = new Time.Builder();
    localBuilder1.setHour(Integer.valueOf(hour));
    localBuilder1.setMinute(Integer.valueOf(minute));
    localBuilder1.setSecond(Integer.valueOf(second));
    localBuilder.setTime(localBuilder1.build());
    return localBuilder;
  }

  public static String b(Context paramContext, BaseReminder paramBaseReminder)
  {
    if ((paramBaseReminder instanceof LocationReminder))
      return a(paramContext, (LocationReminder)paramBaseReminder);
    if ((paramBaseReminder instanceof TimeReminder))
      return a(paramContext, (TimeReminder)paramBaseReminder);
    return null;
  }

  public static String b(Context paramContext, TimeReminder paramTimeReminder)
  {
    Preconditions.checkNotNull(paramTimeReminder.getRecurrence());
    return a(paramContext.getResources(), com.google.android.keep.model.g.a(paramTimeReminder.getRecurrence()));
  }

  public static void b(Fragment paramFragment, String paramString1, String paramString2)
  {
    d.a(paramFragment, paramString1, paramString2).show(paramFragment.getFragmentManager(), "location_picker_dialog");
  }

  public static long c(DateTime paramDateTime)
  {
    if (paramDateTime.getAbsoluteTimeMs() != null)
      return e(paramDateTime).oq();
    if (paramDateTime.getTime() != null)
      return a(paramDateTime.getTime());
    return 0L;
  }

  public static String c(Context paramContext, BaseReminder paramBaseReminder)
  {
    if ((paramContext == null) || (paramBaseReminder == null));
    do
    {
      return null;
      if (paramBaseReminder.getType() == 0)
      {
        paramBaseReminder = (TimeReminder)paramBaseReminder;
        if (paramBaseReminder.jq())
          return paramContext.getString(2131231244);
        return paramContext.getString(2131231238, new Object[] { DateUtils.formatDateTime(paramContext, paramBaseReminder.jp(), 17) });
      }
    }
    while (paramBaseReminder.getType() != 1);
    return paramContext.getString(2131231239, new Object[] { ((LocationReminder)paramBaseReminder).s(paramContext) });
  }

  public static String c(Context paramContext, Note paramNote)
  {
    return a(paramContext, paramNote.getTitle(), paramNote.ir(), paramNote.im(), paramNote.ij(), paramNote.ii());
  }

  public static KeepTime cH(int paramInt)
  {
    KeepTime localKeepTime = new KeepTime();
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown Reminder Time Option: " + paramInt);
    case 0:
      localKeepTime.hour += 1;
    case 1:
    case 2:
    }
    while (true)
    {
      localKeepTime.on();
      return localKeepTime;
      localKeepTime.set(0, 0, U.kI(), localKeepTime.monthDay + 1, localKeepTime.month, localKeepTime.year);
      continue;
      localKeepTime.set(0, 0, U.kI(), localKeepTime.monthDay + 7, localKeepTime.month, localKeepTime.year);
    }
  }

  public static com.google.android.gms.reminders.model.Time d(TimeReminder.TimePeriod paramTimePeriod)
  {
    return new Time.Builder().setHour(Integer.valueOf(TimeReminder.TimePeriod.c(paramTimePeriod))).setMinute(Integer.valueOf(0)).setSecond(Integer.valueOf(0)).build();
  }

  public static TimeReminder.TimePeriod d(DateTime paramDateTime)
  {
    TimeReminder.TimePeriod localTimePeriod = TimeReminder.TimePeriod.zI;
    switch (paramDateTime.getPeriod().intValue())
    {
    default:
      return localTimePeriod;
    case 1:
      return TimeReminder.TimePeriod.zJ;
    case 2:
      return TimeReminder.TimePeriod.zK;
    case 3:
      return TimeReminder.TimePeriod.zL;
    case 4:
    }
    return TimeReminder.TimePeriod.zM;
  }

  public static KeepTime e(DateTime paramDateTime)
  {
    if (paramDateTime.getAbsoluteTimeMs() != null)
      return new KeepTime(paramDateTime.getAbsoluteTimeMs().longValue());
    KeepTime localKeepTime = new KeepTime();
    com.google.android.gms.reminders.model.Time localTime = paramDateTime.getTime();
    if (localTime != null)
    {
      localKeepTime.set(localTime.getSecond().intValue(), localTime.getMinute().intValue(), localTime.getHour().intValue(), paramDateTime.getDay().intValue(), paramDateTime.getMonth().intValue() - 1, paramDateTime.getYear().intValue());
      return localKeepTime;
    }
    if (paramDateTime.getPeriod() != null)
    {
      localKeepTime.set(0, 0, TimeReminder.TimePeriod.c(d(paramDateTime)), paramDateTime.getDay().intValue(), paramDateTime.getMonth().intValue() - 1, paramDateTime.getYear().intValue());
      return localKeepTime;
    }
    localKeepTime.set(0, 0, 0, paramDateTime.getDay().intValue(), paramDateTime.getMonth().intValue() - 1, paramDateTime.getYear().intValue());
    return localKeepTime;
  }

  public static DateTime n(Task paramTask)
  {
    if (paramTask.getDueDate() != null)
      paramTask = paramTask.getDueDate();
    Recurrence localRecurrence;
    DateTime localDateTime;
    do
    {
      return paramTask;
      if (paramTask.getRecurrenceInfo() == null)
        break;
      localRecurrence = paramTask.getRecurrenceInfo().getRecurrence();
      localDateTime = localRecurrence.getRecurrenceStart().getStartDateTime();
      paramTask = localDateTime;
    }
    while (localRecurrence.getDailyPattern() == null);
    paramTask = localRecurrence.getDailyPattern();
    return new DateTime.Builder(localDateTime).setTime(paramTask.getTimeOfDay()).setPeriod(paramTask.getDayPeriod()).build();
    return null;
  }

  public static boolean o(Task paramTask)
  {
    return Boolean.TRUE.equals(paramTask.getArchived());
  }
}