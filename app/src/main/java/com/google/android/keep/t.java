package com.google.android.keep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class t extends ActionBarActivity
{
  protected final m sc = new m();
  private int sd;

  private void fN()
  {
    sd -= 1;
  }

  private void g(Intent paramIntent)
  {
    int i = sd;
    sd = (i + 1);
    if (i == 0)
      sc.startActivity(paramIntent);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (sc.dispatchKeyEvent(paramKeyEvent))
      return true;
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public m fM()
  {
    return sc;
  }

  public void finish()
  {
    sc.finish();
    super.finish();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    sc.onActivityResult(paramInt1, paramInt2, paramIntent);
    sc.a(0xFFFF & paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if (!sc.onBackPressed())
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    sc.onCreate(paramBundle);
    super.onCreate(paramBundle);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (sc.onCreateOptionsMenu(paramMenu))
      return true;
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    sc.onDestroy();
    super.onDestroy();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    sc.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (sc.onOptionsItemSelected(paramMenuItem))
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onPause()
  {
    sc.onPause();
    super.onPause();
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    sc.onPostCreate(paramBundle);
    super.onPostCreate(paramBundle);
  }

  protected void onPostResume()
  {
    sc.onPostResume();
    super.onPostResume();
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (sc.onPrepareOptionsMenu(paramMenu))
      return true;
    return super.onPrepareOptionsMenu(paramMenu);
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    sc.onRestoreInstanceState(paramBundle);
    super.onRestoreInstanceState(paramBundle);
  }

  protected void onResume()
  {
    v.a(getSupportFragmentManager());
    sc.onResume();
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    sc.onSaveInstanceState(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    v.a(getSupportFragmentManager());
    sc.onStart();
    super.onStart();
  }

  protected void onStop()
  {
    sc.onStop();
    super.onStop();
  }

  public void onSupportActionModeFinished(ActionMode paramActionMode)
  {
    sc.fJ();
    super.onSupportActionModeFinished(paramActionMode);
  }

  public void onSupportActionModeStarted(ActionMode paramActionMode)
  {
    sc.fK();
    super.onSupportActionModeStarted(paramActionMode);
  }

  protected void onUserLeaveHint()
  {
    sc.onUserLeaveHint();
    super.onUserLeaveHint();
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    sc.onWindowFocusChanged(paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
  }

  public void startActivity(Intent paramIntent)
  {
    g(paramIntent);
    super.startActivity(paramIntent);
    fN();
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    g(paramIntent);
    super.startActivity(paramIntent, paramBundle);
    fN();
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    g(paramIntent);
    super.startActivityForResult(paramIntent, paramInt);
    fN();
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    g(paramIntent);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    fN();
  }

  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    g(paramIntent);
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt);
    fN();
  }
}