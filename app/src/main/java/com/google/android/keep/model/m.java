package com.google.android.keep.model;

import android.text.TextUtils;

public class m
{
  private String sv;
  private boolean tm;
  private final String uK;
  private Long vF;

  public m(String paramString, boolean paramBoolean)
  {
    this(paramString, paramBoolean, null, null);
  }

  public m(String paramString1, boolean paramBoolean, String paramString2)
  {
    this(paramString1, paramBoolean, paramString2, null);
  }

  public m(String paramString1, boolean paramBoolean, String paramString2, Long paramLong)
  {
    sv = paramString1;
    tm = paramBoolean;
    uK = paramString2;
    vF = paramLong;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof m))
      {
        paramObject = (m)paramObject;
        bool1 = bool2;
        if (TextUtils.equals(sv, paramObject.getText()))
        {
          bool1 = bool2;
          if (tm == paramObject.hz())
            bool1 = true;
        }
      }
    }
    return bool1;
  }

  public String getText()
  {
    return sv;
  }

  public String gu()
  {
    return uK;
  }

  public Long hu()
  {
    return vF;
  }

  public boolean hz()
  {
    return tm;
  }

  public String toString()
  {
    return "ListItemPreview{ text:" + sv + ", " + "checked: " + tm + "}";
  }
}