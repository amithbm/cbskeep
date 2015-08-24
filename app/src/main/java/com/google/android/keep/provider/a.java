package com.google.android.keep.provider;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.os.AsyncTask;
import com.google.android.keep.model.j;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import java.util.Iterator;
import java.util.List;

public class a
  implements OnAccountsUpdateListener
{
  private final Context BI;

  public a(Context paramContext)
  {
    BI = paramContext;
  }

  public void onAccountsUpdated(Account[] paramArrayOfAccount)
  {
    r.a("Keep", "Received onAccountsUpdated() notification", new Object[0]);
    new a(BI, paramArrayOfAccount).execute(new Void[0]);
  }

  private class a extends AsyncTask<Void, Void, Void>
  {
    private final Account[] BJ;
    private final Context mContext;

    a(Context paramArrayOfAccount, Account[] arg3)
    {
      mContext = paramArrayOfAccount;
      Object localObject;
      BJ = localObject;
    }

    private boolean a(Account[] paramArrayOfAccount, j paramj)
    {
      paramj = paramj.getName();
      int j = paramArrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        if (paramj.equalsIgnoreCase(paramArrayOfAccount[i].name))
          return false;
        i += 1;
      }
      return true;
    }

    private boolean b(List<j> paramList, Account paramAccount)
    {
      if (!o.d(paramAccount))
        return false;
      paramAccount = paramAccount.name;
      paramList = paramList.iterator();
      while (paramList.hasNext())
        if (((j)paramList.next()).getName().equalsIgnoreCase(paramAccount))
          return false;
      return true;
    }

    protected Void doInBackground(Void[] paramArrayOfVoid)
    {
      paramArrayOfVoid = o.R(mContext);
      r.a("Keep", "Memory has %s existing accounts", new Object[] { Integer.valueOf(paramArrayOfVoid.size()) });
      r.a("Keep", "System has %s accounts", new Object[] { Integer.valueOf(BJ.length) });
      Object localObject = BJ;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        Account localAccount = localObject[i];
        if (b(paramArrayOfVoid, localAccount))
          o.e(o.a(mContext, localAccount));
        i += 1;
      }
      paramArrayOfVoid = paramArrayOfVoid.iterator();
      while (paramArrayOfVoid.hasNext())
      {
        localObject = (j)paramArrayOfVoid.next();
        if (a(BJ, (j)localObject))
          o.i(mContext, (j)localObject);
      }
      return null;
    }
  }
}