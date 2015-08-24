package com.google.android.keep.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.ex.chips.DropdownChipLayouter;
import com.android.ex.chips.DropdownChipLayouter.AdapterType;
import com.android.ex.chips.DropdownChipLayouter.ViewHolder;
import com.android.ex.chips.RecipientEntry;

public class f extends DropdownChipLayouter
{
  Context mContext;

  public f(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
    mContext = paramContext;
  }

  public View bindView(View paramView, ViewGroup paramViewGroup, RecipientEntry paramRecipientEntry, int paramInt, DropdownChipLayouter.AdapterType paramAdapterType, String paramString)
  {
    String str1 = paramRecipientEntry.getDisplayName();
    String str2 = paramRecipientEntry.getDestination();
    paramView = reuseOrInflateView(paramView, paramViewGroup, paramAdapterType);
    paramViewGroup = new DropdownChipLayouter.ViewHolder(this, paramView);
    paramString = h(paramString, new String[] { str1, str2 });
    bindTextToView(paramString[0], paramViewGroup.displayNameView);
    bindTextToView(paramString[1], paramViewGroup.destinationView);
    bindIconToView(true, paramRecipientEntry, paramViewGroup.imageView, paramAdapterType);
    return paramView;
  }

  protected int getAlternateItemLayoutResId()
  {
    return getItemLayoutResId();
  }

  protected int getDestinationResId()
  {
    return 2131493133;
  }

  protected int getDisplayNameResId()
  {
    return 2131493132;
  }

  protected int getItemLayoutResId()
  {
    return 2130968642;
  }

  protected int getPhotoResId()
  {
    return 2131493131;
  }

  CharSequence[] h(String paramString, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString))
      return paramArrayOfString;
    CharSequence[] arrayOfCharSequence = new CharSequence[paramArrayOfString.length];
    int j = 0;
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      Object localObject = paramArrayOfString[i];
      if ((j == 0) && (localObject != null))
      {
        int k = ((String)localObject).toLowerCase().indexOf(paramString.toLowerCase());
        if (k != -1)
        {
          localObject = SpannableStringBuilder.valueOf((CharSequence)localObject);
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(mContext.getResources().getColor(2131296375)), k, paramString.length() + k, 33);
          arrayOfCharSequence[i] = localObject;
          j = 1;
        }
      }
      while (true)
      {
        i += 1;
        break;
        arrayOfCharSequence[i] = localObject;
      }
    }
    return arrayOfCharSequence;
  }
}