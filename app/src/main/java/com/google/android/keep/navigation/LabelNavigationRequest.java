package com.google.android.keep.navigation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.keep.model.Label;

public class LabelNavigationRequest extends BrowseNavigationRequest
{
  public static Parcelable.Creator<LabelNavigationRequest> CREATOR = new Parcelable.Creator()
  {
    public LabelNavigationRequest[] bv(int paramAnonymousInt)
    {
      return new LabelNavigationRequest[paramAnonymousInt];
    }

    public LabelNavigationRequest v(Parcel paramAnonymousParcel)
    {
      return new LabelNavigationRequest(NavigationManager.NavigationMode.values()[paramAnonymousParcel.readInt()], (Label)paramAnonymousParcel.readParcelable(Label.class.getClassLoader()));
    }
  };
  private Label hc;

  public LabelNavigationRequest(NavigationManager.NavigationMode paramNavigationMode, Label paramLabel)
  {
    super(paramNavigationMode);
    hc = paramLabel;
  }

  public Label jX()
  {
    return hc;
  }

  public String toString()
  {
    return "LabelNavigationRequest { label: " + hc.toString() + " }";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ka().ordinal());
    paramParcel.writeParcelable(hc, paramInt);
  }
}