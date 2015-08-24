package com.google.android.keep;

import android.os.Bundle;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.binder.a;
import com.google.android.keep.util.Config;

public abstract class b extends a
  implements c
{
  private boolean dG;
  protected Tracker dH;

  private void aA()
  {
    if (!dG)
      return;
    if (Config.nI())
    {
      dH = KeepApplication.b(this);
      return;
    }
    EasyTracker.getInstance(this).activityStart(this);
    dH = EasyTracker.getInstance(this);
  }

  protected abstract String S();

  public void a(int paramInt1, int paramInt2, int paramInt3, Long paramLong)
  {
    if (!dG)
      return;
    a(getString(paramInt1), getString(paramInt2), getString(paramInt3), paramLong);
  }

  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (!dG)
      return;
    a(getString(paramInt1), paramLong, getString(paramInt2), getString(paramInt3));
  }

  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if (!dG)
      return;
    dH.send(MapBuilder.createTiming(paramString1, Long.valueOf(paramLong), paramString2, paramString3).build());
  }

  public void a(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    if (!dG)
      return;
    dH.send(MapBuilder.createEvent(paramString1, paramString2, paramString3, paramLong).build());
  }

  public void g(String paramString)
  {
    if (!dG)
      return;
    dH.set("&cd", paramString);
    dH.send(MapBuilder.createAppView().build());
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    dG = Config.nJ();
  }

  protected void onStart()
  {
    aA();
    Preconditions.checkNotNull(S());
    g(S());
    super.onStart();
  }

  protected void onStop()
  {
    super.onStop();
    if (!dG);
    while (Config.nI())
      return;
    EasyTracker.getInstance(this).activityStop(this);
  }
}