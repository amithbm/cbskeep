package com.google.android.keep.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.l;
import com.google.android.keep.model.o;
import com.google.android.keep.model.s;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.D;
import com.google.android.keep.util.a;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class r extends p
  implements TextView.OnEditorActionListener, ModelEventDispatcher.b, e.a, q.b
{
  private long[] Az;
  private Integer KP;
  private EditText Lo;
  private ImageView Lp;
  private boolean Lq = false;
  private q Lr;
  private boolean hi = false;
  private o xI;

  private void br(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramString.trim())));
    do
    {
      return;
      paramString = fh.S(paramString);
    }
    while (paramString == null);
    a.a(Lo, getString(2131231362));
    hb.a(2131230867, 2131230990, 2131231023, null);
    Lr.g(paramString);
    long[] arrayOfLong = Az;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      fh.a(paramString.gu(), l);
      i += 1;
    }
    if (Az.length > 1);
    for (i = 2131231372; ; i = 2131231371)
    {
      a.a(eC, String.format(getString(i), new Object[] { paramString.getName() }));
      Lr.bp("");
      Lo.setText("");
      com.google.android.keep.util.e.B(Lo);
      return;
    }
  }

  private boolean bs(String paramString)
  {
    return (bo(paramString)) && (!mp()) && (!hi);
  }

  public static r e(long[] paramArrayOfLong)
  {
    r localr = new r();
    Bundle localBundle = new Bundle();
    localBundle.putLongArray("tree_entity_ids", paramArrayOfLong);
    localr.setArguments(localBundle);
    return localr;
  }

  protected String S()
  {
    return getString(2131230857);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    boolean bool2 = true;
    if ((!xI.ih()) || (Lq))
      return;
    Lq = true;
    if (fh.ho().size() == 0)
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          r.a(r.this).requestFocus();
          InputMethodManager localInputMethodManager = (InputMethodManager)r.a(r.this).getContext().getSystemService("input_method");
          if (localInputMethodManager != null)
            localInputMethodManager.showSoftInput(r.a(r.this), 1);
        }
      }
      , 100L);
    parama = Lo.getText().toString();
    q localq = Lr;
    if ((bo(parama)) && (!mp()))
    {
      bool1 = true;
      localq.aI(bool1);
      localq = Lr;
      if ((!bo(parama)) || (!mp()))
        break label135;
    }
    label135: for (boolean bool1 = bool2; ; bool1 = false)
    {
      localq.aH(bool1);
      return;
      bool1 = false;
      break;
    }
  }

  public void a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean != hi)
    {
      Lr.aG(paramBoolean);
      hi = paramBoolean;
      if (paramBoolean)
        hb.a(2131230867, 2131231000, 2131231023, null);
    }
    q localq = Lr;
    if ((bo(paramString)) && (!mp()))
    {
      paramBoolean = true;
      localq.aI(paramBoolean);
      localq = Lr;
      if ((!bo(paramString)) || (!mp()))
        break label115;
    }
    label115: for (paramBoolean = bool; ; paramBoolean = false)
    {
      localq.aH(paramBoolean);
      Lr.bp(paramString);
      return;
      paramBoolean = false;
      break;
    }
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return ImmutableList.of(ModelEventDispatcher.EventType.wF);
  }

  public void bq(String paramString)
  {
    br(paramString);
  }

  public int getStatusBarColor()
  {
    if (KP == null)
      KP = Integer.valueOf(getResources().getColor(2131296394));
    return KP.intValue();
  }

  public void h(Label paramLabel)
  {
    int k = 1;
    Object localObject = Az;
    int m = localObject.length;
    int j = 0;
    int i = k;
    long l;
    if (j < m)
    {
      l = localObject[j];
      if (!fh.v(l).contains(paramLabel))
        i = 0;
    }
    else
    {
      localObject = Az;
      k = localObject.length;
      j = 0;
      label62: if (j >= k)
        break label121;
      l = localObject[j];
      if (i == 0)
        break label105;
      fh.b(paramLabel.gu(), l);
    }
    while (true)
    {
      j += 1;
      break label62;
      j += 1;
      break;
      label105: fh.a(paramLabel.gu(), l);
    }
    label121: localObject = hb;
    if (i != 0)
    {
      j = 2131230997;
      ((s)localObject).a(2131230867, j, 2131231023, null);
      if (i == 0)
        break label213;
      if (Az.length <= 1)
        break label206;
    }
    label206: for (i = 2131231374; ; i = 2131231373)
    {
      a.a(eC, String.format(getString(i), new Object[] { paramLabel.getName() }));
      Lr.notifyDataSetChanged();
      return;
      j = 2131230991;
      break;
    }
    label213: if (Az.length > 1);
    for (i = 2131231372; ; i = 2131231371)
      break;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    xI = new o(getActivity(), this, se);
    xI.e(l.class);
    Az = getArguments().getLongArray("tree_entity_ids");
    Lr = new q(getActivity(), fO(), Az, this);
    Lr.setHasStableIds(true);
    mRecyclerView.setAdapter(Lr);
    Lr.d(paramBundle);
    super.onActivityCreated(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    D.bO("LabelPickerFragment_onCreateView");
    eC = ((ViewGroup)paramLayoutInflater.inflate(2130968708, null));
    Lo = ((EditText)((ViewStub)eC.findViewById(2131493238)).inflate().findViewById(2131493246));
    Lo.addTextChangedListener(new e(this, ((Integer)Config.Pd.get()).intValue()));
    Lo.setOnEditorActionListener(this);
    Lp = ((ImageView)eC.findViewById(2131493245));
    Lp.setOnClickListener(this);
    paramLayoutInflater = new LinearLayoutManager(getActivity());
    paramLayoutInflater.setOrientation(1);
    mRecyclerView = ((RecyclerView)eC.findViewById(2131493240));
    mRecyclerView.setLayoutManager(paramLayoutInflater);
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    D.ot();
    return eC;
  }

  public void onDestroyView()
  {
    com.google.android.keep.util.e.B(Lo);
    super.onDestroyView();
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      paramTextView = Lr.ms();
      if (bs(paramTextView))
      {
        br(paramTextView);
        return true;
      }
      paramTextView = fh.P(paramTextView);
      if (paramTextView != null)
      {
        h(paramTextView);
        return true;
      }
    }
    return false;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Lr.e(paramBundle);
  }
}