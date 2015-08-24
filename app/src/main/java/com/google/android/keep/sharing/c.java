package com.google.android.keep.sharing;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.common.base.Preconditions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.people.People;
import com.google.android.gms.people.People.PeopleOptions1p;
import com.google.android.gms.people.People.PeopleOptions1p.Builder;
import com.google.android.keep.util.b;
import com.google.android.keep.util.o;
import com.google.common.collect.ImmutableList;

public class c extends DialogFragment
  implements LoaderManager.LoaderCallbacks<a>, View.OnClickListener
{
  private volatile a EB;
  private TextView EC;
  private TextView ED;
  private Button EE;
  private ProgressBar EF;
  private LinearLayout EG;
  private LinearLayout EH;
  private TextView EI;
  private String dz;
  private Button he;

  public static c a(Fragment paramFragment, String paramString)
  {
    c localc = new c();
    Bundle localBundle = new Bundle();
    localBundle.putString("proposed_email_to_add", paramString);
    localc.setArguments(localBundle);
    localc.setTargetFragment(paramFragment, 0);
    return localc;
  }

  private void a(ImmutableList<View> paramImmutableList)
  {
    int i = 0;
    if (i < EG.getChildCount())
    {
      View localView = EG.getChildAt(i);
      if (paramImmutableList.contains(localView));
      for (int j = 0; ; j = 8)
      {
        localView.setVisibility(j);
        i += 1;
        break;
      }
    }
  }

  private void b(ImmutableList<View> paramImmutableList)
  {
    int i = 0;
    if (i < EG.getChildCount())
    {
      View localView = EG.getChildAt(i);
      if (paramImmutableList.contains(localView));
      for (int j = 8; ; j = 0)
      {
        localView.setVisibility(j);
        i += 1;
        break;
      }
    }
  }

  private void dU()
  {
    if (EB == null)
    {
      a(ImmutableList.of(EF, EH));
      EE.setVisibility(8);
      return;
    }
    if ((TextUtils.isEmpty(EB.displayName)) || (EB.EJ))
    {
      if (EB.EJ)
        EI.setText(getString(2131231334, new Object[] { dz }));
      while (true)
      {
        EE.setVisibility(8);
        a(ImmutableList.of(EI, EH));
        return;
        EI.setText(getString(2131231333, new Object[] { dz }));
      }
    }
    EC.setText(getString(2131231329, new Object[] { EB.displayName }));
    ED.setText(getString(2131231330, new Object[] { EB.displayName, dz }));
    EE.setVisibility(0);
    b(ImmutableList.of(EI, EF));
  }

  public void a(Loader<a> paramLoader, a parama)
  {
    EB = parama;
    dU();
  }

  public void onClick(View paramView)
  {
    if (paramView == he)
      dismiss();
    while (paramView != EE)
      return;
    if ((getTargetFragment() instanceof b))
      ((b)getTargetFragment()).j(dz, EB.displayName);
    while (true)
    {
      dismiss();
      return;
      if ((getActivity() instanceof b))
        ((b)getActivity()).j(dz, EB.displayName);
    }
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    dz = getArguments().getString("proposed_email_to_add");
    if (!TextUtils.isEmpty(dz));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      paramBundle = LayoutInflater.from(getActivity()).inflate(2130968755, null);
      EG = ((LinearLayout)paramBundle.findViewById(2131493354));
      EF = ((ProgressBar)paramBundle.findViewById(2131493355));
      EC = ((TextView)paramBundle.findViewById(2131493357));
      ED = ((TextView)paramBundle.findViewById(2131493358));
      EE = ((Button)paramBundle.findViewById(2131493361));
      EE.setOnClickListener(this);
      he = ((Button)paramBundle.findViewById(2131493360));
      he.setOnClickListener(this);
      EH = ((LinearLayout)paramBundle.findViewById(2131493359));
      EI = ((TextView)paramBundle.findViewById(2131493356));
      dU();
      getLoaderManager().initLoader(1, null, this);
      return new AlertDialog.Builder(getActivity()).setView(paramBundle).setCancelable(false).create();
    }
  }

  public Loader<a> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new c(getActivity(), dz);
  }

  public void onLoaderReset(Loader<a> paramLoader)
  {
    EB = null;
    dU();
  }

  static class a
  {
    boolean EJ = false;
    String displayName = null;
  }

  public static abstract interface b
  {
    public abstract void j(String paramString1, String paramString2);
  }

  private static class c extends b<c.a>
  {
    private volatile c.a EK = null;
    private String dz = null;

    public c(Context paramContext, String paramString)
    {
      super();
      dz = paramString;
    }

    public c.a kO()
    {
      c.a locala = new c.a();
      Object localObject3 = null;
      GoogleApiClient localGoogleApiClient3 = null;
      GoogleApiClient localGoogleApiClient1 = localGoogleApiClient3;
      Object localObject2 = localObject3;
      try
      {
        People.PeopleOptions1p localPeopleOptions1p = new People.PeopleOptions1p.Builder().setClientApplicationId(131).build();
        localGoogleApiClient1 = localGoogleApiClient3;
        localObject2 = localObject3;
        localGoogleApiClient3 = new GoogleApiClient.Builder(getContext()).addApi(People.API_1P, localPeopleOptions1p).build();
        localGoogleApiClient1 = localGoogleApiClient3;
        localObject2 = localGoogleApiClient3;
        localObject3 = localGoogleApiClient3.blockingConnect();
        localGoogleApiClient1 = localGoogleApiClient3;
        localObject2 = localGoogleApiClient3;
        if (!((ConnectionResult)localObject3).isSuccess())
        {
          localGoogleApiClient1 = localGoogleApiClient3;
          localObject2 = localGoogleApiClient3;
          throw new IllegalStateException(((ConnectionResult)localObject3).toString());
        }
      }
      catch (Exception localException)
      {
        localGoogleApiClient2 = localGoogleApiClient1;
        locala.EJ = true;
        return locala;
        localGoogleApiClient1 = localGoogleApiClient3;
        localGoogleApiClient2 = localGoogleApiClient3;
        localObject3 = o.O(getContext());
        localGoogleApiClient1 = localGoogleApiClient3;
        localGoogleApiClient2 = localGoogleApiClient3;
        locala.displayName = com.google.android.keep.util.j.a(localGoogleApiClient3, dz, ((com.google.android.keep.model.j)localObject3).getName());
        return locala;
      }
      finally
      {
        GoogleApiClient localGoogleApiClient2;
        if (localGoogleApiClient2 != null)
          localGoogleApiClient2.disconnect();
      }
    }
  }
}