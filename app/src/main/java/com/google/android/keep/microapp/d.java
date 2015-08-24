package com.google.android.keep.microapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.android.keep.C;
import com.google.android.keep.G;
import com.google.android.keep.S;
import com.google.android.keep.T;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.model.j;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.w;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class d
{
  private static final int to = Runtime.getRuntime().availableProcessors();
  private static final ExecutorService tp = Executors.newFixedThreadPool(to);

  private static int a(Context paramContext, PutDataRequest paramPutDataRequest, long[] paramArrayOfLong, final Semaphore paramSemaphore)
  {
    int j = 0;
    int k = paramArrayOfLong.length;
    int i = 0;
    if (i < k)
    {
      final long l = paramArrayOfLong[i];
      if (l == -1L);
      while (true)
      {
        i += 1;
        break;
        j += 1;
        tp.execute(new Runnable()
        {
          public void run()
          {
            try
            {
              ??? = w.fU().i(rh, ImageBlob.s(l));
              Asset localAsset;
              if (??? != null)
                localAsset = d.c(S.b((Bitmap)???, WearableService.tL, WearableService.tM));
              synchronized (paramSemaphore)
              {
                paramSemaphore.putAsset(String.valueOf(l), localAsset);
                return;
              }
            }
            finally
            {
              ts.release();
            }
          }
        });
      }
    }
    return j;
  }

  public static void a(Context paramContext, GoogleApiClient paramGoogleApiClient)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException("Cannot be called from the main thread.");
    r.b("KeepWearable", "updateBrowseNotesDataItems", new Object[0]);
    Object localObject = o.O(paramContext);
    if (localObject != null)
    {
      PutDataRequest localPutDataRequest = PutDataRequest.create("/keep/browse_notes");
      List localList = e.b(paramContext, (j)localObject);
      C localC = new C();
      localC.tS = ((G[])localList.toArray(new G[localList.size()]));
      byte[] arrayOfByte2 = C.toByteArray(localC);
      byte[] arrayOfByte1 = arrayOfByte2;
      localObject = localList;
      if (arrayOfByte2.length > 100000)
      {
        localObject = i(localList);
        localC.tS = ((G[])((List)localObject).toArray(new G[((List)localObject).size()]));
        arrayOfByte1 = C.toByteArray(localC);
      }
      localPutDataRequest.setData(arrayOfByte1);
      a(paramContext, localPutDataRequest, (List)localObject);
      try
      {
        paramContext = (DataApi.DataItemResult)Wearable.DataApi.putDataItem(paramGoogleApiClient, localPutDataRequest).await(5000L, TimeUnit.MILLISECONDS);
        if (!paramContext.getStatus().isSuccess())
        {
          r.e("KeepWearable", "Failed to put data item for browse notes", new Object[0]);
          return;
        }
      }
      finally
      {
      }
      r.b("KeepWearable", "Browse note data items created.", new Object[0]);
      return;
    }
    if (!((DataApi.DeleteDataItemsResult)Wearable.DataApi.deleteDataItems(paramGoogleApiClient, T.Ek).await(5000L, TimeUnit.MILLISECONDS)).getStatus().isSuccess())
    {
      r.e("KeepWearable", "Failed to delete data item for browse notes", new Object[0]);
      return;
    }
    r.b("KeepWearable", "Browse note data items deleted.", new Object[0]);
  }

  public static void a(Context paramContext, PutDataRequest paramPutDataRequest, List<G> paramList)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
      throw new IllegalStateException("This method cannot be called on the main thread");
    int i = 0;
    Semaphore localSemaphore = new Semaphore(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long[] arrayOfLong = ((G)paramList.next()).ue;
      if ((arrayOfLong != null) && (arrayOfLong.length > 0))
        i += a(paramContext, paramPutDataRequest, arrayOfLong, localSemaphore);
    }
    try
    {
      if (!localSemaphore.tryAcquire(i, 20L, TimeUnit.SECONDS))
        r.d("KeepWearable", "Did not add all assets to the request before putDataItem! semaphoreCount=%d", new Object[] { Integer.valueOf(i) });
      return;
    }
    catch (InterruptedException paramContext)
    {
      r.d("KeepWearable", "Image loading interrupted!", new Object[0]);
    }
  }

  private static Asset b(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return Asset.createFromBytes(localByteArrayOutputStream.toByteArray());
  }

  private static List<G> i(List<G> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      G localG = (G)paramList.next();
      i += G.toByteArray(localG).length;
      if (i >= 100000)
        break;
      localArrayList.add(localG);
    }
    return localArrayList;
  }
}