package com.google.android.keep.editor;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.browse.a;
import com.google.android.keep.f.c;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.p;
import com.google.android.keep.model.s;
import com.google.android.keep.model.x;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.ui.CollaborativeEditText;
import com.google.android.keep.ui.d;
import com.google.android.keep.util.e;
import java.util.Arrays;
import java.util.List;

public class TitleFragment extends p
  implements View.OnFocusChangeListener
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xc, ModelEventDispatcher.EventType.xh, ModelEventDispatcher.EventType.xw, ModelEventDispatcher.EventType.xx, ModelEventDispatcher.EventType.xn });
  private static int pr;
  private static int ps;
  private s hb;
  private TreeEntityModel kJ;
  private x lm;
  private EditTextFocusState nl = new EditTextFocusState();
  private CollaborativeEditText pn;
  private f po;
  private f.c pp;
  private f.c pq;

  private void B(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      pn.setFocusable(bool);
      pn.setFocusableInTouchMode(bool);
      if ((paramBoolean) && (TextUtils.isEmpty(pn.getText())))
        pn.setAlpha(0.0F);
      return;
    }
  }

  private void aB(int paramInt)
  {
    int i = pn.getPaddingLeft();
    int j = pn.getPaddingRight();
    if ((i == paramInt) && (j == paramInt))
      return;
    pn.setPadding(paramInt, pn.getPaddingTop(), paramInt, pn.getPaddingBottom());
    f.c localc1 = pq;
    f.c localc2 = pq;
    f.c localc3 = pp;
    pp.right = paramInt;
    localc3.left = paramInt;
    localc2.right = paramInt;
    localc1.left = paramInt;
  }

  private void dr()
  {
    pn.setOnEditorActionListener((TextView.OnEditorActionListener)getParentFragment());
    pn.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((TitleFragment.a(TitleFragment.this).isInitialized()) && (TitleFragment.b(TitleFragment.this)) && (TextUtils.isEmpty(paramAnonymousCharSequence)))
          TitleFragment.c(TitleFragment.this).n(2131230877, 2131231015);
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (TitleFragment.a(TitleFragment.this).isInitialized())
          TitleFragment.a(TitleFragment.this).setTitle(paramAnonymousCharSequence.toString());
        if (!TextUtils.isEmpty(paramAnonymousCharSequence))
          dq();
      }
    });
    pn.setFilters(new InputFilter[] { new d(getActivity()) });
    pn.setOnFocusChangeListener(this);
  }

  private void eV()
  {
    if (eY());
    for (f.c localc = pp; ; localc = pq)
    {
      pn.setPadding(localc.left, localc.top, localc.right, localc.bottom);
      return;
    }
  }

  private void eW()
  {
    String str = kJ.getTitle();
    if (!TextUtils.equals(str, getTitle()))
      pn.setText(str);
    eX();
  }

  private void eX()
  {
    if (hasFocus())
      return;
    if ((!TextUtils.isEmpty(getTitle())) || (eY()))
    {
      dq();
      return;
    }
    po.dB();
  }

  private boolean eY()
  {
    return ((a)Binder.a(getActivity(), a.class)).aM().eY();
  }

  private void et()
  {
    if (!nl.isValid())
      return;
    if (nl.kY)
      e.A(pn);
    pn.setSelection(nl.selectionStart, nl.selectionEnd);
    nl.clear();
  }

  private String getTitle()
  {
    return pn.getText().toString();
  }

  private boolean hasFocus()
  {
    return pn.hasFocus();
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xw }))
    {
      pn.b(lm.iQ());
      if (!lm.isActive())
        eW();
      if (!kJ.iP())
        break label115;
    }
    label115: for (int i = pr; ; i = ps)
    {
      aB(i);
      B(kJ.jx());
      et();
      return;
      if (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xx }))
        break;
      pn.lY();
      break;
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

  protected void dq()
  {
    po.dA();
    if ((hasFocus()) || (!TextUtils.isEmpty(getTitle())))
      po.dC();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    kJ = ((TreeEntityModel)e(TreeEntityModel.class));
    lm = ((x)e(x.class));
    hb = ((s)Binder.g(getActivity()).a(s.class));
    eV();
    dr();
    if ((paramBundle != null) && (paramBundle.getParcelable("TitleFragment_key_focus_state") != null))
      nl = ((EditTextFocusState)paramBundle.getParcelable("TitleFragment_key_focus_state"));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968700, paramViewGroup, false);
    pn = ((CollaborativeEditText)paramLayoutInflater.findViewById(2131493226));
    pq = new f.c(pn.getPaddingLeft(), pn.getResources().getDimensionPixelSize(2131427551), pn.getPaddingRight(), pn.getResources().getDimensionPixelSize(2131427552));
    pp = new f.c(pn.getPaddingLeft(), pn.getResources().getDimensionPixelSize(2131427549), pn.getPaddingRight(), pn.getResources().getDimensionPixelSize(2131427550));
    pr = (int)getResources().getDimension(2131427533);
    ps = (int)getResources().getDimension(2131427530);
    pn.setAlpha(0.0F);
    po = new f(pn, pq, pp);
    return paramLayoutInflater;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((!paramBoolean) && (TextUtils.isEmpty(getTitle())))
      po.dD();
    while (!paramBoolean)
      return;
    po.dC();
    e.A(pn);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (pn.hasFocus())
    {
      nl.ai(pn.getSelectionStart()).aj(pn.getSelectionEnd()).w(true);
      paramBundle.putParcelable("TitleFragment_key_focus_state", nl);
    }
  }

  public void onStop()
  {
    super.onStop();
    pn.lY();
  }
}