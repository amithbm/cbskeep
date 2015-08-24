package com.android.ex.photo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class PhotoViewActivity extends ActionBarActivity
  implements PhotoViewController.ActivityInterface
{
  private ActionBarWrapper mActionBar;
  private PhotoViewController mController;

  protected PhotoViewController createController()
  {
    return new PhotoViewController(this);
  }

  public ActionBarInterface getActionBarInterface()
  {
    if (mActionBar == null)
      mActionBar = new ActionBarWrapper(getSupportActionBar());
    return mActionBar;
  }

  public Context getContext()
  {
    return this;
  }

  public PhotoViewController getController()
  {
    return mController;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    mController.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if (!mController.onBackPressed())
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mController = createController();
    mController.onCreate(paramBundle);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return (mController.onCreateOptionsMenu(paramMenu)) || (super.onCreateOptionsMenu(paramMenu));
  }

  protected void onDestroy()
  {
    mController.onDestroy();
    super.onDestroy();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return (mController.onOptionsItemSelected(paramMenuItem)) || (super.onOptionsItemSelected(paramMenuItem));
  }

  protected void onPause()
  {
    mController.onPause();
    super.onPause();
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return (mController.onPrepareOptionsMenu(paramMenu)) || (super.onPrepareOptionsMenu(paramMenu));
  }

  protected void onResume()
  {
    super.onResume();
    mController.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    mController.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    super.onStart();
    mController.onStart();
  }

  protected void onStop()
  {
    mController.onStop();
    super.onStop();
  }
}