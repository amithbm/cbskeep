package com.google.android.gsf;

import android.net.Uri;
import android.provider.BaseColumns;

public class SubscribedFeeds
{
  public static final class Feeds
    implements BaseColumns
  {
    public static final Uri CONTENT_URI = Uri.parse("content://subscribedfeeds/feeds");
    public static final Uri DELETED_CONTENT_URI = Uri.parse("content://subscribedfeeds/deleted_feeds");
  }
}