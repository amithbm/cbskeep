package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import java.util.ArrayList;
import java.util.List;

class AdapterHelper
  implements OpReorderer.Callback
{
  final Callback mCallback;
  final boolean mDisableRecycler;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<UpdateOp> mPendingUpdates = new ArrayList();
  final ArrayList<UpdateOp> mPostponedList = new ArrayList();
  private Pools.Pool<UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);

  AdapterHelper(Callback paramCallback)
  {
    this(paramCallback, false);
  }

  AdapterHelper(Callback paramCallback, boolean paramBoolean)
  {
    mCallback = paramCallback;
    mDisableRecycler = paramBoolean;
    mOpReorderer = new OpReorderer(this);
  }

  private void applyAdd(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }

  private void applyMove(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }

  private void applyRemove(UpdateOp paramUpdateOp)
  {
    int i2 = paramUpdateOp.positionStart;
    int n = 0;
    int m = paramUpdateOp.positionStart + paramUpdateOp.itemCount;
    int i1 = -1;
    int i = paramUpdateOp.positionStart;
    if (i < m)
    {
      int k = 0;
      int j = 0;
      if ((mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
      {
        if (i1 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(1, i2, n));
          j = 1;
        }
        i1 = 1;
        k = j;
        j = i1;
        label89: if (k == 0)
          break label150;
        i -= n;
        m -= n;
      }
      label150: for (k = 1; ; k = n + 1)
      {
        i += 1;
        n = k;
        i1 = j;
        break;
        if (i1 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(1, i2, n));
          k = 1;
        }
        j = 0;
        break label89;
      }
    }
    UpdateOp localUpdateOp = paramUpdateOp;
    if (n != paramUpdateOp.itemCount)
    {
      recycleUpdateOp(paramUpdateOp);
      localUpdateOp = obtainUpdateOp(1, i2, n);
    }
    if (i1 == 0)
    {
      dispatchAndUpdateViewHolders(localUpdateOp);
      return;
    }
    postponeAndUpdateViewHolders(localUpdateOp);
  }

  private void applyUpdate(UpdateOp paramUpdateOp)
  {
    int k = paramUpdateOp.positionStart;
    int j = 0;
    int i3 = paramUpdateOp.positionStart;
    int i4 = paramUpdateOp.itemCount;
    int i2 = -1;
    int i = paramUpdateOp.positionStart;
    if (i < i3 + i4)
    {
      int n;
      int m;
      if ((mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
      {
        n = j;
        int i1 = k;
        if (i2 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(2, k, j));
          n = 0;
          i1 = i;
        }
        m = 1;
        k = i1;
      }
      while (true)
      {
        j = n + 1;
        i += 1;
        i2 = m;
        break;
        n = j;
        m = k;
        if (i2 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(2, k, j));
          n = 0;
          m = i;
        }
        j = 0;
        k = m;
        m = j;
      }
    }
    UpdateOp localUpdateOp = paramUpdateOp;
    if (j != paramUpdateOp.itemCount)
    {
      recycleUpdateOp(paramUpdateOp);
      localUpdateOp = obtainUpdateOp(2, k, j);
    }
    if (i2 == 0)
    {
      dispatchAndUpdateViewHolders(localUpdateOp);
      return;
    }
    postponeAndUpdateViewHolders(localUpdateOp);
  }

  private boolean canFindInPreLayout(int paramInt)
  {
    int k = mPostponedList.size();
    int i = 0;
    while (i < k)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPostponedList.get(i);
      if (localUpdateOp.cmd == 3)
      {
        if (findPositionOffset(localUpdateOp.itemCount, i + 1) == paramInt)
          return true;
      }
      else if (localUpdateOp.cmd == 0)
      {
        int m = localUpdateOp.positionStart;
        int n = localUpdateOp.itemCount;
        int j = localUpdateOp.positionStart;
        while (true)
        {
          if (j >= m + n)
            break label113;
          if (findPositionOffset(j, i + 1) == paramInt)
            break;
          j += 1;
        }
      }
      label113: i += 1;
    }
    return false;
  }

  private void dispatchAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    if ((paramUpdateOp.cmd == 0) || (paramUpdateOp.cmd == 3))
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    int i1 = updatePositionWithPostponed(paramUpdateOp.positionStart, paramUpdateOp.cmd);
    int n = 1;
    int i = paramUpdateOp.positionStart;
    int k;
    int m;
    label105: int i2;
    switch (paramUpdateOp.cmd)
    {
    default:
      throw new IllegalArgumentException("op should be remove or update." + paramUpdateOp);
    case 2:
      k = 1;
      m = 1;
      if (m >= paramUpdateOp.itemCount)
        break label284;
      i2 = updatePositionWithPostponed(paramUpdateOp.positionStart + k * m, paramUpdateOp.cmd);
      j = 0;
      switch (paramUpdateOp.cmd)
      {
      default:
        if (j == 0);
        break;
      case 2:
      case 1:
      }
      break;
    case 1:
    }
    for (int j = n + 1; ; j = n)
    {
      m += 1;
      n = j;
      break label105;
      k = 0;
      break;
      if (i2 == i1 + 1);
      for (j = 1; ; j = 0)
        break;
      if (i2 == i1);
      for (j = 1; ; j = 0)
        break;
      UpdateOp localUpdateOp = obtainUpdateOp(paramUpdateOp.cmd, i1, n);
      dispatchFirstPassAndUpdateViewHolders(localUpdateOp, i);
      recycleUpdateOp(localUpdateOp);
      j = i;
      if (paramUpdateOp.cmd == 2)
        j = i + n;
      i1 = i2;
      n = 1;
      i = j;
    }
    label284: recycleUpdateOp(paramUpdateOp);
    if (n > 0)
    {
      paramUpdateOp = obtainUpdateOp(paramUpdateOp.cmd, i1, n);
      dispatchFirstPassAndUpdateViewHolders(paramUpdateOp, i);
      recycleUpdateOp(paramUpdateOp);
    }
  }

  private void postponeAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    mPostponedList.add(paramUpdateOp);
    switch (paramUpdateOp.cmd)
    {
    default:
      throw new IllegalArgumentException("Unknown update op type for " + paramUpdateOp);
    case 0:
      mCallback.offsetPositionsForAdd(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 3:
      mCallback.offsetPositionsForMove(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 1:
      mCallback.offsetPositionsForRemovingLaidOutOrNewView(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 2:
    }
    mCallback.markViewHoldersUpdated(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
  }

  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int i = mPostponedList.size() - 1;
    int j = paramInt1;
    UpdateOp localUpdateOp;
    if (i >= 0)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(i);
      int k;
      if (localUpdateOp.cmd == 3)
        if (localUpdateOp.positionStart < localUpdateOp.itemCount)
        {
          k = localUpdateOp.positionStart;
          paramInt1 = localUpdateOp.itemCount;
          label65: if ((j < k) || (j > paramInt1))
            break label199;
          if (k != localUpdateOp.positionStart)
            break label155;
          if (paramInt2 != 0)
            break label135;
          localUpdateOp.itemCount += 1;
          label104: paramInt1 = j + 1;
        }
      while (true)
      {
        i -= 1;
        j = paramInt1;
        break;
        k = localUpdateOp.itemCount;
        paramInt1 = localUpdateOp.positionStart;
        break label65;
        label135: if (paramInt2 != 1)
          break label104;
        localUpdateOp.itemCount -= 1;
        break label104;
        label155: if (paramInt2 == 0)
          localUpdateOp.positionStart += 1;
        while (true)
        {
          paramInt1 = j - 1;
          break;
          if (paramInt2 == 1)
            localUpdateOp.positionStart -= 1;
        }
        label199: paramInt1 = j;
        if (j < localUpdateOp.positionStart)
          if (paramInt2 == 0)
          {
            localUpdateOp.positionStart += 1;
            localUpdateOp.itemCount += 1;
            paramInt1 = j;
          }
          else
          {
            paramInt1 = j;
            if (paramInt2 == 1)
            {
              localUpdateOp.positionStart -= 1;
              localUpdateOp.itemCount -= 1;
              paramInt1 = j;
              continue;
              if (localUpdateOp.positionStart <= j)
              {
                if (localUpdateOp.cmd == 0)
                {
                  paramInt1 = j - localUpdateOp.itemCount;
                }
                else
                {
                  paramInt1 = j;
                  if (localUpdateOp.cmd == 1)
                    paramInt1 = j + localUpdateOp.itemCount;
                }
              }
              else if (paramInt2 == 0)
              {
                localUpdateOp.positionStart += 1;
                paramInt1 = j;
              }
              else
              {
                paramInt1 = j;
                if (paramInt2 == 1)
                {
                  localUpdateOp.positionStart -= 1;
                  paramInt1 = j;
                }
              }
            }
          }
      }
    }
    paramInt1 = mPostponedList.size() - 1;
    if (paramInt1 >= 0)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(paramInt1);
      if (localUpdateOp.cmd == 3)
        if ((localUpdateOp.itemCount == localUpdateOp.positionStart) || (localUpdateOp.itemCount < 0))
        {
          mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      while (true)
      {
        paramInt1 -= 1;
        break;
        if (localUpdateOp.itemCount <= 0)
        {
          mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
    }
    return j;
  }

  public int applyPendingUpdatesToPosition(int paramInt)
  {
    int m = mPendingUpdates.size();
    int k = 0;
    int i = paramInt;
    paramInt = i;
    UpdateOp localUpdateOp;
    if (k < m)
    {
      localUpdateOp = (UpdateOp)mPendingUpdates.get(k);
      paramInt = i;
      switch (localUpdateOp.cmd)
      {
      default:
        paramInt = i;
      case 2:
      case 0:
      case 1:
      case 3:
      }
    }
    while (true)
    {
      k += 1;
      i = paramInt;
      break;
      paramInt = i;
      if (localUpdateOp.positionStart <= i)
      {
        paramInt = i + localUpdateOp.itemCount;
        continue;
        paramInt = i;
        if (localUpdateOp.positionStart <= i)
        {
          if (localUpdateOp.positionStart + localUpdateOp.itemCount > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - localUpdateOp.itemCount;
          continue;
          if (localUpdateOp.positionStart == i)
          {
            paramInt = localUpdateOp.itemCount;
          }
          else
          {
            int j = i;
            if (localUpdateOp.positionStart < i)
              j = i - 1;
            paramInt = j;
            if (localUpdateOp.itemCount <= j)
              paramInt = j + 1;
          }
        }
      }
    }
  }

  void consumePostponedUpdates()
  {
    int j = mPostponedList.size();
    int i = 0;
    while (i < j)
    {
      mCallback.onDispatchSecondPass((UpdateOp)mPostponedList.get(i));
      i += 1;
    }
    recycleUpdateOpsAndClearList(mPostponedList);
  }

  void consumeUpdatesInOnePass()
  {
    consumePostponedUpdates();
    int j = mPendingUpdates.size();
    int i = 0;
    if (i < j)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPendingUpdates.get(i);
      switch (localUpdateOp.cmd)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        if (mOnItemProcessedCallback != null)
          mOnItemProcessedCallback.run();
        i += 1;
        break;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForAdd(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForRemovingInvisible(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.markViewHoldersUpdated(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForMove(localUpdateOp.positionStart, localUpdateOp.itemCount);
      }
    }
    recycleUpdateOpsAndClearList(mPendingUpdates);
  }

  void dispatchFirstPassAndUpdateViewHolders(UpdateOp paramUpdateOp, int paramInt)
  {
    mCallback.onDispatchFirstPass(paramUpdateOp);
    switch (paramUpdateOp.cmd)
    {
    default:
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 1:
      mCallback.offsetPositionsForRemovingInvisible(paramInt, paramUpdateOp.itemCount);
      return;
    case 2:
    }
    mCallback.markViewHoldersUpdated(paramInt, paramUpdateOp.itemCount);
  }

  int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }

  int findPositionOffset(int paramInt1, int paramInt2)
  {
    int k = mPostponedList.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    UpdateOp localUpdateOp;
    if (j < k)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(j);
      if (localUpdateOp.cmd == 3)
        if (localUpdateOp.positionStart == paramInt2)
          paramInt1 = localUpdateOp.itemCount;
    }
    while (true)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localUpdateOp.positionStart < paramInt2)
        i = paramInt2 - 1;
      paramInt1 = i;
      if (localUpdateOp.itemCount <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localUpdateOp.positionStart <= paramInt2)
          if (localUpdateOp.cmd == 1)
          {
            if (paramInt2 < localUpdateOp.positionStart + localUpdateOp.itemCount)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localUpdateOp.itemCount;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localUpdateOp.cmd == 0)
              paramInt1 = paramInt2 + localUpdateOp.itemCount;
          }
      }
    }
  }

  boolean hasPendingUpdates()
  {
    return mPendingUpdates.size() > 0;
  }

  public UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3)
  {
    UpdateOp localUpdateOp = (UpdateOp)mUpdateOpPool.acquire();
    if (localUpdateOp == null)
      return new UpdateOp(paramInt1, paramInt2, paramInt3);
    localUpdateOp.cmd = paramInt1;
    localUpdateOp.positionStart = paramInt2;
    localUpdateOp.itemCount = paramInt3;
    return localUpdateOp;
  }

  boolean onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if (paramInt1 == paramInt2)
      return false;
    if (paramInt3 != 1)
      throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    mPendingUpdates.add(obtainUpdateOp(3, paramInt1, paramInt2));
    if (mPendingUpdates.size() == 1);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  void preProcess()
  {
    mOpReorderer.reorderOps(mPendingUpdates);
    int j = mPendingUpdates.size();
    int i = 0;
    if (i < j)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPendingUpdates.get(i);
      switch (localUpdateOp.cmd)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        if (mOnItemProcessedCallback != null)
          mOnItemProcessedCallback.run();
        i += 1;
        break;
        applyAdd(localUpdateOp);
        continue;
        applyRemove(localUpdateOp);
        continue;
        applyUpdate(localUpdateOp);
        continue;
        applyMove(localUpdateOp);
      }
    }
    mPendingUpdates.clear();
  }

  public void recycleUpdateOp(UpdateOp paramUpdateOp)
  {
    if (!mDisableRecycler)
      mUpdateOpPool.release(paramUpdateOp);
  }

  void recycleUpdateOpsAndClearList(List<UpdateOp> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      recycleUpdateOp((UpdateOp)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }

  void reset()
  {
    recycleUpdateOpsAndClearList(mPendingUpdates);
    recycleUpdateOpsAndClearList(mPostponedList);
  }

  static abstract interface Callback
  {
    public abstract RecyclerView.ViewHolder findViewHolder(int paramInt);

    public abstract void markViewHoldersUpdated(int paramInt1, int paramInt2);

    public abstract void offsetPositionsForAdd(int paramInt1, int paramInt2);

    public abstract void offsetPositionsForMove(int paramInt1, int paramInt2);

    public abstract void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2);

    public abstract void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2);

    public abstract void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp);

    public abstract void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp);
  }

  static class UpdateOp
  {
    int cmd;
    int itemCount;
    int positionStart;

    UpdateOp(int paramInt1, int paramInt2, int paramInt3)
    {
      cmd = paramInt1;
      positionStart = paramInt2;
      itemCount = paramInt3;
    }

    String cmdToString()
    {
      switch (cmd)
      {
      default:
        return "??";
      case 0:
        return "add";
      case 1:
        return "rm";
      case 2:
        return "up";
      case 3:
      }
      return "mv";
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass()))
            return false;
          paramObject = (UpdateOp)paramObject;
          if (cmd != paramObject.cmd)
            return false;
        }
        while ((cmd == 3) && (Math.abs(itemCount - positionStart) == 1) && (itemCount == paramObject.positionStart) && (positionStart == paramObject.itemCount));
        if (itemCount != paramObject.itemCount)
          return false;
      }
      while (positionStart == paramObject.positionStart);
      return false;
    }

    public int hashCode()
    {
      return (cmd * 31 + positionStart) * 31 + itemCount;
    }

    public String toString()
    {
      return "[" + cmdToString() + ",s:" + positionStart + "c:" + itemCount + "]";
    }
  }
}