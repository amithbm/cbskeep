package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.util.zzc;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil
{

  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzoo();
  public static boolean zzagn = false;
  public static boolean zzago = false;
  private static int zzagp = -1;
  private static String zzagq = null;
  private static Integer zzagr = null;
  static final AtomicBoolean zzags = new AtomicBoolean();
  private static final Object zzpB = new Object();

  @Deprecated
  public static int getApkVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 0;
  }

  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }

  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return zza(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }

  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    Intent localIntent = getGooglePlayServicesAvailabilityRecoveryIntent(paramInt1);
    if (localIntent == null)
      return null;
    return PendingIntent.getActivity(paramContext, paramInt2, localIntent, 268435456);
  }

  @Deprecated
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    case 2:
      return com.google.android.gms.common.internal.zzn.zzcb("com.google.android.gms");
    case 42:
      return com.google.android.gms.common.internal.zzn.zzpY();
    case 3:
    }
    return com.google.android.gms.common.internal.zzn.zzbZ("com.google.android.gms");
  }

  public static boolean honorsDebugCertificates(PackageManager paramPackageManager)
  {
    return (zzb(paramPackageManager)) || (!zzop());
  }

  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    if (zzd.zzakB)
      return 0;
    PackageManager localPackageManager = paramContext.getPackageManager();
    GoogleSignatureVerifier localGoogleSignatureVerifier;
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if (!"com.google.android.gms".equals(paramContext.getPackageName()))
        zzae(paramContext);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
        localGoogleSignatureVerifier = GoogleSignatureVerifier.getInstance();
        if ((zzc.zzfm(localPackageInfo.versionCode)) || (zzc.zzap(paramContext)))
        {
          if (localGoogleSignatureVerifier.zza(localPackageInfo, zzc.zzbk.zzagm) != null)
            break label233;
          Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
          return 9;
          localThrowable = localThrowable;
          Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
        return 1;
      }
    }
    try
    {
      zzc.zza localzza = localGoogleSignatureVerifier.zza(localPackageManager.getPackageInfo("com.android.vending", 64), zzc.zzbk.zzagm);
      if (localzza == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (zzl(paramContext, "com.android.vending"))
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store is updating.");
        if (localGoogleSignatureVerifier.zza(localThrowable, zzc.zzbk.zzagm) == null)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
          return 9;
          if (localGoogleSignatureVerifier.zza(localThrowable, new zzc.zza[] { localNameNotFoundException }) == null)
          {
            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
            return 9;
          }
        }
      }
      else
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
        return 9;
      }
    }
    label233: int i = zzc.zzfk(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    if (zzc.zzfk(localThrowable.versionCode) < i)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + localThrowable.versionCode);
      return 2;
    }
    ApplicationInfo localApplicationInfo = localThrowable.applicationInfo;
    paramContext = localApplicationInfo;
    if (localApplicationInfo == null);
    try
    {
      paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      if (!enabled)
        return 3;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
      paramContext.printStackTrace();
      return 1;
    }
    return 0;
  }

  @Deprecated
  public static boolean isPackageGoogleSigned(PackageManager paramPackageManager, String paramString)
  {
    return GoogleSignatureVerifier.getInstance().isPackageGoogleSigned(paramPackageManager, paramString);
  }

  @Deprecated
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 18)
      return true;
    if (paramInt == 1)
      return zzl(paramContext, "com.google.android.gms");
    return false;
  }

  @Deprecated
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 9)
      return zzl(paramContext, "com.android.vending");
    return false;
  }

  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 9:
    }
    return true;
  }

  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }

  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }

  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    int i = 0;
    paramFragment = zza(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    if (paramFragment == null)
      return false;
    try
    {
      boolean bool = paramActivity instanceof FragmentActivity;
      i = bool;
      label29: if (i != 0)
      {
        paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
        SupportErrorDialogFragment.newInstance(paramFragment, paramOnCancelListener).show(paramActivity, "GooglePlayServicesErrorDialog");
      }
      while (true)
      {
        return true;
        if (!com.google.android.gms.common.util.zzn.zzqK())
          break;
        paramActivity = paramActivity.getFragmentManager();
        ErrorDialogFragment.newInstance(paramFragment, paramOnCancelListener).show(paramActivity, "GooglePlayServicesErrorDialog");
      }
      throw new RuntimeException("This Activity does not support Fragments.");
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      break label29;
    }
  }

  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    int i = paramInt;
    if (zzc.zzap(paramContext))
    {
      i = paramInt;
      if (paramInt == 2)
        i = 42;
    }
    if ((isPlayServicesPossiblyUpdating(paramContext, i)) || (isPlayStorePossiblyUpdating(paramContext, i)))
    {
      zzaf(paramContext);
      return;
    }
    zza(i, paramContext);
  }

  @Deprecated
  public static void verifyPackageIsGoogleSigned(PackageManager paramPackageManager, String paramString)
    throws SecurityException
  {
    GoogleSignatureVerifier.getInstance().verifyPackageIsGoogleSigned(paramPackageManager, paramString);
  }

  @Deprecated
  public static void zzY(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      paramContext = getGooglePlayServicesAvailabilityRecoveryIntent(i);
      Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + i);
      if (paramContext == null)
        throw new GooglePlayServicesNotAvailableException(i);
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }

  private static Dialog zza(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject2 = null;
    if (paramInt1 == 0)
      return null;
    int i = paramInt1;
    if (zzc.zzap(paramActivity))
    {
      i = paramInt1;
      if (paramInt1 == 2)
        i = 42;
    }
    Object localObject1 = localObject2;
    if (com.google.android.gms.common.util.zzn.zzqN())
    {
      TypedValue localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, localTypedValue, true);
      localObject1 = localObject2;
      if ("Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(localTypedValue.resourceId)))
        localObject1 = new AlertDialog.Builder(paramActivity, 5);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
      localObject2 = new AlertDialog.Builder(paramActivity);
    ((AlertDialog.Builder)localObject2).setMessage(zzg.zzb(paramActivity, i, zzah(paramActivity)));
    if (paramOnCancelListener != null)
      ((AlertDialog.Builder)localObject2).setOnCancelListener(paramOnCancelListener);
    paramOnCancelListener = getGooglePlayServicesAvailabilityRecoveryIntent(i);
    if (paramFragment == null);
    for (paramFragment = new zzh(paramActivity, paramOnCancelListener, paramInt2); ; paramFragment = new zzh(paramFragment, paramOnCancelListener, paramInt2))
    {
      paramOnCancelListener = zzg.zzg(paramActivity, i);
      if (paramOnCancelListener != null)
        ((AlertDialog.Builder)localObject2).setPositiveButton(paramOnCancelListener, paramFragment);
      paramActivity = zzg.zzf(paramActivity, i);
      if (paramActivity != null)
        ((AlertDialog.Builder)localObject2).setTitle(paramActivity);
      return ((AlertDialog.Builder)localObject2).create();
    }
  }

  private static void zza(int paramInt, Context paramContext)
  {
    zza(paramInt, paramContext, null);
  }

  private static void zza(int paramInt, Context paramContext, String paramString)
  {
    Resources localResources = paramContext.getResources();
    String str = zzah(paramContext);
    Object localObject2 = zzg.zzh(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
      localObject1 = localResources.getString(R.string.common_google_play_services_notification_ticker);
    str = zzg.zzc(paramContext, paramInt, str);
    PendingIntent localPendingIntent = getErrorPendingIntent(paramInt, paramContext, 0);
    if (zzc.zzap(paramContext))
    {
      zzv.zzR(com.google.android.gms.common.util.zzn.zzqO());
      localObject1 = new Notification.Builder(paramContext).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText((String)localObject1 + " " + str)).addAction(R.drawable.common_full_open_on_phone, localResources.getString(R.string.common_open_on_phone), localPendingIntent).build();
      if (!zzem(paramInt))
        break label358;
      zzags.set(false);
    }
    label358: for (paramInt = 10436; ; paramInt = 39789)
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramString == null)
        break label365;
      paramContext.notify(paramString, paramInt, (Notification)localObject1);
      return;
      localObject2 = localResources.getString(R.string.common_google_play_services_notification_ticker);
      if (com.google.android.gms.common.util.zzn.zzqK())
      {
        localObject1 = new Notification.Builder(paramContext).setSmallIcon(17301642).setContentTitle((CharSequence)localObject1).setContentText(str).setContentIntent(localPendingIntent).setTicker((CharSequence)localObject2).setAutoCancel(true);
        if (com.google.android.gms.common.util.zzn.zzqS())
          ((Notification.Builder)localObject1).setLocalOnly(true);
        if (com.google.android.gms.common.util.zzn.zzqO())
          ((Notification.Builder)localObject1).setStyle(new Notification.BigTextStyle().bigText(str));
        for (localObject1 = ((Notification.Builder)localObject1).build(); ; localObject1 = ((Notification.Builder)localObject1).getNotification())
        {
          if (Build.VERSION.SDK_INT == 19)
            ((Notification)localObject1).extras.putBoolean("android.support.localOnly", true);
          break;
        }
      }
      localObject2 = new Notification(17301642, (CharSequence)localObject2, System.currentTimeMillis());
      ((Notification)localObject2).flags |= 16;
      ((Notification)localObject2).setLatestEventInfo(paramContext, (CharSequence)localObject1, str, localPendingIntent);
      localObject1 = localObject2;
      break;
    }
    label365: paramContext.notify(paramInt, (Notification)localObject1);
  }

  public static boolean zza(Context paramContext, int paramInt, String paramString)
  {
    boolean bool2 = false;
    if (com.google.android.gms.common.util.zzn.zzqR())
      paramContext = (AppOpsManager)paramContext.getSystemService("appops");
    try
    {
      paramContext.checkPackage(paramInt, paramString);
      boolean bool1 = true;
      do
      {
        do
        {
          return bool1;
          paramContext = paramContext.getPackageManager().getPackagesForUid(paramInt);
          bool1 = bool2;
        }
        while (paramString == null);
        bool1 = bool2;
      }
      while (paramContext == null);
      paramInt = 0;
      while (true)
      {
        bool1 = bool2;
        if (paramInt >= paramContext.length)
          break;
        if (paramString.equals(paramContext[paramInt]))
          return true;
        paramInt += 1;
      }
    }
    catch (SecurityException paramContext)
    {
    }
    return false;
  }

  private static void zzae(Context paramContext)
  {
    while (true)
    {
      synchronized (zzpB)
      {
        if (zzagq == null)
        {
          zzagq = paramContext.getPackageName();
          try
          {
            paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
            if (paramContext != null)
            {
              zzagr = Integer.valueOf(paramContext.getInt("com.google.android.gms.version"));
              paramContext = zzagr;
              if (paramContext != null)
                break;
              throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            zzagr = null;
            continue;
          }
          catch (PackageManager.NameNotFoundException paramContext)
          {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", paramContext);
            continue;
          }
        }
      }
      if (!zzagq.equals(paramContext.getPackageName()))
        throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzagq + "' and this call used package '" + paramContext.getPackageName() + "'.");
    }
    if (paramContext.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE)
      throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but" + " found " + paramContext + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
  }

  private static void zzaf(Context paramContext)
  {
    paramContext = new zza(paramContext);
    paramContext.sendMessageDelayed(paramContext.obtainMessage(1), 120000L);
  }

  @Deprecated
  public static void zzag(Context paramContext)
  {
    if (zzags.getAndSet(true))
      return;
    try
    {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(10436);
      return;
    }
    catch (SecurityException paramContext)
    {
    }
  }

  public static String zzah(Context paramContext)
  {
    Object localObject2 = paramContext.getApplicationInfo().name;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = paramContext.getPackageName();
      localObject2 = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      paramContext = ((PackageManager)localObject2).getApplicationInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
        localObject1 = ((PackageManager)localObject2).getApplicationLabel(paramContext).toString();
      return localObject1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      while (true)
        paramContext = null;
    }
  }

  public static boolean zzb(PackageManager paramPackageManager)
  {
    synchronized (zzpB)
    {
      int i = zzagp;
      if (i == -1);
      try
      {
        paramPackageManager = paramPackageManager.getPackageInfo("com.google.android.gms", 64);
        if (GoogleSignatureVerifier.getInstance().zza(paramPackageManager, new zzc.zza[] { zzc.zzagf[1] }) != null);
        for (zzagp = 1; zzagp != 0; zzagp = 0)
          return true;
      }
      catch (PackageManager.NameNotFoundException paramPackageManager)
      {
        while (true)
          zzagp = 0;
      }
    }
    return false;
  }

  public static boolean zze(Context paramContext, int paramInt)
  {
    return (zza(paramContext, paramInt, "com.google.android.gms")) && (isPackageGoogleSigned(paramContext.getPackageManager(), "com.google.android.gms"));
  }

  private static boolean zzem(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 18:
    case 42:
    }
    return true;
  }

  public static boolean zzl(Context paramContext, String paramString)
  {
    if (com.google.android.gms.common.util.zzn.zzqT())
    {
      paramContext = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      do
        if (!paramContext.hasNext())
          break;
      while (!paramString.equals(((PackageInstaller.SessionInfo)paramContext.next()).getAppPackageName()));
      return true;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      boolean bool = paramContext.getApplicationInfo(paramString, 8192).enabled;
      if (bool)
        return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
    }
    return false;
  }

  private static int zzoo()
  {
    return 7571000;
  }

  public static boolean zzop()
  {
    if (zzagn)
      return zzago;
    return "user".equals(Build.TYPE);
  }

  private static class zza extends Handler
  {
    private final Context zzrb;

    zza(Context paramContext)
    {
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + paramMessage.what);
      case 1:
      }
      int i;
      do
      {
        return;
        i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzrb);
      }
      while (!GooglePlayServicesUtil.isUserRecoverableError(i));
      GooglePlayServicesUtil.zzb(i, zzrb);
    }
  }
}