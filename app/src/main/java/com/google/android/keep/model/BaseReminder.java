package com.google.android.keep.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public abstract class BaseReminder
  implements Parcelable, d
{
  protected int mType;
  protected String op;
  protected boolean uF;
  protected long ul;
  protected long uy = -1L;

  protected BaseReminder(int paramInt, long paramLong1, String paramString, boolean paramBoolean, long paramLong2)
  {
    uy = paramLong1;
    mType = paramInt;
    op = paramString;
    uF = paramBoolean;
    ul = paramLong2;
  }

  protected BaseReminder(Parcel paramParcel)
  {
    uy = paramParcel.readLong();
    op = paramParcel.readString();
    mType = paramParcel.readInt();
    if (paramParcel.readInt() == 1);
    while (true)
    {
      uF = bool;
      return;
      bool = false;
    }
  }

  public void d(Object paramObject)
  {
    op = ((BaseReminder)paramObject).op;
  }

  public long dP()
  {
    return uy;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof BaseReminder)) && (TextUtils.equals(toString(), paramObject.toString()));
  }

  public boolean gK()
  {
    return uF;
  }

  public int getType()
  {
    return mType;
  }

  public String gq()
  {
    return op;
  }

  public long gs()
  {
    return ul;
  }

  public String gu()
  {
    return toString();
  }

  public boolean gv()
  {
    return op == null;
  }

  public String toString()
  {
    return "BaseReminder(" + "mType=" + mType + ", mTreeEntityId" + uy + ", mReminderId" + op + ", mIsDismissed" + uF + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(uy);
    paramParcel.writeString(op);
    paramParcel.writeInt(mType);
    if (uF);
    for (paramInt = 1; ; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }

  public static enum ReminderType
  {
  }
}