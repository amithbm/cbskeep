package com.google.android.keep.model;

import android.content.ContentValues;
import android.text.TextUtils;

public class EditableTreeEntity extends TreeEntityImpl
{
  private ContentValues un = new ContentValues();

  EditableTreeEntity(q paramq)
  {
    super(paramq);
  }

  public void K(boolean paramBoolean)
  {
    zT = paramBoolean;
    ContentValues localContentValues = un;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localContentValues.put("is_archived", Integer.valueOf(i));
      return;
    }
  }

  public void L(boolean paramBoolean)
  {
    zU = paramBoolean;
    ContentValues localContentValues = un;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localContentValues.put("is_trashed", Integer.valueOf(i));
      return;
    }
  }

  void M(String paramString)
  {
    if (!TextUtils.isEmpty(iF))
      throw new IllegalStateException("Server id can only be set once");
    iF = paramString;
  }

  public void M(boolean paramBoolean)
  {
    yy = paramBoolean;
    ContentValues localContentValues = un;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localContentValues.put("is_brix_document_created", Integer.valueOf(i));
      return;
    }
  }

  public void N(boolean paramBoolean)
  {
    yx = paramBoolean;
    ContentValues localContentValues = un;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localContentValues.put("has_read", Integer.valueOf(i));
      return;
    }
  }

  public void a(ColorMap.ColorPair paramColorPair)
  {
    yo = paramColorPair;
    un.put("color_name", paramColorPair.getKey());
  }

  public void a(TreeEntity.TreeEntityType paramTreeEntityType)
  {
    zS = paramTreeEntityType;
    un.put("type", Integer.valueOf(TreeEntity.TreeEntityType.e(paramTreeEntityType)));
  }

  public void a(TreeEntitySettings paramTreeEntitySettings)
  {
    yp = paramTreeEntitySettings;
    yp.b(un);
  }

  public void c(Long paramLong)
  {
    yq = paramLong;
    un.put("user_edited_timestamp", paramLong);
  }

  public ContentValues gQ()
  {
    return un;
  }

  public void gR()
  {
    un.clear();
  }

  public boolean gw()
  {
    return un.size() > 0;
  }

  public void r(long paramLong)
  {
    ys = paramLong;
    un.put("last_changes_seen_timestamp", Long.valueOf(paramLong));
  }

  public void setTitle(String paramString)
  {
    ja = paramString;
    un.put("title", paramString);
  }
}