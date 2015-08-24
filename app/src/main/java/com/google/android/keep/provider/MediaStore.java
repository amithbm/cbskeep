package com.google.android.keep.provider;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.r;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class MediaStore
{
  protected static boolean a(InputStream paramInputStream, a parama)
    throws MediaStore.FileValidationException
  {
    if (!e.b(paramInputStream, parama.Dj))
      e.aC(parama.Di);
    while (TextUtils.isEmpty(parama.Di))
      return false;
    paramInputStream = new File(parama.Di);
    if ((paramInputStream.exists()) && (paramInputStream.length() >= Config.nD()))
    {
      r.a("Keep", "File " + parama.Di + " exceeds the limit " + paramInputStream.length(), new Object[0]);
      e.e(paramInputStream);
      bJ((int)paramInputStream.length());
    }
    return true;
  }

  protected static void bJ(int paramInt)
    throws MediaStore.FileValidationException
  {
    if (paramInt >= Config.nD())
      throw new FileValidationException("Expected maximum file size = " + Config.nD() + " and get " + paramInt);
  }

  public static class FileValidationException extends Exception
  {
    public FileValidationException(String paramString)
    {
      super();
    }
  }

  public static class UnsupportedMimeTypeException extends Exception
  {
    public UnsupportedMimeTypeException(String paramString)
    {
      super();
    }
  }

  protected static abstract class a
  {
    public String Dh;
    public String Di;
    public OutputStream Dj;

    protected abstract boolean a(Context paramContext, long paramLong1, long paramLong2);

    protected long e(Context paramContext, long paramLong)
    {
      int i = 0;
      while (i < 1000000)
      {
        long l = com.google.android.keep.util.e.currentTimeMillis();
        if (!a(paramContext, paramLong, l))
          return l;
        i += 1;
      }
      throw new IllegalStateException("Fail to generate unique file name");
    }
  }
}