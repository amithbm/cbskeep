package com.google.android.keep.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Spinner;

public class ReminderSpinner extends Spinner
{
  private boolean LM;
  private a LN;

  public ReminderSpinner(Context paramContext)
  {
    super(paramContext);
  }

  public ReminderSpinner(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public ReminderSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ReminderSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public ReminderSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public ReminderSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2, paramInt3);
  }

  public void a(a parama)
  {
    LN = parama;
  }

  public void cf(int paramInt)
  {
    super.setSelection(paramInt);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!LM) && (paramMotionEvent.getAction() == 0))
      LM = true;
    return super.onTouchEvent(paramMotionEvent);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((LM) && (paramBoolean))
    {
      LM = false;
      if (LN != null)
        LN.onClose();
    }
  }

  public boolean performClick()
  {
    LM = true;
    return super.performClick();
  }

  public void setSelection(int paramInt)
  {
    super.setSelection(paramInt);
    if (LN != null)
      LN.m(getId(), paramInt);
  }

  public static abstract interface a
  {
    public abstract void m(int paramInt1, int paramInt2);

    public abstract void onClose();
  }
}