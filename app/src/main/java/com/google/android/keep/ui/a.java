package com.google.android.keep.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.U;
import com.google.android.keep.browse.SingleSelectDialogFragment.a;
import com.google.android.keep.browse.SingleSelectDialogFragment.b;
import com.google.android.keep.location.g;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.x;

public class a extends Fragment
  implements SingleSelectDialogFragment.b, com.google.android.keep.location.i.a<g>, i.a, k.a
{
  private static final String Ia = NAME + "_datetime";
  private static final String Ib = NAME + "_state";
  private static final String NAME = a.class.getSimpleName();
  private static final String iQ = NAME + "_title";
  private static final String iR = NAME + "_options";
  private long Ic;
  private int mState = 0;

  public static a a(int paramInt, int[] paramArrayOfInt)
  {
    a locala = new a();
    Bundle localBundle = new Bundle();
    localBundle.putInt(iQ, paramInt);
    localBundle.putIntArray(iR, paramArrayOfInt);
    locala.setArguments(localBundle);
    return locala;
  }

  private void dismiss()
  {
    FragmentManager localFragmentManager = getFragmentManager();
    if (localFragmentManager != null)
      localFragmentManager.beginTransaction().remove(this).commit();
  }

  private a lT()
  {
    if ((getTargetFragment() instanceof a))
      return (a)getTargetFragment();
    if ((getActivity() instanceof a))
      return (a)getActivity();
    return null;
  }

  public void a(Context paramContext, g paramg)
  {
    paramContext = lT();
    if (paramContext == null)
      return;
    paramContext.b(paramg);
    dismiss();
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    KeepTime localKeepTime1 = new KeepTime();
    localKeepTime1.set(0, 0, 0, paramInt3, paramInt2, paramInt1);
    Ic = localKeepTime1.op();
    KeepTime localKeepTime2 = new KeepTime();
    if ((localKeepTime2.year == localKeepTime1.year) && (localKeepTime2.yearDay == localKeepTime1.yearDay))
      if (localKeepTime2.hour < 23)
        localKeepTime2.hour += 1;
    while (true)
    {
      localKeepTime2.on();
      x.a(this, localKeepTime2, this);
      return;
      localKeepTime2.set(0, 0, U.kI(), paramInt3, paramInt2, paramInt1);
    }
  }

  public void bQ()
  {
    cancel();
  }

  public void bR()
  {
    cancel();
  }

  public void bp()
  {
    cancel();
  }

  public void cancel()
  {
    a locala = lT();
    if (locala != null)
      locala.ku();
    dismiss();
  }

  public void g(int paramInt1, int paramInt2)
  {
    a locala = lT();
    if (locala == null)
    {
      dismiss();
      return;
    }
    int[] arrayOfInt = getArguments().getIntArray(iR);
    switch (arrayOfInt[paramInt2])
    {
    default:
      return;
    case 0:
    case 1:
    case 2:
      locala.c(x.cH(arrayOfInt[paramInt2]));
      dismiss();
      return;
    case 3:
      x.a(this, new KeepTime(), this);
      return;
    case 4:
    }
    if (((Boolean)Config.Pl.get()).booleanValue())
    {
      x.a(this, null);
      return;
    }
    x.b(this, null, null);
  }

  public void h(int paramInt1, int paramInt2)
  {
    getArguments();
    KeepTime localKeepTime = new KeepTime(Ic);
    localKeepTime.hour = paramInt1;
    localKeepTime.minute = paramInt2;
    localKeepTime.on();
    lT().c(localKeepTime);
    dismiss();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getArguments();
    if (mState == 0)
    {
      new SingleSelectDialogFragment.a(this, 0).o(getString(paramBundle.getInt(iQ))).a(x.a(getActivity(), paramBundle.getIntArray(iR))).show();
      mState = 1;
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a locala;
    if ((paramInt2 == -1) && (paramInt1 == 12))
    {
      locala = lT();
      if (locala != null);
    }
    else
    {
      return;
    }
    locala.a(PlacePicker.getPlace(paramIntent, getActivity()));
    dismiss();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      mState = paramBundle.getInt(Ib, 0);
      Ic = paramBundle.getLong(Ia, 0L);
    }
    x.a(this, this, this);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt(Ib, mState);
    paramBundle.putLong(Ia, Ic);
  }

  public void s(int paramInt)
  {
    cancel();
  }

  public static abstract interface a
  {
    public abstract void a(Place paramPlace);

    public abstract void b(g paramg);

    public abstract void c(KeepTime paramKeepTime);

    public abstract void ku();
  }
}