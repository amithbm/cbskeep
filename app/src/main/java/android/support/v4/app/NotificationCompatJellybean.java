package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class NotificationCompatJellybean
{
  private static final Object sActionsLock = new Object();
  private static Field sExtrasField;
  private static boolean sExtrasFieldAccessFailed;
  private static final Object sExtrasLock = new Object();

  public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, CharSequence paramCharSequence1, boolean paramBoolean1, CharSequence paramCharSequence2, Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean2)
  {
    paramNotificationBuilderWithBuilderAccessor = new Notification.BigPictureStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(paramCharSequence1).bigPicture(paramBitmap1);
    if (paramBoolean2)
      paramNotificationBuilderWithBuilderAccessor.bigLargeIcon(paramBitmap2);
    if (paramBoolean1)
      paramNotificationBuilderWithBuilderAccessor.setSummaryText(paramCharSequence2);
  }

  public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    paramNotificationBuilderWithBuilderAccessor = new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(paramCharSequence1).bigText(paramCharSequence3);
    if (paramBoolean)
      paramNotificationBuilderWithBuilderAccessor.setSummaryText(paramCharSequence2);
  }

  public static void addInboxStyle(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, ArrayList<CharSequence> paramArrayList)
  {
    paramNotificationBuilderWithBuilderAccessor = new Notification.InboxStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(paramCharSequence1);
    if (paramBoolean)
      paramNotificationBuilderWithBuilderAccessor.setSummaryText(paramCharSequence2);
    paramCharSequence1 = paramArrayList.iterator();
    while (paramCharSequence1.hasNext())
      paramNotificationBuilderWithBuilderAccessor.addLine((CharSequence)paramCharSequence1.next());
  }

  public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> paramList)
  {
    Object localObject1 = null;
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      Bundle localBundle = (Bundle)paramList.get(i);
      Object localObject2 = localObject1;
      if (localBundle != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
          localObject2 = new SparseArray();
        ((SparseArray)localObject2).put(i, localBundle);
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }

  private static Bundle getBundleForAction(NotificationCompatBase.Action paramAction)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("icon", paramAction.getIcon());
    localBundle.putCharSequence("title", paramAction.getTitle());
    localBundle.putParcelable("actionIntent", paramAction.getActionIntent());
    localBundle.putBundle("extras", paramAction.getExtras());
    localBundle.putParcelableArray("remoteInputs", RemoteInputCompatJellybean.toBundleArray(paramAction.getRemoteInputs()));
    return localBundle;
  }

  public static Bundle getExtras(Notification paramNotification)
  {
    synchronized (sExtrasLock)
    {
      if (sExtrasFieldAccessFailed)
        return null;
    }
    try
    {
      if (sExtrasField == null)
      {
        localObject1 = Notification.class.getDeclaredField("extras");
        if (!Bundle.class.isAssignableFrom(((Field)localObject1).getType()))
        {
          Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
          sExtrasFieldAccessFailed = true;
          return null;
        }
        ((Field)localObject1).setAccessible(true);
        sExtrasField = (Field)localObject1;
      }
      Bundle localBundle = (Bundle)sExtrasField.get(paramNotification);
      Object localObject1 = localBundle;
      if (localBundle == null)
      {
        localObject1 = new Bundle();
        sExtrasField.set(paramNotification, localObject1);
      }
      return localObject1;
      paramNotification = finally;
      throw paramNotification;
    }
    catch (IllegalAccessException paramNotification)
    {
      Log.e("NotificationCompat", "Unable to access notification extras", paramNotification);
      sExtrasFieldAccessFailed = true;
      return null;
    }
    catch (NoSuchFieldException paramNotification)
    {
      while (true)
        Log.e("NotificationCompat", "Unable to access notification extras", paramNotification);
    }
  }

  public static ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompatBase.Action[] paramArrayOfAction)
  {
    Object localObject;
    if (paramArrayOfAction == null)
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfAction.length);
    int j = paramArrayOfAction.length;
    int i = 0;
    while (true)
    {
      localObject = localArrayList;
      if (i >= j)
        break;
      localArrayList.add(getBundleForAction(paramArrayOfAction[i]));
      i += 1;
    }
  }

  public static Bundle writeActionAndGetExtras(Notification.Builder paramBuilder, NotificationCompatBase.Action paramAction)
  {
    paramBuilder.addAction(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
    paramBuilder = new Bundle(paramAction.getExtras());
    if (paramAction.getRemoteInputs() != null)
      paramBuilder.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.toBundleArray(paramAction.getRemoteInputs()));
    return paramBuilder;
  }

  public static class Builder
    implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor
  {
    private Notification.Builder b;
    private List<Bundle> mActionExtrasList = new ArrayList();
    private final Bundle mExtras;

    public Builder(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean3, Bundle paramBundle, String paramString1, boolean paramBoolean4, String paramString2)
    {
      paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
      boolean bool;
      if ((paramNotification.flags & 0x2) != 0)
      {
        bool = true;
        paramContext = paramContext.setOngoing(bool);
        if ((paramNotification.flags & 0x8) == 0)
          break label337;
        bool = true;
        label123: paramContext = paramContext.setOnlyAlertOnce(bool);
        if ((paramNotification.flags & 0x10) == 0)
          break label343;
        bool = true;
        label143: paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
        if ((paramNotification.flags & 0x80) == 0)
          break label349;
        bool = true;
        label202: b = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
        mExtras = new Bundle();
        if (paramBundle != null)
          mExtras.putAll(paramBundle);
        if (paramBoolean3)
          mExtras.putBoolean("android.support.localOnly", true);
        if (paramString1 != null)
        {
          mExtras.putString("android.support.groupKey", paramString1);
          if (!paramBoolean4)
            break label355;
          mExtras.putBoolean("android.support.isGroupSummary", true);
        }
      }
      while (true)
      {
        if (paramString2 != null)
          mExtras.putString("android.support.sortKey", paramString2);
        return;
        bool = false;
        break;
        label337: bool = false;
        break label123;
        label343: bool = false;
        break label143;
        label349: bool = false;
        break label202;
        label355: mExtras.putBoolean("android.support.useSideChannel", true);
      }
    }

    public void addAction(NotificationCompatBase.Action paramAction)
    {
      mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(b, paramAction));
    }

    public Notification build()
    {
      Notification localNotification = b.build();
      Object localObject = NotificationCompatJellybean.getExtras(localNotification);
      Bundle localBundle = new Bundle(mExtras);
      Iterator localIterator = mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((Bundle)localObject).containsKey(str))
          localBundle.remove(str);
      }
      ((Bundle)localObject).putAll(localBundle);
      localObject = NotificationCompatJellybean.buildActionExtrasMap(mActionExtrasList);
      if (localObject != null)
        NotificationCompatJellybean.getExtras(localNotification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
      return localNotification;
    }

    public Notification.Builder getBuilder()
    {
      return b;
    }
  }
}