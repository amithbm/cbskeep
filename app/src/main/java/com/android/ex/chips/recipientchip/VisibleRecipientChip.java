package com.android.ex.chips.recipientchip;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.android.ex.chips.RecipientEntry;

public class VisibleRecipientChip extends ImageSpan
  implements DrawableRecipientChip
{
  private final SimpleRecipientChip mDelegate;

  public VisibleRecipientChip(Drawable paramDrawable, RecipientEntry paramRecipientEntry, int paramInt)
  {
    super(paramDrawable, paramInt);
    mDelegate = new SimpleRecipientChip(paramRecipientEntry);
  }

  public void draw(Canvas paramCanvas)
  {
    getDrawable().draw(paramCanvas);
  }

  public Rect getBounds()
  {
    return getDrawable().getBounds();
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

  public String toString()
  {
    return mDelegate.toString();
  }
}