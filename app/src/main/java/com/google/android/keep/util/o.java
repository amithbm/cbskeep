package com.google.android.keep.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.keep.k;
import com.google.android.keep.microapp.WearableDataChangedService;
import com.google.android.keep.model.j;
import com.google.android.keep.provider.e;
import com.google.android.keep.provider.i.a;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.provider.i.t;
import com.google.android.keep.provider.i.v;
import java.util.ArrayList;
import java.util.List;

public class o
{
  private static final Object PE = new Object();
  private static j PF;

  public static j O(Context paramContext)
  {
    if (PF != null)
      return PF;
    Account[] arrayOfAccount = AccountManager.get(paramContext).getAccountsByType("com.google");
    if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
      return null;
    synchronized (PE)
    {
      if (PF != null)
      {
        paramContext = PF;
        return paramContext;
      }
    }
    String str = A.W(paramContext);
    Account localAccount2 = null;
    Account localAccount1 = localAccount2;
    int j;
    int i;
    if (arrayOfAccount != null)
    {
      localAccount1 = localAccount2;
      if (arrayOfAccount.length > 0)
      {
        localAccount2 = arrayOfAccount[0];
        j = arrayOfAccount.length;
        i = 0;
      }
    }
    while (true)
    {
      localAccount1 = localAccount2;
      if (i < j)
      {
        localAccount1 = arrayOfAccount[i];
        if ((localAccount1 == null) || (TextUtils.isEmpty(localAccount1.name)) || (!localAccount1.name.equalsIgnoreCase(str)));
      }
      else
      {
        d(paramContext, localAccount1);
        paramContext = PF;
        return paramContext;
      }
      i += 1;
    }
  }

