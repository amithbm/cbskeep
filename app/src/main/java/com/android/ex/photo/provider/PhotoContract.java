package com.android.ex.photo.provider;

public final class PhotoContract
{
  public static abstract interface PhotoQuery
  {
    public static final String[] OPTIONAL_COLUMNS = { "loadingIndicator" };
    public static final String[] PROJECTION = { "uri", "_display_name", "contentUri", "thumbnailUri", "contentType" };
  }
}