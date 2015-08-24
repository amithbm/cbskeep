package com.google.android.keep.editor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.p;
import com.google.android.keep.util.e;
import com.google.android.keep.util.g;
import java.util.Arrays;
import java.util.List;

public class NoteMetadataFragment extends p
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xd, ModelEventDispatcher.EventType.xg, ModelEventDispatcher.EventType.xf });
  private TreeEntityModel kJ = null;
  private TextView nf;
  private TextView ng;

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    if (kJ != null);
    for (long l = kJ.ix().longValue(); ; l = e.currentTimeMillis())
    {
      nf.setText(getString(2131231156, new Object[] { g.i(getActivity(), l) }));
      if (!kJ.js())
        break;
      ng.setVisibility(0);
      ng.setText(2131231123);
      return;
    }
    if (kJ.jr())
    {
      ng.setVisibility(0);
      ng.setText(2131231122);
      return;
    }
    ng.setVisibility(8);
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
    kJ = ((TreeEntityModel)e(TreeEntityModel.class));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968679, paramViewGroup, false);
    nf = ((TextView)paramLayoutInflater.findViewById(2131493161));
    ng = ((TextView)paramLayoutInflater.findViewById(2131493184));
    return paramLayoutInflater;
  }
}