package com.google.android.keep.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.l;
import com.google.android.keep.model.o;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.p;
import com.google.android.keep.util.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class g extends BaseAdapter
  implements View.OnClickListener, ModelEventDispatcher.b
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wU, ModelEventDispatcher.EventType.wX, ModelEventDispatcher.EventType.wV });
  private NavigationManager.NavigationMode IS = NavigationManager.NavigationMode.AL;
  private h IT;
  private final List<f> IU = new ArrayList();
  private final List<f> IV = new ArrayList();
  private d IW = null;
  private a IX = null;
  private final List<e> IY = new ArrayList();
  private final List<g> IZ = new ArrayList();
  private Label Ja = null;
  private l fh;
  private final Context mContext;
  private final LayoutInflater mInflater;

  public g(Context paramContext, p paramp)
  {
    mInflater = LayoutInflater.from(paramContext);
    mContext = paramContext;
    mb();
    fh = ((l)new o(mContext, this, paramp).e(l.class));
  }

  private View a(View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = mInflater.inflate(2130968664, paramViewGroup, false);
      localView.setOnClickListener(this);
    }
    return localView;
  }

  private View a(e parame, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof String));
    }
    else
    {
      localView = mInflater.inflate(2130968661, paramViewGroup, false);
      localView.setOnClickListener(this);
      localView.setId(2131492878);
    }
    parame = e.a(parame);
    ((TextView)localView.findViewById(2131492986)).setText(parame.getName());
    localView.setTag(parame);
    ((DrawerSelectableItemView)localView).g(0.4F, 0.2F);
    if ((parame.equals(Ja)) && (IS == NavigationManager.NavigationMode.AO));
    for (boolean bool = true; ; bool = false)
    {
      localView.setActivated(bool);
      return localView;
    }
  }

  private View a(f paramf, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    paramView = localView;
    if (localView == null)
    {
      paramView = mInflater.inflate(2130968663, paramViewGroup, false);
      paramView.setOnClickListener(this);
      paramView.setTag(new c(paramView));
    }
    paramViewGroup = (c)paramView.getTag();
    paramViewGroup.jW.setText(paramf.text);
    paramViewGroup.Jc.setImageResource(paramf.icon);
    paramView.setId(paramf.id);
    ((DrawerSelectableItemView)paramView).g(1.0F, 0.5F);
    if (paramf.Je == IS);
    for (boolean bool = true; ; bool = false)
    {
      paramView.setActivated(bool);
      return paramView;
    }
  }

  private View b(View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = mInflater.inflate(2130968662, paramViewGroup, false);
      paramView = localView.findViewById(2131493152);
      if (Config.nx())
      {
        paramView.setOnClickListener(this);
        paramView.setId(2131493152);
      }
    }
    else
    {
      return localView;
    }
    paramView.setVisibility(8);
    return localView;
  }

  private View c(View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    View localView = paramView;
    if (paramView == null)
    {
      localView = mInflater.inflate(2130968658, paramViewGroup, false);
      localView.setOnClickListener(this);
    }
    paramView = localView.findViewById(2131493148);
    if (IY.size() == 0);
    while (true)
    {
      paramView.setVisibility(i);
      return localView;
      i = 8;
    }
  }

  private void mb()
  {
    IU.add(new f(2131492876, 2131231126, 2130837684, NavigationManager.NavigationMode.AM));
    IU.add(new f(2131492879, 2131231130, 2130837690, NavigationManager.NavigationMode.AP));
    IV.add(new f(2131492877, 2131231127, 2130837663, NavigationManager.NavigationMode.AN));
    IV.add(new f(2131492880, 2131231128, 2130837703, NavigationManager.NavigationMode.AQ));
    IW = new d(2131492878);
    IX = new a(2131492881);
    IZ.add(new g(2131493153));
  }

  private void mc()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = fh.ho().iterator();
    while (localIterator.hasNext())
      localArrayList.add(new e(2131492878, (Label)localIterator.next()));
    IY.clear();
    IY.addAll(localArrayList);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    mc();
    notifyDataSetChanged();
  }

  public void a(h paramh)
  {
    IT = paramh;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public void d(Label paramLabel)
  {
    Ja = paramLabel;
  }

  public int getCount()
  {
    int j = IU.size();
    int k = IV.size();
    int m = IZ.size();
    if (IY.size() == 0);
    for (int i = 0; ; i = IY.size() + 1)
      return i + (j + k + m + 1);
  }

  public Object getItem(int paramInt)
  {
    if (paramInt < IU.size())
      return IU.get(paramInt);
    paramInt -= IU.size();
    if (IY.size() > 0)
    {
      if (paramInt == 0)
        return IW;
      paramInt -= 1;
      if (paramInt < IY.size())
        return IY.get(paramInt);
      paramInt -= IY.size();
    }
    while (true)
    {
      int i = paramInt - 1;
      if (paramInt == 0)
        return IX;
      if (i < IV.size())
        return IV.get(i);
      paramInt = i - IV.size();
      if (paramInt < IZ.size())
        return IZ.get(paramInt);
      throw new IllegalStateException("Index out of bound for drawer items");
    }
  }

  public long getItemId(int paramInt)
  {
    return ((b)getItem(paramInt)).id;
  }

  public int getItemViewType(int paramInt)
  {
    return ((b)getItem(paramInt)).Jb;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b localb = (b)getItem(paramInt);
    switch (localb.Jb)
    {
    default:
      throw new IllegalStateException("Unknown drawer item " + localb);
    case 0:
      return a((f)localb, paramView, paramViewGroup);
    case 2:
      return b(paramView, paramViewGroup);
    case 4:
      return c(paramView, paramViewGroup);
    case 3:
      return a((e)localb, paramView, paramViewGroup);
    case 1:
    }
    return a(paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return 5;
  }

  public Label md()
  {
    return Ja;
  }

  public void onClick(View paramView)
  {
    if (IT == null)
      return;
    int i;
    switch (paramView.getId())
    {
    default:
      throw new IllegalStateException("Unknown view");
    case 2131492876:
    case 2131492877:
    case 2131492879:
    case 2131492880:
      IT.H(paramView.getId());
      i = 1;
    case 2131492878:
    case 2131493153:
    case 2131493152:
    case 2131492881:
    }
    while (i != 0)
    {
      Ja = null;
      return;
      Label localLabel = (Label)paramView.getTag();
      IT.a(paramView.getId(), localLabel);
      Ja = localLabel;
      i = 0;
      continue;
      IT.I(paramView.getId());
      i = 0;
      continue;
      IT.J(paramView.getId());
      i = 0;
      continue;
      IT.K(paramView.getId());
      i = 0;
    }
  }

  public void q(NavigationManager.NavigationMode paramNavigationMode)
  {
    if (IS == paramNavigationMode)
      return;
    IS = paramNavigationMode;
    notifyDataSetChanged();
  }

  public static class a extends g.b
  {
    public a(int paramInt)
    {
      super(paramInt, 0, 0);
    }
  }

  public static abstract class b
  {
    public final int Jb;
    public final int icon;
    public final int id;
    public final int text;

    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Jb = paramInt1;
      id = paramInt2;
      text = paramInt3;
      icon = paramInt4;
    }
  }

  private static class c
  {
    public final ImageView Jc;
    public final TextView jW;

    public c(View paramView)
    {
      jW = ((TextView)paramView.findViewById(2131492986));
      Jc = ((ImageView)paramView.findViewById(2131492985));
    }
  }

  public static class d extends g.b
  {
    public d(int paramInt)
    {
      super(paramInt, 0, 0);
    }
  }

  public static class e extends g.b
  {
    private final Label Jd;

    public e(int paramInt, Label paramLabel)
    {
      super(paramInt, 0, 0);
      Jd = paramLabel;
    }
  }

  public static class f extends g.b
  {
    public final NavigationManager.NavigationMode Je;

    public f(int paramInt1, int paramInt2, int paramInt3, NavigationManager.NavigationMode paramNavigationMode)
    {
      super(paramInt1, paramInt2, paramInt3);
      Je = paramNavigationMode;
    }
  }

  public static class g extends g.b
  {
    public g(int paramInt)
    {
      super(paramInt, 0, 0);
    }
  }

  public static abstract interface h
  {
    public abstract void H(int paramInt);

    public abstract void I(int paramInt);

    public abstract void J(int paramInt);

    public abstract void K(int paramInt);

    public abstract void a(int paramInt, Label paramLabel);
  }
}