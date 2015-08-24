package com.google.android.keep.provider;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AutoRevocablePermissions
{
  private final Map<String, a> BN = new Hashtable();
  private final SecureRandom BO = new SecureRandom();
  private final c BP;

  public AutoRevocablePermissions(c paramc)
  {
    BP = paramc;
  }

  private void M(long paramLong)
  {
    Iterator localIterator = BN.entrySet().iterator();
    while (localIterator.hasNext())
      if (!a(paramLong, (a)((Map.Entry)localIterator.next()).getValue()))
        localIterator.remove();
  }

  private boolean a(long paramLong, a parama)
  {
    return paramLong < parama.BQ;
  }

  private String kv()
  {
    byte[] arrayOfByte = new byte[''];
    BO.nextBytes(arrayOfByte);
    return Base64.encodeToString(arrayOfByte, 0);
  }

  final Uri aB(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return null;
      M(BP.currentTimeMillis());
      paramString = (a)BN.get(paramString);
    }
    while (paramString == null);
    return paramString.mUri;
  }

  final String b(Uri paramUri, long paramLong)
  {
    long l = BP.currentTimeMillis();
    M(l);
    String str = kv();
    BN.put(str, new a(paramUri, l, paramLong));
    return str;
  }

  final int getTokenMapSize()
  {
    return BN.size();
  }

  private static class a
  {
    public final long BQ;
    public final Uri mUri;

    public a(Uri paramUri, long paramLong1, long paramLong2)
    {
      mUri = paramUri;
      BQ = (paramLong1 + paramLong2);
    }
  }
}