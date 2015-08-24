package com.google.android.keep.colorpicker;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.keep.util.d;

public class a extends DialogFragment
  implements b.a
{
  protected AlertDialog kb;
  protected int kc = 2131231135;
  protected int kd;
  private ColorPickerPalette ke;
  protected b.a kf;
  protected int[] mColors = null;
  protected int mSelectedColor;
  protected int mSize;

  public static a a(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    a locala = new a();
    locala.b(paramInt1, paramArrayOfInt, paramInt2, paramInt3, paramInt4);
    return locala;
  }

  private void cV()
  {
    if ((ke != null) && (mColors != null))
      ke.b(mColors, mSelectedColor);
  }

  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if ((mColors != paramArrayOfInt) || (mSelectedColor != paramInt))
    {
      mColors = paramArrayOfInt;
      mSelectedColor = paramInt;
      cV();
    }
  }

  public void b(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    c(paramInt1, paramInt3, paramInt4);
    a(paramArrayOfInt, paramInt2);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("title_id", paramInt1);
    localBundle.putInt("columns", paramInt2);
    localBundle.putInt("size", paramInt3);
    setArguments(localBundle);
  }

  public void cU()
  {
    if (ke != null)
    {
      cV();
      ke.setVisibility(0);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null)
    {
      kc = getArguments().getInt("title_id");
      kd = getArguments().getInt("columns");
      mSize = getArguments().getInt("size");
    }
    if (paramBundle != null)
    {
      mColors = paramBundle.getIntArray("colors");
      mSelectedColor = ((Integer)paramBundle.getSerializable("selected_color")).intValue();
    }
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    View localView = LayoutInflater.from(paramBundle).inflate(2130968640, null);
    ke = ((ColorPickerPalette)localView.findViewById(2131493128));
    ke.a(mSize, kd, this);
    if (mColors != null)
      cU();
    kb = new AlertDialog.Builder(paramBundle).setTitle(kc).setView(localView).create();
    return kb;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putIntArray("colors", mColors);
    paramBundle.putSerializable("selected_color", Integer.valueOf(mSelectedColor));
  }

  public void y(int paramInt)
  {
    if (kf != null)
      kf.y(paramInt);
    if ((getTargetFragment() instanceof b.a))
      ((b.a)getTargetFragment()).y(paramInt);
    if (paramInt != mSelectedColor)
    {
      mSelectedColor = paramInt;
      ke.b(mColors, mSelectedColor);
    }
    String str = d.a(getActivity(), paramInt);
    if (!TextUtils.isEmpty(str))
      com.google.android.keep.util.a.a(ke, String.format(getString(2131231139), new Object[] { str }));
    dismiss();
  }
}