package com.google.android.gms.drive.metadata;

import android.os.Bundle;

public abstract interface MetadataField<T>
{
  public abstract String getName();

  public abstract T zzn(Bundle paramBundle);
}