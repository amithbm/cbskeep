package com.google.android.keep.util;

import android.content.Context;
import com.google.android.apiary.GoogleRequestInitializer;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.j;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.notes.Notes;
import com.google.api.services.notes.Notes.Builder;
import com.google.api.services.notes.Notes.Changes;
import com.google.api.services.notes.Notes.Changes.Requestaccess;
import com.google.api.services.notes.Notes.Changes.Sync;
import com.google.api.services.notes.NotesRequestInitializer;
import com.google.api.services.notes.model.DownSync;
import com.google.api.services.notes.model.Node;
import com.google.api.services.notes.model.UpSync;
import com.google.api.services.notes.model.UpSync.RequestHeader;
import com.google.api.services.notes.model.UpSync.RequestHeader.Capabilities;
import com.google.api.services.notes.model.UpSync.RequestHeader.ClientVersion;
import com.google.api.services.notes.model.UpSync.SharedNoteInvite;
import com.google.api.services.notes.model.UserInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class p
{
  private final Notes PG;
  private final GoogleRequestInitializer PH;
  private final UpSync.RequestHeader.ClientVersion PI;
  private final List<UpSync.RequestHeader.Capabilities> PJ;
  private final String PK;
  private UpSync.SharedNoteInvite PL = null;

  public p(Context paramContext)
  {
    System.setProperty("http.keepAlive", "false");
    PI = T(paramContext);
    PJ = oi();
    PH = new a(paramContext, Config.nU(), "KeepSync", "com.google.android.keep");
    PH.setRequestConnectTimeout(180000);
    PH.setRequestReadTimeout(180000);
    PG = new Notes.Builder(new NetHttpTransport(), new AndroidJsonFactory(), PH).setApplicationName(Config.nV()).setNotesRequestInitializer(new NotesRequestInitializer()).build();
    PK = C.am(paramContext);
  }

  private UpSync.RequestHeader.ClientVersion T(Context paramContext)
  {
    paramContext = C.bM(KeepApplication.c(paramContext));
    if (paramContext == null)
      return null;
    UpSync.RequestHeader.ClientVersion localClientVersion = new UpSync.RequestHeader.ClientVersion();
    localClientVersion.setMajor(Integer.valueOf(paramContext[0]));
    localClientVersion.setMinor(Integer.valueOf(paramContext[1]));
    localClientVersion.setBuild(Integer.valueOf(paramContext[2]));
    localClientVersion.setRevision(Long.valueOf(paramContext[3]));
    return localClientVersion;
  }

  private List<UpSync.RequestHeader.Capabilities> oi()
  {
    String[] arrayOfString = KeepApplication.au();
    Object localObject;
    if (arrayOfString == null)
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    while (true)
    {
      localObject = localArrayList;
      if (i >= j)
        break;
      localObject = arrayOfString[i];
      UpSync.RequestHeader.Capabilities localCapabilities = new UpSync.RequestHeader.Capabilities();
      localCapabilities.setType((String)localObject);
      localArrayList.add(localCapabilities);
      i += 1;
    }
  }

  public DownSync a(String paramString, List<Node> paramList, UserInfo paramUserInfo)
    throws IOException
  {
    r.a("KeepSync", "entering KeepApiaryClient.syncChanges()", new Object[0]);
    UpSync localUpSync = new UpSync();
    localUpSync.setClientTimestamp(new DateTime(System.currentTimeMillis(), 0));
    if (paramString != null)
      localUpSync.setTargetVersion(paramString);
    if (paramList != null)
      localUpSync.setNodes(paramList);
    paramString = new UpSync.RequestHeader();
    if (PJ != null)
      paramString.setCapabilities(PJ);
    if (PI != null)
      paramString.setClientVersion(PI);
    paramString.setClientPlatform("ANDROID");
    paramString.setClientSessionId(PK);
    paramString.setClientLocale(Locale.getDefault().toString());
    localUpSync.setRequestHeader(paramString);
    if (PL != null)
    {
      localUpSync.setSharedNoteInvite(PL);
      PL = null;
    }
    if (paramUserInfo != null)
      localUpSync.setUserInfo(paramUserInfo);
    r.a("KeepSync", "Sending sync request: [lastSyncVersion=%s, # nodes=%s]", new Object[] { localUpSync.getTargetVersion(), Integer.valueOf(localUpSync.getNodes().size()) });
    paramString = (DownSync)PG.changes().sync(localUpSync).execute();
    r.a("KeepSync", "Sync successful: [from_version = %s, to_version = %s]", new Object[] { paramString.getFromVersion(), paramString.getToVersion() });
    return paramString;
  }

  public void a(j paramj, String paramString)
    throws IOException
  {
    c(paramj);
    PG.changes().requestaccess(paramString).execute();
  }

  public void c(j paramj)
  {
    PH.setEmail(paramj.getName());
  }

  public Notes oh()
  {
    return PG;
  }

  public void r(String paramString1, String paramString2)
  {
    PL = new UpSync.SharedNoteInvite().setNodeId(paramString1).setInviteToken(paramString2);
  }

  private static class a extends GoogleRequestInitializer
  {
    private final Context mContext;

    public a(Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      super(paramString1, paramString2, paramString3);
      mContext = paramContext;
    }

    public void intercept(HttpRequest paramHttpRequest)
      throws IOException
    {
      super.intercept(paramHttpRequest);
      paramHttpRequest.getHeaders().setUserAgent(Config.nM());
    }
  }
}