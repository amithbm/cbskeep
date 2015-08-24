package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class NetHttpTransport extends HttpTransport
{
  private static final String[] SUPPORTED_METHODS = { "DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE" };
  private final HostnameVerifier hostnameVerifier;
  private final Proxy proxy;
  private final SSLSocketFactory sslSocketFactory;

  static
  {
    Arrays.sort(SUPPORTED_METHODS);
  }

  public NetHttpTransport()
  {
    this(null, null, null);
  }

  NetHttpTransport(Proxy paramProxy, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier)
  {
    proxy = paramProxy;
    sslSocketFactory = paramSSLSocketFactory;
    hostnameVerifier = paramHostnameVerifier;
  }

  protected NetHttpRequest buildRequest(String paramString1, String paramString2)
    throws IOException
  {
    Preconditions.checkArgument(supportsMethod(paramString1), "HTTP method %s not supported", new Object[] { paramString1 });
    paramString2 = new URL(paramString2);
    if (proxy == null);
    for (paramString2 = paramString2.openConnection(); ; paramString2 = paramString2.openConnection(proxy))
    {
      paramString2 = (HttpURLConnection)paramString2;
      paramString2.setRequestMethod(paramString1);
      if ((paramString2 instanceof HttpsURLConnection))
      {
        paramString1 = (HttpsURLConnection)paramString2;
        if (hostnameVerifier != null)
          paramString1.setHostnameVerifier(hostnameVerifier);
        if (sslSocketFactory != null)
          paramString1.setSSLSocketFactory(sslSocketFactory);
      }
      return new NetHttpRequest(paramString2);
    }
  }

  public boolean supportsMethod(String paramString)
  {
    return Arrays.binarySearch(SUPPORTED_METHODS, paramString) >= 0;
  }
}