package com.google.android.keep.editor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.browse.a;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.l;
import com.google.android.keep.model.p;
import com.google.android.keep.model.s;
import com.google.android.keep.ui.LabelLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LabelFragment extends p
  implements View.OnClickListener
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wU, ModelEventDispatcher.EventType.wX, ModelEventDispatcher.EventType.wV, ModelEventDispatcher.EventType.wY, ModelEventDispatcher.EventType.wZ, ModelEventDispatcher.EventType.xn });
  private a cR;
  private l fh;
  private s hb;
  private TreeEntityModel kJ;
  private View mContentView;

  private void dW()
  {
    ArrayList localArrayList = fh.v(kJ.dP());
    if ((localArrayList == null) || (localArrayList.isEmpty()));
    LabelLayout localLabelLayout1;
    do
    {
      return;
      LabelLayout localLabelLayout2 = (LabelLayout)mContentView.findViewById(2131493098);
      localLabelLayout1 = localLabelLayout2;
      if (localLabelLayout2 == null)
        localLabelLayout1 = (LabelLayout)((ViewStub)mContentView.findViewById(2131493097)).inflate();
    }
    while (localLabelLayout1 == null);
    localLabelLayout1.d(localArrayList);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    View localView = mContentView;
    if (kJ.jx());
    for (parama = null; ; parama = this)
    {
      localView.setOnClickListener(parama);
      dW();
      return;
    }
  }

  protected boolean aB()
  {
    return false;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    fh = ((l)e(l.class));
    kJ = ((TreeEntityModel)e(TreeEntityModel.class));
    cR = ((a)Binder.a(getActivity(), a.class));
    hb = ((s)Binder.a(getActivity(), s.class));
  }

  public void onClick(View paramView)
  {
    hb.a(2131230867, 2131230994, 2131231015, null);
    cR.c(new long[] { kJ.dP() });
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mContentView = paramLayoutInflater.inflate(2130968712, paramViewGroup, false);
    return mContentView;
  }
}