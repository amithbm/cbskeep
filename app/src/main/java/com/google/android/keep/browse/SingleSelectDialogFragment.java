package com.google.android.keep.browse;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class SingleSelectDialogFragment extends DialogFragment
{
  private static final String NAME = SingleSelectDialogFragment.class.getSimpleName();
  private static final String iP = NAME + "_requestCode";
  private static final String iQ = NAME + "_title";
  private static final String iR = NAME + "_options";
  private static final String iS = NAME + "_rowLayout";
  private static final String iT = NAME + "_textResId";
  private static final String iU = NAME + "_iconResId";
  private int iV;

  private void setResult(int paramInt)
  {
    b localb = null;
    if ((getTargetFragment() instanceof b))
      localb = (b)getTargetFragment();
    while (localb == null)
    {
      return;
      if ((getActivity() instanceof b))
        localb = (b)getActivity();
    }
    if (paramInt == -1)
    {
      localb.s(iV);
      return;
    }
    localb.g(iV, paramInt);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    setResult(-1);
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    iV = paramBundle.getInt(iP);
    c localc = new c(getActivity(), paramBundle.getInt(iS), paramBundle.getInt(iT), paramBundle.getInt(iU), OptionItem.a(paramBundle.getParcelableArray(iR)));
    return new AlertDialog.Builder(getActivity()).setTitle(paramBundle.getString(iQ)).setAdapter(localc, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        SingleSelectDialogFragment.a(SingleSelectDialogFragment.this, paramAnonymousInt);
      }
    }).create();
  }

  public static class OptionItem
    implements Parcelable
  {
    public static final Parcelable.Creator<OptionItem> CREATOR = new Parcelable.Creator()
    {
      public SingleSelectDialogFragment.OptionItem a(Parcel paramAnonymousParcel)
      {
        return new SingleSelectDialogFragment.OptionItem(paramAnonymousParcel, null);
      }

      public SingleSelectDialogFragment.OptionItem[] ab(int paramAnonymousInt)
      {
        return new SingleSelectDialogFragment.OptionItem[paramAnonymousInt];
      }
    };
    public final int icon;
    public final String text;

    private OptionItem(Parcel paramParcel)
    {
      text = paramParcel.readString();
      icon = paramParcel.readInt();
    }

    public OptionItem(String paramString, int paramInt)
    {
      text = paramString;
      icon = paramInt;
    }

    public static OptionItem[] a(Parcelable[] paramArrayOfParcelable)
    {
      Object localObject;
      if (paramArrayOfParcelable == null)
      {
        localObject = new OptionItem[0];
        return localObject;
      }
      OptionItem[] arrayOfOptionItem = new OptionItem[paramArrayOfParcelable.length];
      int i = 0;
      while (true)
      {
        localObject = arrayOfOptionItem;
        if (i >= paramArrayOfParcelable.length)
          break;
        arrayOfOptionItem[i] = ((OptionItem)paramArrayOfParcelable[i]);
        i += 1;
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return text;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(text);
      paramParcel.writeInt(icon);
    }
  }

  public static class a
  {
    private final int iV;
    private final boolean iX;
    private final Fragment iY;
    private final FragmentActivity iZ;
    private String ja;
    private SingleSelectDialogFragment.OptionItem[] jb;
    private int jc;
    private int jd;
    private String mTag;
    private int mTextResourceId;

    public a(Fragment paramFragment, int paramInt)
    {
      iX = true;
      iY = paramFragment;
      iZ = null;
      iV = paramInt;
      initialize();
    }

    public a(FragmentActivity paramFragmentActivity, int paramInt)
    {
      iX = false;
      iY = null;
      iZ = paramFragmentActivity;
      iV = paramInt;
      initialize();
    }

    private void initialize()
    {
      mTag = SingleSelectDialogFragment.W();
      jc = 2130968656;
      mTextResourceId = 2131493145;
      jd = -1;
    }

    public a Y(int paramInt)
    {
      jc = paramInt;
      return this;
    }

    public a Z(int paramInt)
    {
      mTextResourceId = paramInt;
      return this;
    }

    public a a(SingleSelectDialogFragment.OptionItem[] paramArrayOfOptionItem)
    {
      if ((paramArrayOfOptionItem == null) || (paramArrayOfOptionItem.length == 0))
        throw new IllegalArgumentException("Options could not be empty");
      jb = paramArrayOfOptionItem;
      return this;
    }

    public a a(String[] paramArrayOfString)
    {
      if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
        throw new IllegalArgumentException("Options could not be empty");
      jb = new SingleSelectDialogFragment.OptionItem[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        jb[i] = new SingleSelectDialogFragment.OptionItem(paramArrayOfString[i], -1);
        i += 1;
      }
      return this;
    }

    public a aa(int paramInt)
    {
      jd = paramInt;
      return this;
    }

    public a o(String paramString)
    {
      ja = paramString;
      return this;
    }

    public void show()
    {
      if (iX)
        if ((iY != null) && (iY.isAdded()))
          break label42;
      label42: 
      while ((jb == null) || (jb.length == 0))
        do
          return;
        while ((iZ == null) || (iZ.isFinishing()));
      SingleSelectDialogFragment localSingleSelectDialogFragment = new SingleSelectDialogFragment();
      if (iX)
        localSingleSelectDialogFragment.setTargetFragment(iY, iV);
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt(SingleSelectDialogFragment.cE(), iV);
      ((Bundle)localObject).putString(SingleSelectDialogFragment.iQ, ja);
      ((Bundle)localObject).putParcelableArray(SingleSelectDialogFragment.cF(), jb);
      ((Bundle)localObject).putInt(SingleSelectDialogFragment.cb(), jc);
      ((Bundle)localObject).putInt(SingleSelectDialogFragment.cG(), mTextResourceId);
      ((Bundle)localObject).putInt(SingleSelectDialogFragment.cH(), jd);
      localSingleSelectDialogFragment.setArguments((Bundle)localObject);
      if (iX);
      for (localObject = iY.getFragmentManager(); ; localObject = iZ.getSupportFragmentManager())
      {
        localObject = ((FragmentManager)localObject).beginTransaction();
        ((FragmentTransaction)localObject).add(localSingleSelectDialogFragment, mTag);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
        return;
      }
    }
  }

  public static abstract interface b
  {
    public abstract void g(int paramInt1, int paramInt2);

    public abstract void s(int paramInt);
  }

  private class c extends ArrayAdapter<SingleSelectDialogFragment.OptionItem>
  {
    private final int je;

    c(Context paramInt1, int paramInt2, int paramInt3, int paramArrayOfOptionItem, SingleSelectDialogFragment.OptionItem[] arg6)
    {
      super(paramInt2, paramInt3, arrayOfObject);
      je = paramArrayOfOptionItem;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      paramViewGroup = (SingleSelectDialogFragment.OptionItem)getItem(paramInt);
      if ((je != -1) && (paramViewGroup.icon != -1))
        ((ImageView)paramView.findViewById(je)).setImageResource(paramViewGroup.icon);
      return paramView;
    }
  }
}