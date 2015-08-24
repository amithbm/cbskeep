package com.google.android.keep.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.c;
import com.google.android.keep.d;
import com.google.android.keep.model.TreeEntity;
import com.google.android.keep.util.C;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.F;
import com.google.android.keep.util.KeepJsonHttpClient;
import com.google.android.keep.util.KeepJsonHttpClient.RequestMethod;
import com.google.android.keep.util.KeepJsonHttpClient.a;
import com.google.android.keep.util.l;
import com.google.android.keep.util.q;
import com.google.android.keep.util.r;
import com.google.android.keep.util.s;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class DocsExportService extends IntentService
{
  private static final String Ei = (String)Config.Pp.get();
  private static final String Ej = Ei + "upload/drive/v2/files?uploadType=multipart&convert=true";
  private static final String TAG = DocsExportService.class.getSimpleName();

  public DocsExportService()
  {
    super(TAG);
  }

  private Intent a(String paramString, KeepJsonHttpClient.a parama)
  {
    Intent localIntent = new Intent("com.google.android.keep.intent.action.NOTE_TO_GOOGLE_DOC");
    localIntent.putExtra("authAccount", paramString);
    if ((parama != null) && (parama.om()) && (parama.PX != null));
    try
    {
      localIntent.putExtra("googleDocUrl", new JSONObject(new String(parama.PX)).getString("alternateLink"));
      return localIntent;
    }
    catch (JSONException paramString)
    {
      r.d(TAG, "Could not format JSON note-to-doc response: " + paramString, new Object[0]);
    }
    return localIntent;
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    long l = System.currentTimeMillis();
    paramString2 = b(paramString1, paramString2, paramString3);
    d.e(this).a(2131230867, System.currentTimeMillis() - l, 2131230893, 2131231029);
    paramString1 = a(paramString1, paramString2);
    LocalBroadcastManager.getInstance(this).sendBroadcast(paramString1);
  }

  private void a(String paramString, List<TreeEntity> paramList)
  {
    a(paramString, s(paramList).toString().replace("\\", ""), b(paramString, paramList));
  }

  private KeepJsonHttpClient.a b(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = C.v(this, paramString1);
    if (paramString1 == null)
      return null;
    KeepJsonHttpClient localKeepJsonHttpClient = new KeepJsonHttpClient();
    Uri.Builder localBuilder = Uri.parse(Ej).buildUpon();
    localBuilder.appendQueryParameter("key", Config.nL());
    localKeepJsonHttpClient.bB(localBuilder.toString());
    localKeepJsonHttpClient.bA(paramString1);
    localKeepJsonHttpClient.a(KeepJsonHttpClient.RequestMethod.PT);
    localKeepJsonHttpClient.c(new String[] { "Content-Type: application/json\r\n\r\n" + paramString2, "Content-Type: text/html\r\nContent-Transfer-Encoding: base64\r\n\r\n" + Base64.encodeToString(paramString3.getBytes(), 2) });
    localKeepJsonHttpClient.ok();
    return localKeepJsonHttpClient.oj();
  }

  private String b(String paramString, List<TreeEntity> paramList)
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      TreeEntity localTreeEntity = (TreeEntity)paramList.get(i);
      localStringBuilder.append(s.a(this, paramString, localTreeEntity, q.d(getContentResolver(), localTreeEntity.getId()), l.c(getContentResolver(), localTreeEntity.getId())));
      localStringBuilder.append("<br>");
      i += 1;
    }
    d.e(this).a(2131230867, System.currentTimeMillis() - l, 2131230894, 2131231029);
    return localStringBuilder.toString();
  }

  private JSONObject s(List<TreeEntity> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", t(paramList));
      localJSONObject.put("mimeType", "text/html");
      return localJSONObject;
    }
    catch (JSONException paramList)
    {
      r.d(TAG, "Could not format JSON meta data: " + paramList, new Object[0]);
    }
    return localJSONObject;
  }

  private String t(List<TreeEntity> paramList)
  {
    String str = ((TreeEntity)paramList.get(0)).getTitle();
    paramList = str;
    if (TextUtils.isEmpty(str))
      paramList = getResources().getString(2131231308);
    return paramList;
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null);
    String str;
    do
    {
      do
      {
        do
        {
          return;
          str = paramIntent.getStringExtra("authAccount");
        }
        while (TextUtils.isEmpty(str));
        paramIntent = paramIntent.getLongArrayExtra("treeEntityIds");
      }
      while ((paramIntent == null) || (paramIntent.length == 0));
      Long[] arrayOfLong = new Long[paramIntent.length];
      int i = 0;
      while (i < paramIntent.length)
      {
        arrayOfLong[i] = Long.valueOf(paramIntent[i]);
        i += 1;
      }
      paramIntent = F.a(this, arrayOfLong);
    }
    while (paramIntent.isEmpty());
    a(str, paramIntent);
  }
}