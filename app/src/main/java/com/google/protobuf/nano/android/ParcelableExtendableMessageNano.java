package com.google.protobuf.nano.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.protobuf.nano.ExtendableMessageNano;

public abstract class ParcelableExtendableMessageNano<M extends ExtendableMessageNano<M>> extends ExtendableMessageNano<M>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableExtendableMessageNano<?>> CREATOR = new Parcelable.Creator()
  {
    public ParcelableExtendableMessageNano<?> createFromParcel(Parcel paramAnonymousParcel)
    {
      return (ParcelableExtendableMessageNano)ParcelingUtil.createFromParcel(paramAnonymousParcel);
    }

    public ParcelableExtendableMessageNano<?>[] newArray(int paramAnonymousInt)
    {
      return new ParcelableExtendableMessageNano[paramAnonymousInt];
    }
  };
}