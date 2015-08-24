package com.google.android.keep.editor;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.google.android.keep.B;
import com.google.android.keep.B.a;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.D;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.VoiceBlob;
import com.google.android.keep.model.p;
import com.google.android.keep.model.s;
import com.google.android.keep.ui.KeepTextView;
import com.google.android.keep.ui.b.a;
import com.google.android.keep.ui.b.b;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class VoiceFragment extends p
  implements B.a, b.b
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wL });
  private static Formatter pA;
  private static StringBuilder pz = new StringBuilder();
  private s kK;
  private View nh;
  private D np;
  private ImageView pB;
  private ProgressBar pC;
  private KeepTextView pD;
  private ImageView pE;
  private Drawable pF;
  private Drawable pG;
  private VoiceBlob pH;
  private B pI;

  static
  {
    pA = new Formatter(pz, Locale.getDefault());
  }

  private void fb()
  {
    if (pH == null)
      return;
    new b.a(this, 0).bO(2131231178).bP(2131231075).show();
  }

  private void fc()
  {
    if (pI == null)
      return;
    VoiceBlob localVoiceBlob = pI.ge();
    if ((pH != null) && (localVoiceBlob != null) && (localVoiceBlob.getId() == pH.getId()))
    {
      if (pI.isPlaying())
      {
        pI.pause();
        pB.setImageDrawable(pF);
        return;
      }
      pI.resume();
      pB.setImageDrawable(pG);
      return;
    }
    if (localVoiceBlob != null)
      pI.stop();
    pI.a(this);
    pB.setImageDrawable(pG);
    pI.b(pH);
  }

  public void a(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
    if ((paramInt2 == 1) && (paramInt1 == 0))
      np.d(pH);
  }

  public void a(long paramLong, int paramInt)
  {
    pC.setProgress(paramInt);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if ((np.size() == 0) || (np.aL(0) == null))
    {
      nh.setVisibility(8);
      return;
    }
    pH = ((VoiceBlob)np.aL(0));
    nh.setVisibility(0);
    pz.setLength(0);
    int j = (int)Math.ceil(pH.getDuration() / 1000);
    int i = j / 60;
    j %= 60;
    parama = pA.format(getString(2131231035), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }).toString();
    pD.setText(parama);
    pB.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        VoiceFragment.a(VoiceFragment.this);
      }
    });
    pE.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        VoiceFragment.b(VoiceFragment.this);
      }
    });
    parama = getResources().getQuantityString(2131755032, i, new Object[] { Integer.valueOf(i) });
    String str = getResources().getQuantityString(2131755033, j, new Object[] { Integer.valueOf(j) });
    nh.setContentDescription(getString(2131231195, new Object[] { parama, str }));
  }

  protected boolean aB()
  {
    return false;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public void l(long paramLong)
  {
    pB.setImageDrawable(pF);
    pC.setProgress(0);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    np = ((D)e(D.class));
    kK = ((s)Binder.a(getActivity(), s.class));
    pF = getResources().getDrawable(2130837715);
    pG = getResources().getDrawable(2130837713);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    nh = paramLayoutInflater.inflate(2130968666, paramViewGroup, false);
    nh.setVisibility(8);
    pB = ((ImageView)nh.findViewById(2131493157));
    pC = ((ProgressBar)nh.findViewById(2131493158));
    pC.setSecondaryProgress(100);
    pD = ((KeepTextView)nh.findViewById(2131493159));
    pE = ((ImageView)nh.findViewById(2131493160));
    return nh;
  }

  public void onPause()
  {
    super.onPause();
    pI.stop();
    pI.release();
    pI = null;
  }

  public void onResume()
  {
    super.onResume();
    pI = new B(getActivity(), kK);
  }
}