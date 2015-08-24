package com.google.android.gms.people;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.util.IOUtils;
import java.io.FileInputStream;

public class PeopleClientUtil
{
  public static Bitmap decodeFileDescriptor(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null)
      return null;
    paramParcelFileDescriptor = new FileInputStream(paramParcelFileDescriptor.getFileDescriptor());
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramParcelFileDescriptor);
      return localBitmap;
    }
    finally
    {
      IOUtils.closeQuietly(paramParcelFileDescriptor);
    }
  }
}