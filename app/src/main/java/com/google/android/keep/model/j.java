package com.google.android.keep.model;

import android.accounts.Account;
import android.content.ContentUris;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.keep.provider.i.a;

public class j
{
  private final Account mAccount;
  private final long mId;
  private final String mName;

  public j(long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Account name can not be null or empty string");
    if (!u(paramLong))
      throw new IllegalArgumentException("Invalid account id:" + paramLong);
    mAccount = new Account(paramString, "com.google");
    mId = paramLong;
    mName = paramString;
  }

  public static boolean u(long paramLong)
  {
    return paramLong >= 0L;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      bool1 = bool2;
      if (paramObject.getId() == mId)
      {
        bool1 = bool2;
        if (TextUtils.equals(paramObject.getName(), mName))
          bool1 = true;
      }
    }
    return bool1;
  }

  public long getId()
  {
    return mId;
  }

  public String getName()
  {
    return mName;
  }

  public Uri hk()
  {
    return ContentUris.withAppendedId(i.a.CONTENT_URI, mId);
  }

  public Account hl()
  {
    return mAccount;
  }

  public String toString()
  {
    return "KeepAccount{id= " + String.valueOf(mId) + ", name=" + mName + "}";
  }
}