package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator()
  {
    public BackStackState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BackStackState(paramAnonymousParcel);
    }

    public BackStackState[] newArray(int paramAnonymousInt)
    {
      return new BackStackState[paramAnonymousInt];
    }
  };
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int mIndex;
  final String mName;
  final int[] mOps;
  final ArrayList<String> mSharedElementSourceNames;
  final ArrayList<String> mSharedElementTargetNames;
  final int mTransition;
  final int mTransitionStyle;

  public BackStackState(Parcel paramParcel)
  {
    mOps = paramParcel.createIntArray();
    mTransition = paramParcel.readInt();
    mTransitionStyle = paramParcel.readInt();
    mName = paramParcel.readString();
    mIndex = paramParcel.readInt();
    mBreadCrumbTitleRes = paramParcel.readInt();
    mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    mBreadCrumbShortTitleRes = paramParcel.readInt();
    mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    mSharedElementSourceNames = paramParcel.createStringArrayList();
    mSharedElementTargetNames = paramParcel.createStringArrayList();
  }

  public BackStackState(FragmentManagerImpl paramFragmentManagerImpl, BackStackRecord paramBackStackRecord)
  {
    int i = 0;
    paramFragmentManagerImpl = paramBackStackRecord.mHead;
    int j;
    while (paramFragmentManagerImpl != null)
    {
      j = i;
      if (paramFragmentManagerImpl.removed != null)
        j = i + paramFragmentManagerImpl.removed.size();
      paramFragmentManagerImpl = paramFragmentManagerImpl.next;
      i = j;
    }
    mOps = new int[paramBackStackRecord.mNumOp * 7 + i];
    if (!paramBackStackRecord.mAddToBackStack)
      throw new IllegalStateException("Not on back stack");
    paramFragmentManagerImpl = paramBackStackRecord.mHead;
    i = 0;
    if (paramFragmentManagerImpl != null)
    {
      int[] arrayOfInt = mOps;
      j = i + 1;
      arrayOfInt[i] = paramFragmentManagerImpl.cmd;
      arrayOfInt = mOps;
      int k = j + 1;
      if (paramFragmentManagerImpl.fragment != null);
      int m;
      for (i = paramFragmentManagerImpl.fragment.mIndex; ; i = -1)
      {
        arrayOfInt[j] = i;
        arrayOfInt = mOps;
        i = k + 1;
        arrayOfInt[k] = paramFragmentManagerImpl.enterAnim;
        arrayOfInt = mOps;
        j = i + 1;
        arrayOfInt[i] = paramFragmentManagerImpl.exitAnim;
        arrayOfInt = mOps;
        i = j + 1;
        arrayOfInt[j] = paramFragmentManagerImpl.popEnterAnim;
        arrayOfInt = mOps;
        m = i + 1;
        arrayOfInt[i] = paramFragmentManagerImpl.popExitAnim;
        if (paramFragmentManagerImpl.removed == null)
          break label307;
        k = paramFragmentManagerImpl.removed.size();
        mOps[m] = k;
        j = 0;
        i = m + 1;
        while (j < k)
        {
          mOps[i] = ((Fragment)paramFragmentManagerImpl.removed.get(j)).mIndex;
          j += 1;
          i += 1;
        }
      }
      while (true)
      {
        paramFragmentManagerImpl = paramFragmentManagerImpl.next;
        break;
        label307: arrayOfInt = mOps;
        i = m + 1;
        arrayOfInt[m] = 0;
      }
    }
    mTransition = paramBackStackRecord.mTransition;
    mTransitionStyle = paramBackStackRecord.mTransitionStyle;
    mName = paramBackStackRecord.mName;
    mIndex = paramBackStackRecord.mIndex;
    mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
    mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
    mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
    mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
    mSharedElementSourceNames = paramBackStackRecord.mSharedElementSourceNames;
    mSharedElementTargetNames = paramBackStackRecord.mSharedElementTargetNames;
  }

  public int describeContents()
  {
    return 0;
  }

  public BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int i = 0;
    int k = 0;
    while (i < mOps.length)
    {
      BackStackRecord.Op localOp = new BackStackRecord.Op();
      Object localObject = mOps;
      int j = i + 1;
      localOp.cmd = localObject[i];
      if (FragmentManagerImpl.DEBUG)
        Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " op #" + k + " base fragment #" + mOps[j]);
      localObject = mOps;
      i = j + 1;
      j = localObject[j];
      if (j >= 0);
      for (localOp.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(j)); ; localOp.fragment = null)
      {
        localObject = mOps;
        j = i + 1;
        localOp.enterAnim = localObject[i];
        localObject = mOps;
        i = j + 1;
        localOp.exitAnim = localObject[j];
        localObject = mOps;
        j = i + 1;
        localOp.popEnterAnim = localObject[i];
        localObject = mOps;
        int m = j + 1;
        localOp.popExitAnim = localObject[j];
        localObject = mOps;
        i = m + 1;
        int n = localObject[m];
        j = i;
        if (n <= 0)
          break;
        localOp.removed = new ArrayList(n);
        m = 0;
        while (true)
        {
          j = i;
          if (m >= n)
            break;
          if (FragmentManagerImpl.DEBUG)
            Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " set remove fragment #" + mOps[i]);
          localObject = (Fragment)paramFragmentManagerImpl.mActive.get(mOps[i]);
          localOp.removed.add(localObject);
          m += 1;
          i += 1;
        }
      }
      i = j;
      localBackStackRecord.addOp(localOp);
      k += 1;
    }
    localBackStackRecord.mTransition = mTransition;
    localBackStackRecord.mTransitionStyle = mTransitionStyle;
    localBackStackRecord.mName = mName;
    localBackStackRecord.mIndex = mIndex;
    localBackStackRecord.mAddToBackStack = true;
    localBackStackRecord.mBreadCrumbTitleRes = mBreadCrumbTitleRes;
    localBackStackRecord.mBreadCrumbTitleText = mBreadCrumbTitleText;
    localBackStackRecord.mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
    localBackStackRecord.mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
    localBackStackRecord.mSharedElementSourceNames = mSharedElementSourceNames;
    localBackStackRecord.mSharedElementTargetNames = mSharedElementTargetNames;
    localBackStackRecord.bumpBackStackNesting(1);
    return localBackStackRecord;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(mOps);
    paramParcel.writeInt(mTransition);
    paramParcel.writeInt(mTransitionStyle);
    paramParcel.writeString(mName);
    paramParcel.writeInt(mIndex);
    paramParcel.writeInt(mBreadCrumbTitleRes);
    TextUtils.writeToParcel(mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(mBreadCrumbShortTitleText, paramParcel, 0);
    paramParcel.writeStringList(mSharedElementSourceNames);
    paramParcel.writeStringList(mSharedElementTargetNames);
  }
}