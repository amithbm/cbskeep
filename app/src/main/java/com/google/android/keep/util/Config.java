package com.google.android.keep.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.activities.KeepApplication;
import com.google.common.collect.Maps;
import java.util.Locale;
import java.util.Map;

public class Config
{
  private static GservicesValue<Integer> OA = GservicesValue.value("keep:marked_deleted_notes_cleanup_interval", Integer.valueOf(300000));
  private static GservicesValue<Integer> OB = GservicesValue.value("keep:max_download_thread_pool_size", Integer.valueOf(4));
  private static GservicesValue<Integer> OC = GservicesValue.value("keep:autosave_interval_ms", Integer.valueOf(3000));
  private static GservicesValue<Integer> OD = GservicesValue.value("keep:reminder_autosave_interval_ms", Integer.valueOf(600000));
  private static GservicesValue<Boolean> OE = GservicesValue.value("keep:debug_analytics", false);
  private static GservicesValue<Boolean> OF = GservicesValue.value("keep:enable_google_analytics", true);
  private static GservicesValue<Integer> OG = GservicesValue.value("keep:places_radius_meters", Integer.valueOf(30000));
  private static GservicesValue<String> OH = GservicesValue.value("keep:apiary_key", "AIzaSyDzSyl-DPNxSyc7eghRsB4oNNetrnvnH0I");
  private static GservicesValue<Integer> OI = GservicesValue.value("keep:location_default_radius_meters", Integer.valueOf(200));
  public static GservicesValue<Float> OJ = GservicesValue.value("keep:location_default_latlng_bounds", Float.valueOf(0.001F));
  private static GservicesValue<Integer> OK = GservicesValue.value("keep:browse_reminders_nearby_radius_meters", Integer.valueOf(50000));
  private static GservicesValue<Integer> OL = GservicesValue.value("keep:browse_reminders_nearby_limit", Integer.valueOf(5));
  private static GservicesValue<Integer> OM = GservicesValue.value("keep:max_wifi_off_notification_count", Integer.valueOf(5));
  private static GservicesValue<Integer> ON = GservicesValue.value("keep:max_reminder_description_length_limit", Integer.valueOf(500));
  private static GservicesValue<Integer> OO = GservicesValue.value("keep:max_reminder_description_items_limit", Integer.valueOf(100));
  private static GservicesValue<Integer> OP = GservicesValue.value("keep:reminder_type_spinner_auto_expand_limit", Integer.valueOf(4));
  public static GservicesValue<Integer> OQ = GservicesValue.value("keep:reminder_valid_firing_time_range_ms", Integer.valueOf(120000));
  private static GservicesValue<String> OR = GservicesValue.value("keep:apiary_authtoken_type", "oauth2:https://www.googleapis.com/auth/memento https://www.googleapis.com/auth/drive");
  private static GservicesValue<String> OS = GservicesValue.value("keep:apiary_app_name", "android-memory");
  private static GservicesValue<Long> OT = GservicesValue.value("keep:purge_trash_limit", Long.valueOf(604800000L));
  private static GservicesValue<Long> OU = GservicesValue.value("keep:refresh_show_sync_off_bar_limit", Long.valueOf(604800000L));
  private static GservicesValue<String> OV = GservicesValue.value("keep:google_play_url", "https://play.google.com/store/apps/details?id=com.google.android.keep");
  private static GservicesValue<String> OW = GservicesValue.value("keep:tardis", "zjejhkhk");
  private static String OX;
  public static final GservicesValue<Long> OY = GservicesValue.value("keep:max_sync_time_on_same_version", Long.valueOf(120000L));
  public static final GservicesValue<Long> OZ = GservicesValue.value("keep:sync_delay", Long.valueOf(30L));
  private static GservicesValue<Boolean> Or = GservicesValue.value("keep:sync_menu_options", false);
  private static GservicesValue<Boolean> Os = GservicesValue.value("keep:label_editor", true);
  private static GservicesValue<String> Ot = GservicesValue.value("keep:media_download_server", "https://keep.google.com/media/");
  private static GservicesValue<Integer> Ou = GservicesValue.value("keep:upsync_batch_size", Integer.valueOf(100));
  private static GservicesValue<Integer> Ov = GservicesValue.value("keep:max_nodes_per_batch", Integer.valueOf(100));
  private static GservicesValue<Integer> Ow = GservicesValue.value("keep:max_node_char_limit", Integer.valueOf(19999));
  private static GservicesValue<Integer> Ox = GservicesValue.value("keep:max_list_item_limit", Integer.valueOf(995));
  private static GservicesValue<Integer> Oy = GservicesValue.value("keep:max_blob_size", Integer.valueOf(10485760));
  public static GservicesValue<Integer> Oz = GservicesValue.value("keep:max_pixels", Integer.valueOf(26214400));
  public static final GservicesValue<Long> Pa = GservicesValue.value("keep:last_edited_display_window", Long.valueOf(900000L));
  public static final GservicesValue<Integer> Pb = GservicesValue.value("keep:max_sharee_limit", Integer.valueOf(50));
  public static final GservicesValue<Integer> Pc = GservicesValue.value("keep:label_limit", Integer.valueOf(50));
  public static final GservicesValue<Integer> Pd = GservicesValue.value("keep:max_label_name_char_limit", Integer.valueOf(50));
  public static final GservicesValue<Boolean> Pe = GservicesValue.value("keep:log_db_operations", false);
  public static final GservicesValue<Boolean> Pf = GservicesValue.value("keep:log_model_events", false);
  private static final GservicesValue<Integer> Pg = GservicesValue.value("keep:brix_model_version_to_create", Integer.valueOf(2));
  private static final GservicesValue<Boolean> Ph = GservicesValue.value("nearbysharing:enabled", false);
  private static final GservicesValue<Boolean> Pi = GservicesValue.value("keep:nearby_sharing_enabled", true);
  public static final GservicesValue<Integer> Pj = GservicesValue.value("keep:auto_archive_reminders_time_window", Integer.valueOf(168));
  public static final GservicesValue<Boolean> Pk = GservicesValue.value("keep:use_qeb", true);
  public static final GservicesValue<Boolean> Pl = GservicesValue.value("keep:use_place_picker", true);
  public static final GservicesValue<Boolean> Pm = GservicesValue.value("keep:use_place_picker_search", true);
  public static final GservicesValue<Boolean> Pn = GservicesValue.value("keep:use_place_picker_nearby_results", true);
  public static final GservicesValue<Boolean> Po = GservicesValue.value("keep:enable_copy_note_to_docs", true);
  public static final GservicesValue<String> Pp = GservicesValue.value("keep:drive_api_url", "https://clients6.google.com/");
  public static final GservicesValue<Boolean> Pq = GservicesValue.value("keep:fetch_task_assistance", true);
  public static final GservicesValue<Boolean> Pr = GservicesValue.value("keep:enable_auto_bullets", true);
  public static final GservicesValue<Boolean> Ps = GservicesValue.value("keep:enable_auto_bullet_key_events", true);
  public static final GservicesValue<Boolean> Pt = GservicesValue.value("keep:enable_widget_note_selection", false);

