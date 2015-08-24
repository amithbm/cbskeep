package com.google.android.keep.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.keep.util.e;

public class DrawerSelectableItemView extends LinearLayout
{
  private static float Jf = 1.0F;
  private static float Jg = 0.5F;
  private ImageView mIconView;
  private TextView mTextView;

  public DrawerSelectableItemView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DrawerSelectableItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DrawerSelectableItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void g(float paramFloat1, float paramFloat2)
  {
    Jf = paramFloat1;
    Jg = paramFloat2;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mIconView = ((ImageView)findViewById(2131492985));
    mTextView = ((TextView)findViewById(2131492986));
  }

  public void setActivated(boolean paramBoolean)
  {
    super.setActivated(paramBoolean);
    Object localObject = mIconView;
    float f;
    Context localContext;
    if (paramBoolean)
    {
      f = Jf;
      e.a((ImageView)localObject, f);
      localObject = mTextView;
      localContext = getContext();
      if (!paramBoolean)
        break label60;
    }
    label60: for (int i = 2131558891; ; i = 2131558892)
    {
      ((TextView)localObject).setTextAppearance(localContext, i);
      return;
      f = Jg;
      break;
    }
  }
}