package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class zzh
  implements DialogInterface.OnClickListener
{
  private final Activity mActivity;
  private final Intent mIntent;
  private final Fragment zzald;
  private final int zzale;

  public zzh(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    mActivity = paramActivity;
    zzald = null;
    mIntent = paramIntent;
    zzale = paramInt;
  }

  public zzh(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    mActivity = null;
    zzald = paramFragment;
    mIntent = paramIntent;
    zzale = paramInt;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((mIntent != null) && (zzald != null))
        zzald.startActivityForResult(mIntent, zzale);
      while (true)
      {
        paramDialogInterface.dismiss();
        return;
        if (mIntent != null)
          mActivity.startActivityForResult(mIntent, zzale);
      }
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
    }
  }
}