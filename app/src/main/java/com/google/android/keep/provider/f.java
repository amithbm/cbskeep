package com.google.android.keep.provider;

import android.text.TextUtils;

public class f
{
  static String aD(String paramString)
  {
    paramString = "REPLACE(" + paramString + "," + "'" + ":" + "'," + "'" + "::" + "')";
    return "(REPLACE(" + paramString + "," + "'" + "/" + "'," + "'" + "//" + "'))";
  }

  static String aE(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return paramString;
    return paramString.replaceAll("//", "/").replaceAll("::", ":");
  }

  static String f(String paramString1, String paramString2)
  {
    return "CASE WHEN " + paramString1 + " IS NULL " + "THEN '" + paramString2 + "' " + "ELSE " + aD(paramString1) + " " + "END";
  }
}