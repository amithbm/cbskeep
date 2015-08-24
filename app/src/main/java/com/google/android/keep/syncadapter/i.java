package com.google.android.keep.syncadapter;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.model.VoiceBlob;
import com.google.android.keep.provider.b;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.y;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.r;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.services.notes.Notes;
import com.google.api.services.notes.Notes.Changes;
import com.google.api.services.notes.Notes.Changes.Insertmedia;
import com.google.api.services.notes.model.Blob;
import com.google.api.services.notes.model.InsertMedia;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

class i
{
  private final Notes Gu;
  private final a Gv = new a()
  {
    public String s(Uri paramAnonymousUri)
    {
      return "image/jpeg";
    }
  };
  private final a Gw = new a()
  {
    public String s(Uri paramAnonymousUri)
    {
      String str = b.a(i.a(i.this).getContentResolver(), paramAnonymousUri);
      paramAnonymousUri = str;
      if (!VoiceBlob.Ak.contains(str))
      {
        r.e("KeepSync", "Audio file is not in supported format: " + str, new Object[0]);
        paramAnonymousUri = null;
      }
      return paramAnonymousUri;
    }
  };
  private final long cU;
  private final Context mContext;

  i(long paramLong, Context paramContext, Notes paramNotes)
  {
    cU = paramLong;
    mContext = paramContext;
    Gu = paramNotes;
  }

  private void a(String paramString, a parama)
    throws IOException
  {
    Object localObject1 = mContext.getContentResolver();
    Object localObject2 = i.e.CONTENT_URI;
    long l = cU;
    Cursor localCursor = ((ContentResolver)localObject1).query((Uri)localObject2, new String[] { "_id", "server_id", "full_path" }, paramString, new String[] { String.valueOf(l) }, null);
    paramString = "";
    while (true)
    {
      localObject1 = paramString;
      Object localObject3;
      try
      {
        if (!localCursor.moveToNext())
          break;
        localObject1 = paramString;
        l = localCursor.getLong(0);
        localObject1 = paramString;
        localObject2 = localCursor.getString(1);
        localObject1 = localObject2;
        paramString = localCursor.getString(2);
        localObject1 = localObject2;
        r.a("KeepSync", "Uploading media file for blob ID " + l, new Object[0]);
        localObject1 = localObject2;
        localObject3 = new File(paramString);
        localObject1 = localObject2;
        if (!((File)localObject3).canRead())
        {
          localObject1 = localObject2;
          r.a("KeepSync", "Cannot read file " + paramString, new Object[0]);
          localObject1 = localObject2;
          r.e("KeepSync", "Cannot read file", new Object[0]);
          paramString = (String)localObject2;
          continue;
        }
      }
      catch (IOException paramString)
      {
        f.b(mContext, paramString.getMessage(), (String)localObject1);
        throw paramString;
      }
      finally
      {
        localCursor.close();
      }
      localObject1 = localObject2;
      String str = parama.s(ContentUris.withAppendedId(i.y.CK, l));
      paramString = (String)localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        paramString = Gu.changes().insertmedia((String)localObject2, new InsertMedia(), new FileContent(str, (File)localObject3));
        localObject1 = localObject2;
        localObject3 = paramString.getMediaHttpUploader();
        localObject1 = localObject2;
        ((MediaHttpUploader)localObject3).getInitiationHeaders().setUserAgent(Config.nM());
        localObject1 = localObject2;
        ((MediaHttpUploader)localObject3).setChunkSize(262144);
        localObject1 = localObject2;
        ((MediaHttpUploader)localObject3).setBackOffPolicyEnabled(false);
        localObject1 = localObject2;
        if (r.isLoggable("KeepSync", 2))
        {
          localObject1 = localObject2;
          ((MediaHttpUploader)localObject3).setProgressListener(new MediaHttpUploaderProgressListener()
          {
            public void progressChanged(MediaHttpUploader paramAnonymousMediaHttpUploader)
              throws IOException
            {
              Log.v("KeepSync", "Upload progress: " + paramAnonymousMediaHttpUploader.getProgress());
            }
          });
        }
        localObject1 = localObject2;
        paramString = (Blob)paramString.execute();
        localObject1 = localObject2;
        str = paramString.getMediaId();
        localObject1 = localObject2;
        r.a("KeepSync", "Obtained media id " + str + " from server", new Object[0]);
        localObject1 = localObject2;
        localObject3 = new ContentValues();
        localObject1 = localObject2;
        ((ContentValues)localObject3).put("media_id", str);
        localObject1 = localObject2;
        str = paramString.getExtractedText();
        if (str != null)
        {
          localObject1 = localObject2;
          ((ContentValues)localObject3).put("extracted_text", str);
        }
        localObject1 = localObject2;
        ((ContentValues)localObject3).put("extraction_status", Integer.valueOf(ImageBlob.N(paramString.getExtractionStatus())));
        localObject1 = localObject2;
        mContext.getContentResolver().update(ContentUris.withAppendedId(i.e.CONTENT_URI, l), (ContentValues)localObject3, null, null);
        paramString = (String)localObject2;
      }
    }
    localCursor.close();
  }

  void lr()
    throws IOException
  {
    a("blob.blob_type=0 AND blob.media_id IS NULL AND blob.blob_account_id=? AND blob_node.server_id IS NOT NULL", Gv);
    a("blob.blob_type=1 AND blob.media_id IS NULL AND blob.blob_account_id=? AND blob_node.server_id IS NOT NULL", Gw);
  }

  private static abstract interface a
  {
    public abstract String s(Uri paramUri);
  }
}