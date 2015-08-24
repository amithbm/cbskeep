package com.google.android.keep.task;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.common.base.Preconditions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.reminders.Reminders;
import com.google.android.gms.reminders.RemindersApi;
import com.google.android.gms.reminders.RemindersStatusCodes;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.Blob;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.TreeEntitySettings;
import com.google.android.keep.model.m;
import com.google.android.keep.model.n;
import com.google.android.keep.model.z;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.provider.KeepProvider;
import com.google.android.keep.provider.MediaStore.FileValidationException;
import com.google.android.keep.provider.MediaStore.UnsupportedMimeTypeException;
import com.google.android.keep.provider.b;
import com.google.android.keep.provider.g;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.f;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.provider.i.p;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.util.A;
import com.google.android.keep.util.h;
import com.google.android.keep.util.h.a;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.util.w;
import com.google.android.keep.util.x;
import com.google.api.client.util.Lists;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class TreeEntityTask extends AsyncTask<Void, Void, Long>
{
  private Uri AH;
  private final BaseReminder AI;
  private final TaskHelper.a<Long> GC;
  private TaskHelper.ErrorCode GD = TaskHelper.ErrorCode.GH;
  private final long GT;
  private final m[] GU;
  private final MediaInsertType GV;
  private ArrayList<Uri> GW;
  private Uri GX;
  private final int GY;
  private final long cU;
  private final String ja;
  private Bitmap mBitmap;
  private final Context mContext;
  private final int mType;
  private final String rt;
  private final String uK;
  private long uy;
  private final ColorMap.ColorPair yo;
  private final TreeEntitySettings yp;

  private TreeEntityTask(a parama)
  {
    mContext = ((Context)Preconditions.checkNotNull(a.b(parama)));
    cU = ((Long)Preconditions.checkNotNull(a.c(parama))).longValue();
    uy = a.d(parama);
    uK = a.e(parama);
    ja = a.f(parama);
    ColorMap.ColorPair localColorPair;
    int i;
    if (a.g(parama) == null)
    {
      localColorPair = ColorMap.gO();
      yo = localColorPair;
      AI = a.h(parama);
      rt = a.i(parama);
      yp = a.j(parama);
      GC = a.k(parama);
      GT = a.l(parama);
      if (a.m(parama) != null)
        break label193;
      i = 0;
      label131: mType = i;
      GU = a.n(parama);
      GV = a.o(parama);
      if (GV != MediaInsertType.Hb)
        break label204;
      GX = ((Uri)Preconditions.checkNotNull(a.p(parama)));
    }
    while (true)
    {
      GY = a.t(parama);
      return;
      localColorPair = a.g(parama);
      break;
      label193: i = a.m(parama).intValue();
      break label131;
      label204: if (GV == MediaInsertType.Hc)
        GW = ((ArrayList)Preconditions.checkNotNull(a.q(parama)));
      else if (GV == MediaInsertType.Hd)
        AH = ((Uri)Preconditions.checkNotNull(a.r(parama)));
      else if (GV == MediaInsertType.He)
        mBitmap = ((Bitmap)Preconditions.checkNotNull(a.s(parama)));
    }
  }

  private ContentProviderOperation a(Blob paramBlob)
  {
    paramBlob = ContentProviderOperation.newInsert(i.e.CONTENT_URI).withValues(paramBlob.b(null));
    if (uy == -1L)
      paramBlob.withValueBackReference("tree_entity_id", 0);
    while (true)
    {
      return paramBlob.build();
      paramBlob.withValue("tree_entity_id", Long.valueOf(uy));
    }
  }

  private ContentProviderOperation a(m paramm, boolean paramBoolean)
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(i.m.CONTENT_URI).withValue("text", paramm.getText());
    int i;
    String str;
    if (paramm.hz())
    {
      i = 1;
      localBuilder = localBuilder.withValue("is_checked", Integer.valueOf(i));
      str = paramm.gu();
      if ((!paramBoolean) && (!TextUtils.isEmpty(str)))
        break label122;
      localBuilder.withValue("uuid", KeepProvider.kw());
      label71: paramm = paramm.hu();
      if (paramm != null)
        localBuilder.withValue("order_in_parent", paramm);
      if (uy != -1L)
        break label136;
      localBuilder.withValueBackReference("list_parent_id", 0);
    }
    while (true)
    {
      return localBuilder.build();
      i = 0;
      break;
      label122: localBuilder.withValue("uuid", str);
      break label71;
      label136: localBuilder.withValue("list_parent_id", Long.valueOf(uy));
    }
  }

  public static a a(Activity paramActivity, com.google.android.keep.model.j paramj, EditorNavigationRequest paramEditorNavigationRequest, TaskHelper.a<Long> parama)
  {
    TreeEntitySettings localTreeEntitySettings;
    if (paramEditorNavigationRequest.iA() != null)
    {
      localTreeEntitySettings = paramEditorNavigationRequest.iA();
      paramj = new a(paramActivity).ae(-1L).bf(paramEditorNavigationRequest.jL()).o(Long.valueOf(paramj.getId())).i(paramEditorNavigationRequest.jM()).bg(paramEditorNavigationRequest.getTitle()).d(paramEditorNavigationRequest.iz()).d(paramEditorNavigationRequest.jN()).bh(paramEditorNavigationRequest.iN()).f(localTreeEntitySettings).a(parama);
      if (paramEditorNavigationRequest.getText() != null)
        break label189;
    }
    label189: for (paramActivity = ""; ; paramActivity = paramEditorNavigationRequest.getText())
    {
      paramj.a(new m(paramActivity, false, KeepProvider.kw()));
      if (paramEditorNavigationRequest.getBitmap() != null)
        paramj.e(paramEditorNavigationRequest.getBitmap());
      paramActivity = paramEditorNavigationRequest.jP();
      if ((paramActivity == null) || (paramActivity.size() <= 0))
        break label197;
      paramActivity = paramActivity.iterator();
      while (paramActivity.hasNext())
        paramj.t((Uri)paramActivity.next());
      localTreeEntitySettings = A.ae(paramActivity);
      break;
    }
    label197: if (paramEditorNavigationRequest.jR() != null)
      paramj.u(paramEditorNavigationRequest.jR());
    if (paramEditorNavigationRequest.jQ() != null)
      paramj.v(paramEditorNavigationRequest.jQ());
    return paramj;
  }

  public static TreeEntityTask a(Context paramContext, TreeEntityModel paramTreeEntityModel, n paramn)
  {
    paramContext = new a(paramContext).bL(3);
    paramContext.ae(paramTreeEntityModel.getId()).bf(paramTreeEntityModel.gu()).o(Long.valueOf(paramTreeEntityModel.gp())).bg(paramTreeEntityModel.getTitle());
    paramTreeEntityModel = new m[paramn.size()];
    int i = 0;
    while (i < paramn.size())
    {
      ListItem localListItem = (ListItem)paramn.aL(i);
      paramTreeEntityModel[i] = new m(localListItem.getText(), localListItem.isChecked(), localListItem.gu(), localListItem.hu());
      i += 1;
    }
    paramContext.b(paramTreeEntityModel);
    return paramContext.lG();
  }

  private void a(long paramLong, BaseReminder paramBaseReminder)
  {
    if (paramLong == -1L);
    Object localObject;
    Note localNote;
    do
    {
      do
      {
        do
        {
          return;
          localObject = o.j(mContext, cU);
        }
        while (TextUtils.isEmpty((CharSequence)localObject));
        localNote = (Note)h.a(mContext.getContentResolver(), i.f.Cm, Note.COLUMNS, "tree_entity._id=" + paramLong, null, new h.a()
        {
          public Note j(Cursor paramAnonymousCursor, int paramAnonymousInt)
          {
            return Note.p(paramAnonymousCursor);
          }
        });
      }
      while (localNote == null);
      localObject = com.google.android.keep.util.j.j(mContext, (String)localObject).build();
    }
    while (!((GoogleApiClient)localObject).blockingConnect(5L, TimeUnit.SECONDS).isSuccess());
    try
    {
      String str2 = x.a(mContext, localNote.getTitle(), localNote.ir(), localNote.im(), localNote.ij(), localNote.ii());
      String str1 = w.d(localNote);
      paramBaseReminder = z.a(mContext, w.bG(str1), paramBaseReminder, str2, localNote);
      paramBaseReminder = (Status)Reminders.RemindersApi.createReminder((GoogleApiClient)localObject, paramBaseReminder).await(5L, TimeUnit.SECONDS);
      if (!paramBaseReminder.isSuccess())
        r.e("Keep", "Failed to create reminder with externalId:" + str1 + "\n" + "Error code:" + paramBaseReminder.getStatusCode() + "\n" + "Error Message:" + RemindersStatusCodes.getStatusCodeString(paramBaseReminder.getStatusCode()), new Object[0]);
      return;
    }
    finally
    {
      ((GoogleApiClient)localObject).disconnect();
    }
    throw paramBaseReminder;
  }

  private ContentProviderOperation be(String paramString)
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(i.m.CONTENT_URI);
    localBuilder.withValue("text", paramString);
    if (uy == -1L)
      localBuilder.withValueBackReference("list_parent_id", 0);
    while (true)
    {
      r.a("Keep", "Create a TreeEntity", new Object[0]);
      return localBuilder.build();
      localBuilder.withValue("list_parent_id", Long.valueOf(uy));
    }
  }

  private void c(ArrayList<ContentProviderOperation> paramArrayList)
    throws RemoteException, OperationApplicationException
  {
    if (paramArrayList.isEmpty());
    do
    {
      return;
      paramArrayList = mContext.getContentResolver().applyBatch("com.google.android.keep", paramArrayList);
      if (uy == -1L)
        uy = ContentUris.parseId(paramArrayList[0].uri);
    }
    while (AI == null);
    a(uy, AI);
  }

  private void dK()
  {
    if (uy != -1L)
    {
      r.a("Keep", "Delete the note/list with mTreeEntityId: " + uy, new Object[0]);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_id", Long.valueOf(uy));
      mContext.getContentResolver().update(i.v.Ce, localContentValues, "_id=" + uy, null);
    }
  }

  private void lA()
  {
    if ((uy != -1L) || (uK == null));
    Object localObject1;
    do
    {
      return;
      localObject1 = mContext.getContentResolver();
      Uri localUri = i.v.BX;
      String str = uK;
      localObject1 = ((ContentResolver)localObject1).query(localUri, new String[] { "_id" }, "uuid=?", new String[] { str }, null);
    }
    while (localObject1 == null);
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        uy = ((Cursor)localObject1).getLong(0);
        r.a("Keep", "Got valid TreeEntityId " + uy, new Object[0]);
      }
      return;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }

  private ContentProviderOperation lB()
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(i.v.CONTENT_URI).withValue("account_id", Long.valueOf(cU)).withValue("uuid", uK).withValue("type", Integer.valueOf(mType)).withValue("parent_id", Long.valueOf(0L)).withValue("is_archived", Integer.valueOf(0)).withValue("color_name", yo.getKey()).withValue("user_edited_timestamp", Long.valueOf(GT));
    if (!TextUtils.isEmpty(ja))
      localBuilder.withValue("title", ja);
    if (yp != null)
      localBuilder.withValues(yp.jh());
    return localBuilder.build();
  }

  private ContentProviderOperation lC()
  {
    return ContentProviderOperation.newUpdate(i.v.CONTENT_URI).withSelection("_id=?", new String[] { Long.toString(uy) }).withValue("title", ja).build();
  }

  private ContentProviderOperation lD()
  {
    return ContentProviderOperation.newUpdate(i.m.Ce).withSelection("list_parent_id=?", new String[] { Long.toString(uy) }).withValue("list_parent_id", Long.valueOf(uy)).build();
  }

  private ContentProviderOperation lE()
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(i.p.CONTENT_URI).withValue("account_id", Long.valueOf(cU)).withValue("label_id", rt);
    if (uy == -1L)
      localBuilder.withValueBackReference("tree_entity_id", 0);
    while (true)
    {
      return localBuilder.build();
      localBuilder.withValue("tree_entity_id", Long.valueOf(uy));
    }
  }

  private ArrayList<ContentProviderOperation> lF()
    throws IOException, MediaStore.FileValidationException, MediaStore.UnsupportedMimeTypeException
  {
    ArrayList localArrayList = Lists.newArrayList();
    switch (2.Ha[GV.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return localArrayList;
      Object localObject1 = b.b(mContext, cU, GX);
      if (localObject1 != null)
      {
        localArrayList.add(a((Blob)localObject1));
        return localArrayList;
        localObject1 = g.a(mContext, cU, mBitmap);
        if (localObject1 != null)
        {
          localArrayList.add(a((Blob)localObject1));
          return localArrayList;
          localObject1 = g.d(mContext, cU, AH);
          if (localObject1 != null)
          {
            localArrayList.add(a((Blob)localObject1));
            return localArrayList;
            if (GW != null)
            {
              localObject1 = GW.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (Uri)((Iterator)localObject1).next();
                localObject2 = g.c(mContext, cU, (Uri)localObject2);
                if (localObject2 != null)
                  localArrayList.add(a((Blob)localObject2));
              }
            }
          }
        }
      }
    }
  }

  private void lx()
    throws MediaStore.UnsupportedMimeTypeException, MediaStore.FileValidationException, IOException, RemoteException, OperationApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (uy == -1L)
      localArrayList.add(lB());
    if (rt != null)
      localArrayList.add(lE());
    if (uy != -1L)
    {
      r.a("Keep", "Clearing all items before inserting new items", new Object[0]);
      localArrayList.add(lD());
    }
    if (GU != null)
    {
      m[] arrayOfm = GU;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(arrayOfm[i], false));
        i += 1;
      }
    }
    if ((mType == 0) && (GU == null))
    {
      r.a("Keep", "Adding an empty list item to note:" + uK, new Object[0]);
      localArrayList.add(be(""));
    }
    if (GV != null)
      localArrayList.addAll(lF());
    c(localArrayList);
    if (AI != null)
      a(uy, AI);
  }

  private void ly()
    throws RemoteException, OperationApplicationException
  {
    if (uy == -1L)
      return;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(lC());
    if (mType == 0)
      throw new IllegalStateException("Do not support append node for note.");
    if (GU != null)
    {
      m[] arrayOfm = GU;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(arrayOfm[i], true));
        i += 1;
      }
    }
    c(localArrayList);
  }

  private void lz()
    throws RemoteException, OperationApplicationException
  {
    if (uy == -1L)
      return;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(lC());
    localArrayList.add(lD());
    if (GU != null)
    {
      m[] arrayOfm = GU;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(arrayOfm[i], true));
        i += 1;
      }
    }
    if ((mType == 0) && (GU == null))
      localArrayList.add(be(""));
    c(localArrayList);
  }

  protected Long d(Void[] paramArrayOfVoid)
  {
    try
    {
      lA();
      if (GY == 0)
        lx();
      while (true)
      {
        return Long.valueOf(uy);
        if (GY != 1)
          break;
        dK();
      }
    }
    catch (RemoteException paramArrayOfVoid)
    {
      while (true)
      {
        GD = TaskHelper.ErrorCode.GK;
        return null;
        if (GY != 3)
          break;
        ly();
      }
    }
    catch (OperationApplicationException paramArrayOfVoid)
    {
      while (true)
      {
        GD = TaskHelper.ErrorCode.GJ;
        continue;
        if (GY == 2)
          lz();
      }
    }
    catch (FileNotFoundException paramArrayOfVoid)
    {
      while (true)
        GD = TaskHelper.ErrorCode.GP;
    }
    catch (IOException paramArrayOfVoid)
    {
      while (true)
        GD = TaskHelper.ErrorCode.GQ;
    }
    catch (MediaStore.FileValidationException paramArrayOfVoid)
    {
      while (true)
        GD = TaskHelper.ErrorCode.GM;
    }
    catch (MediaStore.UnsupportedMimeTypeException paramArrayOfVoid)
    {
      while (true)
        GD = TaskHelper.ErrorCode.GN;
    }
  }

  public long dP()
  {
    return uy;
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
    return yp;
  }

  public ColorMap.ColorPair iz()
  {
    return yo;
  }

  public TreeEntity.TreeEntityType jM()
  {
    return TreeEntity.TreeEntityType.bn(mType);
  }

  public long lv()
  {
    return GT;
  }

  public m[] lw()
  {
    return GU;
  }

  protected void m(Long paramLong)
  {
    if (GC == null)
      return;
    if (GD == TaskHelper.ErrorCode.GH)
    {
      GC.a(paramLong);
      return;
    }
    GC.a(GD);
  }

  protected void n(Long paramLong)
  {
    if (GC == null)
      return;
    GC.a(TaskHelper.ErrorCode.GL);
  }

  private static enum MediaInsertType
  {
  }

  public static class a
  {
    private Uri AH = null;
    private BaseReminder AI = null;
    private TaskHelper.a<Long> GC = null;
    private long GT;
    private m[] GU = null;
    private TreeEntityTask.MediaInsertType GV = null;
    private Uri GX = null;
    private int GY = 0;
    private Integer Hg;
    private ArrayList<Uri> Hh = Lists.newArrayList();
    private String ja = null;
    private Bitmap mBitmap = null;
    private final Context mContext;
    private String rt = null;
    private String uK = null;
    private long uy = -1L;
    private Long yk = null;
    private ColorMap.ColorPair yo = null;
    private TreeEntitySettings yp = null;

    public a(Context paramContext)
    {
      mContext = paramContext.getApplicationContext();
      GT = System.currentTimeMillis();
    }

    public a a(m paramm)
    {
      return b(new m[] { paramm });
    }

    public a a(TaskHelper.a<Long> parama)
    {
      GC = parama;
      return this;
    }

    public a ae(long paramLong)
    {
      uy = paramLong;
      return this;
    }

    public a b(m[] paramArrayOfm)
    {
      GU = paramArrayOfm;
      return this;
    }

    public a bL(int paramInt)
    {
      GY = paramInt;
      return this;
    }

    public a bf(String paramString)
    {
      uK = paramString;
      return this;
    }

    public a bg(String paramString)
    {
      ja = paramString;
      return this;
    }

    public a bh(String paramString)
    {
      rt = paramString;
      return this;
    }

    public a d(BaseReminder paramBaseReminder)
    {
      AI = paramBaseReminder;
      return this;
    }

    public a d(ColorMap.ColorPair paramColorPair)
    {
      yo = paramColorPair;
      return this;
    }

    public a e(Bitmap paramBitmap)
    {
      if (GV != null)
        throw new IllegalStateException("Adding multiple attachment is not supported");
      GV = TreeEntityTask.MediaInsertType.He;
      mBitmap = paramBitmap;
      return this;
    }

    public a f(TreeEntitySettings paramTreeEntitySettings)
    {
      yp = paramTreeEntitySettings;
      return this;
    }

    public a i(TreeEntity.TreeEntityType paramTreeEntityType)
    {
      Hg = Integer.valueOf(TreeEntity.TreeEntityType.e(paramTreeEntityType));
      return this;
    }

    public TreeEntityTask lG()
    {
      return new TreeEntityTask(this, null);
    }

    public a o(Long paramLong)
    {
      yk = paramLong;
      return this;
    }

    public a t(Uri paramUri)
    {
      if (paramUri == null)
        return this;
      if ((GV != null) && (GV != TreeEntityTask.MediaInsertType.Hc))
        throw new IllegalStateException("Adding multiple attachment types is not supported");
      GV = TreeEntityTask.MediaInsertType.Hc;
      Hh.add(paramUri);
      return this;
    }

    public a u(Uri paramUri)
    {
      if (GV != null)
        throw new IllegalStateException("Adding multiple attachment is not supported");
      GV = TreeEntityTask.MediaInsertType.Hd;
      AH = paramUri;
      return this;
    }

    public a v(Uri paramUri)
    {
      if (GV != null)
        throw new IllegalStateException("Adding multiple attachment is not supported");
      GV = TreeEntityTask.MediaInsertType.Hb;
      GX = paramUri;
      return this;
    }
  }
}