package com.google.android.keep.ui;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class h extends BaseAdapter
{
  public SgvAnimationHelper.TranslationAnimationType L(int paramInt)
  {
    return SgvAnimationHelper.TranslationAnimationType.Mv;
  }

  public int Q(int paramInt)
  {
    return 1;
  }

  public abstract boolean R(int paramInt);

  public boolean S(int paramInt)
  {
    return true;
  }

  public int a(int paramInt, boolean paramBoolean)
  {
    if (!R(paramInt))
      return 0;
    return 1;
  }

  public BitmapDrawable a(int paramInt, View paramView)
  {
    return null;
  }

  public abstract View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2);

  public void a(long paramLong, SgvAnimationHelper.TranslationAnimationType paramTranslationAnimationType)
  {
  }

  public int cp()
  {
    return 0;
  }

  public int cq()
  {
    return 3;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    throw new IllegalStateException("Do not use BaseAdapter#getView, use what's in GridAdapter instead");
  }

  public boolean hasStableIds()
  {
    return true;
  }
}