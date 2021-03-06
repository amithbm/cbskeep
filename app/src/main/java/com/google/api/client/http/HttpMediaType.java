package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HttpMediaType
{
  private static final Pattern FULL_MEDIA_TYPE_REGEX;
  private static final Pattern PARAMETER_REGEX = Pattern.compile("\\s*;\\s*(" + "[^\\s/=;\"]+" + ")" + "=(" + str + ")");
  private static final Pattern TOKEN_REGEX;
  private static final Pattern TYPE_REGEX = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
  private String cachedBuildResult;
  private final SortedMap<String, String> parameters = new TreeMap();
  private String subType = "octet-stream";
  private String type = "application";

  static
  {
    TOKEN_REGEX = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
    FULL_MEDIA_TYPE_REGEX = Pattern.compile("\\s*(" + "[^\\s/=;\"]+" + ")/(" + "[^\\s/=;\"]+" + ")" + "\\s*(" + ";.*" + ")?", 32);
    String str = "\"([^\"]*)\"" + "|" + "[^\\s;\"]*";
  }

  public HttpMediaType(String paramString)
  {
    fromString(paramString);
  }

  public static boolean equalsIgnoreParameters(String paramString1, String paramString2)
  {
    return ((paramString1 == null) && (paramString2 == null)) || ((paramString1 != null) && (paramString2 != null) && (new HttpMediaType(paramString1).equalsIgnoreParameters(new HttpMediaType(paramString2))));
  }

  private HttpMediaType fromString(String paramString)
  {
    paramString = FULL_MEDIA_TYPE_REGEX.matcher(paramString);
    Preconditions.checkArgument(paramString.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
    setType(paramString.group(1));
    setSubType(paramString.group(2));
    paramString = paramString.group(3);
    if (paramString != null)
    {
      Matcher localMatcher = PARAMETER_REGEX.matcher(paramString);
      while (localMatcher.find())
      {
        String str2 = localMatcher.group(1);
        String str1 = localMatcher.group(3);
        paramString = str1;
        if (str1 == null)
          paramString = localMatcher.group(2);
        setParameter(str2, paramString);
      }
    }
    return this;
  }

  static boolean matchesToken(String paramString)
  {
    return TOKEN_REGEX.matcher(paramString).matches();
  }

  private static String quoteString(String paramString)
  {
    paramString = paramString.replace("\\", "\\\\").replace("\"", "\\\"");
    return "\"" + paramString + "\"";
  }

  public String build()
  {
    if (cachedBuildResult != null)
      return cachedBuildResult;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(type);
    localStringBuilder.append('/');
    localStringBuilder.append(subType);
    if (parameters != null)
    {
      Iterator localIterator = parameters.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localStringBuilder.append("; ");
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("=");
        localObject = str;
        if (!matchesToken(str))
          localObject = quoteString(str);
        localStringBuilder.append((String)localObject);
      }
    }
    cachedBuildResult = localStringBuilder.toString();
    return cachedBuildResult;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof HttpMediaType));
    do
    {
      return false;
      paramObject = (HttpMediaType)paramObject;
    }
    while ((!equalsIgnoreParameters(paramObject)) || (!parameters.equals(paramObject.parameters)));
    return true;
  }

  public boolean equalsIgnoreParameters(HttpMediaType paramHttpMediaType)
  {
    return (paramHttpMediaType != null) && (getType().equalsIgnoreCase(paramHttpMediaType.getType())) && (getSubType().equalsIgnoreCase(paramHttpMediaType.getSubType()));
  }

  public Charset getCharsetParameter()
  {
    String str = getParameter("charset");
    if (str == null)
      return null;
    return Charset.forName(str);
  }

  public String getParameter(String paramString)
  {
    return (String)parameters.get(paramString.toLowerCase());
  }

  public String getSubType()
  {
    return subType;
  }

  public String getType()
  {
    return type;
  }

  public int hashCode()
  {
    return build().hashCode();
  }

  public HttpMediaType removeParameter(String paramString)
  {
    cachedBuildResult = null;
    parameters.remove(paramString.toLowerCase());
    return this;
  }

  public HttpMediaType setCharsetParameter(Charset paramCharset)
  {
    if (paramCharset == null);
    for (paramCharset = null; ; paramCharset = paramCharset.name())
    {
      setParameter("charset", paramCharset);
      return this;
    }
  }

  public HttpMediaType setParameter(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      removeParameter(paramString1);
      return this;
    }
    Preconditions.checkArgument(TOKEN_REGEX.matcher(paramString1).matches(), "Name contains reserved characters");
    cachedBuildResult = null;
    parameters.put(paramString1.toLowerCase(), paramString2);
    return this;
  }

  public HttpMediaType setSubType(String paramString)
  {
    Preconditions.checkArgument(TYPE_REGEX.matcher(paramString).matches(), "Subtype contains reserved characters");
    subType = paramString;
    cachedBuildResult = null;
    return this;
  }

  public HttpMediaType setType(String paramString)
  {
    Preconditions.checkArgument(TYPE_REGEX.matcher(paramString).matches(), "Type contains reserved characters");
    type = paramString;
    cachedBuildResult = null;
    return this;
  }

  public String toString()
  {
    return build();
  }
}