package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T>
{
  private static final String[] zzajb = { "data" };
  private final Parcelable.Creator<T> zzajc;

  public zzd(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    zzajc = paramCreator;
  }

  public T get(int paramInt)
  {
    Object localObject = mDataHolder.zzh("data", paramInt, mDataHolder.zzez(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)zzajc.createFromParcel(localParcel);
    localParcel.recycle();
    return localObject;
  }
}