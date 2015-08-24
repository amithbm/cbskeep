package com.google.android.keep.util;

import android.text.TextUtils;
import com.google.android.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Random;

public class KeepJsonHttpClient
{
  private static final String TAG = KeepJsonHttpClient.class.getSimpleName();
  protected a PM = new a();
  private RequestMethod PN;
  private String PO;
  private String PP;
  private boolean PQ;
  private String[] PR;
  private Random PS;
  private String mAuthToken;

  private void c(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
      if (mAuthToken != null)
        paramString1.setRequestProperty("Authorization", "Bearer " + mAuthToken);
      if (paramString2 != null)
      {
        paramString1.setDoOutput(true);
        if (PN != RequestMethod.PT)
          break label172;
        paramString1.setRequestMethod("POST");
        if (PQ)
        {
          Preconditions.checkNotNull(paramString3);
          paramString1.setRequestProperty("Content-Type", "multipart/mixed; boundary=" + paramString3);
        }
      }
      while (true)
      {
        paramString3 = paramString1.getOutputStream();
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramString3);
        paramString3.write(paramString2.getBytes());
        localOutputStreamWriter.flush();
        localOutputStreamWriter.close();
        PM.PW = paramString1.getResponseCode();
        PM.PX = f(paramString1.getInputStream());
        return;
        label172: paramString1.setRequestMethod("GET");
        paramString1.setRequestProperty("Content-Type", "application/json");
      }
    }
    catch (Throwable paramString1)
    {
      if (paramString1.getClass().equals(UnknownHostException.class))
      {
        PM.PW = -2;
        return;
      }
      PM.PW = -1;
    }
  }

  private byte[] f(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte = new byte[1024];
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0)
        {
          paramInputStream.close();
          return localByteArrayOutputStream.toByteArray();
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      paramInputStream.close();
    }
  }

  private String kv()
  {
    return Long.toString(PS.nextLong(), 36);
  }

  private String ol()
  {
    return kv();
  }

  public KeepJsonHttpClient a(RequestMethod paramRequestMethod)
  {
    Preconditions.checkNotNull(paramRequestMethod);
    PN = paramRequestMethod;
    return this;
  }

  public KeepJsonHttpClient bA(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    mAuthToken = paramString;
    return this;
  }

  public KeepJsonHttpClient bB(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    PO = paramString;
    return this;
  }

  public KeepJsonHttpClient c(String[] paramArrayOfString)
  {
    Preconditions.checkNotNull(paramArrayOfString);
    PR = paramArrayOfString;
    PQ = true;
    if (PS == null)
      PS = new Random();
    return this;
  }

  public a oj()
  {
    return PM;
  }

  public void ok()
  {
    String str1 = null;
    String str2 = PP;
    if (PQ)
    {
      str1 = ol();
      str2 = "\r\n--" + str1 + "\r\n";
      String str3 = "\r\n--" + str1 + "--";
      str2 = str2 + TextUtils.join(str2, PR) + str3;
    }
    c(PO, str2, str1);
  }

  public static enum RequestMethod
  {
  }

  public static class a
  {
    public int PW = -1;
    public byte[] PX;

    public boolean om()
    {
      return PW == 200;
    }
  }
}