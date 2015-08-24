package com.google.android.keep.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.Checkable;
import com.google.android.keep.util.y;

public class ListItemEditText extends CollaborativeEditText
  implements Checkable
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private boolean Jx = false;
  private boolean Lt = false;
  private TextWatcher Lu;
  private a mo;

  public ListItemEditText(Context paramContext)
  {
    super(paramContext);
  }

  public ListItemEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ListItemEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void mt()
  {
    if ((getSelectionStart() == 0) && (getSelectionEnd() == 0))
      mo.em();
  }

  public void a(a parama)
  {
    mo = parama;
    if (Lu == null)
    {
      Lu = new y()
      {
        public void a(Editable paramAnonymousEditable, int paramAnonymousInt)
        {
          String str = paramAnonymousEditable.toString();
          if ((ListItemEditText.a(ListItemEditText.this) != null) && (!ListItemEditText.b(ListItemEditText.this)))
          {
            paramAnonymousEditable.delete(paramAnonymousInt, paramAnonymousInt + 1);
            ListItemEditText.a(ListItemEditText.this).b(str, paramAnonymousInt);
          }
        }
      };
      addTextChangedListener(Lu);
    }
  }

  public void c(int paramInt, String paramString)
  {
    Lt = true;
    super.c(paramInt, paramString);
    Lt = false;
  }

  public boolean isChecked()
  {
    return Jx;
  }

  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked())
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    return arrayOfInt;
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return new b(super.onCreateInputConnection(paramEditorInfo), true);
  }

  public void setChecked(boolean paramBoolean)
  {
    if (Jx != paramBoolean)
    {
      Jx = paramBoolean;
      if (!Jx)
        break label36;
      setPaintFlags(getPaintFlags() | 0x10);
    }
    while (true)
    {
      refreshDrawableState();
      return;
      label36: setPaintFlags(getPaintFlags() & 0xFFFFFFEF);
    }
  }

  public void setSelection(int paramInt1, int paramInt2)
  {
    super.setSelection(paramInt1, paramInt2);
    if (getSelectionStart() < getSelectionEnd())
      performLongClick();
  }

  public void toggle()
  {
    if (!Jx);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void b(String paramString, int paramInt);

    public abstract void em();
  }

  private class b extends InputConnectionWrapper
  {
    public b(InputConnection paramBoolean, boolean arg3)
    {
      super(bool);
    }

    public boolean deleteSurroundingText(int paramInt1, int paramInt2)
    {
      if ((paramInt1 == 1) && (paramInt2 == 0))
        return (sendKeyEvent(new KeyEvent(0, 67))) && (sendKeyEvent(new KeyEvent(1, 67)));
      return super.deleteSurroundingText(paramInt1, paramInt2);
    }

    public boolean sendKeyEvent(KeyEvent paramKeyEvent)
    {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 67))
        ListItemEditText.c(ListItemEditText.this);
      return super.sendKeyEvent(paramKeyEvent);
    }
  }
}