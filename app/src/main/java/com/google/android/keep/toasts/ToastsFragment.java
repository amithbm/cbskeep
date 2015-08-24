package com.google.android.keep.toasts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.C;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.n;
import com.google.android.keep.model.p;
import com.google.android.keep.model.r;
import com.google.android.keep.model.s;
import com.google.android.keep.model.x;
import com.google.android.keep.navigation.EditorNavigationRequest.a;
import com.google.android.keep.util.Config;
import java.util.Arrays;
import java.util.List;

public class ToastsFragment extends p
  implements ToastLayout.a
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xo, ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xq, ModelEventDispatcher.EventType.xw, ModelEventDispatcher.EventType.xx, ModelEventDispatcher.EventType.xy, ModelEventDispatcher.EventType.wT });
  private ActionableToastBar HU;
  private ToastLayout HV;
  private boolean HW;
  private ToastListener HX;
  private final Handler HY = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (ToastsFragment.a(ToastsFragment.this).aM() == null)
        return;
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 1:
      }
      paramAnonymousMessage = getString(2131231291);
      a(paramAnonymousMessage, null, null);
    }
  };
  private com.google.android.keep.browse.a cR;
  private s hb;
  private r lN;
  private n la;
  private x lm;
  private C ly;

  private void aA(boolean paramBoolean)
  {
    HY.removeMessages(1);
    Handler localHandler = HY;
    if (paramBoolean);
    for (long l = 0L; ; l = 1000L)
    {
      localHandler.sendEmptyMessageDelayed(1, l);
      return;
    }
  }

  private void g(ModelEventDispatcher.a parama)
  {
    if ((parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wT })) && (la.hG()))
    {
      lO();
      return;
    }
    if (lm.iU())
    {
      lP();
      return;
    }
    if (lN.iL())
    {
      lQ();
      return;
    }
    if (lN.iK())
    {
      lR();
      return;
    }
    if ((parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xq })) && (ly.ip()) && (!lm.isActive()))
    {
      aA(parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xq }));
      return;
    }
    if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xw, ModelEventDispatcher.EventType.xx }))
    {
      lS();
      return;
    }
    az(false);
  }

  private void j(Bundle paramBundle)
  {
    if (paramBundle == null);
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getBundle("ToastsFragment.mToastBar");
      }
      while (paramBundle == null);
      paramBundle = ToastListener.a(paramBundle, getActivity(), null);
    }
    while (paramBundle == null);
    a(paramBundle);
  }

  private void lO()
  {
    a(getString(2131231288), getString(2131231111), new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new EditorNavigationRequest.a().ag(true).g(Long.valueOf(ToastsFragment.b(ToastsFragment.this).dP())).jU();
        ToastsFragment.a(ToastsFragment.this).b(paramAnonymousView);
        ToastsFragment.c(ToastsFragment.this).au(false);
      }
    });
  }

  private void lP()
  {
    a(getString(2131231353), getString(2131231354), new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ToastsFragment.d(ToastsFragment.this).a(2131230867, 2131230959, 2131231022, Long.valueOf(KeepApplication.d(getActivity())));
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Config.ob())));
      }
    });
    hb.a(2131230867, 2131230982, 2131231022, null);
  }

  private void lQ()
  {
    a(getString(2131231191), null, null);
    hb.a(2131230867, 2131230983, 2131231022, null);
  }

  private void lR()
  {
    a(getString(2131231342), getString(2131231285), new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ToastsFragment.e(ToastsFragment.this).ao("WS");
        ToastsFragment.c(ToastsFragment.this).av(true);
      }
    });
    hb.a(2131230867, 2131230984, 2131231022, null);
  }

  private void lS()
  {
    HY.removeMessages(1);
    az(true);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    g(parama);
  }

  public void a(ToastListener paramToastListener)
  {
    if (HV.isShown())
    {
      HW = true;
      HX = paramToastListener;
      HV.av(true);
      return;
    }
    HU.b(paramToastListener);
    HX = null;
  }

  public void a(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    ((TextView)HV.findViewById(2131493372)).setText(paramString1);
    paramString1 = (TextView)HV.findViewById(2131493373);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.setText(paramString2);
      paramString1.setOnClickListener(paramOnClickListener);
      paramString1.setVisibility(0);
    }
    while (HU.isShown())
    {
      HW = true;
      HU.av(true);
      return;
      paramString1.setVisibility(8);
    }
    HV.show();
  }

  protected boolean aB()
  {
    return false;
  }

  public void ax(boolean paramBoolean)
  {
    HU.au(paramBoolean);
  }

  public void ay(boolean paramBoolean)
  {
    HU.av(paramBoolean);
  }

  public void az(boolean paramBoolean)
  {
    TextView localTextView = (TextView)HV.findViewById(2131493373);
    HV.av(paramBoolean);
    localTextView.setOnClickListener(null);
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public void lM()
  {
    ay(true);
    az(true);
  }

  public ToastListener.Type lN()
  {
    return HU.hg();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    cR = ((com.google.android.keep.browse.a)Binder.g(getActivity()).a(com.google.android.keep.browse.a.class));
    lN = ((r)e(r.class));
    la = ((n)e(n.class));
    lm = ((x)e(x.class));
    ly = ((C)e(C.class));
    hb = ((s)Binder.a(getActivity(), s.class));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968769, paramViewGroup, false);
    HU = ((ActionableToastBar)paramLayoutInflater.findViewById(2131493374));
    HU.au(false);
    HU.a(this);
    HV = ((ToastLayout)paramLayoutInflater.findViewById(2131493284));
    HV.au(false);
    HV.a(this);
    j(paramBundle);
    return paramLayoutInflater;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Bundle localBundle = new Bundle();
    HU.onSaveInstanceState(localBundle);
    if (!localBundle.isEmpty())
      paramBundle.putBundle("ToastsFragment.mToastBar", localBundle);
    HY.removeMessages(1);
  }

  public void q(View paramView)
  {
    if ((paramView != HV) && (paramView != HU));
    while (TextUtils.isEmpty(((TextView)paramView.findViewById(2131493373)).getText()))
      return;
    com.google.android.keep.util.a.a(getActivity(), paramView);
  }

  public void r(View paramView)
  {
    if (paramView == HV)
      if (HX != null)
      {
        HU.b(HX);
        HX = null;
      }
    while ((paramView != HU) || (!HW))
      return;
    HV.show();
    HW = false;
  }

  public void s(View paramView)
  {
    HV.p(paramView);
    HU.p(paramView);
  }
}