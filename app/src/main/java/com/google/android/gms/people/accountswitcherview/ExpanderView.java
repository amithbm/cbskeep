package com.google.android.gms.people.accountswitcherview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class ExpanderView extends ImageButton
{
  private static final int[] STATE_EXPANDED = { 16842920 };
  private String mCollapsedDesc;
  private String mExpandedDesc;
  private boolean mIsExpanded;

  public ExpanderView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ExpanderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setupStrings(paramContext);
  }

  public ExpanderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setupStrings(paramContext);
  }

  private void setupStrings(Context paramContext)
  {
    paramContext = paramContext.getResources();
    mCollapsedDesc = paramContext.getString(R.string.show_account_list);
    mExpandedDesc = paramContext.getString(R.string.hide_account_list);
  }

  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (mIsExpanded)
      mergeDrawableStates(arrayOfInt, STATE_EXPANDED);
    return arrayOfInt;
  }

  public void setExpanded(boolean paramBoolean)
  {
    mIsExpanded = paramBoolean;
    if (mIsExpanded);
    for (String str = mExpandedDesc; ; str = mCollapsedDesc)
    {
      setContentDescription(str);
      refreshDrawableState();
      return;
    }
  }
}