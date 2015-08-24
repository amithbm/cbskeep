package com.google.android.keep.sharing;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.util.Rfc822Tokenizer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.android.ex.chips.BaseRecipientAdapter;
import com.android.ex.chips.RecipientEntry;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.Sharee;
import com.google.android.keep.model.j;
import com.google.android.keep.model.p;
import com.google.android.keep.model.r;
import com.google.android.keep.model.s;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.ui.RecipientAutoCompleteView;
import com.google.android.keep.ui.RecipientAutoCompleteView.a;
import com.google.android.keep.ui.b.a;
import com.google.android.keep.ui.b.b;
import com.google.android.keep.util.B;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.o;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class e extends p
  implements c.b, b.b
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xp, ModelEventDispatcher.EventType.xo });
  private ShareesListView ER;
  private View ES;
  private TextView ET;
  private RecipientAutoCompleteView EU;
  private BaseRecipientAdapter EV;
  private BroadcastReceiver EW;
  private boolean EX;
  private boolean EY = false;
  f EZ;
  private List<Sharee> Fa;
  private List<Sharee> Fb;
  private List<Sharee> Fc = Lists.newArrayList();
  private final RecipientAutoCompleteView.a Fd = new RecipientAutoCompleteView.a()
  {
    public void b(RecipientEntry paramAnonymousRecipientEntry)
    {
      e.a(e.this, paramAnonymousRecipientEntry);
    }
  };
  private final f.a Fe = new f.a()
  {
    private HashMap<Long, Integer> Fg = new HashMap();

    private void a(long paramAnonymousLong, View paramAnonymousView)
    {
      Integer localInteger = (Integer)Fg.get(Long.valueOf(paramAnonymousLong));
      int i = paramAnonymousView.getTop();
      if ((localInteger != null) && (localInteger.intValue() != i))
      {
        i = localInteger.intValue() - i;
        paramAnonymousView.setTranslationY(i);
        if (i >= 0)
          break label75;
      }
      label75: for (paramAnonymousView = com.google.android.keep.f.a(paramAnonymousView, 0.0F, null); ; paramAnonymousView = com.google.android.keep.f.b(paramAnonymousView, 0.0F, null))
      {
        if (paramAnonymousView != null)
          paramAnonymousView.start();
        return;
      }
    }

    private int lg()
    {
      int i = e.k(e.this).getChildAt(e.k(e.this).getChildCount() - 1).getTop();
      return (e.d(e.this).getTop() - i) * -1;
    }

    private void o(final View paramAnonymousView)
    {
      int m = e.k(e.this).getFirstVisiblePosition();
      int j = -1;
      ListAdapter localListAdapter = e.k(e.this).getAdapter();
      int i = 0;
      if (i < e.k(e.this).getChildCount())
      {
        View localView = e.k(e.this).getChildAt(i);
        int k = m + i;
        if (localView != paramAnonymousView)
        {
          long l = localListAdapter.getItemId(k);
          k = j;
          if (l != -1L)
          {
            Fg.put(Long.valueOf(l), Integer.valueOf(localView.getTop()));
            k = j;
          }
        }
        while (true)
        {
          i += 1;
          j = k;
          break;
          k -= e.k(e.this).getHeaderViewsCount();
        }
      }
      final float f = e.d(e.this).getTranslationY();
      if (j >= 0)
        EZ.remove(EZ.getItem(j));
      paramAnonymousView = e.k(e.this).getViewTreeObserver();
      paramAnonymousView.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          paramAnonymousView.removeOnPreDrawListener(this);
          int j = e.k(e.this).getFirstVisiblePosition();
          Object localObject = e.k(e.this).getAdapter();
          int k = e.k(e.this).getChildCount();
          int i = 0;
          while (i < k)
          {
            View localView = e.k(e.this).getChildAt(i);
            long l = ((ListAdapter)localObject).getItemId(j + i);
            if (l != -1L)
              e.8.a(e.8.this, l, localView);
            i += 1;
          }
          i = e.8.a(e.8.this);
          e.d(e.this).setTranslationY(f);
          localObject = com.google.android.keep.f.b(e.d(e.this), i, null);
          if (localObject != null)
            ((ObjectAnimator)localObject).start();
          e.8.b(e.8.this).clear();
          return true;
        }
      });
    }

    public void a(Sharee paramAnonymousSharee, View paramAnonymousView)
    {
      o(paramAnonymousView);
      e.g(e.this).remove(paramAnonymousSharee);
      e.h(e.this).remove(paramAnonymousSharee);
      if (paramAnonymousSharee.jf() != -1L)
      {
        e.i(e.this).add(paramAnonymousSharee);
        e.j(e.this).a(2131230867, 2131230986, 2131231022, null);
      }
    }
  };
  private com.google.android.keep.browse.a cR;
  private String dz;
  private ViewGroup eC;
  private com.google.android.keep.ui.c eF;
  private j fr;
  private s hb;
  private com.google.android.keep.activities.a kD;
  private r lN;
  private com.google.android.keep.model.C ly;
  private final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1)
        e.a(e.this);
    }
  };
  private long uy;

  public static e a(long paramLong, boolean paramBoolean, String paramString)
  {
    e locale = new e();
    Bundle localBundle = new Bundle();
    localBundle.putLong("args_treeEntityId", paramLong);
    localBundle.putBoolean("args_showIme", paramBoolean);
    localBundle.putString("args_proposedEmail", paramString);
    locale.setArguments(localBundle);
    return locale;
  }

  private void a(RecipientEntry paramRecipientEntry)
  {
    if (paramRecipientEntry == null);
    for (Object localObject = null; TextUtils.isEmpty((CharSequence)localObject); localObject = paramRecipientEntry.getDestination())
      return;
    paramRecipientEntry = new Sharee(uy, (String)localObject, paramRecipientEntry.getDisplayName());
    if (a(paramRecipientEntry))
    {
      com.google.android.keep.util.e.g(kD, getString(2131231344));
      EU.setText((CharSequence)localObject);
      EU.requestFocus();
      EU.setSelection(((String)localObject).length());
      return;
    }
    if (!kW())
    {
      com.google.android.keep.util.e.g(kD, getString(2131231345));
      EU.setText((CharSequence)localObject);
      return;
    }
    if (Fb.contains(paramRecipientEntry))
    {
      Fb.remove(paramRecipientEntry);
      EZ.b(paramRecipientEntry);
    }
    while (true)
    {
      EU.setText("");
      ER.smoothScrollToPosition(ER.getCount() - 1);
      return;
      Fa.add(paramRecipientEntry);
      EZ.b(paramRecipientEntry);
      hb.a(2131230867, 2131230985, 2131231022, null);
    }
  }

  private boolean a(Sharee paramSharee)
  {
    return (Fc.contains(paramSharee)) || (Fa.contains(paramSharee));
  }

  private boolean ap(boolean paramBoolean)
  {
    if (!com.google.android.keep.util.e.a(kD))
      if (paramBoolean)
        com.google.android.keep.util.e.g(kD, getResources().getString(2131231343));
    do
    {
      return false;
      if (com.google.android.keep.util.C.e(fr.hl()))
        break;
    }
    while (!paramBoolean);
    new b.a(this, 2).bO(2131231350).bN(2131231349).bP(2131231351).bQ(2131231092).show();
    return false;
    return true;
  }

  private void bK(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      lc();
      ld();
      return;
    case 2:
      com.google.android.keep.util.C.a(fr.hl(), true);
      la();
      return;
    case 3:
    }
    ld();
  }

  private boolean kW()
  {
    return EZ.getCount() < ((Integer)Config.Pb.get()).intValue();
  }

  private void kX()
  {
    if (TextUtils.isEmpty(dz))
      return;
    if (!kW())
    {
      Toast.makeText(kD, getString(2131231345), 1).show();
      return;
    }
    Iterator localIterator = Fc.iterator();
    while (localIterator.hasNext())
    {
      Sharee localSharee = (Sharee)localIterator.next();
      if ((!TextUtils.isEmpty(localSharee.getEmail())) && (dz.equalsIgnoreCase(localSharee.getEmail())))
      {
        Toast.makeText(kD, getString(2131231335, new Object[] { dz }), 1).show();
        return;
      }
    }
    c.a(this, dz).show(getFragmentManager(), c.class.getSimpleName());
  }

  private void kY()
  {
    eC.findViewById(2131493350).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        e.e(e.this);
      }
    });
    ET = ((TextView)eC.findViewById(2131493351));
    ET.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (e.a(e.this, true))
          e.f(e.this);
      }
    });
  }

  private void kZ()
  {
    String str = EU.getText().toString();
    if ((Fa.size() > 0) || (Fb.size() > 0) || (!TextUtils.isEmpty(str)))
    {
      new b.a(this, 3).bN(2131231187).bO(2131231188).bP(2131231189).bQ(2131231190).show();
      return;
    }
    ld();
  }

  private void la()
  {
    TextView localTextView = ET;
    if (ap(false));
    for (int i = getResources().getColor(2131296421); ; i = getResources().getColor(2131296422))
    {
      localTextView.setTextColor(i);
      return;
    }
  }

  private void lb()
  {
    Object localObject = EU.getText().toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Sharee localSharee = new Sharee(uy, (String)localObject);
      if (a(localSharee))
      {
        com.google.android.keep.util.e.g(kD, getString(2131231344));
        EU.setText("");
        return;
      }
      if (!kW())
      {
        com.google.android.keep.util.e.g(kD, getString(2131231345));
        EU.setText((CharSequence)localObject);
        return;
      }
      if (B.bL((String)localObject))
      {
        localObject = getResources().getString(2131231157, new Object[] { localObject });
        com.google.android.keep.util.e.g(kD, (String)localObject);
        return;
      }
      Fb.remove(localSharee);
      Fa.add(localSharee);
      EZ.b(localSharee);
      EU.setText("");
    }
    if (u(Fb))
    {
      new b.a(this, 1).bN(2131231180).bO(2131231183).show();
      return;
    }
    localObject = B.c(Fa);
    if (((List)localObject).size() > 0)
    {
      if (((List)localObject).size() == 1);
      for (localObject = getResources().getString(2131231157, new Object[] { ((Sharee)((List)localObject).get(0)).getEmail() }); ; localObject = getResources().getString(2131231158))
      {
        com.google.android.keep.util.e.g(kD, (String)localObject);
        return;
      }
    }
    lc();
    ld();
  }

  private void lc()
  {
    ly.k(new ArrayList(Fa));
    ly.removeAll(new ArrayList(Fb));
    ((com.google.android.keep.db.a)Binder.a(getActivity(), com.google.android.keep.db.a.class)).flush();
  }

  private void ld()
  {
    TaskHelper.a(kD, ly.gA().hl(), ly.dP());
    ((com.google.android.keep.browse.a)Binder.a(getActivity(), com.google.android.keep.browse.a.class)).aY();
  }

  private void le()
  {
    Fc = ly.ji();
    Fa.removeAll(Fc);
    Fc.addAll(Fa);
    Fc.removeAll(Fb);
    EZ.w(Fc);
    if (!EY)
    {
      EY = true;
      mHandler.sendEmptyMessage(1);
    }
  }

  private void lf()
  {
    TextView localTextView = ET;
    if (!lN.iL());
    for (boolean bool = true; ; bool = false)
    {
      localTextView.setEnabled(bool);
      return;
    }
  }

  private boolean u(List<Sharee> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
      if (((Sharee)paramList.next()).getEmail().equalsIgnoreCase(fr.getName()))
        return true;
    return false;
  }

  public void a(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
    if (paramInt2 == 1)
      bK(paramInt1);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if ((parama.jdMethod_if() instanceof r))
      lf();
    while (!(parama.jdMethod_if() instanceof com.google.android.keep.model.C))
      return;
    le();
  }

  protected boolean aB()
  {
    return false;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public int getStatusBarColor()
  {
    return kD.getResources().getColor(2131296394);
  }

  public void j(String paramString1, String paramString2)
  {
    paramString1 = new Sharee(uy, paramString1, paramString2);
    EZ.b(paramString1);
    Fa.add(paramString1);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    kD = ((com.google.android.keep.activities.a)getActivity());
    lN = ((r)e(r.class));
    ly = ((com.google.android.keep.model.C)e(com.google.android.keep.model.C.class));
    hb = ((s)Binder.a(kD, s.class));
    fr = o.O(kD);
    eF = ((com.google.android.keep.ui.c)Binder.a(kD, com.google.android.keep.ui.c.class));
    cR = ((com.google.android.keep.browse.a)Binder.a(kD, com.google.android.keep.browse.a.class));
    uy = getArguments().getLong("args_treeEntityId", -1L);
    EX = getArguments().getBoolean("args_showIme");
    dz = getArguments().getString("args_proposedEmail");
    if (EX)
      com.google.android.keep.util.e.A(EU);
    if (paramBundle != null)
    {
      ArrayList localArrayList1 = paramBundle.getParcelableArrayList("shareFragment_shareesToAdd");
      ArrayList localArrayList2 = paramBundle.getParcelableArrayList("shareFragment_shareesToRemove");
      Fa = new ArrayList(localArrayList1);
      Fb = new ArrayList(localArrayList2);
      EY = paramBundle.getBoolean("shareFragment_proposedEmailDialogShown");
    }
    while (true)
    {
      cR.aI();
      EV = new BaseRecipientAdapter(kD);
      EV.setAccount(o.O(kD).hl());
      EU.setAdapter(EV);
      EZ = new f(kD, Fe, fr, eF);
      EZ.v(ly.ji());
      ER.setAdapter(EZ);
      return;
      Fa = new ArrayList();
      Fb = new ArrayList();
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    eC = ((ViewGroup)paramLayoutInflater.inflate(2130968752, null));
    kY();
    ES = eC.findViewById(2131493347);
    EU = ((RecipientAutoCompleteView)ES.findViewById(2131493349));
    EU.setTokenizer(new Rfc822Tokenizer());
    EU.a(Fd);
    ES.findViewById(2131493348).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.google.android.keep.util.e.A(e.c(e.this));
      }
    });
    ER = ((ShareesListView)eC.findViewById(2131493346));
    ER.addHeaderView(paramLayoutInflater.inflate(2130968754, null));
    ER.addFooterView(paramLayoutInflater.inflate(2130968753, null));
    ER.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 != paramAnonymousInt3);
        do
        {
          return;
          paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt2 - 1);
        }
        while (paramAnonymousAbsListView == null);
        paramAnonymousInt1 = paramAnonymousAbsListView.getTop();
        paramAnonymousInt2 = e.d(e.this).getTop();
        e.d(e.this).setTranslationY((paramAnonymousInt2 - paramAnonymousInt1) * -1);
      }

      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
      }
    });
    return eC;
  }

  public void onDestroyView()
  {
    com.google.android.keep.util.e.B(eC);
    super.onDestroyView();
  }

  public void onPause()
  {
    super.onPause();
    kD.unregisterReceiver(EW);
  }

  public void onResume()
  {
    super.onResume();
    EW = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        e.b(e.this);
      }
    };
    kD.registerReceiver(EW, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArrayList("shareFragment_shareesToAdd", new ArrayList(Fa));
    paramBundle.putParcelableArrayList("shareFragment_shareesToRemove", new ArrayList(Fb));
    paramBundle.putBoolean("shareFragment_proposedEmailDialogShown", EY);
  }
}