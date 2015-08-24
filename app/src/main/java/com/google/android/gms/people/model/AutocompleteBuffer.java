package com.google.android.gms.people.model;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.internal.zzb;

public class AutocompleteBuffer extends DataBufferWithSyncInfo<AutocompleteEntry>
{
  public AutocompleteBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  public AutocompleteEntry get(int paramInt)
  {
    return new zzb(this, mDataHolder, paramInt, getMetadata());
  }

  public String toString()
  {
    return "AutocompleteList:size=" + getCount();
  }
}