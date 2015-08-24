package com.google.android.keep.toasts;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.util.a;

public class ActionableToastBar extends ToastLayout
{
  private ToastListener Hm;
  private TextView Hn;
  private TextView Ho;
  private Context mContext;

  public ActionableToastBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public ActionableToastBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ActionableToastBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, Looper.myLooper());
  }

  ActionableToastBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Looper paramLooper)
  {
    super(paramContext, paramAttributeSet, paramInt, paramLooper);
    mContext = paramContext;
  }

  private void setVisibility(boolean paramBoolean)
  {
    int i = 0;
    Hn.setVisibility(0);
    TextView localTextView = Ho;
    if (paramBoolean);
    while (true)
    {
      localTextView.setVisibility(i);
      return;
      i = 8;
    }
  }

  public void a(TextView paramTextView1, TextView paramTextView2)
  {
    Hn = paramTextView1;
    Ho = paramTextView2;
  }

  public void b(final ToastListener paramToastListener)
  {
    boolean bool;
    int i;
    if (paramToastListener != null)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      Hm = paramToastListener;
      Ho.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramToastListener.hj();
          av(true);
          a.a(ActionableToastBar.a(ActionableToastBar.this), paramToastListener.hi());
        }
      });
      String str = paramToastListener.hf();
      Hn.setText(str);
      Hn.setContentDescription(str);
      i = paramToastListener.hh();
      if (i != ToastListener.Hy)
        break label91;
      Ho.setText("");
      setVisibility(false);
    }
    while (true)
    {
      super.show();
      return;
      bool = false;
      break;
      label91: Ho.setText(i);
      Ho.setContentDescription(mContext.getString(i));
      setVisibility(true);
    }
  }

  public ToastListener.Type hg()
  {
    if (Hm == null)
      return null;
    return Hm.hg();
  }

  protected void lH()
  {
    if (Hm != null)
      Hm.lH();
  }

  protected void lI()
  {
    Ho.setOnClickListener(null);
    if (Hm != null)
    {
      Hm.lI();
      Hm = null;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Hn = ((TextView)findViewById(2131493372));
    Ho = ((TextView)findViewById(2131493373));
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (Hm != null)
      Hm.onSaveInstanceState(paramBundle);
  }

  public void show()
  {
    throw new UnsupportedOperationException("Use show(listener) instead");
  }
}