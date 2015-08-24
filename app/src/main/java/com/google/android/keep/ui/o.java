package com.google.android.keep.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.l;
import com.google.android.keep.p;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class o extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements ModelEventDispatcher.b
{
  protected static String KX = "LabelManagementFragment_priority_labels";
  protected ArrayList<Label> KY = new ArrayList();
  protected ArrayList<Label> KZ = new ArrayList();
  protected boolean La = false;
  protected boolean Lb = false;
  protected boolean Lc = false;
  protected final com.google.android.keep.model.o fg;
  protected final l fh;
  protected Context mContext;

  public o(Context paramContext, p paramp)
  {
    mContext = paramContext;
    fg = new com.google.android.keep.model.o(paramContext, this, paramp);
    fh = ((l)fg.e(l.class));
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!fg.ih())
      return;
    KZ = fh.ho();
    parama = KY.iterator();
    while (parama.hasNext())
      if (!KZ.contains(parama.next()))
        parama.remove();
    KZ.removeAll(KY);
  }

  public void aG(boolean paramBoolean)
  {
    La = paramBoolean;
  }

  protected int am(int paramInt)
  {
    if ((mn()) || (mm()));
    for (int i = 1; ; i = 0)
      return paramInt - i;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return ImmutableList.of(ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wU, ModelEventDispatcher.EventType.wX, ModelEventDispatcher.EventType.wV, ModelEventDispatcher.EventType.wY, ModelEventDispatcher.EventType.wZ);
  }

  protected void d(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    KY = paramBundle.getParcelableArrayList(KX);
  }

  protected void e(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    paramBundle.putParcelableArrayList(KX, KY);
  }

  public void g(Label paramLabel)
  {
    KZ.remove(paramLabel);
    KY.add(0, paramLabel);
  }

  protected abstract boolean mm();

  protected boolean mn()
  {
    return (La) || (Lc);
  }
}