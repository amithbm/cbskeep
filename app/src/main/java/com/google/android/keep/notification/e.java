package com.google.android.keep.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.keep.activities.KeepApplication;

class e
{
  private final AlarmManager Bz;
  private final Context mContext;

  public e(Context paramContext)
  {
    mContext = paramContext;
    Bz = ((AlarmManager)paramContext.getSystemService("alarm"));
  }

  public void a(int paramInt, long paramLong, Intent paramIntent)
  {
    if (KeepApplication.am())
    {
      Bz.setExact(paramInt, paramLong, PendingIntent.getBroadcast(mContext, 0, paramIntent, 134217728));
      return;
    }
    Bz.set(paramInt, paramLong, PendingIntent.getBroadcast(mContext, 0, paramIntent, 134217728));
  }
}