package com.google.android.keep.util;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.util.Linkify;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.TreeEntity;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntitySettings;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class s
{
  private static final String TAG = s.class.getSimpleName();

  private static String a(Context paramContext, String paramString, ImageBlob paramImageBlob)
    throws IOException
  {
    paramContext = C.v(paramContext, paramString);
    if (paramContext == null);
    do
    {
      return null;
      paramString = (HttpURLConnection)new URL("https://keep.google.com/media/" + paramImageBlob.getMediaId() + "?sz=" + 600).openConnection();
      paramString.setRequestProperty("Authorization", "Bearer " + paramContext);
      paramString.setInstanceFollowRedirects(false);
    }
    while ((paramString.getResponseCode() != 302) && (paramString.getResponseCode() != 301) && (paramString.getResponseCode() != 303));
    return paramString.getHeaderField("location");
  }

  private static String a(Context paramContext, String paramString, ImageBlob paramImageBlob, int paramInt)
    throws IOException
  {
    paramContext = a(paramContext, paramString, paramImageBlob);
    if (paramContext == null)
      return null;
    return "<img src=\"" + paramContext + "\"; width=\"" + paramInt + "px\"; />";
  }

  public static String a(Context paramContext, String paramString, TreeEntity paramTreeEntity, List<ListItem> paramList, List<ImageBlob> paramList1)
  {
    boolean bool = false;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramList1.isEmpty())
      localStringBuilder.append(a(paramContext, paramString, paramList1));
    if (!TextUtils.isEmpty(paramTreeEntity.getTitle()))
      localStringBuilder.append("<b>").append(paramTreeEntity.getTitle()).append("</b><br><br>");
    if (!paramList.isEmpty())
    {
      if (paramTreeEntity.ir() != TreeEntity.TreeEntityType.zP)
        break label123;
      if (!paramTreeEntity.iA().ei())
        bool = true;
      localStringBuilder.append(c(paramList, bool));
    }
    while (true)
    {
      return localStringBuilder.toString();
      label123: paramContext = ((ListItem)paramList.get(0)).getText();
      if (!TextUtils.isEmpty(paramContext))
        localStringBuilder.append(bC(paramContext)).append("<br>");
    }
  }

  private static StringBuilder a(Context paramContext, String paramString, List<ImageBlob> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramList.size();
    int i = 600;
    if (k > 1)
      i = 600 / 2;
    int j = 0;
    while (true)
      if (j < k)
      {
        Object localObject = (ImageBlob)paramList.get(j);
        try
        {
          localObject = a(paramContext, paramString, (ImageBlob)localObject, Math.min(((ImageBlob)localObject).getWidth().intValue(), i));
          if (localObject != null)
            localStringBuilder.append((String)localObject);
          j += 1;
        }
        catch (IOException localIOException)
        {
          while (true)
            r.d(TAG, "Could not follow image URL: " + localIOException, new Object[0]);
        }
      }
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.insert(0, "<div width=\"600px\";>");
      localStringBuilder.append("</div><br>");
    }
    return localStringBuilder;
  }

  private static String bC(String paramString)
  {
    paramString = SpannableString.valueOf(paramString);
    Linkify.addLinks(paramString, 15);
    return Html.toHtml(paramString);
  }

  private static StringBuilder c(List<ListItem> paramList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("<ul>");
    StringBuilder localStringBuilder1 = null;
    if (paramBoolean)
      localStringBuilder1 = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      ListItem localListItem = (ListItem)paramList.get(i);
      String str = r(localListItem);
      if ((paramBoolean) && (localListItem.isChecked()))
        localStringBuilder1.append("<li>").append(str).append("</li>");
      while (true)
      {
        i += 1;
        break;
        localStringBuilder2.append("<li>").append(str).append("</li>");
      }
    }
    if (paramBoolean)
      localStringBuilder2.append(localStringBuilder1);
    localStringBuilder2.append("</ul>");
    return localStringBuilder2;
  }

  private static String r(ListItem paramListItem)
  {
    String str2 = bC(paramListItem.getText());
    String str1 = str2;
    if (paramListItem.isChecked())
      str1 = "<s>" + str2 + "</s>";
    return str1;
  }
}