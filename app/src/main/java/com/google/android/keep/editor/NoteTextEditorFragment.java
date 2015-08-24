package com.google.android.keep.editor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.browse.a;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.n;
import com.google.android.keep.model.p;
import com.google.android.keep.model.s;
import com.google.android.keep.model.x;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.ui.CollaborativeEditText;
import com.google.android.keep.ui.d;
import com.google.android.keep.ui.j.b.a;
import com.google.android.keep.util.e;
import java.util.Arrays;
import java.util.List;

public class NoteTextEditorFragment extends p
  implements j.b.a
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wG, ModelEventDispatcher.EventType.xh, ModelEventDispatcher.EventType.wN, ModelEventDispatcher.EventType.xw, ModelEventDispatcher.EventType.xx, ModelEventDispatcher.EventType.xn });
  private TreeEntityModel kJ;
  private n la;
  private x lm;
  private boolean mF;
  private View nh;
  private CollaborativeEditText ni;
  private s nj;
  private String nk;
  private EditTextFocusState nl = new EditTextFocusState();

  private void B(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (paramBoolean = true; ; paramBoolean = false)
    {
      ni.setFocusable(paramBoolean);
      ni.setFocusableInTouchMode(paramBoolean);
      return;
    }
  }

  private boolean b(ModelEventDispatcher.a parama)
  {
    if (lm.isActive())
      if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xw, ModelEventDispatcher.EventType.xh }))
        return true;
    return false;
  }

  private void c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
      e.A(ni);
    ni.setSelection(paramInt1, paramInt2);
  }

  private void dr()
  {
    ni.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (NoteTextEditorFragment.a(NoteTextEditorFragment.this).isInitialized())
        {
          ListItem localListItem = (ListItem)NoteTextEditorFragment.a(NoteTextEditorFragment.this).G(NoteTextEditorFragment.b(NoteTextEditorFragment.this));
          if ((localListItem != null) && (!NoteTextEditorFragment.c(NoteTextEditorFragment.this)))
            localListItem.Y(paramAnonymousCharSequence.toString());
        }
      }
    });
    ni.a(this);
    ni.setFilters(new InputFilter[] { new d(getActivity()) });
  }

  private void eq()
  {
    if (!kJ.isInitialized())
      return;
    View localView = nh;
    if (kJ.iP());
    for (int i = 8; ; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }

  private void er()
  {
    if (!la.isInitialized());
    while (true)
    {
      return;
      Object localObject = (ListItem)la.gE();
      if (localObject != null)
      {
        nk = ((ListItem)localObject).gu();
        if (mF);
        for (localObject = ((ListItem)localObject).hs(); !TextUtils.equals((CharSequence)localObject, getText()); localObject = ((ListItem)localObject).getText())
        {
          ni.aB(true);
          ni.setText((CharSequence)localObject);
          ni.aB(false);
          return;
        }
      }
    }
  }

  private void et()
  {
    if (!nl.isValid())
      return;
    c(nl.selectionStart, nl.selectionEnd, nl.kY);
    nl.clear();
  }

  private String getText()
  {
    return ni.getText().toString();
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    if (kJ.iP())
    {
      if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xh }))
        ni.lY();
      eq();
      return;
    }
    if (b(parama))
      ni.b(lm.iR());
    while (true)
    {
      B(kJ.jx());
      eq();
      er();
      et();
      return;
      if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xx }))
        ni.lY();
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

  protected void es()
  {
    if ((!kJ.isInitialized()) || (kJ.iP()))
      return;
    c(0, 0, true);
  }

  public void eu()
  {
    nj.ab(true);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    kJ = ((TreeEntityModel)e(TreeEntityModel.class));
    la = ((n)e(n.class));
    lm = ((x)e(x.class));
    nj = ((s)e(s.class));
    Object localObject = getActivity();
    int i = (int)((Activity)localObject).getResources().getDimension(2131427530);
    e.setPaddingRelative(ni, i, ni.getPaddingTop(), i, ni.getPaddingBottom());
    localObject = (a)Binder.a((Context)localObject, a.class);
    dr();
    eq();
    er();
    if ((paramBundle != null) && (paramBundle.getParcelable("NoteTextEditorFragment_key_focus_state") != null))
      nl = ((EditTextFocusState)paramBundle.getParcelable("NoteTextEditorFragment_key_focus_state"));
    while (!((a)localObject).aM().eY())
      return;
    paramBundle = (ListItem)la.gE();
    if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle.getText())));
    for (i = 0; ; i = paramBundle.getText().length())
    {
      nl.ai(i).aj(i).w(true);
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    nh = paramLayoutInflater.inflate(2130968699, paramViewGroup, false);
    ni = ((CollaborativeEditText)nh.findViewById(2131493225));
    return nh;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (ni.hasFocus())
    {
      nl.ai(ni.getSelectionStart()).aj(ni.getSelectionEnd()).w(true);
      paramBundle.putParcelable("NoteTextEditorFragment_key_focus_state", nl);
    }
  }

  public void onStop()
  {
    super.onStop();
    ni.lY();
  }

  public void x(boolean paramBoolean)
  {
    mF = paramBoolean;
  }
}