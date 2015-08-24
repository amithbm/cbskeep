package com.google.android.keep.editor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.keep.f;
import com.google.android.keep.model.C;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.p;
import java.util.Arrays;
import java.util.List;

public class ViolatorFragment extends p
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wL });
  private C ly;
  private View pu;
  private TextView pv;
  private boolean pw = false;
  private Interpolator px;

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    if (!ly.ip())
    {
      pu.setVisibility(8);
      return;
    }
    pv.setText(String.valueOf(ly.jj().size()));
  }

  protected boolean aB()
  {
    return false;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public void eZ()
  {
    if (pw);
    ObjectAnimator localObjectAnimator;
    do
    {
      return;
      pw = true;
      pu.setVisibility(0);
      localObjectAnimator = f.b(pu, 0.0F, null);
    }
    while (localObjectAnimator == null);
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(px);
    localObjectAnimator.start();
  }

  public void fa()
  {
    if (!pw);
    Object localObject;
    do
    {
      return;
      pw = false;
      pu.setTranslationY(0.0F);
      localObject = (FrameLayout.LayoutParams)pu.getLayoutParams();
      int i = pu.getHeight();
      int j = ((FrameLayout.LayoutParams)localObject).bottomMargin;
      localObject = f.a(pu, i + j, new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          ViolatorFragment.a(ViolatorFragment.this).setVisibility(4);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
        }
      });
    }
    while (localObject == null);
    ((ObjectAnimator)localObject).setDuration(200L);
    ((ObjectAnimator)localObject).setInterpolator(px);
    ((ObjectAnimator)localObject).start();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ly = ((C)e(C.class));
    px = AnimationUtils.loadInterpolator(getActivity(), 17563653);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    pu = paramLayoutInflater.inflate(2130968702, paramViewGroup, false);
    pv = ((TextView)pu.findViewById(2131493228));
    return pu;
  }
}