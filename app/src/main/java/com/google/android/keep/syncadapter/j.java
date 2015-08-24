package com.google.android.keep.syncadapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.model.TreeEntitySettings;
import com.google.android.keep.provider.i.k;
import com.google.api.client.util.DateTime;
import com.google.api.services.notes.model.Blob;
import com.google.api.services.notes.model.Node;
import com.google.api.services.notes.model.Node.LabelIds;
import com.google.api.services.notes.model.Node.MergeConflict;
import com.google.api.services.notes.model.Node.ShareRequests;
import com.google.api.services.notes.model.Node.Timestamps;
import com.google.api.services.notes.model.UserInfo;
import com.google.api.services.notes.model.UserInfo.Labels;
import com.google.api.services.notes.model.UserInfo.Labels.Timestamps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class j
{
  private final int FA;
  private final Map<String, Integer> FD;
  private UserInfo GA = null;
  private final SQLiteDatabase Gy;
  private final List<Node> Gz;
  private final long cU;
  private final Context mContext;

  j(Context paramContext, SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    mContext = paramContext;
    Gy = paramSQLiteDatabase;
    FA = paramInt;
    cU = paramLong;
    Gz = new ArrayList();
    FD = new HashMap();
    Gy.beginTransactionNonExclusive();
    try
    {
      ar(true);
      as(true);
      aq(true);
      at(true);
      aq(false);
      ar(false);
      as(false);
      at(false);
      Gy.setTransactionSuccessful();
      return;
    }
    finally
    {
      Gy.endTransaction();
    }
    throw paramContext;
  }

  private void a(Node paramNode, long paramLong)
  {
    Cursor localCursor = new d(Gy, paramLong, cU, FA).li();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localCursor.moveToPosition(-1);
      while (localCursor.moveToNext())
      {
        Node.LabelIds localLabelIds = new Node.LabelIds();
        localLabelIds.setLabelId(localCursor.getString(d.yJ));
        if (localCursor.getInt(d.Gq) == 1)
          localLabelIds.setDeleted(ac(localCursor.getLong(d.Gp)));
        localArrayList.add(localLabelIds);
      }
    }
    finally
    {
      localCursor.close();
    }
    if (localArrayList.size() > 0)
    {
      if (paramNode.getLabelIds() == null)
        break label172;
      paramNode.getLabelIds().addAll(localArrayList);
    }
    while (true)
    {
      localCursor.close();
      return;
      label172: paramNode.setLabelIds(localArrayList);
    }
  }

  private DateTime ac(long paramLong)
  {
    return new DateTime(paramLong, 0);
  }

  private void aq(boolean paramBoolean)
  {
    if (Gz.size() >= FA)
      return;
    Cursor localCursor = new h(Gy, cU, paramBoolean, FA).li();
    while (true)
    {
      Node localNode;
      String str3;
      Object localObject2;
      try
      {
        localCursor.moveToPosition(-1);
        if (!localCursor.moveToNext())
          break label826;
        localNode = new Node();
        localNode.setId(localCursor.getString(h.tv));
        a(localNode, localCursor.getLong(h.yB));
        str3 = localCursor.getString(h.Fu);
        if (str3 == null)
        {
          String str1 = "root";
          localNode.setParentId(str1);
          localNode.setSortValue(Long.valueOf(localCursor.getLong(h.xT)));
          str1 = localCursor.getString(h.tw);
          if (str1 != null)
            localNode.setServerId(str1);
          localObject2 = localCursor.getString(h.Fv);
          if (localObject2 != null)
            localNode.setParentServerId((String)localObject2);
          localObject2 = new Node.Timestamps();
          ((Node.Timestamps)localObject2).setCreated(ac(localCursor.getLong(h.uR)));
          DateTime localDateTime = ac(localCursor.getLong(h.Fo));
          ((Node.Timestamps)localObject2).setUpdated(localDateTime);
          if (localCursor.getInt(h.Fp) == 1)
            ((Node.Timestamps)localObject2).setDeleted(localDateTime);
          if (localCursor.getInt(h.xV) != 1)
            break label687;
          ((Node.Timestamps)localObject2).setTrashed(localDateTime);
          ((Node.Timestamps)localObject2).setUserEdited(ac(localCursor.getLong(h.yi)));
          ((Node.Timestamps)localObject2).setRecentSharedChangesSeen(ac(localCursor.getLong(h.yg)));
          localNode.setTimestamps((Node.Timestamps)localObject2);
          if (localCursor.getInt(h.xU) != 1)
            break label837;
          paramBoolean = true;
          localNode.setIsArchived(Boolean.valueOf(paramBoolean));
          localNode.setTitle(localCursor.getString(h.ty));
          localObject2 = localCursor.getString(h.tz);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
            break label701;
          localNode.setColor("DEFAULT");
          if ((str1 != null) && (localCursor.getInt(h.zX) == 1))
          {
            if (localCursor.getInt(h.yb) != 1)
              break label842;
            str1 = "ACCEPTED";
            localNode.setShareState(str1);
            b(localNode, localCursor.getLong(h.yB));
            localNode.setLastModifierEmail(localCursor.getString(h.yf));
          }
          if (localCursor.getInt(h.tB) != 1)
            break label850;
          paramBoolean = true;
          if (localCursor.getInt(h.xR) != 1)
            break label855;
          bool1 = true;
          if (localCursor.getInt(h.xS) != 1)
            break label860;
          bool2 = true;
          localNode.setNodeSettings(new TreeEntitySettings(paramBoolean, bool1, bool2).jA());
          str1 = localCursor.getString(h.vR);
          if (str1 != null)
            localNode.setBaseVersion(str1);
          localNode.setRealtimeDataServerVersion(localCursor.getString(h.Go));
          int i = localCursor.getInt(h.tx);
          switch (i)
          {
          case 0:
            throw new IllegalStateException("Unknown type " + i);
          case 1:
          }
        }
      }
      finally
      {
        localCursor.close();
      }
      String str2 = str3;
      continue;
      label687: ((Node.Timestamps)localObject2).setTrashed(ac(0L));
      continue;
      label701: localNode.setColor((String)localObject2);
      continue;
      if (str3 == null)
        localNode.setType(DownSyncResponseProcessor.SyncType.FV.getTypeName());
      while (true)
      {
        if (!f(localNode))
          break label826;
        FD.put(localCursor.getString(h.tv), Integer.valueOf(localCursor.getInt(h.Fq)));
        break;
        throw new IllegalStateException("Note with non-root parent not supported " + localCursor.getString(h.tv));
        localNode.setType(DownSyncResponseProcessor.SyncType.FX.getTypeName());
      }
      label826: localCursor.close();
      return;
      continue;
      label837: paramBoolean = false;
      continue;
      label842: str2 = "NEW";
      continue;
      label850: paramBoolean = false;
      continue;
      label855: boolean bool1 = false;
      continue;
      label860: boolean bool2 = false;
    }
  }

  private void ar(boolean paramBoolean)
  {
    if (Gz.size() >= FA)
      return;
    Cursor localCursor = new a(Gy, cU, paramBoolean, FA).li();
    Object localObject1;
    try
    {
      localCursor.moveToPosition(-1);
      if (!localCursor.moveToNext())
        break label654;
      Node localNode1 = new Node();
      localNode1.setId(localCursor.getString(a.tv));
      localNode1.setParentId(localCursor.getString(a.Fu));
      localNode1.setType(DownSyncResponseProcessor.SyncType.FY.getTypeName());
      localObject1 = localCursor.getString(a.tw);
      if (localObject1 != null)
        localNode1.setServerId((String)localObject1);
      localObject1 = localCursor.getString(a.Fv);
      if (localObject1 != null)
        localNode1.setParentServerId((String)localObject1);
      localObject1 = localCursor.getString(a.vR);
      if (localObject1 != null)
        localNode1.setBaseVersion((String)localObject1);
      localObject1 = new Blob();
      i = localCursor.getInt(a.tx);
      localObject2 = localCursor.getString(a.Fr);
      switch (i)
      {
      case 0:
        label236: throw new IllegalStateException("Unknown type " + i);
      case 1:
      }
    }
    finally
    {
      localCursor.close();
    }
    ((Blob)localObject1).setMimetype((String)localObject2);
    ((Blob)localObject1).setType("IMAGE");
    Object localObject2 = localCursor.getString(a.uS);
    String str = localCursor.getString(a.uT);
    if (localObject2 != null)
      ((Blob)localObject1).setWidth(Integer.valueOf((String)localObject2));
    if (str != null)
      ((Blob)localObject1).setHeight(Integer.valueOf(str));
    localObject2 = localCursor.getString(a.uU);
    if (localObject2 != null)
      ((Blob)localObject1).setExtractedText((String)localObject2);
    ((Blob)localObject1).setExtractionStatus(ImageBlob.aU(localCursor.getInt(a.uV)));
    label388: ((Blob)localObject1).setByteSize(Integer.valueOf(localCursor.getInt(a.Ft)));
    localObject2 = localCursor.getString(a.Fs);
    if (!TextUtils.isEmpty((CharSequence)localObject2));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        ((Blob)localObject1).setMediaId((String)localObject2);
        localNode2.setBlob((Blob)localObject1);
      }
      localObject1 = new Node.Timestamps();
      ((Node.Timestamps)localObject1).setCreated(ac(localCursor.getLong(a.uR)));
      localObject2 = ac(localCursor.getLong(a.Fo));
      ((Node.Timestamps)localObject1).setUpdated((DateTime)localObject2);
      if (localCursor.getInt(a.Fw) == 1)
        ((Node.Timestamps)localObject1).setTrashed((DateTime)localObject2);
      while (true)
      {
        localNode2.setTimestamps((Node.Timestamps)localObject1);
        if (localCursor.getInt(a.Fp) == 1)
          ((Node.Timestamps)localObject1).setDeleted(ac(localCursor.getLong(a.Fo)));
        if (!f(localNode2))
          break label654;
        FD.put(localCursor.getString(a.tv), Integer.valueOf(localCursor.getInt(a.Fq)));
        break;
        ((Blob)localObject1).setMimetype((String)localObject2);
        ((Blob)localObject1).setType("AUDIO");
        ((Blob)localObject1).setLength(Integer.valueOf(localCursor.getInt(a.uS)));
        break label388;
        ((Node.Timestamps)localObject1).setTrashed(ac(0L));
      }
      label654: localCursor.close();
      return;
      break label236;
    }
  }

  private void as(boolean paramBoolean)
  {
    if (Gz.size() >= FA)
      return;
    Cursor localCursor = new c(Gy, cU, paramBoolean, FA).li();
    while (true)
    {
      Object localObject2;
      try
      {
        localCursor.moveToPosition(-1);
        if (!localCursor.moveToNext())
          break;
        Node localNode = new Node();
        localNode.setId(localCursor.getString(c.tv));
        localNode.setParentId(localCursor.getString(c.Fu));
        localNode.setSortValue(Long.valueOf(localCursor.getLong(c.xT)));
        localObject2 = localCursor.getString(c.tw);
        if (localObject2 != null)
          localNode.setServerId((String)localObject2);
        localObject2 = localCursor.getString(c.Fv);
        if (localObject2 != null)
          localNode.setParentServerId((String)localObject2);
        localObject2 = localCursor.getString(c.vR);
        if (localObject2 != null)
          localNode.setBaseVersion((String)localObject2);
        localNode.setRealtimeDataServerVersion(localCursor.getString(c.Go));
        localObject2 = new Node.Timestamps();
        ((Node.Timestamps)localObject2).setCreated(ac(localCursor.getLong(c.uR)));
        Object localObject3 = ac(localCursor.getLong(c.Fo));
        ((Node.Timestamps)localObject2).setUpdated((DateTime)localObject3);
        if (localCursor.getInt(c.Fw) == 1)
        {
          ((Node.Timestamps)localObject2).setTrashed((DateTime)localObject3);
          if (localCursor.getInt(c.Fp) == 1)
            ((Node.Timestamps)localObject2).setDeleted(ac(localCursor.getLong(c.Fo)));
          localNode.setTimestamps((Node.Timestamps)localObject2);
          localNode.setType(DownSyncResponseProcessor.SyncType.FZ.getTypeName());
          localNode.setText(localCursor.getString(c.TEXT));
          if (localCursor.getInt(c.vP) != 1)
            break label459;
          paramBoolean = true;
          localNode.setChecked(Boolean.valueOf(paramBoolean));
          localObject2 = localCursor.getString(c.vW);
          if (localObject2 != null)
          {
            localObject3 = new Node.MergeConflict();
            ((Node.MergeConflict)localObject3).setToken((String)localObject2);
            localNode.setMergeConflict((Node.MergeConflict)localObject3);
          }
          if (!f(localNode))
            break;
          FD.put(localCursor.getString(c.tv), Integer.valueOf(localCursor.getInt(c.Fq)));
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      ((Node.Timestamps)localObject2).setTrashed(ac(0L));
      continue;
      label459: paramBoolean = false;
    }
    localCursor.close();
  }

  private void at(boolean paramBoolean)
  {
    Cursor localCursor = new b(Gy, cU, paramBoolean).li();
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    try
    {
      localCursor.moveToPosition(-1);
      while (localCursor.moveToNext())
      {
        localObject = new UserInfo.Labels();
        UserInfo.Labels.Timestamps localTimestamps = new UserInfo.Labels.Timestamps();
        if (paramBoolean)
          localTimestamps.setDeleted(ac(localCursor.getLong(b.Gl)));
        localTimestamps.setCreated(ac(localCursor.getLong(b.uR)));
        localTimestamps.setUpdated(ac(localCursor.getLong(b.vA)));
        localTimestamps.setUserEdited(ac(localCursor.getLong(b.yi)));
        ((UserInfo.Labels)localObject).setTimestamps(localTimestamps);
        ((UserInfo.Labels)localObject).setLastMerged(ac(localCursor.getLong(b.Gn)));
        ((UserInfo.Labels)localObject).setName(localCursor.getString(b.vz));
        ((UserInfo.Labels)localObject).setMergedIds(i.k.aI(localCursor.getString(b.Gm)));
        ((UserInfo.Labels)localObject).setMainId(localCursor.getString(b.tv));
        ((UserInfo.Labels)localObject).setRevision(Long.valueOf(localCursor.getLong(b.Gk)));
        FD.put(localCursor.getString(b.tv), Integer.valueOf(localCursor.getInt(b.Fq)));
        localArrayList.add(localObject);
      }
    }
    finally
    {
      localCursor.close();
    }
    if (localList.size() > 0)
    {
      if (GA != null)
        break label333;
      localObject = new UserInfo();
      ((UserInfo)localObject).setLabels(localList);
      GA = ((UserInfo)localObject);
    }
    while (true)
    {
      localCursor.close();
      return;
      label333: GA.getLabels().addAll(localList);
    }
  }

  private boolean f(Node paramNode)
  {
    if (Gz.size() >= FA)
      return false;
    Gz.add(paramNode);
    return true;
  }

  protected void b(Node paramNode, long paramLong)
  {
    Cursor localCursor = new e(Gy, paramLong, cU).li();
    if (localCursor == null)
      return;
    ArrayList localArrayList;
    while (true)
    {
      Node.ShareRequests localShareRequests;
      try
      {
        int i = localCursor.getCount();
        if (i == 0)
          return;
        localArrayList = new ArrayList(localCursor.getCount());
        localCursor.moveToPosition(-1);
        if (!localCursor.moveToNext())
          break;
        localShareRequests = new Node.ShareRequests();
        localShareRequests.setEmail(localCursor.getString(e.EMAIL));
        if (localCursor.getInt(e.Fp) == 0)
        {
          localShareRequests.setType("WR");
          localArrayList.add(localShareRequests);
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      localShareRequests.setType("RM");
    }
    paramNode.setShareRequests(localArrayList);
    localCursor.close();
  }

  List<Node> getNodes()
  {
    return Gz;
  }

  UserInfo getUserInfo()
  {
    return GA;
  }

  public Map<String, Integer> ls()
  {
    return FD;
  }
}