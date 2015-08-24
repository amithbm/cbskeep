package com.google.android.apiary;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.common.http.UrlRules;
import com.google.android.common.http.UrlRules.Rule;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import java.io.IOException;

public class GoogleRequestInitializer
  implements HttpExecuteInterceptor, HttpRequestInitializer, HttpUnsuccessfulResponseHandler
{
  private String mAccountName;
  private String mAuthToken = null;
  private final Context mContext;
  private final String mLogTag;
  private int mRequestConnectTimeout = 0;
  private int mRequestReadTimeout = 0;
  private final String mScope;
  private final String mSyncAuthority;
  private String mUserAgentString;

  public GoogleRequestInitializer(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    mContext = paramContext;
    mScope = paramString1;
    mLogTag = paramString2;
    mSyncAuthority = paramString3;
  }

  public String getAuthToken()
    throws AuthenticationException
  {
    if (mAuthToken == null);
    try
    {
      if (mSyncAuthority != null);
      for (mAuthToken = GoogleAuthUtil.getTokenWithNotification(mContext, mAccountName, mScope, null, mSyncAuthority, null); ; mAuthToken = GoogleAuthUtil.getTokenWithNotification(mContext, mAccountName, mScope, null))
        return mAuthToken;
    }
    catch (IOException localIOException)
    {
      throw new AuthenticationException("Could not get an auth token", localIOException);
    }
    catch (GoogleAuthException localGoogleAuthException)
    {
      throw new AuthenticationException("Could not get an auth token", localGoogleAuthException);
    }
  }

  public boolean handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, boolean paramBoolean)
    throws IOException
  {
    if (paramHttpResponse.getStatusCode() == 401)
    {
      Log.i(mLogTag, "Got a 401. Invalidating token");
      if (paramHttpRequest.getNumberOfRetries() > 0)
        Log.i(mLogTag, "Retrying request");
      GoogleAuthUtil.invalidateToken(mContext, mAuthToken);
      mAuthToken = null;
      return true;
    }
    return false;
  }

  public void initialize(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.setInterceptor(this).setUnsuccessfulResponseHandler(this).setNumberOfRetries(1);
    if (mRequestConnectTimeout > 0)
      paramHttpRequest.setConnectTimeout(mRequestConnectTimeout);
    if (mRequestReadTimeout > 0)
      paramHttpRequest.setReadTimeout(mRequestReadTimeout);
  }

  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    Object localObject = getAuthToken();
    HttpHeaders localHttpHeaders = paramHttpRequest.getHeaders();
    localHttpHeaders.setAuthorization("OAuth " + (String)localObject);
    localObject = paramHttpRequest.getUrl();
    String str1 = ((GenericUrl)localObject).build();
    UrlRules.Rule localRule = UrlRules.getRules(mContext.getContentResolver()).matchRule(str1);
    String str2 = localRule.apply(str1);
    if (str2 == null)
    {
      Log.w(mLogTag, "Blocked by " + localRule.mName + ": " + str1);
      throw new BlockedRequestException(localRule, null);
    }
    if (!str2.equals(str1))
    {
      if (Log.isLoggable(mLogTag, 2))
        Log.v(mLogTag, "Rule " + localRule.mName + ": " + str1 + " -> " + str2);
      localObject = new GenericUrl(str2);
      paramHttpRequest.setUrl((GenericUrl)localObject);
    }
    paramHttpRequest = (String)((GenericUrl)localObject).getFirst("ifmatch");
    if (paramHttpRequest != null)
    {
      localHttpHeaders.setIfMatch(paramHttpRequest);
      ((GenericUrl)localObject).remove("ifmatch");
    }
    paramHttpRequest = new StringBuilder(Build.FINGERPRINT).append(":");
    if (mUserAgentString != null)
      paramHttpRequest.append(mUserAgentString);
    while (true)
    {
      str1 = (String)((GenericUrl)localObject).getFirst("userAgentPackage");
      if (str1 != null)
      {
        paramHttpRequest.append(":").append(str1);
        ((GenericUrl)localObject).remove("userAgentPackage");
      }
      localHttpHeaders.setUserAgent(paramHttpRequest.toString());
      return;
      paramHttpRequest.append(mLogTag);
    }
  }

  public void setEmail(String paramString)
  {
    mAccountName = paramString;
    mAuthToken = null;
  }

  public void setRequestConnectTimeout(int paramInt)
    throws IllegalArgumentException
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("timeout value needs to be positive.");
    mRequestConnectTimeout = paramInt;
  }

  public void setRequestReadTimeout(int paramInt)
    throws IllegalArgumentException
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("timeout value needs to be positive.");
    mRequestReadTimeout = paramInt;
  }

  public static class BlockedRequestException extends IOException
  {
    private BlockedRequestException(UrlRules.Rule paramRule)
    {
      super();
    }
  }
}