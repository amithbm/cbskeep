package com.google.android.keep.browse;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.common.base.Preconditions;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.l;
import com.google.android.keep.model.s;
import com.google.android.keep.ui.e.a;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.a;

public class h extends DialogFragment
  implements View.OnClickListener, TextView.OnEditorActionListener, e.a
{
  private l fh;
  private s hb;
  private Label hc;
  private EditText hd;
  private Button he;
  private Button hf;
  private TextView hg;
  private String hh = null;
  private boolean hi = false;

  public static h b(Label paramLabel)
  {
    h localh = new h();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("args_label_to_rename", paramLabel);
    localh.setArguments(localBundle);
    return localh;
  }

  private void cs()
  {
    hh = null;
    hg.setVisibility(4);
  }

  private void m(String paramString)
  {
    if (paramString == null)
      return;
    paramString = paramString.trim();
    String str = hc.getName();
    if (str.equals(paramString))
    {
      dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      n(getString(2131231367));
      return;
    }
    if ((fh.P(paramString) != null) && (!str.equalsIgnoreCase(paramString)))
    {
      n(getString(2131231365));
      return;
    }
    hb.a(2131230867, 2131230998, 2131231025, null);
    hc.setName(paramString);
    a.a(hf, getString(2131231363, new Object[] { paramString }));
    dismiss();
  }

  private void n(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    hh = paramString;
    hg.setText(paramString);
    hg.setVisibility(0);
    a.a(hg, paramString);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean != hi)
    {
      if (!paramBoolean)
        break label49;
      n(getString(2131231366));
      hh = null;
      hb.a(2131230867, 2131231000, 2131231025, null);
    }
    while (true)
    {
      hi = paramBoolean;
      return;
      label49: cs();
    }
  }

  public void onClick(View paramView)
  {
    if (paramView == he)
      dismiss();
    while (paramView != hf)
      return;
    m(hd.getText().toString());
  }

  public Dialog onCreateDialog(final Bundle paramBundle)
  {
    fh = ((l)Binder.a(getActivity(), l.class));
    hb = ((s)Binder.a(getActivity(), s.class));
    Object localObject = null;
    if (paramBundle != null)
    {
      hc = ((Label)paramBundle.getParcelable("key_label_to_rename"));
      localObject = paramBundle.getString("key_error_to_display");
      paramBundle = paramBundle.getString("key_text_to_display");
      if (hc == null)
        break label286;
    }
    label286: for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      View localView = LayoutInflater.from(getActivity()).inflate(2130968714, null);
      hd = ((EditText)localView.findViewById(2131493254));
      hd.setText(paramBundle);
      hd.setOnEditorActionListener(this);
      hd.addTextChangedListener(new com.google.android.keep.ui.e(this, ((Integer)Config.Pd.get()).intValue()));
      hg = ((TextView)localView.findViewById(2131493255));
      if (!TextUtils.isEmpty((CharSequence)localObject))
        n((String)localObject);
      he = ((Button)localView.findViewById(2131493256));
      he.setOnClickListener(this);
      hf = ((Button)localView.findViewById(2131493257));
      hf.setOnClickListener(this);
      localObject = new AlertDialog.Builder(getActivity()).setView(localView).setCancelable(false).create();
      ((Dialog)localObject).setOnShowListener(new DialogInterface.OnShowListener()
      {
        public void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          com.google.android.keep.util.e.A(h.a(h.this));
          h.a(h.this).setSelection(paramBundle.length());
        }
      });
      return localObject;
      hc = ((Label)getArguments().getParcelable("args_label_to_rename"));
      paramBundle = hc.getName();
      break;
    }
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 6)
    {
      m(hd.getText().toString());
      bool = true;
    }
    return bool;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("key_label_to_rename", hc);
    paramBundle.putString("key_text_to_display", hd.getText().toString());
    paramBundle.putString("key_error_to_display", hh);
  }
}