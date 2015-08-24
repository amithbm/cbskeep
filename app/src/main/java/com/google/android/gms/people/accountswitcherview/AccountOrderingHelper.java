package com.google.android.gms.people.accountswitcherview;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.google.android.gms.people.model.Owner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AccountOrderingHelper
{
  private AccountManager mAccountManager;
  private Account[] mAccountOrder;
  private Context mContext;
  private ArrayList<Owner> mOwners;
  private HashMap<String, Owner> mOwnersMap;

  public AccountOrderingHelper(Context paramContext)
  {
    mContext = paramContext;
    mOwnersMap = new HashMap();
    mOwners = new ArrayList();
  }

  private void attach()
  {
    if (mAccountManager == null)
      mAccountManager = AccountManager.get(mContext);
    mAccountOrder = mAccountManager.getAccountsByType("com.google");
  }

  private void populateAccountsMap(Iterable<Owner> paramIterable)
  {
    mOwnersMap.clear();
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Owner localOwner = (Owner)paramIterable.next();
        mOwnersMap.put(localOwner.getAccountName(), localOwner);
      }
    }
  }

  void detach()
  {
    mOwnersMap.clear();
    mOwners.clear();
  }

  public ArrayList<Owner> orderAccounts(List<Owner> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      detach();
    while (true)
    {
      return mOwners;
      attach();
      populateAccountsMap(paramList);
      if (mOwnersMap.isEmpty())
      {
        detach();
      }
      else
      {
        mOwners.clear();
        paramList = mAccountOrder;
        int j = paramList.length;
        int i = 0;
        while (i < j)
        {
          Owner localOwner = paramList[i];
          localOwner = (Owner)mOwnersMap.get(localOwner.name);
          if (localOwner != null)
            mOwners.add(localOwner);
          i += 1;
        }
      }
    }
  }
}