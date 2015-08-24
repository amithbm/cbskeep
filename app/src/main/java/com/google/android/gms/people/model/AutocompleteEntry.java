package com.google.android.gms.people.model;

public abstract interface AutocompleteEntry
{
  public abstract AvatarReference getAvatarReference();

  public abstract String getPersonDisplayName();
}