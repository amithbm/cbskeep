package com.google.android.keep.ui;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.keep.a.a;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.navigation.a;
import com.google.android.keep.provider.i.g;
import com.google.android.keep.util.e;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class SearchFilterLayout extends RelativeLayout
  implements TextWatcher, View.OnClickListener, View.OnKeyListener, View.OnLongClickListener, TextView.OnEditorActionListener
{
  private final ColorFilterBar.a IR = new ColorFilterBar.a()
  {
    public void c(String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      SearchFilterLayout.a(SearchFilterLayout.this);
      SearchFilterLayout.a(SearchFilterLayout.this, paramAnonymousString, paramAnonymousBoolean);
      if (SearchFilterLayout.b(SearchFilterLayout.this) != null)
        SearchFilterLayout.b(SearchFilterLayout.this).E(2131230972);
    }
  };
  private EditText LO;
  private ImageView LP;
  private ImageView LQ;
  private ImageView LR;
  private ImageView LS;
  private ImageView LT;
  private ImageView LU;
  private ImageView LV;
  private boolean LW;
  private ColorFilterBar LX;
  private List<Integer> LY;
  private a LZ;
  private ImageView Lp;
  private a et;
  private int mHeight;

  public SearchFilterLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public SearchFilterLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }

  public SearchFilterLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SearchFilterLayout);
    LW = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }

  private void D(List<String> paramList)
  {
    LQ = ((ImageView)cg(1));
    LR = ((ImageView)cg(2));
    LS = ((ImageView)cg(3));
    LU = ((ImageView)cg(5));
    LT = ((ImageView)cg(4));
    LV = ((ImageView)findViewById(2131493328));
    E(paramList);
    LX = ((ColorFilterBar)findViewById(2131493333));
    LX.a(this, paramList);
    LX.a(IR);
    int j = getHeight();
    int i = j;
    if (j == 0)
    {
      measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      i = getMeasuredHeight();
    }
    mHeight = i;
  }

  private void E(List<String> paramList)
  {
    LV = ((ImageView)findViewById(2131493328));
    LV.setOnLongClickListener(this);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      d((String)paramList.get(0), true);
      e.a(LV, 1.0F);
    }
    while (true)
    {
      LV.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!SearchFilterLayout.c(SearchFilterLayout.this).isVisible())
            SearchFilterLayout.d(SearchFilterLayout.this);
          while (true)
          {
            SearchFilterLayout.e(SearchFilterLayout.this).clearFocus();
            return;
            SearchFilterLayout.a(SearchFilterLayout.this);
          }
        }
      });
      return;
      e.a(LV, 0.8F);
    }
  }

  private void aK(boolean paramBoolean)
  {
    int j = 0;
    ImageView localImageView = LQ;
    if (paramBoolean)
    {
      i = 0;
      localImageView.setVisibility(i);
      localImageView = LS;
      if (!paramBoolean)
        break label99;
      i = 0;
      label32: localImageView.setVisibility(i);
      localImageView = LR;
      if (!paramBoolean)
        break label105;
      i = 0;
      label50: localImageView.setVisibility(i);
      localImageView = LT;
      if (!paramBoolean)
        break label111;
      i = 0;
      label68: localImageView.setVisibility(i);
      localImageView = LU;
      if (!paramBoolean)
        break label117;
    }
    label99: label105: label111: label117: for (int i = j; ; i = 8)
    {
      localImageView.setVisibility(i);
      return;
      i = 8;
      break;
      i = 8;
      break label32;
      i = 8;
      break label50;
      i = 8;
      break label68;
    }
  }

  private View cg(final int paramInt)
  {
    View localView = findViewById(ch(paramInt));
    g(paramInt, ck(paramInt));
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SearchFilterLayout.a(SearchFilterLayout.this, paramInt);
        if (SearchFilterLayout.b(SearchFilterLayout.this) != null)
          SearchFilterLayout.b(SearchFilterLayout.this).E(SearchFilterLayout.b(SearchFilterLayout.this, paramInt));
        if (SearchFilterLayout.c(SearchFilterLayout.this).isVisible())
          SearchFilterLayout.a(SearchFilterLayout.this);
      }
    });
    localView.setOnLongClickListener(this);
    return localView;
  }

  private int ch(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return -1;
    case 1:
      return 2131493323;
    case 2:
      return 2131493324;
    case 3:
      return 2131493325;
    case 5:
      return 2131493327;
    case 4:
    }
    return 2131493326;
  }

  private int ci(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 2131230978;
    case 1:
      return 2131230973;
    case 2:
      return 2131230974;
    case 3:
      return 2131230975;
    case 5:
      return 2131230976;
    case 4:
    }
    return 2131230977;
  }

  private void cj(int paramInt)
  {
    boolean bool = ck(paramInt);
    if (bool)
    {
      LY.remove(Integer.valueOf(paramInt));
      if (bool)
        break label54;
    }
    label54: for (bool = true; ; bool = false)
    {
      g(paramInt, bool);
      return;
      LY.add(Integer.valueOf(paramInt));
      break;
    }
  }

  private boolean ck(int paramInt)
  {
    return (LY != null) && (LY.contains(Integer.valueOf(paramInt)));
  }

  private void d(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.equals(paramString, "INVALID_COLOR"));
    Object localObject;
    for (int i = ColorMap.J(paramString).getValue(); ; i = -1)
    {
      localObject = ColorMap.aM(i);
      paramString = LV.getBackground();
      if ((!paramBoolean) || (i == -1))
        break label144;
      localObject = ((ColorMap.ColorPair)localObject).getKey();
      if (!TextUtils.equals((CharSequence)localObject, i.g.Co))
        break;
      LV.setImageResource(2130837678);
      paramString.setColorFilter(getContext().getResources().getColor(2131296405), PorterDuff.Mode.SRC_ATOP);
      return;
    }
    if (TextUtils.equals((CharSequence)localObject, "YELLOW"))
    {
      LV.setImageResource(2130837678);
      paramString.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    LV.setImageResource(2130837677);
    paramString.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    return;
    label144: LV.setImageResource(2130837676);
    paramString.setColorFilter(0, PorterDuff.Mode.ADD);
    e.a(LV, 0.8F);
  }

  private void g(int paramInt, boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)findViewById(ch(paramInt));
    localImageView.setSelected(paramBoolean);
    if (paramBoolean);
    for (float f = 1.0F; ; f = 0.8F)
    {
      e.a(localImageView, f);
      return;
    }
  }

  private void mA()
  {
    LX.hide();
    LV.setSelected(false);
    if (LW)
      aK(true);
  }

  private void mB()
  {
    LX.show();
    e.a(LV, 1.0F);
    LV.setSelected(LX.lZ().isEmpty());
    if (LW)
      aK(false);
  }

  public void a(a parama)
  {
    LZ = parama;
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void b(a parama)
  {
    et = parama;
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void bt(String paramString)
  {
    LO.setText(paramString);
  }

  public void bw(int paramInt)
  {
    if ((paramInt == 1) && (LQ != null))
    {
      if (!ck(paramInt))
      {
        LY.add(Integer.valueOf(paramInt));
        g(paramInt, true);
      }
      if (LZ != null)
        LZ.E(ci(paramInt));
      if (LX.isVisible())
        mA();
    }
  }

  public void e(Bundle paramBundle)
  {
    paramBundle.putStringArrayList("savedState_selected_filter_colors", (ArrayList)mG());
    paramBundle.putIntegerArrayList("outState_saved_selected_type_filters", (ArrayList)mF());
  }

  public String getQuery()
  {
    return LO.getText().toString();
  }

  public void hide()
  {
    setVisibility(8);
  }

  public boolean isShowing()
  {
    return getVisibility() == 0;
  }

  public void k(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      ArrayList localArrayList2 = paramBundle.getStringArrayList("savedState_selected_filter_colors");
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
        localArrayList1 = Lists.newArrayList();
      LY = paramBundle.getIntegerArrayList("outState_saved_selected_type_filters");
      paramBundle = localArrayList1;
      if (LY == null)
      {
        LY = Lists.newArrayList();
        paramBundle = localArrayList1;
      }
    }
    while (true)
    {
      D(paramBundle);
      return;
      paramBundle = Lists.newArrayList();
      LY = Lists.newArrayList();
    }
  }

  public void kh()
  {
    e.B(LO);
  }

  public void mC()
  {
    g(1, ck(1));
    g(2, ck(2));
    g(3, ck(3));
    g(4, ck(4));
    g(5, ck(5));
    Object localObject = LX.lZ();
    if (((List)localObject).isEmpty());
    for (localObject = "INVALID_COLOR"; ; localObject = (String)((List)localObject).get(0))
    {
      d((String)localObject, true);
      return;
    }
  }

  public void mD()
  {
    LY.clear();
    if (LX != null)
    {
      LX.clear();
      mA();
    }
    mC();
  }

  public int mE()
  {
    return mHeight;
  }

  public List<Integer> mF()
  {
    return LY;
  }

  public List<String> mG()
  {
    return LX.lZ();
  }

  public void mz()
  {
    e.A(LO);
  }

  public void onClick(View paramView)
  {
    if (paramView == Lp)
      et.kf();
    while (paramView != LP)
      return;
    LO.setText("");
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
      et.onQueryTextSubmit(LO.getText().toString());
    return false;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Lp = ((ImageView)findViewById(2131493330));
    Lp.setOnClickListener(this);
    LO = ((EditText)findViewById(2131493334));
    LO.addTextChangedListener(this);
    LO.setOnEditorActionListener(this);
    LO.setOnKeyListener(this);
    LO.setCustomSelectionActionModeCallback(new ActionMode.Callback()
    {
      public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return false;
      }

      public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }

      public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
      {
      }

      public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }
    });
    LP = ((ImageView)findViewById(2131493335));
    LP.setOnClickListener(this);
    if (KeepApplication.al())
      getLayoutTransition().enableTransitionType(4);
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 66))
      et.onQueryTextSubmit(LO.getText().toString());
    return false;
  }

  public boolean onLongClick(View paramView)
  {
    return e.C(paramView);
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = paramCharSequence.toString();
    if (et != null)
      et.onQueryTextChange(paramCharSequence);
    ImageView localImageView = LP;
    if (TextUtils.isEmpty(paramCharSequence));
    for (paramInt1 = 4; ; paramInt1 = 0)
    {
      localImageView.setVisibility(paramInt1);
      return;
    }
  }

  public void show()
  {
    setVisibility(0);
  }

  public static abstract interface a
  {
    public abstract void E(int paramInt);
  }
}