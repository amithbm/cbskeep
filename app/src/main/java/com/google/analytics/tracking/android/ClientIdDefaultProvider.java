package com.google.analytics.tracking.android;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class ClientIdDefaultProvider
  implements DefaultProvider
{
  private static ClientIdDefaultProvider sInstance;
  private static final Object sInstanceLock = new Object();
  private String mClientId;
  private boolean mClientIdLoaded = false;
  private final Object mClientIdLock = new Object();
  private final Context mContext;

  protected ClientIdDefaultProvider(Context paramContext)
  {
    mContext = paramContext;
    asyncInitializeClientId();
  }

  private void asyncInitializeClientId()
  {
    new Thread("client_id_fetcher")
    {
      public void run()
      {
        synchronized (mClientIdLock)
        {
          ClientIdDefaultProvider.access$102(ClientIdDefaultProvider.this, initializeClientId());
          ClientIdDefaultProvider.access$202(ClientIdDefaultProvider.this, true);
          mClientIdLock.notifyAll();
          return;
        }
      }
    }
    .start();
  }

  private String blockingGetClientId()
  {
    if (!mClientIdLoaded);
    synchronized (mClientIdLock)
    {
      if (!mClientIdLoaded)
        Log.v("Waiting for clientId to load");
      try
      {
        do
          mClientIdLock.wait();
        while (!mClientIdLoaded);
        Log.v("Loaded clientId");
        return mClientId;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          Log.e("Exception while waiting for clientId: " + localInterruptedException);
      }
    }
  }

  public static ClientIdDefaultProvider getProvider()
  {
    synchronized (sInstanceLock)
    {
      ClientIdDefaultProvider localClientIdDefaultProvider = sInstance;
      return localClientIdDefaultProvider;
    }
  }

  public static void initializeProvider(Context paramContext)
  {
    synchronized (sInstanceLock)
    {
      if (sInstance == null)
        sInstance = new ClientIdDefaultProvider(paramContext);
      return;
    }
  }

  private boolean storeClientId(String paramString)
  {
    try
    {
      Log.v("Storing clientId.");
      FileOutputStream localFileOutputStream = mContext.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      Log.e("Error creating clientId file.");
      return false;
    }
    catch (IOException paramString)
    {
      Log.e("Error writing to clientId file.");
    }
    return false;
  }

  protected String generateClientId()
  {
    String str2 = UUID.randomUUID().toString().toLowerCase();
    String str1 = str2;
    if (!storeClientId(str2))
      str1 = "0";
    return str1;
  }

  public String getValue(String paramString)
  {
    if ("&cid".equals(paramString))
      return blockingGetClientId();
    return null;
  }

  String initializeClientId()
  {
    Object localObject4 = null;
    Object localObject3 = null;
    try
    {
      localFileInputStream = mContext.openFileInput("gaClientId");
      Object localObject1 = new byte[''];
      int i = localFileInputStream.read((byte[])localObject1, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        Log.e("clientId file seems corrupted, deleting it.");
        localFileInputStream.close();
        mContext.deleteFile("gaClientId");
      }
      for (localObject1 = localObject3; ; localObject1 = localObject3)
      {
        localObject3 = localObject1;
        if (localObject1 == null)
          localObject3 = generateClientId();
        return localObject3;
        if (i > 0)
          break;
        Log.e("clientId file seems empty, deleting it.");
        localFileInputStream.close();
        mContext.deleteFile("gaClientId");
      }
      localObject1 = new String((byte[])localObject1, 0, i);
    }
    catch (IOException localIOException1)
    {
      while (true)
        try
        {
          FileInputStream localFileInputStream;
          localFileInputStream.close();
          continue;
          localIOException1 = localIOException1;
          Object localObject2 = localObject4;
          Log.e("Error reading clientId file, deleting it.");
          mContext.deleteFile("gaClientId");
        }
        catch (IOException localIOException2)
        {
        }
        catch (FileNotFoundException localFileNotFoundException3)
        {
        }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      while (true)
        FileNotFoundException localFileNotFoundException2 = localFileNotFoundException3;
    }
  }
}