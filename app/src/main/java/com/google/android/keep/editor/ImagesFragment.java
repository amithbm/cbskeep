package com.google.android.keep.editor;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.keep.activities.GalleryActivity;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.B;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.model.ModelEventDispatcher;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.i;
import com.google.android.keep.model.n;
import com.google.android.keep.model.p;
import com.google.android.keep.ui.b.a;
import com.google.android.keep.ui.b.b;
import com.google.android.keep.util.D;
import com.google.android.keep.util.a;
import com.google.android.keep.x;
import java.util.Arrays;
import java.util.List;

public class ImagesFragment extends p
  implements b.b
{
  private static final List<ModelEventDispatcher.EventType> fD = Arrays.asList(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wL, ModelEventDispatcher.EventType.xs, ModelEventDispatcher.EventType.wM, ModelEventDispatcher.EventType.xt, ModelEventDispatcher.EventType.xn });
  private i mb;
  private FrameLayout mc;
  private int md = 0;
  private TreeEntityModel me;

  private void a(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1)
      return;
    n localn = (n)Binder.a(getActivity(), n.class);
    final long l = paramIntent.getLongExtra("com.google.android.keep.intent.extra.INTENT_EXTRA_EXTRACTION_BUSY_BLOB_ID", -1L);
    paramIntent = paramIntent.getStringExtra("com.google.android.keep.intent.extra.EXTRACTED_TEXT");
    new B(new ModelEventDispatcher[] { me, mb, localn })
    {
      protected void run()
      {
        if (l != -1L)
          ImagesFragment.b(ImagesFragment.this).a(ImagesFragment.b(ImagesFragment.this).t(l));
        while (TextUtils.isEmpty(mi))
          return;
        ImagesFragment.b(ImagesFragment.this).O(mi);
      }
    };
  }

  private void ao(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("KEY_INDEX_TO_DELETE", paramInt);
    new b.a(this, 1).bO(2131231177).bP(2131231075).a(localBundle).show();
  }

  private void ap(int paramInt)
  {
    Object localObject = (ImageBlob)mb.aL(paramInt);
    if (((ImageBlob)localObject).getContentUri() == null)
      return;
    localObject = GalleryActivity.a(getActivity(), mb.dP(), ((ImageBlob)localObject).getContentUri());
    ((Intent)localObject).setAction("android.intent.action.EDIT");
    ((Intent)localObject).putExtra("isReadonly", me.jx());
    startActivityForResult((Intent)localObject, 7);
  }

  private View d(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Requested invalid photo container " + paramInt);
    case 0:
      return paramView.findViewById(2131493185);
    case 1:
      return paramView.findViewById(2131493186);
    case 2:
      return paramView.findViewById(2131493187);
    case 3:
      return paramView.findViewById(2131493188);
    case 4:
      return paramView.findViewById(2131493189);
    case 5:
    }
    return paramView.findViewById(2131493190);
  }

  private int dT()
  {
    mc.removeAllViews();
    switch (mb.size())
    {
    default:
      return 2130968686;
    case 0:
      return 0;
    case 1:
      return 2130968680;
    case 2:
      return 2130968681;
    case 3:
      return 2130968682;
    case 4:
      return 2130968683;
    case 5:
      return 2130968684;
    case 6:
    }
    return 2130968685;
  }

  private void dU()
  {
    D.bO("ImagesFragment_updateUi");
    int i = Math.min(7, mb.size());
    if (i == 0)
    {
      mc.removeAllViews();
      md = i;
      return;
    }
    if (md != i)
    {
      mc.removeAllViews();
      mc.addView(getActivity().getLayoutInflater().inflate(dT(), mc, false));
      md = i;
    }
    Object localObject = mc.getChildAt(0);
    if (mb.size() <= 6);
    for (i = mb.size(); ; i = 5)
    {
      int j = 0;
      while (j < i)
      {
        e(d((View)localObject, j), j);
        j += 1;
      }
    }
    localObject = (TextView)((View)localObject).findViewById(2131493191);
    if (localObject != null)
    {
      i = mb.size() - 5;
      ((TextView)localObject).setText(getResources().getQuantityString(2131755022, i, new Object[] { Integer.valueOf(i) }));
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ImagesFragment.a(ImagesFragment.this);
        }
      });
    }
    D.ot();
  }

  private void dV()
  {
    ap(6);
  }

  private void e(View paramView, final int paramInt)
  {
    int i = 0;
    if (paramView == null)
      return;
    D.bO("ImagesFragment_updatePhotoContainer");
    ImageBlob localImageBlob = (ImageBlob)mb.aL(paramInt);
    ImageView localImageView = (ImageView)paramView.findViewById(2131493192);
    View localView1 = paramView.findViewById(2131493116);
    View localView2 = paramView.findViewById(2131493160);
    paramView = paramView.findViewById(2131493193);
    x.fV().a(getActivity(), localImageView, localImageBlob.getContentUri());
    if (me.jx())
    {
      localView2.setVisibility(8);
      localView1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ImagesFragment.b(ImagesFragment.this, paramInt);
        }
      });
      if (!localImageBlob.gY())
        break label154;
    }
    label154: for (paramInt = i; ; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
      D.ot();
      return;
      localView2.setVisibility(0);
      localView2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ImagesFragment.a(ImagesFragment.this, paramInt);
        }
      });
      break;
    }
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 7)
      a(paramInt2, paramIntent);
  }

  public void a(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
    if (paramInt2 != 1);
    while (paramInt1 != 1)
      return;
    paramInt1 = ((Bundle)paramParcelable).getInt("KEY_INDEX_TO_DELETE");
    mb.aK(paramInt1);
    a.b(mc, getResources().getString(2131231299));
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!ih())
      return;
    dU();
  }

  protected boolean aB()
  {
    return false;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return fD;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    mb = ((i)e(i.class));
    me = ((TreeEntityModel)e(TreeEntityModel.class));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mc = ((FrameLayout)paramLayoutInflater.inflate(2130968687, paramViewGroup, false));
    return mc;
  }
}