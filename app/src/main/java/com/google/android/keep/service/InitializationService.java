package com.google.android.keep.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.keep.util.A;
import com.google.android.keep.util.o;
import java.util.Iterator;
import java.util.List;

public class InitializationService extends IntentService
{
  public InitializationService()
  {
    super("InitializationService");
  }

  private boolean kG()
  {
    long l = A.ao(this);
    return System.currentTimeMillis() > 3600000L + l;
  }

  public static void z(Context paramContext)
  {
    paramContext.startService(new Intent(paramContext, InitializationService.class));
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    if (!kG())
      return;
    paramIntent = o.R(this).iterator();
    while (paramIntent.hasNext())
    {
      GoogleApiClient localGoogleApiClient = com.google.android.keep.util.j.i(this, ((com.google.android.keep.model.j)paramIntent.next()).getName()).build();
      com.google.android.keep.util.j.f(localGoogleApiClient);
      com.google.android.keep.util.j.e(localGoogleApiClient);
    }
    A.m(this, System.currentTimeMillis());
  }
}