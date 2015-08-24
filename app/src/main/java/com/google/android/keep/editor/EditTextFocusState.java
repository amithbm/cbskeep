package com.google.android.keep.editor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class EditTextFocusState
  implements Parcelable
{
  public static final Parcelable.Creator<EditTextFocusState> CREATOR = new Parcelable.Creator()
  {
    public EditTextFocusState[] ak(int paramAnonymousInt)
    {
      return new EditTextFocusState[paramAnonymousInt];
    }

    public EditTextFocusState b(Parcel paramAnonymousParcel)
    {
      return new EditTextFocusState(paramAnonymousParcel);
    }
  };
  boolean kY = false;
  int selectionEnd = -1;
  int selectionStart = -1;

  public EditTextFocusState()
  {
  }

  protected EditTextFocusState(Parcel paramParcel)
  {
    selectionStart = paramParcel.readInt();
    selectionEnd = paramParcel.readInt();
    if (paramParcel.readByte() == 1);
    while (true)
    {
      kY = bool;
      return;
      bool = false;
    }
  }

  public EditTextFocusState ai(int paramInt)
  {
    selectionStart = paramInt;
    return this;
  }

  public EditTextFocusState aj(int paramInt)
  {
    selectionEnd = paramInt;
    return this;
  }

  public void clear()
  {
    selectionStart = -1;
    selectionEnd = -1;
    kY = false;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean isValid()
  {
    return (selectionStart >= 0) && (selectionEnd >= 0);
  }

  public EditTextFocusState w(boolean paramBoolean)
  {
    kY = paramBoolean;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(selectionStart);
    paramParcel.writeInt(selectionEnd);
    if (kY);
    for (paramInt = 1; ; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}