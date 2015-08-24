package com.google.android.keep.model;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.gms.drive.realtime.CollaborativeMap;
import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.db.a;
import com.google.android.keep.editor.e.a;
import com.google.android.keep.p;
import com.google.android.keep.provider.KeepProvider;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.task.TreeEntityTask;
import com.google.android.keep.util.A;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Sets;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class n extends b<ListItem>
  implements e.a, ModelEventDispatcher.b
{
  private static final List<ModelEventDispatcher.EventType> wj = ImmutableList.of(ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xi, ModelEventDispatcher.EventType.xw, ModelEventDispatcher.EventType.xx, ModelEventDispatcher.EventType.xD, ModelEventDispatcher.EventType.xE);
  private final o fg;
  private final s hb;
  private final x lm;
  private final TreeEntityModel me;
  private final h wg;
  private final h wh;
  private final ListItemsModelSorter wi;

  public n(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uB);
    fg = new o(paramFragmentActivity, this, paramp);
    me = ((TreeEntityModel)fg.e(TreeEntityModel.class));
    lm = ((x)fg.e(x.class));
    wg = new h(this, ListItemFilter.vZ);
    wh = new h(this, ListItemFilter.wa);
    wi = new ListItemsModelSorter(paramFragmentActivity, this);
    hb = ((s)Binder.a(paramFragmentActivity, s.class));
  }

  private String S(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = Lists.newArrayList();
    if (hL())
    {
      ((ArrayList)localObject1).addAll(hA());
      ((ArrayList)localObject1).addAll(hB());
    }
    while (true)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ListItem)((Iterator)localObject1).next();
        if ((!((ListItem)localObject2).isChecked()) || (!paramBoolean))
        {
          localObject2 = ((ListItem)localObject2).getText();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
            localStringBuilder.append((String)localObject2).append("\n");
        }
      }
      localObject1 = mItems;
    }
    return localStringBuilder.toString();
  }

  private void a(ModelEventDispatcher.a parama, ListItem paramListItem)
  {
    wi.a(parama, paramListItem);
    if (paramListItem.gw())
      gP().a(this);
  }

  private String ac(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.split("\n");
    int i1 = mItems.size();
    int i = 0;
    int k = 0;
    if (k < paramString.length)
    {
      CharSequence localCharSequence = paramString[k];
      int n = -1;
      int j = i;
      label48: int m = n;
      if (j < i1)
      {
        if (TextUtils.equals(localCharSequence, ((ListItem)mItems.get(j)).getText()))
          m = j;
      }
      else
      {
        if (m != -1)
          break label118;
        localStringBuilder.append(localCharSequence).append("\n");
      }
      while (true)
      {
        k += 1;
        break;
        j += 1;
        break label48;
        label118: 
        while (i <= m)
        {
          localStringBuilder.append(((ListItem)mItems.get(i)).getText()).append("\n");
          i += 1;
        }
        i = m + 1;
      }
    }
    while (i < i1)
    {
      paramString = ((ListItem)mItems.get(i)).getText();
      if (!TextUtils.isEmpty(paramString))
        localStringBuilder.append(paramString).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }

  private List<ListItem> ad(String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < size())
    {
      localObject1 = ((ListItem)aL(i)).getText();
      if (localHashMap.containsKey(localObject1));
      for (int j = ((Integer)localHashMap.get(localObject1)).intValue() + 1; ; j = 1)
      {
        localHashMap.put(localObject1, Integer.valueOf(j));
        i += 1;
        break;
      }
    }
    Object localObject1 = new ArrayList();
    paramString = paramString.split("\n");
    i = 0;
    if (i < paramString.length)
    {
      Object localObject2 = paramString[i];
      if ((!localHashMap.containsKey(localObject2)) || (((Integer)localHashMap.get(localObject2)).intValue() == 0))
        if (size() < 1000)
        {
          localObject2 = new ListItem(dP()).X((String)localObject2);
          c((d)localObject2);
          ((List)localObject1).add(localObject2);
        }
      while (true)
      {
        i += 1;
        break;
        ListItem localListItem = (ListItem)gF();
        localListItem.X(localListItem.getText() + "\n" + (String)localObject2);
        continue;
        localHashMap.put(localObject2, Integer.valueOf(((Integer)localHashMap.get(localObject2)).intValue() - 1));
      }
    }
    return localObject1;
  }

  private void d(ModelEventDispatcher.a parama)
  {
    wi.d(parama);
    parama = mItems.iterator();
    while (parama.hasNext())
      if (((ListItem)parama.next()).gw())
        gP().a(this);
  }

  private boolean e(ModelEventDispatcher.a parama)
  {
    if (lm.isActive())
      if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.xw, ModelEventDispatcher.EventType.xD, ModelEventDispatcher.EventType.xE }))
        return true;
    return false;
  }

  private void h(ListItem paramListItem)
  {
    ListItem localListItem = (ListItem)G(paramListItem.gu());
    if (localListItem == null)
    {
      c(paramListItem);
      return;
    }
    localListItem.f(paramListItem);
  }

  private void hJ()
  {
    Object localObject1 = (ListItem)gE();
    if (localObject1 == null)
      return;
    Object localObject2 = ((ListItem)localObject1).getText();
    m((ListItem)localObject1);
    String[] arrayOfString = ((String)localObject2).split("\n");
    localObject1 = null;
    int i = 0;
    label36: if (i < arrayOfString.length)
    {
      localObject2 = arrayOfString[i];
      if (!((String)localObject2).isEmpty())
        break label62;
    }
    while (true)
    {
      i += 1;
      break label36;
      break;
      label62: if (size() + 1 == 1000)
      {
        a(new ListItem(dP()).X(TextUtils.join("\n", Arrays.copyOfRange(arrayOfString, i, arrayOfString.length))), (ListItem)localObject1, null);
        return;
      }
      localObject2 = new ListItem(dP()).X((String)localObject2);
      a((ListItem)localObject2, (ListItem)localObject1, null);
      localObject1 = localObject2;
    }
  }

  private void hK()
  {
    wg.invalidate();
    wh.invalidate();
  }

  private void hM()
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      ListItem localListItem = (ListItem)localIterator.next();
      localListItem.a(null);
      localListItem.a(null);
    }
    gP().a(this);
  }

  private void hN()
  {
    uE = true;
    CollaborativeString localCollaborativeString = lm.iR();
    String str = lm.iS();
    ListItem localListItem = (ListItem)gE();
    if ((localListItem != null) && (TextUtils.equals(str, localListItem.gu())))
    {
      localListItem.a(localCollaborativeString);
      uE = false;
      c(ModelEventDispatcher.EventType.wG);
      return;
    }
    throw new IllegalStateException("For a text note, first item is null in ListItemsModel, or the item uuid doesn't match the note body uuid in Brix");
  }

  private void hO()
  {
    Object localObject = lm.iW();
    HashSet localHashSet = Sets.newHashSet();
    uE = true;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ListItem localListItem = b((CollaborativeMap)((Iterator)localObject).next());
      localHashSet.add(localListItem.gu());
      h(localListItem);
    }
    int i = mItems.size() - 1;
    while (i >= 0)
    {
      localObject = (ListItem)mItems.get(i);
      if (!localHashSet.contains(((ListItem)localObject).gu()))
        m((ListItem)localObject);
      i -= 1;
    }
    uE = false;
    c(ModelEventDispatcher.EventType.wG);
  }

  private void l(ListItem paramListItem)
  {
    if (lm.isActive())
      lm.p(paramListItem);
  }

  public void a(ListItem paramListItem1, ListItem paramListItem2, ListItem paramListItem3)
  {
    ic();
    c(paramListItem1);
    b(paramListItem1, paramListItem2, paramListItem3);
    l(paramListItem1);
    id();
    b(ModelEventDispatcher.EventType.wK);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!fg.ih());
    label104: 
    while (true)
    {
      return;
      if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xx }))
        hM();
      while (true)
      {
        if (!me.iP())
          break label104;
        if ((!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xi })) || (!ei()))
          break;
        wi.hV();
        return;
        if (e(parama))
          if (!me.iP())
            hN();
          else
            hO();
      }
    }
  }

  public void ab(String paramString)
  {
    ListItem localListItem = (ListItem)gE();
    if (localListItem == null)
    {
      c(new ListItem(dP()).X(paramString));
      return;
    }
    if (TextUtils.isEmpty(localListItem.getText()));
    for (String str = ""; ; str = localListItem.getText() + "\n")
    {
      localListItem.X(str + paramString);
      return;
    }
  }

  ListItem b(CollaborativeMap paramCollaborativeMap)
  {
    return new ListItem(dP(), paramCollaborativeMap);
  }

  public void b(ListItem paramListItem1, ListItem paramListItem2, ListItem paramListItem3)
  {
    wi.b(paramListItem1, paramListItem2, paramListItem3);
  }

  public void b(TreeEntityTask paramTreeEntityTask)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramTreeEntityTask.lw() != null)
    {
      paramTreeEntityTask = paramTreeEntityTask.lw();
      int j = paramTreeEntityTask.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new ListItem(-1L, paramTreeEntityTask[i]));
        i += 1;
      }
      ic();
      k(localArrayList);
      id();
    }
    b(ModelEventDispatcher.EventType.wF);
  }

  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    ic();
    Object localObject;
    String str;
    if (paramBoolean2)
    {
      localObject = lm.iS();
      if (!paramBoolean2)
        break label139;
      str = ac(lm.iR().toString());
      label36: removeAll(mItems);
      localObject = new ListItem(dP()).X(str).U((String)localObject).R(false).f(Long.valueOf(0L));
      c((d)localObject);
      if (lm.isActive())
      {
        if (!paramBoolean2)
          break label149;
        lm.o((ListItem)localObject);
      }
    }
    while (true)
    {
      ((ListItem)localObject).a(lm.iR());
      gP().flush();
      hK();
      id();
      return;
      localObject = KeepProvider.kw();
      break;
      label139: str = S(paramBoolean1);
      break label36;
      label149: lm.b(((ListItem)localObject).gu(), ((ListItem)localObject).getText());
    }
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return wj;
  }

  public void c(ModelEventDispatcher.a parama)
  {
    if (ie())
      return;
    if ((parama.jdMethod_if() instanceof ListItem))
      a(parama, (ListItem)parama.jdMethod_if());
    while (true)
    {
      super.c(parama);
      return;
      d(parama);
    }
  }

  boolean ei()
  {
    if (me.isInitialized())
      return me.iA().ei();
    return A.ae(getActivity()).ei();
  }

  protected void gB()
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      ListItem localListItem = (ListItem)localIterator.next();
      if ((localListItem.gv()) && (localListItem.hp().longValue() == -1L))
        localListItem.e(Long.valueOf(dP()));
    }
    super.gB();
  }

  protected Loader<Cursor> gy()
  {
    return ListItem.b(getActivity(), dP());
  }

  public h hA()
  {
    return wh;
  }

  public h hB()
  {
    return wg;
  }

  public List<ListItem> hC()
  {
    return Collections.unmodifiableList(mItems);
  }

  public boolean hD()
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
      if (!((ListItem)localIterator.next()).isEmpty())
        return false;
    return true;
  }

  public boolean hE()
  {
    return wg.size() > 0;
  }

  public long hF()
  {
    long l = -1L;
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      ListItem localListItem = (ListItem)localIterator.next();
      if (!TextUtils.isEmpty(localListItem.hq()))
        l = Math.max(localListItem.hr(), l);
    }
    return l;
  }

  public boolean hG()
  {
    if (mItems == null);
    Iterator localIterator;
    do
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = mItems.iterator();
      }
    while (TextUtils.isEmpty(((ListItem)localIterator.next()).hq()));
    return true;
  }

  public void hH()
  {
    ic();
    hJ();
    if (lm.isActive())
      lm.n(hC());
    gP().flush();
    hK();
    id();
  }

  public void hI()
  {
    ic();
    Object localObject = ((ListItem)gE()).getText();
    aK(0);
    Iterator localIterator = lm.iW().iterator();
    while (localIterator.hasNext())
      h(b((CollaborativeMap)localIterator.next()));
    localObject = ad((String)localObject);
    lm.m((List)localObject);
    gP().flush();
    hK();
    id();
  }

  boolean hL()
  {
    return !ei();
  }

  protected void i(ListItem paramListItem)
  {
    if (!lm.isActive())
      super.b(paramListItem);
    ListItem localListItem;
    do
    {
      do
        return;
      while (f(paramListItem));
      localListItem = (ListItem)G(paramListItem.gu());
    }
    while (localListItem == null);
    localListItem.e(paramListItem);
  }

  public void j(List<DbOperation> paramList)
  {
    if (dP() == -1L);
    do
    {
      return;
      Iterator localIterator = mItems.iterator();
      ListItem localListItem;
      while (localIterator.hasNext())
      {
        localListItem = (ListItem)localIterator.next();
        if (localListItem.gw())
          paramList.add(localListItem.gx());
      }
      localIterator = gG().iterator();
      while (localIterator.hasNext())
      {
        localListItem = (ListItem)localIterator.next();
        paramList.add(DbOperation.cZ().b(i.m.Ce).a("_id = " + localListItem.getId(), null).a("is_deleted", Integer.valueOf(1)));
      }
    }
    while (paramList.size() <= 0);
    hb.Z(true);
  }

  protected boolean j(ListItem paramListItem)
  {
    if (!lm.isActive())
      return super.a(paramListItem);
    return false;
  }

  public void k(ListItem paramListItem)
  {
    ic();
    c(paramListItem);
    wi.hS();
    l(paramListItem);
    id();
    b(ModelEventDispatcher.EventType.wK);
  }

  public void k(List<ListItem> paramList)
  {
    ic();
    int i = wh.size();
    if (i > 0);
    for (Object localObject = wh.aT(i - 1); ; localObject = null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (ListItem)localIterator.next();
        a(paramList, (ListItem)localObject, null);
        localObject = paramList;
      }
    }
    id();
    b(ModelEventDispatcher.EventType.wK);
  }

  public boolean m(ListItem paramListItem)
  {
    if (lm.isActive())
      lm.q(paramListItem);
    return super.d(paramListItem);
  }

  ListItem o(Cursor paramCursor)
  {
    return new ListItem(paramCursor);
  }
}