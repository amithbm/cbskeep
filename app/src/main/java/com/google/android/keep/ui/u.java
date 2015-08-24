package com.google.android.keep.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.keep.util.D;

public class u extends DialogFragment
{
  private Dialog mDialog = null;

  private void a(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = getActivity();
    if ((paramDialogInterface != null) && (isAdded()))
      paramDialogInterface.onBackPressed();
  }

  public static u g(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dialog_text", paramString);
    localBundle.putInt("dialog_color", paramInt);
    paramString = new u();
    paramString.setArguments(localBundle);
    return paramString;
  }

  private a mu()
  {
    if ((getTargetFragment() instanceof a))
      return (a)getTargetFragment();
    if ((getActivity() instanceof a))
      return (a)getActivity();
    return null;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(0, 2131558790);
    setRetainInstance(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    D.bO("OverlayDialog_onCreateView");
    paramBundle = getArguments();
    paramLayoutInflater = paramLayoutInflater.inflate(2130968677, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131493181);
    paramViewGroup.setBackgroundColor(paramBundle.getInt("dialog_color"));
    paramViewGroup.getBackground().setAlpha(204);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131493145);
    paramBundle = paramBundle.getString("dialog_text");
    if (!TextUtils.isEmpty(paramBundle))
    {
      paramViewGroup.setText(paramBundle);
      paramViewGroup.setVisibility(0);
    }
    while (true)
    {
      ((Button)paramLayoutInflater.findViewById(2131493183)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = u.a(u.this);
          if (paramAnonymousView != null)
            paramAnonymousView.mv();
        }
      });
      D.ot();
      return paramLayoutInflater;
      paramViewGroup.setVisibility(8);
    }
  }

  public void onStart()
  {
    super.onStart();
    mDialog = getDialog();
    if (mDialog != null)
    {
      mDialog.getWindow().setLayout(-1, -1);
      mDialog.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramAnonymousInt == 4)
            u.a(u.this, paramAnonymousDialogInterface);
          return true;
        }
      });
    }
  }

  public static abstract interface a
  {
    public abstract void mv();
  }
}