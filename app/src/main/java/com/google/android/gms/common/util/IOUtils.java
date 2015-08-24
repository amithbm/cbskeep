package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import java.io.Closeable;
import java.io.IOException;

public final class IOUtils
{
  public static void closeQuietly(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null);
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (IOException paramParcelFileDescriptor)
    {
    }
  }

  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
    }
  }
}