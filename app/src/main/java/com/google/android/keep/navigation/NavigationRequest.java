package com.google.android.keep.navigation;

import android.os.Parcelable;
import com.google.android.keep.model.Label;

public abstract class NavigationRequest
  implements Parcelable
{
  protected NavigationManager.NavigationMode AW;

  public NavigationRequest(NavigationManager.NavigationMode paramNavigationMode)
  {
    k(paramNavigationMode);
  }

  public static NavigationRequest a(NavigationManager.NavigationMode paramNavigationMode, long[] paramArrayOfLong)
  {
    return new BrowseNavigationRequest(paramNavigationMode, paramArrayOfLong);
  }

  public static NavigationRequest c(NavigationManager.NavigationMode paramNavigationMode, Label paramLabel)
  {
    return new LabelNavigationRequest(paramNavigationMode, paramLabel);
  }

  public static NavigationRequest l(NavigationManager.NavigationMode paramNavigationMode)
  {
    return new BrowseNavigationRequest(paramNavigationMode);
  }

  protected void k(NavigationManager.NavigationMode paramNavigationMode)
  {
    NavigationManager.j(paramNavigationMode);
    AW = paramNavigationMode;
  }

  public NavigationManager.NavigationMode ka()
  {
    return AW;
  }
}