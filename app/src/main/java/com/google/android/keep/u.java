package com.google.android.keep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class u extends Fragment
  implements q.d, r
{
  protected final o se = new o();
  private m sf = null;

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public o fO()
  {
    return se;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    se.onActivityCreated(paramBundle);
    super.onActivityCreated(paramBundle);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    se.onActivityResult(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttach(Activity paramActivity)
  {
    se.onAttach(paramActivity);
    super.onAttach(paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    se.onCreate(paramBundle);
    sf = ((t)getActivity()).fM();
    sf.b(this);
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    se.i(paramBundle);
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  public void onDestroy()
  {
    se.onDestroy();
    sf.c(this);
    super.onDestroy();
  }

  public void onDestroyView()
  {
    se.onDestroyView();
    super.onDestroyView();
  }

  public void onDetach()
  {
    se.onDetach();
    super.onDetach();
  }

  public void onPause()
  {
    se.onPause();
    super.onPause();
  }

  public void onResume()
  {
    v.a(getChildFragmentManager());
    se.onResume();
    super.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    se.onSaveInstanceState(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }

  public void onStart()
  {
    v.a(getChildFragmentManager());
    se.onStart();
    super.onStart();
  }

  public void onStop()
  {
    se.onStop();
    super.onStop();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    se.onViewCreated(paramView, paramBundle);
    super.onViewCreated(paramView, paramBundle);
  }

  public void setMenuVisibility(boolean paramBoolean)
  {
    se.I(paramBoolean);
    super.setMenuVisibility(paramBoolean);
  }
}