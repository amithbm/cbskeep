package com.google.android.keep.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.s;
import com.google.android.keep.p;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.D;
import com.google.android.keep.util.a;
import com.google.common.base.Preconditions;
import java.util.ArrayList;

public class l extends o
  implements View.OnClickListener, View.OnFocusChangeListener, TextView.OnEditorActionListener, e.a, n
{
  private d Kt;
  private RecyclerView Ku;
  private c Kv;
  private String Kw;
  private boolean Kx;
  private String Ky = "";
  private e Kz = new e(this, ((Integer)Config.Pd.get()).intValue());
  private s hb;

  public l(Context paramContext, p paramp, d paramd, boolean paramBoolean)
  {
    super(paramContext, paramp);
    Kt = paramd;
    hb = ((s)Binder.a(paramContext, s.class));
    Kx = paramBoolean;
  }

  private void a(b paramb, boolean paramBoolean)
  {
    int j = 0;
    if (paramb == null)
      return;
    if (paramBoolean)
    {
      com.google.android.keep.util.e.A(paramb.KB);
      paramb.itemView.setBackgroundColor(mContext.getResources().getColor(2131296440));
      Object localObject = paramb.KE;
      if (!paramBoolean)
        break label168;
      i = 8;
      label52: ((ImageView)localObject).setVisibility(i);
      localObject = paramb.KC;
      if (!paramBoolean)
        break label173;
      i = 8;
      label71: ((ImageView)localObject).setVisibility(i);
      localObject = paramb.KF;
      if (!paramBoolean)
        break label178;
      i = 0;
      label89: ((ImageView)localObject).setVisibility(i);
      localObject = paramb.KD;
      if (!paramBoolean)
        break label184;
      i = 0;
      label107: ((ImageView)localObject).setVisibility(i);
      localObject = paramb.KH;
      if (!paramBoolean)
        break label190;
      i = 0;
      label125: ((View)localObject).setVisibility(i);
      paramb = paramb.KI;
      if (!paramBoolean)
        break label196;
    }
    label168: label173: label178: label184: label190: label196: for (int i = j; ; i = 8)
    {
      paramb.setVisibility(i);
      return;
      com.google.android.keep.util.e.B(paramb.KB);
      paramb.itemView.setBackgroundDrawable(null);
      break;
      i = 0;
      break label52;
      i = 0;
      break label71;
      i = 8;
      break label89;
      i = 8;
      break label107;
      i = 8;
      break label125;
    }
  }

  private void a(c paramc, boolean paramBoolean)
  {
    int j = 0;
    if (paramc == null)
      return;
    if (paramBoolean)
    {
      com.google.android.keep.util.e.A(paramc.KK);
      paramc.itemView.setBackgroundColor(mContext.getResources().getColor(2131296440));
      Object localObject = paramc.KL;
      if (!paramBoolean)
        break label171;
      i = 8;
      label52: ((ImageView)localObject).setVisibility(i);
      localObject = paramc.KM;
      if (!paramBoolean)
        break label176;
      i = 0;
      label70: ((ImageView)localObject).setVisibility(i);
      localObject = paramc.KN;
      if (!paramBoolean)
        break label182;
      i = 0;
      label88: ((ImageView)localObject).setVisibility(i);
      localObject = paramc.KH;
      if (!paramBoolean)
        break label188;
      i = 0;
      label106: ((View)localObject).setVisibility(i);
      paramc = paramc.KI;
      if (!paramBoolean)
        break label194;
    }
    label171: label176: label182: label188: label194: for (int i = j; ; i = 8)
    {
      paramc.setVisibility(i);
      Kx = paramBoolean;
      return;
      com.google.android.keep.util.e.B(paramc.KK);
      paramc.KK.setText(null);
      paramc.KG.setVisibility(8);
      paramc.itemView.setBackgroundDrawable(null);
      break;
      i = 0;
      break label52;
      i = 8;
      break label70;
      i = 8;
      break label88;
      i = 8;
      break label106;
    }
  }

  private void b(b paramb)
  {
    a(paramb, false);
    Kw = null;
    if (paramb.KG.getVisibility() == 8)
    {
      a.a(paramb.itemView, mContext.getResources().getString(2131231363, new Object[] { paramb.KB.getText().toString() }));
      hb.a(2131230867, 2131230998, 2131231024, null);
    }
  }

  private b bm(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return (b)Ku.findViewHolderForItemId(paramString.hashCode());
  }

  private int bn(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return 2131231367;
    if (paramString.length() > ((Integer)Config.Pd.get()).intValue())
      return 2131231366;
    if (fh.P(paramString) != null)
      return 2131231365;
    return 0;
  }

  private void e(Label paramLabel)
  {
    if (paramLabel == null);
    while (paramLabel.gu().equals(Kw))
      return;
    if (Kw != null)
      a(bm(Kw), false);
    if (Kx)
      a(mo(), false);
    Kw = paramLabel.gu();
    a(bm(Kw), true);
  }

  private c mo()
  {
    if (Kv == null)
      Kv = ((c)Ku.findViewHolderForItemId(-101L));
    return Kv;
  }

  private boolean mp()
  {
    return fh.ho().size() >= ((Integer)Config.Pc.get()).intValue();
  }

  private void mq()
  {
    if (Kw != null)
    {
      a(bm(Kw), false);
      Kw = null;
    }
    a(mo(), true);
  }

  private void mr()
  {
    c localc = mo();
    Object localObject = localc.KK.getText().toString();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(((String)localObject).trim())))
      a(localc, false);
    int i;
    do
    {
      return;
      i = bn(((String)localObject).trim());
      if (i != 0)
        break;
      a(localc, false);
      localObject = fh.S(((String)localObject).trim());
    }
    while (localObject == null);
    a.a(localc.itemView, mContext.getResources().getString(2131231362));
    hb.a(2131230867, 2131230990, 2131231024, null);
    g((Label)localObject);
    notifyDataSetChanged();
    return;
    localc.KG.setText(i);
    localc.KG.setVisibility(0);
    a.a(localc.KG, mContext.getResources().getString(i));
  }

  private Label t(View paramView)
  {
    while ((paramView.getId() != 2131493241) && (paramView.getId() != 2131493231))
      paramView = (View)paramView.getParent();
    if (paramView.getId() == 2131493231)
      throw new IllegalArgumentException("Create view has no associated label!");
    if (!(paramView.getTag() instanceof Label))
      throw new IllegalStateException("Root tag must be a Label!");
    return (Label)paramView.getTag();
  }

  public void a(Label paramLabel, b paramb, String paramString)
  {
    Preconditions.checkArgument(paramLabel.gu().equals(Kw));
    if (paramLabel.getName().equals(paramString))
      return;
    int i = bn(paramString);
    if (i == 0)
    {
      paramLabel.setName(paramString);
      paramb.KG.setVisibility(8);
      return;
    }
    paramb.KG.setText(i);
    paramb.KG.setVisibility(0);
    a.a(paramb.KG, mContext.getResources().getString(i));
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!fg.ih());
    while (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wV }))
      return;
    super.a(parama);
    notifyDataSetChanged();
  }

  protected void a(b paramb)
  {
    paramb.KE.setOnClickListener(null);
    paramb.KF.setOnClickListener(null);
    paramb.KD.setOnClickListener(null);
    paramb.itemView.setOnClickListener(null);
    paramb.KB.removeTextChangedListener(Kz);
    paramb.ea();
  }

  protected void a(b paramb, Label paramLabel)
  {
    D.bO("LabelEditorAdapter_setupLabelView");
    a(paramb);
    paramb.a(paramLabel, this);
    paramb.KE.setOnClickListener(this);
    paramb.KF.setOnClickListener(this);
    paramb.KD.setOnClickListener(this);
    paramb.KB.setOnFocusChangeListener(this);
    paramb.KB.setOnEditorActionListener(this);
    paramb.KB.addTextChangedListener(Kz);
    boolean bool = paramLabel.gu().equals(Kw);
    if (bool)
      paramb.KB.setSelection(paramLabel.getName().length());
    a(paramb, bool);
    D.ot();
  }

  protected void a(c paramc)
  {
    paramc.KL.setOnClickListener(this);
    paramc.KN.setOnClickListener(this);
    paramc.KM.setOnClickListener(this);
    paramc.KK.setOnFocusChangeListener(this);
    paramc.KK.setOnEditorActionListener(this);
    if (Ky != null)
    {
      paramc.KK.setText(Ky);
      paramc.KK.setSelection(Ky.length());
      Ky = null;
    }
    paramc.KK.addTextChangedListener(Kz);
    a(paramc, Kx);
  }

  public void a(String paramString, boolean paramBoolean)
  {
  }

  protected Label cc(int paramInt)
  {
    if (paramInt < KY.size())
      return (Label)KY.get(paramInt);
    return (Label)KZ.get(paramInt - KY.size());
  }

  protected void d(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    super.d(paramBundle);
    Kw = paramBundle.getString("LabelEditorFragment_current_rename_label");
    Ky = paramBundle.getString("LabelEditorFragment_new_label_text");
    Kx = paramBundle.getBoolean("LabelEditorFragment_is_creating_label");
  }

  protected void e(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    super.e(paramBundle);
    paramBundle.putString("LabelEditorFragment_current_rename_label", Kw);
    if (Kx)
    {
      c localc = mo();
      if (localc != null)
        paramBundle.putString("LabelEditorFragment_new_label_text", localc.KK.getText().toString());
    }
    paramBundle.putBoolean("LabelEditorFragment_is_creating_label", Kx);
  }

  public int getItemCount()
  {
    return KY.size() + KZ.size() + 1;
  }

  public long getItemId(int paramInt)
  {
    if (getItemViewType(paramInt) == 100)
      return -101L;
    if (getItemViewType(paramInt) == 102)
      return -102L;
    return cc(am(paramInt)).gu().hashCode();
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
    {
      if (mn())
        return 102;
      return 100;
    }
    return 101;
  }

  protected boolean mm()
  {
    return !mp();
  }

  protected boolean mn()
  {
    return mp();
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = getItemViewType(paramInt);
    switch (i)
    {
    default:
      throw new IllegalStateException("Unknown view type: " + i);
    case 100:
      a((c)paramViewHolder);
    case 102:
      return;
    case 101:
    }
    a((b)paramViewHolder, cc(am(paramInt)));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131493244:
    case 2131493146:
      do
      {
        return;
        e(t(paramView));
        return;
      }
      while (Kw == null);
      com.google.android.keep.util.e.B(paramView);
      b(bm(Kw));
      return;
    case 2131493242:
      com.google.android.keep.util.e.B(paramView);
      paramView = t(paramView);
      if (paramView != null)
      {
        Kt.f(paramView);
        a(bm(paramView.gu()), false);
      }
      Kw = null;
      return;
    case 2131493232:
      mq();
      return;
    case 2131493233:
      a(mo(), false);
      return;
    case 2131493236:
    }
    mr();
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    D.bO("LabelEditorAdapter_onCreateViewHolder");
    Ku = ((RecyclerView)paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
    Object localObject = null;
    switch (paramInt)
    {
    default:
      paramViewGroup = localObject;
    case 100:
    case 101:
    case 102:
    }
    while (true)
    {
      D.ot();
      return paramViewGroup;
      paramViewGroup = new c(localLayoutInflater.inflate(2130968705, paramViewGroup, false));
      continue;
      paramViewGroup = new b(localLayoutInflater.inflate(2130968709, paramViewGroup, false));
      continue;
      paramViewGroup = new a(localLayoutInflater.inflate(2130968706, paramViewGroup, false));
    }
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (Kx)
      {
        mr();
        return true;
      }
      if (Kw != null)
        b(bm(Kw));
    }
    return false;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramView.getId() == 2131493234))
      mq();
    do
    {
      do
        return;
      while (paramView.getId() != 2131493243);
      if (paramBoolean)
      {
        e(t(paramView));
        return;
      }
    }
    while (Kw == null);
    b(bm(Kw));
  }

  public static class a extends RecyclerView.ViewHolder
  {
    public final TextView KA;

    public a(View paramView)
    {
      super();
      KA = ((TextView)paramView.findViewById(2131493117));
    }
  }

  public static class b extends RecyclerView.ViewHolder
    implements TextWatcher
  {
    public final EditText KB;
    public final ImageView KC;
    public final ImageView KD;
    public final ImageView KE;
    public final ImageView KF;
    public final TextView KG;
    public final View KH;
    public final View KI;
    private n KJ;
    private Label hc;

    public b(View paramView)
    {
      super();
      KB = ((EditText)paramView.findViewById(2131493243));
      KC = ((ImageView)paramView.findViewById(2131492985));
      KD = ((ImageView)paramView.findViewById(2131493242));
      KE = ((ImageView)paramView.findViewById(2131493244));
      KF = ((ImageView)paramView.findViewById(2131493146));
      KG = ((TextView)paramView.findViewById(2131493235));
      KH = paramView.findViewById(2131493148);
      KI = paramView.findViewById(2131493237);
    }

    public void a(Label paramLabel, n paramn)
    {
      hc = paramLabel;
      itemView.setTag(paramLabel);
      KB.setText(paramLabel.getName());
      KB.addTextChangedListener(this);
      KJ = paramn;
    }

    public void afterTextChanged(Editable paramEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void ea()
    {
      KB.removeTextChangedListener(this);
      itemView.setTag(null);
      hc = null;
      KJ = null;
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((hc != null) && (KJ != null))
        KJ.a(hc, this, paramCharSequence.toString().trim());
    }
  }

  public static class c extends RecyclerView.ViewHolder
  {
    public final TextView KG;
    public final View KH;
    public final View KI;
    public final EditText KK;
    public final ImageView KL;
    public final ImageView KM;
    public final ImageView KN;

    public c(View paramView)
    {
      super();
      KK = ((EditText)paramView.findViewById(2131493234));
      KL = ((ImageView)paramView.findViewById(2131493232));
      KM = ((ImageView)paramView.findViewById(2131493233));
      KN = ((ImageView)paramView.findViewById(2131493236));
      KG = ((TextView)paramView.findViewById(2131493235));
      KH = paramView.findViewById(2131493148);
      KI = paramView.findViewById(2131493237);
    }
  }

  public static abstract interface d
  {
    public abstract void f(Label paramLabel);
  }
}