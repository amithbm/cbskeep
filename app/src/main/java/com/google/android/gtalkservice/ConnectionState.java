package com.google.android.gtalkservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class ConnectionState
  implements Parcelable
{
  public static final Parcelable.Creator<ConnectionState> CREATOR = new Parcelable.Creator()
  {
    public ConnectionState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ConnectionState(paramAnonymousParcel);
    }

    public ConnectionState[] newArray(int paramAnonymousInt)
    {
      return new ConnectionState[paramAnonymousInt];
    }
  };
  private volatile int mState;

  public ConnectionState(Parcel paramParcel)
  {
    mState = paramParcel.readInt();
  }

  public static final String toString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "IDLE";
    case 1:
      return "RECONNECTION_SCHEDULED";
    case 2:
      return "CONNECTING";
    case 3:
      return "AUTHENTICATED";
    case 4:
    }
    return "ONLINE";
  }

  public int describeContents()
  {
    return 0;
  }

  public final String toString()
  {
    return toString(mState);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mState);
  }
}