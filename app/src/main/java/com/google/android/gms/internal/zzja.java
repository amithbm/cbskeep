package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.AppDataSearch;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.UsageReportingApi;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.common.api.zza.zzb;
import java.util.List;

public final class zzja
  implements UsageReportingApi, AppIndexApi
{
  public static Intent zza(String paramString, Uri paramUri)
  {
    zzb(paramString, paramUri);
    paramString = paramUri.getPathSegments();
    String str = (String)paramString.get(0);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme(str);
    if (paramString.size() > 1)
    {
      localBuilder.authority((String)paramString.get(1));
      int i = 2;
      while (i < paramString.size())
      {
        localBuilder.appendPath((String)paramString.get(i));
        i += 1;
      }
    }
    localBuilder.encodedQuery(paramUri.getEncodedQuery());
    localBuilder.encodedFragment(paramUri.getEncodedFragment());
    return new Intent("android.intent.action.VIEW", localBuilder.build());
  }

  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, Action paramAction, int paramInt)
  {
    String str = paramGoogleApiClient.getContext().getPackageName();
    return reportUsage(paramGoogleApiClient, new UsageInfo[] { zziz.zza(paramAction, System.currentTimeMillis(), str, paramInt) });
  }

  private static void zzb(String paramString, Uri paramUri)
  {
    if (!"android-app".equals(paramUri.getScheme()))
      throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + paramUri);
    String str = paramUri.getHost();
    if ((paramString != null) && (!paramString.equals(str)))
      throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + paramUri);
    paramString = paramUri.getPathSegments();
    if ((paramString.isEmpty()) || (((String)paramString.get(0)).isEmpty()))
      throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + paramUri);
  }

  public PendingResult<Status> end(GoogleApiClient paramGoogleApiClient, Action paramAction)
  {
    return zza(paramGoogleApiClient, paramAction, 2);
  }

  public PendingResult<Status> reportUsage(GoogleApiClient paramGoogleApiClient, final UsageInfo[] paramArrayOfUsageInfo)
  {
    return paramGoogleApiClient.zza(new zze(paramGoogleApiClient)
    {
      protected void zza(zziv paramAnonymouszziv)
        throws RemoteException
      {
        paramAnonymouszziv.zza(new zzja.zzf(this), zzOI, paramArrayOfUsageInfo);
      }
    });
  }

  private static abstract class zzd<T extends Result> extends zza.zza<T, zziy>
  {
    public zzd(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }

    protected abstract void zza(zziv paramzziv)
      throws RemoteException;

    protected final void zza(zziy paramzziy)
      throws RemoteException
    {
      zza(paramzziy.zzkD());
    }
  }

  private static abstract class zze<T extends Result> extends zzja.zzd<Status>
  {
    zze(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    protected Status zze(Status paramStatus)
    {
      return paramStatus;
    }
  }

  private static final class zzf extends zzix<Status>
  {
    public zzf(zza.zzb<Status> paramzzb)
    {
      super();
    }

    public void zzb(Status paramStatus)
    {
      zzOF.zzq(paramStatus);
    }
  }
}