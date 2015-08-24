package com.android.ex.chips.recipientchip;

import com.android.ex.chips.RecipientEntry;

abstract interface BaseRecipientChip
{
  public abstract long getContactId();

  public abstract long getDataId();

  public abstract Long getDirectoryId();

  public abstract RecipientEntry getEntry();

  public abstract String getLookupKey();

  public abstract CharSequence getOriginalText();

  public abstract CharSequence getValue();

  public abstract boolean isSelected();

  public abstract void setOriginalText(String paramString);

  public abstract void setSelected(boolean paramBoolean);
}