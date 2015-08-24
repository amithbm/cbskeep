package com.google.android.keep.navigation;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class FilterBrowseNavigationRequest extends BrowseNavigationRequest
{
  public static Parcelable.Creator<FilterBrowseNavigationRequest> CREATOR = new Parcelable.Creator()
  {
    public FilterBrowseNavigationRequest[] bu(int paramAnonymousInt)
    {
      return new FilterBrowseNavigationRequest[paramAnonymousInt];
    }

    public FilterBrowseNavigationRequest u(Parcel paramAnonymousParcel)
    {
      return new FilterBrowseNavigationRequest(NavigationManager.NavigationMode.values()[paramAnonymousParcel.readInt()], paramAnonymousParcel.readInt());
    }
  };
  private final int AJ;
  private String fs;

  public FilterBrowseNavigationRequest(NavigationManager.NavigationMode paramNavigationMode, int paramInt)
  {
    super(paramNavigationMode);
    AJ = paramInt;
  }

  public void ax(String paramString)
  {
    fs = paramString;
  }

  public int jV()
  {
    return AJ;
  }

  public String jW()
  {
    return fs;
  }

  public String toString()
  {
    return "FilterBrowseNavigationRequest { search filter type: " + AJ + " }";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ka().ordinal());
    paramParcel.writeInt(AJ);
  }
}