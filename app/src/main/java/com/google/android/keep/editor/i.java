package com.google.android.keep.editor;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.TreeEntitySettings;
import com.google.android.keep.model.s;
import com.google.android.keep.util.A;

public class i extends DialogFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Button db;
  private s hb;
  private TreeEntityModel kJ;
  private final String mV = "key_list_settings";
  private final String mW = "key_apply_to_new_list";
  private RadioButton mZ;
  private RadioButton na;
  private RadioButton nb;
  private RadioButton nc;
  private CheckBox nd;
  private boolean ne;

  private void a(TreeEntitySettings paramTreeEntitySettings, boolean paramBoolean)
  {
    boolean bool2 = true;
    RadioButton localRadioButton = mZ;
    if (!paramTreeEntitySettings.ei())
    {
      bool1 = true;
      localRadioButton.setChecked(bool1);
      na.setChecked(paramTreeEntitySettings.ei());
      nb.setChecked(paramTreeEntitySettings.ej());
      localRadioButton = nc;
      if (paramTreeEntitySettings.ej())
        break label82;
    }
    label82: for (boolean bool1 = bool2; ; bool1 = false)
    {
      localRadioButton.setChecked(bool1);
      nd.setChecked(paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }

  private void en()
  {
    mZ.setOnCheckedChangeListener(this);
    na.setOnCheckedChangeListener(this);
    nb.setOnCheckedChangeListener(this);
    nc.setOnCheckedChangeListener(this);
    nd.setOnCheckedChangeListener(this);
    db.setOnClickListener(this);
  }

  private void eo()
  {
    TreeEntitySettings localTreeEntitySettings = ep();
    kJ.a(localTreeEntitySettings);
    if (nd.isChecked())
    {
      A.d(getActivity(), localTreeEntitySettings.ei());
      A.e(getActivity(), localTreeEntitySettings.ej());
    }
    dismiss();
  }

  private TreeEntitySettings ep()
  {
    boolean bool1 = na.isChecked();
    boolean bool2 = nb.isChecked();
    return new TreeEntitySettings(bool1, ne, bool2);
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = -1;
    int j = paramCompoundButton.getId();
    if (paramBoolean)
      switch (j)
      {
      default:
      case 2131493221:
      case 2131493220:
      case 2131493218:
      case 2131493219:
      case 2131493222:
      }
    while (true)
    {
      if (i != -1)
        hb.a(2131230867, i, 2131231020, null);
      return;
      i = 2131230964;
      continue;
      i = 2131230965;
      continue;
      i = 2131230966;
      continue;
      i = 2131230967;
      continue;
      i = 2131230968;
      continue;
      if (j == 2131493222)
        i = 2131230969;
    }
  }

  public void onClick(View paramView)
  {
    if (paramView == db)
      eo();
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    kJ = ((TreeEntityModel)Binder.a(localFragmentActivity, TreeEntityModel.class));
    hb = ((s)Binder.a(localFragmentActivity, s.class));
    View localView = localFragmentActivity.getLayoutInflater().inflate(2130968695, null);
    mZ = ((RadioButton)localView.findViewById(2131493221));
    na = ((RadioButton)localView.findViewById(2131493220));
    nb = ((RadioButton)localView.findViewById(2131493218));
    nc = ((RadioButton)localView.findViewById(2131493219));
    nd = ((CheckBox)localView.findViewById(2131493222));
    db = ((Button)localView.findViewById(2131493223));
    boolean bool;
    if (paramBundle != null)
    {
      TreeEntitySettings localTreeEntitySettings = (TreeEntitySettings)paramBundle.getParcelable("key_list_settings");
      bool = paramBundle.getBoolean("key_apply_to_new_list");
      paramBundle = localTreeEntitySettings;
    }
    while (true)
    {
      ne = paramBundle.jz();
      a(paramBundle, bool);
      en();
      return new AlertDialog.Builder(localFragmentActivity).setView(localView).setCancelable(true).create();
      paramBundle = kJ.iA();
      bool = true;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("key_list_settings", ep());
    paramBundle.putBoolean("key_apply_to_new_list", nd.isChecked());
  }
}