package com.google.android.keep.editor;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.db.a.a;
import com.google.android.keep.m;
import com.google.android.keep.model.A;
import com.google.android.keep.model.C;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.TreeEntity;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.i;
import com.google.android.keep.model.l;
import com.google.android.keep.model.n;
import com.google.android.keep.model.s;
import com.google.android.keep.model.x;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.p.a;
import com.google.android.keep.r;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.task.TreeEntityTask;
import com.google.android.keep.toasts.ToastListener.Type;
import com.google.android.keep.toasts.ToastListener.d;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.util.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d extends a
  implements ModelEventDispatcher.b
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xe, ModelEventDispatcher.EventType.wS, ModelEventDispatcher.EventType.xd, ModelEventDispatcher.EventType.xf, ModelEventDispatcher.EventType.xw, ModelEventDispatcher.EventType.xy, ModelEventDispatcher.EventType.xj, ModelEventDispatcher.EventType.xg, ModelEventDispatcher.EventType.xq, ModelEventDispatcher.EventType.xr, ModelEventDispatcher.EventType.xb, ModelEventDispatcher.EventType.xc, ModelEventDispatcher.EventType.wN });
  private com.google.android.keep.browse.a cR;
  private l fh;
  private A fi;
  private s hb;
  private TreeEntityModel kJ;
  private com.google.android.keep.model.D lA;
  private com.google.android.keep.sharing.d lB;
  private Runnable lC = null;
  private boolean lD = false;
  private n la;
  private View lf;
  private x lm;
  private View lw;
  private View lx;
  private C ly;
  private i lz;
  private final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (!e.isFragmentActive(d.this))
        return;
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 1:
      }
      d.a(d.this);
      d.a(d.this, d.b(d.this).aM());
    }
  };

  private boolean a(ToastListener.Type paramType)
  {
    return (paramType == ToastListener.Type.HO) || (paramType == ToastListener.Type.HR);
  }

  private void dr()
  {
    if (cR.aN())
    {
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!isAdded())
            return;
          c(null);
        }
      };
      kF.findViewById(2131493173).setOnClickListener(local3);
      kF.findViewById(2131493174).setOnClickListener(local3);
    }
    lf.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        paramAnonymousView = (ToastsFragment)e.a(getActivity(), 2131493048);
        if (paramAnonymousView != null)
        {
          if ((!d.c(d.this).isInitialized()) || (!d.c(d.this).js()))
            break label94;
          ArrayList localArrayList = e.h(Long.valueOf(d.c(d.this).dP()));
          paramAnonymousView.a(new ToastListener.d(getActivity(), localArrayList));
        }
        while (true)
        {
          return d.d(d.this).dispatchTouchEvent(paramAnonymousMotionEvent);
          label94: paramAnonymousView.ax(true);
        }
      }
    });
  }

  private void ds()
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

  private void dt()
  {
    kD.fM().b(new p.a()
    {
      public void a(r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof e.c))
          ((e.c)paramAnonymousr).dx();
      }
    });
  }

  private void du()
  {
    int i;
    if ((ly.ip()) && (!lm.isActive()))
    {
      i = 1;
      if ((!kJ.js()) && (!la.hG()) && (!lm.iU()) && (i == 0))
        break label72;
    }
    label72: for (boolean bool = true; ; bool = false)
    {
      kJ.B(bool);
      return;
      i = 0;
      break;
    }
  }

  private void dv()
  {
    ToastsFragment localToastsFragment = (ToastsFragment)e.a(kD, 2131493048);
    if (localToastsFragment == null);
    while ((!localToastsFragment.isVisible()) || (!a(localToastsFragment.lN())))
      return;
    localToastsFragment.ay(true);
  }

  private void dw()
  {
    if ((dg()) && (lB.kP()))
      lB.kQ();
  }

  public static d f(EditorNavigationRequest paramEditorNavigationRequest)
  {
    d locald = new d();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("args.EditorNavigationRequest", paramEditorNavigationRequest);
    locald.setArguments(localBundle);
    return locald;
  }

  private void g(EditorNavigationRequest paramEditorNavigationRequest)
  {
    EditorToolbarFragment localEditorToolbarFragment = (EditorToolbarFragment)getChildFragmentManager().findFragmentById(2131493176);
    if (localEditorToolbarFragment == null);
    do
    {
      return;
      int i = paramEditorNavigationRequest.jO();
      paramEditorNavigationRequest.jT();
      switch (i)
      {
      default:
        return;
      case 4:
      }
      paramEditorNavigationRequest = paramEditorNavigationRequest.jS();
    }
    while (TextUtils.isEmpty(paramEditorNavigationRequest));
    localEditorToolbarFragment.a(kJ.dP(), paramEditorNavigationRequest, false);
  }

  private void i(final long paramLong)
  {
    if (paramLong != -1L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      kD.fM().b(new p.a()
      {
        public void a(r paramAnonymousr)
        {
          if ((paramAnonymousr instanceof e.b))
            ((e.b)paramAnonymousr).j(paramLong);
        }
      });
      return;
    }
  }

  private boolean isEmpty()
  {
    boolean bool = ih();
    if (!bool)
      hb.n(2131231002, 2131231015);
    return (bool) && (kJ.isEmpty()) && (la.hD()) && (lA.isEmpty()) && (lz.isEmpty()) && (ly.isEmpty()) && (fh.v(kJ.dP()).isEmpty()) && (fi.a(kJ) == null);
  }

  protected String S()
  {
    return getString(2131230858);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih());
    label280: label305: 
    while (true)
    {
      return;
      if ((parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xb })) && (isAdded()) && (!dj()))
      {
        c(new Runnable()
        {
          public void run()
          {
            e.b(kD, 2131231352);
          }
        });
        return;
      }
      if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xe }))
        lw.setBackgroundColor(kJ.iz().getValue());
      du();
      if ((parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wS })) && (la.hG()))
      {
        e.B(getActivity().getCurrentFocus());
        la.b(ModelEventDispatcher.EventType.wT);
        return;
      }
      int i;
      if ((parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xj, ModelEventDispatcher.EventType.xq })) && (ly.ip()))
      {
        i = 1;
        String str = kJ.getServerId();
        if ((i == 0) || (TextUtils.isEmpty(str)))
          break label280;
        boolean bool = parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xq });
        lB.b(kJ.getServerId(), bool);
        dw();
      }
      while (true)
      {
        if (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xd, ModelEventDispatcher.EventType.xg }))
          break label305;
        dh();
        return;
        i = 0;
        break;
        if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xr }))
          lB.kT();
      }
    }
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public String bo()
  {
    if (kJ != null)
      return kJ.gu();
    return "";
  }

  public void c(final Runnable paramRunnable)
  {
    e.B(kD.getCurrentFocus());
    if ((cR.aM().eY()) && (isEmpty()));
    for (final boolean bool = true; ; bool = false)
    {
      lC = new Runnable()
      {
        public void run()
        {
          if (bool)
            TaskHelper.d(kD, d.c(d.this).gA(), e.h(lG));
          d.e(d.this);
          if (paramRunnable != null)
            paramRunnable.run();
        }
      };
      di();
      return;
    }
  }

  public void d(Runnable paramRunnable)
  {
    lD = true;
    c(paramRunnable);
  }

  public View df()
  {
    return kF;
  }

  protected void di()
  {
    if (cR.aM().jK() != null)
    {
      super.di();
      return;
    }
    mHandler.post(new Runnable()
    {
      public void run()
      {
        onCloseComplete();
      }
    });
  }

  protected void g(Bundle paramBundle)
  {
    if (cR.aM().jK() != null)
      super.g(paramBundle);
    while (true)
    {
      if (cR.aN())
        cR.aF();
      return;
      onOpenComplete();
    }
  }

  public int getStatusBarColor()
  {
    if ((kJ.isInitialized()) && (!cR.aN()))
    {
      if ((lz.isInitialized()) && (!lz.isEmpty()));
      for (int i = 1; i != 0; i = 0)
        return getResources().getColor(2131296398);
      return ColorMap.L(kJ.iz().getKey()).intValue();
    }
    return getResources().getColor(17170445);
  }

  public void h(long paramLong)
  {
    i(paramLong);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    EditorNavigationRequest localEditorNavigationRequest = (EditorNavigationRequest)getArguments().getParcelable("args.EditorNavigationRequest");
    lw.setBackgroundColor(localEditorNavigationRequest.iz().getValue());
    lB = new com.google.android.keep.sharing.d(this, fO());
    kJ = ((TreeEntityModel)e(TreeEntityModel.class));
    ly = ((C)e(C.class));
    lm = ((x)e(x.class));
    la = ((n)e(n.class));
    Binder localBinder = Binder.g(getActivity());
    cR = ((com.google.android.keep.browse.a)localBinder.a(com.google.android.keep.browse.a.class));
    lz = ((i)localBinder.a(i.class));
    lA = ((com.google.android.keep.model.D)localBinder.a(com.google.android.keep.model.D.class));
    fi = ((A)localBinder.a(A.class));
    ly = ((C)localBinder.a(C.class));
    fh = ((l)localBinder.a(l.class));
    hb = ((s)localBinder.a(s.class));
    dr();
    if (paramBundle != null);
    while (true)
    {
      g(paramBundle);
      return;
      paramBundle = localEditorNavigationRequest.getIntent().getExtras();
    }
  }

  public void onCloseComplete()
  {
    super.onCloseComplete();
    if (lC != null)
    {
      if (!lD)
        break label73;
      new Handler().postDelayed(lC, kC);
    }
    while (true)
    {
      lC = null;
      lD = false;
      if (cR.aN())
        cR.aG();
      cR.aX();
      return;
      label73: lC.run();
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    com.google.android.keep.util.D.bO("EditorFragment_onCreateView");
    kF = paramLayoutInflater.inflate(2130968671, paramViewGroup, false);
    lw = kF.findViewById(2131493043);
    lx = lw.findViewById(2131493175);
    lf = lw.findViewById(2131493116);
    com.google.android.keep.util.D.ot();
    return kF;
  }

  public void onOpenComplete()
  {
    super.onOpenComplete();
    EditorNavigationRequest localEditorNavigationRequest = cR.aM();
    if ((localEditorNavigationRequest != null) && (!localEditorNavigationRequest.eY()))
      kF.requestFocus();
    mHandler.sendEmptyMessage(1);
  }

  public void onPause()
  {
    super.onPause();
    if (kJ.isInitialized())
    {
      dt();
      if (kJ.dP() == -1L)
      {
        hb.n(2131231001, 2131231001);
        TreeEntityTask.a(kD, kJ, la).execute(new Void[0]);
      }
    }
    else
    {
      return;
    }
    ((com.google.android.keep.db.a)Binder.a(kD, com.google.android.keep.db.a.class)).a(new a.a().u(false));
  }

  public void onStart()
  {
    super.onStart();
    long l = ((EditorNavigationRequest)getArguments().getParcelable("args.EditorNavigationRequest")).dP();
    if (l != -1L)
      i(l);
  }

  public void onStop()
  {
    ds();
    super.onStop();
  }
}