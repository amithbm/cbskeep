package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator<Operator> CREATOR = new zzn();
  public static final Operator zzayc = new Operator("=");
  public static final Operator zzayd = new Operator("<");
  public static final Operator zzaye = new Operator("<=");
  public static final Operator zzayf = new Operator(">");
  public static final Operator zzayg = new Operator(">=");
  public static final Operator zzayh = new Operator("and");
  public static final Operator zzayi = new Operator("or");
  public static final Operator zzayj = new Operator("not");
  public static final Operator zzayk = new Operator("contains");
  final String mTag;
  final int mVersionCode;

  Operator(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    mTag = paramString;
  }

  private Operator(String paramString)
  {
    this(1, paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        paramObject = (Operator)paramObject;
        if (mTag != null)
          break;
      }
      while (paramObject.mTag == null);
      return false;
    }
    while (mTag.equals(paramObject.mTag));
    return false;
  }

  public String getTag()
  {
    return mTag;
  }

  public int hashCode()
  {
    if (mTag == null);
    for (int i = 0; ; i = mTag.hashCode())
      return i + 31;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}