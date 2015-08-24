package com.android.ex.chips.recipientchip;

import android.text.TextUtils;
import com.android.ex.chips.RecipientEntry;

class SimpleRecipientChip
  implements BaseRecipientChip
{
  private final long mContactId;
  private final long mDataId;
  private final Long mDirectoryId;
  private final CharSequence mDisplay;
  private final RecipientEntry mEntry;
  private final String mLookupKey;
  private CharSequence mOriginalText;
  private boolean mSelected = false;
  private final CharSequence mValue;

  public SimpleRecipientChip(RecipientEntry paramRecipientEntry)
  {
    mDisplay = paramRecipientEntry.getDisplayName();
    mValue = paramRecipientEntry.getDestination().trim();
    mContactId = paramRecipientEntry.getContactId();
    mDirectoryId = paramRecipientEntry.getDirectoryId();
    mLookupKey = paramRecipientEntry.getLookupKey();
    mDataId = paramRecipientEntry.getDataId();
    mEntry = paramRecipientEntry;
  }

  public long getContactId()
  {
    return mContactId;
  }

  public long getDataId()
  {
    return mDataId;
  }

  public Long getDirectoryId()
  {
    return mDirectoryId;
  }

  public RecipientEntry getEntry()
  {
    return mEntry;
  }

  public String getLookupKey()
  {
    return mLookupKey;
  }

  public CharSequence getOriginalText()
  {
    if (!TextUtils.isEmpty(mOriginalText))
      return mOriginalText;
    return mEntry.getDestination();
  }

  public CharSequence getValue()
  {
    return mValue;
  }

  public boolean isSelected()
  {
    return mSelected;
  }

  public void setOriginalText(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      mOriginalText = paramString;
      return;
    }
    mOriginalText = paramString.trim();
  }

  public void setSelected(boolean paramBoolean)
  {
    mSelected = paramBoolean;
  }

  public String toString()
  {
    return mDisplay + " <" + mValue + ">";
  }
}