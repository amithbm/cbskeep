package com.android.ex.chips.recipientchip;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import com.android.ex.chips.RecipientEntry;

public class InvisibleRecipientChip extends ReplacementSpan
  implements DrawableRecipientChip
{
  private final SimpleRecipientChip mDelegate;

  public InvisibleRecipientChip(RecipientEntry paramRecipientEntry)
  {
    mDelegate = new SimpleRecipientChip(paramRecipientEntry);
  }

  public void draw(Canvas paramCanvas)
  {
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
  }

  public Rect getBounds()
  {
    return new Rect(0, 0, 0, 0);
  }

  public long getContactId()
  {
    return mDelegate.getContactId();
  }

  public long getDataId()
  {
    return mDelegate.getDataId();
  }

  public Long getDirectoryId()
  {
    return mDelegate.getDirectoryId();
  }

  public RecipientEntry getEntry()
  {
    return mDelegate.getEntry();
  }

  public String getLookupKey()
  {
    return mDelegate.getLookupKey();
  }

  public CharSequence getOriginalText()
  {
    return mDelegate.getOriginalText();
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return 0;
  }

  public CharSequence getValue()
  {
    return mDelegate.getValue();
  }

  public boolean isSelected()
  {
    return mDelegate.isSelected();
  }

  public void setOriginalText(String paramString)
  {
    mDelegate.setOriginalText(paramString);
  }

  public void setSelected(boolean paramBoolean)
  {
    mDelegate.setSelected(paramBoolean);
  }
}