package com.google.android.keep.editor;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.browse.a;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.n;
import com.google.android.keep.model.o;
import com.google.android.keep.model.x;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.u;
import com.google.android.keep.ui.EditorRecyclerView;
import com.google.android.keep.ui.EditorRecyclerView.a;
import com.google.android.keep.util.e;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class EditorContentFragment extends u
  implements View.OnFocusChangeListener, TextView.OnEditorActionListener, ListItemsAdapter.g, ModelEventDispatcher.b, EditorRecyclerView.a
{
  private a cR;
  private o fg;
  private TreeEntityModel kJ;
  private View kP;
  private n la;
  private x lm;
  private EditorRecyclerView ln;
  private ShareeAvatarsFragment lo;
  private ViolatorFragment lp;
  private ListItemsAdapter lq;
  private g lr;
  private boolean ls;
  private RecyclerView.OnScrollListener lt = new RecyclerView.OnScrollListener()
  {
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
      if (paramAnonymousInt == 0)
        EditorContentFragment.b(EditorContentFragment.this);
    }
  };
  private ItemTouchHelper.Callback lu = new ItemTouchHelper.Callback()
  {
    public boolean canDropOver(RecyclerView paramAnonymousRecyclerView, RecyclerView.ViewHolder paramAnonymousViewHolder1, RecyclerView.ViewHolder paramAnonymousViewHolder2)
    {
      return EditorContentFragment.c(EditorContentFragment.this).an(paramAnonymousViewHolder2.getAdapterPosition());
    }

    public int getMovementFlags(RecyclerView paramAnonymousRecyclerView, RecyclerView.ViewHolder paramAnonymousViewHolder)
    {
      return makeMovementFlags(3, 0);
    }

    public boolean isItemViewSwipeEnabled()
    {
      return false;
    }

    public boolean isLongPressDragEnabled()
    {
      return false;
    }

    public boolean onMove(RecyclerView paramAnonymousRecyclerView, RecyclerView.ViewHolder paramAnonymousViewHolder1, RecyclerView.ViewHolder paramAnonymousViewHolder2)
    {
      EditorContentFragment.c(EditorContentFragment.this).l(paramAnonymousViewHolder1.getAdapterPosition(), paramAnonymousViewHolder2.getAdapterPosition());
      return true;
    }

    public void onSelectedChanged(RecyclerView.ViewHolder paramAnonymousViewHolder, int paramAnonymousInt)
    {
      super.onSelectedChanged(paramAnonymousViewHolder, paramAnonymousInt);
      if (paramAnonymousInt == 2)
        EditorContentFragment.c(EditorContentFragment.this).a(paramAnonymousViewHolder);
      while (paramAnonymousInt != 0)
        return;
      EditorContentFragment.c(EditorContentFragment.this).dS();
    }

    public void onSwiped(RecyclerView.ViewHolder paramAnonymousViewHolder, int paramAnonymousInt)
    {
    }
  };
  private int mActionBarHeight;

  private void jdMethod_do()
  {
    if (lo == null)
      lo = ((ShareeAvatarsFragment)getChildFragmentManager().findFragmentById(2131493211));
    if (lp == null)
      lp = ((ViolatorFragment)getChildFragmentManager().findFragmentById(2131493170));
    if ((lm.isActive()) && (lo != null) && (!lo.isVisible()) && (lp != null));
    for (int i = 1; i != 0; i = 0)
    {
      lp.eZ();
      return;
    }
    lp.fa();
  }

  private void dp()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getActivity().getTheme().resolveAttribute(16843499, localTypedValue, true))
      mActionBarHeight = TypedValue.complexToDimensionPixelSize(localTypedValue.data, getResources().getDisplayMetrics());
  }

  private void dq()
  {
    TitleFragment localTitleFragment = (TitleFragment)getChildFragmentManager().findFragmentById(2131493216);
    if (localTitleFragment != null)
      localTitleFragment.dq();
  }

  private void y(boolean paramBoolean)
  {
    if ((!kJ.isInitialized()) || (!kJ.iP()) || (!paramBoolean))
      return;
    lq.c((ListItem)la.gE());
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!fg.ih());
    while (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xw }))
      return;
    jdMethod_do();
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return ImmutableList.of(ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xw);
  }

  protected void dn()
  {
    if (!kJ.isInitialized())
      return;
    if (kJ.iP())
    {
      lq.c((ListItem)la.gE());
      lq.ek();
      return;
    }
    ((NoteTextEditorFragment)getChildFragmentManager().findFragmentById(2131493217)).es();
  }

  public void n(View paramView)
  {
    if (paramView == null);
    int i;
    int j;
    do
    {
      return;
      i = (int)(ln.getBottom() * 0.8F);
      j = paramView.getBottom();
    }
    while (j <= i);
    ln.smoothScrollBy(0, Math.max(paramView.getHeight(), j - i));
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    fg = new o(paramBundle, this, fO());
    la = ((n)fg.e(n.class));
    kJ = ((TreeEntityModel)fg.e(TreeEntityModel.class));
    lm = ((x)fg.e(x.class));
    cR = ((a)Binder.a(paramBundle, a.class));
    y(cR.aM().eY());
    dp();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    kP = paramLayoutInflater.inflate(2130968670, paramViewGroup, false);
    kP.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    Object localObject = new a(getActivity());
    ((LinearLayoutManager)localObject).setOrientation(1);
    ln = ((EditorRecyclerView)kP.findViewById(2131493169));
    ln.setHasFixedSize(true);
    ln.setLayoutManager((RecyclerView.LayoutManager)localObject);
    ln.setItemAnimator(null);
    ln.a(this);
    ln.setOnScrollListener(lt);
    ln.setOnFocusChangeListener(this);
    localObject = paramLayoutInflater.inflate(2130968694, paramViewGroup, false);
    ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    paramLayoutInflater = paramLayoutInflater.inflate(2130968693, paramViewGroup, false);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    lq = new ListItemsAdapter(getActivity(), se);
    lq.h(paramBundle);
    lq.setHasStableIds(true);
    lq.a(this);
    lq.x(ls);
    lr = new g((View)localObject, paramLayoutInflater, lq);
    lr.setHasStableIds(true);
    paramLayoutInflater = new ItemTouchHelper(lu);
    paramLayoutInflater.attachToRecyclerView(ln);
    lq.a(paramLayoutInflater);
    ln.setAdapter(lr);
    return kP;
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 5) && (paramTextView.getId() == 2131493226))
    {
      dn();
      return true;
    }
    return false;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramView instanceof EditText)))
      dq();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    lq.onSaveInstanceState(paramBundle);
  }

  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = ln.getFocusedChild();
    if (localView == null);
    while ((paramInt2 - paramInt4 >= 0) || (localView.getTop() <= paramInt2))
      return;
    if (localView.getHeight() > paramInt2);
    for (paramInt1 = localView.getTop() - paramInt2; ; paramInt1 = localView.getBottom() - paramInt2)
    {
      ln.scrollBy(0, paramInt1);
      localView.requestFocus();
      return;
    }
  }

  public void x(boolean paramBoolean)
  {
    ls = paramBoolean;
    ((NoteTextEditorFragment)getChildFragmentManager().findFragmentById(2131493217)).x(ls);
    if (lq != null)
    {
      lq.x(ls);
      lr.notifyDataSetChanged();
    }
  }

  public class a extends LinearLayoutManager
  {
    public a(Context arg2)
    {
      super();
    }

    public void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
    {
      try
      {
        super.removeAndRecycleViewAt(paramInt, paramRecycler);
        return;
      }
      catch (IllegalArgumentException paramRecycler)
      {
        Log.e("EditorContentFragment", "Recycler view crashes if you recycle any item with focus.", paramRecycler);
        e.B(getView());
      }
    }

    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      int i1 = getPaddingLeft();
      int j = getPaddingTop();
      int i2 = getWidth() - getPaddingRight();
      int m = getHeight();
      int i5 = getPaddingBottom();
      int i3 = paramView.getLeft() + paramRect.left;
      int n = paramView.getTop() + paramRect.top;
      int i4 = i3 + paramRect.width();
      int i6 = paramRect.height();
      int i = Math.min(0, i3 - i1);
      int k = Math.max(0, i4 - i2);
      m = Math.max(0, n + i6 - (m - i5));
      n = n - j - EditorContentFragment.a(EditorContentFragment.this);
      j = Math.min(0, n);
      if (getLayoutDirection() == 1)
        if (k != 0)
        {
          i = k;
          if (j == 0)
            break label219;
          label156: if ((i == 0) && (j == 0))
            break label242;
          if (!paramBoolean)
            break label231;
          paramRecyclerView.scrollBy(i, j);
        }
      while (true)
      {
        return true;
        i = Math.max(i, i4 - i2);
        break;
        if (i != 0)
          break;
        while (true)
          i = Math.min(i3 - i1, k);
        label219: j = Math.min(n, m);
        break label156;
        label231: paramRecyclerView.smoothScrollBy(i, j);
      }
      label242: return false;
    }
  }
}