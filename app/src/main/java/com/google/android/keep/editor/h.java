package com.google.android.keep.editor;

import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.google.android.gms.drive.realtime.CollaborativeMap;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.x.b;
import com.google.android.keep.ui.ListItemEditText;
import com.google.android.keep.ui.ListItemEditText.a;
import com.google.android.keep.util.e;

public class h extends RecyclerView.ViewHolder
{
  private Handler mHandler = new Handler();
  private final ImageView mj;
  private final CheckBox mk;
  private final ImageView ml;
  private final ListItemEditText mm;
  private TextWatcher mn;
  private ListItemEditText.a mo;
  private CompoundButton.OnCheckedChangeListener mp;
  private View.OnClickListener mq;
  private ListItemsAdapter.i mr;
  private x.b ms;
  protected ListItem mt;
  private boolean mu;
  private int mv = -1;
  private View.OnFocusChangeListener mw = new View.OnFocusChangeListener()
  {
    public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      paramAnonymousView = h.b(h.this);
      if (paramAnonymousBoolean);
      for (int i = 0; ; i = 4)
      {
        paramAnonymousView.setVisibility(i);
        return;
      }
    }
  };

  public h(View paramView)
  {
    super(paramView);
    mk = ((CheckBox)paramView.findViewById(2131492998));
    mm = ((ListItemEditText)paramView.findViewById(2131493075));
    ml = ((ImageView)paramView.findViewById(2131493180));
    mj = ((ImageView)paramView.findViewById(2131493179));
    mj.setVisibility(4);
  }

  private void A(boolean paramBoolean)
  {
    if (!mm.hasFocus())
      mm.requestFocus();
    if (paramBoolean)
      e.A(mm);
  }

  private void ed()
  {
    if ((mt == null) || (!mt.hy()))
      return;
    mm.lY();
    mm.b(mt.hv());
    if (ms == null)
      ms = new x.b(mt);
    CollaborativeMap localCollaborativeMap = mt.hw();
    localCollaborativeMap.removeValueChangedListener(ms);
    localCollaborativeMap.addValueChangedListener(ms);
  }

  private void ee()
  {
    mm.lY();
    if ((mt != null) && (mt.hy()))
      mt.hw().removeValueChangedListener(ms);
  }

  public void B(boolean paramBoolean)
  {
    int j = 4;
    boolean bool;
    ImageView localImageView;
    if (!paramBoolean)
    {
      bool = true;
      mm.setFocusable(bool);
      mm.setFocusableInTouchMode(bool);
      mk.setEnabled(bool);
      localImageView = ml;
      if (!paramBoolean)
        break label79;
      i = 4;
      label48: localImageView.setVisibility(i);
      localImageView = mj;
      if (!paramBoolean)
        break label90;
    }
    label79: label90: for (int i = j; ; i = mj.getVisibility())
    {
      localImageView.setVisibility(i);
      return;
      bool = false;
      break;
      i = ml.getVisibility();
      break label48;
    }
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    A(paramBoolean);
    mm.setSelection(paramInt1, paramInt2);
  }

  public void a(TextWatcher paramTextWatcher)
  {
    mn = paramTextWatcher;
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    mq = paramOnClickListener;
  }

  public void a(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    mp = paramOnCheckedChangeListener;
  }

  public void a(ListItemsAdapter.i parami)
  {
    mr = parami;
  }

  public void a(ListItem paramListItem, int paramInt, boolean paramBoolean)
  {
    mt = paramListItem;
    mv = paramInt;
    mu = paramBoolean;
    mm.setTag(paramListItem.gu());
    mk.setTag(paramListItem.gu());
    paramListItem = mj;
    if (mu);
    for (paramInt = 0; ; paramInt = 4)
    {
      paramListItem.setVisibility(paramInt);
      return;
    }
  }

  public void a(ListItemEditText.a parama)
  {
    mo = parama;
  }

  public void b(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        h.a(h.this, paramBoolean);
        h.a(h.this).setSelection(paramInt1, paramInt2);
      }
    });
  }

  public ListItem dX()
  {
    return mt;
  }

  public ListItemEditText dY()
  {
    return mm;
  }

  public int dZ()
  {
    return mv;
  }

  public void ea()
  {
    mt = null;
    mv = -1;
    mu = false;
    mm.setTag(null);
    mk.setTag(null);
    mj.setVisibility(4);
  }

  public void eb()
  {
    mm.addTextChangedListener(mn);
    mm.a(mo);
    mm.setOnFocusChangeListener(mw);
    mk.setOnCheckedChangeListener(mp);
    ml.setOnClickListener(mq);
    ImageView localImageView = mj;
    if (mu);
    for (ListItemsAdapter.i locali = mr; ; locali = null)
    {
      localImageView.setOnTouchListener(locali);
      ed();
      return;
    }
  }

  public void ec()
  {
    mm.removeTextChangedListener(mn);
    mm.a(null);
    mm.setOnFocusChangeListener(null);
    mk.setOnCheckedChangeListener(null);
    mj.setOnTouchListener(null);
    ml.setOnClickListener(null);
    ee();
  }

  public String getText()
  {
    return mm.getText().toString();
  }

  public void setChecked(boolean paramBoolean)
  {
    mk.setChecked(paramBoolean);
    mm.setChecked(paramBoolean);
  }

  public void setText(String paramString)
  {
    mm.setText(paramString);
  }
}