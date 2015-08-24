package com.google.android.keep.editor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.location.g;
import com.google.android.keep.location.i.a;
import com.google.android.keep.model.A;
import com.google.android.keep.model.Alert;
import com.google.android.keep.model.B;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.D;
import com.google.android.keep.model.ModelEventDispatcher;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.a;
import com.google.android.keep.model.i;
import com.google.android.keep.model.n;
import com.google.android.keep.model.p;
import com.google.android.keep.model.s;
import java.util.Arrays;
import java.util.List;

public class ReminderEditorFragment extends p
  implements ReminderHelper.d, i.a<g>
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wI, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wL, ModelEventDispatcher.EventType.xn });
  private A hZ;
  private a ia;
  private TreeEntityModel me;
  private View nh;
  private n nn;
  private i no;
  private D np;
  private ReminderHelper nq;

  public void a(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 12))
      new B(new ModelEventDispatcher[] { me, nn, no, np, hZ })
      {
        protected void run()
        {
          Place localPlace = PlacePicker.getPlace(paramIntent, getActivity());
          ReminderEditorFragment.a(ReminderEditorFragment.this).b(localPlace);
        }
      };
  }

  public void a(Context paramContext, g paramg)
  {
    nq.a(paramContext, paramg);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    parama = hZ.a(me);
    Alert localAlert;
    if (parama != null)
    {
      localAlert = (Alert)ia.G(parama.gq());
      if (localAlert == null)
        break label87;
    }
    label87: for (int i = localAlert.getState(); ; i = -1)
    {
      nq.a(parama.gK(), i, parama.gs());
      nq.a(parama);
      nq.B(me.jx());
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

  public void bp()
  {
    nq.bp();
  }

  public void ev()
  {
    BaseReminder localBaseReminder = nq.k(me.dP());
    hZ.a(localBaseReminder, me);
  }

  public void ew()
  {
    hZ.c(me);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    me = ((TreeEntityModel)e(TreeEntityModel.class));
    nn = ((n)e(n.class));
    no = ((i)e(i.class));
    np = ((D)e(D.class));
    hZ = ((A)e(A.class));
    ia = ((a)e(a.class));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    nh = paramLayoutInflater.inflate(2130968689, paramViewGroup, false);
    paramLayoutInflater = (s)Binder.a(getActivity(), s.class);
    nq = new ReminderHelper(this, this, nh, paramLayoutInflater);
    return nh;
  }
}