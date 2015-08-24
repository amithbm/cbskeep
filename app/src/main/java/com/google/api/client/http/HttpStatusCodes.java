package com.google.api.client.http;

public class HttpStatusCodes
{
  public static boolean isRedirect(int paramInt)
  {
    switch (paramInt)
    {
    case 304:
    case 305:
    case 306:
    default:
      return false;
    case 301:
    case 302:
    case 303:
    case 307:
    }
    return true;
  }

  public static boolean isSuccess(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 300);
  }
}