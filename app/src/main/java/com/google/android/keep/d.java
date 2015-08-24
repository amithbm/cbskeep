package com.google.android.keep;

import android.content.Context;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.util.Config;

public class d
  implements c
{
  private Tracker dH;
  private Context mContext;

  private d(Context paramContext)
  {
    if (Config.nJ())
    {
      mContext = paramContext;
      if (Config.nI())
        dH = KeepApplication.b(paramContext);
    }
    else
    {
      return;
    }
    dH = EasyTracker.getInstance(paramContext);
  }

  public static c e(Context paramContext)
  {
    return new d(paramContext);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, Long paramLong)
  {
    if (dH == null)
      return;
    a(mContext.getString(paramInt1), mContext.getString(paramInt2), mContext.getString(paramInt3), paramLong);
  }

  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (dH == null)
      return;
    a(mContext.getString(paramInt1), paramLong, mContext.getString(paramInt2), mContext.getString(paramInt3));
  }

  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if (dH == null)
      return;
    dH.send(MapBuilder.createTiming(paramString1, Long.valueOf(paramLong), paramString2, paramString3).build());
  }

  public void a(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    if (dH == null)
      return;
    dH.send(MapBuilder.createEvent(paramString1, paramString2, paramString3, paramLong).build());
  }

  public void g(String paramString)
  {
    if (dH == null)
      return;
    dH.set("&cd", paramString);
    dH.send(MapBuilder.createAppView().build());
  }
}