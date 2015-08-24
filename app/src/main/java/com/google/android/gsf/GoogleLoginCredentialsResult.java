package com.google.android.gsf;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GoogleLoginCredentialsResult
  implements Parcelable
{
  public static final Parcelable.Creator<GoogleLoginCredentialsResult> CREATOR = new Parcelable.Creator()
  {
    public GoogleLoginCredentialsResult createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GoogleLoginCredentialsResult(paramAnonymousParcel, null);
    }

    public GoogleLoginCredentialsResult[] newArray(int paramAnonymousInt)
    {
      return new GoogleLoginCredentialsResult[paramAnonymousInt];
    }
  };
  private String mAccount;
  private Intent mCredentialsIntent;
  private String mCredentialsString;

  public GoogleLoginCredentialsResult()
  {
    mCredentialsString = null;
    mCredentialsIntent = null;
    mAccount = null;
  }

  private GoogleLoginCredentialsResult(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }

  public int describeContents()
  {
    if (mCredentialsIntent != null)
      return mCredentialsIntent.describeContents();
    return 0;
  }

  public void readFromParcel(Parcel paramParcel)
  {
    mAccount = paramParcel.readString();
    mCredentialsString = paramParcel.readString();
    int i = paramParcel.readInt();
    mCredentialsIntent = null;
    if (i == 1)
    {
      mCredentialsIntent = new Intent();
      mCredentialsIntent.readFromParcel(paramParcel);
      mCredentialsIntent.setExtrasClassLoader(getClass().getClassLoader());
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(mAccount);
    paramParcel.writeString(mCredentialsString);
    if (mCredentialsIntent != null)
    {
      paramParcel.writeInt(1);
      mCredentialsIntent.writeToParcel(paramParcel, 0);
      return;
    }
    paramParcel.writeInt(0);
  }
}