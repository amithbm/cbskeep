package com.google.android.keep.syncadapter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SyncResult;
import android.content.SyncStats;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.people.People;
import com.google.android.gms.people.People.PeopleOptions1p.Builder;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.A;
import com.google.android.keep.provider.DatabaseHelper;
import com.google.android.keep.provider.i.a;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.k;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.provider.i.p;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.util.C;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.h;
import com.google.android.keep.util.o;
import com.google.android.keep.util.p;
import com.google.android.keep.util.r;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.notes.model.DownSync;
import com.google.api.services.notes.model.Node;
import com.google.api.services.notes.model.Node.Timestamps;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeepSyncAdapter extends AbstractThreadedSyncAdapter
{
  final p Gf;
  private String Gg;
  private long Gh = -1L;
  private GoogleApiClient gh;
  final AccountManager mAccountManager;
  private volatile boolean mCanceled = false;

  public KeepSyncAdapter(Context paramContext)
  {
    super(paramContext, false);
    mAccountManager = AccountManager.get(paramContext);
    Gf = new p(paramContext);
  }

  static void C(Context paramContext)
  {
    long l = System.currentTimeMillis();
    a(paramContext, i.m.BX, l);
    a(paramContext, i.e.BX, l);
    a(paramContext, i.v.BX, l);
    a(paramContext, "list_item", i.m.BX);
    a(paramContext, "blob_node", i.e.BX);
    a(paramContext, "tree_entity", i.v.CI);
  }

  private void C(List<Node> paramList)
  {
    if (!r.isLoggable("KeepSync", 2));
    while (true)
    {
      return;
      Log.v("KeepSync", "About to upsync following local changes:");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Node)paramList.next();
        Log.v("KeepSync", "\nThis is a " + ((Node)localObject).getType() + " with id " + ((Node)localObject).getId());
        Log.v("KeepSync", "Parent Id: " + ((Node)localObject).getParentId());
        Log.v("KeepSync", "Is archived: " + ((Node)localObject).getIsArchived());
        Log.v("KeepSync", "Sort value is: " + ((Node)localObject).getSortValue());
        Log.v("KeepSync", "Color is: " + ((Node)localObject).getColor());
        Log.v("KeepSync", "BaseVersion is: " + ((Node)localObject).getBaseVersion());
        Log.v("KeepSync", "Text is: " + ((Node)localObject).getText());
        localObject = ((Node)localObject).getTimestamps();
        if (localObject != null)
        {
          Log.v("KeepSync", "Time created: " + ((Node.Timestamps)localObject).getCreated());
          Log.v("KeepSync", "Time last updated: " + ((Node.Timestamps)localObject).getUpdated());
          Log.v("KeepSync", "Time deleted: " + ((Node.Timestamps)localObject).getDeleted());
          Log.v("KeepSync", "Time trashed: " + ((Node.Timestamps)localObject).getTrashed());
        }
        Log.v("KeepSync", "\n");
      }
    }
  }

  private int a(com.google.android.keep.model.j paramj, SyncResult paramSyncResult, boolean paramBoolean)
  {
    if (mCanceled)
    {
      r.a("KeepSync", "Sync is cancelled", new Object[0]);
      paramj = paramSyncResult.stats;
      paramj.numIoExceptions += 1L;
      paramSyncResult.delayUntil = ((Long)Config.OZ.get()).longValue();
      return 7;
    }
    while (true)
    {
      try
      {
        Gf.c(paramj);
        j localj;
        try
        {
          String str = bb(paramj.getName());
          if ((TextUtils.equals(str, Gg)) && (Gh != -1L))
            continue;
          Gg = str;
          Gh = System.currentTimeMillis();
          localj = new j(getContext(), DatabaseHelper.getInstance(getContext()).getReadableDatabase(), paramj.getId(), Config.nz());
          if ((!paramBoolean) || (localj.getNodes().size() != 0) || (localj.getUserInfo() != null))
            continue;
          Log.v("KeepSync", "Skip this empty sync");
          return 1;
        }
        catch (AccountNotFoundException localAccountNotFoundException)
        {
          if (!r.isLoggable("KeepSync", 2))
            break label720;
        }
        Log.v("KeepSync", "Account has been removed from the device:" + paramj.getName());
        Log.v("KeepSync", localAccountNotFoundException.getMessage());
        break label720;
        long l1 = System.currentTimeMillis();
        long l2 = Gh;
        if (l1 <= ((Long)Config.OY.get()).longValue() + l2)
          continue;
        paramj = paramSyncResult.stats;
        paramj.numIoExceptions += 1L;
        paramSyncResult.delayUntil = ((Long)Config.OZ.get()).longValue();
        return 6;
        C(localj.getNodes());
        l1 = System.currentTimeMillis();
        DownSync localDownSync = Gf.a(localAccountNotFoundException, localj.getNodes(), localj.getUserInfo());
        r.a("KeepSync", "Sync request took %s milliseconds", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        i = new DownSyncResponseProcessor(getContext(), gh, localDownSync, paramj, localAccountNotFoundException, localj.getNodes(), localj.getUserInfo(), localj.ls()).lj();
        r.a("KeepSync", "Sync once result:" + i, new Object[0]);
        switch (i)
        {
        case 5:
          paramj = localDownSync.getTruncated();
          if (paramj != null)
          {
            if (!paramj.booleanValue())
              break label727;
            return 0;
            paramj = paramSyncResult.stats;
            paramj.numIoExceptions += 1L;
            return 5;
          }
        case 3:
          paramj = paramSyncResult.stats;
          paramj.numParseExceptions += 1L;
          return 3;
        case 4:
          paramj = paramSyncResult.stats;
          paramj.numParseExceptions += 1L;
          return 4;
          if (!TextUtils.isEmpty(localDownSync.getToVersion()))
          {
            paramBoolean = localDownSync.getToVersion().equals(localAccountNotFoundException);
            if (!paramBoolean)
              return 0;
          }
          return 1;
        default:
        case 2:
        }
      }
      catch (HttpResponseException paramj)
      {
        int i = paramj.getStatusCode();
        r.a("KeepSync", "Received http error.\n  Status code: %d\n  Message: %s", new Object[] { Integer.valueOf(i), paramj.getMessage() });
        if (i == 401)
        {
          Log.e("KeepSync", "401 auth exception");
          paramj = paramSyncResult.stats;
          paramj.numAuthExceptions += 1L;
          return 2;
        }
        Log.e("KeepSync", "HTTP exception");
        paramSyncResult = paramSyncResult.stats;
        paramSyncResult.numIoExceptions += 1L;
        f.f(getContext(), paramj.getMessage());
        continue;
      }
      catch (IOException paramj)
      {
        Log.e("KeepSync", "IOException", paramj);
        paramj = paramSyncResult.stats;
        paramj.numIoExceptions += 1L;
        return 2;
      }
      catch (IllegalArgumentException paramj)
      {
        Log.e("KeepSync", "IllegalArgumentException", paramj);
        paramj = paramSyncResult.stats;
        paramj.numAuthExceptions += 1L;
        return 2;
      }
      label720: return 2;
      continue;
      return 2;
    }
    label727: return 1;
  }

  private static void a(Context paramContext, Uri paramUri, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("is_deleted", Integer.valueOf(1));
    localContentValues.put("is_dirty", Integer.valueOf(1));
    localContentValues.put("time_last_updated", Long.valueOf(paramLong));
    long l = Config.nE();
    paramContext.getContentResolver().update(paramUri, localContentValues, "is_deleted = ? AND time_last_updated < ?", new String[] { String.valueOf(-1), String.valueOf(paramLong - l) });
  }

  private static void a(Context paramContext, String paramString, Uri paramUri)
  {
    paramString = paramString + "." + "is_deleted" + " = ? AND " + paramString + "." + "server_id" + " IS NULL ";
    paramContext.getContentResolver().delete(paramUri, paramString, new String[] { String.valueOf(1) });
  }

  private void a(com.google.android.keep.model.j paramj, SyncResult paramSyncResult)
  {
    try
    {
      new i(paramj.getId(), getContext(), Gf.oh()).lr();
      return;
    }
    catch (IOException paramj)
    {
      Log.e("KeepSync", "Error uploading media files", paramj);
      paramj = paramSyncResult.stats;
      paramj.numIoExceptions += 1L;
    }
  }

  private String bb(String paramString)
    throws KeepSyncAdapter.AccountNotFoundException
  {
    paramString = getContext().getContentResolver().query(i.a.CONTENT_URI, new String[] { "last_sync_version" }, "name=?", new String[] { paramString }, null);
    try
    {
      if (paramString.getCount() != 1)
        throw new AccountNotFoundException("Cannot find account in database");
    }
    finally
    {
      paramString.close();
    }
    paramString.moveToFirst();
    String str = paramString.getString(0);
    paramString.close();
    return str;
  }

  private int d(com.google.android.keep.model.j paramj)
  {
    r.a("KeepSync", "\n******** Downloading media files *********", new Object[0]);
    Object localObject1 = getContext().getContentResolver();
    Object localObject2 = i.e.CONTENT_URI;
    long l = paramj.getId();
    localObject1 = ((ContentResolver)localObject1).query((Uri)localObject2, new String[] { "blob_id", "blob_account_id", "media_id", "blob_type" }, "blob.file_name IS NULL AND (blob.blob_type=0 OR blob.blob_type=1) AND blob.blob_account_id=?", new String[] { String.valueOf(l) }, null);
    paramj = C.j(getContext(), paramj);
    if (paramj == null)
    {
      Log.e("KeepSync", "Null auth token when trying to download media files");
      return 2;
    }
    localObject2 = A.p(getContext());
    try
    {
      ((Cursor)localObject1).moveToPosition(-1);
      while (((Cursor)localObject1).moveToNext())
        ((A)localObject2).a(((Cursor)localObject1).getLong(0), ((Cursor)localObject1).getLong(1), paramj, ((Cursor)localObject1).getString(2), ((Cursor)localObject1).getInt(3));
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
    ((Cursor)localObject1).close();
    return 1;
  }

  static boolean e(Context paramContext, com.google.android.keep.model.j paramj)
  {
    boolean bool = false;
    paramContext = paramContext.getContentResolver();
    long l = paramj.getId();
    paramj = new String[2];
    paramj[0] = String.valueOf(1);
    paramj[1] = String.valueOf(l);
    if ((h.a(paramContext, i.v.BX, "is_dirty = ? AND account_id = ?", paramj) > 0) || (h.a(paramContext, i.m.BX, "is_dirty = ? AND account_id = ?", paramj) > 0) || (h.a(paramContext, i.e.BX, "is_dirty = ? AND account_id = ?", paramj) > 0) || (h.a(paramContext, i.k.BX, "is_dirty = ? AND account_id = ?", paramj) > 0) || (h.a(paramContext, i.p.BX, "is_dirty = ? AND account_id = ?", paramj) > 0))
      bool = true;
    return bool;
  }

  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    mCanceled = false;
    Gg = null;
    Gh = -1L;
    if ((Config.oe()) && (r.isLoggable("KeepHttpTransport", 2)))
      Logger.getLogger(HttpTransport.class.getName()).setLevel(Level.CONFIG);
    if ((paramBundle != null) && (paramBundle.getBoolean("initialize", false)))
    {
      r.a("KeepSync", "Enabling sync on initial sync", new Object[0]);
      ContentResolver.setIsSyncable(paramAccount, paramString, 1);
      ContentResolver.setSyncAutomatically(paramAccount, paramString, true);
    }
    do
    {
      return;
      if ((paramBundle == null) || (!paramBundle.getBoolean("upload", false)))
        break;
      bool = true;
      if (r.isLoggable("KeepSync", 2))
      {
        Log.v("KeepSync", "Starting notes sync. Is local sync: " + bool);
        paramString = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Log.v("KeepSync", "Current time:" + paramString.format(new Date()));
      }
      C.a(getContext().getContentResolver(), paramAccount);
      paramAccount = o.c(getContext(), paramAccount);
    }
    while (paramAccount == null);
    r.a("KeepSync", "Sync account:" + paramAccount, new Object[0]);
    paramString = new People.PeopleOptions1p.Builder().setClientApplicationId(131).build();
    gh = new GoogleApiClient.Builder(getContext()).addApi(Drive.API).addApi(People.API_1P, paramString).addScope(Drive.SCOPE_APPFOLDER).addScope(Drive.SCOPE_FULL).setAccountName(paramAccount.getName()).build();
    Log.v("KeepSync", "Connecting to GoogleApiClient");
    paramString = gh.blockingConnect(5L, TimeUnit.SECONDS);
    if (!gh.isConnected())
      Log.v("KeepSync", "GoogleApiClient failed to connect with error code: " + paramString.getErrorCode());
    int i;
    while (true)
    {
      if ((paramBundle != null) && (paramBundle.getBoolean("refresh_sync", false)))
      {
        paramString = new ContentValues();
        paramString.put("last_sync_version", "");
        getContext().getContentResolver().update(i.a.CONTENT_URI, paramString, "name=?", new String[] { paramAccount.getName() });
      }
      if ((paramBundle != null) && (paramBundle.containsKey("note_server_id")) && (paramBundle.containsKey("invitation_token")))
        Gf.r(paramBundle.getString("note_server_id"), paramBundle.getString("invitation_token"));
      C(getContext());
      i = 0;
      while (i == 0)
      {
        j = a(paramAccount, paramSyncResult, bool);
        if (j == 0)
          r.a("KeepSync", "Issuing another request to sync in case there's more data", new Object[0]);
        i = j;
        if (j == 1)
        {
          i = j;
          if (e(getContext(), paramAccount))
          {
            i = 0;
            r.a("KeepSync", "There is more data to sync. Issuing another request", new Object[0]);
          }
        }
      }
      bool = false;
      break;
      Log.v("KeepSync", "Connected to GoogleApiClient.");
    }
    int j = i;
    if (i == 1)
    {
      j = d(paramAccount);
      a(paramAccount, paramSyncResult);
    }
    if (j != 1)
      r.d("KeepSync", "Sync result " + j, new Object[0]);
    paramAccount = getContext();
    if (j == 1);
    for (boolean bool = true; ; bool = false)
    {
      g.a(paramAccount, bool);
      gh.disconnect();
      gh = null;
      return;
    }
  }

  public void onSyncCanceled()
  {
    super.onSyncCanceled();
    mCanceled = true;
  }

  private class AccountNotFoundException extends Exception
  {
    AccountNotFoundException(String arg2)
    {
      super();
    }
  }
}