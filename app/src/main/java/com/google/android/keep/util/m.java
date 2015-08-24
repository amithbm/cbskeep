package com.google.android.keep.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.activities.SharingUrlResolverActivity;
import com.google.android.keep.model.j;
import com.google.android.keep.provider.i.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m
{
  private static final Pattern PD = Pattern.compile("^(/a/[^\\s/]+|)(/keep|)(/create|/share|)(/|)$");

  private static String a(Uri paramUri, String paramString)
  {
    String str1 = paramUri.getQuery();
    String str2 = paramUri.getFragment();
    if (!TextUtils.isEmpty(str2))
      return str2.substring(paramString.length() + 1);
    if (!TextUtils.isEmpty(str1))
      return paramUri.getQueryParameter(paramString);
    return null;
  }

  public static Intent b(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    if ((paramIntent == null) || (!bz(paramIntent.getPath())));
    j localj;
    do
    {
      return null;
      localj = o.O(paramContext);
    }
    while (localj == null);
    if (TextUtils.equals(paramIntent.getLastPathSegment(), "share"))
      return SharingUrlResolverActivity.a(paramContext, paramIntent);
    if (!TextUtils.isEmpty(paramIntent.getFragment()))
    {
      String str = paramIntent.getFragment().toLowerCase();
      if (str.startsWith("note/"))
        return l(paramContext, a(paramIntent, "note"));
      if (str.startsWith("create"))
        return h(paramContext, localj);
    }
    else if (!TextUtils.isEmpty(paramIntent.getQuery()))
    {
      if (!TextUtils.isEmpty(paramIntent.getQueryParameter("note")))
        return l(paramContext, paramIntent.getQueryParameter("note"));
      if (!TextUtils.isEmpty(paramIntent.getQueryParameter("reminder")))
      {
        paramIntent = w.bF(a(paramIntent, "reminder"));
        if (paramIntent == null)
          return new Intent(paramContext, BrowseActivity.class);
        if (!TextUtils.isEmpty(paramIntent.iF))
          return l(paramContext, paramIntent.iF);
        return l(paramContext, paramIntent.uK);
      }
    }
    else if (TextUtils.equals(paramIntent.getLastPathSegment(), "create"))
    {
      return h(paramContext, localj);
    }
    return new Intent(paramContext, BrowseActivity.class);
  }

  private static boolean by(String paramString)
  {
    return TextUtils.indexOf(paramString, ' ') != -1;
  }

  public static boolean bz(String paramString)
  {
    if (paramString == null)
      return false;
    return PD.matcher(paramString).matches();
  }

  private static Intent h(Context paramContext, j paramj)
  {
    paramContext = new Intent(paramContext, BrowseActivity.class);
    paramContext.setAction("android.intent.action.INSERT");
    paramContext.putExtra("authAccount", paramj.getName());
    return paramContext;
  }

  private static Intent l(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, BrowseActivity.class);
    String str = paramString;
    if (paramString != null)
      str = paramString.trim();
    if ((TextUtils.isEmpty(str)) || (by(str)));
    do
    {
      return localIntent;
      paramString = paramContext.getContentResolver().query(i.v.CONTENT_URI, new String[] { "_id", "account_id" }, "(uuid=? OR server_id=?)", new String[] { str, str }, null);
    }
    while (paramString == null);
    try
    {
      if (paramString.moveToFirst())
      {
        paramContext = o.j(paramContext, paramString.getLong(1));
        if (!TextUtils.isEmpty(paramContext))
        {
          localIntent.setAction("android.intent.action.VIEW");
          localIntent.putExtra("treeEntityId", paramString.getLong(0));
          localIntent.putExtra("authAccount", paramContext);
        }
      }
      return localIntent;
    }
    finally
    {
      paramString.close();
    }
    throw paramContext;
  }
}