  public static void E(Context paramContext)
  {
    OX = K(paramContext);
  }

  private static String K(Context paramContext)
  {
    Locale localLocale = Locale.getDefault();
    String str2 = KeepApplication.c(paramContext);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "-1";
    String str3 = paramContext.getString(2131231034);
    String str4 = KeepApplication.dq;
    if (TextUtils.isEmpty(localLocale.getLanguage()))
    {
      paramContext = "en";
      if (!TextUtils.isEmpty(localLocale.getCountry()))
        break label115;
    }
    label115: for (str2 = "us"; ; str2 = localLocale.getCountry().toLowerCase())
    {
      return String.format(str3, new Object[] { str1, str4, paramContext, str2, KeepApplication.dr, KeepApplication.ds });
      paramContext = localLocale.getLanguage().toLowerCase();
      break;
    }
  }

  public static int nA()
  {
    return ((Integer)Ov.get()).intValue();
  }

  public static int nB()
  {
    return ((Integer)Ow.get()).intValue();
  }

  public static int nC()
  {
    return ((Integer)Ox.get()).intValue();
  }

  public static int nD()
  {
    return ((Integer)Oy.get()).intValue();
  }

  public static int nE()
  {
    return ((Integer)OA.get()).intValue();
  }

  public static int nF()
  {
    return ((Integer)OB.get()).intValue();
  }

