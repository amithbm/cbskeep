package com.google.android.keep.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.keep.a.a;
import com.google.android.keep.model.Label;
import com.google.android.keep.util.D;
import com.google.api.client.util.Lists;
import java.util.ArrayList;

public class LabelLayout extends LinearLayout
{
  private ArrayList<Label> KR = new ArrayList();
  ArrayList<Integer> KS = new ArrayList();
  private final ArrayList<ArrayList<View>> KT = Lists.newArrayList();
  private final ArrayList<LinearLayout> KU = Lists.newArrayList();
  private int KV = 2147483647;
  private Integer KW = null;
  private final LayoutInflater mInflater;

  public LabelLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public LabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mInflater = ((Activity)paramContext).getLayoutInflater();
    c(paramContext, paramAttributeSet);
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i = paramInt3 + 1;
    int k = 1;
    int j = paramInt4;
    paramInt4 = k;
    while (j + i > paramInt3)
    {
      View localView = r(paramInt5, paramInt6 - paramInt4);
      j -= c(localView, paramInt1, paramInt2);
      a(localView, getContext().getResources().getString(2131231346, new Object[] { Integer.valueOf(paramInt7 + paramInt4) }));
      i = c(localView, paramInt1, paramInt2);
      if (paramInt4 > 1)
        KS.set(paramInt5, Integer.valueOf(((Integer)KS.get(paramInt5)).intValue() - 1));
      paramInt4 += 1;
    }
  }

  private void a(View paramView, String paramString)
  {
    ((TextView)paramView.findViewById(2131493096)).setText(paramString);
  }

  private int c(View paramView, int paramInt1, int paramInt2)
  {
    measureChild(paramView, paramInt1, paramInt2);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
  }

  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null)
      return;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.LabelLayout);
    KV = paramContext.getInteger(0, 2147483647);
    KW = Integer.valueOf(paramContext.getResourceId(1, 0));
    if (KW.intValue() == 0)
      throw new IllegalArgumentException("labelView must be set!");
    paramContext.recycle();
  }

  private void cd(int paramInt)
  {
    if (KS.size() == paramInt)
    {
      KS.add(Integer.valueOf(1));
      return;
    }
    KS.set(paramInt, Integer.valueOf(((Integer)KS.get(paramInt)).intValue() + 1));
  }

  private LinearLayout ce(int paramInt)
  {
    if (paramInt < KU.size())
    {
      localLinearLayout = (LinearLayout)KU.get(paramInt);
      localLinearLayout.setVisibility(0);
      return localLinearLayout;
    }
    LinearLayout localLinearLayout = (LinearLayout)mInflater.inflate(2130968715, this, false);
    KU.add(localLinearLayout);
    return localLinearLayout;
  }

  private void dW()
  {
    int i = 0;
    while (i < KS.size())
    {
      LinearLayout localLinearLayout = ce(i);
      if (getChildCount() <= i)
        addView(localLinearLayout);
      int j = localLinearLayout.getChildCount();
      int k = ((Integer)KS.get(i)).intValue();
      while (j < k)
      {
        localLinearLayout.addView(r(i, j));
        j += 1;
      }
      int m = ((ArrayList)KT.get(i)).size();
      j = k;
      while (j < m)
      {
        ((View)((ArrayList)KT.get(i)).get(j)).setVisibility(8);
        j += 1;
      }
      i += 1;
    }
    i = KS.size();
    while (i < KU.size())
    {
      ((LinearLayout)KU.get(i)).setVisibility(8);
      i += 1;
    }
  }

  private View r(int paramInt1, int paramInt2)
  {
    if (KT.size() == paramInt1)
      KT.add(new ArrayList());
    Object localObject = (ArrayList)KT.get(paramInt1);
    if (paramInt2 < ((ArrayList)localObject).size())
    {
      localObject = (View)((ArrayList)localObject).get(paramInt2);
      ((View)localObject).setVisibility(0);
      return localObject;
    }
    View localView = mInflater.inflate(KW.intValue(), this, false);
    ((ArrayList)localObject).add(localView);
    return localView;
  }

  public void d(ArrayList<Label> paramArrayList)
  {
    if (paramArrayList == KR)
      return;
    if (paramArrayList == null)
      KR.clear();
    while (true)
    {
      requestLayout();
      return;
      KR = paramArrayList;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    D.bO("LabelLayout_onMeasure");
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int k = 0;
    int i = 0;
    int m = 0;
    KS.clear();
    int j = 0;
    View localView;
    int n;
    if (j < KR.size())
    {
      localView = r(k, i);
      a(localView, ((Label)KR.get(j)).getName());
      n = Math.min(c(localView, paramInt1, paramInt2), i1);
      if (m + n <= i1)
      {
        n = m + n;
        m = i;
      }
    }
    for (i = n; ; i = c(localView, paramInt1, paramInt2))
    {
      cd(k);
      n = m + 1;
      j += 1;
      m = i;
      i = n;
      break;
      if (k + 1 == KV)
      {
        j = KR.size() - j;
        a(localView, getContext().getResources().getString(2131231346, new Object[] { Integer.valueOf(j) }));
        if (m + c(localView, paramInt1, paramInt2) <= i1)
          cd(k);
        while (true)
        {
          dW();
          super.onMeasure(paramInt1, paramInt2);
          D.ot();
          return;
          a(paramInt1, paramInt2, i1, m, k, i, j);
        }
      }
      k += 1;
      m = 0;
      localView = r(k, 0);
      a(localView, ((Label)KR.get(j)).getName());
    }
  }
}