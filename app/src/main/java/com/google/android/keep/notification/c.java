package com.google.android.keep.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.InboxStyle;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.model.Location;
import com.google.android.keep.model.LocationReminder;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.Sharee;
import com.google.android.keep.model.TimeReminder;
import com.google.android.keep.model.TimeReminder.TimePeriod;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.m;
import com.google.android.keep.provider.i.c;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.sharing.SharingNotificationService;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.w;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static final c Br = new c();

  public static Notification a(Context paramContext, Intent paramIntent, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new NotificationCompat.Builder(paramContext).setContentTitle(paramContext.getString(paramInt1)).setContentText(paramContext.getString(paramInt2)).setSmallIcon(2130837685).setContentIntent(PendingIntent.getActivity(paramContext, 0, paramIntent, 134217728)).setAutoCancel(paramBoolean).build();
  }

  public static Notification a(Context paramContext, Note paramNote, com.google.android.keep.ui.c paramc)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    Resources localResources = paramContext.getResources();
    Sharee localSharee = paramNote.io();
    if (localSharee == null)
      return null;
    String str4 = localResources.getString(2131231347, new Object[] { localSharee.getDisplayName() });
    String str2 = d(paramNote);
    String str1;
    Object localObject;
    if (!TextUtils.isEmpty(paramNote.getTitle()))
    {
      str1 = paramNote.getTitle();
      if (paramNote.ir() == TreeEntity.TreeEntityType.zO)
      {
        String str3 = paramNote.getTitle();
        localObject = str3;
        if (!TextUtils.isEmpty(str2))
          localObject = str3 + "\n" + str2;
        a(localBuilder, str4, (String)localObject);
        localObject = str1;
      }
    }
    while (true)
    {
      paramc = paramc.m(localSharee.getEmail(), o.j(paramContext, paramNote.gp()));
      if (paramc != null)
        localBuilder.setLargeIcon(paramc);
      localBuilder.setContentTitle(str4).setContentText((CharSequence)localObject).setSmallIcon(2130837685).setContentIntent(a(paramContext, paramNote)).setDeleteIntent(b(paramContext, paramNote)).setPriority(0).setCategory("email").setColor(localResources.getColor(2131296431)).setVisibility(0).setAutoCancel(true);
      return localBuilder.build();
      localObject = str1;
      if (paramNote.im() != null)
      {
        localObject = str1;
        if (paramNote.im().length > 0)
        {
          localObject = a(paramNote.im());
          ((List)localObject).add(0, paramNote.getTitle());
          a(localBuilder, str4, (List)localObject);
          localObject = str1;
          continue;
          if (!TextUtils.isEmpty(str2))
          {
            str1 = str2;
            if (paramNote.ir() == TreeEntity.TreeEntityType.zO)
            {
              a(localBuilder, str4, str2);
              localObject = str1;
            }
            else
            {
              localObject = str1;
              if (paramNote.im() != null)
              {
                localObject = str1;
                if (paramNote.im().length > 0)
                {
                  a(localBuilder, str4, a(paramNote.im()));
                  localObject = str1;
                }
              }
            }
          }
          else if (paramNote.ij())
          {
            localObject = paramContext.getString(2131231264);
          }
          else if (paramNote.ii())
          {
            localObject = paramContext.getString(2131231265);
          }
          else if (paramNote.ir() == TreeEntity.TreeEntityType.zO)
          {
            localObject = paramContext.getString(2131231262);
          }
          else
          {
            localObject = null;
          }
        }
      }
    }
  }

  private static PendingIntent a(Context paramContext, int paramInt, long[] paramArrayOfLong, String paramString)
  {
    Intent localIntent = a(paramContext, DismissAlarmService.class, "com.google.android.keep.intent.action.DISMISS_NOTIFICATION", paramInt);
    localIntent.putExtra("com.google.android.keep.intent.extra.alert_ids", paramArrayOfLong);
    localIntent.putExtra("authAccount", paramString);
    return PendingIntent.getService(paramContext, 0, localIntent, 134217728);
  }

  private static PendingIntent a(Context paramContext, int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString)
  {
    Intent localIntent = a(paramContext, DismissAlarmService.class, "com.google.android.keep.intent.action.CLICK_NOTIFICATION", paramInt);
    localIntent.putExtra("com.google.android.keep.intent.extra.recent_reminder_ids", paramArrayOfLong1);
    localIntent.putExtra("com.google.android.keep.intent.extra.alert_ids", paramArrayOfLong2);
    localIntent.putExtra("authAccount", paramString);
    return PendingIntent.getService(paramContext, 0, localIntent, 134217728);
  }

  private static PendingIntent a(Context paramContext, Note paramNote)
  {
    String str = o.j(paramContext, paramNote.gp());
    Intent localIntent = new Intent(paramContext, BrowseActivity.class);
    localIntent.putExtra("authAccount", str);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("treeEntityId", paramNote.getId());
    localIntent.setData(ContentUris.withAppendedId(i.v.CONTENT_URI, paramNote.getId()));
    localIntent.setFlags(268468224);
    return PendingIntent.getActivity(paramContext, 0, localIntent, 134217728);
  }

  private static PendingIntent a(Context paramContext, String paramString, int paramInt, long paramLong, BaseReminder paramBaseReminder)
  {
    if ((paramBaseReminder.getType() == 0) && (((TimeReminder)paramBaseReminder).getRecurrence() != null))
      return null;
    Intent localIntent = a(paramContext, SnoozeAlarmActivity.class, "com.google.android.keep.intent.action.SNOOZE_NOTIFICATION", paramInt);
    localIntent.putExtra("authAccount", paramString);
    localIntent.putExtra("treeEntityId", paramLong);
    localIntent.putExtra("com.google.android.keep.intent.extra.reminder_id", paramBaseReminder.gq());
    localIntent.setFlags(268468224);
    return PendingIntent.getActivity(paramContext, 0, localIntent, 134217728);
  }

  private static PendingIntent a(Context paramContext, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2)
  {
    Intent localIntent = a(paramContext, SnoozeAlarmService.class, "com.google.android.keep.intent.action.SNOOZE_NOTIFICATION", paramInt1);
    localIntent.putExtra("action_mode", paramInt2);
    localIntent.putExtra("authAccount", paramString1);
    localIntent.putExtra("treeEntityId", paramLong);
    localIntent.putExtra("com.google.android.keep.intent.extra.reminder_id", paramString2);
    return PendingIntent.getService(paramContext, 0, localIntent, 134217728);
  }

  public static Intent a(Context paramContext, Class<?> paramClass, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, paramClass);
    localIntent.setAction(paramString);
    return localIntent;
  }

  private static Intent a(Context paramContext, Class<?> paramClass, String paramString, int paramInt)
  {
    paramContext = a(paramContext, paramClass, paramString);
    paramContext.setData(ContentUris.withAppendedId(i.c.CONTENT_URI, paramInt));
    paramContext.putExtra("com.google.android.keep.intent.extra.notification_id", paramInt);
    return paramContext;
  }

  private static NotificationCompat.Action a(Context paramContext, String paramString, Note paramNote, int paramInt, BaseReminder paramBaseReminder)
  {
    if (paramBaseReminder.getType() == 1)
      return new NotificationCompat.Action(2130837694, paramContext.getString(2131231269), a(paramContext, paramString, paramInt, paramNote.getId(), paramBaseReminder.gq(), 1));
    if ((paramBaseReminder.getType() == 0) && (((TimeReminder)paramBaseReminder).getRecurrence() == null))
      return new NotificationCompat.Action(2130837697, paramContext.getString(2131231268), a(paramContext, paramString, paramInt, paramNote.getId(), paramBaseReminder.gq(), 0));
    return null;
  }

  private static String a(Context paramContext, BaseReminder paramBaseReminder)
  {
    if (paramBaseReminder == null);
    do
    {
      return null;
      if (paramBaseReminder.getType() == 0)
      {
        paramBaseReminder = (TimeReminder)paramBaseReminder;
        return com.google.android.keep.util.g.a(paramContext, new KeepTime(paramBaseReminder.jp()), TimeReminder.TimePeriod.bm(paramBaseReminder.jo()));
      }
    }
    while (paramBaseReminder.getType() != 1);
    return paramContext.getString(2131231267, new Object[] { ((LocationReminder)paramBaseReminder).hZ().r(paramContext) });
  }

  private static List<String> a(m[] paramArrayOfm)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfm.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfm[i].getText());
      i += 1;
    }
    return localArrayList;
  }

  private static void a(NotificationCompat.Builder paramBuilder, String paramString1, String paramString2)
  {
    paramBuilder.setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(paramString1).bigText(paramString2));
  }

  private static void a(NotificationCompat.Builder paramBuilder, String paramString, List<String> paramList)
  {
    NotificationCompat.InboxStyle localInboxStyle = new NotificationCompat.InboxStyle();
    localInboxStyle.setBigContentTitle(paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
      localInboxStyle.addLine((String)paramString.next());
    paramBuilder.setStyle(localInboxStyle);
  }

  private static PendingIntent b(Context paramContext, Note paramNote)
  {
    return PendingIntent.getService(paramContext, 0, SharingNotificationService.f(paramContext, paramNote.getId()), 134217728);
  }

  private static PendingIntent c(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, WifiNotificationActivity.class);
    localIntent.setAction(paramString);
    return PendingIntent.getActivity(paramContext, 0, localIntent, 134217728);
  }

  private static String d(Note paramNote)
  {
    m[] arrayOfm = paramNote.im();
    if ((arrayOfm == null) || (arrayOfm.length == 0))
      return null;
    switch (1.rz[paramNote.ir().ordinal()])
    {
    default:
      return null;
    case 1:
      return arrayOfm[0].getText();
    case 2:
    }
    paramNote = new StringBuilder();
    int i = 0;
    if (i < arrayOfm.length)
    {
      String str = arrayOfm[i].getText();
      if (TextUtils.isEmpty(str));
      while (true)
      {
        i += 1;
        break;
        if (i > 0)
          paramNote.append("; ");
        paramNote.append(str);
      }
    }
    return paramNote.toString();
  }

  public static c ks()
  {
    return Br;
  }

  public static Notification u(Context paramContext)
  {
    PendingIntent localPendingIntent = c(paramContext, "com.google.android.keep.intent.action.WIFI_NOTIFICATION_GOTO_SETTINGS");
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    localBuilder.setContentTitle(paramContext.getString(2131231279)).setContentIntent(localPendingIntent).setDeleteIntent(c(paramContext, "com.google.android.keep.intent.action.WIFI_NOTIFICATION_DISMISS")).setSmallIcon(2130837685).setPriority(0).setCategory("err").setColor(paramContext.getResources().getColor(2131296431)).setVisibility(1).setAutoCancel(true);
    if (KeepApplication.aj())
    {
      new NotificationCompat.BigTextStyle(localBuilder).bigText(paramContext.getString(2131231280));
      localBuilder.setContentText(paramContext.getString(2131231280)).addAction(2130837736, paramContext.getString(2131231283), localPendingIntent).addAction(2130837656, paramContext.getString(2131231284), c(paramContext, "com.google.android.keep.intent.action.WIFI_NOTIFICATION_IGNORE"));
    }
    while (true)
    {
      return localBuilder.build();
      localBuilder.setContentText(paramContext.getString(2131231281)).setSubText(paramContext.getString(2131231282));
    }
  }

  public Notification a(Context paramContext, int paramInt, Note paramNote, BaseReminder paramBaseReminder, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramBaseReminder == null)
      return null;
    if ((paramBaseReminder.getType() != 1) && (paramBaseReminder.getType() != 0))
    {
      r.e("KeepNotification", "Unknown reminder type" + paramBaseReminder.getType(), new Object[0]);
      return null;
    }
    Object localObject1 = d(paramNote);
    Object localObject2 = a(paramContext, paramBaseReminder);
    Resources localResources = paramContext.getResources();
    Object localObject3;
    NotificationCompat.Builder localBuilder;
    NotificationCompat.WearableExtender localWearableExtender;
    String str;
    Object localObject4;
    int i;
    if (!TextUtils.isEmpty(paramNote.getTitle()))
    {
      localObject3 = paramNote.getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        localObject1 = localObject3;
        localBuilder = new NotificationCompat.Builder(paramContext);
        localWearableExtender = new NotificationCompat.WearableExtender();
        str = null;
        localObject4 = paramNote.ik();
        localObject3 = str;
        if (localObject4 != null)
        {
          localObject3 = str;
          if (localObject4.length > 0)
            localObject3 = w.fU().i(paramContext, ImageBlob.s(localObject4[0]));
        }
        str = o.j(paramContext, paramNote.gp());
        NotificationCompat.Action localAction = a(paramContext, str, paramNote, paramInt, paramBaseReminder);
        if (!KeepApplication.aj())
          break label940;
        localBuilder.setContentTitle((CharSequence)localObject1).setContentText((CharSequence)localObject2);
        if (localAction != null)
          localBuilder.addAction(localAction);
        paramBaseReminder = a(paramContext, str, paramInt, paramNote.getId(), paramBaseReminder);
        if (paramBaseReminder != null)
          localBuilder.addAction(2130837692, paramContext.getString(2131231270), paramBaseReminder);
        if (localObject3 == null)
          break label815;
        i = localResources.getDimensionPixelSize(2131427572);
        localBuilder.setLargeIcon(com.google.android.keep.provider.g.a(paramContext.getContentResolver(), ImageBlob.s(localObject4[0]), i, i));
        localBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture((Bitmap)localObject3).bigLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), 2130837692)).setSummaryText((CharSequence)localObject2));
        label343: long l = paramNote.getId();
        paramBaseReminder = new long[1];
        paramBaseReminder[0] = paramLong1;
        if (!paramBoolean)
          localBuilder.setDefaults(-1);
        localBuilder.setSmallIcon(2130837685).setDeleteIntent(a(paramContext, paramInt, paramBaseReminder, str)).setContentIntent(a(paramContext, paramInt, new long[] { l }, paramBaseReminder, str)).setPriority(1).setCategory("event").setColor(localResources.getColor(2131296431)).setVisibility(0).setWhen(paramLong2);
        if (localAction != null)
          localWearableExtender.addAction(localAction);
        paramBaseReminder = new Intent();
        paramBaseReminder.setClass(paramContext, WearableArchiveService.class);
        paramBaseReminder.setData(ContentUris.withAppendedId(i.c.CONTENT_URI, paramInt));
        paramBaseReminder.putExtra("treeEntityId", paramNote.getId());
        paramBaseReminder.putExtra("com.google.android.keep.intent.extra.notification_id", paramInt);
        paramBaseReminder.putExtra("com.google.android.keep.intent.extra.alert_id", paramLong1);
        localWearableExtender.addAction(new NotificationCompat.Action(2130837647, paramContext.getString(2131231072), PendingIntent.getService(paramContext, 0, paramBaseReminder, 134217728)));
        paramBaseReminder = new Intent();
        paramBaseReminder.setClass(paramContext, WearableNotificationOpenService.class);
        paramBaseReminder.setData(ContentUris.withAppendedId(i.c.CONTENT_URI, paramInt));
        paramBaseReminder.putExtra("treeEntityId", paramNote.getId());
        paramBaseReminder = new NotificationCompat.Action(2130837633, paramContext.getString(2131231271), PendingIntent.getService(paramContext, 0, paramBaseReminder, 134217728));
        if (paramNote.ir() == TreeEntity.TreeEntityType.zP)
          localWearableExtender.addAction(paramBaseReminder);
        if (localObject3 != null)
          break label1029;
        paramInt = new GregorianCalendar().get(11);
        if ((paramInt >= 4) && (paramInt <= 19))
          break label1017;
        paramInt = 1;
        label674: paramContext = paramContext.getResources();
        if (paramInt == 0)
          break label1022;
        paramInt = 2130837569;
        label687: localWearableExtender.setBackground(BitmapFactory.decodeResource(paramContext, paramInt));
      }
    }
    while (true)
    {
      return localBuilder.extend(localWearableExtender).build();
      localObject1 = localObject3;
      break;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
        break;
      if (paramNote.ij())
        localObject1 = paramContext.getString(2131231264);
      while (true)
      {
        break;
        if (paramNote.ii())
          localObject1 = paramContext.getString(2131231265);
        else if (paramNote.ip())
          localObject1 = paramContext.getString(2131231266);
        else if (paramNote.ir() == TreeEntity.TreeEntityType.zO)
          localObject1 = paramContext.getString(2131231262);
        else
          localObject1 = paramContext.getString(2131231263);
      }
      label815: if (paramNote.ir() == TreeEntity.TreeEntityType.zP)
      {
        paramBaseReminder = new NotificationCompat.InboxStyle();
        paramBaseReminder.setBigContentTitle(paramNote.getTitle());
        localObject1 = paramNote.im();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          i = 0;
          while (i < j)
          {
            paramBaseReminder.addLine(localObject1[i].getText());
            i += 1;
          }
        }
        localBuilder.setStyle(paramBaseReminder);
        break label343;
      }
      paramBaseReminder = new NotificationCompat.BigTextStyle();
      paramBaseReminder.setBigContentTitle((CharSequence)localObject1);
      paramBaseReminder.bigText((CharSequence)localObject2);
      localBuilder.setStyle(paramBaseReminder);
      break label343;
      label940: localObject4 = new RemoteViews(paramContext.getPackageName(), 2130968727);
      ((RemoteViews)localObject4).setTextViewText(2131492986, (CharSequence)localObject1);
      ((RemoteViews)localObject4).setTextViewText(2131493145, (CharSequence)localObject2);
      localBuilder.setContent((RemoteViews)localObject4);
      paramBaseReminder = a(paramContext, str, paramInt, paramNote.getId(), paramBaseReminder);
      if (paramBaseReminder == null)
        break label343;
      ((RemoteViews)localObject4).setOnClickPendingIntent(2131493274, paramBaseReminder);
      break label343;
      label1017: paramInt = 0;
      break label674;
      label1022: paramInt = 2130837568;
      break label687;
      label1029: localWearableExtender.setBackground((Bitmap)localObject3);
    }
  }

  public Notification a(Context paramContext, int paramInt, List<Note> paramList, List<Long> paramList1, long paramLong, boolean paramBoolean)
  {
    if (paramList.size() != paramList1.size())
      throw new IllegalArgumentException("note size and alert size does not match! " + paramList.size() + " " + paramList1.size());
    int j = paramList.size();
    Object localObject1 = new long[j];
    int i = 0;
    while (i < j)
    {
      localObject1[i] = ((Note)paramList.get(i)).getId();
      i += 1;
    }
    Object localObject2 = e.G(paramList1);
    paramList1 = o.j(paramContext, ((Note)paramList.get(0)).gp());
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    Object localObject3 = String.format(paramContext.getResources().getQuantityString(2131755034, j), new Object[] { Integer.valueOf(j) });
    Resources localResources = paramContext.getResources();
    localBuilder.setContentTitle((CharSequence)localObject3).setSmallIcon(2130837685).setContentText(paramList1).setDeleteIntent(a(paramContext, paramInt, (long[])localObject2, paramList1)).setContentIntent(a(paramContext, paramInt, (long[])localObject1, (long[])localObject2, paramList1)).setPriority(0).setCategory("event").setColor(localResources.getColor(2131296431)).setVisibility(0).setWhen(paramLong);
    if (!paramBoolean)
      localBuilder.setDefaults(-1);
    localObject1 = new NotificationCompat.InboxStyle(localBuilder);
    localObject2 = paramList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Note)((Iterator)localObject2).next();
      paramList = d((Note)localObject3);
      if (!TextUtils.isEmpty(((Note)localObject3).getTitle()))
        paramList = ((Note)localObject3).getTitle();
      while (true)
      {
        ((NotificationCompat.InboxStyle)localObject1).addLine(paramList);
        break;
        if (TextUtils.isEmpty(paramList))
          if (((Note)localObject3).ij())
            paramList = paramContext.getString(2131231264);
          else if (((Note)localObject3).ii())
            paramList = paramContext.getString(2131231265);
          else if (((Note)localObject3).ip())
            paramList = paramContext.getString(2131231266);
          else if (((Note)localObject3).ir() == TreeEntity.TreeEntityType.zO)
            paramList = paramContext.getString(2131231262);
          else
            paramList = paramContext.getString(2131231263);
      }
    }
    ((NotificationCompat.InboxStyle)localObject1).setSummaryText(paramList1);
    return localBuilder.build();
  }
}