  private static void P(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, WearableDataChangedService.class);
    paramContext.startService(localIntent);
  }

  private static void Q(Context paramContext)
  {
    if ((PF != null) && ((paramContext instanceof k)))
      ((k)paramContext).aE();
  }

  public static List<j> R(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    Uri localUri = i.a.CONTENT_URI;
    h.a local1 = new h.a()
    {
      public j n(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        return new j(paramAnonymousCursor.getLong(0), paramAnonymousCursor.getString(1));
      }
    };
    return h.a(paramContext, localUri, new String[] { "_id", "name" }, null, null, "_id ASC", local1);
  }

  public static boolean S(Context paramContext)
  {
    paramContext = AccountManager.get(paramContext).getAccountsByType("com.google");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = paramContext[i].name;
      if ((!TextUtils.isEmpty(str)) && (str.endsWith("@google.com")))
        return true;
      i += 1;
    }
    return false;
  }

  public static j a(Context paramContext, Account paramAccount)
  {
    if (!d(paramAccount))
      r.e("Keep", "Try to add invalid account", new Object[0]);
    while (true)
    {
      return null;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(ContentProviderOperation.newAssertQuery(i.a.CONTENT_URI).withSelection("name=?", new String[] { paramAccount.name }).withExpectedCount(0).build());
      ((ArrayList)localObject).add(ContentProviderOperation.newInsert(i.a.CONTENT_URI).withValue("name", paramAccount.name).build());
      ContentResolver localContentResolver = paramContext.getContentResolver();
      try
      {
        localObject = localContentResolver.applyBatch("com.google.android.keep", (ArrayList)localObject);
        if ((localObject != null) && (localObject.length == 2))
        {
          r.a("Keep", "Result from content provider batch " + localObject[1], new Object[0]);
          localObject = localObject[1].uri;
          if (localObject == null)
            return c(paramContext, paramAccount);
        }
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        return c(paramContext, paramAccount);
      }
      catch (RemoteException localRemoteException)
      {
        r.e("Keep", "Remote exception when inserting account into DB", new Object[] { localRemoteException });
        return c(paramContext, paramAccount);
      }
    }
    return new j(ContentUris.parseId(localRemoteException), paramAccount.name);
  }

  public static j b(Context paramContext, Account paramAccount)
  {
    if (!d(paramAccount))
    {
      r.e("Keep", "Try to switch invalid account", new Object[0]);
      return PF;
    }
    synchronized (PE)
    {
      if ((PF != null) && (paramAccount.name.equalsIgnoreCase(PF.getName())))
      {
        paramContext = PF;
        return paramContext;
      }
    }
    d(paramContext, paramAccount);
    paramContext = PF;
    return paramContext;
  }

  public static Intent c(Account paramAccount)
  {
    return AccountManager.newChooseAccountIntent(paramAccount, null, new String[] { "com.google" }, true, null, null, null, null);
  }

  public static j c(Context paramContext, Account paramAccount)
  {
    if (!d(paramAccount))
      r.e("Keep", "Invalid account", new Object[0]);
    do
    {
      return null;
      paramContext = paramContext.getContentResolver();
      String str = paramAccount.name.toLowerCase();
      paramContext = paramContext.query(i.a.CONTENT_URI, new String[] { "_id" }, "LOWER(name)=?", new String[] { str }, null);
    }
    while (paramContext == null);
    try
    {
      if ((paramContext.getCount() == 1) && (paramContext.moveToFirst()))
      {
        paramAccount = new j(paramContext.getLong(0), paramAccount.name);
        return paramAccount;
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
    throw paramAccount;
  }

  private static void d(Context paramContext, Account paramAccount)
  {
    if (paramAccount == null)
      throw new IllegalStateException("Try to set a null account");
    PF = c(paramContext, paramAccount);
    if (PF == null)
      PF = a(paramContext, paramAccount);
    if (PF == null)
      A.q(paramContext, null);
    while (true)
    {
      P(paramContext);
      Q(paramContext);
      return;
      A.q(paramContext, PF.getName());
    }
  }

  public static boolean d(Account paramAccount)
  {
    return (paramAccount != null) && (!TextUtils.isEmpty(name)) && ("com.google".equalsIgnoreCase(type));
  }

  public static void e(j paramj)
  {
    if (paramj == null)
    {
      r.e("Keep", "Try to force sync on a null account", new Object[0]);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("force", true);
    ContentResolver.requestSync(paramj.hl(), "com.google.android.keep", localBundle);
  }

  public static boolean i(Context paramContext, j paramj)
  {
    if (paramj == null)
    {
      r.a("Keep", "Try to remove an null account", new Object[0]);
      return false;
    }
    r.a("Keep", "Removing account " + paramj.getName(), new Object[0]);
    ArrayList localArrayList = new ArrayList();
    ??? = new String[1];
    ???[0] = String.valueOf(paramj.getId());
    localArrayList.add(ContentProviderOperation.newDelete(i.e.BX).withSelection("account_id=?", (String[])???).build());
    localArrayList.add(ContentProviderOperation.newDelete(i.m.BX).withSelection("account_id=?", (String[])???).build());
    localArrayList.add(ContentProviderOperation.newDelete(i.t.BX).withSelection("account_id=?", (String[])???).build());
    localArrayList.add(ContentProviderOperation.newDelete(i.v.BX).withSelection("account_id=?", (String[])???).build());
    localArrayList.add(ContentProviderOperation.newDelete(paramj.hk()).build());
    try
    {
      synchronized (PE)
      {
        try
        {
          paramContext.getContentResolver().applyBatch("com.google.android.keep", localArrayList);
          if ((PF != null) && (PF.getName().equalsIgnoreCase(paramj.getName())))
          {
            PF = null;
            A.q(paramContext, null);
            P(paramContext);
          }
          e.d(paramContext, paramj.getId());
          C.b(paramContext.getContentResolver(), paramj.hl());
          return true;
        }
        catch (OperationApplicationException paramContext)
        {
          r.e("Keep", "Error while deleting account", new Object[] { paramContext });
        }
        return false;
      }
    }
    catch (RemoteException paramContext)
    {
      while (true)
        r.e("Keep", "Error while deleting account", new Object[] { paramContext });
    }
  }

  public static String j(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getContentResolver();
    Uri localUri = ContentUris.withAppendedId(i.a.CONTENT_URI, paramLong);
    h.a local2 = new h.a()
    {
      public String a(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        return paramAnonymousCursor.getString(0);
      }
    };
    return (String)h.a(paramContext, localUri, new String[] { "name" }, null, null, local2);
  }

  public static j k(Context paramContext, long paramLong)
  {
    paramContext = j(paramContext, paramLong);
    if (TextUtils.isEmpty(paramContext))
      return null;
    return new j(paramLong, paramContext);
  }

  public static j m(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!o(paramContext, paramString)))
      return PF;
    return b(paramContext, new Account(paramString, "com.google"));
  }

  public static Long n(Context paramContext, String paramString)
  {
    paramContext = paramContext.getContentResolver();
    Uri localUri = i.a.CONTENT_URI;
    h.a local3 = new h.a()
    {
      public Long o(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        return Long.valueOf(paramAnonymousCursor.getLong(0));
      }
    };
    return (Long)h.a(paramContext, localUri, new String[] { "_id" }, "name=?", new String[] { paramString }, local3);
  }

  public static boolean o(Context paramContext, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString)));
    while (true)
    {
      return false;
      paramContext = AccountManager.get(paramContext).getAccountsByType("com.google");
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramContext[i].name))
          return true;
        i += 1;
      }
    }
  }
}