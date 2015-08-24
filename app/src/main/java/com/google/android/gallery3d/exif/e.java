package com.google.android.gallery3d.exif;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

class e
{
  private final c ce;

  e(c paramc)
  {
    ce = paramc;
  }

  protected b c(InputStream paramInputStream)
    throws ExifInvalidFormatException, IOException
  {
    paramInputStream = d.a(paramInputStream, ce);
    b localb = new b(paramInputStream.b());
    int i = paramInputStream.next();
    if (i != 5)
    {
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        i = paramInputStream.next();
        break;
        localb.a(new g(paramInputStream.j()));
        continue;
        Object localObject = paramInputStream.i();
        if (!((f)localObject).hasValue())
        {
          paramInputStream.a((f)localObject);
        }
        else
        {
          localb.a(((f)localObject).t()).d((f)localObject);
          continue;
          localObject = paramInputStream.i();
          if (((f)localObject).v() == 7)
            paramInputStream.c((f)localObject);
          localb.a(((f)localObject).t()).d((f)localObject);
          continue;
          localObject = new byte[paramInputStream.m()];
          if (localObject.length == paramInputStream.read((byte[])localObject))
          {
            localb.b((byte[])localObject);
          }
          else
          {
            Log.w("ExifReader", "Failed to read the compressed thumbnail");
            continue;
            localObject = new byte[paramInputStream.l()];
            if (localObject.length == paramInputStream.read((byte[])localObject))
              localb.a(paramInputStream.k(), (byte[])localObject);
            else
              Log.w("ExifReader", "Failed to read the strip bytes");
          }
        }
      }
    }
    return localb;
  }
}