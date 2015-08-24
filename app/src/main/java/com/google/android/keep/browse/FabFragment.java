package com.google.android.keep.browse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.keep.U;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.g;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.TimeReminder;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.navigation.BrowseNavigationRequest;
import com.google.android.keep.navigation.EditorNavigationRequest.a;
import com.google.android.keep.navigation.LabelNavigationRequest;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.util.KeepTime;
import com.google.api.client.util.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FabFragment extends com.google.android.keep.e
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, SingleSelectDialogFragment.b
{
  private static Interpolator gu;
  private a cR;
  private SingleSelectDialogFragment.OptionItem[] fF;
  private View gA;
  private View gB;
  private int gC;
  private int gD;
  private int gE;
  private int gF;
  private int gG;
  private boolean gH;
  private boolean gI;
  private boolean gJ = false;
  private String gK;
  private String gL;
  private int[] gM = null;
  private View gv;
  private View gw;
  private List<View> gx = Lists.newArrayList();
  private View gy;
  private View gz;
  private View mContentView;
  private boolean mIsExpanded;

  private void D(int paramInt)
  {
    int i = cj();
    switch (fF[paramInt].icon)
    {
    default:
      return;
    case 2130837672:
      paramInt = 1;
      a(2131230866, 2131230898, i, null);
    case 2130837683:
    }
    while (true)
    {
      a(TreeEntity.TreeEntityType.zO, paramInt, gB);
      a(2131230866, 2131230869, i, null);
      return;
      paramInt = 3;
      a(2131230866, 2131230899, i, null);
    }
  }

  private void a(TreeEntity.TreeEntityType paramTreeEntityType, int paramInt, View paramView)
  {
    EditorNavigationRequest.a locala = new EditorNavigationRequest.a();
    locala.h(paramTreeEntityType);
    if (paramInt != 0)
      locala.bt(paramInt);
    paramTreeEntityType = cR.aL();
    if (paramTreeEntityType.ka() == NavigationManager.NavigationMode.AP)
      locala.b(bM());
    if ((paramTreeEntityType.ka() == NavigationManager.NavigationMode.AO) && ((paramTreeEntityType instanceof LabelNavigationRequest)))
      locala.au(((LabelNavigationRequest)paramTreeEntityType).jX().gu());
    locala.ah(true);
    locala.a(new g(paramView, getActivity(), 2, -1L));
    cR.b(locala.jU());
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        FabFragment.b(FabFragment.this);
      }
    }
    , 100L);
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    do
    {
      bool1 = false;
      do
      {
        return bool1;
        cm();
        gI = false;
        if (gM == null)
        {
          gM = new int[2];
          gw.getLocationInWindow(gM);
        }
        cl();
        return true;
      }
      while (gI);
      Rect localRect = new Rect();
      gw.getDrawingRect(localRect);
      bool1 = bool2;
      if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        bool1 = true;
      gI = bool1;
      return true;
      paramMotionEvent = i((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
      if ((gI) && (paramMotionEvent == gw));
      for (int i = 1; (mIsExpanded) && ((paramMotionEvent == null) || (i != 0)); i = 0)
      {
        cf();
        return true;
      }
    }
    while ((paramMotionEvent == null) || (paramMotionEvent == gw));
    return paramMotionEvent.performClick();
  }

  private void aI()
  {
    BrowseNavigationRequest localBrowseNavigationRequest = cR.aL();
    if ((localBrowseNavigationRequest == null) || (!(getActivity() instanceof com.google.android.keep.activities.a)) || (cR.aM() != null))
      return;
    com.google.android.keep.activities.a locala = (com.google.android.keep.activities.a)getActivity();
    switch (6.cP[localBrowseNavigationRequest.ka().ordinal()])
    {
    default:
      return;
    case 1:
      if (mIsExpanded);
      for (i = gD; ; i = gE)
      {
        locala.q(i);
        return;
      }
    case 2:
    case 3:
    case 4:
    }
    if (mIsExpanded);
    for (int i = gF; ; i = gG)
    {
      locala.q(i);
      return;
    }
  }

  private BaseReminder bM()
  {
    return new TimeReminder(-1L, new KeepTime().jm() + 1, U.kI() * 3600000L, 1);
  }

  private void cd()
  {
    gw.setVisibility(4);
    gw.setTranslationY(mContentView.getBottom() - gw.getTop());
    gJ = false;
  }

  private void ce()
  {
    if (!mIsExpanded)
      return;
    mIsExpanded = false;
    m(mIsExpanded);
    aI();
    cg();
  }

  private void cg()
  {
    if (mIsExpanded)
    {
      mContentView.setClickable(true);
      gw.setContentDescription(gL);
      return;
    }
    mContentView.setClickable(false);
    gw.setContentDescription(gK);
  }

  private void ch()
  {
    if (com.google.android.keep.util.a.G(getActivity()))
    {
      mContentView.setOnClickListener(this);
      gw.setOnClickListener(this);
    }
    while (true)
    {
      Iterator localIterator = gx.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        localView.setOnClickListener(this);
        localView.setOnLongClickListener(this);
      }
      mContentView.setOnTouchListener(this);
      gw.setOnTouchListener(this);
    }
  }

  private void ci()
  {
    mContentView.setOnClickListener(null);
    gw.setOnClickListener(null);
    mContentView.setOnTouchListener(null);
    gw.setOnTouchListener(null);
    Iterator localIterator = gx.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.setOnClickListener(null);
      localView.setOnLongClickListener(null);
    }
  }

  private int cj()
  {
    int i = 2131231026;
    BrowseNavigationRequest localBrowseNavigationRequest = cR.aL();
    if (localBrowseNavigationRequest.ka() == NavigationManager.NavigationMode.AP)
      i = 2131231027;
    while (localBrowseNavigationRequest.ka() != NavigationManager.NavigationMode.AO)
      return i;
    return 2131231028;
  }

  private boolean ck()
  {
    if (!mIsExpanded)
      return false;
    cf();
    return true;
  }

  private void cl()
  {
    if (gH)
      return;
    if (mIsExpanded)
    {
      cf();
      return;
    }
    expand();
  }

  private void cm()
  {
    ((ToastsFragment)com.google.android.keep.util.e.a(getActivity(), 2131493048)).ax(true);
  }

  private View i(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    Rect localRect = new Rect();
    Iterator localIterator = gx.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.getLocationOnScreen(arrayOfInt);
      localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + localView.getWidth(), arrayOfInt[1] + localView.getHeight());
      if (localRect.contains(paramInt1, paramInt2))
        return localView;
    }
    localRect.set(gM[0], gM[1], gM[0] + gw.getWidth(), gM[1] + gw.getHeight());
    if (localRect.contains(paramInt1, paramInt2))
      return gw;
    return null;
  }

  private void m(final boolean paramBoolean)
  {
    ArrayList localArrayList = Lists.newArrayList();
    float f1;
    float f2;
    label19: Object localObject2;
    float f3;
    label37: label46: int i;
    int j;
    label109: int k;
    label160: label201: label224: label231: Object localObject3;
    if (paramBoolean)
    {
      f1 = 0.5F;
      if (!paramBoolean)
        break label438;
      f2 = 1.0F;
      localObject1 = gw;
      localObject2 = View.ROTATION;
      if (!paramBoolean)
        break label445;
      f3 = 0.0F;
      if (!paramBoolean)
        break label453;
      f4 = 135.0F;
      localArrayList.add(ObjectAnimator.ofFloat(localObject1, (Property)localObject2, new float[] { f3, f4 }));
      i = getResources().getColor(17170445);
      localObject1 = mContentView;
      localObject2 = new ArgbEvaluator();
      if (!paramBoolean)
        break label459;
      j = i;
      if (paramBoolean)
        i = gC;
      localArrayList.add(ObjectAnimator.ofObject(localObject1, "backgroundColor", (TypeEvaluator)localObject2, new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
      i = 0;
      if (i >= gx.size())
        break label516;
      localObject1 = (View)gx.get(i);
      if (!paramBoolean)
        break label468;
      j = i * 30;
      k = ((View)localObject1).getHeight() / 2;
      localObject2 = View.TRANSLATION_Y;
      if (!paramBoolean)
        break label490;
      f3 = k;
      if (!paramBoolean)
        break label496;
      f4 = 0.0F;
      localObject2 = ObjectAnimator.ofFloat(localObject1, (Property)localObject2, new float[] { f3, f4 });
      ((ObjectAnimator)localObject2).setStartDelay(j);
      localObject3 = View.ALPHA;
      if (!paramBoolean)
        break label504;
      f3 = 0.0F;
      label273: if (!paramBoolean)
        break label510;
    }
    label438: label445: label453: label459: label468: label490: label496: label504: label510: for (float f4 = 1.0F; ; f4 = 0.0F)
    {
      localObject3 = ObjectAnimator.ofFloat(localObject1, (Property)localObject3, new float[] { f3, f4 });
      ((ObjectAnimator)localObject3).setStartDelay(j);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject1, View.SCALE_X, new float[] { f1, f2 });
      localObjectAnimator1.setStartDelay(j);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject1, View.SCALE_Y, new float[] { f1, f2 });
      localObjectAnimator2.setStartDelay(j);
      ((ObjectAnimator)localObject3).addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          if (!paramBoolean)
            gP.setVisibility(4);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          super.onAnimationStart(paramAnonymousAnimator);
          if (paramBoolean)
            gP.setVisibility(0);
        }
      });
      localArrayList.add(localObject2);
      localArrayList.add(localObject3);
      localArrayList.add(localObjectAnimator1);
      localArrayList.add(localObjectAnimator2);
      i += 1;
      break label160;
      f1 = 1.0F;
      break;
      f2 = 0.5F;
      break label19;
      f3 = 135.0F;
      break label37;
      f4 = 0.0F;
      break label46;
      j = gC;
      break label109;
      j = (gx.size() - i - 1) * 20;
      break label201;
      f3 = 0.0F;
      break label224;
      f4 = k;
      break label231;
      f3 = 1.0F;
      break label273;
    }
    label516: Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).setInterpolator(gu);
    ((AnimatorSet)localObject1).setDuration(300L);
    ((AnimatorSet)localObject1).playTogether(localArrayList);
    ((AnimatorSet)localObject1).addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        FabFragment.a(FabFragment.this, false);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        super.onAnimationStart(paramAnonymousAnimator);
        FabFragment.a(FabFragment.this, true);
      }
    });
    ((AnimatorSet)localObject1).start();
  }

  protected String S()
  {
    return getString(2131230853);
  }

  public boolean cc()
  {
    return mIsExpanded;
  }

  public void cf()
  {
    if (!mIsExpanded)
      return;
    ce();
    a(2131230867, 2131230871, 2131231008, null);
  }

  public void expand()
  {
    if (mIsExpanded)
      return;
    mIsExpanded = true;
    m(mIsExpanded);
    aI();
    cg();
    a(2131230867, 2131230870, 2131231008, null);
  }

  public void g(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return;
    case 1:
    }
    D(paramInt2);
  }

  public void hide()
  {
    if (!gJ)
      return;
    int i = mContentView.getBottom();
    int j = gw.getTop();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(gw, View.TRANSLATION_Y, new float[] { gw.getTranslationY(), i - j });
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        FabFragment.a(FabFragment.this).setVisibility(8);
      }
    });
    localObjectAnimator.start();
    gJ = false;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    gu = AnimationUtils.loadInterpolator(getActivity(), 17563653);
    cR = ((a)Binder.a(getActivity(), a.class));
    if (getResources().getBoolean(2131623945))
    {
      paramBundle = (ToastsFragment)com.google.android.keep.util.e.a(getActivity(), 2131493048);
      if (paramBundle != null)
        paramBundle.s(gv);
    }
    gK = getString(2131231048);
    gL = getString(2131231331);
    mContentView.setContentDescription(gL);
  }

  public void onClick(View paramView)
  {
    cm();
    int i = paramView.getId();
    int j = cj();
    switch (i)
    {
    default:
      return;
    case 2131493054:
      a(TreeEntity.TreeEntityType.zO, 0, gy);
      a(2131230863, 2131230869, j, null);
      return;
    case 2131493053:
      a(TreeEntity.TreeEntityType.zP, 0, gz);
      a(2131230864, 2131230869, j, null);
      return;
    case 2131493051:
      a(TreeEntity.TreeEntityType.zO, 2, gA);
      a(2131230865, 2131230869, j, null);
      return;
    case 2131493052:
      a(2131230866, 2131230897, j, null);
      cm();
      new SingleSelectDialogFragment.a(this, 1).o(getString(2131231055)).a(fF).Y(2130968657).Z(2131493145).aa(2131492985).show();
      return;
    case 2131493055:
      cl();
      return;
    case 2131493041:
    }
    ck();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = getResources();
    gC = paramViewGroup.getColor(2131296399);
    gD = paramViewGroup.getColor(2131296400);
    gF = paramViewGroup.getColor(2131296401);
    gE = paramViewGroup.getColor(2131296372);
    gG = paramViewGroup.getColor(2131296396);
    fF = new SingleSelectDialogFragment.OptionItem[] { new SingleSelectDialogFragment.OptionItem(getString(2131231053), 2130837672), new SingleSelectDialogFragment.OptionItem(getString(2131231054), 2130837683) };
    mContentView = paramLayoutInflater.inflate(2130968608, null);
    gv = mContentView.findViewById(2131493050);
    gw = mContentView.findViewById(2131493055);
    gy = mContentView.findViewById(2131493054);
    gz = mContentView.findViewById(2131493053);
    gA = mContentView.findViewById(2131493051);
    gB = mContentView.findViewById(2131493052);
    gx.add(gy);
    gx.add(gz);
    gx.add(gB);
    gx.add(gA);
    gw.requestFocus();
    if ((paramBundle != null) && (!paramBundle.getBoolean("key_is_shown", true)))
      cd();
    return mContentView;
  }

  public boolean onLongClick(View paramView)
  {
    com.google.android.keep.util.e.C(paramView);
    return true;
  }

  public void onPause()
  {
    ci();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    ch();
    cg();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_shown", gJ);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == mContentView)
      return ck();
    if (paramView == gw)
      return a(paramMotionEvent);
    return false;
  }

  public void s(int paramInt)
  {
  }

  public void show()
  {
    if (gJ)
      return;
    int i = mContentView.getBottom();
    int j = gw.getTop();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(gw, View.TRANSLATION_Y, new float[] { i - j, 0.0F });
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        FabFragment.a(FabFragment.this).setVisibility(0);
      }
    });
    localObjectAnimator.start();
    gJ = true;
  }
}