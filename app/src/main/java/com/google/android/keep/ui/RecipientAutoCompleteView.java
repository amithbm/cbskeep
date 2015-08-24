package com.google.android.keep.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ScrollView;
import com.android.ex.chips.RecipientEditTextView;
import com.android.ex.chips.RecipientEntry;
import com.google.android.keep.y;

public class RecipientAutoCompleteView extends RecipientEditTextView
{
  private int LK = getHeight();
  private a LL;
  private int minHeight;

  public RecipientAutoCompleteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDropdownChipLayouter(new f(LayoutInflater.from(paramContext), paramContext));
    minHeight = paramContext.getResources().getDimensionPixelOffset(2131427569);
  }

  public void a(a parama)
  {
    LL = parama;
  }

  protected void drawIconOnCanvas(Bitmap paramBitmap, Canvas paramCanvas, Paint paramPaint, RectF paramRectF1, RectF paramRectF2)
  {
    y.a(paramBitmap, paramCanvas, paramRectF1, paramRectF2);
  }

  protected float getTextYOffset(String paramString, TextPaint paramTextPaint, int paramInt)
  {
    return paramInt - (paramInt - LK) / 2;
  }

  protected void onChipCreated(RecipientEntry paramRecipientEntry)
  {
    if (LL != null)
      LL.b(paramRecipientEntry);
  }

  protected void scrollBottomIntoView()
  {
    ScrollView localScrollView = getScrollView();
    if (localScrollView == null);
    int i;
    int j;
    do
    {
      return;
      int[] arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      i = getHeight();
      i = arrayOfInt[1] + i;
      localScrollView.getLocationOnScreen(arrayOfInt);
      j = arrayOfInt[1] + minHeight;
    }
    while (i <= j);
    localScrollView.scrollBy(0, i - j);
  }

  public static abstract interface a
  {
    public abstract void b(RecipientEntry paramRecipientEntry);
  }
}