package com.google.android.gms.people.accountswitcherview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.people.model.Owner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OwnersListAdapter extends BaseAdapter
{
  private static final int DEFAULT_ACCOUNT_LIST_LAYOUT = R.layout.account_item_view;
  private int mAccountDetailsColor;
  private AccountOrderingHelper mAccountOrderingHelper;
  private OwnersAvatarManager mAvatarLoader;
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private int mLayoutRes;
  private ArrayList<Owner> mOwners = new ArrayList();
  private String mSelectedOwner;
  private boolean mShowAddAccount = true;
  private boolean mShowManageAccounts = true;
  private boolean mUseCustomOrdering;
  private ViewDecorator mViewDecorator;
  private ViewHolderItemCreator mViewHolderItemCreator;

  public OwnersListAdapter(Context paramContext)
  {
    this(paramContext, R.layout.account_item_view, null, null);
  }

  public OwnersListAdapter(Context paramContext, int paramInt, ViewHolderItemCreator paramViewHolderItemCreator, ViewDecorator paramViewDecorator)
  {
    mContext = paramContext;
    if (paramInt != -1)
    {
      mLayoutRes = paramInt;
      mLayoutInflater = LayoutInflater.from(paramContext);
      if (paramViewHolderItemCreator == null)
        break label132;
    }
    while (true)
    {
      mViewHolderItemCreator = paramViewHolderItemCreator;
      mViewDecorator = paramViewDecorator;
      paramInt = R.attr.accountDetailsTextColor;
      paramViewHolderItemCreator = paramContext.obtainStyledAttributes(new TypedValue().data, new int[] { paramInt });
      mAccountDetailsColor = paramViewHolderItemCreator.getColor(0, paramContext.getResources().getColor(R.color.default_account_details_color));
      paramViewHolderItemCreator.recycle();
      mAccountOrderingHelper = new AccountOrderingHelper(paramContext);
      return;
      paramInt = DEFAULT_ACCOUNT_LIST_LAYOUT;
      break;
      label132: paramViewHolderItemCreator = new DefaultViewHolderItemCreator(null);
    }
  }

  private int getAddAccountsOffset()
  {
    if (mShowManageAccounts)
      return -2;
    return -1;
  }

  private boolean isAddAccountsPosition(int paramInt)
  {
    int i = getAddAccountsOffset();
    return (mShowAddAccount) && (paramInt == getCount() + i);
  }

  private boolean isManageAccountsPosition(int paramInt)
  {
    return (mShowManageAccounts) && (paramInt == getCount() - 1);
  }

  public static List<Owner> removeSelectedAccount(List<Owner> paramList, Owner paramOwner1, Owner paramOwner2)
  {
    String str = null;
    int m = -1;
    int j = -1;
    if (paramOwner2 != null);
    for (paramOwner2 = paramOwner2.getAccountName(); ; paramOwner2 = null)
    {
      if (paramOwner1 != null)
        str = paramOwner1.getAccountName();
      int i = 0;
      while (i < paramList.size())
      {
        Owner localOwner = (Owner)paramList.get(i);
        int k = m;
        if (m < 0)
        {
          k = m;
          if (localOwner.getAccountName().equals(paramOwner2))
            k = i;
        }
        m = j;
        if (j < 0)
        {
          m = j;
          if (localOwner.getAccountName().equals(str))
            m = i;
        }
        i += 1;
        j = m;
        m = k;
      }
    }
    if (m >= 0)
      paramList.remove(m);
    if ((j < 0) && (str != null) && (!str.equals(paramOwner2)))
      paramList.add(paramOwner1);
    return paramList;
  }

  public View bindView(View paramView, Owner paramOwner, OwnersAvatarManager paramOwnersAvatarManager, ViewHolderItemCreator paramViewHolderItemCreator, ViewDecorator paramViewDecorator, boolean paramBoolean, int paramInt)
  {
    if (paramView.getTag() == null)
    {
      paramViewHolderItemCreator = paramViewHolderItemCreator.createViewHolderItem(paramView, paramBoolean);
      paramView.setTag(paramViewHolderItemCreator);
      if ((paramViewHolderItemCreator.avatar != null) && (paramOwnersAvatarManager != null))
      {
        paramViewHolderItemCreator.avatar.setImageDrawable(null);
        if (TextUtils.isEmpty(paramOwner.getAvatarUrl()))
          break label186;
        paramOwnersAvatarManager.removePendingRequest(paramViewHolderItemCreator.avatar);
        paramOwnersAvatarManager.loadOwnerAvatar(paramViewHolderItemCreator.avatar, paramOwner, 1);
      }
    }
    while (true)
    {
      if (paramViewHolderItemCreator.address != null)
      {
        paramViewHolderItemCreator.address.setTextColor(paramInt);
        paramViewHolderItemCreator.address.setVisibility(0);
        paramViewHolderItemCreator.address.setText(paramOwner.getAccountName());
        paramViewHolderItemCreator.address.setContentDescription(mContext.getResources().getString(R.string.account_item, new Object[] { paramOwner.getAccountName() }));
      }
      if (paramViewDecorator != null)
        paramViewDecorator.decorateView(paramViewHolderItemCreator, paramOwner, paramBoolean, paramInt);
      return paramView;
      paramViewHolderItemCreator = (ViewHolderItem)paramView.getTag();
      break;
      label186: paramOwnersAvatarManager.removePendingRequest(paramViewHolderItemCreator.avatar);
      paramViewHolderItemCreator.avatar.setImageBitmap(paramOwnersAvatarManager.getPlaceholder(paramView.getContext(), paramOwner, 1));
    }
  }

  public void disconnect()
  {
    if (mAccountOrderingHelper != null)
      mAccountOrderingHelper.detach();
  }

  public int getCount()
  {
    int j = 1;
    int k = 0;
    int i;
    if (mShowManageAccounts)
    {
      i = 1;
      if (!mShowAddAccount)
        break label46;
    }
    while (true)
    {
      if (mOwners != null)
        k = mOwners.size();
      return i + j + k;
      i = 0;
      break;
      label46: j = 0;
    }
  }

  public Owner getItem(int paramInt)
  {
    if ((isAddAccountsPosition(paramInt)) || (isManageAccountsPosition(paramInt)));
    while (mOwners == null)
      return null;
    return (Owner)mOwners.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    long l2 = -1L;
    getAddAccountsOffset();
    long l1;
    if (isManageAccountsPosition(paramInt))
      l1 = -2L;
    do
    {
      do
      {
        return l1;
        l1 = l2;
      }
      while (isAddAccountsPosition(paramInt));
      l1 = l2;
    }
    while (mOwners == null);
    return ((Owner)mOwners.get(paramInt)).getAccountName().hashCode();
  }

  public int getItemViewType(int paramInt)
  {
    if (isManageAccountsPosition(paramInt))
      return 2;
    if (isAddAccountsPosition(paramInt))
      return 1;
    return 0;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    if (getItemViewType(paramInt) == 2)
    {
      paramViewGroup = paramView;
      if (paramView == null)
        paramViewGroup = mLayoutInflater.inflate(R.layout.manage_accounts, null);
    }
    do
    {
      return paramViewGroup;
      if (getItemViewType(paramInt) != 1)
        break;
      paramViewGroup = paramView;
    }
    while (paramView != null);
    return mLayoutInflater.inflate(R.layout.add_account, null);
    paramViewGroup = paramView;
    if (paramView == null)
      paramViewGroup = mLayoutInflater.inflate(mLayoutRes, null);
    paramView = getItem(paramInt);
    OwnersAvatarManager localOwnersAvatarManager = mAvatarLoader;
    ViewHolderItemCreator localViewHolderItemCreator = mViewHolderItemCreator;
    ViewDecorator localViewDecorator = mViewDecorator;
    if ((mSelectedOwner != null) && (mSelectedOwner.equals(paramView.getAccountName())));
    while (true)
    {
      return bindView(paramViewGroup, paramView, localOwnersAvatarManager, localViewHolderItemCreator, localViewDecorator, bool, mAccountDetailsColor);
      bool = false;
    }
  }

  public int getViewTypeCount()
  {
    return 3;
  }

  public void setAvatarManager(OwnersAvatarManager paramOwnersAvatarManager)
  {
    mAvatarLoader = paramOwnersAvatarManager;
  }

  public void setBuffer(List<Owner> paramList)
  {
    if (mUseCustomOrdering)
    {
      mOwners.clear();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Owner localOwner = (Owner)paramList.next();
          mOwners.add(localOwner);
        }
      }
      notifyDataSetChanged();
    }
    while (true)
    {
      notifyDataSetChanged();
      return;
      mOwners = mAccountOrderingHelper.orderAccounts(paramList);
    }
  }

  public void setOwners(List<Owner> paramList)
  {
    setBuffer(paramList);
  }

  public void setSelectedOwner(Owner paramOwner)
  {
    if (paramOwner != null);
    for (paramOwner = paramOwner.getAccountName(); ; paramOwner = null)
    {
      setSelectedOwner(paramOwner);
      return;
    }
  }

  public void setSelectedOwner(String paramString)
  {
    mSelectedOwner = paramString;
    notifyDataSetChanged();
  }

  private class DefaultViewHolderItemCreator
    implements OwnersListAdapter.ViewHolderItemCreator
  {
    private DefaultViewHolderItemCreator()
    {
    }

    public OwnersListAdapter.ViewHolderItem createViewHolderItem(View paramView, boolean paramBoolean)
    {
      OwnersListAdapter.ViewHolderItem localViewHolderItem = new OwnersListAdapter.ViewHolderItem();
      localViewHolderItem.avatar = ((ImageView)paramView.findViewById(R.id.avatar));
      localViewHolderItem.address = ((TextView)paramView.findViewById(R.id.account_address));
      return localViewHolderItem;
    }
  }

  public static abstract interface ViewDecorator
  {
    public abstract void decorateView(OwnersListAdapter.ViewHolderItem paramViewHolderItem, Owner paramOwner, boolean paramBoolean, int paramInt);
  }

  public static class ViewHolderItem
  {
    public TextView address;
    public ImageView avatar;
  }

  public static abstract interface ViewHolderItemCreator
  {
    public abstract OwnersListAdapter.ViewHolderItem createViewHolderItem(View paramView, boolean paramBoolean);
  }
}