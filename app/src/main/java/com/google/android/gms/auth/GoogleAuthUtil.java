package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.Status;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;

public final class GoogleAuthUtil
{
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  private static final ComponentName zzQx;
  private static final ComponentName zzQy;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      KEY_CALLER_UID = "callerUid";
      if (Build.VERSION.SDK_INT < 14)
        break label58;
    }
    label58: 
    while (true)
    {
      KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
      zzQx = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      zzQy = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      return;
      break;
    }
  }

  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return zza(paramContext, paramAccount, paramString, paramBundle).getString("authtoken");
  }

  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null)
      localBundle = new Bundle();
    localBundle.putBoolean("handle_notification", true);
    return zzb(paramContext, paramAccount, paramString, localBundle);
  }

  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString1, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (TextUtils.isEmpty(paramString2))
      throw new IllegalArgumentException("Authority cannot be empty or null.");
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null)
      localBundle = new Bundle();
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null)
      paramBundle1 = new Bundle();
    ContentResolver.validateSyncExtrasBundle(paramBundle1);
    localBundle.putString("authority", paramString2);
    localBundle.putBundle("sync_extras", paramBundle1);
    localBundle.putBoolean("handle_notification", true);
    return zzb(paramContext, paramAccount, paramString1, localBundle);
  }

  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }

  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle1, paramString3, paramBundle2);
  }

  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }

  private static void zzY(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.zzY(paramContext);
      return;
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(paramContext.getConnectionStatusCode(), paramContext.getMessage(), paramContext.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
    }
    throw new GoogleAuthException(paramContext.getMessage());
  }

  // ERROR //
  public static Bundle zza(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 172	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 5
    //   6: ldc 174
    //   8: invokestatic 179	com/google/android/gms/common/internal/zzv:zzbU	(Ljava/lang/String;)V
    //   11: aload 5
    //   13: invokestatic 180	com/google/android/gms/auth/GoogleAuthUtil:zzY	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +148 -> 165
    //   20: new 59	android/os/Bundle
    //   23: dup
    //   24: invokespecial 69	android/os/Bundle:<init>	()V
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 184	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   32: getfield 189	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: ldc 191
    //   39: aload_0
    //   40: invokevirtual 103	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: getstatic 26	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   47: invokevirtual 63	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +11 -> 64
    //   56: aload_3
    //   57: getstatic 26	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   60: aload_0
    //   61: invokevirtual 103	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: new 193	com/google/android/gms/common/zza
    //   67: dup
    //   68: invokespecial 194	com/google/android/gms/common/zza:<init>	()V
    //   71: astore_0
    //   72: aload 5
    //   74: invokestatic 200	com/google/android/gms/common/internal/zzl:zzal	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/zzl;
    //   77: astore 5
    //   79: aload 5
    //   81: getstatic 38	com/google/android/gms/auth/GoogleAuthUtil:zzQx	Landroid/content/ComponentName;
    //   84: aload_0
    //   85: ldc 202
    //   87: invokevirtual 205	com/google/android/gms/common/internal/zzl:zza	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   90: ifeq +187 -> 277
    //   93: aload_0
    //   94: invokevirtual 209	com/google/android/gms/common/zza:zzok	()Landroid/os/IBinder;
    //   97: invokestatic 214	com/google/android/gms/internal/zzau$zza:zza	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzau;
    //   100: aload_1
    //   101: aload_2
    //   102: aload_3
    //   103: invokeinterface 219 4 0
    //   108: astore_2
    //   109: aload_2
    //   110: ifnonnull +67 -> 177
    //   113: ldc 202
    //   115: ldc 221
    //   117: invokestatic 227	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   120: pop
    //   121: new 51	com/google/android/gms/auth/GoogleAuthException
    //   124: dup
    //   125: ldc 229
    //   127: invokespecial 162	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    //   131: astore_1
    //   132: ldc 202
    //   134: ldc 231
    //   136: aload_1
    //   137: invokestatic 235	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   140: pop
    //   141: new 47	java/io/IOException
    //   144: dup
    //   145: ldc 237
    //   147: invokespecial 238	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   150: athrow
    //   151: astore_1
    //   152: aload 5
    //   154: getstatic 38	com/google/android/gms/auth/GoogleAuthUtil:zzQx	Landroid/content/ComponentName;
    //   157: aload_0
    //   158: ldc 202
    //   160: invokevirtual 241	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   163: aload_1
    //   164: athrow
    //   165: new 59	android/os/Bundle
    //   168: dup
    //   169: aload_3
    //   170: invokespecial 243	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   173: astore_3
    //   174: goto -146 -> 28
    //   177: aload_2
    //   178: ldc 57
    //   180: invokevirtual 63	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: istore 4
    //   188: iload 4
    //   190: ifne +16 -> 206
    //   193: aload 5
    //   195: getstatic 38	com/google/android/gms/auth/GoogleAuthUtil:zzQx	Landroid/content/ComponentName;
    //   198: aload_0
    //   199: ldc 202
    //   201: invokevirtual 241	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   204: aload_2
    //   205: areturn
    //   206: aload_2
    //   207: ldc 245
    //   209: invokevirtual 63	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore_1
    //   213: aload_2
    //   214: ldc 247
    //   216: invokevirtual 251	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   219: checkcast 253	android/content/Intent
    //   222: astore_2
    //   223: aload_1
    //   224: invokestatic 257	com/google/android/gms/auth/GoogleAuthUtil:zzbe	(Ljava/lang/String;)Z
    //   227: ifeq +25 -> 252
    //   230: new 49	com/google/android/gms/auth/UserRecoverableAuthException
    //   233: dup
    //   234: aload_1
    //   235: aload_2
    //   236: invokespecial 260	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   239: athrow
    //   240: astore_1
    //   241: new 51	com/google/android/gms/auth/GoogleAuthException
    //   244: dup
    //   245: ldc_w 262
    //   248: invokespecial 162	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   251: athrow
    //   252: aload_1
    //   253: invokestatic 265	com/google/android/gms/auth/GoogleAuthUtil:zzbd	(Ljava/lang/String;)Z
    //   256: ifeq +12 -> 268
    //   259: new 47	java/io/IOException
    //   262: dup
    //   263: aload_1
    //   264: invokespecial 238	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   267: athrow
    //   268: new 51	com/google/android/gms/auth/GoogleAuthException
    //   271: dup
    //   272: aload_1
    //   273: invokespecial 162	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   276: athrow
    //   277: new 47	java/io/IOException
    //   280: dup
    //   281: ldc_w 267
    //   284: invokespecial 238	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   287: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   93	109	131	android/os/RemoteException
    //   113	131	131	android/os/RemoteException
    //   177	188	131	android/os/RemoteException
    //   206	240	131	android/os/RemoteException
    //   252	268	131	android/os/RemoteException
    //   268	277	131	android/os/RemoteException
    //   93	109	151	finally
    //   113	131	151	finally
    //   132	151	151	finally
    //   177	188	151	finally
    //   206	240	151	finally
    //   241	252	151	finally
    //   252	268	151	finally
    //   268	277	151	finally
    //   93	109	240	java/lang/InterruptedException
    //   113	131	240	java/lang/InterruptedException
    //   177	188	240	java/lang/InterruptedException
    //   206	240	240	java/lang/InterruptedException
    //   252	268	240	java/lang/InterruptedException
    //   268	277	240	java/lang/InterruptedException
  }

  private static String zzb(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null)
      localBundle = new Bundle();
    try
    {
      paramAccount = getToken(paramContext, paramAccount, paramString, localBundle);
      GooglePlayServicesUtil.zzag(paramContext);
      return paramAccount;
    }
    catch (GooglePlayServicesAvailabilityException paramAccount)
    {
      GooglePlayServicesUtil.showErrorNotification(paramAccount.getConnectionStatusCode(), paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
    catch (UserRecoverableAuthException paramAccount)
    {
      GooglePlayServicesUtil.zzag(paramContext);
    }
    throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
  }

  private static boolean zzbd(String paramString)
  {
    return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
  }

  private static boolean zzbe(String paramString)
  {
    return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString)) || (Status.DM_SYNC_DISABLED.getWire().equals(paramString)) || (Status.DM_ADMIN_BLOCKED.getWire().equals(paramString)) || (Status.DM_ADMIN_PENDING_APPROVAL.getWire().equals(paramString)) || (Status.DM_STALE_SYNC_REQUIRED.getWire().equals(paramString)) || (Status.DM_DEACTIVATED.getWire().equals(paramString)) || (Status.DM_REQUIRED.getWire().equals(paramString)) || (Status.THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.getWire().equals(paramString));
  }
}