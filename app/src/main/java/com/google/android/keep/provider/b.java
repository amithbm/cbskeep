package com.google.android.keep.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.keep.activities.KeepApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;

public final class b extends MediaStore
{
  private static Object BL = new Object();
  private static Constructor<? extends InputStream> BM;
  private static MediaPlayer te;

  public static String a(ContentResolver paramContentResolver, Uri paramUri)
  {
    if ((paramUri == null) || (!KeepApplication.ad()))
      return "UNKNOWN";
    MediaExtractor localMediaExtractor = new MediaExtractor();
    try
    {
      paramContentResolver = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
      if (paramContentResolver == null)
        return "UNKNOWN";
      localMediaExtractor.setDataSource(paramContentResolver.getFileDescriptor(), paramContentResolver.getStartOffset(), paramContentResolver.getLength());
      if (localMediaExtractor.getTrackCount() == 0)
        return "UNKNOWN";
    }
    catch (IOException paramContentResolver)
    {
      Log.e("Keep", "File not found", paramContentResolver);
      return "UNKNOWN";
    }
    paramContentResolver = localMediaExtractor.getTrackFormat(0).getString("mime");
    localMediaExtractor.release();
    return paramContentResolver;
  }

  public static String a(Context paramContext, long paramLong, InputStream paramInputStream)
    throws MediaStore.FileValidationException
  {
    new ContentValues();
    try
    {
      paramContext = new a(paramContext, paramLong);
      if (!a(paramInputStream, paramContext))
        return null;
    }
    catch (FileNotFoundException paramContext)
    {
      Log.e("Keep", "Fail to create audio file", paramContext);
      return null;
    }
    return Dh;
  }

