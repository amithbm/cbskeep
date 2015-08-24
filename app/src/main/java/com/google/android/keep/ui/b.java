package com.google.android.keep.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;

public class b extends DialogFragment
{
  private static final String Id = NAME + "_message";
  private static final String Ie = NAME + "_titleId";
  private static final String If = NAME + "_viewResourceId";
  private static final String Ig = NAME + "_positiveTextId";
  private static final String Ih = NAME + "_negativeTextId";
  private static final String Ii = NAME + "_neutralTextId";
  private static final String Ij = NAME + "_parcelable";
  private static final String Ik = NAME + "_displayOptions";
  private static final String NAME = b.class.getSimpleName();
  private static final String iP = NAME + "_requestCode";
  private int iV;

  private void b(int paramInt, Parcelable paramParcelable)
  {
    b localb = null;
    if ((getTargetFragment() instanceof b))
      localb = (b)getTargetFragment();
    while (true)
    {
      if (localb != null)
        localb.a(iV, paramInt, paramParcelable);
      return;
      if ((getActivity() instanceof b))
        localb = (b)getActivity();
    }
  }

  protected void a(AlertDialog.Builder paramBuilder, Bundle paramBundle)
  {
    int i = paramBundle.getInt(If, 0);
    if (i != 0)
    {
      paramBuilder.setView(getActivity().getLayoutInflater().inflate(i, null));
      return;
    }
    paramBuilder.setMessage(paramBundle.getString(Id, ""));
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    iV = paramBundle.getInt(iP);
    int i = paramBundle.getInt(Ie, 0);
    int j = paramBundle.getInt(Ig, 0);
    int k = paramBundle.getInt(Ih, 0);
    int m = paramBundle.getInt(Ii, 0);
    int n = paramBundle.getInt(Ik);
    final Parcelable localParcelable = paramBundle.getParcelable(Ij);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    if (i != 0)
      localBuilder.setTitle(i);
    a(localBuilder, paramBundle);
    if ((n & 0x1) == 1)
      localBuilder.setPositiveButton(j, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          b.a(b.this, 1, localParcelable);
          paramAnonymousDialogInterface.dismiss();
        }
      });
    if ((n & 0x2) == 2)
      localBuilder.setNegativeButton(k, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          b.a(b.this, 2, localParcelable);
          paramAnonymousDialogInterface.dismiss();
        }
      });
    if ((n & 0x4) == 4)
      localBuilder.setNeutralButton(m, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          b.a(b.this, 4, localParcelable);
          paramAnonymousDialogInterface.dismiss();
        }
      });
    return localBuilder.create();
  }

  public static class a<T extends a>
  {
    private int In;
    private String Io;
    private int Ip;
    private int Iq;
    private int Ir;
    private int Is;
    private int It;
    private Parcelable Iu;
    private final int iV;
    private final boolean iX;
    private final Fragment iY;
    private final FragmentActivity iZ;
    private String mTag;

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
      if (iX);
      for (String str = iY.getClass().getSimpleName() + " " + iV; ; str = iZ.getClass().getSimpleName() + " " + iV)
      {
        mTag = str;
        In = 0;
        Ip = 0;
        Iq = 17039370;
        Ir = 17039360;
        Is = 17039369;
        It = 3;
        Iu = Bundle.EMPTY;
        return;
      }
    }

    public T a(Parcelable paramParcelable)
    {
      Iu = paramParcelable;
      return this;
    }

    public T bN(int paramInt)
    {
      In = paramInt;
      return this;
    }

    public T bO(int paramInt)
    {
      if (iX);
      for (String str = iY.getString(paramInt); ; str = iZ.getString(paramInt))
      {
        Io = str;
        return this;
      }
    }

    public T bP(int paramInt)
    {
      Iq = paramInt;
      return this;
    }

    public T bQ(int paramInt)
    {
      Ir = paramInt;
      return this;
    }

    public T bR(int paramInt)
    {
      It = paramInt;
      return this;
    }

    public T bi(String paramString)
    {
      Io = paramString;
      return this;
    }

    protected Bundle getArguments()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(b.W(), iV);
      localBundle.putString(b.cE(), Io);
      localBundle.putInt(b.Ie, In);
      localBundle.putInt(b.cF(), Ip);
      localBundle.putInt(b.cb(), Iq);
      localBundle.putInt(b.cG(), Ir);
      localBundle.putInt(b.cH(), Is);
      localBundle.putInt(b.lU(), It);
      localBundle.putParcelable(b.lV(), Iu);
      return localBundle;
    }

    protected b lW()
    {
      return new b();
    }

    public void show()
    {
      if (iX)
      {
        if ((iY != null) && (iY.isAdded()));
      }
      else
        while ((iZ == null) || (iZ.isFinishing()))
          return;
      b localb = lW();
      if (iX)
        localb.setTargetFragment(iY, iV);
      localb.setArguments(getArguments());
      if (iX);
      for (Object localObject = iY.getFragmentManager(); ; localObject = iZ.getSupportFragmentManager())
      {
        localObject = ((FragmentManager)localObject).beginTransaction();
        ((FragmentTransaction)localObject).add(localb, mTag);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
        return;
      }
    }
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, Parcelable paramParcelable);
  }
}