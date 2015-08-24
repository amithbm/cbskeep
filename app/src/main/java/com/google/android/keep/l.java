package com.google.android.keep;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class l
{
  public static abstract interface a
  {
    public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  }

  public static abstract interface b
  {
    public abstract void finish();
  }

  public static abstract interface c
  {
    public abstract void fJ();
  }

  public static abstract interface d
  {
    public abstract void fK();
  }

  public static abstract interface e
  {
    public abstract boolean onBackPressed();
  }

  public static abstract interface f
  {
    public abstract boolean onCreateOptionsMenu(Menu paramMenu);
  }

  public static abstract interface g
  {
    public abstract void onNewIntent(Intent paramIntent);
  }

  public static abstract interface h
  {
    public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem);
  }

  public static abstract interface i
  {
    public abstract void onPostCreate(Bundle paramBundle);
  }

  public static abstract interface j
  {
    public abstract void onPostResume();
  }

  public static abstract interface k
  {
    public abstract boolean onPrepareOptionsMenu(Menu paramMenu);
  }

  public static abstract interface l
  {
    public abstract void onRestoreInstanceState(Bundle paramBundle);
  }

  public static abstract interface m
  {
    public abstract void onUserLeaveHint();
  }

  public static abstract interface n
  {
    public abstract void onWindowFocusChanged(boolean paramBoolean);
  }

  public static abstract interface o
  {
    public abstract void startActivity(Intent paramIntent);
  }
}