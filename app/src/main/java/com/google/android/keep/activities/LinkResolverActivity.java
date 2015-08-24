package com.google.android.keep.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Patterns;
import com.google.android.keep.browse.SingleSelectDialogFragment.a;
import com.google.android.keep.browse.SingleSelectDialogFragment.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkResolverActivity extends FragmentActivity
  implements SingleSelectDialogFragment.b
{
  private String[] f(String paramString)
  {
    if (Patterns.PHONE.matcher(paramString).matches())
      return new String[] { getString(2131231193), getString(2131231194) };
    return new String[] { getString(2131231192), getString(2131231194) };
  }

  public void g(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      startActivity(new Intent("android.intent.action.VIEW", getIntent().getData()));
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((getIntent() == null) || (getIntent().getData() == null))
      finish();
    while (paramBundle != null)
      return;
    paramBundle = getIntent().getStringExtra("android.intent.extra.TEXT");
    String[] arrayOfString = f(paramBundle);
    new SingleSelectDialogFragment.a(this, 0).o(paramBundle).a(arrayOfString).show();
  }

  public void s(int paramInt)
  {
    finish();
  }
}