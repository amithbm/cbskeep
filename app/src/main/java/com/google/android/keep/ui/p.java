package com.google.android.keep.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.browse.a;
import com.google.android.keep.e;
import com.google.android.keep.model.l;
import com.google.android.keep.model.s;
import com.google.android.keep.util.Config;
import java.util.ArrayList;

public abstract class p extends e
  implements View.OnClickListener
{
  protected a cR;
  protected ViewGroup eC;
  protected l fh;
  protected s hb;
  protected RecyclerView mRecyclerView;

  protected boolean bo(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString.trim())) && (fh.P(paramString.trim()) == null);
  }

  public abstract int getStatusBarColor();

  protected boolean mp()
  {
    return fh.ho().size() >= ((Integer)Config.Pc.get()).intValue();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    cR = ((a)Binder.a(getActivity(), a.class));
    fh = ((l)Binder.a(getActivity(), l.class));
    hb = ((s)Binder.a(getActivity(), s.class));
    if ((cR.aN()) && (!cR.aQ()))
    {
      eC.findViewById(2131493173).setOnClickListener(this);
      eC.findViewById(2131493174).setOnClickListener(this);
      cR.aF();
    }
    cR.aI();
  }

  public void onClick(View paramView)
  {
    if (!isAdded())
      return;
    switch (paramView.getId())
    {
    default:
      return;
    case 2131493173:
    case 2131493174:
    case 2131493245:
    }
    cR.aZ();
  }
}