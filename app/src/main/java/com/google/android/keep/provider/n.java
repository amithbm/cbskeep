package com.google.android.keep.provider;

import android.text.TextUtils;
import com.google.android.keep.model.Sharee;
import com.google.android.keep.model.Sharee.Role;
import com.google.android.keep.util.r;

public class n
{
  private static final String Dg = "(SELECT GROUP_CONCAT(" + f.f("shareesGroupConcatSourceTable.email", "") + " || ' : ' || " + f.f("shareesGroupConcatSourceTable.name", "") + " || ' : ' || " + "shareesGroupConcatSourceTable" + "." + "role" + " || ' : ' || " + f.f("shareesGroupConcatSourceTable.avatar_uri", "") + ", " + "' / '" + ") " + "FROM " + "(SELECT shareesGroupConcatTable.email, shareesGroupConcatTable.name, shareesGroupConcatTable.role, shareesGroupConcatTable.avatar_uri FROM sharing AS shareesGroupConcatTable WHERE shareesGroupConcatTable.tree_entity_id=tree_entity._id AND shareesGroupConcatTable.is_deleted=0 %s ) AS shareesGroupConcatSourceTable" + ")";

  public static Sharee[] aS(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    String[] arrayOfString = paramString.split(" / ");
    Sharee[] arrayOfSharee = new Sharee[arrayOfString.length];
    int i = 0;
    while (true)
    {
      paramString = arrayOfSharee;
      if (i >= arrayOfString.length)
        break;
      Object localObject = arrayOfString[i].split(" : ");
      String str1 = f.aE(localObject[0]);
      String str2 = f.aE(localObject[1]);
      paramString = null;
      try
      {
        localObject = Sharee.Role.bk(Integer.valueOf(f.aE(localObject[2])).intValue());
        paramString = (String)localObject;
        arrayOfSharee[i] = new Sharee(-1L, -1L, str1, str2, paramString);
        r.a("ShareesGroupConcat", "Created " + arrayOfSharee[i], new Object[0]);
        i += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          r.e("ShareesGroupConcat", "NumberFormatException when parsing role", new Object[] { localNumberFormatException });
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