package com.google.android.keep.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.drive.realtime.Collaborator;
import com.google.android.keep.model.Sharee;
import com.google.android.keep.model.j;
import com.google.android.keep.util.D;
import com.google.api.client.util.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EditorShareesLayout extends LinearLayout
{
  private final int Ji = getResources().getColor(2131296416);
  private final float Jj = getResources().getDimension(2131427571);
  private final List<View> Jk = Lists.newArrayList();
  private View Jl;
  private View.OnClickListener Jm;
  private View.OnLongClickListener Jn;
  private Map<String, Integer> Jo = new HashMap();
  private List<Sharee> Jp = new ArrayList();
  private j cL;
  private c eF;
  private LayoutInflater mInflater;
  private TextView pv;
  private boolean pw = false;
  private Interpolator px;

  public EditorShareesLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public EditorShareesLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public EditorShareesLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    px = AnimationUtils.loadInterpolator(paramContext, 17563653);
  }

  private void bS(int paramInt)
  {
    if (Jl == null)
      Jl = mInflater.inflate(2130968696, this, false);
    ((TextView)Jl).setText(getContext().getResources().getString(2131231346, new Object[] { Integer.valueOf(paramInt) }));
    Jl.setVisibility(0);
    addView(Jl);
  }

  private int bl(String paramString)
  {
    int i = 0;
    while (i < Jp.size())
    {
      if (paramString.equals(((Sharee)Jp.get(i)).getGaiaId()))
        return i;
      i += 1;
    }
    return -1;
  }

  private void mf()
  {
    if (Jl == null)
      return;
    Jl.setVisibility(8);
    removeView(Jl);
  }

  public void a(Context paramContext, j paramj, c paramc)
  {
    cL = paramj;
    eF = paramc;
    mInflater = ((Activity)paramContext).getLayoutInflater();
  }

  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    Jn = paramOnLongClickListener;
  }

  public void a(Collaborator paramCollaborator)
  {
    Object localObject = paramCollaborator.getUserId();
    int i;
    if (Jo.containsKey(localObject))
    {
      i = ((Integer)Jo.get(localObject)).intValue() + 1;
      Jo.put(localObject, Integer.valueOf(i));
      if (i == 1)
        break label65;
    }
    label65: 
    do
    {
      return;
      i = 1;
      break;
      i = bl((String)localObject);
    }
    while (i == -1);
    localObject = (Sharee)Jp.get(i);
    Jp.remove(i);
    ((Sharee)localObject).bi(paramCollaborator.getColor());
    Jp.add(0, localObject);
    me();
  }

  public void b(View.OnClickListener paramOnClickListener)
  {
    Jm = paramOnClickListener;
  }

  public void b(Collaborator paramCollaborator)
  {
    paramCollaborator = paramCollaborator.getUserId();
    int i;
    if (Jo.containsKey(paramCollaborator))
    {
      i = ((Integer)Jo.get(paramCollaborator)).intValue() - 1;
      Jo.put(paramCollaborator, Integer.valueOf(i));
      if (i == 0)
        break label64;
    }
    label64: 
    do
    {
      return;
      i = 0;
      break;
      i = bl(paramCollaborator);
    }
    while (i == -1);
    paramCollaborator = (Sharee)Jp.get(i);
    Jp.remove(i);
    paramCollaborator.bi(Ji);
    Jp.add(paramCollaborator);
    me();
  }

  public void me()
  {
    D.bO("EditorShareesLayout_updateView");
    int i;
    label76: int j;
    label82: int k;
    label84: Sharee localSharee;
    View localView;
    if ((Jp == null) || (Jp.size() == 0))
    {
      setVisibility(8);
      removeAllViews();
      if (pv != null)
        pv.setText(String.valueOf(Jp.size()));
      if (Jp.size() <= 6)
        break label235;
      i = 1;
      if (i == 0)
        break label240;
      j = 5;
      k = 0;
      if (k >= j)
        break label282;
      localSharee = (Sharee)Jp.get(k);
      if (k >= Jk.size())
        break label253;
      localView = (View)Jk.get(k);
    }
    while (true)
    {
      localView.setVisibility(0);
      localView.setContentDescription(localSharee.getDisplayName());
      localView.setOnClickListener(Jm);
      localView.setOnLongClickListener(Jn);
      CircularImageView localCircularImageView = (CircularImageView)localView.findViewById(2131493021);
      localCircularImageView.b(localSharee.jg(), Jj);
      eF.a(localSharee.getEmail(), cL.getName(), localCircularImageView);
      addView(localView);
      k += 1;
      break label84;
      setVisibility(0);
      break;
      label235: i = 0;
      break label76;
      label240: j = Jp.size();
      break label82;
      label253: localView = mInflater.inflate(2130968667, this, false);
      Jk.add(localView);
    }
    label282: if (i != 0)
      bS(Jp.size() - j);
    while (true)
    {
      D.ot();
      return;
      mf();
    }
  }

  public void w(List<Sharee> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      Jp.clear();
      me();
      return;
    }
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
      if (TextUtils.equals(((Sharee)((Iterator)localObject1).next()).getEmail(), cL.getName()))
        ((Iterator)localObject1).remove();
    Object localObject2 = new HashSet();
    localObject1 = new HashMap();
    Iterator localIterator = Jp.iterator();
    while (localIterator.hasNext())
      ((Set)localObject2).add(((Sharee)localIterator.next()).getEmail());
    localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      String str = ((Sharee)localIterator.next()).getEmail();
      if (!((Set)localObject2).contains(str));
      for (boolean bool = true; ; bool = false)
      {
        ((Map)localObject1).put(str, Boolean.valueOf(bool));
        break;
      }
    }
    localObject2 = Jp.iterator();
    while (((Iterator)localObject2).hasNext())
      if (!((Map)localObject1).containsKey(((Sharee)((Iterator)localObject2).next()).getEmail()))
        ((Iterator)localObject2).remove();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (Sharee)paramList.next();
      if (((Boolean)((Map)localObject1).get(((Sharee)localObject2).getEmail())).booleanValue())
      {
        ((Sharee)localObject2).bi(Ji);
        Jp.add(localObject2);
      }
    }
    me();
  }
}