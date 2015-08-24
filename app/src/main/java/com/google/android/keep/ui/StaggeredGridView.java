package com.google.android.keep.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.keep.util.D;
import com.google.android.keep.util.r;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StaggeredGridView extends ViewGroup
{
  private static final String TAG = "Keep-" + StaggeredGridView.class.getSimpleName();
  private final int MW = 10;
  private SgvAnimationHelper.AnimationIn MX = SgvAnimationHelper.AnimationIn.Mh;
  private SgvAnimationHelper.AnimationOut MY = SgvAnimationHelper.AnimationOut.Mp;
  private AnimatorSet MZ = null;
  private e NA;
  private int NB;
  private int NC;
  private int ND;
  private int NE;
  private int NF;
  private Point NG = new Point();
  private Rect NH;
  private ObjectAnimator NI;
  private int NJ;
  private int NK;
  private int NL;
  private int NM;
  private BitmapDrawable NN;
  private final int NO;
  private v NP;
  private boolean NQ = true;
  private final Map<Long, i> NR = new HashMap();
  private final SparseArrayCompat<c> NS = new SparseArrayCompat();
  private Handler NT;
  private boolean NU;
  private final Runnable NV = new Runnable()
  {
    public void run()
    {
      if (StaggeredGridView.a(StaggeredGridView.this) == 0)
        return;
      boolean bool2 = true;
      boolean bool1;
      if (StaggeredGridView.b(StaggeredGridView.this) >= StaggeredGridView.c(StaggeredGridView.this))
      {
        bool1 = bool2;
        if (StaggeredGridView.a(StaggeredGridView.this, -10, false))
          bool1 = false;
      }
      while (true)
      {
        StaggeredGridView.e(StaggeredGridView.this).aL(bool1);
        StaggeredGridView.f(StaggeredGridView.this).postDelayed(this, 5L);
        return;
        bool1 = bool2;
        if (StaggeredGridView.b(StaggeredGridView.this) <= StaggeredGridView.d(StaggeredGridView.this))
        {
          bool1 = bool2;
          if (StaggeredGridView.a(StaggeredGridView.this, 10, false))
            bool1 = false;
        }
      }
    }
  };
  boolean Na = false;
  private int Nb = 2;
  private int Nc = 2;
  private int Nd = 0;
  private int Ne = 0;
  private int[] Nf;
  private int[] Ng;
  private boolean Nh;
  private boolean Ni;
  private boolean Nj;
  private final f Nk = new f(null);
  private final a Nl = new a(null);
  private boolean Nm;
  private final List<View> Nn = Lists.newArrayList();
  private long No;
  private ScrollState Np;
  private final int Nq;
  private float Nr;
  private int Ns;
  private final w Nt;
  private final EdgeEffectCompat Nu;
  private final EdgeEffectCompat Nv;
  private boolean Nw;
  private h Nx;
  private d Ny;
  private int Nz;
  private h gQ;
  private int hP;
  private float lj = 0.0F;
  private int mActivePointerId;
  private boolean mDataChanged;
  private int mDragState;
  private View mEmptyView;
  private int mFirstPosition;
  private boolean mHasStableIds;
  private int mHeight;
  private boolean mInLayout;
  private int mItemCount;
  private final int mMaximumVelocity;
  private boolean mSmoothScrollbarEnabled = false;
  private final Rect mTempRect = new Rect();
  private final int mTouchSlop;
  private final VelocityTracker mVelocityTracker = VelocityTracker.obtain();

  public StaggeredGridView(Context paramContext)
  {
    this(paramContext, null);
  }

  public StaggeredGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public StaggeredGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    mTouchSlop = paramAttributeSet.getScaledTouchSlop();
    mMaximumVelocity = paramAttributeSet.getScaledMaximumFlingVelocity();
    Nq = paramAttributeSet.getScaledMinimumFlingVelocity();
    Nt = new w(paramContext);
    Nu = new EdgeEffectCompat(paramContext);
    Nv = new EdgeEffectCompat(paramContext);
    setWillNotDraw(false);
    setClipToPadding(false);
    SgvAnimationHelper.E(paramContext);
    mDragState = 0;
    Nw = true;
    NO = ViewConfiguration.get(paramContext).getScaledOverflingDistance();
    setMotionEventSplittingEnabled(false);
  }

  private void B(int paramInt1, int paramInt2)
  {
    mFirstPosition = paramInt1;
    if ((Nf == null) || (Ng == null))
    {
      Nf = new int[Nc];
      Ng = new int[Nc];
    }
    cu(paramInt2);
  }

  private List<Animator> F(List<Animator> paramList)
  {
    int j = getChildCount();
    if (j == 0)
      return null;
    Object localObject = paramList;
    if (paramList == null)
      localObject = Lists.newArrayList();
    int i = 0;
    while (i < j)
    {
      paramList = getChildAt(i);
      float f2 = getHeight();
      float f1 = 25.0F;
      if (Na)
      {
        f2 = paramList.getTranslationY();
        f1 = paramList.getRotation();
      }
      SgvAnimationHelper.a((List)localObject, paramList, 0, (int)f2, f1, i * 50);
      i += 1;
    }
    return localObject;
  }

  private c a(int paramInt, View paramView, b paramb)
  {
    c localc = new c(null);
    NS.put(paramInt, localc);
    localc.column = paramb.column;
    localc.height = paramView.getHeight();
    localc.id = paramb.id;
    localc.span = Math.min(Nc, paramb.span);
    return localc;
  }

  private List<Animator> a(List<Animator> paramList, boolean paramBoolean, SgvAnimationHelper.AnimationIn paramAnimationIn, int paramInt)
  {
    int n = getChildCount();
    if (n == 0)
      return null;
    Object localObject1 = paramList;
    if (paramList == null)
      localObject1 = Lists.newArrayList();
    int j = 0;
    int i = 0;
    if (i < n)
    {
      paramList = getChildAt(i);
      int k;
      if (Nn.contains(paramList))
        k = j;
      label107: int m;
      Object localObject2;
      int i1;
      int i2;
      float f;
      do
      {
        do
        {
          i += 1;
          j = k;
          break;
          k = j;
        }
        while (!gQ.S(mFirstPosition + i));
        if (!paramBoolean)
          break label290;
        k = j * 50;
        m = paramInt + k;
        localObject2 = (b)paramList.getLayoutParams();
        i locali = (i)NR.get(Long.valueOf(((b)localObject2).id));
        if ((locali == null) || (locali.rect == null))
          break label338;
        localObject2 = locali.rect;
        i1 = ((Rect)localObject2).left - paramList.getLeft();
        i2 = ((Rect)localObject2).top - paramList.getTop();
        f = paramList.getRotation();
        paramList.setTranslationX(i1);
        paramList.setTranslationY(i2);
        if ((i1 != 0) || (i2 != 0))
          break label230;
        k = j;
      }
      while (f == 0.0F);
      label230: switch (6.Oa[gQ.L(mFirstPosition + i).ordinal()])
      {
      default:
        SgvAnimationHelper.a((List)localObject1, paramList, i1, i2, f, 0);
      case 1:
      }
      while (true)
      {
        label281: k = j + 1;
        break;
        label290: k = 0;
        break label107;
        paramList.setAlpha(0.0F);
        SgvAnimationHelper.a((List)localObject1, paramList, i1, i2, f, 0);
        SgvAnimationHelper.a((List)localObject1, paramList, 0.0F, 1.0F, 0);
        SgvAnimationHelper.a((List)localObject1, paramList, SgvAnimationHelper.mI() + m);
        continue;
        label338: if (paramAnimationIn == SgvAnimationHelper.AnimationIn.Ml);
        for (k = getHeight(); ; k = 0)
        {
          i1 = m + SgvAnimationHelper.mI();
          paramList.setTranslationX(0);
          paramList.setTranslationY(k);
          switch (6.NY[paramAnimationIn.ordinal()])
          {
          default:
            k = j;
            break;
          case 2:
          case 3:
            if (i != 0)
              break label532;
            paramList.setAlpha(0.0F);
            SgvAnimationHelper.a((List)localObject1, paramList, 0, paramList.getHeight() * -1, i1);
            SgvAnimationHelper.a((List)localObject1, paramList, 0.0F, 1.0F, i1);
            break label281;
          case 5:
          case 4:
          case 6:
          }
        }
        SgvAnimationHelper.a((List)localObject1, paramList, 0, k, 25.0F, i1);
        continue;
        m = (int)(paramList.getWidth() * 1.5D);
        k = m;
        if (((b)localObject2).column < Nc / 2)
          k = -m;
        SgvAnimationHelper.b((List)localObject1, paramList, k, i1);
        continue;
        label532: SgvAnimationHelper.a((List)localObject1, paramList, i1);
        continue;
        SgvAnimationHelper.a((List)localObject1, paramList, 0.0F, 1.0F, i1);
      }
    }
    return localObject1;
  }

  private void a(ScrollState paramScrollState)
  {
    if ((gQ == null) || (paramScrollState == null) || (gQ.getCount() == 0))
      return;
    r.a(TAG, "[restoreScrollPosition] " + paramScrollState, new Object[0]);
    int k = 0;
    int m = paramScrollState.getAdapterPosition();
    int n = gQ.getCount();
    int j = 0;
    while (true)
    {
      int i = k;
      long l;
      if (j < 10)
      {
        if (m + j >= n)
          break label166;
        l = gQ.getItemId(m + j);
        if ((l == -1L) || (l != paramScrollState.getItemId()))
          break label166;
      }
      for (i = m + j; ; i = m - j)
      {
        k = paramScrollState.getVerticalOffset() - Ne;
        j = k;
        if (i == 0)
          j = k + getPaddingTop();
        B(i, j);
        Np = null;
        return;
        label166: if ((m - j < 0) || (m - j >= n))
          break;
        l = gQ.getItemId(m - j);
        if ((l == -1L) || (l != paramScrollState.getItemId()))
          break;
      }
      j += 1;
    }
  }

  private void a(b paramb)
  {
    if (paramb.column == Nc - 1);
    for (boolean bool = true; ; bool = false)
    {
      paramb.Ob = gQ.a(paramb.position, bool);
      return;
    }
  }

  private void a(List<Animator> paramList, SgvAnimationHelper.AnimationIn paramAnimationIn, int paramInt)
  {
    if (paramAnimationIn == SgvAnimationHelper.AnimationIn.Mh)
      return;
    switch (6.NY[paramAnimationIn.ordinal()])
    {
    default:
      throw new IllegalStateException("Unknown animationInMode: " + MX);
    case 1:
      F(paramList);
      return;
    case 2:
      a(paramList, true, SgvAnimationHelper.AnimationIn.Mj, paramInt);
      return;
    case 3:
      a(paramList, false, SgvAnimationHelper.AnimationIn.Mk, paramInt);
      return;
    case 4:
      a(paramList, true, SgvAnimationHelper.AnimationIn.Mm, paramInt);
      return;
    case 5:
      a(paramList, true, SgvAnimationHelper.AnimationIn.Ml, paramInt);
      return;
    case 6:
    }
    a(paramList, true, SgvAnimationHelper.AnimationIn.Mn, paramInt);
  }

  private void a(List<Animator> paramList, SgvAnimationHelper.AnimationOut paramAnimationOut)
  {
    if (paramAnimationOut == SgvAnimationHelper.AnimationOut.Mp);
    Iterator localIterator;
    do
    {
      return;
      localIterator = Nn.iterator();
    }
    while (!localIterator.hasNext());
    View localView = (View)localIterator.next();
    ArrayList localArrayList = Lists.newArrayList();
    switch (6.NZ[paramAnimationOut.ordinal()])
    {
    default:
      throw new IllegalStateException("Unknown animationOutMode: " + paramAnimationOut);
    case 1:
      b localb = (b)localView.getLayoutParams();
      int j = (int)(localView.getWidth() * 1.5D);
      int i = j;
      if (localb.column < Nc / 2)
        i = -j;
      SgvAnimationHelper.c(localArrayList, localView, (int)localView.getTranslationX(), i);
    case 2:
    case 3:
    case 4:
    }
    while (localArrayList.size() > 0)
    {
      b(localView, localArrayList);
      paramList.addAll(localArrayList);
      break;
      SgvAnimationHelper.a(localArrayList, localView);
      continue;
      SgvAnimationHelper.a(localArrayList, localView, (int)localView.getTranslationY(), getHeight());
      continue;
      SgvAnimationHelper.a(localArrayList, localView, localView.getAlpha(), 0.0F);
    }
  }

  private void b(final View paramView, List<Animator> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
        ((Animator)paramList.next()).addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramAnonymousAnimator = (StaggeredGridView.b)paramView.getLayoutParams();
            if (StaggeredGridView.h(StaggeredGridView.this).containsKey(Long.valueOf(paramAnonymousAnimator.id)))
              StaggeredGridView.h(StaggeredGridView.this).remove(Long.valueOf(paramAnonymousAnimator.id));
            StaggeredGridView.a(StaggeredGridView.this, paramView);
          }
        });
    }
  }

  private void cq(int paramInt)
  {
    mHeight = getHeight();
    NL = Math.min(paramInt - mTouchSlop, mHeight / 5);
    NM = Math.max(mTouchSlop + paramInt, mHeight * 4 / 5);
  }

  private void cr(int paramInt)
    throws IllegalStateException
  {
    int k = 0;
    int i = 0;
    mDragState = paramInt;
    int j = k;
    switch (paramInt)
    {
    default:
      throw new IllegalStateException("Illegal drag state: " + mDragState);
    case 0:
    case 1:
      j = 1;
      i = 1;
    case 2:
    case 3:
    }
    while (true)
    {
      if ((j != 0) && (NP.mO() != null))
        NP.mQ();
      if (i != 0)
      {
        if (NN != null)
        {
          NN.getBitmap().recycle();
          NN = null;
        }
        NP.mP();
        NP.mL();
      }
      return;
      i = 1;
      j = k;
    }
  }

  private void ct(int paramInt)
  {
    if ((paramInt != Nz) && (Nx != null))
    {
      Nz = paramInt;
      Nx.a(this, paramInt);
    }
  }

  private void cu(int paramInt)
  {
    if ((mFirstPosition != 0) && ((!Nm) || (mFirstPosition < hP)))
      System.arraycopy(Nf, 0, Ng, 0, Nc);
    while (true)
    {
      return;
      int i2 = (getWidth() - getPaddingLeft() - getPaddingRight() - Ne * (Nc - 1)) / Nc;
      Arrays.fill(Nf, getPaddingTop());
      Arrays.fill(Ng, getPaddingTop());
      if (mDataChanged)
        NS.clear();
      int k = 0;
      while (k < mFirstPosition)
      {
        c localc2 = (c)NS.get(k);
        c localc1;
        b localb;
        if (!mDataChanged)
        {
          localc1 = localc2;
          if (localc2 != null);
        }
        else
        {
          View localView = b(k, null);
          localb = (b)localView.getLayoutParams();
          if (localb.height != -2)
            break label435;
          i = View.MeasureSpec.makeMeasureSpec(0, 0);
          j = Math.min(Nc, localb.span);
          localView.measure(View.MeasureSpec.makeMeasureSpec(i2 * j + Ne * (j - 1), 1073741824), i);
          i = localView.getMeasuredHeight();
          localc1 = localc2;
          if (localc2 == null)
          {
            localc1 = new c(null);
            NS.put(k, localc1);
          }
          localc1.height = i;
          localc1.id = localb.id;
          localc1.span = j;
          Nk.z(localView);
        }
        j = nh();
        i = j;
        if (localc1.span > 1)
        {
          if (!Nj)
            break label450;
          i = j;
          if (j + 1 < localc1.span)
            i = Nc - 1;
        }
        label337: localc1.column = i;
        j = Ng[i] + Ne;
        int m = j;
        int n;
        if (localc1.span > 1)
        {
          n = 0;
          label370: m = j;
          if (n < localc1.span)
          {
            if (Nj);
            for (m = i - n; ; m = i + n)
            {
              int i1 = Ng[m] + Ne;
              m = j;
              if (i1 > j)
                m = i1;
              n += 1;
              j = m;
              break label370;
              label435: i = View.MeasureSpec.makeMeasureSpec(localb.height, 1073741824);
              break;
              label450: i = j;
              if (Nc - j >= localc1.span)
                break label337;
              i = 0;
              break label337;
            }
          }
        }
        j = 0;
        while (j < localc1.span)
        {
          if (Nj);
          for (n = i - j; ; n = i + j)
          {
            Ng[n] = (localc1.height + m);
            if (!r.isLoggable(TAG, 2))
              break;
            Log.v(TAG, " position: " + k + " bottoms: ");
            n = 0;
            while (n < Nc)
            {
              Log.v(TAG, "    mItemBottoms[" + n + "]: " + Ng[n]);
              n += 1;
            }
          }
          j += 1;
        }
        k += 1;
      }
      int i = 2147483647;
      int j = 0;
      while (j < Nc)
      {
        k = i;
        if (Ng[j] < i)
          k = Ng[j];
        j += 1;
        i = k;
      }
      j = 0;
      while (j < Nc)
      {
        Ng[j] = (Ng[j] - i + paramInt);
        Nf[j] = Ng[j];
        r.a(TAG, "Adjusting to offset = mItemBottoms[" + j + "]: " + Ng[j], new Object[0]);
        j += 1;
      }
    }
  }

  private int cx(int paramInt)
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight() - Ne * (Nc - 1)) / Nc * paramInt + Ne * (paramInt - 1);
  }

  private void d(View paramView, int paramInt1, int paramInt2)
  {
    if (!mX())
      return;
    cr(1);
    b localb = (b)paramView.getLayoutParams();
    NN = gQ.a(localb.position, paramView);
    if (NN == null)
    {
      NP.u(paramView);
      cr(0);
      return;
    }
    NE = (paramInt1 - paramView.getLeft());
    NF = (paramInt2 - paramView.getTop());
    NG.x = paramView.getLeft();
    NG.y = paramView.getTop();
    NJ = paramView.getWidth();
    NK = paramView.getHeight();
    NH = new Rect(NG.x, NG.y, NG.x + NJ, NG.y + NK);
    NN.setBounds(NH);
    invalidate();
    cq(paramInt2);
    NP.a(paramView, localb.position, localb.id);
  }

  private boolean h(int paramInt, boolean paramBoolean)
  {
    boolean bool = mZ();
    int m = Math.abs(paramInt);
    int j;
    int k;
    int i;
    if (!bool)
    {
      Ni = true;
      if (paramInt > 0)
      {
        j = x(mFirstPosition - 1, m);
        k = 1;
        i = Math.min(j, m);
        if (k == 0)
          break label196;
        k = i;
        label59: offsetChildren(k);
        na();
        Ni = false;
        j = m - j;
        label81: if (paramBoolean)
        {
          k = ViewCompat.getOverScrollMode(this);
          if (((k == 0) || ((k == 1) && (!bool))) && (j > 0))
            if (paramInt <= 0)
              break label212;
        }
      }
    }
    label196: label212: for (EdgeEffectCompat localEdgeEffectCompat = Nu; ; localEdgeEffectCompat = Nv)
    {
      localEdgeEffectCompat.onPull(Math.abs(paramInt) / getHeight());
      ViewCompat.postInvalidateOnAnimation(this);
      awakenScrollBars(0, true);
      if ((paramInt != 0) && (i == 0))
        break label221;
      return true;
      j = y(mFirstPosition + getChildCount(), m);
      i = j;
      if (j < 0)
        i = 0;
      k = 0;
      j = i;
      break;
      k = -i;
      break label59;
      j = m;
      i = 0;
      break label81;
    }
    label221: return false;
  }

  @SuppressLint({"NewApi"})
  private boolean isLayoutRtl()
  {
    if (Build.VERSION.SDK_INT >= 17)
      return 1 == getLayoutDirection();
    return false;
  }

  private boolean isWithinDeltaOfScreen(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(mTempRect);
    offsetDescendantRectToMyCoords(paramView, mTempRect);
    return (mTempRect.bottom + paramInt1 >= getScrollY()) && (mTempRect.top - paramInt1 <= getScrollY() + paramInt2);
  }

  private boolean mX()
  {
    return (Nw) && (NP != null) && (NP.mS());
  }

  private void mY()
  {
    Nu.finish();
    Nv.finish();
    Nt.abortAnimation();
  }

  private void na()
  {
    if (getChildCount() == 0)
      return;
    int j = getHeight();
    int k = -Ne;
    int m = Ne;
    int i = getChildCount() - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = getChildAt(i);
      if (((View)localObject).getTop() > j + m);
    }
    else
    {
      if (getChildCount() > 0)
      {
        localObject = getChildAt(0);
        if (((View)localObject).getBottom() < k)
          break label346;
      }
      m = getChildCount();
      if (m <= 0)
        break label460;
      Arrays.fill(Nf, 2147483647);
      Arrays.fill(Ng, -2147483648);
      i = 0;
    }
    while (true)
    {
      if (i >= m)
        break label412;
      View localView = getChildAt(i);
      b localb = (b)localView.getLayoutParams();
      int n = localView.getTop();
      int i1 = Ne;
      int i2 = localView.getBottom();
      c localc = (c)NS.get(mFirstPosition + i);
      localObject = localc;
      if (localc == null)
        localObject = a(mFirstPosition + i, localView, localb);
      int i3 = Math.min(Nc, localb.span);
      j = 0;
      label213: if (j < i3)
      {
        if (Nj);
        for (k = localb.column - j; ; k = localb.column + j)
        {
          int i4 = n - i1 - ((c)localObject).cz(j);
          int i5 = i2 + ((c)localObject).cA(j);
          if (i4 < Nf[k])
            Nf[k] = i4;
          if (i5 > Ng[k])
            Ng[k] = i5;
          j += 1;
          break label213;
          ((View)localObject).clearFocus();
          if (mInLayout)
            removeViewsInLayout(i, 1);
          while (true)
          {
            Nk.z((View)localObject);
            i -= 1;
            break;
            removeViewAt(i);
          }
          label346: ((View)localObject).clearFocus();
          if (mInLayout)
            removeViewsInLayout(0, 1);
          while (true)
          {
            Nk.z((View)localObject);
            mFirstPosition += 1;
            break;
            removeViewAt(0);
          }
        }
      }
      i += 1;
    }
    label412: i = 0;
    while (i < Nc)
    {
      if (Nf[i] == 2147483647)
      {
        j = getPaddingTop();
        Nf[i] = j;
        Ng[i] = j;
      }
      i += 1;
    }
    label460: Np = nn();
  }

  private void nb()
  {
    int j = 1;
    if (Nt.computeScrollOffset())
    {
      int k = getScrollY();
      int m = Nt.getCurrY();
      if (overScrollBy(0, m - k, 0, k, 0, 0, 0, NO, false))
      {
        int i;
        if ((k <= 0) && (m > 0))
        {
          i = 1;
          if ((k < 0) || (m >= 0))
            break label94;
        }
        while (true)
        {
          if ((i == 0) && (j == 0))
            break label99;
          Ns = 0;
          Nt.abortAnimation();
          return;
          i = 0;
          break;
          label94: j = 0;
        }
        label99: if (Nt.springBack(0, k, 0, 0, 0, 0))
        {
          Ns = 3;
          ViewCompat.postInvalidateOnAnimation(this);
          return;
        }
        Ns = 0;
        return;
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    Ns = 0;
    Nt.abortAnimation();
  }

  private void nc()
  {
    if ((gQ == null) || (gQ.isEmpty()))
      if (mEmptyView != null)
        mEmptyView.setVisibility(0);
    while (mEmptyView == null)
    {
      return;
      setVisibility(0);
      return;
    }
    mEmptyView.setVisibility(8);
  }

  private void nd()
    throws IllegalStateException
  {
    ArrayList localArrayList = Lists.newArrayList();
    a(localArrayList, MY);
    int i;
    if (localArrayList.size() > 0)
    {
      i = SgvAnimationHelper.mI() / 2;
      a(localArrayList, MX, i);
      if ((localArrayList == null) || (localArrayList.size() <= 0))
        break label134;
      Object localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).setDuration(0L);
      localArrayList.add(0, localObject);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(localArrayList);
      ((AnimatorSet)localObject).addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          Na = true;
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!Na)
            StaggeredGridView.g(StaggeredGridView.this);
          StaggeredGridView.a(StaggeredGridView.this, null);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          Na = false;
          StaggeredGridView.a(StaggeredGridView.this, NX);
        }
      });
      ((AnimatorSet)localObject).start();
    }
    while (true)
    {
      Nn.clear();
      NR.clear();
      return;
      i = 0;
      break;
      label134: ne();
    }
  }

  private void ne()
  {
    MX = SgvAnimationHelper.AnimationIn.Mh;
    MY = SgvAnimationHelper.AnimationOut.Mp;
  }

  private void nf()
  {
    int j = getChildCount();
    NR.clear();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      b localb = (b)localView.getLayoutParams();
      int k = (int)localView.getY();
      int m = localView.getHeight();
      int n = (int)localView.getX();
      Rect localRect = new Rect(n, k, n + localView.getWidth(), k + m);
      NR.put(Long.valueOf(localb.id), new i(localView, localRect));
      i += 1;
    }
  }

  private void nj()
  {
    NS.clear();
    removeAllViews();
    Nf = null;
    Ng = null;
    nk();
    Nk.clear();
    lj = 0.0F;
    hP = 0;
  }

  private boolean nm()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Np != null)
    {
      bool1 = bool2;
      if (Np.getAdapterPosition() == 0)
      {
        bool1 = bool2;
        if (Np.getVerticalOffset() == Ne)
          bool1 = true;
      }
    }
    return bool1;
  }

  private void offsetChildren(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = getChildAt(i);
      ((View)localObject).offsetTopAndBottom(paramInt);
      a((b)((View)localObject).getLayoutParams());
      i += 1;
    }
    j = Nc;
    i = 0;
    while (i < j)
    {
      localObject = Nf;
      localObject[i] += paramInt;
      localObject = Ng;
      localObject[i] += paramInt;
      i += 1;
    }
    if (Nx != null)
      Nx.a(paramInt, computeVerticalScrollOffset(), computeVerticalScrollRange());
  }

  private void populate()
  {
    if ((getWidth() == 0) || (getHeight() == 0) || (gQ == null))
      return;
    if (Nc == -1)
    {
      i = getWidth() / Nd;
      if (i != Nc)
        Nc = i;
    }
    int i = Nc;
    if ((Nf == null) || (Ng == null) || (Nf.length != i) || (Ng.length != i))
    {
      Nf = new int[i];
      Ng = new int[i];
      NS.clear();
      if (mInLayout)
        removeAllViewsInLayout();
    }
    else
    {
      if ((mDataChanged) && (MZ != null))
      {
        MZ.cancel();
        MZ = null;
      }
      if (nm())
        Np = null;
      if (Np == null)
        break label327;
      a(Np);
    }
    while (true)
    {
      Ni = true;
      No = -1L;
      View localView = getFocusedChild();
      if (localView != null)
        No = ((b)localView.getLayoutParams()).id;
      aN(mDataChanged);
      y(mFirstPosition + getChildCount(), 0);
      x(mFirstPosition - 1, 0);
      if ((mX()) && ((NI == null) || (!NI.isRunning())) && ((mDragState == 2) || (mDragState == 3)))
      {
        cr(0);
        invalidate();
      }
      if (mDataChanged)
        nd();
      na();
      Ni = false;
      mDataChanged = false;
      return;
      removeAllViews();
      break;
      label327: cu(getPaddingTop());
    }
  }

  private void recycleView(View paramView)
  {
    if (paramView == null)
      return;
    if (mInLayout)
    {
      removeViewInLayout(paramView);
      invalidate();
    }
    while (true)
    {
      Nk.z(paramView);
      return;
      removeView(paramView);
    }
  }

  private View s(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0);
    while (true)
    {
      return null;
      Rect localRect = new Rect();
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        getChildAt(i).getHitRect(localRect);
        if (localRect.contains(paramInt1, paramInt2))
          return getChildAt(i);
        i += 1;
      }
    }
  }

  private boolean scrollToChildRect(Rect paramRect, boolean paramBoolean)
  {
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0);
    for (paramBoolean = true; ; paramBoolean = false)
    {
      if (paramBoolean)
        scrollBy(0, i);
      return paramBoolean;
    }
  }

  private void t(int paramInt1, int paramInt2)
  {
    int i = gQ.cq();
    if ((i & 0x1) == 1)
      NG.x = (paramInt1 - NE);
    if ((i & 0x2) == 2)
      NG.y = (paramInt2 - NF);
    NH.offsetTo(NG.x, NG.y);
    NN.setBounds(NH);
    invalidate();
  }

  private void u(int paramInt1, int paramInt2)
  {
    if (mDragState != 1);
    do
    {
      return;
      t(paramInt1, paramInt2);
      invalidate();
    }
    while (MZ != null);
    NP.a(new Point(paramInt1, paramInt2));
  }

  private void v(int paramInt1, int paramInt2)
  {
    if (!NP.mS())
      cr(0);
    View localView;
    do
    {
      return;
      if (NP.mM())
      {
        t(paramInt1, paramInt2);
        if ((getChildCount() > 0) && (((b)getChildAt(0).getLayoutParams()).position > NP.mR()))
          mFirstPosition -= 1;
        Np = nn();
      }
      localView = NP.mK();
    }
    while ((localView == null) || (mDragState != 1));
    cr(2);
    NH.offsetTo(localView.getLeft(), localView.getTop());
    NI = ObjectAnimator.ofObject(NN, "bounds", SgvAnimationHelper.mH(), new Object[] { NH });
    NI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        invalidate();
      }
    });
    NI.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        StaggeredGridView.e(StaggeredGridView.this).mO().setVisibility(0);
        StaggeredGridView.e(StaggeredGridView.this).mJ();
        setEnabled(true);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        setEnabled(false);
      }
    });
    NI.start();
  }

  private void w(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= paramInt1)
    {
      View localView = getChildAt(paramInt2);
      if (mInLayout)
        removeViewsInLayout(paramInt2, 1);
      while (true)
      {
        Nk.z(localView);
        paramInt2 -= 1;
        break;
        removeViewAt(paramInt2);
      }
    }
  }

  final c A(int paramInt1, int paramInt2)
  {
    c localc2 = (c)NS.get(paramInt1);
    c localc1;
    if (localc2 != null)
    {
      localc1 = localc2;
      if (localc2.span == paramInt2);
    }
    else
    {
      if (paramInt2 > Nc)
        throw new IllegalStateException("Span larger than column count! Span:" + paramInt2 + " ColumnCount:" + Nc);
      localc1 = new c(null);
      localc1.span = paramInt2;
      NS.put(paramInt1, localc1);
    }
    int j = -1;
    int i = 2147483647;
    int i2 = Nc;
    int k;
    int m;
    int i1;
    int n;
    if (Nj)
    {
      paramInt1 = i2 - 1;
      while (true)
      {
        k = j;
        m = i;
        if (paramInt1 < paramInt2 - 1)
          break;
        k = -2147483648;
        m = paramInt1;
        while (m > paramInt1 - paramInt2)
        {
          i1 = Ng[m];
          n = k;
          if (i1 > k)
            n = i1;
          m -= 1;
          k = n;
        }
        m = i;
        if (k < i)
        {
          j = paramInt1;
          m = k;
        }
        paramInt1 -= 1;
        i = m;
      }
    }
    paramInt1 = 0;
    while (true)
    {
      k = j;
      m = i;
      if (paramInt1 > i2 - paramInt2)
        break;
      k = -2147483648;
      m = paramInt1;
      while (m < paramInt1 + paramInt2)
      {
        i1 = Ng[m];
        n = k;
        if (i1 > k)
          n = i1;
        m += 1;
        k = n;
      }
      m = i;
      if (k < i)
      {
        j = paramInt1;
        m = k;
      }
      paramInt1 += 1;
      i = m;
    }
    localc1.column = k;
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      if (Nj);
      for (i = k - paramInt1; ; i = k + paramInt1)
      {
        localc1.C(paramInt1, m - Ng[i]);
        paramInt1 += 1;
        break;
      }
    }
    return localc1;
  }

  protected b a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new b(paramLayoutParams);
  }

  public void a(SgvAnimationHelper.AnimationIn paramAnimationIn, SgvAnimationHelper.AnimationOut paramAnimationOut)
  {
    MX = paramAnimationIn;
    MY = paramAnimationOut;
  }

  public void a(e parame)
  {
    NA = parame;
  }

  public void a(g paramg)
  {
    NP = new v(paramg, this);
  }

  public void a(h paramh)
  {
    Nx = paramh;
  }

  public void a(h paramh)
  {
    if (gQ != null)
      gQ.unregisterDataSetObserver(Nl);
    nj();
    gQ = paramh;
    mDataChanged = true;
    int i;
    if (paramh != null)
    {
      i = paramh.getCount();
      mItemCount = i;
      if (paramh == null)
        break label99;
      paramh.registerDataSetObserver(Nl);
      Nk.cB(paramh.getViewTypeCount());
    }
    label99: for (mHasStableIds = paramh.hasStableIds(); ; mHasStableIds = false)
    {
      if (mX())
        cr(0);
      nc();
      return;
      i = 0;
      break;
    }
  }

  public void a(h paramh, ScrollState paramScrollState)
  {
    a(paramh);
    Np = paramScrollState;
  }

  public void aM(boolean paramBoolean)
  {
    Nm = paramBoolean;
  }

  final void aN(boolean paramBoolean)
  {
    int i4 = getPaddingLeft();
    int i5 = getPaddingRight();
    int i6 = Ne;
    int i7 = getWidth() - i4 - i5 - (Nc - 1) * i6;
    int i8 = i7 / Nc;
    int i9 = Nc;
    int i = 0;
    int m;
    int k;
    int j;
    label94: label111: int n;
    label114: int i10;
    Object localObject3;
    if (MY != SgvAnimationHelper.AnimationOut.Mp)
    {
      m = 1;
      if (m != 0)
        break label212;
      k = getChildCount();
      if (mItemCount > mFirstPosition)
        break label199;
      j = 0;
      if (k > j)
      {
        w(j, k - 1);
        i = 1;
      }
      n = 0;
      if (n >= getChildCount())
        break label1045;
      i10 = mFirstPosition + n;
      localObject3 = getChildAt(n);
      j = Ng[nh()];
      if ((m == 0) || ((i10 < mItemCount) && (j < getHeight())))
        break label224;
      Nn.add(localObject3);
    }
    while (true)
    {
      n += 1;
      break label114;
      m = 0;
      break;
      label199: j = mItemCount - mFirstPosition;
      break label94;
      label212: Nn.clear();
      break label111;
      label224: Object localObject1 = null;
      j = -1;
      if (localObject3 != null)
      {
        localObject1 = (b)((View)localObject3).getLayoutParams();
        j = ((b)localObject1).column;
      }
      label294: b localb;
      label373: int i11;
      int i1;
      if ((paramBoolean) || (localObject3 == null) || (((View)localObject3).isLayoutRequested()))
      {
        i2 = 1;
        localObject2 = localObject3;
        k = i;
        if (paramBoolean)
        {
          if (m == 0)
            break label642;
          localObject1 = cy(i10);
          localb = (b)((View)localObject1).getLayoutParams();
          k = i;
          if (localObject1 != localObject3)
          {
            k = i;
            if (localObject3 != null)
            {
              k = i;
              if (m == 0)
              {
                Nk.z((View)localObject3);
                removeViewInLayout((View)localObject3);
                k = 1;
              }
            }
            if (((View)localObject1).getParent() != this)
              break label655;
            detachViewFromParent((View)localObject1);
            attachViewToParent((View)localObject1, n, localb);
          }
          localObject2 = localObject1;
          localb.column = nh();
          j = localb.column;
          localObject1 = localb;
        }
        a((b)localObject1);
        i11 = Math.min(Nc, ((b)localObject1).span);
        i1 = j;
        if (i11 > 1)
        {
          if (!Nj)
            break label669;
          i = j;
          if (j + 1 < i11)
            i = Nc - 1;
          label449: ((b)localObject1).column = i;
          i1 = i;
        }
        j = i8 * i11 + (i11 - 1) * i6;
        if ((!Nj) || (i11 != i1 + 1))
        {
          i = j;
          if (!Nj)
          {
            i = j;
            if (i11 + i1 != Nc);
          }
        }
        else
        {
          i = j + i7 % i9;
        }
        if (i2 != 0)
        {
          j = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
          if (((b)localObject1).height != -2)
            break label687;
          i = View.MeasureSpec.makeMeasureSpec(0, 0);
          label548: ((View)localObject2).measure(j, i);
        }
        j = Ng[i1] + Ne;
        i = j;
        if (i11 <= 1)
          break label711;
        i = j;
        j = 0;
        label580: if (j >= i11)
          break label711;
        if (!Nj)
          break label702;
      }
      label642: label655: label669: label687: label702: for (int i2 = i1 - j; ; i2 = i1 + j)
      {
        i3 = Ng[i2] + Ne;
        i2 = i;
        if (i3 > i)
          i2 = i3;
        j += 1;
        i = i2;
        break label580;
        i2 = 0;
        break;
        localObject1 = b(i10, (View)localObject3);
        break label294;
        addViewInLayout((View)localObject1, n, localb);
        break label373;
        i = j;
        if (Nc - j >= i11)
          break label449;
        i = 0;
        break label449;
        i = View.MeasureSpec.makeMeasureSpec(((b)localObject1).height, 1073741824);
        break label548;
      }
      label711: int i3 = ((View)localObject2).getMeasuredHeight();
      int i12 = i + i3;
      if (Nj)
      {
        i2 = getWidth() - i5 - (Nc - i1 - 1) * (i8 + i6);
        j = i2 - ((View)localObject2).getMeasuredWidth();
        r.a(TAG, "[layoutChildren] height: " + i3 + " top: " + i + " bottom: " + i12 + " left: " + j + " column: " + i1 + " position: " + i10 + " id: " + ((b)localObject1).id, new Object[0]);
        ((View)localObject2).layout(j, i, i2, i12);
        if (((b)localObject1).id == No)
          ((View)localObject2).requestFocus();
        i = 0;
        label896: if (i >= i11)
          break label961;
        if (!Nj)
          break label953;
      }
      label953: for (j = i1 - i; ; j = i1 + i)
      {
        Ng[j] = i12;
        i += 1;
        break label896;
        j = i4 + (i8 + i6) * i1;
        i2 = j + ((View)localObject2).getMeasuredWidth();
        break;
      }
      label961: localObject3 = (c)NS.get(i10);
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new c(null);
        NS.put(i10, localObject2);
      }
      ((c)localObject2).column = ((b)localObject1).column;
      ((c)localObject2).height = i3;
      ((c)localObject2).id = ((b)localObject1).id;
      ((c)localObject2).span = i11;
      i = k;
    }
    label1045: if ((i != 0) || (m != 0))
      invalidate();
  }

  final View b(int paramInt, View paramView)
  {
    View localView2 = Nk.cC(paramInt);
    int j = gQ.getItemViewType(paramInt);
    View localView1 = localView2;
    int i;
    label50: ViewGroup.LayoutParams localLayoutParams;
    if (localView2 == null)
    {
      if (paramView == null)
        break label211;
      i = ((b)paramView.getLayoutParams()).Jb;
      if (i != j)
        break label216;
      i = cx(gQ.Q(paramInt));
      localView2 = gQ.a(paramInt, paramView, this, i);
      if ((localView2 != paramView) && (paramView != null))
        Nk.z(paramView);
      localLayoutParams = localView2.getLayoutParams();
      localView1 = localView2;
      if (localView2.getParent() != this)
      {
        if (localLayoutParams != null)
          break label229;
        paramView = no();
      }
    }
    while (true)
    {
      localView2.setLayoutParams(paramView);
      localView1 = localView2;
      paramView = (b)localView1.getLayoutParams();
      paramView.position = paramInt;
      paramView.Jb = j;
      long l = gQ.getItemId(paramInt);
      paramView.id = l;
      if ((mX()) && (NP.mN() == l))
      {
        NP.w(localView1);
        NP.x(localView1);
      }
      return localView1;
      label211: i = -1;
      break;
      label216: paramView = Nk.cD(j);
      break label50;
      label229: paramView = localLayoutParams;
      if (!checkLayoutParams(localLayoutParams))
        paramView = a(localLayoutParams);
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof b;
  }

  public void computeScroll()
  {
    if (Ns == 3)
    {
      nb();
      ct(0);
    }
    while (!Nt.computeScrollOffset())
      return;
    int i;
    int j;
    int m;
    Object localObject;
    if (ViewCompat.getOverScrollMode(this) != 2)
    {
      i = 1;
      j = Nt.getCurrY();
      m = (int)(j - lj);
      lj = j;
      if ((i == 0) || (getChildCount() <= 0))
        break label127;
      localObject = getChildAt(0);
      label80: if (localObject == null)
        break label133;
      j = ((View)localObject).getTop();
      label91: if (h(m, false))
        break label138;
    }
    label133: label138: for (int k = 1; ; k = 0)
    {
      if ((k != 0) || (Nt.isFinished()))
        break label143;
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      i = 0;
      break;
      label127: localObject = null;
      break label80;
      j = 0;
      break label91;
    }
    label143: if ((k != 0) && (m != 0) && (i != 0))
    {
      if (localObject != null)
      {
        i = ((View)localObject).getTop();
        overScrollBy(0, -m - (i - j), 0, getScrollY(), 0, 0, 0, NO, true);
      }
      if (m > 0)
      {
        localObject = Nu;
        Nv.finish();
      }
      while (true)
      {
        ((EdgeEffectCompat)localObject).onAbsorb(Math.abs((int)Nt.getCurrVelocity()));
        if (Nt.computeScrollOffset())
          Nt.notifyVerticalEdgeReached(getScrollY(), 0, NO);
        Ns = 3;
        ct(0);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
        localObject = Nv;
        Nu.finish();
      }
    }
    Ns = 0;
    ct(0);
  }

  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0);
    int m;
    int k;
    int j;
    do
    {
      return 0;
      m = getHeight();
      int n = getVerticalFadingEdgeLength();
      k = getScrollY() + getPaddingTop();
      int i = m;
      j = k;
      if (paramRect.top > 0)
        j = k + n;
      k = i;
      if (paramRect.bottom < getHeight())
        k = i - n;
      if ((paramRect.bottom > k) && (paramRect.top > j))
      {
        if (paramRect.height() > m)
          return j - paramRect.top;
        return k - paramRect.bottom;
      }
    }
    while ((paramRect.top >= j) || (paramRect.bottom >= k));
    if (paramRect.height() > m)
      return k - paramRect.bottom;
    return j - paramRect.top;
  }

  protected int computeVerticalScrollExtent()
  {
    int k = getChildCount();
    if (k > 0)
    {
      if (mSmoothScrollbarEnabled)
      {
        int j = (Nc + k - 1) / Nc * 100;
        View localView = getChildAt(0);
        int m = localView.getTop();
        int n = localView.getHeight();
        int i = j;
        if (n > 0)
          i = j + m * 100 / n;
        localView = getChildAt(k - 1);
        k = localView.getBottom();
        m = localView.getHeight();
        j = i;
        if (m > 0)
          j = i - (k - getHeight()) * 100 / m;
        return j;
      }
      return 1;
    }
    return 0;
  }

  protected int computeVerticalScrollOffset()
  {
    int k = mFirstPosition;
    int n = getChildCount();
    int m = getPaddingTop();
    if ((k >= 0) && (n > 0))
    {
      int j;
      int i;
      if (mSmoothScrollbarEnabled)
      {
        View localView = getChildAt(0);
        n = localView.getTop();
        j = localView.getHeight();
        if (j > 0)
        {
          i = k * 100 / Nc;
          j = n * 100 / j;
          int i1 = (mItemCount + Nc - 1) / Nc;
          j = Math.max(i - j + (int)(getScrollY() / getHeight() * i1 * 100.0F), 0);
          i = j;
          if (k == 0)
          {
            i = j;
            if (m > 0)
              i = j + (m - n + Ne);
          }
          return i;
        }
      }
      else
      {
        j = mItemCount;
        if (k == 0)
          i = 0;
        while (true)
        {
          return (int)(k + n * (i / j));
          if (k + n == j)
            i = j;
          else
            i = k + n / 2;
        }
      }
    }
    return m;
  }

  protected int computeVerticalScrollRange()
  {
    int k = (mItemCount + Nc - 1) / Nc;
    int j = Math.max(k * 100, 0);
    if (mSmoothScrollbarEnabled)
    {
      int i = j;
      if (getScrollY() != 0)
        i = j + Math.abs((int)(getScrollY() / getHeight() * k * 100.0F));
      return i;
    }
    return mItemCount;
  }

  public void cp(int paramInt)
  {
    if (paramInt != Ne)
    {
      Ne = paramInt;
      populate();
    }
  }

  public boolean cs(int paramInt)
  {
    return gQ.R(mFirstPosition + paramInt);
  }

  final void cv(int paramInt)
  {
    int i = 0;
    while ((i < NS.size()) && (NS.keyAt(i) < paramInt))
      i += 1;
    NS.removeAtRange(0, i);
  }

  final void cw(int paramInt)
  {
    int i = NS.size() - 1;
    while ((i >= 0) && (NS.keyAt(i) > paramInt))
      i -= 1;
    paramInt = i + 1;
    NS.removeAtRange(paramInt + 1, NS.size() - paramInt);
  }

  final View cy(int paramInt)
  {
    Object localObject1 = null;
    int j = gQ.getItemViewType(paramInt);
    long l = gQ.getItemId(paramInt);
    Object localObject2 = (i)NR.get(Long.valueOf(l));
    if (localObject2 != null)
      localObject1 = ((i)localObject2).view;
    int i;
    View localView;
    if ((localObject1 != null) && ((((View)localObject1).getLayoutParams() instanceof b)))
    {
      i = ((b)((View)localObject1).getLayoutParams()).Jb;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (i == j);
      }
      else
      {
        if (localObject1 != null)
          recycleView((View)localObject1);
        localObject2 = Nk.cD(j);
      }
      i = cx(gQ.Q(paramInt));
      localView = gQ.a(paramInt, (View)localObject2, this, i);
      localObject2 = localView.getLayoutParams();
      if (localView.getParent() != this)
      {
        if (localObject2 != null)
          break label252;
        localObject1 = no();
      }
    }
    while (true)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (b)localView.getLayoutParams();
      ((b)localObject1).position = paramInt;
      ((b)localObject1).Jb = j;
      ((b)localObject1).id = l;
      if ((mX()) && (NP.mN() == l))
      {
        NP.w(localView);
        NP.x(localView);
      }
      return localView;
      i = -1;
      break;
      label252: localObject1 = localObject2;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject2))
        localObject1 = a((ViewGroup.LayoutParams)localObject2);
    }
  }

  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    if (!mX())
      return super.dispatchDragEvent(paramDragEvent);
    switch (paramDragEvent.getAction())
    {
    case 2:
    default:
      return super.dispatchDragEvent(paramDragEvent);
    case 1:
      if ((NP.mS()) && (Nw))
      {
        paramDragEvent = s(NC, ND);
        if (paramDragEvent != null)
        {
          d(paramDragEvent, NC, ND);
          return true;
        }
      }
      return false;
    case 3:
    case 4:
    }
    if (mDragState == 1)
      v((int)paramDragEvent.getX(), (int)paramDragEvent.getY());
    return onDragEvent(paramDragEvent);
  }

  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (NN != null)
      NN.draw(paramCanvas);
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (Nu != null)
    {
      int i = 0;
      if (!Nu.isFinished())
      {
        i = paramCanvas.save();
        paramCanvas.translate(0.0F, 0.0F);
        Nu.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
        i = 1;
      }
      if (!Nv.isFinished())
      {
        i = paramCanvas.save();
        int j = getWidth();
        paramCanvas.translate(-j, getHeight());
        paramCanvas.rotate(180.0F, j, 0.0F);
        Nv.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
        i = 1;
      }
      if (i != 0)
        ViewCompat.postInvalidateOnAnimation(this);
    }
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new b(getContext(), paramAttributeSet);
  }

  public int getColumnCount()
  {
    return Nc;
  }

  public float mW()
  {
    return lj;
  }

  public final boolean mZ()
  {
    if ((mFirstPosition != 0) || (getChildCount() != mItemCount));
    int m;
    int j;
    do
    {
      return false;
      m = 2147483647;
      j = -2147483648;
      int i = 0;
      while (i < Nc)
      {
        int k = m;
        if (Nf[i] < m)
          k = Nf[i];
        m = j;
        if (Ng[i] > j)
          m = Ng[i];
        i += 1;
        j = m;
        m = k;
      }
    }
    while ((m < getPaddingTop()) || (j > getHeight() - getPaddingBottom()));
    return true;
  }

  final int ng()
  {
    int m = -1;
    int k = -2147483648;
    int i2 = Nc;
    int i = i2 - 1;
    if (i >= 0)
    {
      if (Nj);
      for (int j = i2 - (i + 1); ; j = i)
      {
        int i1 = Nf[j];
        int n = k;
        if (i1 > k)
        {
          n = i1;
          m = j;
        }
        i -= 1;
        k = n;
        break;
      }
    }
    return m;
  }

  final int nh()
  {
    int k = 2147483647;
    int m = 0;
    int i2 = Nc;
    int i = 0;
    if (i < i2)
    {
      if (Nj);
      for (int j = i2 - (i + 1); ; j = i)
      {
        int i1 = Ng[j];
        int n = k;
        if (i1 < k)
        {
          n = i1;
          m = j;
        }
        i += 1;
        k = n;
        break;
      }
    }
    return m;
  }

  public SgvAnimationHelper.AnimationIn ni()
  {
    return MX;
  }

  public void nk()
  {
    Np = null;
    B(0, getPaddingTop());
  }

  public int nl()
  {
    return mFirstPosition;
  }

  public ScrollState nn()
  {
    View localView = getChildAt(0);
    if (localView == null)
      return null;
    b localb = (b)localView.getLayoutParams();
    if (localb.position == 0);
    for (int i = localView.getTop() - getPaddingTop(); ; i = localView.getTop())
      return new ScrollState(localb.id, localb.position, i);
  }

  protected b no()
  {
    return new b(-2);
  }

  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    if (!mX())
      return false;
    int i = (int)paramDragEvent.getX();
    int j = (int)paramDragEvent.getY();
    switch (paramDragEvent.getAction())
    {
    default:
      return false;
    case 2:
      if (mDragState == 1)
      {
        u(i, j);
        lj = j;
      }
      if ((!NU) && ((Math.abs(i - NC) >= mTouchSlop * 4) || (Math.abs(j - ND) >= mTouchSlop * 4)))
      {
        NU = true;
        if (NT == null)
          NT = getHandler();
        NT.postDelayed(NV, 5L);
      }
      return true;
    case 3:
    case 4:
    }
    if (NT != null)
    {
      NT.removeCallbacks(NV);
      NU = false;
    }
    return true;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    float f;
    do
    {
      do
      {
        return false;
        NC = ((int)paramMotionEvent.getX());
        ND = ((int)paramMotionEvent.getY());
        mVelocityTracker.clear();
        Nt.abortAnimation();
        lj = paramMotionEvent.getY();
        mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        Nr = 0.0F;
      }
      while (Ns != 2);
      Ns = 1;
      return true;
      int i = MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId);
      if (i < 0)
      {
        Log.e(TAG, "onInterceptTouchEvent could not find pointer with id " + mActivePointerId + " - did StaggeredGridView receive an inconsistent " + "event stream?");
        return false;
      }
      f = MotionEventCompat.getY(paramMotionEvent, i) - lj + Nr;
      Nr = (f - (int)f);
    }
    while (Math.abs(f) <= mTouchSlop);
    Ns = 1;
    return true;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    D.bO("StaggeredGridView_onLayout");
    Nj = isLayoutRtl();
    mInLayout = true;
    populate();
    mInLayout = false;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    Nu.setSize(paramInt1, paramInt2);
    Nv.setSize(paramInt1, paramInt2);
    if (Ny != null)
      Ny.onLayoutComplete();
    D.ot();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    D.bO("StaggeredGridView_onMeasure");
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != 1073741824)
      r.b(TAG, "onMeasure: must have an exact width or match_parent! Using fallback spec of EXACTLY " + paramInt1, new Object[0]);
    if (j != 1073741824)
      r.b(TAG, "onMeasure: must have an exact height or match_parent! Using fallback spec of EXACTLY " + paramInt2, new Object[0]);
    setMeasuredDimension(paramInt1, paramInt2);
    if (Nb == -1)
    {
      paramInt2 = paramInt1 / Nd;
      if (paramInt2 != Nc)
        Nc = paramInt2;
    }
    if (NB == 0)
      if (Nc <= 1)
        break label181;
    label181: for (NB = ((paramInt1 - Ne * (Nc + 1)) / Nc / 4); ; NB = 30)
    {
      D.ot();
      return;
    }
  }

  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getScrollY() != paramInt2)
      scrollTo(0, paramInt2);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    mDataChanged = true;
    mFirstPosition = paramParcelable.position;
    Np = new ScrollState(paramParcelable.Og, paramParcelable.position, paramParcelable.topOffset);
    requestLayout();
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int i = mFirstPosition;
    localSavedState.position = i;
    if ((i >= 0) && (gQ != null) && (i < gQ.getCount()))
      localSavedState.Og = gQ.getItemId(i);
    if (getChildCount() > 0)
      if (i != 0)
        break label88;
    label88: for (i = getChildAt(0).getTop() - getPaddingTop(); ; i = getChildAt(0).getTop())
    {
      localSavedState.topOffset = i;
      return localSavedState;
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (NA != null)
      NA.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView));
    while (!isWithinDeltaOfScreen(localView, 0, paramInt4))
      return;
    localView.getDrawingRect(mTempRect);
    offsetDescendantRectToMyCoords(localView, mTempRect);
    scrollBy(0, computeScrollDeltaToGetChildRectOnScreen(mTempRect));
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default:
    case 0:
    case 2:
    case 3:
      while (true)
      {
        return true;
        mY();
        mVelocityTracker.clear();
        Nt.abortAnimation();
        lj = paramMotionEvent.getY();
        mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        Nr = 0.0F;
        continue;
        int i = MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId);
        if (i < 0)
        {
          Log.e(TAG, "onInterceptTouchEvent could not find pointer with id " + mActivePointerId + " - did StaggeredGridView receive an inconsistent " + "event stream?");
          return false;
        }
        f1 = MotionEventCompat.getY(paramMotionEvent, i);
        float f2 = f1 - lj + Nr;
        i = (int)f2;
        Nr = (f2 - i);
        if (Math.abs(f2) > mTouchSlop)
          Ns = 1;
        if (Ns == 1)
        {
          ct(1);
          lj = f1;
          if (!h(i, true))
          {
            mVelocityTracker.clear();
            continue;
            Ns = 0;
            ct(0);
            Nu.onRelease();
            Nv.onRelease();
          }
        }
      }
    case 1:
    }
    mVelocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
    float f1 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
    if (Math.abs(f1) > Nq)
    {
      Ns = 2;
      ct(2);
      mY();
      Nt.fling(0, 0, 0, (int)f1, 0, 0, -2147483648, 2147483647);
      lj = 0.0F;
      ViewCompat.postInvalidateOnAnimation(this);
    }
    while (true)
    {
      Nu.onRelease();
      Nv.onRelease();
      break;
      Ns = 0;
      ct(0);
    }
  }

  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return scrollToChildRect(paramRect, paramBoolean);
  }

  public void requestLayout()
  {
    if ((!Ni) && (!Nh))
      super.requestLayout();
  }

  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
      h(paramInt2, false);
  }

  public void setColumnCount(int paramInt)
  {
    int i = 1;
    if ((paramInt < 1) && (paramInt != -1))
      throw new IllegalArgumentException("Column count must be at least 1 - received " + paramInt);
    if (paramInt != Nc);
    while (true)
    {
      Nb = paramInt;
      Nc = paramInt;
      if (i != 0)
      {
        nj();
        NB = 0;
        populate();
      }
      return;
      i = 0;
    }
  }

  public void setEmptyView(View paramView)
  {
    mEmptyView = paramView;
    nc();
  }

  final int x(int paramInt1, int paramInt2)
  {
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    int i2 = Ne;
    int i3 = getWidth() - n - i1 - (Nc - 1) * i2;
    int i4 = i3 / Nc;
    int i5 = Nc;
    int m = getPaddingTop();
    int i6 = -paramInt2;
    int i = ng();
    paramInt2 = paramInt1;
    paramInt1 = i;
    while ((paramInt1 >= 0) && (Nf[paramInt1] > i6) && (paramInt2 >= 0))
    {
      View localView = b(paramInt2, null);
      b localb = (b)localView.getLayoutParams();
      int i7;
      c localc;
      label172: label212: int k;
      if (localView.getParent() != this)
      {
        if (mInLayout)
          addViewInLayout(localView, 0, localb);
      }
      else
      {
        i7 = Math.min(Nc, localb.span);
        if (i7 <= 1)
          break label444;
        localc = z(paramInt2, i7);
        paramInt1 = localc.column;
        i = 0;
        if (localc != null)
          break label460;
        localc = new c(null);
        NS.put(paramInt2, localc);
        localc.column = paramInt1;
        localc.span = i7;
        if (mHasStableIds)
          localc.id = localb.id;
        localb.column = paramInt1;
        a(localb);
        k = i4 * i7 + (i7 - 1) * i2;
        if ((!Nj) || (i7 != paramInt1 + 1))
        {
          j = k;
          if (!Nj)
          {
            j = k;
            if (i7 + paramInt1 != Nc);
          }
        }
        else
        {
          j = k + i3 % i5;
        }
        k = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        if (localb.height != -2)
          break label497;
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        label334: localView.measure(k, j);
        k = localView.getMeasuredHeight();
        if ((i != 0) || ((k != localc.height) && (localc.height > 0)))
          cv(paramInt2);
        localc.height = k;
        i = 0;
        label386: if (i >= i7)
          break label521;
        if (!Nj)
          break label513;
      }
      label513: for (int j = paramInt1 - i; ; j = paramInt1 + i)
      {
        int[] arrayOfInt = Nf;
        arrayOfInt[j] += localc.cA(i);
        i += 1;
        break label386;
        addView(localView, 0);
        break;
        label444: localc = (c)NS.get(paramInt2);
        break label172;
        label460: if (i7 != localc.span)
        {
          localc.span = i7;
          localc.column = paramInt1;
          i = 1;
          break label212;
        }
        paramInt1 = localc.column;
        break label212;
        label497: j = View.MeasureSpec.makeMeasureSpec(localb.height, 1073741824);
        break label334;
      }
      label521: int i9 = Nf[paramInt1];
      int i8 = i9 - k;
      if (Nj)
      {
        j = getWidth() - i1 - (Nc - paramInt1 - 1) * (i4 + i2);
        i = j - localView.getMeasuredWidth();
        localView.layout(i, i8, j, i9);
        r.a(TAG, "[fillUp] position: " + paramInt2 + " id: " + localb.id + " childLeft: " + i + " childTop: " + i8 + " column: " + localc.column + " childHeight:" + k, new Object[0]);
        i = 0;
        label681: if (i >= i7)
          break label756;
        if (!Nj)
          break label748;
      }
      label748: for (j = paramInt1 - i; ; j = paramInt1 + i)
      {
        Nf[j] = (i8 - localc.cz(i) - i2);
        i += 1;
        break label681;
        i = n + (i4 + i2) * paramInt1;
        j = i + localView.getMeasuredWidth();
        break;
      }
      label756: if (localb.id == No)
        localView.requestFocus();
      paramInt1 = ng();
      mFirstPosition = paramInt2;
      paramInt2 -= 1;
    }
    paramInt2 = getHeight();
    paramInt1 = 0;
    while (paramInt1 < Nc)
    {
      i = paramInt2;
      if (Nf[paramInt1] < paramInt2)
        i = Nf[paramInt1];
      paramInt1 += 1;
      paramInt2 = i;
    }
    return m - paramInt2;
  }

  final int y(int paramInt1, int paramInt2)
  {
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    int i3 = Ne;
    int i4 = getWidth() - i1 - i2 - (Nc - 1) * i3;
    int i5 = i4 / Nc;
    int i6 = Nc;
    int n = getHeight() - getPaddingBottom();
    int j = nh();
    int i = paramInt1;
    paramInt1 = j;
    while ((paramInt1 >= 0) && (Ng[paramInt1] < n + paramInt2) && (i < mItemCount))
    {
      View localView = b(i, null);
      b localb = (b)localView.getLayoutParams();
      int i7;
      c localc;
      label181: label222: int m;
      if (localView.getParent() != this)
      {
        if (mInLayout)
          addViewInLayout(localView, -1, localb);
      }
      else
      {
        i7 = Math.min(Nc, localb.span);
        if (i7 <= 1)
          break label460;
        localc = A(i, i7);
        paramInt1 = localc.column;
        j = 0;
        if (localc != null)
          break label476;
        localc = new c(null);
        NS.put(i, localc);
        localc.column = paramInt1;
        localc.span = i7;
        if (mHasStableIds)
          localc.id = localb.id;
        localb.column = paramInt1;
        a(localb);
        m = i5 * i7 + (i7 - 1) * i3;
        if ((!Nj) || (i7 != paramInt1 + 1))
        {
          k = m;
          if (!Nj)
          {
            k = m;
            if (i7 + paramInt1 != Nc);
          }
        }
        else
        {
          k = m + i4 % i6;
        }
        m = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        if (localb.height != -2)
          break label514;
        k = View.MeasureSpec.makeMeasureSpec(0, 0);
        label344: localView.measure(m, k);
        m = localView.getMeasuredHeight();
        if ((j != 0) || ((m != localc.height) && (localc.height > 0)))
          cw(i);
        localc.height = m;
        j = 0;
        label398: if (j >= i7)
          break label539;
        if (!Nj)
          break label530;
      }
      label514: label530: for (int k = paramInt1 - j; ; k = paramInt1 + j)
      {
        int[] arrayOfInt = Ng;
        arrayOfInt[k] += localc.cz(j);
        j += 1;
        break label398;
        addView(localView);
        break;
        label460: localc = (c)NS.get(i);
        break label181;
        label476: if (i7 != localc.span)
        {
          localc.span = i7;
          localc.column = paramInt1;
          j = 1;
          break label222;
        }
        paramInt1 = localc.column;
        break label222;
        k = View.MeasureSpec.makeMeasureSpec(localb.height, 1073741824);
        break label344;
      }
      label539: int i9 = Ng[paramInt1] + i3;
      int i8 = i9 + m;
      if (Nj)
      {
        k = getWidth() - i2 - (Nc - paramInt1 - 1) * (i5 + i3);
        j = k - localView.getMeasuredWidth();
        r.a(TAG, "[fillDown] position: " + i + " id: " + localb.id + " childLeft: " + j + " childTop: " + i9 + " column: " + localc.column + " childHeight:" + m, new Object[0]);
        localView.layout(j, i9, k, i8);
        j = 0;
        label706: if (j >= i7)
          break label786;
        if (!Nj)
          break label777;
      }
      label777: for (k = paramInt1 - j; ; k = paramInt1 + j)
      {
        Ng[k] = (localc.cA(j) + i8);
        j += 1;
        break label706;
        j = i1 + (i5 + i3) * paramInt1;
        k = j + localView.getMeasuredWidth();
        break;
      }
      label786: if (localb.id == No)
        localView.requestFocus();
      paramInt1 = nh();
      i += 1;
    }
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt1 < Nc)
    {
      if (Nj);
      for (j = Nc - (paramInt1 + 1); ; j = paramInt1)
      {
        i = paramInt2;
        if (Ng[j] > paramInt2)
          i = Ng[j];
        paramInt1 += 1;
        paramInt2 = i;
        break;
      }
    }
    return paramInt2 - n;
  }

  final c z(int paramInt1, int paramInt2)
  {
    c localc2 = (c)NS.get(paramInt1);
    c localc1;
    if (localc2 != null)
    {
      localc1 = localc2;
      if (localc2.span == paramInt2);
    }
    else
    {
      if (paramInt2 > Nc)
        throw new IllegalStateException("Span larger than column count! Span:" + paramInt2 + " ColumnCount:" + Nc);
      localc1 = new c(null);
      localc1.span = paramInt2;
      NS.put(paramInt1, localc1);
    }
    int j = -1;
    int i = -2147483648;
    int i2 = Nc;
    int k;
    int m;
    int i1;
    int n;
    if (Nj)
    {
      paramInt1 = paramInt2 - 1;
      while (true)
      {
        k = i;
        m = j;
        if (paramInt1 >= i2)
          break;
        k = 2147483647;
        m = paramInt1;
        while (m > paramInt1 - paramInt2)
        {
          i1 = Nf[m];
          n = k;
          if (i1 < k)
            n = i1;
          m -= 1;
          k = n;
        }
        m = i;
        if (k > i)
        {
          j = paramInt1;
          m = k;
        }
        paramInt1 += 1;
        i = m;
      }
    }
    paramInt1 = i2 - paramInt2;
    while (true)
    {
      k = i;
      m = j;
      if (paramInt1 < 0)
        break;
      k = 2147483647;
      m = paramInt1;
      while (m < paramInt1 + paramInt2)
      {
        i1 = Nf[m];
        n = k;
        if (i1 < k)
          n = i1;
        m += 1;
        k = n;
      }
      m = i;
      if (k > i)
      {
        j = paramInt1;
        m = k;
      }
      paramInt1 -= 1;
      i = m;
    }
    localc1.column = m;
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      if (Nj);
      for (i = m - paramInt1; ; i = m + paramInt1)
      {
        localc1.D(paramInt1, Nf[i] - k);
        paramInt1 += 1;
        break;
      }
    }
    return localc1;
  }

  static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public StaggeredGridView.SavedState[] cE(int paramAnonymousInt)
      {
        return new StaggeredGridView.SavedState[paramAnonymousInt];
      }

      public StaggeredGridView.SavedState x(Parcel paramAnonymousParcel)
      {
        return new StaggeredGridView.SavedState(paramAnonymousParcel, null);
      }
    };
    long Og = -1L;
    int position;
    int topOffset;

    private SavedState(Parcel paramParcel)
    {
      super();
      Og = paramParcel.readLong();
      position = paramParcel.readInt();
      topOffset = paramParcel.readInt();
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public String toString()
    {
      return "StaggereGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " firstId=" + Og + " position=" + position + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeLong(Og);
      paramParcel.writeInt(position);
      paramParcel.writeInt(topOffset);
    }
  }

  public static class ScrollState
    implements Parcelable
  {
    public static final Parcelable.Creator<ScrollState> CREATOR = new Parcelable.Creator()
    {
      public StaggeredGridView.ScrollState[] cF(int paramAnonymousInt)
      {
        return new StaggeredGridView.ScrollState[paramAnonymousInt];
      }

      public StaggeredGridView.ScrollState y(Parcel paramAnonymousParcel)
      {
        return new StaggeredGridView.ScrollState(paramAnonymousParcel, null);
      }
    };
    private final int Oh;
    private int Oi;
    private final long mItemId;

    public ScrollState(long paramLong, int paramInt1, int paramInt2)
    {
      mItemId = paramLong;
      Oh = paramInt1;
      Oi = paramInt2;
    }

    private ScrollState(Parcel paramParcel)
    {
      mItemId = paramParcel.readLong();
      Oh = paramParcel.readInt();
      Oi = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    public int getAdapterPosition()
    {
      return Oh;
    }

    public long getItemId()
    {
      return mItemId;
    }

    public int getVerticalOffset()
    {
      return Oi;
    }

    public String toString()
    {
      return "ScrollState {mItemId=" + mItemId + " mAdapterPosition=" + Oh + " mVerticalOffset=" + Oi + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(mItemId);
      paramParcel.writeInt(Oh);
      paramParcel.writeInt(Oi);
    }
  }

  private class a extends DataSetObserver
  {
    private a()
    {
    }

    public void onChanged()
    {
      StaggeredGridView.a(StaggeredGridView.this, true);
      StaggeredGridView.b(StaggeredGridView.this, StaggeredGridView.i(StaggeredGridView.this).getCount());
      StaggeredGridView.c(StaggeredGridView.this, StaggeredGridView.i(StaggeredGridView.this).cp());
      if (StaggeredGridView.j(StaggeredGridView.this) >= StaggeredGridView.k(StaggeredGridView.this))
      {
        StaggeredGridView.d(StaggeredGridView.this, 0);
        StaggeredGridView.a(StaggeredGridView.this, null);
      }
      StaggeredGridView.l(StaggeredGridView.this).nr();
      if (StaggeredGridView.m(StaggeredGridView.this))
        StaggeredGridView.n(StaggeredGridView.this);
      while (true)
      {
        StaggeredGridView.s(StaggeredGridView.this);
        requestLayout();
        return;
        StaggeredGridView.o(StaggeredGridView.this).clear();
        int j = StaggeredGridView.p(StaggeredGridView.this);
        int i = 0;
        while (i < j)
        {
          StaggeredGridView.q(StaggeredGridView.this)[i] = StaggeredGridView.r(StaggeredGridView.this)[i];
          i += 1;
        }
      }
    }

    public void onInvalidated()
    {
    }
  }

  public static class b extends ViewGroup.LayoutParams
  {
    private static final int[] LAYOUT_ATTRS = { 16843085 };
    int Jb;
    public int Ob = 0;
    int column;
    long id = -1L;
    public int position = -1;
    public int span = 1;

    public b(int paramInt)
    {
      super(paramInt);
      if (height == -1)
      {
        Log.w(StaggeredGridView.np(), "Constructing LayoutParams with height FILL_PARENT - impossible! Falling back to WRAP_CONTENT");
        height = -2;
      }
    }

    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      if (width != -1)
      {
        Log.w(StaggeredGridView.np(), "Inflation setting LayoutParams width to " + width + " - must be MATCH_PARENT");
        width = -1;
      }
      if (height == -1)
      {
        Log.w(StaggeredGridView.np(), "Inflation setting LayoutParams height to MATCH_PARENT - impossible! Falling back to WRAP_CONTENT");
        height = -2;
      }
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
      span = paramContext.getInteger(0, 1);
      paramContext.recycle();
    }

    public b(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      if (width != -1)
      {
        Log.w(StaggeredGridView.np(), "Constructing LayoutParams with width " + width + " - must be MATCH_PARENT");
        width = -1;
      }
      if (height == -1)
      {
        Log.w(StaggeredGridView.np(), "Constructing LayoutParams with height MATCH_PARENT - impossible! Falling back to WRAP_CONTENT");
        height = -2;
      }
    }
  }

  private static final class c
  {
    private int[] Oc;
    public int column;
    public int height;
    public long id = -1L;
    public int span;

    private final void nq()
    {
      if (Oc == null)
        Oc = new int[span * 2];
    }

    public final void C(int paramInt1, int paramInt2)
    {
      if ((Oc == null) && (paramInt2 == 0))
        return;
      nq();
      Oc[(paramInt1 * 2)] = paramInt2;
    }

    public final void D(int paramInt1, int paramInt2)
    {
      if ((Oc == null) && (paramInt2 == 0))
        return;
      nq();
      Oc[(paramInt1 * 2 + 1)] = paramInt2;
    }

    public final int cA(int paramInt)
    {
      if (Oc == null)
        return 0;
      return Oc[(paramInt * 2 + 1)];
    }

    public final int cz(int paramInt)
    {
      if (Oc == null)
        return 0;
      return Oc[(paramInt * 2)];
    }

    public String toString()
    {
      String str2 = "LayoutRecord{c=" + column + ", id=" + id + " h=" + height + " s=" + span;
      String str1 = str2;
      if (Oc != null)
      {
        str1 = str2 + " margins[above, below](";
        int i = 0;
        while (i < Oc.length)
        {
          str1 = str1 + "[" + Oc[i] + ", " + Oc[(i + 1)] + "]";
          i += 2;
        }
        str1 = str1 + ")";
      }
      return str1 + "}";
    }
  }

  public static abstract interface d
  {
    public abstract void onLayoutComplete();
  }

  public static abstract interface e
  {
    public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }

  private class f
  {
    private ArrayList<View>[] Od;
    private int Oe;
    private SparseArray<View> Of;
    private int gV;

    private f()
    {
    }

    public void cB(int paramInt)
    {
      if (paramInt < 1)
        throw new IllegalArgumentException("Must have at least one view type (" + paramInt + " types reported)");
      if (paramInt == gV)
        return;
      ArrayList[] arrayOfArrayList = new ArrayList[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        arrayOfArrayList[i] = new ArrayList();
        i += 1;
      }
      gV = paramInt;
      Od = arrayOfArrayList;
    }

    public View cC(int paramInt)
    {
      Object localObject;
      if (Of == null)
        localObject = null;
      View localView;
      do
      {
        return localObject;
        localView = (View)Of.get(paramInt);
        localObject = localView;
      }
      while (localView == null);
      Of.remove(paramInt);
      return localView;
    }

    public View cD(int paramInt)
    {
      ArrayList localArrayList = Od[paramInt];
      if (localArrayList.isEmpty())
        return null;
      return (View)localArrayList.remove(localArrayList.size() - 1);
    }

    public void clear()
    {
      int j = gV;
      int i = 0;
      while (i < j)
      {
        Od[i].clear();
        i += 1;
      }
      if (Of != null)
        Of.clear();
    }

    public void nr()
    {
      if (Of != null)
        Of.clear();
    }

    public void z(View paramView)
    {
      if (!(paramView.getLayoutParams() instanceof StaggeredGridView.b));
      Object localObject;
      do
      {
        return;
        localObject = (StaggeredGridView.b)paramView.getLayoutParams();
        if (ViewCompat.hasTransientState(paramView))
        {
          if (Of == null)
            Of = new SparseArray();
          Of.put(((StaggeredGridView.b)localObject).position, paramView);
          return;
        }
        int i = getChildCount();
        if (i > Oe)
          Oe = i;
        paramView.setTranslationX(0.0F);
        paramView.setTranslationY(0.0F);
        paramView.setRotation(0.0F);
        paramView.setAlpha(1.0F);
        paramView.setScaleY(1.0F);
        localObject = Od[localObject.Jb];
      }
      while ((((ArrayList)localObject).size() >= Oe) || (((ArrayList)localObject).contains(paramView)));
      ((ArrayList)localObject).add(paramView);
    }
  }

  public static abstract interface g
  {
    public abstract void a(View paramView, int paramInt1, int paramInt2);

    public abstract boolean a(View paramView, long paramLong, int paramInt1, int paramInt2);

    public abstract void b(View paramView, int paramInt);

    public abstract void c(View paramView, int paramInt);

    public abstract void g(View paramView);
  }

  public static abstract interface h
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3);

    public abstract void a(StaggeredGridView paramStaggeredGridView, int paramInt);
  }

  private static class i
  {
    public final Rect rect;
    public final View view;

    public i(View paramView, Rect paramRect)
    {
      view = paramView;
      rect = paramRect;
    }
  }
}