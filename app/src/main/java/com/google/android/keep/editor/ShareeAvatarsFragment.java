package com.google.android.keep.editor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.C;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.p;
import com.google.android.keep.model.x.a;
import com.google.android.keep.ui.EditorShareesLayout;
import com.google.android.keep.ui.c;
import com.google.android.keep.util.e;
import java.util.Arrays;
import java.util.List;

public class ShareeAvatarsFragment extends p
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wL, ModelEventDispatcher.EventType.xz, ModelEventDispatcher.EventType.xA });
  private com.google.android.keep.browse.a cR;
  private c eF;
  private C ly;
  private EditorShareesLayout pj;
  private final View.OnClickListener pk = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ShareeAvatarsFragment.b(ShareeAvatarsFragment.this).a(ShareeAvatarsFragment.a(ShareeAvatarsFragment.this).dP(), false, null, true);
    }
  };
  private final View.OnLongClickListener pl = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramAnonymousView)
    {
      return e.C(paramAnonymousView);
    }
  };

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih());
    x.a locala;
    do
    {
      return;
      if (!(parama instanceof x.a))
        break;
      locala = (x.a)parama;
      if (parama.ig() == ModelEventDispatcher.EventType.xz)
      {
        pj.a(locala.getCollaborator());
        return;
      }
    }
    while (parama.ig() != ModelEventDispatcher.EventType.xA);
    pj.b(locala.getCollaborator());
    return;
    if (!ly.ip())
    {
      pj.setVisibility(8);
      return;
    }
    pj.setVisibility(0);
    parama = ly.jj();
    pj.b(pk);
    pj.a(pl);
    pj.w(parama);
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
    paramBundle = (com.google.android.keep.activities.a)getActivity();
    cR = ((com.google.android.keep.browse.a)Binder.a(getActivity(), com.google.android.keep.browse.a.class));
    ly = ((C)e(C.class));
    eF = ((c)Binder.a(getActivity(), c.class));
    pj.a(paramBundle, ly.gA(), eF);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968757, paramViewGroup, false);
    pj = ((EditorShareesLayout)paramLayoutInflater.findViewById(2131493368));
    return paramLayoutInflater;
  }
}