package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface CategoryInfo extends Parcelable, Freezable<CategoryInfo>
{
  public abstract String getCategoryId();

  public abstract String getDisplayName();
}