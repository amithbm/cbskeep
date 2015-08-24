package com.google.android.keep.navigation;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class BrowseNavigationRequest extends NavigationRequest
{
  public static Parcelable.Creator<BrowseNavigationRequest> CREATOR = new Parcelable.Creator()
  {
    public BrowseNavigationRequest[] br(int paramAnonymousInt)
    {
      return new BrowseNavigationRequest[paramAnonymousInt];
    }

    public BrowseNavigationRequest s(Parcel paramAnonymousParcel)
    {
      return new BrowseNavigationRequest(NavigationManager.NavigationMode.values()[paramAnonymousParcel.readInt()], paramAnonymousParcel.createLongArray());
    }
  };
  private final long[] Az;

  public BrowseNavigationRequest(NavigationManager.NavigationMode paramNavigationMode)
  {
    this(paramNavigationMode, null);
  }

  public BrowseNavigationRequest(NavigationManager.NavigationMode paramNavigationMode, long[] paramArrayOfLong)
  {
    super(paramNavigationMode);
    Az = paramArrayOfLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public long[] jI()
  {
    return Az;
  }

  public String toString()
  {
    return "BrowseNavigationRequest { mode: " + ka() + " }";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ka().ordinal());
    paramParcel.writeLongArray(Az);
  }
}