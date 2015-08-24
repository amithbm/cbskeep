package com.google.android.gtalkservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class ConnectionError
  implements Parcelable
{
  public static final Parcelable.Creator<ConnectionError> CREATOR = new Parcelable.Creator()
  {
    public ConnectionError createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ConnectionError(paramAnonymousParcel);
    }

    public ConnectionError[] newArray(int paramAnonymousInt)
    {
      return new ConnectionError[paramAnonymousInt];
    }
  };
  private int mError;

  public ConnectionError(Parcel paramParcel)
  {
    mError = paramParcel.readInt();
  }

  public static final String toString(int paramInt)
  {
    switch (paramInt)
    {
    case 9:
    default:
      return "NO ERROR";
    case 1:
      return "NO NETWORK";
    case 2:
      return "CONNECTION FAILED";
    case 3:
      return "UNKNOWN HOST";
    case 4:
      return "AUTH FAILED";
    case 5:
      return "AUTH EXPIRED";
    case 6:
      return "HEARTBEAT TIMEOUT";
    case 7:
      return "SERVER FAILED";
    case 8:
      return "SERVER REJECT - RATE LIMIT";
    case 10:
    }
    return "UNKNOWN";
  }

  public int describeContents()
  {
    return 0;
  }

  public final String toString()
  {
    return toString(mError);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mError);
  }
}