  public static int nG()
  {
    return ((Integer)OC.get()).intValue();
  }

  public static int nH()
  {
    return ((Integer)OD.get()).intValue();
  }

  public static boolean nI()
  {
    return ((Boolean)OE.get()).booleanValue();
  }

  public static boolean nJ()
  {
    return ((Boolean)OF.get()).booleanValue();
  }

  public static int nK()
  {
    return ((Integer)OG.get()).intValue();
  }

  public static String nL()
  {
    return (String)OH.get();
  }

  public static String nM()
  {
    return OX;
  }

  public static int nN()
  {
    return ((Integer)OI.get()).intValue();
  }

  public static int nO()
  {
    return ((Integer)OK.get()).intValue();
  }

  public static int nP()
  {
    return ((Integer)OL.get()).intValue();
  }

  public static int nQ()
  {
    return ((Integer)OM.get()).intValue();
  }

  public static int nR()
  {
    return ((Integer)ON.get()).intValue();
  }

  public static int nS()
  {
    return ((Integer)OO.get()).intValue();
  }

  public static int nT()
  {
    return ((Integer)OP.get()).intValue();
  }

  public static String nU()
  {
    return (String)OR.get();
  }

  public static String nV()
  {
    return (String)OS.get();
  }

  public static String nW()
  {
    return "KeepSyncV5";
  }

  public static int nX()
  {
    return 2;
  }

  public static int nY()
  {
    return Math.min(nX(), ((Integer)Pg.get()).intValue());
  }

  public static long nZ()
  {
    return ((Long)OT.get()).longValue();
  }

  public static boolean nw()
  {
    return ((Boolean)Or.get()).booleanValue();
  }

  public static boolean nx()
  {
    return ((Boolean)Os.get()).booleanValue();
  }

  public static String ny()
  {
    return (String)Ot.get();
  }

  public static int nz()
  {
    return ((Integer)Ou.get()).intValue();
  }

  public static long oa()
  {
    return ((Long)OU.get()).longValue();
  }

  public static String ob()
  {
    return (String)OV.get();
  }

  public static String oc()
  {
    if (TextUtils.isEmpty((CharSequence)OW.get()))
      return "zjejhkhk";
    return (String)OW.get();
  }

  public static boolean od()
  {
    return (((Boolean)Ph.get()).booleanValue()) && (((Boolean)Pi.get()).booleanValue());
  }

  public static boolean oe()
  {
    return (Build.TYPE.equals("userdebug")) || (Build.TYPE.equals("eng"));
  }

  public static enum UpgradeType
  {
    private static final Map<String, UpgradeType> Gb;
    private final String mTypeName;

    static
    {
      Gb = Maps.newHashMap();
      UpgradeType[] arrayOfUpgradeType = values();
      int j = arrayOfUpgradeType.length;
      int i = 0;
      while (i < j)
      {
        UpgradeType localUpgradeType = arrayOfUpgradeType[i];
        Gb.put(localUpgradeType.mTypeName, localUpgradeType);
        i += 1;
      }
    }

    private UpgradeType(String paramString)
    {
      mTypeName = paramString;
    }

    public static UpgradeType bx(String paramString)
    {
      return (UpgradeType)Gb.get(paramString);
    }

    public boolean bw(String paramString)
    {
      return mTypeName.equals(paramString);
    }

    public String toString()
    {
      return mTypeName;
    }
  }
}