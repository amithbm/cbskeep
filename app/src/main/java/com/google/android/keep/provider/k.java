package com.google.android.keep.provider;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.keep.model.m;
import com.google.android.keep.util.r;

public class k
{
  private static final String Dg = "(SELECT GROUP_CONCAT(" + f.f("groupConcatSourceTable.is_checked", "0") + " || ' : ' || " + f.f("groupConcatSourceTable.text", "") + ", " + "' / '" + ") " + "FROM " + "(SELECT grpConcatListItemTable.is_checked, grpConcatListItemTable.text, CASE tree_entity.is_graveyard_off WHEN 1 THEN 0 ELSE grpConcatListItemTable.is_checked END AS first_order FROM list_item AS grpConcatListItemTable WHERE grpConcatListItemTable.list_parent_id=tree_entity._id AND grpConcatListItemTable.is_deleted=0 ORDER BY first_order ASC,grpConcatListItemTable.order_in_parent DESC,grpConcatListItemTable.time_last_updated DESC  %s ) AS groupConcatSourceTable)";

  public static m[] aL(String paramString)
  {
    r.a("KeepListItemGroup", "parseChildren()", new Object[0]);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    String[] arrayOfString1 = paramString.split(" / ");
    int j;
    if (r.isLoggable("KeepListItemGroup", 2))
    {
      j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        paramString = arrayOfString1[i];
        Log.v("KeepListItemGroup", "    listItem: " + paramString);
        i += 1;
      }
    }
    m[] arrayOfm = new m[arrayOfString1.length];
    int i = 0;
    while (true)
    {
      paramString = arrayOfm;
      if (i >= arrayOfString1.length)
        break;
      String[] arrayOfString2 = arrayOfString1[i].split(" : ");
      if (r.isLoggable("KeepListItemGroup", 2))
      {
        Log.v("KeepListItemGroup", "This list item has " + arrayOfString2.length + " # of tokens. Original list item string:" + arrayOfString1[i]);
        int k = arrayOfString2.length;
        j = 0;
        while (j < k)
        {
          paramString = arrayOfString2[j];
          Log.v("KeepListItemGroup", "        childToken: " + paramString);
          j += 1;
        }
      }
      boolean bool = false;
      paramString = null;
      if (arrayOfString2.length >= 1);
      try
      {
        j = Integer.valueOf(f.aE(arrayOfString2[0])).intValue();
        if (j == 1);
        for (bool = true; ; bool = false)
        {
          if (arrayOfString2.length >= 2)
            paramString = f.aE(arrayOfString2[1]);
          arrayOfm[i] = new m(paramString, bool);
          r.a("KeepListItemGroup", "Created list item", new Object[0]);
          i += 1;
          break;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          r.e("KeepListItemGroup", "NumberFormatException when parsing checked state", new Object[] { localNumberFormatException });
          bool = false;
        }
      }
    }
  }

  public static String bI(int paramInt)
  {
    if (paramInt > 0)
      return String.format(Dg, new Object[] { " LIMIT " + paramInt });
    if (paramInt == 0)
      return String.format(Dg, new Object[] { " " });
    throw new IllegalArgumentException("Invalid limit:" + paramInt);
  }
}