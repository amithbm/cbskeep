package com.google.android.keep.provider;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;

public class d extends CursorWrapper
{
  private final Bundle BR;

  public d(Cursor paramCursor, Bundle paramBundle)
  {
    super(paramCursor);
    BR = paramBundle;
  }

  public Bundle getExtras()
  {
    return BR;
  }
}