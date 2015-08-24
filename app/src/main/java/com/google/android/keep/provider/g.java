package com.google.android.keep.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Log;
import com.google.android.gallery3d.exif.c;
import com.google.android.gallery3d.exif.f;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.r;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class g extends MediaStore
{
  private static int a(BitmapFactory.Options paramOptions, int paramInt)
  {
    int j = b(paramOptions, paramInt);
    if (j <= 8)
    {
      paramInt = 1;
      while (true)
      {
        i = paramInt;
        if (paramInt >= j)
          break;
        paramInt <<= 1;
      }
    }
    int i = (j + 7) / 8 * 8;
    return i;
  }

  public static Bitmap a(ContentResolver paramContentResolver, Uri paramUri, int paramInt1, int paramInt2)
  {
    return a(paramContentResolver, paramUri, paramInt1, paramInt2, null);
  }

  private static Bitmap a(ContentResolver paramContentResolver, Uri paramUri, int paramInt1, int paramInt2, l paraml)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      localAssetFileDescriptor = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
      if (localAssetFileDescriptor == null)
      {
        paramUri = null;
        paramContentResolver = paramUri;
        if (localAssetFileDescriptor == null);
      }
      do
      {
        try
        {
          localAssetFileDescriptor.close();
          paramContentResolver = paramUri;
          return paramContentResolver;
        }
        catch (IOException paramContentResolver)
        {
          Log.e("Keep", "Close pfd error", paramContentResolver);
          return null;
        }
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        i = d(paramContentResolver, paramUri);
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        localOptions = new BitmapFactory.Options();
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        localFileDescriptor = localAssetFileDescriptor.getFileDescriptor();
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        localOptions.inJustDecodeBounds = true;
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        BitmapFactory.decodeFileDescriptor(localFileDescriptor, null, localOptions);
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        if (localOptions.outWidth != -1)
        {
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          if (localOptions.outHeight != -1)
            break;
        }
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        Log.e("Keep", "Fail to decode boundary of bitmap:" + paramUri);
        paramContentResolver = null;
      }
      while (localAssetFileDescriptor == null);
      try
      {
        localAssetFileDescriptor.close();
        return null;
      }
      catch (IOException paramContentResolver)
      {
        Log.e("Keep", "Close pfd error", paramContentResolver);
        return null;
      }
      if ((i == 90) || (i == 270))
      {
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
      }
      for (localOptions.inSampleSize = calculateInSampleSize(localOptions.outWidth, localOptions.outHeight, paramInt2, paramInt1); ; localOptions.inSampleSize = calculateInSampleSize(localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2))
      {
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        if (localOptions.inSampleSize < 1)
        {
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          localOptions.inSampleSize = 1;
        }
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        localOptions.inJustDecodeBounds = false;
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        localOptions.inDither = true;
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        localOptions.inMutable = true;
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        bool = r.isLoggable("Keep", 2);
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        if (!"image/gif".equals(localOptions.outMimeType))
          break label623;
        if (bool)
        {
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          Log.v("Keep", "Cannot reuse bitmap for gif file. Create a new bitmap.");
        }
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        paramContentResolver = BitmapFactory.decodeFileDescriptor(localFileDescriptor, null, localOptions);
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        paramUri = a(paramContentResolver, paramInt1, paramInt2);
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        paramContentResolver.recycle();
        paramContentResolver = paramUri;
        if (localAssetFileDescriptor == null)
          break;
        try
        {
          localAssetFileDescriptor.close();
          return paramUri;
        }
        catch (IOException paramContentResolver)
        {
          Log.e("Keep", "Close pfd error", paramContentResolver);
          return paramUri;
        }
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
      }
    }
    catch (IOException paramContentResolver)
    {
      AssetFileDescriptor localAssetFileDescriptor;
      do
      {
        BitmapFactory.Options localOptions;
        FileDescriptor localFileDescriptor;
        boolean bool;
        do
        {
          localObject1 = localObject2;
          Log.e("Keep", "Image file not found", paramContentResolver);
          paramContentResolver = null;
        }
        while (localObject2 == null);
        try
        {
          localObject2.close();
          return null;
        }
        catch (IOException paramContentResolver)
        {
          Log.e("Keep", "Close pfd error", paramContentResolver);
          return null;
        }
        if (!bool)
          break;
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        Log.v("Keep", "Options width:" + localOptions.outWidth + " sample size:" + localOptions.inSampleSize + " reqWidth:" + paramInt1);
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        Log.v("Keep", "Options height:" + localOptions.outHeight + " sample size:" + localOptions.inSampleSize + " reqHeight" + paramInt2);
        break;
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        paramContentResolver = a(localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, localOptions.inSampleSize);
        while (true)
        {
          if ((paraml != null) && (i == 0))
          {
            localObject2 = localAssetFileDescriptor;
            localObject3 = localAssetFileDescriptor;
            localObject1 = localAssetFileDescriptor;
            paramUri = paraml.getBitmap();
            if (paramUri != null)
            {
              localObject2 = localAssetFileDescriptor;
              localObject3 = localAssetFileDescriptor;
              localObject1 = localAssetFileDescriptor;
              if (paramUri.isMutable())
              {
                localObject2 = localAssetFileDescriptor;
                localObject3 = localAssetFileDescriptor;
                localObject1 = localAssetFileDescriptor;
                if (paramUri.getWidth() == paramInt1)
                {
                  localObject2 = localAssetFileDescriptor;
                  localObject3 = localAssetFileDescriptor;
                  localObject1 = localAssetFileDescriptor;
                  if (paramUri.getHeight() == paramInt2)
                  {
                    if (bool)
                    {
                      localObject2 = localAssetFileDescriptor;
                      localObject3 = localAssetFileDescriptor;
                      localObject1 = localAssetFileDescriptor;
                      Log.v("Keep", "Reusing bitmap:" + paramUri + " width:" + paramUri.getWidth() + ", height:" + paramUri.getHeight());
                    }
                    localObject2 = localAssetFileDescriptor;
                    localObject3 = localAssetFileDescriptor;
                    localObject1 = localAssetFileDescriptor;
                    localOptions.inBitmap = paramUri;
                    localObject2 = localAssetFileDescriptor;
                    localObject3 = localAssetFileDescriptor;
                    localObject1 = localAssetFileDescriptor;
                    paraml.p(Math.round(paramContentResolver.width() / localOptions.inSampleSize), Math.round(paramContentResolver.height() / localOptions.inSampleSize));
                  }
                }
              }
            }
          }
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          paramContentResolver = BitmapRegionDecoder.newInstance(localFileDescriptor, true).decodeRegion(paramContentResolver, localOptions);
          if (i == 0)
          {
            if (localAssetFileDescriptor != null);
            try
            {
              localAssetFileDescriptor.close();
              return paramContentResolver;
              localObject2 = localAssetFileDescriptor;
              localObject3 = localAssetFileDescriptor;
              localObject1 = localAssetFileDescriptor;
              paramContentResolver = a(localOptions.outWidth, localOptions.outHeight, paramInt2, paramInt1, localOptions.inSampleSize);
            }
            catch (IOException paramUri)
            {
              while (true)
                Log.e("Keep", "Close pfd error", paramUri);
            }
          }
        }
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        paramUri = b(paramContentResolver, i);
        paramContentResolver = paramUri;
      }
      while (localAssetFileDescriptor == null);
      try
      {
        localAssetFileDescriptor.close();
        return paramUri;
      }
      catch (IOException paramContentResolver)
      {
        Log.e("Keep", "Close pfd error", paramContentResolver);
        return paramUri;
      }
    }
    catch (OutOfMemoryError paramContentResolver)
    {
      label623: 
      do
      {
        localObject1 = localObject3;
        Log.e("Keep", "Got OutOfMemoryError", paramContentResolver);
        paramContentResolver = null;
      }
      while (localObject3 == null);
      try
      {
        localObject3.close();
        return null;
      }
      catch (IOException paramContentResolver)
      {
        Log.e("Keep", "Close pfd error", paramContentResolver);
        return null;
      }
    }
    finally
    {
      while (true)
      {
        int i;
        if (localObject1 != null);
        try
        {
          localObject1.close();
          throw paramContentResolver;
        }
        catch (IOException paramUri)
        {
          while (true)
            Log.e("Keep", "Close pfd error", paramUri);
        }
        if (i != 90)
          if (i != 270);
      }
    }
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null)
      throw new IllegalArgumentException("Source bitmap is null!");
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      throw new IllegalArgumentException("Illegal dimension to crop an image:" + paramInt1 + "," + paramInt2);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3;
    if (i * paramInt2 > paramInt1 * j)
    {
      f3 = paramInt2 / j;
      f1 = (paramInt1 - i * f3) * 0.5F;
    }
    while (true)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate((int)(f1 + 0.5F), (int)(f2 + 0.5F));
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap, localMatrix, null);
      localCanvas.setBitmap(null);
      return localBitmap;
      f3 = paramInt1 / i;
      f2 = (paramInt2 - j * f3) * 0.5F;
    }
  }

  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    float f = Math.min(Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4), paramInt5);
    paramInt3 = Math.round(paramInt3 * f);
    paramInt4 = Math.round(paramInt4 * f);
    paramInt1 = (paramInt1 - paramInt3) / 2;
    paramInt2 = (paramInt2 - paramInt4) / 2;
    return new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }

  public static ImageBlob a(Context paramContext, long paramLong, Bitmap paramBitmap)
    throws MediaStore.FileValidationException
  {
    try
    {
      paramContext = new a(paramContext, paramLong);
      paramContext = a(paramBitmap, Dh, Dj);
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
    }
    throw new IllegalStateException("Fail to create the outputStream");
  }

  private static ImageBlob a(Bitmap paramBitmap, String paramString, OutputStream paramOutputStream)
    throws MediaStore.FileValidationException
  {
    bC(paramBitmap.getWidth() * paramBitmap.getHeight());
    a(paramBitmap, paramOutputStream);
    paramString = new ImageBlob(paramString, Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()));
    paramBitmap.recycle();
    return paramString;
  }

  private static void a(Bitmap paramBitmap, OutputStream paramOutputStream)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      paramOutputStream.write(localByteArrayOutputStream.toByteArray());
      if (paramOutputStream != null);
      try
      {
        paramOutputStream.close();
        return;
      }
      catch (IOException paramBitmap)
      {
        Log.e("Keep", "Error closing output stream", paramBitmap);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      throw new IllegalStateException("Error writing bitmap to file " + paramBitmap);
    }
    finally
    {
      if (paramOutputStream == null);
    }
    try
    {
      paramOutputStream.close();
      throw paramBitmap;
    }
    catch (IOException paramOutputStream)
    {
      while (true)
        Log.e("Keep", "Error closing output stream", paramOutputStream);
    }
  }

  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null)
      return;
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.e("Keep", "Error closing stream", paramCloseable);
    }
  }

  private static int aF(String paramString)
    throws IOException
  {
    int j = 0;
    c localc = new c();
    localc.a(paramString);
    paramString = localc.d(c.v);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.v() == 3)
        i = c.b((short)paramString.n(0));
    }
    return i;
  }

  private static int b(BitmapFactory.Options paramOptions, int paramInt)
  {
    double d1 = outWidth;
    double d2 = outHeight;
    int j = (int)Math.ceil(Math.sqrt(d1 * d2 / 409600.0D));
    int i;
    if (paramInt == -1)
    {
      i = 128;
      if (i >= j)
        break label74;
    }
    label74: 
    while (paramInt == -1)
    {
      return j;
      i = (int)Math.min(Math.floor(d1 / paramInt), Math.floor(d2 / paramInt));
      break;
    }
    return i;
  }

  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }

  public static BitmapFactory.Options b(ContentResolver paramContentResolver, Uri paramUri)
  {
    ContentResolver localContentResolver2 = null;
    Object localObject = null;
    ContentResolver localContentResolver1 = null;
    try
    {
      paramContentResolver = paramContentResolver.openInputStream(paramUri);
      localContentResolver1 = paramContentResolver;
      localContentResolver2 = paramContentResolver;
      localObject = paramContentResolver;
      paramUri = new BitmapFactory.Options();
      localContentResolver1 = paramContentResolver;
      localContentResolver2 = paramContentResolver;
      localObject = paramContentResolver;
      paramUri.inJustDecodeBounds = true;
      localContentResolver1 = paramContentResolver;
      localContentResolver2 = paramContentResolver;
      localObject = paramContentResolver;
      BitmapFactory.decodeStream(paramContentResolver, null, paramUri);
      a(paramContentResolver);
      return paramUri;
    }
    catch (IOException paramContentResolver)
    {
      localObject = localContentResolver1;
      Log.e("Keep", "Image file not found", paramContentResolver);
      a(localContentResolver1);
      return null;
    }
    catch (OutOfMemoryError paramContentResolver)
    {
      localObject = localContentResolver2;
      Log.e("Keep", "Got OutOfMemoryError", paramContentResolver);
      a(localContentResolver2);
      return null;
    }
    finally
    {
      a((Closeable)localObject);
    }
    throw paramContentResolver;
  }

  public static String b(Context paramContext, long paramLong, InputStream paramInputStream)
    throws MediaStore.FileValidationException
  {
    try
    {
      paramContext = new a(paramContext, paramLong);
      if (!a(paramInputStream, paramContext))
        return null;
    }
    catch (FileNotFoundException paramContext)
    {
      Log.e("Keep", "Fail to create image file", paramContext);
      return null;
    }
    return Dh;
  }

  private static void bC(int paramInt)
    throws MediaStore.FileValidationException
  {
    if (paramInt >= ((Integer)Config.Oz.get()).intValue())
      throw new MediaStore.FileValidationException("Expected maximum pixels = " + Config.Oz.get() + " and get " + paramInt);
  }

  private static int bD(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 1073741824))
      throw new IllegalArgumentException();
    paramInt -= 1;
    paramInt |= paramInt >> 16;
    paramInt |= paramInt >> 8;
    paramInt |= paramInt >> 4;
    paramInt |= paramInt >> 2;
    return (paramInt | paramInt >> 1) + 1;
  }

  public static Bitmap c(ContentResolver paramContentResolver, Uri paramUri)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      AssetFileDescriptor localAssetFileDescriptor = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
      if (localAssetFileDescriptor == null)
        if (localAssetFileDescriptor == null);
      do
      {
        int i;
        do
        {
          try
          {
            localAssetFileDescriptor.close();
            paramContentResolver = null;
            return paramContentResolver;
          }
          catch (IOException paramContentResolver)
          {
            while (true)
              Log.e("Keep", "Close pfd error", paramContentResolver);
          }
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          i = d(paramContentResolver, paramUri);
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          paramContentResolver = new BitmapFactory.Options();
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          paramUri = localAssetFileDescriptor.getFileDescriptor();
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          inJustDecodeBounds = true;
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          BitmapFactory.decodeFileDescriptor(paramUri, null, paramContentResolver);
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          if (outWidth != -1)
          {
            localObject2 = localAssetFileDescriptor;
            localObject3 = localAssetFileDescriptor;
            localObject1 = localAssetFileDescriptor;
            int j = outHeight;
            if (j != -1);
          }
          else
          {
            if (localAssetFileDescriptor != null);
            try
            {
              localAssetFileDescriptor.close();
              return null;
            }
            catch (IOException paramContentResolver)
            {
              while (true)
                Log.e("Keep", "Close pfd error", paramContentResolver);
            }
          }
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          inSampleSize = a(paramContentResolver, 400);
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          inJustDecodeBounds = false;
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          inDither = false;
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          inPreferredConfig = Bitmap.Config.ARGB_8888;
          localObject2 = localAssetFileDescriptor;
          localObject3 = localAssetFileDescriptor;
          localObject1 = localAssetFileDescriptor;
          paramUri = BitmapFactory.decodeFileDescriptor(paramUri, null, paramContentResolver);
          if (i != 0)
            break;
          paramContentResolver = paramUri;
        }
        while (localAssetFileDescriptor == null);
        try
        {
          localAssetFileDescriptor.close();
          return paramUri;
        }
        catch (IOException paramContentResolver)
        {
          Log.e("Keep", "Close pfd error", paramContentResolver);
          return paramUri;
        }
        localObject2 = localAssetFileDescriptor;
        localObject3 = localAssetFileDescriptor;
        localObject1 = localAssetFileDescriptor;
        paramUri = b(paramUri, i);
        paramContentResolver = paramUri;
      }
      while (localAssetFileDescriptor == null);
      try
      {
        localAssetFileDescriptor.close();
        return paramUri;
      }
      catch (IOException paramContentResolver)
      {
        Log.e("Keep", "Close pfd error", paramContentResolver);
        return paramUri;
      }
    }
    catch (IOException paramContentResolver)
    {
      localObject1 = localObject2;
      Log.e("Keep", "Image file not found", paramContentResolver);
      if (localObject2 != null);
      try
      {
        localObject2.close();
        return null;
      }
      catch (IOException paramContentResolver)
      {
        while (true)
          Log.e("Keep", "Close pfd error", paramContentResolver);
      }
    }
    catch (OutOfMemoryError paramContentResolver)
    {
      localObject1 = localObject3;
      Log.e("Keep", "Got OutOfMemoryError", paramContentResolver);
      if (localObject3 != null);
      try
      {
        localObject3.close();
        return null;
      }
      catch (IOException paramContentResolver)
      {
        while (true)
          Log.e("Keep", "Close pfd error", paramContentResolver);
      }
    }
    finally
    {
      if (localObject1 == null);
    }
    try
    {
      localObject1.close();
      throw paramContentResolver;
    }
    catch (IOException paramUri)
    {
      while (true)
        Log.e("Keep", "Close pfd error", paramUri);
    }
  }

  public static ImageBlob c(Context paramContext, long paramLong, Uri paramUri)
    throws FileNotFoundException, MediaStore.FileValidationException
  {
    Object localObject = paramContext.getContentResolver();
    a locala = new a(paramContext, paramLong);
    paramContext = ((ContentResolver)localObject).openInputStream(paramUri);
    localObject = b((ContentResolver)localObject, paramUri);
    bC(((BitmapFactory.Options)localObject).outWidth * ((BitmapFactory.Options)localObject).outHeight);
    if (i.j.isSupported(((BitmapFactory.Options)localObject).outMimeType))
    {
      if (a(paramContext, locala))
      {
        a(paramContext);
        return new ImageBlob(locala.Dh, Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight));
      }
      a(paramContext);
      return null;
    }
    try
    {
      localObject = BitmapFactory.decodeStream(paramContext);
      if (localObject == null)
        throw new FileNotFoundException("Cannot decode the bitmap from " + paramUri);
    }
    finally
    {
      a(paramContext);
    }
    paramUri = a((Bitmap)localObject, locala.Dh, locala.Dj);
    a(paramContext);
    return paramUri;
  }

  private static int calculateInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int i = 1;
    float f1;
    if ((paramInt2 > paramInt4) || (paramInt1 > paramInt3))
    {
      i = Math.min(Math.round(paramInt2 / paramInt4), Math.round(paramInt1 / paramInt3));
      f1 = paramInt1 * paramInt2;
      float f2 = paramInt3 * paramInt4 * 2;
      paramInt1 = i;
      while (true)
      {
        i = paramInt1;
        if (f1 / (paramInt1 * paramInt1) <= f2)
          break;
        paramInt1 += 1;
      }
    }
    paramInt1 = i;
    if (i < 1)
      paramInt1 = 1;
    if (paramInt1 == 1)
      paramInt1 = j;
    do
    {
      return paramInt1;
      paramInt2 = bD(paramInt1);
      f1 = paramInt2 / paramInt1;
      paramInt1 = paramInt2;
    }
    while (f1 <= 2.0F / f1);
    return paramInt2 / 2;
  }

  private static int d(ContentResolver paramContentResolver, Uri paramUri)
  {
    if (!"image/jpeg".equals(b(paramContentResolver, paramUri).outMimeType))
      return 0;
    c localc = new c();
    Object localObject = null;
    ContentResolver localContentResolver = null;
    try
    {
      paramContentResolver = paramContentResolver.openInputStream(paramUri);
      localContentResolver = paramContentResolver;
      localObject = paramContentResolver;
      localc.a(paramContentResolver);
      localContentResolver = paramContentResolver;
      localObject = paramContentResolver;
      paramUri = localc.d(c.v);
      if (paramUri != null)
      {
        localContentResolver = paramContentResolver;
        localObject = paramContentResolver;
        if (paramUri.v() == 3)
        {
          localContentResolver = paramContentResolver;
          localObject = paramContentResolver;
          int i = c.b((short)paramUri.n(0));
          com.google.android.keep.util.e.e(paramContentResolver);
          return i;
        }
      }
      com.google.android.keep.util.e.e(paramContentResolver);
      return 0;
    }
    catch (Exception paramContentResolver)
    {
      localObject = localContentResolver;
      r.e("Keep", "Failed to get orientation:", new Object[] { paramContentResolver });
      com.google.android.keep.util.e.e(localContentResolver);
      return 0;
    }
    finally
    {
      com.google.android.keep.util.e.e((InputStream)localObject);
    }
    throw paramContentResolver;
  }

  private static Bitmap d(String paramString, int paramInt)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    double d = Math.sqrt(((BitmapFactory.Options)localObject).outWidth * ((BitmapFactory.Options)localObject).outHeight / 2000000.0D);
    if (d <= 1.0D)
      d = 1.0D;
    try
    {
      while (true)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = ((int)d);
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        localObject = new Matrix();
        ((Matrix)localObject).postRotate(paramInt);
        localObject = Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), (Matrix)localObject, true);
        paramString.recycle();
        return localObject;
        d = bD((int)Math.ceil(d));
      }
    }
    catch (OutOfMemoryError paramString)
    {
      Log.e("Keep", "Got OutOfMemoryError in rotateAndScaleImage", paramString);
    }
    return null;
  }

  public static ImageBlob d(Context paramContext, long paramLong, Uri paramUri)
    throws IOException, MediaStore.FileValidationException
  {
    int i = aF(paramUri.getPath());
    if (i != 0)
    {
      paramContext = new a(paramContext, paramLong);
      Bitmap localBitmap = d(paramUri.getPath(), i);
      if (localBitmap == null)
        return null;
      e.l(paramUri);
      return a(localBitmap, Dh, Dj);
    }
    paramContext = c(paramContext, paramLong, paramUri);
    e.l(paramUri);
    return paramContext;
  }

  private static class a extends MediaStore.a
  {
    public a(Context paramContext, long paramLong)
      throws FileNotFoundException
    {
      long l = e(paramContext, paramLong);
      Uri localUri = i.j.a(paramLong, l);
      Dj = paramContext.getContentResolver().openOutputStream(localUri);
      if (Dj == null)
        throw new FileNotFoundException("Can not create new image file");
      Dh = e.O(l);
      Di = e.b(paramContext, paramLong, 0, Dh);
    }

    protected boolean a(Context paramContext, long paramLong1, long paramLong2)
    {
      return e.b(paramContext, paramLong1, paramLong2).exists();
    }
  }
}