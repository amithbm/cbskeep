package com.google.android.gms.googlehelp.internal.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class zzd
{
  public static int zzaA(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i != 0)
      return paramContext.getResources().getDimensionPixelSize(i);
    return 0;
  }

  public static Bitmap zzr(Activity paramActivity)
  {
    FutureTask localFutureTask = new FutureTask(new Callable()
    {
      public Bitmap zzxM()
        throws Exception
      {
        return zzd.zzu(zzaBg);
      }
    });
    paramActivity.runOnUiThread(localFutureTask);
    try
    {
      paramActivity = (Bitmap)localFutureTask.get();
      return paramActivity;
    }
    catch (InterruptedException paramActivity)
    {
      Log.w("gH_Utils", "Taking screenshot failed!");
      return null;
    }
    catch (ExecutionException paramActivity)
    {
      label32: break label32;
    }
  }

  private static Bitmap zzs(Activity paramActivity)
  {
    try
    {
      View localView1 = paramActivity.getWindow().getDecorView().getRootView();
      View localView2 = localView1.findViewById(16908290);
      if (localView2 == null)
        return null;
      int i = zzaA(paramActivity) + localView2.getTop();
      if (i < localView1.getHeight())
      {
        paramActivity = Bitmap.createBitmap(localView1.getWidth(), localView1.getHeight(), Bitmap.Config.ARGB_8888);
        localView1.draw(new Canvas(paramActivity));
        int j = Math.min(paramActivity.getHeight() - i, localView2.getHeight());
        paramActivity = Bitmap.createBitmap(paramActivity, 0, i, paramActivity.getWidth(), j);
        return paramActivity;
      }
    }
    catch (Exception paramActivity)
    {
      Log.w("gH_Utils", "Get screenshot failed!", paramActivity);
    }
    return null;
  }

  public static String zzt(Activity paramActivity)
  {
    String str = paramActivity.getTitle().toString();
    int i = paramActivity.getResources().getIdentifier("action_bar", "id", paramActivity.getPackageName());
    if (i == 0)
      return str;
    paramActivity = (ViewGroup)paramActivity.findViewById(i);
    if (paramActivity == null)
      return str;
    i = 0;
    while (i < paramActivity.getChildCount())
    {
      View localView = paramActivity.getChildAt(i);
      if ((localView instanceof TextView))
        return ((TextView)localView).getText().toString();
      i += 1;
    }
    return str;
  }
}