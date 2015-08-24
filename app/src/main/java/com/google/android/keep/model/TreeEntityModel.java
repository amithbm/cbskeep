package com.google.android.keep.model;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.db.a;
import com.google.android.keep.editor.e.a;
import com.google.android.keep.p;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.task.TreeEntityTask;
import com.google.android.keep.util.u;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class TreeEntityModel extends f
  implements e.a, ModelEventDispatcher.b, TreeEntity, w
{
  private static final List<ModelEventDispatcher.EventType> wj = ImmutableList.of(ModelEventDispatcher.EventType.xB);
  private boolean Aa = false;
  private boolean Ab = false;
  private boolean de = false;
  private final o fg;
  private final s hb;
  private final x lm;
  private EditableTreeEntity zY;
  private ContentValues zZ = new ContentValues();

  public TreeEntityModel(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uB);
    fg = new o(paramFragmentActivity, this, paramp);
    lm = ((x)fg.e(x.class));
    hb = ((s)Binder.a(paramFragmentActivity, s.class));
  }

  private void M(String paramString)
  {
    if (!TextUtils.equals(zY.getServerId(), paramString))
    {
      zY.M(paramString);
      b(ModelEventDispatcher.EventType.xj);
    }
  }

  private void a(EditableTreeEntity paramEditableTreeEntity)
  {
    Preconditions.checkArgument(u.equals(zY.gu(), paramEditableTreeEntity.gu()));
    zY.mId = paramEditableTreeEntity.getId();
    zY.zR = paramEditableTreeEntity.ju();
    zY.uL = paramEditableTreeEntity.gJ();
    M(paramEditableTreeEntity.getServerId());
  }

  private TreeEntitySettings d(TreeEntitySettings paramTreeEntitySettings)
  {
    TreeEntitySettings localTreeEntitySettings = paramTreeEntitySettings;
    if (lm.isActive())
    {
      localTreeEntitySettings = paramTreeEntitySettings;
      if (lm.iP())
        if (lm.hL())
          break label58;
    }
    label58: for (boolean bool = true; ; bool = false)
    {
      localTreeEntitySettings = new TreeEntitySettings(bool, paramTreeEntitySettings.jz(), lm.ej());
      return localTreeEntitySettings;
    }
  }

  private boolean gw()
  {
    return (zZ.size() > 0) || ((zY != null) && (zY.gw()));
  }

  public void B(boolean paramBoolean)
  {
    if (de != paramBoolean)
    {
      de = paramBoolean;
      b(ModelEventDispatcher.EventType.xn);
    }
  }

  public void H(long paramLong)
  {
    if (zY.ix().longValue() != paramLong)
    {
      zY.c(Long.valueOf(paramLong));
      b(ModelEventDispatcher.EventType.xf);
      gP().a(this);
    }
  }

  public void K(boolean paramBoolean)
  {
    if (zY.jr() != paramBoolean)
    {
      zY.K(paramBoolean);
      b(ModelEventDispatcher.EventType.xd);
      gP().a(this);
    }
  }

  public void L(boolean paramBoolean)
  {
    if (zY.js() != paramBoolean)
    {
      zY.L(paramBoolean);
      b(ModelEventDispatcher.EventType.xg);
      gP().a(this);
    }
  }

  public void N(boolean paramBoolean)
  {
    if (zY.iE() != paramBoolean)
    {
      zY.N(paramBoolean);
      gP().a(this);
      b(ModelEventDispatcher.EventType.xl);
    }
  }

  public void a(ColorMap.ColorPair paramColorPair)
  {
    if (!TextUtils.equals(zY.iz().getKey(), paramColorPair.getKey()))
    {
      zY.a(paramColorPair);
      b(ModelEventDispatcher.EventType.xe);
      gP().a(this);
    }
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.xB }))
    {
      Ab = true;
      a(d(iA()));
      Ab = false;
    }
  }

  public void a(TreeEntitySettings paramTreeEntitySettings)
  {
    if (paramTreeEntitySettings == null);
    TreeEntitySettings localTreeEntitySettings;
    label54: 
    do
    {
      return;
      localTreeEntitySettings = paramTreeEntitySettings;
      if (lm.isActive())
        if ((!Aa) && (!Ab))
          break label54;
      for (localTreeEntitySettings = d(paramTreeEntitySettings); !isInitialized(); localTreeEntitySettings = paramTreeEntitySettings)
      {
        localTreeEntitySettings.b(zZ);
        return;
        lm.c(paramTreeEntitySettings);
      }
    }
    while (u.equals(zY.iA(), localTreeEntitySettings));
    zY.a(localTreeEntitySettings);
    gP().a(this);
    b(ModelEventDispatcher.EventType.xi);
  }

  public void af(boolean paramBoolean)
  {
    if (zY.jv() != paramBoolean)
    {
      zY.M(paramBoolean);
      gP().a(this);
      b(ModelEventDispatcher.EventType.xk);
    }
  }

  public void b(TreeEntityTask paramTreeEntityTask)
  {
    zY = new EditableTreeEntity(TreeEntityImpl.c(paramTreeEntityTask));
    b(ModelEventDispatcher.EventType.wF);
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return wj;
  }

  public void g(TreeEntity.TreeEntityType paramTreeEntityType)
  {
    if (zY.ir() != paramTreeEntityType)
    {
      zY.a(paramTreeEntityType);
      b(ModelEventDispatcher.EventType.xh);
      gP().a(this);
    }
  }

  void gB()
  {
    gP().a(this);
  }

  public long gJ()
  {
    return zY.gJ();
  }

  public long getChangesSeenTimestamp()
  {
    return zY.getChangesSeenTimestamp();
  }

  public long getId()
  {
    return zY.getId();
  }

  public String getServerId()
  {
    return zY.getServerId();
  }

  public String getTitle()
  {
    return zY.getTitle();
  }

  public long gp()
  {
    return zY.gp();
  }

  public String gu()
  {
    return zY.gu();
  }

  public Loader<Cursor> gy()
  {
    return new CursorLoader(getActivity(), ContentUris.withAppendedId(i.v.CONTENT_URI, dP()), TreeEntityImpl.COLUMNS, null, null, null);
  }

  public void gz()
  {
    ib();
    if (zY != null)
      zY.gR();
  }

  public TreeEntitySettings iA()
  {
    return zY.iA();
  }

  public boolean iD()
  {
    return zY.iD();
  }

  public boolean iE()
  {
    return zY.iE();
  }

  public boolean iP()
  {
    return zY.ir() == TreeEntity.TreeEntityType.zP;
  }

  public TreeEntity.TreeEntityType ir()
  {
    return zY.ir();
  }

  public boolean isEmpty()
  {
    if (!isInitialized());
    while ((!TextUtils.isEmpty(getTitle())) || (!iz().equals(ColorMap.gO())))
      return false;
    return true;
  }

  public Long ix()
  {
    return zY.ix();
  }

  public ColorMap.ColorPair iz()
  {
    return zY.iz();
  }

  public void j(Cursor paramCursor)
  {
    if (!paramCursor.moveToFirst())
    {
      if (isInitialized())
        b(ModelEventDispatcher.EventType.xb);
      gz();
      return;
    }
    paramCursor = new EditableTreeEntity(EditableTreeEntity.x(paramCursor));
    if (!isInitialized())
    {
      zY = paramCursor;
      b(ModelEventDispatcher.EventType.wF);
      return;
    }
    a(paramCursor);
    if (gw())
    {
      ((a)Binder.a(getActivity(), a.class)).a(this);
      return;
    }
    Aa = true;
    setTitle(paramCursor.getTitle());
    H(paramCursor.ix().longValue());
    K(paramCursor.jr());
    L(paramCursor.js());
    a(paramCursor.iz());
    a(paramCursor.iA());
    af(paramCursor.jv());
    N(paramCursor.iE());
    r(paramCursor.getChangesSeenTimestamp());
    zY.gR();
    Aa = false;
  }

  public void j(List<DbOperation> paramList)
  {
    if (dP() == -1L);
    ContentValues localContentValues;
    do
    {
      return;
      localContentValues = new ContentValues();
      if ((zY != null) && (zY.gw()))
      {
        localContentValues.putAll(zY.gQ());
        zY.gR();
      }
      localContentValues.putAll(zZ);
      zZ.clear();
    }
    while (localContentValues.size() <= 0);
    if (localContentValues.containsKey("title"))
      hb.aa(true);
    paramList.add(DbOperation.cZ().a(i.v.CONTENT_URI, dP()).a(localContentValues));
  }

  public boolean jr()
  {
    return zY.jr();
  }

  public boolean js()
  {
    return zY.js();
  }

  public long jt()
  {
    return zY.jt();
  }

  public boolean jw()
  {
    return zY.ir() == TreeEntity.TreeEntityType.zO;
  }

  public boolean jx()
  {
    return de;
  }

  public TreeEntity jy()
  {
    if (zY == null)
      return null;
    return new TreeEntity()
    {
      private ColorMap.ColorPair Ac = TreeEntityModel.b(TreeEntityModel.this).iz();
      private TreeEntitySettings Ad = TreeEntityModel.b(TreeEntityModel.this).iA();
      private Long Ae = TreeEntityModel.b(TreeEntityModel.this).ix();
      private long Af = TreeEntityModel.b(TreeEntityModel.this).getChangesSeenTimestamp();
      private long cU = TreeEntityModel.b(TreeEntityModel.this).gp();
      private String iF = TreeEntityModel.b(TreeEntityModel.this).getServerId();
      private String ja = TreeEntityModel.b(TreeEntityModel.this).getTitle();
      private long mId = TreeEntityModel.b(TreeEntityModel.this).getId();
      private String uK = TreeEntityModel.b(TreeEntityModel.this).gu();
      private long uL = TreeEntityModel.b(TreeEntityModel.this).gJ();
      private TreeEntity.TreeEntityType yn = TreeEntityModel.b(TreeEntityModel.this).ir();
      private long yt = TreeEntityModel.b(TreeEntityModel.this).jt();
      private boolean yv = TreeEntityModel.b(TreeEntityModel.this).iD();
      private boolean yx = TreeEntityModel.b(TreeEntityModel.this).iE();
      private boolean zT = TreeEntityModel.b(TreeEntityModel.this).jr();
      private boolean zU = TreeEntityModel.b(TreeEntityModel.this).js();

      public long gJ()
      {
        return uL;
      }

      public long getId()
      {
        return mId;
      }

      public String getServerId()
      {
        return iF;
      }

      public String getTitle()
      {
        return ja;
      }

      public long gp()
      {
        return cU;
      }

      public String gu()
      {
        return uK;
      }

      public TreeEntitySettings iA()
      {
        return Ad;
      }

      public TreeEntity.TreeEntityType ir()
      {
        return yn;
      }

      public ColorMap.ColorPair iz()
      {
        return Ac;
      }

      public boolean jr()
      {
        return zT;
      }

      public boolean js()
      {
        return zU;
      }

      public long jt()
      {
        return yt;
      }
    };
  }

  public void r(long paramLong)
  {
    if (zY.getChangesSeenTimestamp() != paramLong)
    {
      zY.r(paramLong);
      gP().a(this);
      b(ModelEventDispatcher.EventType.xm);
    }
  }

  public void setTitle(String paramString)
  {
    if (!TextUtils.equals(zY.getTitle(), paramString))
    {
      zY.setTitle(paramString);
      b(ModelEventDispatcher.EventType.xc);
      gP().a(this);
    }
  }
}