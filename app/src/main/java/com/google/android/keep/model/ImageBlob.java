package com.google.android.keep.model;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.provider.KeepProvider;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.j;
import com.google.android.keep.util.E;
import com.google.android.keep.util.u;

public final class ImageBlob extends Blob
{
  public static final Parcelable.Creator<ImageBlob> CREATOR = new Parcelable.Creator()
  {
    public ImageBlob[] aW(int paramAnonymousInt)
    {
      return new ImageBlob[paramAnonymousInt];
    }

    public ImageBlob f(Parcel paramAnonymousParcel)
    {
      return new ImageBlob(paramAnonymousParcel, null);
    }
  };
  private static String vs = "tree_entity_id=? AND type=0";
  private ContentValues un = new ContentValues();
  private final Integer vo;
  private final Integer vp;
  private String vq;
  private int vr;

  private ImageBlob(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, Integer paramInteger1, Integer paramInteger2, String paramString4, int paramInt, long paramLong3)
  {
    super(paramLong1, paramString1, paramString2, 0, paramString3, paramLong2, paramLong3);
    vq = paramString4;
    vr = paramInt;
    vo = a(paramInteger1);
    vp = a(paramInteger2);
  }

  public ImageBlob(Cursor paramCursor)
  {
    super(paramCursor);
    vq = paramCursor.getString(uU);
    vr = paramCursor.getInt(uV);
    vo = valueOf(paramCursor.getString(uS));
    vp = valueOf(paramCursor.getString(uT));
  }

  private ImageBlob(Parcel paramParcel)
  {
    super(paramParcel);
    vq = paramParcel.readString();
    vr = paramParcel.readInt();
    vo = aV(paramParcel.readInt());
    vp = aV(paramParcel.readInt());
  }

  public ImageBlob(String paramString, Integer paramInteger1, Integer paramInteger2)
  {
    this(-1L, KeepProvider.kw(), null, paramString, System.currentTimeMillis(), paramInteger1, paramInteger2, null, 1, 0L);
  }

  public static int N(String paramString)
  {
    if (paramString == null);
    do
    {
      return 0;
      if (paramString.equals("PROCESSING_REQUESTED"))
        return 1;
      if (paramString.equals("SENT_TO_VSS"))
        return 2;
      if (paramString.equals("VSS_FAILED"))
        return 3;
    }
    while (!paramString.equals("VSS_SUCCEEDED"));
    return 4;
  }

  private void P(boolean paramBoolean)
  {
    c(new b(this, paramBoolean));
  }

  public static Loader<Cursor> a(Activity paramActivity, long paramLong)
  {
    return new CursorLoader(paramActivity, i.e.CONTENT_URI, COLUMNS, vs, new String[] { String.valueOf(paramLong) }, "time_created DESC ");
  }

  private static Integer a(Integer paramInteger)
  {
    if ((paramInteger != null) && (paramInteger.intValue() >= 0))
      return paramInteger;
    return null;
  }

  private void a(int paramInt, a parama)
  {
    vr = paramInt;
    un.put("extraction_status", Integer.valueOf(vr));
    c(parama);
    P(true);
  }

  public static String aU(int paramInt)
  {
    if (paramInt == 1)
      return "PROCESSING_REQUESTED";
    if (paramInt == 2)
      return "SENT_TO_VSS";
    if (paramInt == 3)
      return "VSS_FAILED";
    if (paramInt == 4)
      return "VSS_SUCCEEDED";
    return "DO_NOT_PROCESS";
  }

  private static Integer aV(int paramInt)
  {
    if (paramInt == -1)
      return null;
    return Integer.valueOf(paramInt);
  }

  private void b(int paramInt, String paramString)
  {
    if ((vr == paramInt) && (TextUtils.equals(vq, paramString)))
      return;
    a locala = new a(this, vr, vq);
    vr = paramInt;
    vq = paramString;
    c(locala);
  }

  public static boolean c(String paramString, int paramInt)
  {
    return (paramString != null) || (paramInt != 0);
  }

  public static Uri s(long paramLong)
  {
    if (paramLong == -1L)
      return null;
    return ContentUris.withAppendedId(i.j.Cq, paramLong);
  }

  private static Integer valueOf(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return a(Integer.valueOf(paramString));
  }

