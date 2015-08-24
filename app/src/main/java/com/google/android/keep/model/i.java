package com.google.android.keep.model;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.db.a;
import com.google.android.keep.db.a.a;
import com.google.android.keep.p;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.toasts.ToastListener;
import com.google.android.keep.toasts.ToastListener.Type;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.util.e;
import com.google.api.client.util.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class i extends b<ImageBlob>
{
  private final n nn;
  private final TreeEntityModel vw;

  public i(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uB);
    paramFragmentActivity = Binder.g(paramFragmentActivity);
    vw = ((TreeEntityModel)paramFragmentActivity.a(TreeEntityModel.class));
    nn = ((n)paramFragmentActivity.a(n.class));
  }

  private void a(ImageBlob.a parama)
  {
    if ((parama.gZ() == 2) && (!hc()))
      he();
  }

  private void he()
  {
    if (!hc());
    boolean bool1;
    for (boolean bool2 = true; ; bool2 = false)
    {
      Preconditions.checkArgument(bool2);
      bool1 = false;
      Iterator localIterator = mItems.iterator();
      while (localIterator.hasNext())
        bool1 |= O(((ImageBlob)localIterator.next()).getExtractedText());
    }
    if (bool1)
    {
      e.b(getActivity(), 2131231298);
      return;
    }
    e.b(getActivity(), 2131231300);
  }

  public boolean O(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    if (vw.jw())
      nn.ab(paramString);
    while (true)
    {
      return true;
      ArrayList localArrayList = Lists.newArrayList();
      paramString = paramString.split("\n");
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        CharSequence localCharSequence = paramString[i];
        if (TextUtils.isEmpty(localCharSequence));
        while (true)
        {
          i += 1;
          break;
          localArrayList.add(new ListItem(vw.dP()).X(localCharSequence));
        }
      }
      nn.k(localArrayList);
    }
  }

  public boolean a(ImageBlob paramImageBlob)
  {
    if (paramImageBlob == null)
      return false;
    if (paramImageBlob.gW())
    {
      paramImageBlob.O(true);
      return false;
    }
    return O(paramImageBlob.getExtractedText());
  }

  public void c(ModelEventDispatcher.a parama)
  {
    if ((parama instanceof ImageBlob.b))
      if (((ImageBlob.b)parama).ha())
        gP().a(this, new a.a().t(true));
    while (true)
    {
      super.c(parama);
      return;
      gP().a(this);
      continue;
      if ((parama instanceof ImageBlob.a))
        a((ImageBlob.a)parama);
    }
  }

  public void fX()
  {
    if (!isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (!hc())
        break label106;
      if (e.a(getActivity()))
        break;
      e.b(getActivity(), 2131231301);
      return;
    }
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
      ((ImageBlob)localIterator.next()).O(true);
    ((ToastsFragment)e.a(getActivity(), 2131493048)).a(new a(getActivity()));
    return;
    label106: he();
  }

  protected Loader<Cursor> gy()
  {
    return ImageBlob.a(getActivity(), dP());
  }

  public boolean hb()
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      ImageBlob localImageBlob = (ImageBlob)localIterator.next();
      if ((localImageBlob != null) && (localImageBlob.gX()))
        return true;
    }
    return false;
  }

  public boolean hc()
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
      if (((ImageBlob)localIterator.next()).gW())
        return true;
    return false;
  }

  public void hd()
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
      ((ImageBlob)localIterator.next()).O(false);
    gP().a(this);
  }

  public void j(List<DbOperation> paramList)
  {
    if (dP() == -1L);
    while (true)
    {
      return;
      Iterator localIterator = mItems.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = ((ImageBlob)localIterator.next()).d(Long.valueOf(dP()));
        if (localObject != null)
          paramList.add(localObject);
      }
      localIterator = gG().iterator();
      while (localIterator.hasNext())
      {
        localObject = (ImageBlob)localIterator.next();
        paramList.add(DbOperation.cZ().b(i.e.Ce).a("_id = " + ((ImageBlob)localObject).getId(), null).a("is_deleted", Integer.valueOf(1)));
      }
    }
  }

  ImageBlob l(Cursor paramCursor)
  {
    return new ImageBlob(paramCursor);
  }

  public ImageBlob t(long paramLong)
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      ImageBlob localImageBlob = (ImageBlob)localIterator.next();
      if (localImageBlob.getId() == paramLong)
        return localImageBlob;
    }
    return null;
  }

  public static class a extends ToastListener
  {
    private final Context mContext;

    public a(Context paramContext)
    {
      mContext = paramContext;
    }

    public String hf()
    {
      return mContext.getResources().getString(2131231296);
    }

    public ToastListener.Type hg()
    {
      return ToastListener.Type.HN;
    }

    public int hh()
    {
      return 2131231092;
    }

    protected String hi()
    {
      return mContext.getResources().getString(2131231297);
    }

    public void hj()
    {
      Hz = true;
      ((i)Binder.a(mContext, i.class)).hd();
    }
  }
}