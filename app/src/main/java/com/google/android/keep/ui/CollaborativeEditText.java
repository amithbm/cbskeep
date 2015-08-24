package com.google.android.keep.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.keep.sharing.b;
import com.google.android.keep.sharing.b.a;
import com.google.android.keep.util.r;

public class CollaborativeEditText extends j
  implements b.a
{
  private b IL;
  private TextWatcher IM;

  public CollaborativeEditText(Context paramContext)
  {
    super(paramContext);
  }

  public CollaborativeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CollaborativeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void aB(boolean paramBoolean)
  {
    if (IL != null)
      IL.ao(paramBoolean);
  }

  public void b(CollaborativeString paramCollaborativeString)
  {
    r.a("Keep", "bindCollaborativeString from view: " + getId(), new Object[0]);
    String str = paramCollaborativeString.toString();
    if (!TextUtils.equals(str, getText()))
      setText(str);
    IL = new b(paramCollaborativeString, this);
    IM = new a(IL);
    addTextChangedListener(IM);
  }

  public void c(int paramInt, String paramString)
  {
    Editable localEditable = getEditableText();
    int i = localEditable.length();
    int j = getSelectionEnd();
    if (paramInt > i);
    while (true)
    {
      localEditable.insert(i, paramString);
      if (j == paramInt)
        setSelection(j);
      return;
      i = paramInt;
    }
  }

  public void d(int paramInt, String paramString)
  {
    getEditableText().delete(paramInt, paramString.length() + paramInt);
  }

  public void lY()
  {
    if (IM != null)
    {
      removeTextChangedListener(IM);
      IM = null;
    }
    if (IL != null)
    {
      r.a("Keep", "unbindCollaborativeString from view: " + getId(), new Object[0]);
      IL.kN();
      IL = null;
    }
  }

  private class a
    implements TextWatcher
  {
    private b IN;

    public a(b arg2)
    {
      Object localObject;
      IN = localObject;
    }

    public void afterTextChanged(Editable paramEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (IN != null)
        IN.a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
}