package com.google.android.keep.util;

import android.net.Uri;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.provider.KeepPublicProvider;

public class z
{
  public static Uri w(Uri paramUri)
  {
    if (KeepApplication.ae())
      return paramUri;
    return KeepPublicProvider.r(paramUri);
  }
}