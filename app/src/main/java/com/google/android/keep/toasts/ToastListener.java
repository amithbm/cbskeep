package com.google.android.keep.toasts;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.keep.L;
import com.google.android.keep.b;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.i.a;
import com.google.android.keep.model.j;
import com.google.android.keep.model.n;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.ui.SgvAnimationHelper.AnimationIn;
import com.google.android.keep.ui.SgvAnimationHelper.AnimationOut;
import com.google.android.keep.ui.StaggeredGridView;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;
import com.google.api.client.util.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class ToastListener
{
  public static int Hy = 0;
  int HA = -1;
  int HB = -1;
  int HC = -1;
  Long HD = null;
  protected boolean Hz = false;

  public static ToastListener a(Bundle paramBundle, Context paramContext, StaggeredGridView paramStaggeredGridView)
  {
    if (paramBundle == null)
      return null;
    Type localType = Type.bM(paramBundle.getInt("savedState_undoBarType"));
    switch (1.HE[localType.ordinal()])
    {
    default:
      return null;
    case 1:
      return new a(paramContext, e.f(paramBundle.getLongArray("savedState_undoBarTreeEntityIds")), e.f(paramBundle.getLongArray("savedState_undoBarTreeEntityOrdersInParet")), paramStaggeredGridView, true);
    case 2:
      return new a(paramContext, e.f(paramBundle.getLongArray("savedState_undoBarTreeEntityIds")), e.f(paramBundle.getLongArray("savedState_undoBarTreeEntityOrdersInParet")), paramStaggeredGridView, false);
    case 3:
      return new g(paramContext, e.f(paramBundle.getLongArray("savedState_undoBarTreeEntityIds")), paramStaggeredGridView);
    case 4:
      return new f(paramContext, e.f(paramBundle.getLongArray("savedState_undoBarTreeEntityIds")), paramStaggeredGridView);
    case 5:
      return new i.a(paramContext);
    case 6:
      return new d(paramContext, e.f(paramBundle.getLongArray("savedState_undoBarTreeEntityIds")));
    case 7:
    }
    return new c(paramContext, paramBundle);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3, Long paramLong)
  {
    HA = paramInt1;
    HB = paramInt2;
    HC = paramInt3;
    HD = paramLong;
  }

  protected abstract String hf();

  protected abstract Type hg();

  protected int hh()
  {
    return 2131231110;
  }

  protected abstract String hi();

  protected abstract void hj();

  protected void lH()
  {
  }

  protected void lI()
  {
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("savedState_undoBarType", hg().value);
  }

  public static enum Type
  {
    private static final Map<Integer, Type> HS;
    protected final int value;

    static
    {
      HS = Maps.newHashMap();
      Type[] arrayOfType = values();
      int j = arrayOfType.length;
      int i = 0;
      while (i < j)
      {
        Type localType = arrayOfType[i];
        HS.put(Integer.valueOf(localType.value), localType);
        i += 1;
      }
    }

    private Type(int paramInt)
    {
      value = paramInt;
    }

    public static Type bM(int paramInt)
    {
      return (Type)HS.get(Integer.valueOf(paramInt));
    }
  }

  public static class a extends ToastListener.h
  {
    private final List<Long> GF;
    private final boolean HF;

    public a(Context paramContext, List<Long> paramList1, List<Long> paramList2, StaggeredGridView paramStaggeredGridView, boolean paramBoolean)
    {
      super(paramList1, paramStaggeredGridView);
      GF = paramList2;
      HF = paramBoolean;
    }

    public String hf()
    {
      int j = GE.size();
      if (HF);
      for (int i = 2131755023; ; i = 2131755024)
        return mContext.getResources().getQuantityString(i, j, new Object[] { Integer.valueOf(j) });
    }

    public ToastListener.Type hg()
    {
      if (HF)
        return ToastListener.Type.HJ;
      return ToastListener.Type.HK;
    }

    protected String hi()
    {
      int j = GE.size();
      if (HF);
      for (int i = 2131755024; ; i = 2131755023)
        return mContext.getResources().getQuantityString(i, j, new Object[] { Integer.valueOf(j) });
    }

    public void hj()
    {
      if (eD != null)
        eD.a(SgvAnimationHelper.AnimationIn.Mm, SgvAnimationHelper.AnimationOut.Mr);
      Context localContext = mContext;
      List localList1 = GE;
      List localList2 = GF;
      if (!HF);
      for (boolean bool = true; ; bool = false)
      {
        TaskHelper.a(localContext, localList1, localList2, bool);
        Hz = true;
        return;
      }
    }

    public void lH()
    {
      if (eD != null)
        eD.a(SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Ms);
      if (HF)
      {
        TaskHelper.c(mContext, GE);
        return;
      }
      TaskHelper.d(mContext, GE);
    }

    public void onSaveInstanceState(Bundle paramBundle)
    {
      super.onSaveInstanceState(paramBundle);
      paramBundle.putLongArray("savedState_undoBarTreeEntityOrdersInParet", e.G(GF));
    }
  }

  public static class b extends ToastListener
  {
    private ArrayList<ListItem> HG = Lists.newArrayList();
    private final Context mContext;

    public b(Context paramContext, Collection<ListItem> paramCollection)
    {
      HG.addAll(paramCollection);
      mContext = paramContext;
    }

    protected String hf()
    {
      int i = HG.size();
      return mContext.getResources().getQuantityString(2131755028, i, new Object[] { Integer.valueOf(i) });
    }

    protected ToastListener.Type hg()
    {
      return ToastListener.Type.HO;
    }

    protected String hi()
    {
      int i = HG.size();
      return mContext.getResources().getQuantityString(2131755029, i, new Object[] { Integer.valueOf(i) });
    }

    protected void hj()
    {
      ((n)Binder.a(mContext, n.class)).k(HG);
      Hz = true;
    }
  }

  public static class c extends ToastListener
  {
    private ListItem HH;
    private final Context mContext;

    public c(Context paramContext, Bundle paramBundle)
    {
      mContext = paramContext;
      HH = ((ListItem)paramBundle.getParcelable("DeleteListItemUndoListener.mDeletedItem"));
    }

    public c(Context paramContext, ListItem paramListItem)
    {
      mContext = paramContext;
      HH = paramListItem;
    }

    protected String hf()
    {
      return mContext.getResources().getQuantityString(2131755028, 1, new Object[] { Integer.valueOf(1) });
    }

    protected ToastListener.Type hg()
    {
      return ToastListener.Type.HR;
    }

    protected String hi()
    {
      return mContext.getResources().getQuantityString(2131755029, 1, new Object[] { Integer.valueOf(1) });
    }

    protected void hj()
    {
      ((n)Binder.a(mContext, n.class)).k(HH);
      Hz = true;
    }

    public void onSaveInstanceState(Bundle paramBundle)
    {
      super.onSaveInstanceState(paramBundle);
      paramBundle.putParcelable("DeleteListItemUndoListener.mDeletedItem", HH);
    }
  }

  public static class d extends ToastListener.h
  {
    public d(Context paramContext, List<Long> paramList)
    {
      super(paramList, null);
    }

    public String hf()
    {
      return mContext.getResources().getString(2131231120);
    }

    public ToastListener.Type hg()
    {
      return ToastListener.Type.HQ;
    }

    protected int hh()
    {
      return 2131231079;
    }

    protected String hi()
    {
      return mContext.getResources().getQuantityString(2131755027, 1, new Object[] { Integer.valueOf(1) });
    }

    public void hj()
    {
      TaskHelper.b(mContext, GE);
      Hz = true;
    }
  }

  public static class e extends ToastListener
  {
    final String HI;

    public e(String paramString)
    {
      HI = paramString;
    }

    protected String hf()
    {
      return HI;
    }

    protected ToastListener.Type hg()
    {
      return ToastListener.Type.HP;
    }

    protected int hh()
    {
      return Hy;
    }

    protected String hi()
    {
      return "";
    }

    protected void hj()
    {
    }
  }

  public static class f extends ToastListener.h
  {
    public f(Context paramContext, List<Long> paramList, StaggeredGridView paramStaggeredGridView)
    {
      super(paramList, paramStaggeredGridView);
    }

    public String hf()
    {
      int i = GE.size();
      return mContext.getResources().getQuantityString(2131755027, i, new Object[] { Integer.valueOf(i) });
    }

    public ToastListener.Type hg()
    {
      return ToastListener.Type.HM;
    }

    protected String hi()
    {
      int i = GE.size();
      return mContext.getResources().getQuantityString(2131755026, i, new Object[] { Integer.valueOf(i) });
    }

    public void hj()
    {
      if (eD != null)
        eD.a(SgvAnimationHelper.AnimationIn.Mj, SgvAnimationHelper.AnimationOut.Mr);
      TaskHelper.a(mContext, GE);
      Hz = true;
    }

    public void lH()
    {
      if (eD != null)
        eD.a(SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Mt);
      TaskHelper.b(mContext, GE);
    }
  }

  public static class g extends ToastListener.h
  {
    private j fr;

    public g(Context paramContext, List<Long> paramList, StaggeredGridView paramStaggeredGridView)
    {
      super(paramList, paramStaggeredGridView);
      fr = o.O(paramContext);
    }

    public String hf()
    {
      int i = GE.size();
      return mContext.getResources().getQuantityString(2131755026, i, new Object[] { Integer.valueOf(i) });
    }

    public ToastListener.Type hg()
    {
      return ToastListener.Type.HL;
    }

    protected String hi()
    {
      int i = GE.size();
      return mContext.getResources().getQuantityString(2131755027, i, new Object[] { Integer.valueOf(i) });
    }

    public void hj()
    {
      if (eD != null)
        eD.a(SgvAnimationHelper.AnimationIn.Mj, SgvAnimationHelper.AnimationOut.Mr);
      TaskHelper.b(mContext, GE);
      Hz = true;
    }

    public void lH()
    {
      if (eD != null)
        eD.a(SgvAnimationHelper.AnimationIn.Ml, SgvAnimationHelper.AnimationOut.Mt);
      TaskHelper.a(mContext, GE);
    }

    public void lI()
    {
      L.a(mContext, fr, GE);
    }
  }

  public static abstract class h extends ToastListener
  {
    final List<Long> GE;
    final StaggeredGridView eD;
    final Context mContext;

    public h(Context paramContext, List<Long> paramList, StaggeredGridView paramStaggeredGridView)
    {
      mContext = paramContext;
      GE = paramList;
      eD = paramStaggeredGridView;
    }

    public void lI()
    {
      if ((!Hz) && (HA != -1))
        ((b)mContext).a(HA, HB, HC, HD);
    }

    public void onSaveInstanceState(Bundle paramBundle)
    {
      super.onSaveInstanceState(paramBundle);
      paramBundle.putLongArray("savedState_undoBarTreeEntityIds", e.G(GE));
    }
  }
}