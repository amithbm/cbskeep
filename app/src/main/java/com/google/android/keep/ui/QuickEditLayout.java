package com.google.android.keep.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.keep.f;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.util.e;

public class QuickEditLayout extends FrameLayout
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, TextView.OnEditorActionListener
{
  private TextView LF;
  private Typeface LG;
  private QebOptionsLayout LH;
  private ImageView LI;
  private a Lz;
  private boolean gJ = true;
  private Context mContext;

  public QuickEditLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public QuickEditLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }

  public QuickEditLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mContext = paramContext;
    LG = e.d(paramContext, paramAttributeSet);
  }

  private void aJ(boolean paramBoolean)
  {
    if (paramBoolean);
    for (ObjectAnimator localObjectAnimator = f.c(LI); ; localObjectAnimator = f.d(LI))
    {
      if (localObjectAnimator != null)
        localObjectAnimator.start();
      return;
    }
  }

  private void clearText()
  {
    LF.setText(null);
  }

  private String getText()
  {
    String str = LF.getText().toString();
    if (TextUtils.isEmpty(str))
      return "";
    return str.toString();
  }

  private void my()
  {
    if (Lz != null)
      Lz.j(getText());
    clearText();
    e.B(LF);
  }

  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      LH.hide();
      aJ(true);
      return;
    }
    LH.show();
    aJ(false);
  }

  public void b(a parama)
  {
    Lz = parama;
    LH = ((QebOptionsLayout)findViewById(2131493298));
    LH.f(this, 14);
    LH.a(parama);
    LF = ((TextView)findViewById(2131493296));
    LF.setTypeface(LG);
    LF.setOnClickListener(this);
    LI = ((ImageView)findViewById(2131493297));
    LI.setOnClickListener(this);
    parama = (ToastsFragment)e.a((FragmentActivity)mContext, 2131493048);
    if (parama != null)
      parama.s(this);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void hide()
  {
    if (!gJ)
      return;
    int i = getBottom();
    int j = getTop();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[] { getTranslationY(), i - j });
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        setVisibility(8);
      }
    });
    localObjectAnimator.start();
    gJ = false;
  }

  public boolean isActive()
  {
    return LF.hasFocus();
  }

  public void mx()
  {
    if (!TextUtils.isEmpty(getText()))
      my();
    e.B(LF);
  }

  public void onClick(View paramView)
  {
    if (((paramView == LF) || (paramView == LI)) && (Lz != null))
    {
      Lz.k(getText());
      clearText();
    }
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      my();
      return true;
    }
    return false;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramView == LF) && (Lz != null))
      Lz.k(paramBoolean);
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 66))
    {
      my();
      return true;
    }
    return false;
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void show()
  {
    if (gJ)
      return;
    int i = getBottom();
    int j = getTop();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[] { i - j, 0.0F });
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        setVisibility(0);
      }
    });
    localObjectAnimator.start();
    gJ = true;
  }

  public static abstract interface a
  {
    public abstract void C(int paramInt);

    public abstract void j(String paramString);

    public abstract void k(String paramString);

    public abstract void k(boolean paramBoolean);
  }
}