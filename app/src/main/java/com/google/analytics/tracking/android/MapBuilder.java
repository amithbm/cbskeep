package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class MapBuilder
{
  private Map<String, String> map = new HashMap();

  static String booleanToString(Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return null;
    if (paramBoolean.booleanValue())
      return "1";
    return "0";
  }

  public static MapBuilder createAppView()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_APP_VIEW);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "appview");
    return localMapBuilder;
  }

  public static MapBuilder createEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EVENT);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "event");
    localMapBuilder.set("&ec", paramString1);
    localMapBuilder.set("&ea", paramString2);
    localMapBuilder.set("&el", paramString3);
    if (paramLong == null);
    for (paramString1 = null; ; paramString1 = Long.toString(paramLong.longValue()))
    {
      localMapBuilder.set("&ev", paramString1);
      return localMapBuilder;
    }
  }

  public static MapBuilder createException(String paramString, Boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EXCEPTION);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "exception");
    localMapBuilder.set("&exd", paramString);
    localMapBuilder.set("&exf", booleanToString(paramBoolean));
    return localMapBuilder;
  }

  public static MapBuilder createTiming(String paramString1, Long paramLong, String paramString2, String paramString3)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TIMING);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "timing");
    localMapBuilder.set("&utc", paramString1);
    paramString1 = null;
    if (paramLong != null)
      paramString1 = Long.toString(paramLong.longValue());
    localMapBuilder.set("&utt", paramString1);
    localMapBuilder.set("&utv", paramString2);
    localMapBuilder.set("&utl", paramString3);
    return localMapBuilder;
  }

  public Map<String, String> build()
  {
    return new HashMap(map);
  }

  public MapBuilder set(String paramString1, String paramString2)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET);
    if (paramString1 != null)
    {
      map.put(paramString1, paramString2);
      return this;
    }
    Log.w(" MapBuilder.set() called with a null paramName.");
    return this;
  }

  public MapBuilder setCampaignParamsFromUrl(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
    paramString = Utils.filterCampaign(paramString);
    if (TextUtils.isEmpty(paramString))
      return this;
    paramString = Utils.parseURLParameters(paramString);
    set("&cc", (String)paramString.get("utm_content"));
    set("&cm", (String)paramString.get("utm_medium"));
    set("&cn", (String)paramString.get("utm_campaign"));
    set("&cs", (String)paramString.get("utm_source"));
    set("&ck", (String)paramString.get("utm_term"));
    set("&ci", (String)paramString.get("utm_id"));
    set("&gclid", (String)paramString.get("gclid"));
    set("&dclid", (String)paramString.get("dclid"));
    set("&gmob_t", (String)paramString.get("gmob_t"));
    return this;
  }
}