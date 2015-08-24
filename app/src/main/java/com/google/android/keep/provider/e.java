package com.google.android.keep.provider;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.keep.util.r;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e
{
  private static final String BS = "image" + File.separator + "original";
  private static final String BT = "image" + File.separator + "thumbnail";
  private static String BU = null;
  private static String BV = null;
  private static Object BW = new Object();

  private static String N(long paramLong)
  {
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format((Date)localObject);
    return (String)localObject + "_" + paramLong % 1000L;
  }

  public static String O(long paramLong)
  {
    return "IMG_" + N(paramLong) + ".jpg";
  }

  public static String P(long paramLong)
  {
    return "AUDIO_" + N(paramLong) + ".3gp";
  }

  public static Uri a(Context paramContext, long paramLong, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return null;
      paramContext = new File(b(paramContext, paramLong, paramInt, paramString));
    }
    while (!paramContext.exists());
    return Uri.fromFile(paramContext);
  }

  private static File a(File paramFile, String paramString1, String paramString2, long paramLong)
  {
    if (paramFile == null)
      throw new IllegalArgumentException("Cannot have null file directory");
    if (!c(paramFile))
    {
      Log.e("Keep", "Failed to create directory");
      throw new IllegalStateException("Cannot create new folder!");
    }
    paramFile.getPath();
    paramFile = new File(paramFile.getPath() + File.separator + paramString1 + N(paramLong) + paramString2);
    r.a("Keep", "Created new file: " + paramFile.toString(), new Object[0]);
    return paramFile;
  }

  private static String a(String paramString1, long paramLong, String paramString2)
  {
    return paramString1 + File.separator + paramLong + File.separator + paramString2 + File.separator;
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

  // ERROR //
  static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore_3
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore 6
    //   21: aconst_null
    //   22: astore 5
    //   24: new 164	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_0
    //   33: new 169	java/io/FileOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 170	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_1
    //   42: aload_0
    //   43: aload_1
    //   44: invokestatic 173	com/google/android/keep/provider/e:b	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   47: istore_2
    //   48: aload_0
    //   49: invokestatic 175	com/google/android/keep/provider/e:a	(Ljava/io/Closeable;)V
    //   52: aload_1
    //   53: invokestatic 175	com/google/android/keep/provider/e:a	(Ljava/io/Closeable;)V
    //   56: iload_2
    //   57: ireturn
    //   58: astore_1
    //   59: aload 7
    //   61: astore_0
    //   62: aload_0
    //   63: astore_3
    //   64: aload 5
    //   66: astore 4
    //   68: aload_1
    //   69: invokevirtual 178	java/io/FileNotFoundException:printStackTrace	()V
    //   72: aload_0
    //   73: invokestatic 175	com/google/android/keep/provider/e:a	(Ljava/io/Closeable;)V
    //   76: aload 5
    //   78: invokestatic 175	com/google/android/keep/provider/e:a	(Ljava/io/Closeable;)V
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_0
    //   84: aload_3
    //   85: invokestatic 175	com/google/android/keep/provider/e:a	(Ljava/io/Closeable;)V
    //   88: aload 4
    //   90: invokestatic 175	com/google/android/keep/provider/e:a	(Ljava/io/Closeable;)V
    //   93: aload_0
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: astore_3
    //   98: aload 6
    //   100: astore 4
    //   102: aload_1
    //   103: astore_0
    //   104: goto -20 -> 84
    //   107: astore 5
    //   109: aload_0
    //   110: astore_3
    //   111: aload_1
    //   112: astore 4
    //   114: aload 5
    //   116: astore_0
    //   117: goto -33 -> 84
    //   120: astore_1
    //   121: goto -59 -> 62
    //   124: astore_3
    //   125: aload_1
    //   126: astore 5
    //   128: aload_3
    //   129: astore_1
    //   130: goto -68 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   24	33	58	java/io/FileNotFoundException
    //   24	33	83	finally
    //   68	72	83	finally
    //   33	42	95	finally
    //   42	48	107	finally
    //   33	42	120	java/io/FileNotFoundException
    //   42	48	124	java/io/FileNotFoundException
  }

  public static boolean aC(String paramString)
  {
    return e(new File(paramString));
  }

  public static File b(Context paramContext, long paramLong1, long paramLong2)
  {
    return a(new File(a(v(paramContext), paramLong1, BS)), "IMG_", ".jpg", paramLong2);
  }

  static String b(Context paramContext, long paramLong, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    paramContext = v(paramContext);
    StringBuilder localStringBuilder = new StringBuilder().append(paramContext).append(File.separator).append(paramLong).append(File.separator);
    if (paramInt == 0);
    for (paramContext = BS; ; paramContext = "audio")
      return paramContext + File.separator + paramString;
  }

  static boolean b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (IOException localIOException)
    {
      Log.e("Keep", "Error writing to file", localIOException);
      return false;
      return true;
    }
    finally
    {
      a(paramInputStream);
      a(paramOutputStream);
    }
  }

  static File c(Context paramContext, long paramLong1, long paramLong2)
  {
    return a(new File(a(v(paramContext), paramLong1, "audio")), "AUDIO_", ".3gp", paramLong2);
  }

  private static boolean c(File paramFile)
  {
    if (!paramFile.exists())
      synchronized (BW)
      {
        if ((!paramFile.exists()) && (!paramFile.mkdirs()))
          return false;
      }
    return true;
  }

  public static void d(Context paramContext, long paramLong)
  {
    if (paramLong <= 0L)
      throw new IllegalStateException("Invalid accountId:" + paramLong);
    d(new File(paramContext.getExternalFilesDir(null), String.valueOf(paramLong)));
    d(new File(paramContext.getFilesDir(), String.valueOf(paramLong)));
  }

  public static void d(File paramFile)
  {
    if (!paramFile.exists())
      return;
    r.a("Keep", "Delete folder", new Object[0]);
    File[] arrayOfFile = paramFile.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.isDirectory())
        d(localFile);
      while (true)
      {
        i += 1;
        break;
        r.a("Keep", "Delete file", new Object[0]);
        e(localFile);
      }
    }
    paramFile.delete();
  }

  static boolean e(File paramFile)
  {
    if (paramFile.exists())
    {
      boolean bool = paramFile.delete();
      if (!bool)
        Log.e("Keep", "Deleting file fails");
      return bool;
    }
    Log.e("Keep", "File not found");
    return false;
  }

  public static boolean l(Uri paramUri)
  {
    if (paramUri == null)
      return false;
    return aC(paramUri.getPath());
  }

  private static String v(Context paramContext)
  {
    if (TextUtils.isEmpty(BU))
    {
      BU = paramContext.getFilesDir().getAbsolutePath();
      if (TextUtils.isEmpty(BU))
        throw new IllegalStateException("Can not get the internal file folder");
    }
    return BU;
  }

  static String w(Context paramContext)
  {
    paramContext = v(paramContext);
    return "(CASE blob.blob_type WHEN 0 THEN '" + paramContext + File.separator + "'" + "||" + "blob" + "." + "blob_account_id" + "||" + "'/" + BS + "/'" + "||" + "blob" + "." + "file_name" + " " + "WHEN " + 1 + " THEN " + "'" + paramContext + File.separator + "'" + "||" + "blob" + "." + "blob_account_id" + "||" + "'/" + "audio" + "/'" + "||" + "blob" + "." + "file_name" + " " + "ELSE " + "file_name" + " END)";
  }
}