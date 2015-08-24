package com.android.ex.chips;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

class SingleRecipientArrayAdapter extends ArrayAdapter<RecipientEntry>
{
  private final DropdownChipLayouter mDropdownChipLayouter;

  public SingleRecipientArrayAdapter(Context paramContext, RecipientEntry paramRecipientEntry, DropdownChipLayouter paramDropdownChipLayouter)
  {
    super(paramContext, paramDropdownChipLayouter.getAlternateItemLayoutResId(), new RecipientEntry[] { paramRecipientEntry });
    mDropdownChipLayouter = paramDropdownChipLayouter;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return mDropdownChipLayouter.bindView(paramView, paramViewGroup, (RecipientEntry)getItem(paramInt), paramInt, DropdownChipLayouter.AdapterType.SINGLE_RECIPIENT, null);
  }
}