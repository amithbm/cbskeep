package com.google.android.keep;

import android.content.Intent;
import android.os.Bundle;

public class q
{
  public static abstract interface a
  {
    public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  }

  public static abstract interface b
  {
    public abstract void onCreate(Bundle paramBundle);
  }

  public static abstract interface c
  {
    public abstract void onDestroy();
  }

  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  }

  public static abstract interface e
  {
    public abstract void onPause();
  }

  public static abstract interface f
  {
    public abstract void onResume();
  }

  public static abstract interface g
  {
    public abstract void onSaveInstanceState(Bundle paramBundle);
  }

  public static abstract interface h
  {
    public abstract void onStart();
  }

  public static abstract interface i
  {
    public abstract void onStop();
  }
}