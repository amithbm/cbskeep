package com.google.android.keep.browse;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.TextView.BufferType;
import com.google.android.keep.a.a;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.ui.KeepTextView;
import com.google.android.keep.util.r;
import java.util.ArrayList;

public class TextNoteView extends KeepTextView
{
  private static int jj = -1;
  private static int jk = -1;
  private static int jl = -1;
  private static ArrayList<Integer> jm;
  private static int[] jn;
  private static String jo;
  private static int jp = -1;
  private int jf;
  private int jg;
  private int jh = -1;
  private boolean ji = false;

  public TextNoteView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TextNoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }

  public TextNoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (jm == null)
    {
      Resources localResources = getResources();
      int[] arrayOfInt = localResources.getIntArray(2131689485);
      jm = new ArrayList();
      int i = arrayOfInt.length;
      paramInt = 0;
      while (paramInt < i)
      {
        int j = arrayOfInt[paramInt];
        jm.add(Integer.valueOf(j));
        paramInt += 1;
      }
      jk = localResources.getDimensionPixelSize(2131427546);
      jl = localResources.getDimensionPixelSize(2131427545);
      jj = localResources.getDimensionPixelSize(2131427547);
      jn = localResources.getIntArray(2131689486);
      jo = localResources.getString(2131230839);
      jp = localResources.getInteger(2131361815);
    }
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null)
      return;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.TextNoteView);
    ji = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }

  private void a(Layout paramLayout, CharSequence paramCharSequence)
  {
    a(paramLayout, paramCharSequence, cM());
    cL();
    ac(cK());
  }

  private void a(Layout paramLayout, CharSequence paramCharSequence, int paramInt)
  {
    if (paramLayout == null)
      r.d("Keep", "unable to get layout for resizinglayout", new Object[0]);
    do
    {
      return;
      i = paramLayout.getLineCount();
      setMaxLines(paramInt);
    }
    while (i <= paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramCharSequence.toString().substring(paramLayout.getLineStart(paramInt - 1));
    Object localObject = TextUtils.ellipsize(str, getPaint(), paramLayout.getWidth(), TextUtils.TruncateAt.END);
    int i = ((CharSequence)localObject).toString().indexOf('\n');
    if (i == 0)
      localObject = jo;
    while (true)
    {
      localStringBuilder.append(paramCharSequence, 0, paramLayout.getLineStart(paramInt - 1));
      if (!TextUtils.isEmpty((CharSequence)localObject))
        localStringBuilder.append((CharSequence)localObject, 0, ((CharSequence)localObject).length());
      setText(localStringBuilder, TextView.BufferType.SPANNABLE);
      return;
      if (i > 0)
        localObject = str.substring(0, i) + jo;
    }
  }

  private static final boolean a(char paramChar1, char paramChar2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramChar1 != ' ') && (paramChar1 != '\t') && (paramChar1 != '\n') && (((paramChar1 != '/') && (paramChar1 != '-')) || (Character.isDigit(paramChar2))))
    {
      bool1 = bool2;
      if (paramChar1 >= '⺀')
      {
        bool1 = bool2;
        if (a(paramChar1, true))
        {
          bool1 = bool2;
          if (!a(paramChar2, false));
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  private static final boolean a(char paramChar, boolean paramBoolean)
  {
    if ((paramChar >= '⺀') && (paramChar <= '⿿'));
    do
    {
      do
      {
        do
        {
          do
            return true;
          while (paramChar == '　');
          if ((paramChar < '぀') || (paramChar > 'ゟ'))
            break;
        }
        while (paramBoolean);
        switch (paramChar)
        {
        default:
          return true;
        case 'ぁ':
        case 'ぃ':
        case 'ぅ':
        case 'ぇ':
        case 'ぉ':
        case 'っ':
        case 'ゃ':
        case 'ゅ':
        case 'ょ':
        case 'ゎ':
        case 'ゕ':
        case 'ゖ':
        case '゛':
        case '゜':
        case 'ゝ':
        case 'ゞ':
        }
        return false;
        if ((paramChar < '゠') || (paramChar > 'ヿ'))
          break;
      }
      while (paramBoolean);
      switch (paramChar)
      {
      default:
        return true;
      case '゠':
      case 'ァ':
      case 'ィ':
      case 'ゥ':
      case 'ェ':
      case 'ォ':
      case 'ッ':
      case 'ャ':
      case 'ュ':
      case 'ョ':
      case 'ヮ':
      case 'ヵ':
      case 'ヶ':
      case '・':
      case 'ー':
      case 'ヽ':
      case 'ヾ':
      }
      return false;
    }
    while (((paramChar >= '㐀') && (paramChar <= '䶵')) || ((paramChar >= '一') && (paramChar <= 40891)) || ((paramChar >= 63744) && (paramChar <= 64217)) || ((paramChar >= 40960) && (paramChar <= 42127)) || ((paramChar >= 42128) && (paramChar <= 42191)) || ((paramChar >= 65122) && (paramChar <= 65126)) || ((paramChar >= 65296) && (paramChar <= 65305)));
    return false;
  }

  private void ac(int paramInt)
  {
    jh = paramInt;
  }

  private boolean ad(int paramInt)
  {
    return jl - jj < paramInt;
  }

  private int ae(int paramInt)
  {
    paramInt = jm.indexOf(Integer.valueOf(paramInt));
    if (paramInt == 0)
      return -1;
    return ((Integer)jm.get(paramInt - 1)).intValue();
  }

  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1);
    do
    {
      return;
      setTextSize(paramInt);
    }
    while (jf == 0);
    CharSequence localCharSequence = getText();
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      cL();
      ac(-1);
      return;
    }
    measure(jf, jg);
    Layout localLayout = getLayout();
    if (localLayout == null)
    {
      r.e("Keep", "unable to get layout for resizinglayout", new Object[0]);
      ac(-1);
      return;
    }
    int i = localLayout.getHeight();
    if (i == jk)
    {
      cL();
      ac(paramInt);
      return;
    }
    if (i > jk)
    {
      if (paramInt == cK())
      {
        a(localLayout, localCharSequence);
        return;
      }
      b(ae(paramInt), true);
      return;
    }
    if (!b(localLayout, localCharSequence))
    {
      if ((!paramBoolean) && (!ad(i)))
      {
        b(k(paramInt, i), true);
        return;
      }
      cL();
      ac(paramInt);
      return;
    }
    if (paramInt == cK())
    {
      a(localLayout, localCharSequence);
      return;
    }
    b(ae(paramInt), true);
  }

  private boolean b(Layout paramLayout, CharSequence paramCharSequence)
  {
    int j = paramLayout.getLineCount();
    int i = 1;
    while (i < j)
    {
      int k = paramLayout.getLineStart(i);
      if (k > 0)
      {
        char c2 = paramCharSequence.charAt(k - 1);
        if (k < paramCharSequence.length() - 1);
        for (char c1 = paramCharSequence.charAt(k); !a(c2, c1); c1 = ' ')
          return true;
      }
      i += 1;
    }
    return false;
  }

  private void cJ()
  {
    b(cK(), false);
  }

  private int cK()
  {
    return ((Integer)jm.get(0)).intValue();
  }

  private void cL()
  {
    setMinHeight(jl);
    setMaxHeight(jk);
  }

  private int cM()
  {
    float f = getPaint().getFontMetrics(null);
    if (f == 0.0F)
      return 1;
    return (int)Math.floor(jk / f);
  }

  private int k(int paramInt1, int paramInt2)
  {
    float f = jk / paramInt2 * paramInt1;
    int j = jm.indexOf(Integer.valueOf(paramInt1));
    if (j == jm.size() - 1)
    {
      paramInt1 = -1;
      return paramInt1;
    }
    paramInt2 = jm.size() - 1;
    while (true)
    {
      if (paramInt2 <= j)
        break label86;
      int i = ((Integer)jm.get(paramInt2)).intValue();
      paramInt1 = i;
      if (i < f)
        break;
      paramInt2 -= 1;
    }
    label86: return -1;
  }

  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    jf = View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingLeft() - getPaddingRight(), 1073741824);
    setEllipsize(null);
    setText(paramCharSequence, TextView.BufferType.SPANNABLE);
    if (ji)
    {
      if (paramInt1 == -1)
      {
        cJ();
        return;
      }
      b(paramInt1, false);
      return;
    }
    b(cK(), true);
  }

  public int cI()
  {
    return jh;
  }

  public boolean hasOverlappingRendering()
  {
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    Object localObject1 = getText();
    if ((localObject1 instanceof Spanned))
    {
      float f1 = paramMotionEvent.getX() - getTotalPaddingLeft();
      float f2 = paramMotionEvent.getY() - getTotalPaddingTop();
      Object localObject2 = getLayout();
      if ((f2 < 0.0F) || (f2 > ((Layout)localObject2).getLineBottom(((Layout)localObject2).getLineCount() - 1)))
        bool = false;
      int i;
      do
      {
        return bool;
        i = ((Layout)localObject2).getLineForVertical((int)f2);
        if ((f1 < ((Layout)localObject2).getLineLeft(i)) || (((Layout)localObject2).getLineRight(i) < f1))
          return false;
        i = ((Layout)localObject2).getOffsetForHorizontal(i, f1);
        localObject1 = (Spannable)localObject1;
        localObject2 = (ClickableSpan[])((Spannable)localObject1).getSpans(i, i, ClickableSpan.class);
        if (localObject2.length == 0)
          break;
        i = paramMotionEvent.getAction();
        if (i == 1)
        {
          localObject2[0].onClick(this);
          return true;
        }
      }
      while (i != 0);
      Selection.setSelection((Spannable)localObject1, ((Spannable)localObject1).getSpanStart(localObject2[0]), ((Spannable)localObject1).getSpanEnd(localObject2[0]));
      return true;
    }
    return false;
  }

  public void r(boolean paramBoolean)
  {
    ji = paramBoolean;
  }

  public void setTextSize(float paramFloat)
  {
    int i = jm.indexOf(Integer.valueOf((int)paramFloat));
    Typeface localTypeface = null;
    if (i >= 0)
      switch (jn[i])
      {
      default:
      case 0:
      case 1:
      case 2:
      }
    while (true)
    {
      setTypeface(localTypeface);
      super.setTextSize(paramFloat);
      return;
      localTypeface = KeepApplication.Z();
      continue;
      localTypeface = KeepApplication.ab();
      continue;
      localTypeface = KeepApplication.ac();
    }
  }
}