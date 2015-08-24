package com.google.android.keep.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.l;
import com.google.android.keep.p;
import com.google.android.keep.util.D;
import com.google.api.client.util.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class q extends o
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private long[] Az;
  private String Ld;
  private HashMap<String, Integer> Le = new HashMap();
  private ArrayList<Label> Lf = new ArrayList();
  private String Lg;
  private b Lh;

  public q(Context paramContext, p paramp, long[] paramArrayOfLong, b paramb)
  {
    super(paramContext, paramp);
    Az = paramArrayOfLong;
    Lh = paramb;
  }

  private void b(a parama, Label paramLabel)
  {
    paramLabel = paramLabel.getName();
    if (Le.containsKey(paramLabel));
    for (int i = ((Integer)Le.get(paramLabel)).intValue(); (i > 0) && (i != Az.length); i = 0)
    {
      parama.Lm.setVisibility(8);
      parama.Ln.setVisibility(0);
      return;
    }
    parama.Ln.setVisibility(8);
    parama.Lm.setVisibility(0);
    parama.Lm.setChecked(Le.containsKey(paramLabel));
  }

  private void d(a parama)
  {
    parama.Lm.setVisibility(8);
    parama.Ln.setVisibility(8);
  }

  private Label t(View paramView)
  {
    while (paramView.getId() != 2131493247)
      paramView = (View)paramView.getParent();
    if (!(paramView.getTag() instanceof Label))
      throw new IllegalStateException("Root tag must be a Label!");
    return (Label)paramView.getTag();
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!fg.ih())
      return;
    Le.clear();
    long[] arrayOfLong = Az;
    int k = arrayOfLong.length;
    int i = 0;
    while (i < k)
    {
      long l = arrayOfLong[i];
      Iterator localIterator = fh.v(l).iterator();
      while (localIterator.hasNext())
      {
        Label localLabel = (Label)localIterator.next();
        int j = 0;
        String str = localLabel.getName();
        if (Le.containsKey(str))
          j = ((Integer)Le.get(str)).intValue();
        Le.put(localLabel.getName(), Integer.valueOf(j + 1));
      }
      i += 1;
    }
    super.a(parama);
    bp(Lg);
  }

  protected void a(a parama)
  {
    parama.Ll.setOnClickListener(null);
    parama.Lk.setOnClickListener(null);
    parama.Lm.setOnCheckedChangeListener(null);
    parama.Ln.setOnClickListener(null);
  }

  protected void a(a parama, Label paramLabel)
  {
    D.bO("LabelPickerAdapter_setupLabelView");
    parama.itemView.setTag(paramLabel);
    parama.Li.setText(paramLabel.getName());
    parama.KC.setVisibility(0);
    parama.Lj.setVisibility(8);
    parama.Ll.setVisibility(8);
    parama.Lk.setVisibility(0);
    parama.Lk.setContentDescription(paramLabel.getName());
    b(parama, paramLabel);
    parama.Lm.setOnCheckedChangeListener(this);
    parama.Ln.setOnClickListener(this);
    parama.Lk.setOnClickListener(this);
    D.ot();
  }

  public void aH(boolean paramBoolean)
  {
    Lc = paramBoolean;
  }

  public void aI(boolean paramBoolean)
  {
    Lb = paramBoolean;
  }

  protected void b(a parama)
  {
    D.bO("LabelPickerAdapter_setupNewLabelView");
    String str = mContext.getString(2131231360, new Object[] { Ld });
    parama.itemView.setTag(null);
    parama.Li.setText(str);
    parama.Lj.setVisibility(0);
    parama.KC.setVisibility(8);
    d(parama);
    parama.Ll.setVisibility(0);
    parama.Ll.setOnClickListener(this);
    parama.Lk.setVisibility(8);
    parama.Ll.setContentDescription(str);
    D.ot();
  }

  public void bp(String paramString)
  {
    Lg = paramString;
    int i;
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramString.trim())))
    {
      i = 1;
      if (i == 0)
        break label107;
    }
    label107: for (paramString = ""; ; paramString = paramString.trim())
    {
      Ld = paramString;
      paramString = new ArrayList();
      paramString.addAll(KY);
      paramString.addAll(KZ);
      if (i == 0)
        break label115;
      if ((!Lf.containsAll(paramString)) || (Lf.size() != paramString.size()))
      {
        Lf = paramString;
        notifyDataSetChanged();
      }
      return;
      i = 0;
      break;
    }
    label115: Lf = Lists.newArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      Label localLabel = (Label)paramString.next();
      if (localLabel.getName().toUpperCase().contains(Ld.toUpperCase()))
        Lf.add(localLabel);
    }
    notifyDataSetChanged();
  }

  protected void c(a parama)
  {
    D.bO("LabelPickerAdapter_setupErrorView");
    if (La)
    {
      parama.Li.setText(mContext.getString(2131231366));
      parama.Li.setTextAppearance(mContext, 2131558769);
    }
    while (true)
    {
      d(parama);
      parama.itemView.setTag(null);
      parama.KC.setVisibility(8);
      parama.Lj.setVisibility(8);
      parama.Ll.setVisibility(8);
      parama.Lk.setVisibility(8);
      parama.Li.setSingleLine(false);
      D.ot();
      return;
      parama.Li.setText(mContext.getString(2131231370));
      parama.Li.setTextAppearance(mContext, 2131558768);
    }
  }

  protected Label cc(int paramInt)
  {
    return (Label)Lf.get(paramInt);
  }

  public int getItemCount()
  {
    int j = Lf.size();
    if ((mn()) || (Lb));
    for (int i = 1; ; i = 0)
      return i + j;
  }

  public long getItemId(int paramInt)
  {
    if (getItemViewType(paramInt) == 100)
      return -101L;
    if (getItemViewType(paramInt) == 102)
      return -100L;
    paramInt = am(paramInt);
    return ((Label)Lf.get(paramInt)).gu().hashCode();
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
    {
      if (mn())
        return 102;
      if (Lb)
        return 100;
    }
    return 101;
  }

  protected boolean mm()
  {
    return Lb;
  }

  public String ms()
  {
    return Ld;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = getItemViewType(paramInt);
    paramViewHolder = (a)paramViewHolder;
    a(paramViewHolder);
    switch (i)
    {
    default:
      throw new IllegalStateException("Unknown view type: " + i);
    case 102:
      c(paramViewHolder);
      return;
    case 100:
      b(paramViewHolder);
      return;
    case 101:
    }
    a(paramViewHolder, cc(am(paramInt)));
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Lh.h(t(paramCompoundButton));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131493250:
      Lh.bq(Ld);
      return;
    case 2131493249:
    case 2131493251:
    }
    Lh.h(t(paramView));
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    D.bO("LabelPickerAdapter_onCreateViewHolder");
    LayoutInflater localLayoutInflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
    switch (paramInt)
    {
    default:
      D.ot();
      return null;
    case 100:
    case 101:
    case 102:
    }
    D.ot();
    return new a(localLayoutInflater.inflate(2130968713, paramViewGroup, false));
  }

  public static class a extends RecyclerView.ViewHolder
  {
    public final ImageView KC;
    public final TextView Li;
    public final ImageView Lj;
    public final View Lk;
    public final View Ll;
    public final CheckBox Lm;
    public final ImageView Ln;

    public a(View paramView)
    {
      super();
      Li = ((TextView)paramView.findViewById(2131493243));
      KC = ((ImageView)paramView.findViewById(2131492985));
      Lj = ((ImageView)paramView.findViewById(2131493248));
      Lk = paramView.findViewById(2131493249);
      Ll = paramView.findViewById(2131493250);
      Lm = ((CheckBox)paramView.findViewById(2131492998));
      Ln = ((ImageView)paramView.findViewById(2131493251));
    }
  }

  public static abstract interface b
  {
    public abstract void bq(String paramString);

    public abstract void h(Label paramLabel);
  }
}