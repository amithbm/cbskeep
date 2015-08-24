package com.android.ex.chips.recipientchip;

import android.graphics.Canvas;
import android.graphics.Rect;

public abstract interface DrawableRecipientChip extends BaseRecipientChip
{
  public abstract void draw(Canvas paramCanvas);

  public abstract Rect getBounds();
}