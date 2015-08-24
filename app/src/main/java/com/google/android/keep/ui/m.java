package com.google.android.keep.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.db.a.a;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.s;
import com.google.android.keep.util.D;
import com.google.android.keep.util.e;

public class m extends p
  implements b.b, l.d
{
  private l KO;
  private Integer KP;
  private Toolbar mToolbar;

  public static m aF(boolean paramBoolean)
  {
    m localm = new m();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("start_in_create_label_mode", paramBoolean);
    localm.setArguments(localBundle);
    return localm;
  }

  protected String S()
  {
    return getString(2131230856);
  }

  public void a(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
    if ((paramInt2 == 1) && (paramInt1 == 0))
    {
      paramParcelable = (Label)paramParcelable;
      fh.T(paramParcelable.getName());
      com.google.android.keep.util.a.a(mToolbar, getString(2131231364));
      hb.a(2131230867, 2131230999, 2131231024, null);
    }
  }

  public void f(Label paramLabel)
  {
    new b.a(this, 0).bN(2131231067).bO(2131231068).bP(2131231075).a(paramLabel).show();
  }

  public int getStatusBarColor()
  {
    if (KP == null)
      KP = Integer.valueOf(getResources().getColor(2131296396));
    return KP.intValue();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    boolean bool = getArguments().getBoolean("start_in_create_label_mode", false);
    KO = new l(getActivity(), fO(), this, bool);
    KO.setHasStableIds(true);
    KO.d(paramBundle);
    mRecyclerView.setAdapter(KO);
    super.onActivityCreated(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    D.bO("LabelEditorFragment_onCreateView");
    eC = ((ViewGroup)paramLayoutInflater.inflate(2130968708, null));
    mToolbar = ((Toolbar)((ViewStub)eC.findViewById(2131493239)).inflate());
    mToolbar.setNavigationIcon(2130837648);
    mToolbar.setNavigationContentDescription(2131231293);
    mToolbar.setTitle(2131231358);
    mToolbar.setBackgroundColor(getResources().getColor(2131296407));
    mToolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        e.B(paramAnonymousView);
        cR.aZ();
      }
    });
    paramLayoutInflater = new LinearLayoutManager(getActivity());
    paramLayoutInflater.setOrientation(1);
    mRecyclerView = ((RecyclerView)eC.findViewById(2131493240));
    mRecyclerView.setLayoutManager(paramLayoutInflater);
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    D.ot();
    return eC;
  }

  public void onPause()
  {
    super.onPause();
    ((com.google.android.keep.db.a)Binder.a(getActivity(), com.google.android.keep.db.a.class)).a(new a.a().u(false));
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    KO.e(paramBundle);
  }
}