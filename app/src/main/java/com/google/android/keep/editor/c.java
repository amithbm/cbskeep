package com.google.android.keep.editor;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.n;
import com.google.android.keep.model.p;
import com.google.android.keep.util.a;
import com.google.android.keep.util.e;
import com.google.android.keep.util.g;
import java.util.Arrays;
import java.util.List;

public class c extends p
  implements ModelEventDispatcher.b
{
  private TreeEntityModel kJ;
  private b kZ;
  private n la;
  private boolean lb;
  private int lc;
  private float ld;
  private View le;
  private View lf;
  private View lg;
  private TextView lh;
  private final View.OnTouchListener li = new View.OnTouchListener()
  {
    private float lj;
    private float lk;

    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      switch (paramAnonymousMotionEvent.getAction() & 0xFF)
      {
      default:
      case 0:
      case 1:
      }
      while (true)
      {
        c.c(c.this).dispatchTouchEvent(paramAnonymousMotionEvent);
        return true;
        lk = paramAnonymousMotionEvent.getRawX();
        lj = paramAnonymousMotionEvent.getRawY();
        continue;
        if ((Math.abs(lk - paramAnonymousMotionEvent.getRawX()) <= c.a(c.this)) && (Math.abs(lj - paramAnonymousMotionEvent.getRawY()) <= c.a(c.this)))
          c.b(c.this);
      }
    }
  };
  private View mContentView;

  public static c a(long paramLong, int paramInt, boolean paramBoolean)
  {
    c localc = new c();
    Bundle localBundle = new Bundle();
    localBundle.putLong("Keep_id", paramLong);
    localBundle.putInt("Keep_pageId", paramInt);
    localBundle.putBoolean("Keep_useConflicts", paramBoolean);
    localc.setArguments(localBundle);
    return localc;
  }

  private void dm()
  {
    boolean bool = true;
    le.sendAccessibilityEvent(1);
    View localView = lf;
    if (!lf.isSelected());
    while (true)
    {
      localView.setSelected(bool);
      lg.setSelected(lf.isSelected());
      if (kZ != null)
        kZ.d(lc, lf.isSelected());
      return;
      bool = false;
    }
  }

  protected String S()
  {
    return getString(2131230859);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    le.setBackgroundColor(kJ.iz().getValue());
    mContentView.setContentDescription(a.a(getActivity(), kJ, la, lb));
    if (lb);
    for (long l1 = la.hF(); ; l1 = kJ.ix().longValue())
    {
      long l2 = l1;
      if (l1 <= 0L)
        l2 = System.currentTimeMillis();
      lh.setText(getString(2131231156, new Object[] { g.i(getActivity(), l2) }));
      return;
    }
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF });
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ld = ViewConfiguration.get(getActivity()).getScaledTouchSlop();
    kZ = ((b)e.a(getActivity(), "conflict_resolution_fragment"));
    kZ.a(this, lc);
    kJ = ((TreeEntityModel)e(TreeEntityModel.class));
    la = ((n)e(n.class));
    paramBundle = getChildFragmentManager().findFragmentById(le.getId());
    if (paramBundle != null)
      ((EditorContentFragment)paramBundle).x(lb);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null)
      throw new IllegalStateException("The getArguments could not be null");
    lc = paramBundle.getInt("Keep_pageId");
    lb = paramBundle.getBoolean("Keep_useConflicts");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mContentView = paramLayoutInflater.inflate(2130968668, null);
    le = mContentView.findViewById(2131493162);
    lf = mContentView.findViewById(2131493116);
    lf.setOnTouchListener(li);
    lh = ((TextView)mContentView.findViewById(2131493161));
    lg = mContentView.findViewById(2131493163);
    setHasOptionsMenu(false);
    return mContentView;
  }

  public void setSelected(boolean paramBoolean)
  {
    lf.setSelected(paramBoolean);
    lg.setSelected(paramBoolean);
  }
}