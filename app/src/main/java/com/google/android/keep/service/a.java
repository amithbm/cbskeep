package com.google.android.keep.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.keep.b;
import com.google.android.keep.model.j;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.util.e;

public class a extends BroadcastReceiver
{
  private j fr;
  private final FragmentActivity mActivity;

  public a(FragmentActivity paramFragmentActivity, j paramj)
  {
    mActivity = paramFragmentActivity;
    fr = paramj;
  }

  public void c(j paramj)
  {
    fr = paramj;
  }

  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("authAccount");
    if ((str == null) || (fr == null) || (!str.equals(fr.getName())));
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("googleDocUrl");
      if (TextUtils.isEmpty(paramIntent))
      {
        e.b(paramContext, 2131231312);
        return;
      }
      ((b)mActivity).a(2131230867, 2131230895, 2131231029, null);
      paramContext = (ToastsFragment)e.a(mActivity, 2131493048);
    }
    while (paramContext == null);
    paramContext.az(true);
    paramContext.a(mActivity.getString(2131231310), mActivity.getString(2131231311), new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((a.a(a.this) instanceof b))
          ((b)a.a(a.this)).a(2131230867, 2131230896, 2131231029, null);
        paramAnonymousView = new Intent("android.intent.action.VIEW");
        paramAnonymousView.setData(Uri.parse(paramIntent));
        a.a(a.this).startActivity(paramAnonymousView);
        paramContext.az(true);
      }
    });
  }
}