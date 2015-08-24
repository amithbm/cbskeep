package com.google.android.gms.people.model;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.internal.zzj;

public final class OwnerBuffer extends AbstractDataBuffer<Owner>
{
  public OwnerBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  public Owner get(int paramInt)
  {
    return new zzj(mDataHolder, paramInt);
  }

  public String toString()
  {
    return "Owner:size=" + getCount();
  }
}