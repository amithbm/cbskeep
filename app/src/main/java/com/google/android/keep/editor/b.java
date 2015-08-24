package com.google.android.keep.editor;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.m;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.j;
import com.google.android.keep.model.p;
import com.google.android.keep.model.s;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.navigation.a.a;
import com.google.android.keep.p.a;
import com.google.android.keep.r;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.task.TaskHelper.ErrorCode;
import com.google.android.keep.task.TaskHelper.a;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class b extends p
  implements ModelEventDispatcher.b, a.a
{
  private com.google.android.keep.browse.a cR;
  private com.google.android.keep.navigation.a et;
  private com.google.android.keep.activities.a kD;
  private TreeEntityModel kJ;
  private s kK;
  private c kL;
  private c kM;
  private a kN;
  private ViewPager kO;
  private View kP;
  private View kQ;
  private View kR;
  private View kS;
  private int kT = -1;
  private final View.OnClickListener kU = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      switch (paramAnonymousView.getId())
      {
      default:
      case 2131493166:
      case 2131493167:
      }
      do
      {
        return;
        b.a(b.this).a(2131230867, 2131230962, 2131231020, null);
        TaskHelper.c(getActivity(), b.b(b.this).dP(), b.c(b.this));
        return;
        b.a(b.this).a(2131230867, 2131230963, 2131231020, null);
        if (b.d(b.this) == 0)
        {
          TaskHelper.a(getActivity(), o.O(getActivity()).getId(), b.b(b.this).dP(), b.c(b.this));
          return;
        }
      }
      while (b.d(b.this) != 1);
      TaskHelper.b(getActivity(), b.b(b.this).dP(), b.c(b.this));
    }
  };
  private final TaskHelper.a<Long> kV = new TaskHelper.a()
  {
    public void a(TaskHelper.ErrorCode paramAnonymousErrorCode)
    {
      e.b(getActivity(), 2131231201);
      getFragmentManager().popBackStack();
    }

    public void a(Long paramAnonymousLong)
    {
      getFragmentManager().popBackStack();
    }
  };

  private void dk()
  {
    kD.fM().b(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof e.d))
          ((e.d)paramAnonymousr).dy();
      }
    });
  }

  private void dl()
  {
    if (kT == -1)
      return;
    switch (kT)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      d(kT, true);
      return;
      kL.setSelected(true);
      continue;
      kM.setSelected(true);
    }
  }

  public static b e(EditorNavigationRequest paramEditorNavigationRequest)
  {
    b localb = new b();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("args_editor_navigation_request", paramEditorNavigationRequest);
    localb.setArguments(localBundle);
    return localb;
  }

  private void g(final long paramLong)
  {
    kD.fM().b(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof e.b))
          ((e.b)paramAnonymousr).j(paramLong);
      }
    });
  }

  private void v(boolean paramBoolean)
  {
    kR.setEnabled(paramBoolean);
    View localView = kR;
    if (paramBoolean);
    for (float f = 1.0F; ; f = 0.3F)
    {
      localView.setAlpha(f);
      return;
    }
  }

  protected String S()
  {
    return getString(2131230860);
  }

  public void a(c paramc, int paramInt)
  {
    if (paramInt == 0)
    {
      kL = paramc;
      return;
    }
    if (paramInt == 1)
    {
      kM = paramc;
      return;
    }
    throw new IllegalArgumentException("Unknown conflict page: " + paramInt);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih());
    do
    {
      return;
      kN = new a(getChildFragmentManager());
      kO = ((ViewPager)kP.findViewById(2131493164));
      kO.setOffscreenPageLimit(2);
      kO.setAdapter(kN);
      kJ.B(true);
    }
    while (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF }));
    dl();
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return ImmutableList.of(ModelEventDispatcher.EventType.wF);
  }

  public void bq()
  {
    getFragmentManager().popBackStack();
  }

  public void br()
  {
    throw new UnsupportedOperationException();
  }

  public void bs()
  {
    throw new UnsupportedOperationException();
  }

  public void d(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if (!paramBoolean)
    {
      kT = -1;
      if (kT == -1)
        break label157;
    }
    label157: for (paramBoolean = bool; ; paramBoolean = false)
    {
      v(paramBoolean);
      return;
      kT = paramInt;
      switch (kT)
      {
      default:
        break;
      case 0:
        kK.a(2131230867, 2131230960, 2131231020, null);
        kM.setSelected(false);
        if (kO.getCurrentItem() == 0)
          break;
        kO.setCurrentItem(0, true);
        break;
      case 1:
        kK.a(2131230867, 2131230961, 2131231020, null);
        kL.setSelected(false);
        if (kO.getCurrentItem() == 1)
          break;
        kO.setCurrentItem(1, true);
        break;
      }
    }
  }

  public void h(String paramString)
  {
    throw new UnsupportedOperationException();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onActivityCreated(paramBundle);
    kD = ((com.google.android.keep.activities.a)getActivity());
    EditorNavigationRequest localEditorNavigationRequest;
    if (kT != -1)
    {
      bool1 = true;
      v(bool1);
      kJ = ((TreeEntityModel)e(TreeEntityModel.class));
      kK = ((s)Binder.a(getActivity(), s.class));
      cR = ((com.google.android.keep.browse.a)Binder.a(getActivity(), com.google.android.keep.browse.a.class));
      localEditorNavigationRequest = (EditorNavigationRequest)getArguments().getParcelable("args_editor_navigation_request");
      if (localEditorNavigationRequest.dP() == -1L)
        break label196;
    }
    label196: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      Toolbar localToolbar = (Toolbar)kP.findViewById(2131493059);
      et = new com.google.android.keep.navigation.a(getActivity(), localToolbar);
      et.a(getActivity(), NavigationManager.NavigationMode.AU);
      et.a(this);
      if (paramBundle != null)
        kT = paramBundle.getInt("key_current_selected_page_id", -1);
      g(localEditorNavigationRequest.dP());
      return;
      bool1 = false;
      break;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    kP = paramLayoutInflater.inflate(2130968669, paramViewGroup, false);
    kS = kP.findViewById(2131493165);
    kQ = kS.findViewById(2131493166);
    kR = kS.findViewById(2131493167);
    kQ.setOnClickListener(kU);
    kR.setOnClickListener(kU);
    return kP;
  }

  public void onDestroy()
  {
    dk();
    super.onDestroy();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("key_current_selected_page_id", kT);
  }

  public class a extends FragmentStatePagerAdapter
  {
    public a(FragmentManager arg2)
    {
      super();
    }

    public int getCount()
    {
      return 2;
    }

    public Fragment getItem(int paramInt)
    {
      if (paramInt == 0)
      {
        b.a(b.this, c.a(b.b(b.this).dP(), 0, false));
        return b.e(b.this);
      }
      if (paramInt == 1)
      {
        b.b(b.this, c.a(b.b(b.this).dP(), 1, true));
        return b.f(b.this);
      }
      throw new IllegalStateException("No more fragment to server " + paramInt);
    }

    public float getPageWidth(int paramInt)
    {
      return getResources().getInteger(2131361821) / 100.0F;
    }
  }
}