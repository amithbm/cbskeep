package com.google.android.keep.homescreenwidget;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.keep.b;
import com.google.android.keep.browse.SingleSelectDialogFragment.OptionItem;
import com.google.android.keep.browse.SingleSelectDialogFragment.a;
import com.google.android.keep.browse.SingleSelectDialogFragment.b;
import com.google.android.keep.quickaddwidget.QuickAddWidgetService;

public class NoteTypePickerActivity extends b
  implements SingleSelectDialogFragment.b
{
  private SingleSelectDialogFragment.OptionItem[] jb;
  private String mAccountName;

  protected String S()
  {
    return getString(2131230842);
  }

  public void g(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    switch (jb[paramInt2].icon)
    {
    default:
      paramInt1 = 2131230867;
    case 2130837688:
    case 2130837686:
    case 2130837687:
    case 2130837672:
    }
    while (true)
    {
      if (localIntent.getAction() != null)
      {
        localIntent.putExtra("authAccount", mAccountName);
        QuickAddWidgetService.a(this, localIntent);
        a(paramInt1, 2131230874, 2131231012, null);
      }
      finish();
      return;
      localIntent.setAction("com.google.android.keep.intent.action.QUICK_EDIT");
      paramInt1 = 2131230863;
      continue;
      localIntent.setAction("com.google.android.keep.intent.action.QUICK_LIST");
      paramInt1 = 2131230864;
      continue;
      localIntent.setAction("com.google.android.keep.intent.action.QUICK_VOICE");
      paramInt1 = 2131230865;
      continue;
      localIntent.setAction("com.google.android.keep.intent.action.QUICK_IMAGE");
      paramInt1 = 2131230866;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mAccountName = getIntent().getStringExtra("authAccount");
    jb = new SingleSelectDialogFragment.OptionItem[] { new SingleSelectDialogFragment.OptionItem(getString(2131231251), 2130837688), new SingleSelectDialogFragment.OptionItem(getString(2131231252), 2130837686), new SingleSelectDialogFragment.OptionItem(getString(2131231253), 2130837687), new SingleSelectDialogFragment.OptionItem(getString(2131231254), 2130837672) };
    if (paramBundle != null)
      return;
    new SingleSelectDialogFragment.a(this, 0).o(getString(2131231245)).a(jb).Y(2130968657).Z(2131493145).aa(2131492985).show();
  }

  public void s(int paramInt)
  {
    finish();
  }
}