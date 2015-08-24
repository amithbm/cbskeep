package com.google.android.keep.browse;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBar;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.Q;
import com.google.android.keep.U;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.activities.DebugActivity;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.f;
import com.google.android.keep.f.c;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.Location;
import com.google.android.keep.model.LocationReminder;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.TimeReminder;
import com.google.android.keep.model.TreeEntity;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.j;
import com.google.android.keep.model.m;
import com.google.android.keep.navigation.BrowseNavigationRequest;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.navigation.EditorNavigationRequest.a;
import com.google.android.keep.navigation.FilterBrowseNavigationRequest;
import com.google.android.keep.navigation.LabelNavigationRequest;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.navigation.a.a;
import com.google.android.keep.provider.KeepProvider;
import com.google.android.keep.provider.i.g;
import com.google.android.keep.provider.m.a;
import com.google.android.keep.service.DocsExportService;
import com.google.android.keep.syncadapter.g.a;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.task.TaskHelper.ErrorCode;
import com.google.android.keep.task.TaskHelper.a;
import com.google.android.keep.task.TreeEntityTask;
import com.google.android.keep.task.TreeEntityTask.a;
import com.google.android.keep.toasts.ToastListener;
import com.google.android.keep.toasts.ToastListener.a;
import com.google.android.keep.toasts.ToastListener.f;
import com.google.android.keep.toasts.ToastListener.g;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.ui.QuickEditLayout;
import com.google.android.keep.ui.QuickEditLayout.a;
import com.google.android.keep.ui.SearchFilterLayout;
import com.google.android.keep.ui.SearchFilterLayout.a;
import com.google.android.keep.ui.SgvAnimationHelper.AnimationIn;
import com.google.android.keep.ui.SgvAnimationHelper.AnimationOut;
import com.google.android.keep.ui.SgvAnimationHelper.TranslationAnimationType;
import com.google.android.keep.ui.StaggeredGridView;
import com.google.android.keep.ui.StaggeredGridView.ScrollState;
import com.google.android.keep.ui.StaggeredGridView.e;
import com.google.android.keep.ui.StaggeredGridView.g;
import com.google.android.keep.ui.StaggeredGridView.h;
import com.google.android.keep.ui.b.b;
import com.google.android.keep.ui.k.a;
import com.google.android.keep.util.C;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.Config.UpgradeType;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.d;
import com.google.android.keep.util.r;
import com.google.android.keep.util.x;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c extends com.google.android.keep.e
  implements SwipeRefreshLayout.OnRefreshListener, MenuBuilder.Callback, MenuPresenter.Callback, View.OnClickListener, View.OnTouchListener, SingleSelectDialogFragment.b, com.google.android.keep.colorpicker.b.a, com.google.android.keep.location.i.a<com.google.android.keep.location.g>, ModelEventDispatcher.b, a.a, QuickEditLayout.a, StaggeredGridView.e, StaggeredGridView.g, StaggeredGridView.h, b.b
{
  private static int eu = 5000;
  private static float ev = 0.5F;
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wX, ModelEventDispatcher.EventType.wV, ModelEventDispatcher.EventType.xo });
  private static final ImmutableSet<NavigationManager.NavigationMode> fG = ImmutableSet.of(NavigationManager.NavigationMode.AM, NavigationManager.NavigationMode.AP, NavigationManager.NavigationMode.AO);
  private a cR;
  private ViewConfiguration eA;
  private View eB;
  private ViewGroup eC;
  private StaggeredGridView eD;
  private b eE;
  private com.google.android.keep.ui.c eF;
  private BrowseSwipeRefreshLayout eG;
  private SearchFilterLayout eH;
  private boolean eI;
  private q eJ;
  private a eK;
  private boolean eL;
  private boolean eM;
  private ActionMode eN;
  private QuickEditLayout eO;
  private View eP = null;
  private View eQ;
  private boolean eR;
  private Config.UpgradeType eS = Config.UpgradeType.Pu;
  private View eT;
  private boolean eU;
  private int eV = 0;
  private boolean eW = true;
  private MinTimeProgressView eX;
  private boolean eY = true;
  private int eZ;
  private View ea;
  private com.google.android.keep.navigation.a et;
  private int ew = -1;
  private boolean ex = false;
  private FabFragment ey = null;
  private int ez;
  private final int[] fA = { 0, 1, 2, 3, 4 };
  private final LoaderManager.LoaderCallbacks<Cursor> fB = new LoaderManager.LoaderCallbacks()
  {
    private void bN()
    {
      View localView = c.f(c.this).findViewById(2131493061);
      localView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
        {
          switch (paramAnonymous2MotionEvent.getAction() & 0xFF)
          {
          default:
          case 0:
          }
          while (true)
          {
            return false;
            c.d(c.this);
            com.google.android.keep.util.e.B(c.f(c.this));
          }
        }
      });
      TextView localTextView = (TextView)localView.findViewById(2131493100);
      int i;
      switch (c.12.cP[c.j(c.this).ka().ordinal()])
      {
      case 3:
      case 4:
      default:
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130837712, 0, 0);
        i = 2131231104;
      case 2:
      case 1:
      case 5:
      case 6:
      }
      while (true)
      {
        if (localTextView != null)
          localTextView.setText(i);
        c.z(c.this).setEmptyView(localView);
        return;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130837640, 0, 0);
        i = 2131231107;
        continue;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130837639, 0, 0);
        i = 2131231105;
        continue;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130837643, 0, 0);
        i = 2131231106;
        continue;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130837642, 0, 0);
        i = 2131231109;
      }
    }

    public CursorLoader a(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      if ((paramAnonymousBundle == null) || (!paramAnonymousBundle.containsKey("loader_browseRequest")))
        return null;
      c.a(c.this, (BrowseNavigationRequest)paramAnonymousBundle.getParcelable("loader_browseRequest"));
      if (c.j(c.this) == null)
        return null;
      if (c.s(c.this) == null)
        return null;
      return Note.a(getActivity(), c.s(c.this).getId(), c.j(c.this));
    }

    public void onLoadFinished(Loader<Cursor> paramAnonymousLoader, Cursor paramAnonymousCursor)
    {
      if (paramAnonymousCursor == null)
        return;
      paramAnonymousLoader = c.this;
      boolean bool;
      int i;
      if ((!paramAnonymousCursor.getExtras().getBoolean("hasDataReady")) && (com.google.android.keep.util.e.a(getActivity())))
      {
        bool = true;
        c.d(paramAnonymousLoader, bool);
        paramAnonymousLoader = c.C(c.this);
        if (!c.B(c.this))
          break label333;
        i = 0;
        label67: paramAnonymousLoader.setVisibility(i);
        c.c(c.this).setRefreshing(false);
        paramAnonymousLoader = c.this;
        if ((c.j(c.this).ka() != NavigationManager.NavigationMode.AQ) || (paramAnonymousCursor.getCount() <= 0))
          break label339;
        bool = true;
        label116: c.e(paramAnonymousLoader, bool);
        r.a("Keep", "onLoadFinished:\n   request: " + c.j(c.this).toString() + "\n" + "   cursor size: " + paramAnonymousCursor.getCount(), new Object[0]);
        if (!c.B(c.this))
        {
          c.c(c.this).setEnabled(true);
          if (paramAnonymousCursor.getCount() == 0)
            bN();
        }
        if (!c.D(c.this))
          break label345;
        c.z(c.this).a(SgvAnimationHelper.AnimationIn.Mi, SgvAnimationHelper.AnimationOut.Mp);
        c.f(c.this, false);
        label249: if (c.k(c.this) != null)
          break label380;
        c.a(c.this, c.a(c.this, paramAnonymousCursor));
        c.g(c.this, false);
        c.z(c.this).a(c.k(c.this), c.E(c.this));
      }
      while (true)
      {
        getActivity().invalidateOptionsMenu();
        c.a(c.this, null);
        return;
        bool = false;
        break;
        label333: i = 8;
        break label67;
        label339: bool = false;
        break label116;
        label345: if (c.z(c.this).ni() != SgvAnimationHelper.AnimationIn.Mh)
          break label249;
        c.z(c.this).a(SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Mp);
        break label249;
        label380: c.g(c.this, false);
        c.k(c.this).changeCursor(paramAnonymousCursor);
        c.k(c.this).a(c.F(c.this), c.G(c.this), c.H(c.this), c.I(c.this), c.J(c.this), c.K(c.this));
        c.a(c.this, null);
        if (c.L(c.this))
        {
          c.z(c.this).nk();
          if (c.M(c.this).getTranslationY() != 0.0F)
            c.p(c.this).post(new Runnable()
            {
              public void run()
              {
                c.z(c.this).scrollBy(0, (int)c.M(c.this).getTranslationY());
              }
            });
          c.h(c.this, false);
        }
        c.N(c.this);
      }
    }

    public void onLoaderReset(Loader<Cursor> paramAnonymousLoader)
    {
      if (c.k(c.this) != null)
        c.k(c.this).changeCursor(null);
    }
  };
  private final LoaderManager.LoaderCallbacks<Cursor> fC = new LoaderManager.LoaderCallbacks()
  {
    private void bN()
    {
      View localView = c.f(c.this).findViewById(2131493061);
      TextView localTextView = (TextView)localView.findViewById(2131493100);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130837641, 0, 0);
      localTextView.setText(2131231108);
      c.z(c.this).setEmptyView(localView);
    }

    public CursorLoader a(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      if ((paramAnonymousBundle == null) || (!paramAnonymousBundle.containsKey("loader_query")) || (c.s(c.this) == null))
        return null;
      return Note.a(getActivity(), c.s(c.this).getId(), paramAnonymousBundle.getString("loader_query"));
    }

    public void onLoadFinished(Loader<Cursor> paramAnonymousLoader, Cursor paramAnonymousCursor)
    {
      int i = 0;
      if (paramAnonymousCursor == null)
        return;
      r.a("Keep", "onLoadFinished() cursor count " + paramAnonymousCursor.getCount(), new Object[0]);
      c.z(c.this).a(SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Mr);
      paramAnonymousLoader = c.this;
      boolean bool;
      if ((!paramAnonymousCursor.getExtras().getBoolean("hasDataReady")) && (com.google.android.keep.util.e.a(getActivity())))
      {
        bool = true;
        c.d(paramAnonymousLoader, bool);
        paramAnonymousLoader = c.C(c.this);
        if (!c.B(c.this))
          break label203;
      }
      while (true)
      {
        paramAnonymousLoader.setVisibility(i);
        if (!c.B(c.this))
          bN();
        if (c.k(c.this) != null)
          break label209;
        c.a(c.this, c.a(c.this, paramAnonymousCursor));
        c.k(c.this).f(c.O(c.this));
        c.z(c.this).a(c.k(c.this));
        return;
        bool = false;
        break;
        label203: i = 8;
      }
      label209: c.k(c.this).changeCursor(paramAnonymousCursor);
      c.N(c.this);
    }

    public void onLoaderReset(Loader<Cursor> paramAnonymousLoader)
    {
      if (c.k(c.this) != null)
        c.k(c.this).changeCursor(null);
    }
  };
  private final TaskHelper.a<Long> fE = new TaskHelper.a()
  {
    public void a(TaskHelper.ErrorCode paramAnonymousErrorCode)
    {
      if ((getActivity() == null) || (!isAdded()))
        return;
      com.google.android.keep.util.e.b(getActivity(), 2131231200);
    }

    public void a(Long paramAnonymousLong)
    {
    }
  };
  private SingleSelectDialogFragment.OptionItem[] fF;
  private String fa = "INVALID_COLOR";
  private boolean fb = false;
  private BrowseNavigationRequest fc;
  private StaggeredGridView.ScrollState fd;
  private int fe = 0;
  private long[] ff = null;
  private com.google.android.keep.model.o fg;
  private com.google.android.keep.model.l fh;
  private com.google.android.keep.model.A fi;
  private int fj;
  private int fk;
  private int fl;
  private int fm;
  private int fn;
  private Bundle fo;
  private int fp = -1;
  private KeepTime fq = null;
  private j fr;
  private String fs;
  private boolean ft;
  private boolean fu;
  private final SearchFilterLayout.a fv = new SearchFilterLayout.a()
  {
    public void E(int paramAnonymousInt)
    {
      h(c.b(c.this).jW());
      c.a(c.this, 2131230867, paramAnonymousInt, 2131231016, null);
      c.b(c.this).kh();
    }
  };
  private final Runnable fw = new Runnable()
  {
    public void run()
    {
      c.c(c.this).setRefreshing(false);
    }
  };
  private final p fx = new p()
  {
    private final Set<Long> fL = new HashSet();

    public void a(long paramAnonymousLong, boolean paramAnonymousBoolean)
    {
      boolean bool = fL.contains(Long.valueOf(paramAnonymousLong));
      if (bool == paramAnonymousBoolean)
        return;
      if ((bool) && (!paramAnonymousBoolean))
        fL.remove(Long.valueOf(paramAnonymousLong));
      if ((!bool) && (paramAnonymousBoolean))
        fL.add(Long.valueOf(paramAnonymousLong));
      if (fL.size() == 0)
      {
        by();
        return;
      }
      c.e(c.this).setTag(fL);
      c.e(c.this).invalidate();
    }

    public void a(final View paramAnonymousView, final Note paramAnonymousNote)
    {
      com.google.android.keep.util.e.B(c.f(c.this));
      c.d(c.this);
      by();
      c.g(c.this);
      if (c.b(c.this).kg());
      for (int i = 200; ; i = 0)
      {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if (c.h(c.this).aQ())
              return;
            long l = paramAnonymousNote.getId();
            EditorNavigationRequest.a locala = new EditorNavigationRequest.a().h(paramAnonymousNote.ir()).g(Long.valueOf(l)).e(paramAnonymousNote.iA());
            if (paramAnonymousNote.iz() == null);
            for (Object localObject = ColorMap.gO(); ; localObject = paramAnonymousNote.iz())
            {
              localObject = locala.c((ColorMap.ColorPair)localObject).ag(paramAnonymousNote.in()).a(c.a(c.this, paramAnonymousView, getActivity(), l)).jU();
              c.h(c.this).b((EditorNavigationRequest)localObject);
              return;
            }
          }
        }
        , i);
        return;
      }
    }

    public void a(TreeEntity paramAnonymousTreeEntity)
    {
      long l = paramAnonymousTreeEntity.getId();
      r.a("Keep", "onSwipedAway called with treeEntityId " + paramAnonymousTreeEntity.getId(), new Object[0]);
      if ((getActivity() == null) || (!c.i(c.this)) || (paramAnonymousTreeEntity.jr()))
        return;
      if (c.j(c.this).ka() == NavigationManager.NavigationMode.AO)
        c.k(c.this).a(l, SgvAnimationHelper.TranslationAnimationType.Mw);
      paramAnonymousTreeEntity = b(com.google.android.keep.util.e.h(paramAnonymousTreeEntity), true);
      paramAnonymousTreeEntity.b(2131230867, 2131230886, 2131231021, null);
      c.a(c.this, paramAnonymousTreeEntity);
      c.c(c.this).setEnabled(true);
    }

    public void bO()
    {
      c.d(c.this);
      fL.clear();
      BrowseActivity localBrowseActivity = (BrowseActivity)getActivity();
      if (c.b(c.this).kg())
        c.b(c.this).kf();
      c.a(c.this, localBrowseActivity.startSupportActionMode(a(localBrowseActivity.getMenuInflater())));
      c.e(c.this).setTag(fL);
      c.e(c.this).invalidate();
      localBrowseActivity.invalidateOptionsMenu();
    }

    public void bP()
    {
      c.c(c.this).setEnabled(false);
    }

    public void e(long paramAnonymousLong)
    {
      com.google.android.keep.util.e.B(c.f(c.this));
      c.a(c.this, 2131230889);
    }
  };
  private final com.google.android.keep.ui.i.a fy = new com.google.android.keep.ui.i.a()
  {
    public void b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      c.l(c.this).year = paramAnonymousInt1;
      c.l(c.this).month = paramAnonymousInt2;
      c.l(c.this).monthDay = paramAnonymousInt3;
      c.l(c.this).on();
      KeepTime localKeepTime = new KeepTime();
      localKeepTime.set(0, 0, localKeepTime.hour + 1, localKeepTime.monthDay, localKeepTime.month, localKeepTime.year);
      x.a(c.this, localKeepTime, c.m(c.this));
    }

    public void bQ()
    {
    }
  };
  private final k.a fz = new k.a()
  {
    public void bR()
    {
    }

    public void h(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      c.l(c.this).hour = paramAnonymousInt1;
      c.l(c.this).minute = paramAnonymousInt2;
      c.l(c.this).on();
      c.a(c.this, c.l(c.this));
      by();
    }
  };
  private int mDeltaY = 0;
  private final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool = true;
      switch (paramAnonymousMessage.what)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      do
      {
        return;
        c localc = c.this;
        if (paramAnonymousMessage.what == 1);
        while (true)
        {
          c.a(localc, bool);
          return;
          bool = false;
        }
        if (c.a(c.this) != null)
          break;
        c.a(c.this, (FabFragment)com.google.android.keep.util.e.a(getActivity(), 2131493041));
      }
      while (c.a(c.this) == null);
      if (paramAnonymousMessage.what == 3)
      {
        c.a(c.this).show();
        return;
      }
      c.a(c.this).hide();
    }
  };

  private void A(int paramInt)
  {
    if (paramInt == 0)
      return;
    float f = et.kj().getTranslationY();
    if (paramInt < 0);
    for (f = Math.max(paramInt + f, -ew); ; f = Math.min(paramInt + f, 0.0F))
    {
      et.kj().setTranslationY(f);
      if (!bx())
        break;
      eQ.setTranslationY(f);
      return;
    }
  }

  private void B(int paramInt)
  {
    if ((eN == null) || (eN.getTag() == null));
    int i;
    do
    {
      return;
      i = ((Set)eN.getTag()).size();
    }
    while (i == 0);
    if (i == 1)
    {
      a(2131230867, paramInt, 2131231009, Long.valueOf(1L));
      return;
    }
    a(2131230867, paramInt, 2131231010, Long.valueOf(i));
  }

  private void D(int paramInt)
  {
    int i = bL();
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
      a(2131230866, 2131230872, i, null);
      a(TreeEntity.TreeEntityType.zO, paramInt, null, null);
      return;
      paramInt = 3;
      a(2131230866, 2131230899, i, null);
    }
  }

  private com.google.android.keep.g a(View paramView, Activity paramActivity, long paramLong)
  {
    if (eM);
    for (int i = 0; ; i = 1)
      return new com.google.android.keep.g(paramView, paramActivity, i, paramLong);
  }

  private void a(int paramInt, Parcelable paramParcelable)
  {
    paramParcelable = (Bundle)paramParcelable;
    switch (paramInt)
    {
    default:
      return;
    case 2:
      a(2131230867, 2131230957, 2131231008, null);
      TaskHelper.f(getActivity(), fr);
      return;
    case 3:
      B(2131230882);
      paramParcelable = (TreeEntity[])paramParcelable.getParcelableArray("parcel_deleted_notes");
      TaskHelper.d(getActivity(), fr, Arrays.asList(paramParcelable));
      return;
    case 4:
      B(2131230882);
      paramParcelable = com.google.android.keep.util.e.f(paramParcelable.getLongArray("parcel_deleted_note_ids"));
      TaskHelper.a(getActivity(), paramParcelable, fr.hl());
      return;
    case 5:
    }
    com.google.android.keep.util.a.a(eD, getString(2131231364));
    a(2131230867, 2131230999, 2131231008, null);
    fh.T(cR.aV().getName());
  }

  private void a(int paramInt, ToastListener paramToastListener)
  {
    if ((eN == null) || (eN.getTag() == null));
    int i;
    do
    {
      return;
      i = ((Set)eN.getTag()).size();
    }
    while (i == 0);
    if (i == 1)
    {
      paramToastListener.b(2131230867, paramInt, 2131231009, Long.valueOf(1L));
      return;
    }
    paramToastListener.b(2131230867, paramInt, 2131231010, Long.valueOf(i));
  }

  private void a(LayoutInflater paramLayoutInflater)
  {
    int i;
    if (eS == Config.UpgradeType.Px)
    {
      i = 2130968636;
      eQ = paramLayoutInflater.inflate(i, eD, false);
      eQ.setVisibility(0);
      paramLayoutInflater = (TextView)eQ.findViewById(2131493123);
      if (eS != Config.UpgradeType.Px)
        break label190;
      i = 2131231114;
    }
    while (true)
    {
      paramLayoutInflater.setText(Html.fromHtml(String.format(getResources().getString(i), new Object[] { Config.ob() })), TextView.BufferType.SPANNABLE);
      Spannable localSpannable = (Spannable)paramLayoutInflater.getText();
      URLSpan[] arrayOfURLSpan = paramLayoutInflater.getUrls();
      int j = arrayOfURLSpan.length;
      i = 0;
      while (i < j)
      {
        URLSpan localURLSpan = arrayOfURLSpan[i];
        localSpannable.setSpan(new BrowseFragment.10(this, localURLSpan.getURL()), localSpannable.getSpanStart(localURLSpan), localSpannable.getSpanEnd(localURLSpan), 33);
        localSpannable.removeSpan(localURLSpan);
        i += 1;
      }
      i = 2130968635;
      break;
      label190: if (eS == Config.UpgradeType.Pw)
        i = 2131231113;
      else
        i = 2131231112;
    }
    paramLayoutInflater.setMovementMethod(LinkMovementMethod.getInstance());
    paramLayoutInflater.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.q(c.this);
      }
    });
    if ((eS == Config.UpgradeType.Pw) || (eS == Config.UpgradeType.Pv))
      eQ.findViewById(2131493124).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = getActivity();
          c.b(c.this, 2131230867, 2131230958, 2131231020, Long.valueOf(KeepApplication.d(paramAnonymousView)));
          com.google.android.keep.util.A.al(paramAnonymousView);
          c.b(c.this, false);
          c.a(c.this, Config.UpgradeType.Pu);
          c.a(c.this, c.r(c.this), SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Mp);
        }
      });
  }

  private static void a(Menu paramMenu, int paramInt, boolean paramBoolean)
  {
    paramMenu = paramMenu.findItem(paramInt);
    if (paramMenu != null)
      paramMenu.setVisible(paramBoolean);
  }

  private void a(View paramView, SgvAnimationHelper.AnimationIn paramAnimationIn, SgvAnimationHelper.AnimationOut paramAnimationOut)
  {
    eE.removeHeaderView(paramView);
    eD.a(paramAnimationIn, paramAnimationOut);
    eE.notifyDataSetChanged();
  }

  private void a(final com.google.android.keep.location.g paramg)
  {
    final Note[] arrayOfNote = eE.bm();
    new com.google.android.keep.location.e(getActivity())
    {
      protected void c(List<Location> paramAnonymousList)
      {
        if ((paramAnonymousList == null) || (paramAnonymousList.size() <= 0))
          r.e("Keep", "Unexpected results from PlaceDetailsTask for " + paramg, new Object[0]);
        while (true)
        {
          return;
          if (arrayOfNote != null)
          {
            paramAnonymousList = (Location)paramAnonymousList.get(0);
            Note[] arrayOfNote = arrayOfNote;
            int j = arrayOfNote.length;
            int i = 0;
            while (i < j)
            {
              Note localNote = arrayOfNote[i];
              LocationReminder localLocationReminder = new LocationReminder(localNote.getId(), new Location(paramAnonymousList.r(getActivity()), paramAnonymousList.hW(), paramAnonymousList.hX(), paramAnonymousList.getRadius(), paramAnonymousList.hY(), paramAnonymousList.getPlaceId(), paramAnonymousList.getAddress()));
              c.n(c.this).a(localLocationReminder, localNote);
              i += 1;
            }
          }
        }
      }
    }
    .execute(new com.google.android.keep.location.g[] { paramg });
  }

  private void a(TreeEntity.TreeEntityType paramTreeEntityType, int paramInt, View paramView, String paramString)
  {
    paramView = new EditorNavigationRequest.a();
    paramView.h(paramTreeEntityType);
    paramView.ah(true);
    if (paramInt != 0)
      paramView.bt(paramInt);
    paramTreeEntityType = cR.aL();
    if (paramTreeEntityType.ka() == NavigationManager.NavigationMode.AP)
      paramView.b(bM());
    if ((paramTreeEntityType.ka() == NavigationManager.NavigationMode.AO) && ((paramTreeEntityType instanceof LabelNavigationRequest)))
      paramView.au(((LabelNavigationRequest)paramTreeEntityType).jX().gu());
    if (!TextUtils.isEmpty(paramString))
      paramView.aw(paramString);
    cR.b(paramView.jU());
  }

  private void a(ToastListener paramToastListener)
  {
    ((ToastsFragment)com.google.android.keep.util.e.a(getActivity(), 2131493048)).a(paramToastListener);
  }

  private void a(KeepTime paramKeepTime)
  {
    Note[] arrayOfNote = eE.bm();
    if (arrayOfNote == null);
    while (true)
    {
      return;
      int j = paramKeepTime.jm();
      long l = paramKeepTime.oq();
      int k = arrayOfNote.length;
      int i = 0;
      while (i < k)
      {
        paramKeepTime = arrayOfNote[i];
        TimeReminder localTimeReminder = new TimeReminder(paramKeepTime.getId(), j, l, 0);
        fi.a(localTimeReminder, paramKeepTime);
        i += 1;
      }
    }
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (bJ())
    {
      if (paramBoolean1);
      for (i = 1; paramBoolean2; i = 2)
      {
        mHandler.sendEmptyMessageDelayed(i, 100L);
        return;
      }
      i(paramBoolean1);
      return;
    }
    if (paramBoolean1);
    for (int i = 3; paramBoolean2; i = 4)
    {
      mHandler.sendEmptyMessageDelayed(i, 100L);
      return;
    }
    mHandler.sendEmptyMessage(i);
  }

  private b b(Cursor paramCursor)
  {
    if (bD())
      return new b(new n(getActivity(), se, paramCursor, fx, eF, Q.hl));
    NavigationManager.NavigationMode localNavigationMode = fc.ka();
    switch (12.cP[localNavigationMode.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Invalid browse navigation mode: " + localNavigationMode);
    case 1:
    case 3:
    case 4:
    case 5:
      paramCursor = new k(getActivity(), se, paramCursor, fx, eF);
      paramCursor.o(bn());
      if (localNavigationMode != NavigationManager.NavigationMode.AM)
        break;
    case 6:
    case 2:
    }
    for (boolean bool = true; ; bool = false)
    {
      paramCursor.n(bool);
      paramCursor.p(true);
      paramCursor.f(eM);
      return new b(paramCursor);
      paramCursor = new i(getActivity(), se, cR.aV(), paramCursor, fx, eF);
      break;
      paramCursor = new n(getActivity(), se, paramCursor, fx, eF, l.hl);
      break;
    }
  }

  public static c b(BrowseNavigationRequest paramBrowseNavigationRequest)
  {
    c localc = new c();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("args_browseRequest", paramBrowseNavigationRequest);
    localc.setArguments(localBundle);
    return localc;
  }

  private void b(LayoutInflater paramLayoutInflater)
  {
    eT = paramLayoutInflater.inflate(2130968630, eD, false);
    eT.findViewById(2131493110).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.c(c.this, 2131230867, 2131230954, 2131231020, null);
        com.google.android.keep.util.A.a(getActivity(), c.s(c.this).getName(), false);
        c.c(c.this, false);
        c.a(c.this, c.t(c.this), SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Mp);
      }
    });
    eT.findViewById(2131493111).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.d(c.this, 2131230867, 2131230955, 2131231020, null);
        C.a(c.s(c.this).hl(), true);
        com.google.android.keep.util.A.a(getActivity(), c.s(c.this).getName(), false);
        c.c(c.this, false);
        c.a(c.this, c.t(c.this), SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Mp);
      }
    });
  }

  private void bA()
  {
    fd = eD.nn();
  }

  private void bB()
  {
    ((ToastsFragment)com.google.android.keep.util.e.a(getActivity(), 2131493048)).ax(true);
  }

  private void bC()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (!com.google.android.keep.util.e.a(localFragmentActivity))
    {
      com.google.android.keep.util.e.b(localFragmentActivity, 2131231307);
      return;
    }
    a(2131230867, 2131230891, 2131231008, null);
    com.google.android.keep.util.e.c(getActivity(), 2131231309);
    Intent localIntent = new Intent(localFragmentActivity, DocsExportService.class);
    localIntent.putExtra("authAccount", fr.getName());
    localIntent.putExtra("treeEntityIds", eE.bg());
    localFragmentActivity.startService(localIntent);
  }

  private boolean bD()
  {
    return (!TextUtils.isEmpty(fs)) || ((eH != null) && (eZ > 0));
  }

  private void bE()
  {
    if ((fo != null) && (!fo.isEmpty()))
    {
      a(ToastListener.a(fo, getActivity(), eD));
      fo = null;
    }
  }

  private void bG()
  {
    if (((fc instanceof FilterBrowseNavigationRequest)) && (((FilterBrowseNavigationRequest)fc).jV() > 0))
    {
      String str = ((FilterBrowseNavigationRequest)fc).jW();
      if (!TextUtils.isEmpty(str))
        et.ax(str);
      et.bw(((FilterBrowseNavigationRequest)fc).jV());
    }
  }

  private void bH()
  {
    com.google.android.keep.util.A.ag(getActivity());
    eL = false;
    eE.removeHeaderView(eB);
    eD.a(SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Ms);
    eE.notifyDataSetChanged();
  }

  private boolean bJ()
  {
    return ((Boolean)Config.Pk.get()).booleanValue();
  }

  private boolean bK()
  {
    return fG.contains(fc.ka());
  }

  private int bL()
  {
    int i = 2131231026;
    BrowseNavigationRequest localBrowseNavigationRequest = cR.aL();
    if (localBrowseNavigationRequest.ka() == NavigationManager.NavigationMode.AP)
      i = 2131231027;
    while (localBrowseNavigationRequest.ka() != NavigationManager.NavigationMode.AO)
      return i;
    return 2131231028;
  }

  private BaseReminder bM()
  {
    return new TimeReminder(-1L, new KeepTime().jm() + 1, U.kI() * 3600000L, 1);
  }

  private boolean bn()
  {
    NavigationManager.NavigationMode localNavigationMode = fc.ka();
    return (localNavigationMode == NavigationManager.NavigationMode.AM) || (localNavigationMode == NavigationManager.NavigationMode.AO);
  }

  private boolean bu()
  {
    return (!C.e(fr.hl())) && (com.google.android.keep.util.A.t(getActivity(), fr.getName())) && (fc.ka() == NavigationManager.NavigationMode.AM);
  }

  private void bv()
  {
    a(2131230867, 2131230959, 2131231020, Long.valueOf(KeepApplication.d(getActivity())));
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Config.ob())));
  }

  private boolean bw()
  {
    if (eD == null);
    View localView;
    do
    {
      return true;
      if (eD.nl() > 0)
        return false;
      localView = eD.getChildAt(0);
    }
    while ((localView == null) || (localView.getTop() >= ew));
    return false;
  }

  private boolean bx()
  {
    return (eR) && (eS == Config.UpgradeType.Px);
  }

  private void bz()
  {
    if (eM);
    for (int i = ez; ; i = 1)
    {
      if (eD.getColumnCount() != i)
      {
        eD.setColumnCount(i);
        eD.aM(eM);
      }
      return;
    }
  }

  private void c(LayoutInflater paramLayoutInflater)
  {
    eP = paramLayoutInflater.inflate(2130968634, eD, false);
    eP.findViewById(2131493122).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.e(c.this, 2131230867, 2131230956, 2131231020, null);
        com.google.android.keep.util.A.f(getActivity(), false);
        c.a(c.this, c.u(c.this), SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Ms);
      }
    });
  }

  private void f(Bundle paramBundle)
  {
    eH = et.kb();
    eH.k(paramBundle);
    eH.a(fv);
  }

  private void g(NavigationManager.NavigationMode paramNavigationMode)
  {
    int i;
    if (et.kg())
      i = ColorMap.L(i.g.Co).intValue();
    while (true)
    {
      et.setStatusBarBackground(i);
      return;
      switch (12.cP[paramNavigationMode.ordinal()])
      {
      default:
        i = getResources().getColor(2131296372);
        break;
      case 1:
      case 2:
      case 3:
      case 6:
        i = getResources().getColor(2131296396);
        break;
      case 4:
        i = getResources().getColor(2131296372);
        break;
      case 5:
        i = getResources().getColor(2131296397);
      }
    }
  }

  private void g(boolean paramBoolean)
  {
    int j = 1;
    Bundle localBundle = new Bundle();
    boolean bool = bD();
    int i;
    label29: LoaderManager.LoaderCallbacks localLoaderCallbacks;
    if (bool)
    {
      i = 2;
      if (!bool)
        break label88;
      if (!bool)
        break label93;
      localLoaderCallbacks = fC;
      label40: if (!bool)
        break label102;
      localBundle.putString("loader_query", fs);
    }
    while (true)
    {
      getLoaderManager().destroyLoader(j);
      if (!paramBoolean)
        break label117;
      getLoaderManager().restartLoader(i, localBundle, localLoaderCallbacks);
      return;
      i = 1;
      break;
      label88: j = 2;
      break label29;
      label93: localLoaderCallbacks = fB;
      break label40;
      label102: localBundle.putParcelable("loader_browseRequest", fc);
    }
    label117: getLoaderManager().initLoader(i, localBundle, localLoaderCallbacks);
  }

  private void h(boolean paramBoolean)
  {
    if ((eE == null) || (eD == null));
    label352: label371: 
    while (true)
    {
      return;
      eE.cn();
      eE.co();
      if (fp == -1)
        fp = ((int)getResources().getDimension(2131427501));
      if ((!KeepApplication.ap()) && (ew <= 0))
        ew = et.kj().getHeight();
      int k = (int)getResources().getDimension(2131427520);
      int j = 0;
      int i;
      if (et.kg())
      {
        i = eH.mE();
        k += i;
        i = j;
        if (bJ())
        {
          i = j;
          if (bK())
            i = 0 + ew;
        }
        if (eU)
          eE.addHeaderView(eT);
        if (eR)
          eE.addHeaderView(eQ);
        if ((eL) && (!bD()))
          eE.addHeaderView(eB);
        if ((eD.getPaddingTop() != k) || (eD.getPaddingBottom() != i) || (eD.getPaddingLeft() != fp) || (eD.getPaddingRight() != fp))
        {
          f.c localc1 = f.c.f(eD);
          if (!paramBoolean)
            break label352;
          f.c localc2 = new f.c(fp, k, fp, i);
          f.a(eD, localc1, localc2).start();
        }
      }
      while (true)
      {
        if (fc.ka() != NavigationManager.NavigationMode.AQ)
          break label371;
        if ((!ft) || (!com.google.android.keep.util.A.ah(getActivity())))
          break label373;
        eE.addHeaderView(eP);
        return;
        i = ew;
        break;
        com.google.android.keep.util.e.setPaddingRelative(eD, fp, k, fp, i);
      }
    }
    label373: eE.removeHeaderView(eP);
  }

  private void i(boolean paramBoolean)
  {
    if (eO == null)
      return;
    if (paramBoolean)
    {
      eO.show();
      return;
    }
    eO.hide();
  }

  private void j(boolean paramBoolean)
  {
    if ((paramBoolean) && (eI));
    while ((!paramBoolean) && (!eI))
      return;
    if (paramBoolean)
      f.c(ea).start();
    while (true)
    {
      eI = paramBoolean;
      g(fc.ka());
      return;
      f.d(ea).start();
    }
  }

  private void x(int paramInt)
  {
    paramInt = fA[paramInt];
    KeepTime localKeepTime = null;
    switch (paramInt)
    {
    default:
      if (localKeepTime != null)
      {
        a(localKeepTime);
        by();
      }
      break;
    case 0:
    case 1:
    case 2:
    }
    do
    {
      return;
      localKeepTime = x.cH(0);
      B(2131230948);
      break;
      localKeepTime = x.cH(1);
      B(2131230949);
      break;
      localKeepTime = x.cH(2);
      B(2131230950);
      break;
      if (paramInt == 3)
      {
        if (fq == null)
          fq = new KeepTime();
        x.a(this, new KeepTime(), fy);
        B(2131230951);
        return;
      }
    }
    while (paramInt != 4);
    if (((Boolean)Config.Pl.get()).booleanValue())
      x.a(this, null);
    while (true)
    {
      B(2131230952);
      return;
      x.b(this, null, null);
    }
  }

  private void z(int paramInt)
  {
    if (!ex);
    ObjectAnimator localObjectAnimator;
    do
    {
      return;
      localObjectAnimator = f.c(et.kj(), paramInt, null);
    }
    while (localObjectAnimator == null);
    localObjectAnimator.start();
  }

  public void C(int paramInt)
  {
    by();
    int i = 0;
    int j = bL();
    TreeEntity.TreeEntityType localTreeEntityType;
    switch (paramInt)
    {
    default:
      throw new IllegalStateException("Unsupported item clicked in Quick edit box.");
    case 2:
      localTreeEntityType = TreeEntity.TreeEntityType.zP;
      a(2131230864, 2131230872, j, null);
      paramInt = i;
    case 4:
      while (true)
      {
        a(localTreeEntityType, paramInt, null, null);
        fb = true;
        return;
        localTreeEntityType = TreeEntity.TreeEntityType.zO;
        paramInt = 2;
        a(2131230865, 2131230872, j, null);
      }
    case 8:
    }
    a(2131230866, 2131230897, j, null);
    new SingleSelectDialogFragment.a(this, 6).o(getString(2131231055)).a(fF).Y(2130968657).Z(2131493145).aa(2131492985).show();
  }

  protected String S()
  {
    switch (12.cP[fc.ka().ordinal()])
    {
    default:
      return getString(2131230851);
    case 1:
      return getString(2131230854);
    case 2:
    case 3:
    }
    return getString(2131230855);
  }

  public final ActionMode.Callback a(final MenuInflater paramMenuInflater)
  {
    return new ActionMode.Callback()
    {
      private int d(long[] paramAnonymousArrayOfLong)
      {
        if (paramAnonymousArrayOfLong == null)
          return 2131231368;
        int k = 0;
        int m = paramAnonymousArrayOfLong.length;
        int i = 0;
        while (true)
        {
          int j = k;
          if (i < m)
          {
            long l = paramAnonymousArrayOfLong[i];
            if (c.v(c.this).v(l).size() > 0)
              j = 1;
          }
          else
          {
            if (j != 0)
              break;
            return 2131231369;
          }
          i += 1;
        }
      }

      public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        Object localObject = (Set)paramAnonymousActionMode.getTag();
        if (localObject == null)
          return false;
        paramAnonymousActionMode = new ArrayList();
        paramAnonymousActionMode.addAll((Collection)localObject);
        int i = paramAnonymousActionMode.size();
        long l;
        int m;
        int k;
        int n;
        switch (paramAnonymousMenuItem.getItemId())
        {
        case 2131493424:
        case 2131493431:
        case 2131493432:
        case 2131493433:
        case 2131493434:
        case 2131493435:
        case 2131493436:
        case 2131493438:
        default:
          return false;
        case 2131493439:
          c.a(c.this, 2131230901);
          paramAnonymousActionMode = x.a(getActivity(), c.w(c.this));
          new SingleSelectDialogFragment.a(c.this, 1).o(getString(2131231073)).a(paramAnonymousActionMode).show();
          return true;
        case 2131493425:
          paramAnonymousMenuItem = b(Arrays.asList(c.k(c.this).bm()), true);
          c.a(c.this, 2131230886, paramAnonymousMenuItem);
          c.a(c.this, paramAnonymousMenuItem);
          if (c.j(c.this).ka() == NavigationManager.NavigationMode.AO)
          {
            paramAnonymousActionMode = paramAnonymousActionMode.iterator();
            while (paramAnonymousActionMode.hasNext())
            {
              l = ((Long)paramAnonymousActionMode.next()).longValue();
              c.k(c.this).a(l, SgvAnimationHelper.TranslationAnimationType.Mw);
            }
          }
          by();
          return true;
        case 2131493426:
          paramAnonymousMenuItem = b(Arrays.asList(c.k(c.this).bm()), false);
          c.a(c.this, 2131230885, paramAnonymousMenuItem);
          c.a(c.this, paramAnonymousMenuItem);
          if (c.j(c.this).ka() == NavigationManager.NavigationMode.AO)
          {
            paramAnonymousActionMode = paramAnonymousActionMode.iterator();
            while (paramAnonymousActionMode.hasNext())
            {
              l = ((Long)paramAnonymousActionMode.next()).longValue();
              c.k(c.this).a(l, SgvAnimationHelper.TranslationAnimationType.Mw);
            }
          }
          by();
          return true;
        case 2131493428:
          if (c.j(c.this).ka() == NavigationManager.NavigationMode.AQ)
          {
            paramAnonymousActionMode = getResources().getQuantityString(2131755025, paramAnonymousActionMode.size(), new Object[] { Integer.valueOf(paramAnonymousActionMode.size()) });
            paramAnonymousMenuItem = new Bundle();
            paramAnonymousMenuItem.putParcelableArray("parcel_deleted_notes", c.k(c.this).bm());
            new com.google.android.keep.ui.b.a(c.this, 3).bi(paramAnonymousActionMode).bP(2131231075).a(paramAnonymousMenuItem).show();
          }
          while (true)
          {
            by();
            return true;
            paramAnonymousMenuItem = c.k(c.this).bm();
            m = 0;
            j = 0;
            i = 0;
            int i1 = paramAnonymousMenuItem.length;
            k = 0;
            if (k < i1)
            {
              localObject = (Note)paramAnonymousMenuItem[k];
              boolean bool1 = ((Note)localObject).ip();
              boolean bool2 = ((Note)localObject).iD();
              if ((bool1) && (!bool2))
              {
                n = 1;
                n = m | n;
                if ((!bool1) || (!bool2))
                  break label664;
                m = 1;
                m = j | m;
                if (bool1)
                  break label670;
              }
              for (j = 1; ; j = 0)
              {
                i |= j;
                k += 1;
                j = m;
                m = n;
                break;
                n = 0;
                break label601;
                m = 0;
                break label621;
              }
            }
            if ((m != 0) || (j != 0))
            {
              if (paramAnonymousMenuItem.length > 1)
              {
                n = 1;
                if (n == 0)
                  break label786;
                k = 2131231182;
                if ((m == 0) || (j != 0) || (i != 0))
                  break label800;
                if (n == 0)
                  break label793;
              }
              for (i = 2131231184; ; i = 2131231183)
              {
                paramAnonymousMenuItem = new Bundle();
                paramAnonymousMenuItem.putLongArray("parcel_deleted_note_ids", com.google.android.keep.util.e.G(paramAnonymousActionMode));
                new com.google.android.keep.ui.b.a(c.this, 4).bN(k).bO(i).bP(2131231075).a(paramAnonymousMenuItem).show();
                break;
                n = 0;
                break label695;
                k = 2131231181;
                break label704;
              }
              if (n != 0);
              for (i = 2131231186; ; i = 2131231185)
                break;
            }
            paramAnonymousActionMode = b(paramAnonymousActionMode);
            c.a(c.this, 2131230883, paramAnonymousActionMode);
            c.a(c.this, paramAnonymousActionMode);
          }
        case 2131493423:
          c.a(c.this, 2131230992);
          c.h(c.this).c(com.google.android.keep.util.e.G(paramAnonymousActionMode));
          by();
          return true;
        case 2131493429:
          TaskHelper.a(getActivity(), ((Long)paramAnonymousActionMode.get(0)).longValue(), c.x(c.this));
          by();
          return true;
        case 2131493437:
          c.y(c.this);
          by();
          return true;
        case 2131493427:
          c.z(c.this).a(SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Mt);
          paramAnonymousActionMode = new ToastListener.f(getActivity(), paramAnonymousActionMode, c.z(c.this));
          c.a(c.this, 2131230884, paramAnonymousActionMode);
          c.a(c.this, paramAnonymousActionMode);
          by();
          return true;
        case 2131493430:
          label601: label621: if (i != 1)
            return true;
          label664: label670: label695: label704: new com.google.android.keep.task.e(getActivity(), ((Long)paramAnonymousActionMode.get(0)).longValue())
          {
            protected void e(Intent paramAnonymous2Intent)
            {
              if (paramAnonymous2Intent != null)
              {
                c.a(c.this, 2131230890);
                startActivityForResult(paramAnonymous2Intent, 3);
              }
            }
          }
          .execute(new Void[0]);
          label786: label793: label800: return true;
        case 2131493440:
        }
        c.a(c.this, 2131230900);
        c.b(c.this, 1);
        i = -1;
        paramAnonymousActionMode = c.k(c.this).bm();
        int j = i;
        if (paramAnonymousActionMode != null)
        {
          n = paramAnonymousActionMode.length;
          k = 0;
          j = i;
          if (k < n)
          {
            m = paramAnonymousActionMode[k].iz().getValue();
            if (i == -1)
              j = m;
            do
            {
              k += 1;
              i = j;
              break;
              j = i;
            }
            while (i == m);
            j = -1;
          }
        }
        d.a(j, c.this);
        return true;
      }

      public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        paramMenuInflater.inflate(2131820548, paramAnonymousMenu);
        c.a(c.this, false, false);
        return true;
      }

      public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
      {
        if (c.k(c.this) != null)
          c.k(c.this).bf();
        c.a(c.this, c.A(c.this), true);
        c.a(c.this, null);
        paramAnonymousActionMode = c.this;
        c.b(c.this);
        paramAnonymousActionMode = paramAnonymousActionMode.getString(com.google.android.keep.navigation.a.p(c.j(c.this).ka()));
        c.b(c.this).ay(paramAnonymousActionMode);
        getActivity().invalidateOptionsMenu();
      }

      public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        long[] arrayOfLong = c.k(c.this).bg();
        if ((arrayOfLong == null) || (arrayOfLong.length == 0))
          return false;
        paramAnonymousActionMode.setTitle(getString(2131231116, new Object[] { Integer.valueOf(arrayOfLong.length) }));
        c.b(c.this).ay(getString(2131231116, new Object[] { Integer.valueOf(arrayOfLong.length) }));
        paramAnonymousActionMode = c.j(c.this).ka();
        if (c.k(c.this).bj() > 0)
          com.google.android.keep.util.e.a(paramAnonymousMenu);
        while (true)
        {
          return true;
          if (paramAnonymousActionMode == NavigationManager.NavigationMode.AM)
          {
            paramAnonymousMenu.findItem(2131493425).setVisible(true);
            paramAnonymousMenu.findItem(2131493439).setVisible(true);
            paramAnonymousMenu.findItem(2131493440).setVisible(true);
            paramAnonymousActionMode = paramAnonymousMenu.findItem(2131493423);
            paramAnonymousActionMode.setVisible(true);
            paramAnonymousActionMode.setTitle(d(arrayOfLong));
            paramAnonymousMenu.findItem(2131493437).setVisible(((Boolean)Config.Po.get()).booleanValue());
            paramAnonymousActionMode = paramAnonymousMenu.findItem(2131493429);
            if (arrayOfLong.length == 1)
            {
              bool = true;
              label248: paramAnonymousActionMode.setVisible(bool);
              paramAnonymousActionMode = paramAnonymousMenu.findItem(2131493430);
              if (arrayOfLong.length != 1)
                break label327;
            }
            label327: for (bool = true; ; bool = false)
            {
              paramAnonymousActionMode.setVisible(bool);
              paramAnonymousMenu.findItem(2131493426).setVisible(false);
              paramAnonymousMenu.findItem(2131493427).setVisible(false);
              break;
              bool = false;
              break label248;
            }
          }
          if (paramAnonymousActionMode != NavigationManager.NavigationMode.AQ)
            break;
          paramAnonymousMenu.findItem(2131493425).setVisible(false);
          paramAnonymousMenu.findItem(2131493426).setVisible(false);
          paramAnonymousMenu.findItem(2131493439).setVisible(false);
          paramAnonymousMenu.findItem(2131493440).setVisible(false);
          paramAnonymousMenu.findItem(2131493423).setVisible(false);
          paramAnonymousMenu.findItem(2131493430).setVisible(false);
          paramAnonymousMenu.findItem(2131493429).setVisible(false);
          paramAnonymousMenu.findItem(2131493437).setVisible(false);
          paramAnonymousMenu.findItem(2131493427).setVisible(true);
          paramAnonymousMenu.findItem(2131493428).setVisible(true);
          paramAnonymousMenu.findItem(2131493428).setTitle(2131231078);
        }
        int j = c.k(c.this).bh();
        int i = c.k(c.this).bi();
        if ((j > 0) && (i > 0))
        {
          i = 1;
          label555: paramAnonymousMenu.findItem(2131493439).setVisible(true);
          paramAnonymousMenu.findItem(2131493440).setVisible(true);
          MenuItem localMenuItem = paramAnonymousMenu.findItem(2131493423);
          localMenuItem.setVisible(true);
          localMenuItem.setTitle(d(arrayOfLong));
          paramAnonymousMenu.findItem(2131493437).setVisible(((Boolean)Config.Po.get()).booleanValue());
          localMenuItem = paramAnonymousMenu.findItem(2131493429);
          if ((arrayOfLong.length != 1) || (paramAnonymousActionMode == NavigationManager.NavigationMode.AN))
            break label775;
          bool = true;
          label676: localMenuItem.setVisible(bool);
          paramAnonymousActionMode = paramAnonymousMenu.findItem(2131493430);
          if (arrayOfLong.length != 1)
            break label781;
        }
        label775: label781: for (boolean bool = true; ; bool = false)
        {
          paramAnonymousActionMode.setVisible(bool);
          paramAnonymousMenu.findItem(2131493427).setVisible(false);
          if (i == 0)
            break label787;
          paramAnonymousMenu.findItem(2131493426).setVisible(false);
          paramAnonymousMenu.findItem(2131493425).setVisible(true);
          break;
          i = 0;
          break label555;
          bool = false;
          break label676;
        }
        label787: if (j > 0)
        {
          bool = true;
          label795: paramAnonymousMenu.findItem(2131493426).setVisible(bool);
          paramAnonymousActionMode = paramAnonymousMenu.findItem(2131493425);
          if (bool)
            break label848;
        }
        label848: for (bool = true; ; bool = false)
        {
          paramAnonymousActionMode.setVisible(bool);
          break;
          bool = false;
          break label795;
        }
      }
    };
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (et.kg())
    {
      et.kh();
      com.google.android.keep.util.e.B(eC);
    }
    bB();
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3)
      by();
    while ((paramInt2 != -1) || (paramInt1 != 12))
      return;
    a(PlacePicker.getPlace(paramIntent, getActivity()));
    by();
  }

  public void a(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
    if (paramInt2 == 1)
      a(paramInt1, paramParcelable);
  }

  public void a(Context paramContext, com.google.android.keep.location.g paramg)
  {
    a(paramg);
    by();
  }

  public void a(View paramView, int paramInt1, int paramInt2)
  {
    g(paramView);
  }

  public void a(Place paramPlace)
  {
    Note[] arrayOfNote = eE.bm();
    if (arrayOfNote == null);
    while (true)
    {
      return;
      paramPlace = new Location(paramPlace);
      int j = arrayOfNote.length;
      int i = 0;
      while (i < j)
      {
        Note localNote = arrayOfNote[i];
        LocationReminder localLocationReminder = new LocationReminder(localNote.getId(), paramPlace);
        fi.a(localLocationReminder, localNote);
        i += 1;
      }
    }
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!fg.ih());
    Label localLabel;
    do
    {
      do
        return;
      while (fc.ka() != NavigationManager.NavigationMode.AO);
      localLabel = cR.aV();
      if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wV }))
      {
        et.setTitle(localLabel.getName());
        return;
      }
    }
    while ((!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wX })) || (fh.Q(localLabel.gu()) != null));
    fc = new BrowseNavigationRequest(NavigationManager.NavigationMode.AM);
    cR.f(fc.ka());
  }

  public void a(StaggeredGridView paramStaggeredGridView, int paramInt)
  {
  }

  public boolean a(View paramView, long paramLong, int paramInt1, int paramInt2)
  {
    if (!isAdded())
      return false;
    a(2131230867, 2131230916, 2131231020, null);
    boolean bool;
    if (eE.w(paramInt2))
      if (paramInt2 + 1 < eE.getCount())
      {
        bool = true;
        paramInt2 += 1;
      }
    while (true)
    {
      TreeEntity localTreeEntity = (TreeEntity)eE.getItem(paramInt2);
      if ((localTreeEntity == null) || (((!bool) || (paramInt1 + 1 == paramInt2)) && ((bool) || (paramInt1 - 1 == paramInt2))))
        break;
      eE.a(paramView, 1);
      TaskHelper.a(getActivity(), paramLong, localTreeEntity.getId(), bool);
      eD.a(SgvAnimationHelper.AnimationIn.Mj, SgvAnimationHelper.AnimationOut.Mp);
      by();
      return true;
      bool = false;
      paramInt2 -= 1;
      continue;
      bool = true;
    }
    eE.a(paramView, 1);
    eE.notifyDataSetChanged();
    return false;
  }

  ToastListener.g b(List<Long> paramList)
  {
    return new ToastListener.g(getActivity(), paramList, eD);
  }

  ToastListener b(List<? extends TreeEntity> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TreeEntity localTreeEntity = (TreeEntity)paramList.next();
      localArrayList1.add(Long.valueOf(localTreeEntity.getId()));
      localArrayList2.add(Long.valueOf(localTreeEntity.jt()));
    }
    return new ToastListener.a(getActivity(), localArrayList1, localArrayList2, eD, paramBoolean);
  }

  public void b(View paramView, int paramInt)
  {
    if (eE == null);
    while (!eE.R(paramInt))
      return;
    by();
    eD.a(SgvAnimationHelper.AnimationIn.Mk, SgvAnimationHelper.AnimationOut.Mp);
    eE.v(paramInt);
    eE.notifyDataSetChanged();
  }

  public void bF()
  {
    NavigationManager.NavigationMode localNavigationMode = fc.ka();
    et.a(getActivity(), localNavigationMode);
    if (localNavigationMode == NavigationManager.NavigationMode.AO)
      et.setTitle(cR.aV().getName());
    g(localNavigationMode);
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public String bo()
  {
    Note[] arrayOfNote = eE.bm();
    if ((arrayOfNote != null) && (arrayOfNote.length != 0))
      return arrayOfNote[0].gu();
    return "";
  }

  public void bp()
  {
  }

  public void bq()
  {
    if (et.kg())
    {
      et.kf();
      return;
    }
    ((BrowseActivity)getActivity()).P();
  }

  public void br()
  {
    h(true);
    if (bK())
      a(false, true);
    eG.setEnabled(false);
    bF();
  }

  public void bs()
  {
    h(true);
    getActivity().invalidateOptionsMenu();
    a(bK(), true);
    eG.setEnabled(true);
    bF();
  }

  public void bt()
  {
    et.kf();
    by();
  }

  public void by()
  {
    a(bK(), false);
    if (eN != null)
      eN.finish();
  }

  public void c(View paramView, int paramInt)
  {
    com.google.android.keep.util.e.B(eD);
    eD.a(SgvAnimationHelper.AnimationIn.Mk, SgvAnimationHelper.AnimationOut.Mp);
    eE.a(paramView, 0);
  }

  public void g(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return;
    case 6:
      D(paramInt2);
      return;
    case 1:
    }
    x(paramInt2);
  }

  public void g(View paramView)
  {
    eD.a(SgvAnimationHelper.AnimationIn.Mh, SgvAnimationHelper.AnimationOut.Mp);
    eE.a(paramView, 1);
    paramView.setVisibility(0);
    eE.notifyDataSetChanged();
  }

  public void h(String paramString)
  {
    int n = 0;
    r.a("Keep", "onSearch: " + paramString, new Object[0]);
    Object localObject3 = Lists.newArrayList();
    Object localObject4 = Lists.newArrayList();
    int i = 0;
    Object localObject1 = "INVALID_COLOR";
    Object localObject2 = localObject1;
    if (eH != null)
    {
      localObject3 = eH.mG();
      localObject4 = eH.mF();
      if (!((List)localObject3).isEmpty())
        localObject1 = (String)((List)localObject3).get(0);
      i = ((List)localObject3).size() + ((List)localObject4).size();
      localObject2 = localObject1;
    }
    m.a.q((List)localObject3);
    m.a.r((List)localObject4);
    if (TextUtils.equals(paramString, Config.oc()))
    {
      localObject1 = getActivity();
      if (localObject1 != null)
        com.google.android.keep.util.A.l((Context)localObject1, System.currentTimeMillis());
    }
    if (!isAdded())
      return;
    boolean bool;
    int m;
    int j;
    if ((!TextUtils.equals(fs, paramString)) || (i != eZ) || (!TextUtils.equals(fa, localObject2)))
    {
      bool = true;
      if ((i != 0) || (TextUtils.isEmpty(fs) == TextUtils.isEmpty(paramString)))
      {
        m = n;
        if (!TextUtils.isEmpty(paramString))
          break label262;
        if (eZ != 0)
          break label309;
        j = 1;
        label242: if (i != 0)
          break label314;
      }
    }
    label262: label309: label314: for (int k = 1; ; k = 0)
    {
      m = n;
      if (j != k)
        m = 1;
      if (m != 0)
      {
        eE = null;
        eD.a(null);
      }
      fa = localObject2;
      eZ = i;
      fs = paramString;
      g(bool);
      return;
      bool = false;
      break;
      j = 0;
      break label242;
    }
  }

  public void j(String paramString)
  {
    if (!bK());
    do
    {
      return;
      by();
    }
    while (TextUtils.isEmpty(paramString));
    fb = true;
    a(2131230863, 2131230875, 2131231011, null);
    paramString = new TreeEntityTask.a(getActivity()).o(Long.valueOf(fr.getId())).i(TreeEntity.TreeEntityType.zO).a(new m(paramString, false, KeepProvider.kw()));
    if (cR.aL().ka() == NavigationManager.NavigationMode.AP)
      paramString.d(bM());
    paramString.lG().execute(new Void[0]);
    TaskHelper.a(getActivity(), fr.hl(), -1L);
    com.google.android.keep.util.a.a(eC, getResources().getString(2131231101));
  }

  public void k(String paramString)
  {
    a(2131230863, 2131230872, bL(), null);
    by();
    a(TreeEntity.TreeEntityType.zO, 0, null, paramString);
  }

  public void k(boolean paramBoolean)
  {
    j(paramBoolean);
    if (paramBoolean)
    {
      if (eO.getTranslationY() == 0.0F)
        eD.scrollBy(0, -ew);
      z(-ew);
    }
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    BrowseActivity localBrowseActivity = (BrowseActivity)getActivity();
    fr = com.google.android.keep.util.o.O(localBrowseActivity);
    if (fr == null)
    {
      localBrowseActivity.finish();
      return;
    }
    ex = localBrowseActivity.getResources().getBoolean(2131623946);
    Toolbar localToolbar = (Toolbar)eC.findViewById(2131493059);
    localToolbar.setTitle("");
    localToolbar.setMenuCallbacks(this, this);
    eH = ((SearchFilterLayout)eC.findViewById(2131493329));
    localBrowseActivity.setSupportActionBar(localToolbar);
    localBrowseActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    et = new com.google.android.keep.navigation.a(localBrowseActivity, localToolbar, eH);
    et.a(localBrowseActivity.H());
    et.a(this);
    bF();
    et.ai(true);
    f(paramBundle);
    if (paramBundle != null)
    {
      et.d(paramBundle);
      if (paramBundle.getBoolean("savedState_isSearchFilterVisible", false))
        et.aj(false);
    }
    bG();
    if ((bK()) && (!et.kg()))
    {
      bool = true;
      a(bool, false);
      eE = b(null);
      eD.a(eE);
      paramBundle = localBrowseActivity.getLayoutInflater();
      if ((!com.google.android.keep.util.A.ai(localBrowseActivity)) || (fc.ka() != NavigationManager.NavigationMode.AM))
        break label386;
    }
    label386: for (boolean bool = true; ; bool = false)
    {
      eR = bool;
      eS = com.google.android.keep.util.A.aj(localBrowseActivity);
      if (eR)
        a(paramBundle);
      eU = bu();
      if (eU)
        b(paramBundle);
      if (fc.ka() == NavigationManager.NavigationMode.AQ)
        c(paramBundle);
      fF = new SingleSelectDialogFragment.OptionItem[] { new SingleSelectDialogFragment.OptionItem(getString(2131231053), 2130837672), new SingleSelectDialogFragment.OptionItem(getString(2131231054), 2130837683) };
      return;
      bool = false;
      break;
    }
  }

  public boolean onBackPressed()
  {
    if (et.kg())
    {
      et.kf();
      return true;
    }
    if ((!bJ()) && (ey.cc()))
    {
      ey.cf();
      return true;
    }
    return false;
  }

  public void onClick(View paramView)
  {
    if ((paramView == ea) && (ea.getAlpha() == 1.0F))
    {
      j(false);
      eO.mx();
    }
  }

  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (fu)
    {
      fu = false;
      a(2131230867, 2131230918, 2131231008, null);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    super.onCreate(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    TypedValue localTypedValue = new TypedValue();
    if ((KeepApplication.ap()) && (localFragmentActivity.getTheme().resolveAttribute(16843499, localTypedValue, true)))
      ew = TypedValue.complexToDimensionPixelSize(localTypedValue.data, getResources().getDisplayMetrics());
    ez = localFragmentActivity.getResources().getInteger(2131361808);
    fg = new com.google.android.keep.model.o(localFragmentActivity, this, se);
    fh = ((com.google.android.keep.model.l)fg.e(com.google.android.keep.model.l.class));
    cR = ((a)Binder.a(localFragmentActivity, a.class));
    eF = ((com.google.android.keep.ui.c)Binder.a(localFragmentActivity, com.google.android.keep.ui.c.class));
    fi = ((com.google.android.keep.model.A)Binder.a(localFragmentActivity, com.google.android.keep.model.A.class));
    long l;
    int i;
    if (paramBundle != null)
    {
      fc = ((BrowseNavigationRequest)paramBundle.getParcelable("savedState_browseResult"));
      cR.a(fc);
      eY = paramBundle.getBoolean("savedState_playFirstLoadAnimation", true);
      fd = ((StaggeredGridView.ScrollState)paramBundle.getParcelable("savedState_scrollState"));
      eW = paramBundle.getBoolean("savedState_showLoadingSpinner");
      ff = paramBundle.getLongArray("savedState_selectedIds");
      fj = paramBundle.getInt("savedState_selectedArchivedCount", 0);
      fk = paramBundle.getInt("savedState_selectedUnarchivedCount", 0);
      fl = paramBundle.getInt("savedState_selectedConflictCount", 0);
      fm = paramBundle.getInt("savedState_selectedNonOwnedSharedNoteCount", 0);
      fn = paramBundle.getInt("savedState_selectedOwnedSharedNoteCount", 0);
      eZ = paramBundle.getInt("savedState_numberOfSelectedFilters");
      fa = paramBundle.getString("savedState_selectedColorFilter");
      fo = paramBundle.getBundle("savedState_undoBarBundle");
      eV = paramBundle.getInt("savedState_colorPickerMode", 0);
      fs = paramBundle.getString("savedState_query");
      cR.a((Label)paramBundle.getParcelable("savedState_currentLabel"));
      l = paramBundle.getLong("savedState_reminderTime");
      if (l == 0L)
      {
        fq = null;
        paramBundle = new StringBuilder().append("Restoring saved instance state:\n    browse request: ").append(fc).append("\n").append("    show loading spinner: ").append(eW).append("    number of items selected:");
        if (ff != null)
          break label569;
        i = 0;
        label446: r.a("Keep", i, new Object[0]);
      }
    }
    while (true)
    {
      if (fc == null)
      {
        fc = new BrowseNavigationRequest(NavigationManager.NavigationMode.AM);
        cR.a(fc);
      }
      boolean bool1 = bool2;
      if (com.google.android.keep.util.A.af(localFragmentActivity))
      {
        bool1 = bool2;
        if (!ActivityManager.isRunningInTestHarness())
        {
          bool1 = bool2;
          if (fc.ka() == NavigationManager.NavigationMode.AM)
            bool1 = true;
        }
      }
      eL = bool1;
      x.a(this, fy, fz);
      return;
      fq = new KeepTime(l);
      break;
      label569: i = ff.length;
      break label446;
      if (getArguments() != null)
      {
        fc = ((BrowseNavigationRequest)getArguments().getParcelable("args_browseRequest"));
        cR.a(fc);
      }
    }
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131820544, paramMenu);
    if (KeepApplication.ao())
      onPrepareOptionsMenu(et.ki());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = true;
    eC = ((ViewGroup)paramLayoutInflater.inflate(2130968609, null));
    eX = ((MinTimeProgressView)eC.findViewById(2131493095));
    paramViewGroup = eX;
    int i;
    if (eW)
    {
      i = 0;
      paramViewGroup.setVisibility(i);
      eD = ((StaggeredGridView)eC.findViewById(2131493060));
      eD.a(this);
      eD.a(this);
      eD.setOnTouchListener(this);
      eD.setHapticFeedbackEnabled(true);
      eD.a(this);
      ea = eC.findViewById(2131493057);
      ea.setOnClickListener(this);
      i = (int)getResources().getDimension(2131427523);
      int j = (int)getResources().getDimension(2131427522);
      eD.cp(j - i);
      eM = com.google.android.keep.util.A.X(getActivity());
      paramViewGroup = eD;
      if (!eM)
        break label467;
      i = ez;
      label202: paramViewGroup.setColumnCount(i);
      eD.aM(eM);
      eO = ((QuickEditLayout)getActivity().findViewById(2131493040));
      if (bJ())
        break label473;
      eO.setVisibility(8);
      label252: if (eL)
      {
        eB = paramLayoutInflater.inflate(2130968637, eD, false);
        if (eB != null)
        {
          eB.setOnClickListener(null);
          eK = new a(null);
          eJ = new q(getActivity(), eB, eK, VelocityTracker.obtain(), true);
          eB.setOnTouchListener(eJ);
          eB.findViewById(2131493125).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              c.o(c.this);
            }
          });
        }
      }
      setHasOptionsMenu(true);
      eG = ((BrowseSwipeRefreshLayout)eC.findViewById(2131493056));
      eG.setColorScheme(new int[] { 2131296433, 2131296434, 2131296435, 2131296436 });
      eG.setOnRefreshListener(this);
      paramLayoutInflater = eG;
      if (eW)
        break label484;
    }
    while (true)
    {
      paramLayoutInflater.setEnabled(bool);
      com.google.android.keep.syncadapter.g.a(new g.a()
      {
        public void bS()
        {
          c.p(c.this).post(new Runnable()
          {
            public void run()
            {
              c.c(c.this).setRefreshing(false);
            }
          });
        }
      });
      return eC;
      i = 8;
      break;
      label467: i = 1;
      break label202;
      label473: eO.b(this);
      break label252;
      label484: bool = false;
    }
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    eD.a(SgvAnimationHelper.AnimationIn.Mh, SgvAnimationHelper.AnimationOut.Mp);
    et.a(null);
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    if (!paramBoolean)
      bB();
  }

  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return false;
  }

  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
  }

  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if (!fu)
    {
      fu = true;
      a(2131230867, 2131230917, 2131231008, null);
    }
    return false;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131493414:
      et.aj(true);
      return true;
    case 2131493415:
      eM = false;
      if (eE != null)
        eE.f(eM);
      bz();
      com.google.android.keep.util.A.b(getActivity(), eM);
      a(2131230867, 2131230903, 2131231008, null);
      getActivity().invalidateOptionsMenu();
      com.google.android.keep.util.a.b(eC, getResources().getString(2131231057));
      return true;
    case 2131493416:
      eM = true;
      if (eE != null)
        eE.f(eM);
      bz();
      com.google.android.keep.util.A.b(getActivity(), eM);
      a(2131230867, 2131230902, 2131231008, null);
      getActivity().invalidateOptionsMenu();
      com.google.android.keep.util.a.b(eC, getResources().getString(2131231059));
      return true;
    case 2131493417:
      h.b(cR.aV()).show(getFragmentManager(), h.class.getName());
      return true;
    case 2131493418:
      new com.google.android.keep.ui.b.a(this, 5).bN(2131231067).bO(2131231068).bP(2131231075).show();
      return true;
    case 2131493420:
      if (!Config.nw())
        throw new IllegalStateException("Sync menu option should not be showing");
      TaskHelper.a(getActivity(), fr.hl(), -1L);
      a(2131230867, 2131230888, 2131231008, null);
      return true;
    case 2131493419:
      new com.google.android.keep.ui.b.a(this, 2).bN(2131231065).bi(getString(2131231066)).bP(2131231062).show();
      return true;
    case 2131493421:
    }
    paramMenuItem = getActivity();
    paramMenuItem.startActivity(new Intent(paramMenuItem, DebugActivity.class));
    return true;
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = false;
    if ((fc == null) || (eN != null))
    {
      com.google.android.keep.util.e.a(paramMenu);
      a(paramMenu, 2131493420, Config.nw());
      a(paramMenu, 2131493421, com.google.android.keep.util.i.L(getActivity()));
      return;
    }
    NavigationManager.NavigationMode localNavigationMode = fc.ka();
    if (localNavigationMode == NavigationManager.NavigationMode.AQ)
    {
      if (ft)
        com.google.android.keep.util.e.a(paramMenu, new int[] { 2131493419 });
      while (true)
      {
        a(paramMenu, 2131493414, false);
        break;
        com.google.android.keep.util.e.a(paramMenu);
      }
    }
    if (et != null)
    {
      if ((!eM) && (!et.kg()))
      {
        bool1 = true;
        label126: a(paramMenu, 2131493416, bool1);
        if ((!eM) || (et.kg()))
          break label223;
        bool1 = true;
        label153: a(paramMenu, 2131493415, bool1);
      }
    }
    else
    {
      a(paramMenu, 2131493419, false);
      if (localNavigationMode != NavigationManager.NavigationMode.AO)
        break label228;
    }
    label223: label228: for (boolean bool1 = true; ; bool1 = false)
    {
      a(paramMenu, 2131493417, bool1);
      bool1 = bool2;
      if (localNavigationMode == NavigationManager.NavigationMode.AO)
        bool1 = true;
      a(paramMenu, 2131493418, bool1);
      a(paramMenu, 2131493414, true);
      break;
      bool1 = false;
      break label126;
      bool1 = false;
      break label153;
    }
  }

  public void onRefresh()
  {
    mHandler.removeCallbacks(fw);
    mHandler.postDelayed(fw, eu);
    eG.setRefreshing(true);
    TaskHelper.a(getActivity(), fr.hl(), -1L);
    a(2131230867, 2131230887, 2131231021, null);
  }

  public void onResume()
  {
    super.onResume();
    j localj = com.google.android.keep.util.o.O(getActivity());
    if (localj == null);
    do
    {
      return;
      if (localj.getId() != fr.getId())
      {
        fr = localj;
        bF();
        et.a(this);
        eE = null;
      }
    }
    while (!et.kg());
    h(false);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("savedState_browseResult", fc);
    if (eD != null)
      fd = eD.nn();
    if (eE != null)
    {
      paramBundle.putBoolean("savedState_playFirstLoadAnimation", false);
      paramBundle.putLongArray("savedState_selectedIds", eE.bg());
      paramBundle.putInt("savedState_selectedArchivedCount", eE.bh());
      paramBundle.putInt("savedState_selectedUnarchivedCount", eE.bi());
      paramBundle.putInt("savedState_selectedConflictCount", eE.bj());
      paramBundle.putInt("savedState_selectedNonOwnedSharedNoteCount", eE.bk());
      paramBundle.putInt("savedState_selectedOwnedSharedNoteCount", eE.bl());
      Bundle localBundle = new Bundle();
      if (!localBundle.isEmpty())
        paramBundle.putBundle("savedState_undoBarBundle", localBundle);
    }
    if (fd != null)
      paramBundle.putParcelable("savedState_scrollState", fd);
    if (fq != null)
      paramBundle.putLong("savedState_reminderTime", fq.op());
    paramBundle.putString("savedState_query", fs);
    paramBundle.putBoolean("savedState_showLoadingSpinner", eW);
    paramBundle.putInt("savedState_colorPickerMode", eV);
    paramBundle.putBoolean("savedState_isSearchFilterVisible", et.kg());
    paramBundle.putInt("savedState_numberOfSelectedFilters", eZ);
    paramBundle.putString("savedState_selectedColorFilter", fa);
    paramBundle.putParcelable("savedState_currentLabel", cR.aV());
    if (eH != null)
      eH.e(paramBundle);
    et.e(paramBundle);
  }

  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!bJ()) || ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)));
    while ((paramInt1 != paramInt3) || (paramInt4 >= paramInt2) || (!eO.isActive()))
      return;
    eO.mx();
  }

  public void onStart()
  {
    super.onStart();
    g(true);
  }

  public void onStop()
  {
    bB();
    super.onStop();
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int k = 1;
    int i = 1;
    if (!ex)
      return false;
    if (eA == null)
      eA = ViewConfiguration.get(eD.getContext());
    int j;
    int m;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default:
      return false;
    case 1:
    case 3:
      j = -ew;
      m = (int)(ew * ev);
      paramView = et.kj();
      if (mDeltaY < 0)
        break label217;
      if (Math.abs(j - paramView.getTranslationY()) <= m)
        break;
    case 2:
    }
    while (true)
    {
      if (i == 0)
      {
        i = j;
        if (!bw());
      }
      else
      {
        i = 0;
      }
      z(i);
      fe = 0;
      return false;
      if (eD.mZ())
        break;
      if (fe == 0)
        fe = ((int)eD.mW());
      mDeltaY = ((int)paramMotionEvent.getY() - fe);
      fe = ((int)paramMotionEvent.getY());
      A(mDeltaY);
      return false;
      i = 0;
    }
    label217: if (paramView.getTranslationY() >= -m);
    for (i = k; ; i = 0)
      break;
  }

  public void s(int paramInt)
  {
  }

  public void y(int paramInt)
  {
    Object localObject = eE.bg();
    if ((localObject == null) || (localObject.length == 0))
      return;
    ArrayList localArrayList = Lists.newArrayList();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Long.valueOf(localObject[i]));
      i += 1;
    }
    localObject = ColorMap.aN(paramInt);
    TaskHelper.a(getActivity(), localArrayList, (ColorMap.ColorPair)localObject);
    by();
  }

  private class a
    implements q.a
  {
    private a()
    {
    }

    public void a(ViewPropertyAnimator paramViewPropertyAnimator)
    {
    }

    public void bP()
    {
      c.c(c.this).setEnabled(false);
    }

    public void bT()
    {
    }

    public void bU()
    {
    }

    public boolean bV()
    {
      return true;
    }

    public void h(View paramView)
    {
      c.c(c.this).setEnabled(true);
      c.o(c.this);
    }

    public void l(boolean paramBoolean)
    {
    }
  }
}