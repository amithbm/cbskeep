package com.google.android.gms.people.model;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.internal.zzd;

public final class ContactGaiaIdBuffer extends AbstractDataBuffer<ContactGaiaId>
{
  public ContactGaiaIdBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  public ContactGaiaId get(int paramInt)
  {
    return new zzd(mDataHolder, paramInt);
  }

  public String toString()
  {
    return "ContactGaiaId:size=" + getCount();
  }
}