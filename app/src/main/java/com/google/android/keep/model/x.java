package com.google.android.keep.model;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.common.base.Preconditions;
import com.google.android.gms.drive.realtime.CollaborativeList;
import com.google.android.gms.drive.realtime.CollaborativeList.ValuesAddedEvent;
import com.google.android.gms.drive.realtime.CollaborativeList.ValuesRemovedEvent;
import com.google.android.gms.drive.realtime.CollaborativeMap;
import com.google.android.gms.drive.realtime.CollaborativeMap.ValueChangedEvent;
import com.google.android.gms.drive.realtime.CollaborativeObject.ObjectChangedEvent;
import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.gms.drive.realtime.Collaborator;
import com.google.android.gms.drive.realtime.CompoundOperation;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.gms.drive.realtime.RealtimeDocument;
import com.google.android.gms.drive.realtime.RealtimeDocument.CollaboratorJoinedEvent;
import com.google.android.gms.drive.realtime.RealtimeDocument.CollaboratorLeftEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.editor.e.b;
import com.google.android.keep.editor.e.d;
import com.google.android.keep.k;
import com.google.android.keep.p;
import com.google.android.keep.q.b;
import com.google.android.keep.q.g;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.o;
import java.util.Iterator;
import java.util.List;

public class x extends ModelEventDispatcher
  implements e.b, e.d, k, q.b, q.g, com.google.android.keep.r
{
  private j fr;
  private final Activity mActivity;
  private Model yM;
  private boolean yN;
  private boolean yO;
  private boolean yP;
  private RealtimeEvent.Listener<CollaborativeMap.ValueChangedEvent> yQ = new RealtimeEvent.Listener()
  {
    public void a(CollaborativeMap.ValueChangedEvent paramAnonymousValueChangedEvent)
    {
      if (paramAnonymousValueChangedEvent.isLocal())
        return;
      b(ModelEventDispatcher.EventType.xB);
    }
  };
  private final RealtimeEvent.Listener<RealtimeDocument.CollaboratorJoinedEvent> yR = new RealtimeEvent.Listener()
  {
    public void a(RealtimeDocument.CollaboratorJoinedEvent paramAnonymousCollaboratorJoinedEvent)
    {
      c(new x.a(x.this, ModelEventDispatcher.EventType.xz, paramAnonymousCollaboratorJoinedEvent.getCollaborator()));
    }
  };
  private final RealtimeEvent.Listener<RealtimeDocument.CollaboratorLeftEvent> yS = new RealtimeEvent.Listener()
  {
    public void a(RealtimeDocument.CollaboratorLeftEvent paramAnonymousCollaboratorLeftEvent)
    {
      c(new x.a(x.this, ModelEventDispatcher.EventType.xA, paramAnonymousCollaboratorLeftEvent.getCollaborator()));
    }
  };
  private final RealtimeEvent.Listener<CollaborativeObject.ObjectChangedEvent> yT = new RealtimeEvent.Listener()
  {
    private void a(CollaborativeObjectEvent paramAnonymousCollaborativeObjectEvent)
    {
      if (((paramAnonymousCollaborativeObjectEvent instanceof CollaborativeMap.ValueChangedEvent)) && (((CollaborativeMap.ValueChangedEvent)paramAnonymousCollaborativeObjectEvent).getProperty().equals("keep_last_modifier_email")))
        return;
      x.a(x.this);
    }

    public void a(CollaborativeObject.ObjectChangedEvent paramAnonymousObjectChangedEvent)
    {
      paramAnonymousObjectChangedEvent = paramAnonymousObjectChangedEvent.getCauses().iterator();
      while (paramAnonymousObjectChangedEvent.hasNext())
      {
        Object localObject = (CollaborativeObjectEvent)paramAnonymousObjectChangedEvent.next();
        if (((CollaborativeObjectEvent)localObject).isLocal())
        {
          a((CollaborativeObjectEvent)localObject);
        }
        else if ((localObject instanceof CollaborativeMap.ValueChangedEvent))
        {
          localObject = (CollaborativeMap.ValueChangedEvent)localObject;
          String str = ((CollaborativeMap.ValueChangedEvent)localObject).getProperty();
          if (str.equals("keep_note_type"))
            x.a(x.this, TreeEntity.TreeEntityType.ar((String)((CollaborativeMap.ValueChangedEvent)localObject).getNewValue()));
          else if ((str.equals("keep_model_version")) && (com.google.android.keep.sharing.a.b(x.b(x.this))))
            x.c(x.this);
        }
      }
    }
  };
  private RealtimeEvent.Listener<CollaborativeList.ValuesAddedEvent> yU = new RealtimeEvent.Listener()
  {
    public void a(CollaborativeList.ValuesAddedEvent paramAnonymousValuesAddedEvent)
    {
      if (paramAnonymousValuesAddedEvent.isLocal())
        return;
      b(ModelEventDispatcher.EventType.xD);
    }
  };
  private RealtimeEvent.Listener<CollaborativeList.ValuesRemovedEvent> yV = new RealtimeEvent.Listener()
  {
    public void a(CollaborativeList.ValuesRemovedEvent paramAnonymousValuesRemovedEvent)
    {
      if (paramAnonymousValuesRemovedEvent.isLocal())
        return;
      b(ModelEventDispatcher.EventType.xE);
    }
  };

  public x(com.google.android.keep.activities.a parama, p paramp)
  {
    mActivity = parama;
    fr = o.O(mActivity);
    paramp.b(this);
  }

  private void a(boolean paramBoolean, TreeEntity.TreeEntityType paramTreeEntityType)
  {
    CollaborativeMap localCollaborativeMap = yM.getRoot();
    if ((!localCollaborativeMap.containsKey("keep_note_type")) || ((paramBoolean) && (com.google.android.keep.sharing.a.d(yM) != paramTreeEntityType)))
      localCollaborativeMap.put("keep_note_type", TreeEntity.TreeEntityType.f(paramTreeEntityType));
  }

  private void a(boolean paramBoolean, String paramString)
  {
    CollaborativeMap localCollaborativeMap = yM.getRoot();
    if ((!localCollaborativeMap.containsKey("keep_uuid")) || ((paramBoolean) && (!TextUtils.equals(com.google.android.keep.sharing.a.c(yM), paramString))))
      localCollaborativeMap.put("keep_uuid", paramString);
  }

  private void ad(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject1 = yM.getRoot();
    Object localObject3 = (TreeEntityModel)Binder.a(mActivity, TreeEntityModel.class);
    Object localObject2 = (n)Binder.a(mActivity, n.class);
    localObject3 = ((TreeEntityModel)localObject3).iA();
    Model localModel;
    if (!((CollaborativeMap)localObject1).containsKey("keep_list_settings_v2"))
    {
      localModel = yM;
      if (!((TreeEntitySettings)localObject3).ei())
        com.google.android.keep.sharing.a.a(localModel, bool1, ((TreeEntitySettings)localObject3).ej());
    }
    while (true)
      if ((((CollaborativeMap)localObject1).containsKey("keep_list")) && (!paramBoolean))
      {
        return;
        bool1 = false;
        break;
        if (paramBoolean)
        {
          localModel = yM;
          if (!((TreeEntitySettings)localObject3).ei());
          for (bool1 = bool2; ; bool1 = false)
          {
            com.google.android.keep.sharing.a.b(localModel, bool1, ((TreeEntitySettings)localObject3).ej());
            break;
          }
        }
      }
    if (!((CollaborativeMap)localObject1).containsKey("keep_list"))
      localObject1 = com.google.android.keep.sharing.a.k(yM);
    while (true)
    {
      localObject2 = ((n)localObject2).hC().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ListItem)((Iterator)localObject2).next();
        ((CollaborativeList)localObject1).add(com.google.android.keep.sharing.a.a(mActivity, yM, (ListItem)localObject3));
      }
      break;
      localObject1 = com.google.android.keep.sharing.a.g(yM);
      ((CollaborativeList)localObject1).clear();
    }
  }

  private void ae(boolean paramBoolean)
  {
    CollaborativeMap localCollaborativeMap = yM.getRoot();
    Object localObject = (n)Binder.a(mActivity, n.class);
    int i = ((n)localObject).size();
    if (i == 0)
    {
      com.google.android.keep.util.r.e("RealtimeDataModel", "ListItemsModel has size 0", new Object[0]);
      ((n)localObject).c(new ListItem(((n)localObject).dP()).X(""));
    }
    String str;
    do
      while (true)
      {
        localObject = (ListItem)((n)localObject).gE();
        str = ((ListItem)localObject).gu();
        if (localCollaborativeMap.containsKey("keep_note_body"))
          break;
        com.google.android.keep.sharing.a.a(yM, str, ((ListItem)localObject).getText());
        return;
        if (i > 1)
          com.google.android.keep.util.r.e("RealtimeDataModel", "ListItemsModel has size: " + i + " for Note type", new Object[0]);
      }
    while (!paramBoolean);
    com.google.android.keep.sharing.a.b(yM, str, ((ListItem)localObject).getText());
  }

  private void b(RealtimeDocument paramRealtimeDocument)
  {
    CollaborativeMap localCollaborativeMap = yM.getRoot();
    localCollaborativeMap.removeObjectChangedListener(yT);
    localCollaborativeMap.addObjectChangedListener(yT);
    paramRealtimeDocument.removeCollaboratorJoinedListener(yR);
    paramRealtimeDocument.removeCollaboratorLeftListener(yS);
    paramRealtimeDocument.addCollaboratorJoinedListener(yR);
    paramRealtimeDocument.addCollaboratorLeftListener(yS);
    if (com.google.android.keep.sharing.a.d(yM) == TreeEntity.TreeEntityType.zP)
      iX();
  }

  private void b(boolean paramBoolean, String paramString)
  {
    CollaborativeMap localCollaborativeMap = yM.getRoot();
    if (!localCollaborativeMap.containsKey("keep_title"))
    {
      localCollaborativeString = yM.createString();
      localCollaborativeString.setText(paramString);
      localCollaborativeMap.put("keep_title", localCollaborativeString);
    }
    while (!paramBoolean)
    {
      CollaborativeString localCollaborativeString;
      return;
    }
    com.google.android.keep.sharing.a.b(yM, paramString);
  }

  private void c(TreeEntity.TreeEntityType paramTreeEntityType)
  {
    int m = 0;
    int k = 0;
    if (yM == null)
      throw new IllegalArgumentException("Model cannot be null!");
    CollaborativeMap localCollaborativeMap = yM.getRoot();
    int i;
    if ((!localCollaborativeMap.containsKey("keep_uuid")) || (!localCollaborativeMap.containsKey("keep_note_type")) || (!localCollaborativeMap.containsKey("keep_title")) || (!localCollaborativeMap.containsKey("keep_model_version")))
    {
      i = 1;
      j = i;
      if (i == 0)
      {
        if (paramTreeEntityType != TreeEntity.TreeEntityType.zP)
          break label184;
        if (localCollaborativeMap.containsKey("keep_list"))
          break label179;
        j = 1;
        label114: paramTreeEntityType = com.google.android.keep.sharing.a.h(yM);
        if ((paramTreeEntityType == null) || (!paramTreeEntityType.containsKey("keep_checked_list_items_policy")) || (!paramTreeEntityType.containsKey("keep_new_list_item_placement")))
          k = 1;
      }
    }
    for (int j = i | j | k; ; j = i | j)
    {
      if (j != 0)
        a(yM, true);
      return;
      i = 0;
      break;
      label179: j = 0;
      break label114;
      label184: paramTreeEntityType = com.google.android.keep.sharing.a.l(yM);
      if ((paramTreeEntityType != null) && (paramTreeEntityType.containsKey("keep_uuid")) && (paramTreeEntityType.containsKey("keep_text")))
      {
        j = m;
        if (!TextUtils.equals((String)paramTreeEntityType.get("keep_uuid"), (String)localCollaborativeMap.get("keep_uuid")));
      }
      else
      {
        j = 1;
      }
    }
  }

  private void d(TreeEntity.TreeEntityType paramTreeEntityType)
  {
    n localn = (n)Binder.a(mActivity, n.class);
    if (paramTreeEntityType == TreeEntity.TreeEntityType.zP)
    {
      localn.hI();
      iX();
    }
    while (true)
    {
      ((TreeEntityModel)Binder.a(mActivity, TreeEntityModel.class)).g(paramTreeEntityType);
      return;
      if (paramTreeEntityType == TreeEntity.TreeEntityType.zO)
        localn.b(false, true);
    }
  }

  private void iV()
  {
    String str1 = com.google.android.keep.sharing.a.f(yM);
    String str2 = fr.getName();
    if (!TextUtils.equals(str1, str2))
      yM.getRoot().put("keep_last_modifier_email", str2);
  }

  private void iX()
  {
    Preconditions.checkArgument(iP());
    Object localObject = com.google.android.keep.sharing.a.h(yM);
    ((CollaborativeMap)localObject).removeValueChangedListener(yQ);
    ((CollaborativeMap)localObject).addValueChangedListener(yQ);
    localObject = com.google.android.keep.sharing.a.g(yM);
    ((CollaborativeList)localObject).removeValuesAddedListener(yU);
    ((CollaborativeList)localObject).removeValuesRemovedListener(yV);
    ((CollaborativeList)localObject).addValuesAddedListener(yU);
    ((CollaborativeList)localObject).addValuesRemovedListener(yV);
  }

  private void iY()
  {
    if (!yP)
    {
      yP = true;
      b(ModelEventDispatcher.EventType.xy);
    }
  }

  private void ja()
  {
    yO = false;
    yN = false;
    yP = false;
  }

  public void a(Model paramModel, boolean paramBoolean)
  {
    yM = paramModel;
    paramModel = yM.getRoot();
    TreeEntityModel localTreeEntityModel = (TreeEntityModel)Binder.a(mActivity, TreeEntityModel.class);
    TreeEntity.TreeEntityType localTreeEntityType = localTreeEntityModel.ir();
    paramModel.put("keep_model_version", Integer.valueOf(Config.nY()));
    a(paramBoolean, localTreeEntityModel.gu());
    a(paramBoolean, localTreeEntityType);
    b(paramBoolean, localTreeEntityModel.getTitle());
    if (localTreeEntityType == TreeEntity.TreeEntityType.zP)
      ad(paramBoolean);
    while (true)
    {
      yN = false;
      return;
      ae(paramBoolean);
    }
  }

  public void a(RealtimeDocument paramRealtimeDocument)
  {
    a(paramRealtimeDocument.getModel(), yN);
    if (com.google.android.keep.sharing.a.b(yM))
      iY();
    c(com.google.android.keep.sharing.a.d(yM));
    TreeEntityModel localTreeEntityModel = (TreeEntityModel)Binder.a(mActivity, TreeEntityModel.class);
    localTreeEntityModel.g(com.google.android.keep.sharing.a.d(yM));
    localTreeEntityModel.af(true);
    localTreeEntityModel.N(true);
    localTreeEntityModel.r(System.currentTimeMillis());
    b(paramRealtimeDocument);
    yO = true;
    b(ModelEventDispatcher.EventType.xw);
    com.google.android.keep.util.r.a("RealtimeDataModel", "handleRealtimeDocumentLoaded finished: " + System.currentTimeMillis(), new Object[0]);
  }

  public void aE()
  {
    fr = o.O(mActivity);
  }

  public void ac(boolean paramBoolean)
  {
    yN = paramBoolean;
  }

  public void b(final String paramString1, final String paramString2)
  {
    paramString1 = new CompoundOperation()
    {
      public void performCompoundOperation(Model paramAnonymousModel)
      {
        com.google.android.keep.sharing.a.a(paramAnonymousModel, paramString1, paramString2);
        com.google.android.keep.sharing.a.a(paramAnonymousModel, TreeEntity.TreeEntityType.zO);
        com.google.android.keep.sharing.a.n(paramAnonymousModel);
        com.google.android.keep.sharing.a.o(paramAnonymousModel);
      }
    };
    yM.performCompoundOperation(paramString1, paramString1.getClass().getSimpleName());
  }

  public void c(TreeEntitySettings paramTreeEntitySettings)
  {
    if (com.google.android.keep.sharing.a.h(yM) == null)
      return;
    if (!paramTreeEntitySettings.ei());
    for (final boolean bool1 = true; ; bool1 = false)
    {
      final boolean bool2 = paramTreeEntitySettings.ej();
      paramTreeEntitySettings = yM;
      CompoundOperation local1 = new CompoundOperation()
      {
        public void performCompoundOperation(Model paramAnonymousModel)
        {
          paramAnonymousModel = com.google.android.keep.sharing.a.h(paramAnonymousModel);
          if (paramAnonymousModel == null);
          String str1;
          String str2;
          do
          {
            return;
            str1 = (String)paramAnonymousModel.get("keep_checked_list_items_policy");
            str2 = com.google.android.keep.sharing.a.am(bool1);
            if (!TextUtils.equals(str1, str2))
              paramAnonymousModel.put("keep_checked_list_items_policy", str2);
            str1 = (String)paramAnonymousModel.get("keep_new_list_item_placement");
            str2 = com.google.android.keep.sharing.a.an(bool2);
          }
          while (TextUtils.equals(str1, str2));
          paramAnonymousModel.put("keep_new_list_item_placement", str2);
        }
      };
      paramTreeEntitySettings.performCompoundOperation(local1, local1.getClass().getSimpleName());
      return;
    }
  }

  public void dy()
  {
    iZ();
    ib();
  }

  public boolean ej()
  {
    return TextUtils.equals((String)com.google.android.keep.sharing.a.h(yM).get("keep_new_list_item_placement"), "TOP");
  }

  public boolean hL()
  {
    CollaborativeMap localCollaborativeMap = com.google.android.keep.sharing.a.h(yM);
    if (localCollaborativeMap == null)
      throw new IllegalStateException("Failed to get list settings from brix model");
    return TextUtils.equals((String)localCollaborativeMap.get("keep_checked_list_items_policy"), "GRAVEYARD");
  }

  public boolean iP()
  {
    return com.google.android.keep.sharing.a.d(yM) == TreeEntity.TreeEntityType.zP;
  }

  public CollaborativeString iQ()
  {
    return com.google.android.keep.sharing.a.a(yM, "keep_title");
  }

  public CollaborativeString iR()
  {
    return (CollaborativeString)com.google.android.keep.sharing.a.l(yM).get("keep_text");
  }

  public String iS()
  {
    return (String)com.google.android.keep.sharing.a.l(yM).get("keep_uuid");
  }

  public boolean iT()
  {
    return yN;
  }

  public boolean iU()
  {
    return yP;
  }

  public List<CollaborativeMap> iW()
  {
    return com.google.android.keep.sharing.a.a(com.google.android.keep.sharing.a.g(yM));
  }

  public void iZ()
  {
    ja();
    b(ModelEventDispatcher.EventType.xx);
  }

  public boolean isActive()
  {
    return yO;
  }

  public void j(long paramLong)
  {
    b(ModelEventDispatcher.EventType.wF);
  }

  public void m(final List<ListItem> paramList)
  {
    if (paramList.size() == 0)
      return;
    paramList = new CompoundOperation()
    {
      public void performCompoundOperation(Model paramAnonymousModel)
      {
        paramAnonymousModel = paramList.iterator();
        while (paramAnonymousModel.hasNext())
        {
          ListItem localListItem = (ListItem)paramAnonymousModel.next();
          p(localListItem);
        }
      }
    };
    yM.performCompoundOperation(paramList, paramList.getClass().getSimpleName());
  }

  public void n(final List<ListItem> paramList)
  {
    paramList = new CompoundOperation()
    {
      public void performCompoundOperation(Model paramAnonymousModel)
      {
        com.google.android.keep.sharing.a.k(paramAnonymousModel);
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          ListItem localListItem = (ListItem)localIterator.next();
          p(localListItem);
        }
        if (!zd.ei());
        for (boolean bool = true; ; bool = false)
        {
          com.google.android.keep.sharing.a.a(paramAnonymousModel, bool, zd.ej());
          com.google.android.keep.sharing.a.a(paramAnonymousModel, TreeEntity.TreeEntityType.zP);
          com.google.android.keep.sharing.a.m(paramAnonymousModel);
          return;
        }
      }
    };
    yM.performCompoundOperation(paramList, paramList.getClass().getSimpleName());
    iX();
  }

  public void o(ListItem paramListItem)
  {
    com.google.android.keep.sharing.a.b(yM, paramListItem.gu(), paramListItem.getText());
  }

  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null)
      yN = paramBundle.getBoolean("RealtimeDataModel.shouldInitialize");
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("RealtimeDataModel.shouldInitialize", yN);
  }

  public void p(ListItem paramListItem)
  {
    CollaborativeList localCollaborativeList = com.google.android.keep.sharing.a.g(yM);
    if (localCollaborativeList == null)
      return;
    Object localObject = iW().iterator();
    while (((Iterator)localObject).hasNext())
      if (TextUtils.equals(com.google.android.keep.sharing.a.d((CollaborativeMap)((Iterator)localObject).next()), paramListItem.gu()))
        throw new IllegalStateException("Trying to add duplicated collaborative item, uuid: " + paramListItem.gu());
    localObject = com.google.android.keep.sharing.a.a(mActivity, yM, paramListItem.gu(), paramListItem.getText(), paramListItem.isChecked(), paramListItem.hu().longValue());
    paramListItem.a((CollaborativeMap)localObject);
    localCollaborativeList.add(localObject);
  }

  public void q(ListItem paramListItem)
  {
    CollaborativeList localCollaborativeList = com.google.android.keep.sharing.a.g(yM);
    if (localCollaborativeList == null)
      return;
    localCollaborativeList.remove(paramListItem.hw());
  }

  public static class a extends ModelEventDispatcher.a
  {
    protected Collaborator ze;

    public a(Object paramObject, ModelEventDispatcher.EventType paramEventType, Collaborator paramCollaborator)
    {
      super(paramEventType);
      ze = paramCollaborator;
    }

    public Collaborator getCollaborator()
    {
      return ze;
    }
  }

  public static class b
    implements RealtimeEvent.Listener<CollaborativeMap.ValueChangedEvent>
  {
    ListItem zf;

    public b(ListItem paramListItem)
    {
      zf = paramListItem;
    }

    public void a(CollaborativeMap.ValueChangedEvent paramValueChangedEvent)
    {
      if (paramValueChangedEvent.isLocal());
      long l;
      do
      {
        do
        {
          return;
          paramValueChangedEvent = paramValueChangedEvent.getProperty();
          if (TextUtils.equals(paramValueChangedEvent, "keep_is_checked"))
          {
            zf.R(com.google.android.keep.sharing.a.e(zf.hw()));
            return;
          }
        }
        while (!TextUtils.equals(paramValueChangedEvent, "keep_sort_value"));
        l = com.google.android.keep.sharing.a.f(zf.hw());
      }
      while (l == zf.hu().longValue());
      zf.f(Long.valueOf(l));
      zf.b(ModelEventDispatcher.EventType.xC);
    }
  }
}