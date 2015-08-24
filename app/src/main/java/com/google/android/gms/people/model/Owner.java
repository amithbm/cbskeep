package com.google.android.gms.people.model;

public abstract interface Owner
{
  public abstract String getAccountName();

  public abstract String getAvatarUrl();

  public abstract String getCoverPhotoUrl();

  public abstract String getDisplayName();

  public abstract String getPlusPageId();
}