  public boolean O(boolean paramBoolean)
  {
    a locala = new a(this, vr, vq);
    if ((paramBoolean) && (vr == 1))
    {
      a(2, locala);
      return true;
    }
    if ((!paramBoolean) && (vr == 2))
    {
      a(1, locala);
      return true;
    }
    return false;
  }

  public ContentValues b(Long paramLong)
  {
    boolean bool = false;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tree_entity_id", paramLong);
    localContentValues.put("type", Integer.valueOf(0));
    localContentValues.put("file_name", getFileName());
    localContentValues.put("data1", vo);
    localContentValues.put("data2", vp);
    localContentValues.put("extracted_text", vq);
    localContentValues.put("extraction_status", Integer.valueOf(vr));
    localContentValues.put("time_created", Long.valueOf(uM));
    if (gu() != null)
      bool = true;
    Preconditions.checkArgument(bool);
    localContentValues.put("uuid", gu());
    return localContentValues;
  }

  public DbOperation d(Long paramLong)
  {
    boolean bool;
    Object localObject;
    if (paramLong.longValue() != -1L)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      localObject = null;
      if (!gv())
        break label58;
      paramLong = DbOperation.cY().b(i.e.CONTENT_URI).a(b(paramLong));
    }
    while (true)
    {
      un.clear();
      return paramLong;
      bool = false;
      break;
      label58: paramLong = localObject;
      if (gw())
        paramLong = DbOperation.cZ().b(i.e.CONTENT_URI).a("_id = " + getId(), null).a(un);
    }
  }

  public void d(Object paramObject)
  {
    if (equals(paramObject))
      return;
    if (gw())
    {
      P(true);
      return;
    }
    paramObject = (ImageBlob)paramObject;
    o(paramObject.getId());
    p(paramObject.gJ());
    q(paramObject.gM());
    b(paramObject.gV(), paramObject.getExtractedText());
    if (!TextUtils.equals(paramObject.getFileName(), uN))
    {
      uN = paramObject.getFileName();
      b(ModelEventDispatcher.EventType.wM);
    }
    mMediaId = paramObject.mMediaId;
    Preconditions.checkArgument(equals(paramObject));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageBlob));
    do
    {
      return false;
      paramObject = (ImageBlob)paramObject;
    }
    while ((!super.equals(paramObject)) || (!TextUtils.equals(vq, paramObject.vq)) || (vr != paramObject.vr) || (!u.equals(vo, paramObject.vo)) || (!u.equals(vp, paramObject.vp)));
    return true;
  }

  public int gV()
  {
    return vr;
  }

  public boolean gW()
  {
    return (gV() == 2) || (gV() == 1);
  }

  public boolean gX()
  {
    return c(getExtractedText(), gV());
  }

  public boolean gY()
  {
    return gV() == 2;
  }

  public Uri getContentUri()
  {
    return s(getId());
  }

  public String getExtractedText()
  {
    return vq;
  }

  public Integer getWidth()
  {
    return vo;
  }

  public boolean gv()
  {
    return getId() == -1L;
  }

  public boolean gw()
  {
    return un.size() > 0;
  }

  public String toString()
  {
    return gL().a("width", vo).a("height", vp).a("extractStatus", Integer.valueOf(vr)).a("extractText", vq).build();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(vq);
    paramParcel.writeInt(vr);
    if (vo == null)
    {
      paramInt = -1;
      paramParcel.writeInt(paramInt);
      if (vp != null)
        break label64;
    }
    label64: for (paramInt = i; ; paramInt = vp.intValue())
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = vo.intValue();
      break;
    }
  }

  public static class a extends ModelEventDispatcher.a
  {
    private final int vt;
    private final String vu;

    public a(ImageBlob paramImageBlob, int paramInt, String paramString)
    {
      super(ModelEventDispatcher.EventType.xs);
      vt = paramInt;
      vu = paramString;
    }

    public int gZ()
    {
      return vt;
    }
  }

  public static class b extends ModelEventDispatcher.a
  {
    private final boolean vv;

    b(ImageBlob paramImageBlob, boolean paramBoolean)
    {
      super(ModelEventDispatcher.EventType.xv);
      vv = paramBoolean;
    }

    public boolean ha()
    {
      return vv;
    }
  }
}