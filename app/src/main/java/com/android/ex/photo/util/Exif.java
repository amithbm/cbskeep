package com.android.ex.photo.util;

import android.util.Log;
import java.io.InputStream;

public class Exif
{
  public static int getOrientation(InputStream paramInputStream, long paramLong)
  {
    if (paramInputStream == null)
      return 0;
    paramInputStream = new InputStreamBuffer(paramInputStream, 16, false);
    int k = 0;
    int i = k;
    int j;
    if (has(paramInputStream, paramLong, 1))
    {
      if ((paramInputStream.get(0) == -1) && (paramInputStream.get(1) == -40));
      for (j = 1; ; j = 0)
      {
        i = k;
        if (j != 0)
          break;
        return 0;
      }
    }
    int m;
    do
    {
      do
      {
        while (true)
        {
          m = 0;
          k = m;
          j = i;
          if (!has(paramInputStream, paramLong, i + 3))
            break label192;
          j = i + 1;
          if ((paramInputStream.get(i) & 0xFF) != 255)
            break label582;
          k = paramInputStream.get(j) & 0xFF;
          if (k != 255)
            break;
          i = j;
        }
        j += 1;
        i = j;
      }
      while (k == 216);
      i = j;
    }
    while (k == 1);
    if ((k == 217) || (k == 218))
    {
      paramInputStream.advanceTo(j - 4);
      k = m;
    }
    while (true)
    {
      label192: if (k > 8)
      {
        i = pack(paramInputStream, j, 4, false);
        if ((i != 1229531648) && (i != 1296891946))
        {
          Log.e("CameraExif", "Invalid byte order");
          return 0;
          i = pack(paramInputStream, j, 2, false);
          if ((i < 2) || (!has(paramInputStream, paramLong, j + i - 1)))
          {
            Log.e("CameraExif", "Invalid length");
            return 0;
          }
          if ((k == 225) && (i >= 8) && (pack(paramInputStream, j + 2, 4, false) == 1165519206) && (pack(paramInputStream, j + 6, 2, false) == 0))
          {
            j += 8;
            k = i - 8;
            paramInputStream.advanceTo(j - 4);
            continue;
          }
          i = j + i;
          paramInputStream.advanceTo(i - 4);
          break;
        }
        if (i == 1229531648);
        for (boolean bool = true; ; bool = false)
        {
          m = pack(paramInputStream, j + 4, 4, bool) + 2;
          if ((m >= 10) && (m <= k))
            break;
          Log.e("CameraExif", "Invalid offset");
          return 0;
        }
        i = j + m;
        j = k - m;
        paramInputStream.advanceTo(i - 4);
        m = pack(paramInputStream, i - 2, 2, bool);
        k = i;
        i = m;
        while ((i > 0) && (j >= 12))
        {
          if (pack(paramInputStream, k, 2, bool) == 274)
          {
            switch (pack(paramInputStream, k + 8, 2, bool))
            {
            case 2:
            case 4:
            case 5:
            case 7:
            default:
              Log.i("CameraExif", "Unsupported orientation");
              return 0;
            case 1:
              return 0;
            case 3:
              return 180;
            case 6:
              return 90;
            case 8:
            }
            return 270;
          }
          k += 12;
          j -= 12;
          paramInputStream.advanceTo(k - 4);
          i -= 1;
        }
      }
      return 0;
      label582: k = m;
    }
  }

  private static boolean has(InputStreamBuffer paramInputStreamBuffer, long paramLong, int paramInt)
  {
    if (paramLong >= 0L)
      return paramInt < paramLong;
    return paramInputStreamBuffer.has(paramInt);
  }

  private static int pack(InputStreamBuffer paramInputStreamBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 1;
    int i = paramInt1;
    if (paramBoolean)
    {
      i = paramInt1 + (paramInt2 - 1);
      j = -1;
    }
    paramInt1 = 0;
    while (paramInt2 > 0)
    {
      paramInt1 = paramInt1 << 8 | paramInputStreamBuffer.get(i) & 0xFF;
      i += j;
      paramInt2 -= 1;
    }
    return paramInt1;
  }
}