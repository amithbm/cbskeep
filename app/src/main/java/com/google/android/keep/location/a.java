package com.google.android.keep.location;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.keep.util.r;

public class a
{
  private static final Uri sh = Uri.parse("content://com.google.settings/partner");

  public static boolean m(Context paramContext)
  {
    return paramContext.getPackageManager().resolveActivity(new Intent("com.google.android.gsf.GOOGLE_APPS_LOCATION_SETTINGS"), 65536) != null;
  }

  private static int n(Context paramContext)
  {
    Object localObject2 = paramContext.getContentResolver();
    Object localObject1 = null;
    paramContext = null;
    Object localObject3 = null;
    Object localObject4 = null;
    try
    {
      Cursor localCursor = ((ContentResolver)localObject2).query(sh, new String[] { "value" }, "name=?", new String[] { "use_location_for_services" }, null);
      localObject2 = localObject4;
      if (localCursor != null)
      {
        localObject2 = localObject4;
        paramContext = localCursor;
        localObject1 = localCursor;
        if (localCursor.moveToNext())
        {
          paramContext = localCursor;
          localObject1 = localCursor;
          localObject2 = localCursor.getString(0);
        }
      }
      localObject1 = localObject2;
      if (localCursor != null)
      {
        localCursor.close();
        localObject1 = localObject2;
      }
      if (localObject1 == null)
        return 2;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
      {
        localObject1 = paramContext;
        r.d("Keep", "Failed to get 'Use My Location' setting", new Object[] { localRuntimeException });
        localObject1 = localObject3;
        if (paramContext != null)
        {
          paramContext.close();
          localObject1 = localObject3;
        }
      }
    }
    finally
    {
      if (localObject1 != null)
        ((Cursor)localObject1).close();
    }
    try
    {
      int i = Integer.parseInt((String)localObject1);
      return i;
    }
    catch (NumberFormatException paramContext)
    {
    }
    return 2;
  }

  public static boolean o(Context paramContext)
  {
    return (!m(paramContext)) || (n(paramContext) == 1);
  }
}