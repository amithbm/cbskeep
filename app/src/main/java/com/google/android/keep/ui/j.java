package com.google.android.keep.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.net.Uri;
import android.text.Editable;
import android.text.Selection;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.a.a;
import com.google.android.keep.activities.LinkResolverActivity;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j extends EditText
{
  private a JA;
  private String JB;
  private boolean JC;
  private boolean JD;
  private boolean JE;
  private j.b.a JF;

  public j(Context paramContext)
  {
    this(paramContext, null);
  }

  public j(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }

  public j(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null)
      return;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.KeepEditText);
    JB = paramContext.getString(0);
    JC = paramContext.getBoolean(1, true);
    if ((((Boolean)Config.Pr.get()).booleanValue()) && (paramContext.getBoolean(2, false)));
    for (boolean bool = true; ; bool = false)
    {
      JD = bool;
      if (JD)
        JE = ((Boolean)Config.Ps.get()).booleanValue();
      paramContext.recycle();
      aC(false);
      return;
    }
  }

  private void aC(boolean paramBoolean)
  {
    int i = getInputType();
    if (paramBoolean);
    for (i = 0xFFF7FFFF & i | 0x8000; ; i = 0xFFFF7FFF & i | 0x80000)
    {
      setInputType(i);
      return;
    }
  }

  private int am(int paramInt)
  {
    return Math.min(Math.max(paramInt, 0), getText().length());
  }

  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (JC)
      setTypeface(e.d(paramContext, paramAttributeSet));
  }

  private void o(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(getContext(), LinkResolverActivity.class);
    localIntent.setData(Uri.parse(paramString1));
    localIntent.putExtra("android.intent.extra.TEXT", paramString2);
    getContext().startActivity(localIntent);
  }

  public void a(j.b.a parama)
  {
    JF = parama;
  }

  public boolean onCheckIsTextEditor()
  {
    return true;
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    Object localObject = localInputConnection;
    if (JD)
    {
      localObject = new b(localInputConnection, this);
      ((b)localObject).a(JF);
      ((b)localObject).aD(JE);
    }
    if (JB == null)
      return localObject;
    if ((paramEditorInfo.imeOptions & 0x40000000) != 0)
      paramEditorInfo.imeOptions &= -1073741825;
    int i = paramEditorInfo.imeOptions;
    paramEditorInfo.imeOptions ^= i & 0xFF;
    if ("actionDone".equals(JB))
    {
      paramEditorInfo.imeOptions |= 6;
      return localObject;
    }
    if ("actionNext".equals(JB))
    {
      paramEditorInfo.imeOptions |= 5;
      return localObject;
    }
    throw new IllegalStateException("Unknown ex:imeOptions " + JB);
  }

  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    return false;
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    aC(paramBoolean);
  }

  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (JA != null))
      JA.dz();
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int j;
    int k;
    int i;
    if (paramMotionEvent.getAction() == 1)
    {
      j = getSelectionStart();
      if (j == getSelectionEnd())
      {
        paramMotionEvent = getUrls();
        if (paramMotionEvent != null)
        {
          k = paramMotionEvent.length;
          i = 0;
        }
      }
    }
    while (true)
    {
      if (i < k)
      {
        Object localObject = paramMotionEvent[i];
        int m = getText().getSpanStart(localObject);
        int n = getText().getSpanEnd(localObject);
        if ((j > m) && (j < n))
          o(localObject.getURL(), getText().subSequence(m, n).toString());
      }
      else
      {
        return bool;
      }
      i += 1;
    }
  }

  public void setSelection(int paramInt1, int paramInt2)
  {
    super.setSelection(am(paramInt1), am(paramInt2));
  }

  public static abstract interface a
  {
    public abstract void dz();
  }

  public static class b extends InputConnectionWrapper
  {
    private static final Pattern JG = Pattern.compile("^(\\s+|\\s*[-+*]\\s*)");
    private static final Pattern JH = Pattern.compile("^(\\s+|\\s*[-+*]\\s*)\\w");
    private boolean JE;
    private a JF;
    private EditText JI;
    private boolean JJ;
    private int JK;

    public b(InputConnection paramInputConnection, EditText paramEditText)
    {
      super(true);
      JI = paramEditText;
    }

    private CharSequence a(CharSequence paramCharSequence, int paramInt)
    {
      paramCharSequence = paramCharSequence.subSequence(0, paramInt).toString().split("(\r|\n|\r\n)", -1);
      return paramCharSequence[(paramCharSequence.length - 1)];
    }

    private void a(Editable paramEditable, Matcher paramMatcher, int paramInt)
    {
      paramEditable.delete(paramInt - paramMatcher.group(1).length(), paramInt);
    }

    private boolean mg()
    {
      Editable localEditable = JI.getText();
      int i = Selection.getSelectionStart(localEditable);
      if (i >= 0)
      {
        Object localObject = a(localEditable, i);
        Matcher localMatcher = JH.matcher((CharSequence)localObject);
        if (localMatcher.find())
        {
          localObject = "\n" + localMatcher.group(1);
          JJ = true;
          JK = (((String)localObject).length() + i);
          if (JF != null)
            JF.eu();
          localEditable.insert(i, (CharSequence)localObject);
          return true;
        }
        if ((JJ) && (JK == i))
        {
          JJ = false;
          localObject = JG.matcher((CharSequence)localObject);
          if (((Matcher)localObject).matches())
          {
            a(localEditable, (Matcher)localObject, i);
            return false;
          }
        }
      }
      return false;
    }

    private boolean mh()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (JJ)
      {
        JJ = false;
        Editable localEditable = JI.getText();
        int i = Selection.getSelectionStart(localEditable);
        bool1 = bool2;
        if (i >= 0)
        {
          bool1 = bool2;
          if (i == JK)
          {
            Object localObject = a(localEditable, i);
            localObject = JG.matcher((CharSequence)localObject);
            bool1 = bool2;
            if (((Matcher)localObject).matches())
            {
              a(localEditable, (Matcher)localObject, i);
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }

    public void a(a parama)
    {
      JF = parama;
    }

    public void aD(boolean paramBoolean)
    {
      JE = paramBoolean;
    }

    public boolean commitText(CharSequence paramCharSequence, int paramInt)
    {
      if (("\n".equals(paramCharSequence.toString())) && (mg()))
        return true;
      JJ = false;
      return super.commitText(paramCharSequence, paramInt);
    }

    public boolean deleteSurroundingText(int paramInt1, int paramInt2)
    {
      if (mh())
        return true;
      return super.deleteSurroundingText(paramInt1, paramInt2);
    }

    public boolean sendKeyEvent(KeyEvent paramKeyEvent)
    {
      if ((JE) && (paramKeyEvent.getAction() == 0))
        if (paramKeyEvent.getKeyCode() == 66)
        {
          if (!mg());
        }
        else
          while ((paramKeyEvent.getKeyCode() == 67) && (mh()))
            return true;
      return super.sendKeyEvent(paramKeyEvent);
    }

    public static abstract interface a
    {
      public abstract void eu();
    }
  }
}