package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface ExternalApplicationLink extends Parcelable, Freezable<ExternalApplicationLink>
{
  public abstract Integer getApplication();

  public abstract String getId();
}