package com.android.ex.chips;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DropdownChipLayouter
{
  private final Context mContext;
  private final LayoutInflater mInflater;
  private Queries.Query mQuery;

  public DropdownChipLayouter(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    mInflater = paramLayoutInflater;
    mContext = paramContext;
  }

  protected void bindIconToView(boolean paramBoolean, RecipientEntry paramRecipientEntry, ImageView paramImageView, AdapterType paramAdapterType)
  {
    if (paramImageView == null)
      return;
    if (paramBoolean)
    {
      switch (1.$SwitchMap$com$android$ex$chips$DropdownChipLayouter$AdapterType[paramAdapterType.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        paramImageView.setVisibility(0);
        return;
        paramRecipientEntry = paramRecipientEntry.getPhotoBytes();
        if ((paramRecipientEntry != null) && (paramRecipientEntry.length > 0))
        {
          paramImageView.setImageBitmap(BitmapFactory.decodeByteArray(paramRecipientEntry, 0, paramRecipientEntry.length));
        }
        else
        {
          paramImageView.setImageResource(getDefaultPhotoResId());
          continue;
          paramRecipientEntry = paramRecipientEntry.getPhotoThumbnailUri();
          if (paramRecipientEntry != null)
            paramImageView.setImageURI(paramRecipientEntry);
          else
            paramImageView.setImageResource(getDefaultPhotoResId());
        }
      }
    }
    paramImageView.setVisibility(8);
  }

  protected void bindTextToView(CharSequence paramCharSequence, TextView paramTextView)
  {
    if (paramTextView == null)
      return;
    if (paramCharSequence != null)
    {
      paramTextView.setText(paramCharSequence);
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }

  public View bindView(View paramView, ViewGroup paramViewGroup, RecipientEntry paramRecipientEntry, int paramInt, AdapterType paramAdapterType, String paramString)
  {
    String str2 = paramRecipientEntry.getDisplayName();
    paramString = paramRecipientEntry.getDestination();
    boolean bool = true;
    CharSequence localCharSequence2 = getDestinationType(paramRecipientEntry);
    View localView = reuseOrInflateView(paramView, paramViewGroup, paramAdapterType);
    ViewHolder localViewHolder = new ViewHolder(localView);
    CharSequence localCharSequence1;
    switch (1.$SwitchMap$com$android$ex$chips$DropdownChipLayouter$AdapterType[paramAdapterType.ordinal()])
    {
    default:
      paramView = str2;
      localCharSequence1 = localCharSequence2;
      paramViewGroup = paramString;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      bindTextToView(paramView, localViewHolder.displayNameView);
      bindTextToView(paramViewGroup, localViewHolder.destinationView);
      bindTextToView(localCharSequence1, localViewHolder.destinationTypeView);
      bindIconToView(bool, paramRecipientEntry, localViewHolder.imageView, paramAdapterType);
      return localView;
      String str1;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = paramString;
        paramView = str2;
        if (!TextUtils.equals(str2, paramString));
      }
      else
      {
        paramViewGroup = paramString;
        str1 = paramString;
        paramView = paramViewGroup;
        if (paramRecipientEntry.isFirstLevel())
        {
          str1 = null;
          paramView = paramViewGroup;
        }
      }
      paramViewGroup = str1;
      localCharSequence1 = localCharSequence2;
      if (!paramRecipientEntry.isFirstLevel())
      {
        paramView = null;
        bool = false;
        paramViewGroup = str1;
        localCharSequence1 = localCharSequence2;
        continue;
        paramViewGroup = paramString;
        localCharSequence1 = localCharSequence2;
        paramView = str2;
        if (paramInt != 0)
        {
          paramView = null;
          bool = false;
          paramViewGroup = paramString;
          localCharSequence1 = localCharSequence2;
          continue;
          paramViewGroup = android.text.util.Rfc822Tokenizer.tokenize(paramRecipientEntry.getDestination())[0].getAddress();
          localCharSequence1 = null;
          paramView = str2;
        }
      }
    }
  }

  protected int getAlternateItemLayoutResId()
  {
    return R.layout.chips_alternate_item;
  }

  protected int getDefaultPhotoResId()
  {
    return R.drawable.ic_contact_picture;
  }

  protected int getDestinationResId()
  {
    return 16908308;
  }

  protected CharSequence getDestinationType(RecipientEntry paramRecipientEntry)
  {
    return mQuery.getTypeLabel(mContext.getResources(), paramRecipientEntry.getDestinationType(), paramRecipientEntry.getDestinationLabel()).toString().toUpperCase();
  }

  protected int getDestinationTypeResId()
  {
    return 16908309;
  }

  protected int getDisplayNameResId()
  {
    return 16908310;
  }

  protected int getItemLayoutResId()
  {
    return R.layout.chips_recipient_dropdown_item;
  }

  protected int getPhotoResId()
  {
    return 16908294;
  }

  public View newView()
  {
    return mInflater.inflate(getItemLayoutResId(), null);
  }

  protected View reuseOrInflateView(View paramView, ViewGroup paramViewGroup, AdapterType paramAdapterType)
  {
    int j = getItemLayoutResId();
    int i = j;
    switch (1.$SwitchMap$com$android$ex$chips$DropdownChipLayouter$AdapterType[paramAdapterType.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    for (i = j; paramView != null; i = getAlternateItemLayoutResId())
      return paramView;
    return mInflater.inflate(i, paramViewGroup, false);
  }

  public void setQuery(Queries.Query paramQuery)
  {
    mQuery = paramQuery;
  }

  public static enum AdapterType
  {
    BASE_RECIPIENT, RECIPIENT_ALTERNATES, SINGLE_RECIPIENT;
  }

  protected class ViewHolder
  {
    public final TextView destinationTypeView;
    public final TextView destinationView;
    public final TextView displayNameView;
    public final ImageView imageView;

    public ViewHolder(View arg2)
    {
      Object localObject;
      displayNameView = ((TextView)localObject.findViewById(getDisplayNameResId()));
      destinationView = ((TextView)localObject.findViewById(getDestinationResId()));
      destinationTypeView = ((TextView)localObject.findViewById(getDestinationTypeResId()));
      imageView = ((ImageView)localObject.findViewById(getPhotoResId()));
    }
  }
}