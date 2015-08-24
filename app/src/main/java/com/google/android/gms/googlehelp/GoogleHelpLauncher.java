package com.google.android.gms.googlehelp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.googlehelp.internal.common.zzj;
import java.util.List;

public class GoogleHelpLauncher
{
  protected final Activity mActivity;
  private final GoogleApiClient zzaaj;

  public GoogleHelpLauncher(Activity paramActivity)
  {
    this(paramActivity, new GoogleApiClient.Builder(paramActivity).addApi(zzc.API).build());
  }

  GoogleHelpLauncher(Activity paramActivity, GoogleApiClient paramGoogleApiClient)
  {
    mActivity = paramActivity;
    zzaaj = paramGoogleApiClient;
  }

  private boolean zzv(Intent paramIntent)
  {
    boolean bool = false;
    if (mActivity.getPackageManager().queryIntentActivities(paramIntent, 0).size() > 0)
      bool = true;
    return bool;
  }

  protected int isGooglePlayServicesAvailable()
  {
    return GooglePlayServicesUtil.isGooglePlayServicesAvailable(mActivity);
  }

  public void launch(Intent paramIntent)
  {
    zzu(paramIntent);
    int i = isGooglePlayServicesAvailable();
    if (i == 0)
    {
      zzt(paramIntent);
      return;
    }
    zza(i, paramIntent);
  }

  void zza(int paramInt, Intent paramIntent)
  {
    paramIntent = (GoogleHelp)paramIntent.getParcelableExtra("EXTRA_GOOGLE_HELP");
    paramIntent = new Intent("android.intent.action.VIEW").setData(paramIntent.getFallbackSupportUri());
    if ((paramInt != 7) && (zzv(paramIntent)))
    {
      mActivity.startActivity(paramIntent);
      return;
    }
    GooglePlayServicesUtil.showErrorDialogFragment(paramInt, mActivity, 0);
  }

  void zzt(final Intent paramIntent)
  {
    zzc.zza(zzaaj, new zzj()
    {
      public PendingResult<Status> zzl(GoogleApiClient paramAnonymousGoogleApiClient)
      {
        return zzc.zzaOB.zza(GoogleHelpLauncher.zza(GoogleHelpLauncher.this), mActivity, paramIntent);
      }
    });
  }

  void zzu(Intent paramIntent)
  {
    if ((!paramIntent.getAction().equals("com.google.android.gms.googlehelp.HELP")) || (!paramIntent.hasExtra("EXTRA_GOOGLE_HELP")))
      throw new IllegalArgumentException("The intent you are trying to launch is not GoogleHelp intent! This class only supports GoogleHelp intents.");
  }
}