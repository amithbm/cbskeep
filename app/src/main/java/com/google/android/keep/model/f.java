package com.google.android.keep.model;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.db.a;
import com.google.android.keep.p;

public abstract class f extends BaseModel<Cursor>
{
  private final a vk;

  public f(FragmentActivity paramFragmentActivity, p paramp, BaseModel.LoaderCreation paramLoaderCreation)
  {
    super(paramFragmentActivity, paramp, paramLoaderCreation);
    vk = ((a)Binder.a(paramFragmentActivity, a.class));
  }

  public a gP()
  {
    return vk;
  }
}