  private static boolean a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    InputStream localInputStream = d(paramInputStream);
    if (localInputStream == null)
      return false;
    byte[] arrayOfByte = new byte[1024];
    try
    {
      paramOutputStream.write("#!AMR\n".getBytes());
      while (true)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (IOException localIOException1)
    {
      Log.e("Keep", "Error transcoding the file", localIOException1);
      try
      {
        localInputStream.close();
        try
        {
          paramInputStream.close();
          try
          {
            paramOutputStream.close();
            return false;
          }
          catch (IOException paramInputStream)
          {
            Log.e("Keep", "Error closing outputStream", paramInputStream);
            return false;
          }
          try
          {
            localInputStream.close();
            try
            {
              paramInputStream.close();
              try
              {
                paramOutputStream.close();
                return true;
              }
              catch (IOException paramInputStream)
              {
                Log.e("Keep", "Error closing outputStream", paramInputStream);
                return true;
              }
            }
            catch (IOException paramInputStream)
            {
              Log.e("Keep", "Error closing inputStream", paramInputStream);
              try
              {
                paramOutputStream.close();
                return true;
              }
              catch (IOException paramInputStream)
              {
                Log.e("Keep", "Error closing outputStream", paramInputStream);
                return true;
              }
            }
            finally
            {
            }
          }
          catch (IOException localIOException2)
          {
            Log.e("Keep", "Error closing AmrInputStream", localIOException2);
            try
            {
              paramInputStream.close();
              try
              {
                paramOutputStream.close();
                return true;
              }
              catch (IOException paramInputStream)
              {
                Log.e("Keep", "Error closing outputStream", paramInputStream);
                return true;
              }
            }
            catch (IOException paramInputStream)
            {
              Log.e("Keep", "Error closing inputStream", paramInputStream);
              try
              {
                paramOutputStream.close();
                return true;
              }
              catch (IOException paramInputStream)
              {
                Log.e("Keep", "Error closing outputStream", paramInputStream);
                return true;
              }
            }
            finally
            {
            }
          }
          finally
          {
            try
            {
              paramInputStream.close();
            }
            catch (IOException paramInputStream)
            {
              while (true)
              {
                Log.e("Keep", "Error closing inputStream", paramInputStream);
                try
                {
                  paramOutputStream.close();
                }
                catch (IOException paramInputStream)
                {
                  Log.e("Keep", "Error closing outputStream", paramInputStream);
                }
              }
            }
            finally
            {
            }
          }
        }
        catch (IOException paramInputStream)
        {
          Log.e("Keep", "Error closing inputStream", paramInputStream);
          try
          {
            paramOutputStream.close();
            return false;
          }
          catch (IOException paramInputStream)
          {
            Log.e("Keep", "Error closing outputStream", paramInputStream);
            return false;
          }
        }
        finally
        {
          try
          {
            paramOutputStream.close();
            throw paramInputStream;
          }
          catch (IOException paramOutputStream)
          {
            while (true)
              Log.e("Keep", "Error closing outputStream", paramOutputStream);
          }
        }
      }
      catch (IOException localIOException3)
      {
        Log.e("Keep", "Error closing AmrInputStream", localIOException3);
        try
        {
          paramInputStream.close();
          try
          {
            paramOutputStream.close();
            return false;
          }
          catch (IOException paramInputStream)
          {
            Log.e("Keep", "Error closing outputStream", paramInputStream);
            return false;
          }
        }
        catch (IOException paramInputStream)
        {
          Log.e("Keep", "Error closing inputStream", paramInputStream);
          try
          {
            paramOutputStream.close();
            return false;
          }
          catch (IOException paramInputStream)
          {
            Log.e("Keep", "Error closing outputStream", paramInputStream);
            return false;
          }
        }
        finally
        {
          try
          {
            paramOutputStream.close();
            throw paramInputStream;
          }
          catch (IOException paramOutputStream)
          {
            while (true)
              Log.e("Keep", "Error closing outputStream", paramOutputStream);
          }
        }
      }
      finally
      {
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          while (true)
          {
            Log.e("Keep", "Error closing inputStream", paramInputStream);
            try
            {
              paramOutputStream.close();
            }
            catch (IOException paramInputStream)
            {
              Log.e("Keep", "Error closing outputStream", paramInputStream);
            }
          }
        }
        finally
        {
          try
          {
            paramOutputStream.close();
            throw paramInputStream;
          }
          catch (IOException paramOutputStream)
          {
            while (true)
              Log.e("Keep", "Error closing outputStream", paramOutputStream);
          }
        }
      }
    }
    finally
    {
      try
      {
        localInputStream.close();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          while (true)
          {
            Log.e("Keep", "Error closing inputStream", paramInputStream);
            try
            {
              paramOutputStream.close();
            }
            catch (IOException paramInputStream)
            {
              Log.e("Keep", "Error closing outputStream", paramInputStream);
            }
          }
        }
        finally
        {
          try
          {
            paramOutputStream.close();
            throw paramInputStream;
          }
          catch (IOException paramOutputStream)
          {
            while (true)
              Log.e("Keep", "Error closing outputStream", paramOutputStream);
          }
        }
      }
      catch (IOException localIOException4)
      {
        while (true)
        {
          Log.e("Keep", "Error closing AmrInputStream", localIOException4);
          try
          {
            paramInputStream.close();
            try
            {
              paramOutputStream.close();
            }
            catch (IOException paramInputStream)
            {
              Log.e("Keep", "Error closing outputStream", paramInputStream);
            }
          }
          catch (IOException paramInputStream)
          {
            Log.e("Keep", "Error closing inputStream", paramInputStream);
            try
            {
              paramOutputStream.close();
            }
            catch (IOException paramInputStream)
            {
              Log.e("Keep", "Error closing outputStream", paramInputStream);
            }
          }
          finally
          {
            try
            {
              paramOutputStream.close();
              throw paramInputStream;
            }
            catch (IOException paramOutputStream)
            {
              while (true)
                Log.e("Keep", "Error closing outputStream", paramOutputStream);
            }
          }
        }
      }
      finally
      {
        try
        {
          paramInputStream.close();
          try
          {
            paramOutputStream.close();
            throw localObject4;
          }
          catch (IOException paramInputStream)
          {
            while (true)
              Log.e("Keep", "Error closing outputStream", paramInputStream);
          }
        }
        catch (IOException paramInputStream)
        {
          while (true)
          {
            paramInputStream = paramInputStream;
            Log.e("Keep", "Error closing inputStream", paramInputStream);
            try
            {
              paramOutputStream.close();
            }
            catch (IOException paramInputStream)
            {
              Log.e("Keep", "Error closing outputStream", paramInputStream);
            }
          }
        }
        finally
        {
        }
      }
    }
    try
    {
      paramOutputStream.close();
      throw paramInputStream;
    }
    catch (IOException paramOutputStream)
    {
      while (true)
        Log.e("Keep", "Error closing outputStream", paramOutputStream);
    }
  }

  // ERROR //
  public static com.google.android.keep.model.VoiceBlob b(Context paramContext, long paramLong, Uri paramUri)
    throws MediaStore.FileValidationException, MediaStore.UnsupportedMimeTypeException
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_0
    //   6: aload_0
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 165	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore 5
    //   14: new 6	com/google/android/keep/provider/b$a
    //   17: dup
    //   18: aload_0
    //   19: lload_1
    //   20: invokespecial 103	com/google/android/keep/provider/b$a:<init>	(Landroid/content/Context;J)V
    //   23: astore 7
    //   25: aload 5
    //   27: aload_3
    //   28: invokevirtual 169	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   31: astore 8
    //   33: aload 5
    //   35: aload_3
    //   36: invokestatic 171	com/google/android/keep/provider/b:a	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/String;
    //   39: astore 6
    //   41: aload_0
    //   42: aload_3
    //   43: invokestatic 175	com/google/android/keep/provider/b:j	(Landroid/content/Context;Landroid/net/Uri;)I
    //   46: istore 4
    //   48: iload 4
    //   50: ifgt +17 -> 67
    //   53: aconst_null
    //   54: areturn
    //   55: astore_0
    //   56: ldc 69
    //   58: ldc 177
    //   60: aload_0
    //   61: invokestatic 77	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   64: pop
    //   65: aconst_null
    //   66: areturn
    //   67: new 179	com/google/android/keep/model/VoiceBlob
    //   70: dup
    //   71: aload 7
    //   73: getfield 114	com/google/android/keep/provider/MediaStore$a:Dh	Ljava/lang/String;
    //   76: iload 4
    //   78: invokespecial 182	com/google/android/keep/model/VoiceBlob:<init>	(Ljava/lang/String;I)V
    //   81: astore_3
    //   82: ldc 184
    //   84: aload 6
    //   86: invokevirtual 188	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifeq +16 -> 105
    //   92: aload 8
    //   94: aload 7
    //   96: getfield 192	com/google/android/keep/provider/MediaStore$a:Dj	Ljava/io/OutputStream;
    //   99: invokestatic 194	com/google/android/keep/provider/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   102: pop
    //   103: aload_3
    //   104: areturn
    //   105: getstatic 198	com/google/android/keep/model/VoiceBlob:Ak	Ljava/util/Collection;
    //   108: aload 6
    //   110: invokeinterface 203 2 0
    //   115: ifeq +13 -> 128
    //   118: aload 8
    //   120: aload 7
    //   122: invokestatic 106	com/google/android/keep/provider/b:a	(Ljava/io/InputStream;Lcom/google/android/keep/provider/MediaStore$a;)Z
    //   125: pop
    //   126: aload_3
    //   127: areturn
    //   128: ldc 35
    //   130: aload 6
    //   132: invokevirtual 188	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +49 -> 184
    //   138: aload 8
    //   140: aload 7
    //   142: invokestatic 106	com/google/android/keep/provider/b:a	(Ljava/io/InputStream;Lcom/google/android/keep/provider/MediaStore$a;)Z
    //   145: pop
    //   146: aload 5
    //   148: aload_3
    //   149: invokevirtual 207	com/google/android/keep/model/VoiceBlob:getContentUri	()Landroid/net/Uri;
    //   152: invokestatic 171	com/google/android/keep/provider/b:a	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/String;
    //   155: astore 7
    //   157: aload_3
    //   158: astore_0
    //   159: getstatic 198	com/google/android/keep/model/VoiceBlob:Ak	Ljava/util/Collection;
    //   162: aload 7
    //   164: invokeinterface 203 2 0
    //   169: ifne -163 -> 6
    //   172: aload 5
    //   174: aload_3
    //   175: invokevirtual 207	com/google/android/keep/model/VoiceBlob:getContentUri	()Landroid/net/Uri;
    //   178: aconst_null
    //   179: aconst_null
    //   180: invokevirtual 211	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   183: pop
    //   184: new 159	com/google/android/keep/provider/MediaStore$UnsupportedMimeTypeException
    //   187: dup
    //   188: aload 6
    //   190: invokespecial 214	com/google/android/keep/provider/MediaStore$UnsupportedMimeTypeException:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: astore_0
    //   195: goto -139 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   14	25	55	java/io/FileNotFoundException
    //   25	33	194	java/io/FileNotFoundException
  }

  private static InputStream d(InputStream paramInputStream)
  {
    try
    {
      if (BM == null);
      synchronized (BL)
      {
        if (BM == null)
          BM = Class.forName("android.media.AmrInputStream").getConstructor(new Class[] { InputStream.class });
        paramInputStream = (InputStream)BM.newInstance(new Object[] { paramInputStream });
        return paramInputStream;
      }
    }
    catch (Exception paramInputStream)
    {
      Log.e("Keep", "Exception while instantiating AmrInputStream", paramInputStream);
    }
    return null;
  }

  private static int j(Context paramContext, Uri paramUri)
  {
    if (te == null)
    {
      te = new MediaPlayer();
      if (paramUri != null)
        break label31;
    }
    while (true)
    {
      return -1;
      te.reset();
      break;
      try
      {
        label31: paramContext = paramContext.getContentResolver().openFileDescriptor(paramUri, "r");
        if (paramContext != null)
        {
          te.setDataSource(paramContext.getFileDescriptor());
          te.prepare();
          te.setLooping(false);
          int i = te.getDuration();
          return i;
        }
      }
      catch (IOException paramContext)
      {
        Log.e("Keep", "Error preparing audio uri", paramContext);
      }
    }
    return 0;
  }

  private static class a extends MediaStore.a
  {
    public a(Context paramContext, long paramLong)
      throws FileNotFoundException
    {
      long l = e(paramContext, paramLong);
      Uri localUri = i.y.d(paramLong, l);
      Dj = paramContext.getContentResolver().openOutputStream(localUri);
      if (Dj == null)
        throw new FileNotFoundException("Can not create new audio file");
      Dh = e.P(l);
      Di = e.b(paramContext, paramLong, 1, Dh);
    }

    protected boolean a(Context paramContext, long paramLong1, long paramLong2)
    {
      return e.c(paramContext, paramLong1, paramLong2).exists();
    }
  }
}